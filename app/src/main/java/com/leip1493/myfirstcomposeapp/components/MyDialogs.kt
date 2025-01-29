package com.leip1493.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyDialogs(modifier: Modifier) {
    var showAlertDialog by remember { mutableStateOf(false) }
    var showSimpleDialog by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { showAlertDialog = true }) {
            Text("Mostrar alert dialogo")
        }
        Button(onClick = { showSimpleDialog = true }) {
            Text("Mostrar basic custom dialogo")
        }

        MyAlertDialog(
            showAlertDialog,
            onConfirm = {
                Log.i("MyDialogs", "Confirmado")
            },
            onDismiss = { showAlertDialog = false })

        MySimpleCustomDialog(
            showSimpleDialog,
            onDismiss = { showSimpleDialog = false })
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

@Composable
fun MySimpleCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (!show) return

    Dialog(
        onDismissRequest = { onDismiss() }, properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Text("Esto es un texto")
        }

    }

}