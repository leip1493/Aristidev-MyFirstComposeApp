package com.leip1493.myfirstcomposeapp.components

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.leip1493.myfirstcomposeapp.R

@Composable
fun MyDialogs(modifier: Modifier) {
    var showAlertDialog by remember { mutableStateOf(false) }
    var showSimpleDialog by remember { mutableStateOf(false) }
    var showCustomDialog by remember { mutableStateOf(false) }
    var showConfirmationDialog by remember { mutableStateOf(true) }

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
        Button(onClick = { showCustomDialog = true }) {
            Text("Mostrar custom dialogo")
        }
        Button(onClick = { showConfirmationDialog = true }) {
            Text("Mostrar confirmation dialogo")
        }


        MyAlertDialog(showAlertDialog, onConfirm = {
            Log.i("MyDialogs", "Confirmado")
        }, onDismiss = { showAlertDialog = false })

        MySimpleCustomDialog(showSimpleDialog, onDismiss = { showSimpleDialog = false })

        MyCustomDialog(showCustomDialog, onDismiss = { showCustomDialog = false })

        MyConfirmationDialog(showConfirmationDialog, onDismiss = { showConfirmationDialog = false })
    }
}

@Composable
fun MyAlertDialog(showDialog: Boolean, onConfirm: () -> Unit, onDismiss: () -> Unit) {
    if (!showDialog) return
    AlertDialog(onDismissRequest = {
        onDismiss()
    }, confirmButton = {
        TextButton(onClick = { onConfirm() }) {
            Text("Confirmar")
        }
    }, dismissButton = {
        TextButton(onClick = { onDismiss() }) {
            Text("Cancelar")
        }
    }, title = {
        Text("Titulo")
    }, text = {
        Text("Hola, soy el contenido")
    })
//    }
}

@Composable
fun MySimpleCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (!show) return

    Dialog(
        onDismissRequest = { onDismiss() }, properties = DialogProperties(
            dismissOnBackPress = true, dismissOnClickOutside = false
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

@Composable
fun MyCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (!show) return
    Dialog(onDismissRequest = { onDismiss() }) {
        Column(
            Modifier
                .background(Color.White)
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            MyTitleDialog(text = "Set backup account")
            MyCustomDialogAccountItem(
                email = "ejemplodecorreogmaillargo@gmail.com", drawable = R.drawable.avatar
            )
            MyCustomDialogAccountItem(
                email = "ejemplo2@gmail.com", drawable = R.drawable.avatar
            )
            MyCustomDialogAccountItem(
                email = "Añadir nueva cuenta", drawable = R.drawable.add
            )
        }
    }
}

@Composable
fun MyTitleDialog(
    text: String,
    modifier: Modifier = Modifier.padding(bottom = 12.dp),
) {
    Text(
        text,
        color = Color.Black,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun MyCustomDialogAccountItem(email: String, @DrawableRes drawable: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )

        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun MyConfirmationDialog(show: Boolean, onDismiss: () -> Unit) {
    if (!show) return
    var status by remember { mutableStateOf("") }

    Dialog(onDismissRequest = { onDismiss() }) {
        Column(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
        ) {
            MyTitleDialog(text = "Phone ringtone", modifier = Modifier.padding(24.dp))
            HorizontalDivider(Modifier.fillMaxWidth(), color = Color.LightGray)
            MyRadioButtonList(status) { status = it }
            HorizontalDivider(Modifier.fillMaxWidth(), color = Color.LightGray)
            Row(
                Modifier
                    .align(Alignment.End)
                    .padding(8.dp)
            ) {
                TextButton(onClick = {}) {
                    Text("CANCEL", color = Color.Black)
                }
                TextButton(onClick = {}) {
                    Text("OK", color = Color.Black)
                }
            }
        }
    }

}