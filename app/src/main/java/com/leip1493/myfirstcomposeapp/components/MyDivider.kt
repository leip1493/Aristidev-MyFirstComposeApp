package com.leip1493.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyDivider(modifier: Modifier) {
    Column(modifier) {
        HorizontalDivider(modifier.fillMaxWidth(), color = Color.Red)
    }
}