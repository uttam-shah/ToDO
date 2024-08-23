package com.example.todo.login_reg.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.todo.R
import com.example.todo.databinding.ActivitySignupBinding
import com.example.todo.login_reg.NavigationHandler
import com.example.todo.login_reg.view_models.SignupViewModel
import com.github.dhaval2404.imagepicker.ImagePicker

class SignupActivity : AppCompatActivity(), NavigationHandler {

    private lateinit var binding: ActivitySignupBinding
    private val signupViewModel: SignupViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        binding.viewModel = signupViewModel
        binding.lifecycleOwner = this

        // Pass the NavigationHandler to the ViewModel
        signupViewModel.setNavigationHandler(this)

        // Setting up the NavController
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_activity_signup) as NavHostFragment
        val navController = navHostFragment.navController

    }

     override fun navigateToFragment(fragmentId: Int) {
        // Use NavController to navigate to the desired fragment
        val navController = findNavController(R.id.nav_host_fragment_activity_signup)
        navController.navigate(fragmentId)
    }

}
