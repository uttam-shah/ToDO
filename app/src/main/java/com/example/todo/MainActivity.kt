package com.example.todo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.todo.login_reg.view.StartActivity
import com.example.todo.room_db.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Apply insets to handle edge-to-edge design
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Check user login status and navigate accordingly
        checkUserLoginStatus()
    }

    private fun checkUserLoginStatus() {
        GlobalScope.launch(Dispatchers.IO) {
            val userDao = AppDatabase.getDatabase(this@MainActivity).userDao()
            val user = userDao.getUser()

            launch(Dispatchers.Main) {
                if (user != null) {
                    if (user.isLogIn) {
                        // User is logged in, navigate to DashboardActivity
                        startActivity(Intent(this@MainActivity, DashboardActivity::class.java))
                    } else {
                        // User is not logged in, navigate to StartActivity
                        startActivity(Intent(this@MainActivity, StartActivity::class.java))
                    }
                } else {
                    // No user found, navigate to StartActivity
                    startActivity(Intent(this@MainActivity, StartActivity::class.java))
                }
                // Finish the SplashActivity so it won't be in the back stack
                finish()
            }
        }
    }
}
