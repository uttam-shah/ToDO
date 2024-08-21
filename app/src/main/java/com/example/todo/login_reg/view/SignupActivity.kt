package com.example.todo.login_reg.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

import com.example.todo.R
import com.example.todo.databinding.ActivitySignupBinding
import com.example.todo.login_reg.view_models.SignupViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private val signupViewModel: SignupViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        binding.viewModel = signupViewModel
        binding.lifecycleOwner = this

        // Setting up the NavController and AppBarConfiguration
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_activity_signup) as NavHostFragment

        val navController = navHostFragment.navController
       // val appBarConfiguration = AppBarConfiguration(navController.graph)

        //setupActionBarWithNavController(navController, appBarConfiguration)

        // If you have a BottomNavigationView
//        val bottomNavView: BottomNavigationView = binding.bottomNavView
//        bottomNavView.setupWithNavController(navController)

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }

    // Optional: To handle back navigation
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_signup)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
