package com.leip1493.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.leip1493.myfirstcomposeapp.components.MyBadgeBox
import com.leip1493.myfirstcomposeapp.components.MyButtons
import com.leip1493.myfirstcomposeapp.components.MyCard
import com.leip1493.myfirstcomposeapp.components.MyCheckbox
import com.leip1493.myfirstcomposeapp.components.MyDivider
import com.leip1493.myfirstcomposeapp.components.MyDropdownMenu
import com.leip1493.myfirstcomposeapp.components.MyIcon
import com.leip1493.myfirstcomposeapp.components.MyImage
import com.leip1493.myfirstcomposeapp.components.MyImageAdvanced
import com.leip1493.myfirstcomposeapp.components.MyProgressAdvanced
import com.leip1493.myfirstcomposeapp.components.MyProgressBar
import com.leip1493.myfirstcomposeapp.components.MySwitch
import com.leip1493.myfirstcomposeapp.components.MyTextField
import com.leip1493.myfirstcomposeapp.components.MyTextFieldParent
import com.leip1493.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyDropdownMenu(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstComposeAppTheme {
        Greeting("Android")
    }
}