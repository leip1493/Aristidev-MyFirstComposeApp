package com.leip1493.myfirstcomposeapp.instagramlogin

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnabled = MutableLiveData<Boolean>()
    val isLoginEnabled: LiveData<Boolean> = _isLoginEnabled

    fun onLoginChanged(email: String) {
        _email.value = email
        _isLoginEnabled.value = enableLogin(email, _password.value.orEmpty())
    }

    fun onPasswordChanged(password: String) {
        _password.value = password
        _isLoginEnabled.value = enableLogin(_email.value.orEmpty(), password)
    }

    fun enableLogin(email: String, password: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 6
    }
}