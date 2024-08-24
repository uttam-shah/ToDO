package com.example.todo.ui.notifications

import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todo.login_reg.view.StartActivity

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

    fun onLoginClick(context: Context){


        val intent = Intent(context, StartActivity::class.java)
        context.startActivity(intent)
    }

}