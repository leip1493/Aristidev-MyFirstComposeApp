package com.leip1493.myfirstcomposeapp.instagramlogin.domain

import com.leip1493.myfirstcomposeapp.instagramlogin.data.network.LoginRepository
import javax.inject.Inject


class LoginUseCase @Inject constructor(
    private val repository: LoginRepository,
) {
    // De esta manera se puede invocar LoginUseCase(user,password)
    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogin(user, password)
    }
}