package com.example.todo.login_reg.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StartViewModel: ViewModel() {

    private val _navigateToLogin = MutableLiveData<Boolean>()
    val navigateToLogin: LiveData<Boolean> get() = _navigateToLogin

    private val _navigateToSignup = MutableLiveData<Boolean>()
    val navigateToSignup: LiveData<Boolean> get() = _navigateToSignup

    private val _navigateToDashboard = MutableLiveData<Boolean>()
    val navigateToDashboard: LiveData<Boolean> get() = _navigateToDashboard

    fun onLoginClicked() {
        _navigateToLogin.value = true
    }

    fun onSignupClicked() {
        _navigateToSignup.value = true
    }

    fun onContinueWithoutSignupClicked() {
        // Handle continue without signup click event
        _navigateToDashboard.value = true
    }

    fun onNavigatedToLogin() {
        _navigateToLogin.value = false
    }

    fun onNavigatedToSignup(){
        _navigateToSignup.value = false
    }

    fun onNavigateToDashboard(){
        _navigateToDashboard.value = false
    }
}