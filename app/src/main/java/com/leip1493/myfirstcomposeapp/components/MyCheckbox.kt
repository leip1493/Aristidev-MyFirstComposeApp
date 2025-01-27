package com.leip1493.myfirstcomposeapp.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyCheckbox(modifier: Modifier) {
    var state by rememberSaveable { mutableStateOf(true) }

    Column(modifier) {
        Checkbox(
            checked = state,
            onCheckedChange = { state = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Cyan,
                uncheckedColor = Color.Green,
                checkmarkColor = Color.Gray
            )
        )

        // Checkbox con texto
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = !state,
                onCheckedChange = { state = !it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Cyan,
                    uncheckedColor = Color.Green,
                    checkmarkColor = Color.Gray
                )
            )
            Spacer(Modifier.width(8.dp))
            Text("Ejemplo 1")

        }
    }
}

