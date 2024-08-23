package com.example.todo.login_reg.view_models


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.RoomDatabase
import com.example.todo.DashboardActivity
import com.example.todo.login_reg.view.SignupActivity
import com.example.todo.retrofit.ApiSet
import com.example.todo.retrofit.RetrofitController
import com.example.todo.retrofit.response.LoginResponse
import com.example.todo.room_db.BgThread
import com.example.todo.room_db.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel: ViewModel(){

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()


     fun onLoginClick(context: Context){
          val apiService: ApiSet = RetrofitController.getInstance().getApiService()
         apiService.loginUser(email.value.toString(), password.value.toString())
             .enqueue(object : Callback<LoginResponse>{
                 override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                     if (response.isSuccessful){
                         //Store data in room database
                         val user  = response.body()?.user
                         val bgThread = BgThread(context)
                         if (user != null) {
                             bgThread.performInsert(user)
                         }
                         Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
                         val intent = Intent(context, DashboardActivity::class.java)
                         context.startActivity(intent)
                         if (context is Activity) {
                             context.finish()
                         }

                     }
                     else{
                         Toast.makeText(context, "Login Failed: "+response.message(), Toast.LENGTH_SHORT).show()
                     }
                 }

                 override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                     Toast.makeText(context, "Failed: "+ t.message, Toast.LENGTH_SHORT).show()
                 }

             })
     }

    fun onGoogleLoginClick(context: Context){

    }

    fun onRegisterClick(context: Context){
        val intent = Intent(context, SignupActivity::class.java)
        context.startActivity(intent)
    }

}