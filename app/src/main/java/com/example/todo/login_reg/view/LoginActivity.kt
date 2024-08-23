package com.example.todo.login_reg.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.todo.R
import com.example.todo.databinding.ActivityLoginBinding
import com.example.todo.login_reg.view_models.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.viewModel = loginViewModel
        binding.lifecycleOwner = this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        loginViewModel.processLogin.observe(this){ shouldNavigate ->
//            if (shouldNavigate){
//                processLoginProecss()
//                loginViewModel.onProcessLogin()
//            }
//        }
    }

    private fun processLoginProecss() {
        Toast.makeText(this, "process login process", Toast.LENGTH_SHORT).show()
    }
}
