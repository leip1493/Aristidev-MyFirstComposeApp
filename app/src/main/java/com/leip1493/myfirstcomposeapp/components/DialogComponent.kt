package com.leip1493.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun DialogComponent(
    show: Boolean,
    onDismiss: () -> Unit,
    onTaskAdded: (String) -> Unit,
) {
    if (!show) return

    var myTask by remember { mutableStateOf("") }

    Dialog(
        onDismissRequest = { onDismiss() },
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)
                .testTag("dialog")
        ) {
            Text(
                "Añade tu tarea",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.size(16.dp))
            TextField(
                value = myTask,
                onValueChange = { myTask = it },
                singleLine = true,
                maxLines = 1
            )
            Spacer(modifier = Modifier.size(16.dp))
            Button(onClick = {
                onTaskAdded(myTask)
                myTask = ""
            }, modifier = Modifier.fillMaxWidth()) {
                Text("Añadir tarea")
            }
        }
    }
}