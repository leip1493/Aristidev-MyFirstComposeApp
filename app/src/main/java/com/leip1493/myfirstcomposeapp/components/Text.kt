package com.leip1493.myfirstcomposeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun MyTexts(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Lorem ipsum")
        Text("Lorem ipsum red", color = Color.Red)
        Text("Lorem", fontSize = 25.sp)
        Text("Lorem italic", fontStyle = FontStyle.Italic)
        Text(
            "Font weight italic big",
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            fontSize = 30.sp
        )
        Text("LetterSpacing", letterSpacing = 20.sp)
        Text(
            "TextDecoration combined",
            textDecoration = TextDecoration.Underline + TextDecoration.LineThrough
        )

        Text(
            "Underline clickable",
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.clickable { })

        // Sin el modifier el elemento no puede centrarse porque no ocupa todo el espacio para centrase
        Text("Align", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)

        Text("Long text max line 1 aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", maxLines = 1, overflow = TextOverflow.Ellipsis)

    }
}