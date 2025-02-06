package com.leip1493.myfirstcomposeapp.instagramlogin.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leip1493.myfirstcomposeapp.instagramlogin.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
) : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnabled = MutableLiveData<Boolean>()
    val isLoginEnabled: LiveData<Boolean> = _isLoginEnabled

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _lorem = MutableStateFlow<String>("")
    val lorem: StateFlow<String> = _lorem

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

    fun onLoginSelected() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = loginUseCase(email.value!!, password.value!!)
            if (result) {
                // Navegar a la siguiente pantalla
                Log.i("LoginViewModel", "loginUseCase Success")
            }
            _isLoading.value = false
        }
    }
}