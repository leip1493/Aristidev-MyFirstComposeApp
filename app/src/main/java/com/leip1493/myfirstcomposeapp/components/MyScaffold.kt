package com.leip1493.myfirstcomposeapp.components

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyScaffold(modifier: Modifier) {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = { MyTopAppBar() { coroutineScope.launch { snackbarHostState.showSnackbar("Has pulsado $it") } } },
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit) {
    TopAppBar(title = { Text("Mi primera toolbar") }, colors = TopAppBarDefaults.topAppBarColors(
        containerColor = Color.DarkGray,
    ), navigationIcon = {
        IconButton(onClick = { onClickIcon("Atras") }) {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                contentDescription = "Atras"
            )
        }
    }, actions = {
        IconButton(onClick = { onClickIcon("Buscar") }) {
            Icon(
                imageVector = Icons.Filled.Search, contentDescription = "Search"
            )
        }
        IconButton(onClick = { onClickIcon("Cerrar") }) {
            Icon(
                imageVector = Icons.Filled.Close, contentDescription = "Close"
            )
        }
    })
}