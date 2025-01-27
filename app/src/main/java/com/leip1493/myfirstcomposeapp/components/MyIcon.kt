package com.leip1493.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyIcon(modifier: Modifier) {
    Column(modifier) {
        Icon(
            imageVector = Icons.Outlined.Star,
            contentDescription = "Icono",
            tint = Color.Cyan
        )
    }
}