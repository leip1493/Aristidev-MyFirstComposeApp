package com.leip1493.myfirstcomposeapp.instagramlogin.data.network

import com.leip1493.myfirstcomposeapp.instagramlogin.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginClient {
    @GET("v3/0d02c128-ba4c-4905-85d4-5bf5b61f2c7a")
    suspend fun doLogin(
        @Query("user") user: String,
        @Query("user") password: String,
    ): Response<LoginResponse>
}