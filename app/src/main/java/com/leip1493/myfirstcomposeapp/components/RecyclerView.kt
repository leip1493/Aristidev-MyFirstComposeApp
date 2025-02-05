package com.leip1493.myfirstcomposeapp.components

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leip1493.myfirstcomposeapp.R
import kotlinx.coroutines.launch

data class Superhero(
    val name: String,
    val realName: String,
    val publisher: String,
    @DrawableRes val photo: Int,
)

@Composable
fun SuperHeroGridView(modifier: Modifier) {
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp), // Margen exterior al listado
        verticalArrangement = Arrangement.spacedBy(16.dp), // Espaciado vertical entre elementos
        horizontalArrangement = Arrangement.spacedBy(16.dp), // Espaciado horizontal entre elementos
        modifier = modifier.fillMaxWidth(),
        content = {
            items(getSuperHeroes()) { superhero ->
                ItemHero(superhero) {
                    Toast.makeText(context, it.realName, Toast.LENGTH_SHORT).show()
                }
            }
        })
}

@Composable
fun SuperHeroWithSpecialControlsView(modifier: Modifier) {
    val rvState = rememberLazyListState()
    val context = LocalContext.current
    val coroutinesScope = rememberCoroutineScope()

    Column(Modifier.fillMaxWidth()) {
        LazyColumn(
            state = rvState,
            modifier = modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(getSuperHeroes()) { superhero ->
                ItemHero(superhero) {
                    Toast.makeText(context, it.realName, Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Esto se hace para que por cada movimiento no re-evalue la expresion y gaste cpu
        val showButton by remember { derivedStateOf { rvState.firstVisibleItemIndex > 0 } }

        if (showButton) {
            Button(
                onClick = {
                    coroutinesScope.launch {
                        rvState.animateScrollToItem(0)
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(text = "Soy un boton")
            }
        }

    }
}

@Composable
fun SuperHeroView(modifier: Modifier) {
    val context = LocalContext.current
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(getSuperHeroes()) { superhero ->
            ItemHero(superhero) {
                Toast.makeText(context, it.realName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun ItemHero(superhero: Superhero, onItemSelected: (Superhero) -> Unit) {
    Card(border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(superhero) }) {
        Column {
            Image(
                painter = painterResource(id = superhero.photo),
                contentDescription = superhero.name,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superhero.name, modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superhero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superhero.publisher,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp)
            )
        }
    }
}

fun getSuperHeroes(): List<Superhero> {
    return listOf(
        Superhero("Spiderman", "Peter Parker", "Marvel", R.drawable.spiderman),
        Superhero("Batman", "Bruce Wayner", "DC", R.drawable.batman),
        Superhero("Wolverine", "Logan", "Marvel", R.drawable.logan),
        Superhero("Daredevil", "Matthew Michael Murdock", "Marvel", R.drawable.daredevil),
        Superhero("Flash", "Barry Allen", "DC", R.drawable.flash),
        Superhero("Green Lantern", "Hal Jordan", "DC", R.drawable.green_lantern),
        Superhero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
        Superhero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman),
    )
}

