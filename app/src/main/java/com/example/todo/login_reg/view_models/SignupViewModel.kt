package com.example.todo.login_reg.view_models


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo.DashboardActivity
import com.example.todo.R
import com.example.todo.login_reg.NavigationHandler
import com.example.todo.login_reg.models.User
import com.example.todo.login_reg.models.UserInfo
import com.example.todo.login_reg.view.SignupActivity
import com.example.todo.retrofit.ApiSet
import com.example.todo.retrofit.RetrofitController
import com.example.todo.retrofit.response.RegisterResponse
import com.example.todo.room_db.BgThread
import com.example.todo.room_db.UserRoom
import com.google.firebase.storage.FirebaseStorage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupViewModel : ViewModel() {

    val userInfo = MutableLiveData<UserInfo>().apply {
        value = UserInfo() // Initialize with an instance of UserInfo
    }

    val password = MutableLiveData<String>()
    val confPassword = MutableLiveData<String>()
    val phone = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val imageUri = MutableLiveData<Uri?>()
//    private var imagePickerLauncher: ActivityResultLauncher<Intent>? = null

    private val apiService: ApiSet = RetrofitController.getInstance().getApiService()

    private var navigationHandler: NavigationHandler? = null

    fun setNavigationHandler(handler: SignupActivity) {
        this.navigationHandler = handler
    }


    private fun uploadImageToFirebase(context: Context) {
        val uri = imageUri.value ?: return
        val storageRef = FirebaseStorage.getInstance().reference.child("user_images/${uri.lastPathSegment}")
        storageRef.putFile(uri)
            .addOnSuccessListener {
                storageRef.downloadUrl.addOnSuccessListener { downloadUri ->
                    downloadUri?.let {
                        userInfo.value?.profileUrl = it.toString()
                        Toast.makeText(context, "Image uploaded successfully", Toast.LENGTH_SHORT).show()

                        // Proceed with the registration process
                        signupProcess(context)
                    } ?: run {
                        Toast.makeText(context, "Failed to retrieve download URL", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            .addOnFailureListener {
                Toast.makeText(context, "Image upload failed", Toast.LENGTH_SHORT).show()
            }
    }

    fun onSignupClick(context: Context) {

        // Ensure the phone number starts with +91
        val phoneValue = phone.value ?: ""
        if (!phoneValue.startsWith("+91")) {
            phone.value = "+91$phoneValue"
        }

        // Validate email format
        val emailValue = email.value ?: ""
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailValue).matches()) {
            Toast.makeText(context, "Invalid email format", Toast.LENGTH_SHORT).show()
            return
        }

        uploadImageToFirebase(context)

        // Proceed with the registration process
       //signupProcess(context)
    }

    private fun signupProcess(context: Context) {
        if (password.value != confPassword.value) {
            Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
            return
        }

        // Retrieve the userInfo object
        userInfo.value?.let {
            val name = it.fullName
            val email = email.value ?: ""
            val phone = phone.value ?: ""
            val password = password.value ?: ""
            val profileImage = it.profileUrl ?: ""

            apiService.registerUser(name, email, phone, password, profileImage)
                .enqueue(object : Callback<RegisterResponse> {
                    override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                        if (response.isSuccessful) {
                            Toast.makeText(context, response.body()?.message ?: "Registration successful", Toast.LENGTH_SHORT).show()

                            // In your response handling code:
                            val user = response.body()?.user
                            if (user != null) {
                                Toast.makeText(context, user.name + user.userId, Toast.LENGTH_SHORT).show()
                            }
                            val bgThread = BgThread(context)
                            if (user != null) {
                                // Convert User to UserRoom and insert it into the database
                                val userRoom = convertToUserRoom(user)
                                bgThread.performInsert(userRoom)
                            }

                            //navigating to Dashboard
                            val intent = Intent(context, DashboardActivity::class.java)
                            context.startActivity(intent)
                            if (context is Activity) {
                                context.finish()
                            }

                        } else {
                            Toast.makeText(context, "Registration failed. Please try again.", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                        Toast.makeText(context, "Network error: ${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })
        } ?: run {
            Toast.makeText(context, "User information is missing", Toast.LENGTH_SHORT).show()
        }
    }

    fun onNextClick(view: View) {
        val user = userInfo.value
        val context = view.context

        when {
            user?.fullName.isNullOrEmpty() || user?.gender.isNullOrEmpty() || password.value.isNullOrEmpty() || confPassword.value.isNullOrEmpty() -> {
                Toast.makeText(context, "Please Fill add the details", Toast.LENGTH_SHORT).show()
            }

            !(password.value == confPassword.value) -> {
                Toast.makeText(context, "Password Did not Match", Toast.LENGTH_SHORT).show()
            }

            else -> {
                // Navigate to the next fragment
                navigationHandler?.navigateToFragment(R.id.navigation_signup2) // Replace with your actual fragment ID

            }
        }
    }


    fun setImageUri(uri: Uri?) {
        imageUri.value = uri
    }

    // Convert User (API response) to UserRoom (Room database entity)
    fun convertToUserRoom(user: User): UserRoom {
        return UserRoom(
            userId = user.userId,
            name = user.name,
            email = user.email,
            phone = user.phone,
            profileImage = user.profileImage,
            createdAt = user.createdAt,
            isLogIn = true  // Set isLogIn to true when storing in Room database
        )
    }



}
