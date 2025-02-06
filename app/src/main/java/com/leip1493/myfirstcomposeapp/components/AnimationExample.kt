package com.leip1493.myfirstcomposeapp.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ColorAnimationSimple(modifier: Modifier) {
    var firstColor by rememberSaveable {
        mutableStateOf(false)
    }
    val realColor = if (firstColor) Color.Red else Color.Yellow


    var showBox by rememberSaveable {
        mutableStateOf(true)
    }

    var secondColor by rememberSaveable {
        mutableStateOf(false)
    }
    val realColor2 by animateColorAsState(if (secondColor) Color.Red else Color.Yellow,
        label = "Box animation",
        animationSpec = tween(2000),
        finishedListener = {
            showBox = false
        })

    Column(modifier = modifier) {
        if (showBox) {
            Box(modifier = Modifier
                .size(100.dp)
                .background(realColor)
                .clickable { firstColor = !firstColor })
        }
        Spacer(Modifier.size(200.dp))
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor2)
            .clickable { secondColor = !secondColor })
        Spacer(Modifier.size(200.dp))
    }
}