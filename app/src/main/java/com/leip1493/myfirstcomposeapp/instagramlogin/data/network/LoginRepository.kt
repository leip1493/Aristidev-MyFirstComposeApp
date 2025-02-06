package com.leip1493.myfirstcomposeapp.instagramlogin.data.network

import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val api: LoginService,
) {
    suspend fun doLogin(user: String, password: String): Boolean {
        return api.doLogin(user, password)
    }
}