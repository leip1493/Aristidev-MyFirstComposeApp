package com.leip1493.myfirstcomposeapp.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyScaffold(modifier: Modifier) {
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            MyDrawer() {
                coroutineScope.launch {
                    drawerState.close()
                }
            }
        },
        gesturesEnabled = false,
    ) {
        Scaffold(
            topBar = {
                MyTopAppBar(onClickIcon = {
                    coroutineScope.launch {
                        snackBarHostState.showSnackbar(
                            "Has pulsado $it"
                        )
                    }
                }, onClickDrawer = {
                    coroutineScope.launch {
                        drawerState.open()
                    }
                })
            },
            snackbarHost = { SnackbarHost(snackBarHostState) },
            bottomBar = { MyBottomNavigation() },
            floatingActionButton = { MyFloatingActionButton() },
            floatingActionButtonPosition = FabPosition.Center,
        ) {

        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit, onClickDrawer: () -> Unit) {
    TopAppBar(title = { Text("Mi primera toolbar") }, colors = TopAppBarDefaults.topAppBarColors(
        containerColor = Color.DarkGray,
        titleContentColor = Color.White,
    ), navigationIcon = {
//        IconButton(onClick = { onClickIcon("Atras") }) {
//            Icon(
//                imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
//                contentDescription = "Atras"
//            )
//        }
        IconButton(onClick = { onClickDrawer() }) {
            Icon(
                imageVector = Icons.Filled.Menu, contentDescription = "Menu", tint = Color.White
            )
        }
    }, actions = {
        IconButton(onClick = { onClickIcon("Buscar") }) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search",
                tint = Color.White
            )
        }
        IconButton(onClick = { onClickIcon("Cerrar") }) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Close",
                tint = Color.White
            )
        }
    })
}

@Composable
fun MyBottomNavigation() {
    var index by remember { mutableStateOf(0) }

    NavigationBar(containerColor = Color.DarkGray, contentColor = Color.White) {
        NavigationBarItem(
            selected = index == 0, onClick = { index = 0 }, icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }, label = { Text(text = "Home") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Gray, indicatorColor = Color.White,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                selectedTextColor = Color.White
            )
        )
        NavigationBarItem(
            selected = index == 1, onClick = { index = 1 }, icon = {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "FAV")
            }, label = { Text(text = "FAV") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Gray, indicatorColor = Color.White,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                selectedTextColor = Color.White
            )
        )
        NavigationBarItem(
            selected = index == 2, onClick = { index = 2 }, icon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Person")
            }, label = { Text(text = "Person") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Gray, indicatorColor = Color.White,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                selectedTextColor = Color.White
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

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val drawerOptions = listOf(
        DrawerOption("Primera opcion") { selectedItem = 0 },
        DrawerOption("Segunda opcion") { selectedItem = 1 },
        DrawerOption("Tercera opcion") { selectedItem = 2 },
    )
    ModalDrawerSheet {
        Spacer(Modifier.height(24.dp))
        drawerOptions.forEachIndexed { index, option ->
            NavigationDrawerItem(label = {
                Text(
                    text = option.name, modifier = Modifier
                )
            }, selected = selectedItem == index, onClick = {
                option.action()
            })
        }
        Spacer(Modifier.weight(1f))
        NavigationDrawerItem(label = {
            Text(
                text = "Cerrar Drawer", modifier = Modifier
            )
        }, selected = false, onClick = {
            onCloseDrawer()
        })
    }
}

data class DrawerOption(val name: String, val action: () -> Unit)