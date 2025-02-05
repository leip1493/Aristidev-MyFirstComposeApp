package com.leip1493.myfirstcomposeapp.components

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyScaffold(modifier: Modifier) {
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = { MyTopAppBar() { coroutineScope.launch { snackBarHostState.showSnackbar("Has pulsado $it") } } },
        snackbarHost = { SnackbarHost(snackBarHostState) },
        bottomBar = { MyBottomNavigation() },
        floatingActionButton = { MyFloatingActionButton() },
        floatingActionButtonPosition = FabPosition.Center,
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

@Composable
fun MyBottomNavigation() {
    var index by remember { mutableStateOf(0) }

    NavigationBar(containerColor = Color.DarkGray, contentColor = Color.White) {
        NavigationBarItem(selected = index == 0, onClick = { /*TODO*/ }, icon = {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
        }, label = { Text(text = "Home") }, colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Gray, indicatorColor = Color.White
        )
        )
        NavigationBarItem(selected = index == 1, onClick = { /*TODO*/ }, icon = {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "FAV")
        }, label = { Text(text = "FAV") }, colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Gray, indicatorColor = Color.White
        )
        )
        NavigationBarItem(selected = index == 2, onClick = { /*TODO*/ }, icon = {
            Icon(imageVector = Icons.Default.Person, contentDescription = "Person")
        }, label = { Text(text = "Person") }, colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Color.Gray, indicatorColor = Color.White
        )
        )
    }
}

@Composable
fun MyFloatingActionButton() {
//    Box {
    FloatingActionButton(
        onClick = {},
        containerColor = Color.White,
        contentColor = Color.DarkGray,
//            modifier = Modifier.offset(y = 45.dp)
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
    }
//    }
}