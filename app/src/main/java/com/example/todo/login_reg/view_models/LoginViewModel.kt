package com.example.todo.login_reg.view_models


import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo.login_reg.view.SignupActivity


class LoginViewModel: ViewModel(){

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _processLogin = MutableLiveData<Boolean>()
    val processLogin: LiveData<Boolean> get() = _processLogin

     fun onLoginClick(context: Context){
         _processLogin.value = true
     }

    fun onGoogleLoginClick(context: Context){

    }

    fun onRegisterClick(context: Context){
        val intent = Intent(context, SignupActivity::class.java)
        context.startActivity(intent)
    }

    fun onProcessLogin() {
        _processLogin.value = false
    }
}