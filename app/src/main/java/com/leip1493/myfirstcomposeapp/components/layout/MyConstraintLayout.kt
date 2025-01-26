package com.leip1493.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MyBasicConstraintLayout(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (boxRed, boxCyan, boxGreen, boxBlue, boxGray) = createRefs()

        Box(
            Modifier
                .size(150.dp)
                .background(Color.Red)
                .constrainAs(boxRed){
                    top.linkTo(boxGray.bottom)
                    start.linkTo(boxGray.end)
                }
        )
        Box(
            Modifier
                .size(150.dp)
                .background(Color.Cyan)
                .constrainAs(boxCyan){
                    top.linkTo(boxGray.bottom)
                    end.linkTo(boxGray.start)
                }
        )
        Box(
            Modifier
                .size(150.dp)
                .background(Color.Green)
                .constrainAs(boxGreen){
                    bottom.linkTo(boxGray.top)
                    start.linkTo(boxGray.end)
                }
        )
        Box(
            Modifier
                .size(150.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue){
                    bottom.linkTo(boxGray.top)
                    end.linkTo(boxGray.start)
                }
        )
        Box(
            Modifier
                .size(150.dp)
                .background(Color.Gray)
                .constrainAs(boxGray){
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )
    }
}