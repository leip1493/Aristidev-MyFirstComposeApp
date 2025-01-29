package com.leip1493.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MyDialogs(modifier: Modifier) {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { showDialog = true }) {
            Text("Mostrar dialogo")
        }

        MyAlertDialog(
            showDialog,
            onConfirm = {
                Log.i("MyDialogs", "Confirmado")
            },
            onDismiss = { showDialog = false })
    }
}

@Composable
fun MyAlertDialog(showDialog: Boolean, onConfirm: () -> Unit, onDismiss: () -> Unit) {
    if (!showDialog) return
    AlertDialog(
        onDismissRequest = {
            onDismiss()
        },
        confirmButton = {
            TextButton(onClick = { onConfirm() }) {
                Text("Confirmar")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text("Cancelar")
            }
        },
        title = {
            Text("Titulo")
        },
        text = {
            Text("Hola, soy el contenido")
        }
    )
//    }
}