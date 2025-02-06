package com.leip1493.myfirstcomposeapp.instagramlogin

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leip1493.myfirstcomposeapp.R

@Composable
fun InstagramLoginScreen(
    modifier: Modifier,
    loginViewModel: LoginViewModel = LoginViewModel(),
) {
    Box(
        modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center), loginViewModel)
        Footer(Modifier.align(Alignment.BottomCenter))
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
fun Body(modifier: Modifier, loginViewModel: LoginViewModel) {
    val email: String by loginViewModel.email.observeAsState("")
    val password: String by loginViewModel.password.observeAsState("")
    val isLoginEnabled: Boolean by loginViewModel.isLoginEnabled.observeAsState(false)

    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(Modifier.size(16.dp))
        Email(email) {
            loginViewModel.onLoginChanged(it)
        }
        Spacer(Modifier.size(4.dp))
        Password(password) {
            loginViewModel.onPasswordChanged(it)
        }
        Spacer(Modifier.size(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(Modifier.size(16.dp))
        LoginButton(isLoginEnabled)
        Spacer(Modifier.size(16.dp))
        LoginDivider()
        Spacer(Modifier.size(32.dp))
        SocialLogin()
    }
}

@Composable
fun SocialLogin() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fb),
            contentDescription = "Facebook login",
            modifier = Modifier.size(16.dp)
        )
        Text(
            "Continue as Luis",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp),
            color = Color(0xFF4EA8E9)
        )
    }
}

@Composable
fun LoginDivider() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        HorizontalDivider(
            color = Color(0xfff9f9f9), modifier = Modifier
                .height(1.dp)
                .weight(1f)
        )
        Text(
            "OR",
            modifier = Modifier.padding(horizontal = 18.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF726E6E)
        )
        HorizontalDivider(
            color = Color(0xfff9f9f9), modifier = Modifier
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun LoginButton(isLoginEnabled: Boolean) {
    Button(
        onClick = {},
        enabled = isLoginEnabled,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4EA8E9),
            disabledContainerColor = Color(0xFF78C8F9),
            contentColor = Color.White,
            disabledContentColor = Color.White
        ),
        shape = RoundedCornerShape(4.dp),
    ) {
        Text("Login")
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
    TextField(
        email,
        onValueChange = { onChange(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("Email") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = Color(0xFFb2b2b2),
            focusedTextColor = Color(0xFFb2b2b2),
            unfocusedContainerColor = Color(0xFFfafafa),
            focusedContainerColor = Color(0xFFfafafa),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )
    )
}

@Composable
fun Password(password: String, onChange: (String) -> Unit) {
    var passwordVisibility by remember { mutableStateOf(false) }

    TextField(
        password,
        onValueChange = { onChange(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("Password") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.colors(
            unfocusedTextColor = Color(0xFFb2b2b2),
            focusedTextColor = Color(0xFFb2b2b2),
            unfocusedContainerColor = Color(0xFFfafafa),
            focusedContainerColor = Color(0xFFfafafa),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        trailingIcon = {
            val image = if (passwordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = image, contentDescription = "show password")
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.insta),
        contentDescription = "Logo",
        modifier = modifier
    )
}

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier.fillMaxWidth()) {
        HorizontalDivider(
            Modifier
                .background(Color(0xFFf9f9f9))
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(Modifier.size(24.dp))
        SignUp()
        Spacer(Modifier.size(24.dp))
    }
}

@Composable
fun SignUp() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text("Don´t have an account?", fontSize = 12.sp, color = Color(0xFF726E6E))
        Text(
            "Sign up.",
            modifier = Modifier.padding(horizontal = 8.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9)
        )
    }
}
