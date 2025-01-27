package com.leip1493.myfirstcomposeapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.leip1493.myfirstcomposeapp.R

@Composable
fun MyImage(modifier: Modifier) {
    Column(modifier = modifier) {
        Image(
            modifier = Modifier
                .border(5.dp, Color.Cyan)
                .height(200.dp)
                .fillMaxSize(),
            alignment = Alignment.Center,
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Ejemplo de imagen"
        )
    }
}

@Composable
fun MyImageAdvanced(modifier: Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Ejemplo de imagen",
            modifier = Modifier
                .clip(CircleShape)
                .border(5.dp, Color.Red, CircleShape)
                .background(Color.Cyan)
        )
    }
}