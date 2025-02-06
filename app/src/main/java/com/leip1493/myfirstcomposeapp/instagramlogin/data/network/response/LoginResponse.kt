package com.leip1493.myfirstcomposeapp.instagramlogin.data.network.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("success") val success: Boolean,
)