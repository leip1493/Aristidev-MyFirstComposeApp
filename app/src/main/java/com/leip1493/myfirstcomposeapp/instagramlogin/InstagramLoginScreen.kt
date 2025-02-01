package com.leip1493.myfirstcomposeapp.instagramlogin

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leip1493.myfirstcomposeapp.R

@Composable
fun InstagramLoginScreen(modifier: Modifier) {
    Box(
        modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
    }
}

@SuppressLint("ContextCastToActivity")
@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(imageVector = Icons.Default.Close,
        contentDescription = "Close app",
        tint = Color.Black,
        modifier = modifier.clickable { activity.finish() })
}

@Composable
fun Body(modifier: Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        ImageLogo()
        Spacer(Modifier.size(16.dp))
        Email(email) { email = it }
        Spacer(Modifier.size(4.dp))
        Password(password) { password = it }
        Spacer(Modifier.size(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4ea8e9),
        modifier = modifier
    )
}

@Composable
fun Email(email: String, onChange: (String) -> Unit) {
    TextField(email, onValueChange = { onChange(it) })
}

@Composable
fun Password(password: String, onChange: (String) -> Unit) {
    TextField(password, onValueChange = { onChange(it) })
}

@Composable
fun ImageLogo() {
    Image(painter = painterResource(id = R.drawable.insta), contentDescription = "Logo")
}

//@Preview(showBackground = true, showSystemUi = true, device = "id:pixel_6")
//@Composable
//fun InstagramLoginScreenPreview() {
//    InstagramLoginScreen(Modifier.padding(top = 24.dp))
//}