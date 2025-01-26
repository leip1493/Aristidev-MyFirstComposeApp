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
import com.leip1493.myfirstcomposeapp.components.layout.ConstraintBarrier
import com.leip1493.myfirstcomposeapp.components.layout.ConstraintChain
import com.leip1493.myfirstcomposeapp.components.layout.ConstraintExampleGuide
import com.leip1493.myfirstcomposeapp.components.layout.ExerciseOne
import com.leip1493.myfirstcomposeapp.components.layout.ExerciseTwo
import com.leip1493.myfirstcomposeapp.components.layout.MyBasicConstraintLayout
import com.leip1493.myfirstcomposeapp.components.layout.MyBox
import com.leip1493.myfirstcomposeapp.components.layout.MyColumn
import com.leip1493.myfirstcomposeapp.components.layout.MyComplexLayout
import com.leip1493.myfirstcomposeapp.components.layout.MyRow
import com.leip1493.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ConstraintChain(modifier = Modifier.padding(innerPadding))
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