package com.leip1493.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MySlider(modifier: Modifier) {
    Column(modifier) {
        BasicSlider()
        AdvancedSlider()
        MyRangeSlider()
    }
}

@Composable
fun BasicSlider() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column(Modifier.padding(32.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text(sliderPosition.toString())
    }
}

@Composable
fun AdvancedSlider() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column(Modifier.padding(32.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = {},
            valueRange = 0f..10f,
            steps = 9
        )
        Text(sliderPosition.toString())
    }
}

@Composable
fun MyRangeSlider() {
    var currentRange by remember { mutableStateOf(0f..10f) }

    Column(Modifier.padding(32.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        RangeSlider(
            value = currentRange, onValueChange = { currentRange = it }, valueRange = 0f..40f,
            steps = 9
        )
        Row {
            Text(currentRange.start.toString())
            Text(" - ")
            Text(currentRange.endInclusive.toString())
        }

    }
}