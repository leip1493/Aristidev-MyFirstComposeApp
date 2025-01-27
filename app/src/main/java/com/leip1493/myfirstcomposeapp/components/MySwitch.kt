package com.leip1493.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Composable
fun MySwitch(modifier: Modifier) {
    var state by rememberSaveable { mutableStateOf(true) }

    Column(modifier) {
        Switch(

            thumbContent = {
                SwitchDefaults.IconSize
                Text(if (state) "O" else "I", fontWeight = FontWeight.ExtraBold)
            },
            checked = state,
            onCheckedChange = { state = it },
            colors = SwitchDefaults.colors(
                checkedTrackColor = Color.Green,
                checkedThumbColor = Color.Red,
                uncheckedTrackColor = Color.Red,
                uncheckedThumbColor = Color.Green,
            )
        )
    }
}