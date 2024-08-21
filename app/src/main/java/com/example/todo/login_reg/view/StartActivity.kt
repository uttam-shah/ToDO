package com.example.todo.login_reg.view


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.todo.DashboardActivity
import com.example.todo.R
import com.example.todo.databinding.ActivityStartBinding
import com.example.todo.login_reg.view_models.StartViewModel

class StartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStartBinding
    private val startViewModel: StartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_start)
        binding.viewModel = startViewModel
        binding.lifecycleOwner = this

        startViewModel.navigateToLogin.observe(this) { shouldNavigate ->
            if (shouldNavigate) {
                navigateToLoginScreen()
                startViewModel.onNavigatedToLogin()
            }
        }

        startViewModel.navigateToSignup.observe(this){ shouldNavigate ->
            if (shouldNavigate){
                navigateToSignupScreen()
                startViewModel.onNavigatedToSignup()
            }
        }

        startViewModel.navigateToDashboard.observe(this){ shouldNavigate ->
            if (shouldNavigate){
                navigateToDashboardScreen()
                startViewModel.onNavigatedToSignup()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navigateToLoginScreen() {
        val intent = Intent(this, LoginActivity::class.java) // Replace LoginActivity with your actual login activity class
        startActivity(intent)
    }

    private fun navigateToSignupScreen(){
        val intent = Intent(this, SignupActivity::class.java) // Replace LoginActivity with your actual login activity class
        startActivity(intent)
    }

    private fun navigateToDashboardScreen(){
        Toast.makeText(this, "Navigate to Dashboard", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
    }
}
