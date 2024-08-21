package com.example.todo.login_reg.view_models

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.todo.R
import com.example.todo.login_reg.models.UserInfo
import com.example.todo.retrofit.ApiSet
import com.example.todo.retrofit.RetrofitController
import com.example.todo.retrofit.response.RegisterResponse
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

    private val apiService: ApiSet = RetrofitController.getInstance().getApiService()

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

        // Proceed with the registration process
        signupProcess(context)
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

            apiService.registerUser(name, email, phone, password, profileImage.toString())
                .enqueue(object : Callback<RegisterResponse> {
                    override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                        if (response.isSuccessful) {
                            Toast.makeText(context, response.body()?.message ?: "Registration successful", Toast.LENGTH_SHORT).show()
                            // Navigate to the next screen if needed
//                            val navController = Navigation.findNavController(context as View)
//                            navController.navigate(R.id.navigation_signup2) // Replace with the correct action ID
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
        // Check if password and confirm password match
        if (password.value != confPassword.value) {
            Toast.makeText(view.context, "Passwords do not match", Toast.LENGTH_SHORT).show()
            return
        }

        // Retrieve the userInfo object and display the fullName
        userInfo.value?.let {
            Toast.makeText(view.context, it.fullName, Toast.LENGTH_SHORT).show()
        } ?: run {
            Toast.makeText(view.context, "User information is missing", Toast.LENGTH_SHORT).show()
        }

        // Navigate to the next fragment
        val navController = Navigation.findNavController(view)
        navController.navigate(R.id.navigation_signup2) // Replace with the correct action ID
    }
}
