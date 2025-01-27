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

    var checkInfoStatus by rememberSaveable { mutableStateOf(true) }
    val checkInfo = CheckInfo(title = "Elemento 1", selected = checkInfoStatus) {
        checkInfoStatus = it
    }

    val myOptions = getOptions(listOf("Lorem", "Ipsum", "Foo"))

    Column(modifier) {
        Checkbox(
            checked = state, onCheckedChange = { state = it }, colors = CheckboxDefaults.colors(
                checkedColor = Color.Cyan, uncheckedColor = Color.Green, checkmarkColor = Color.Gray
            )
        )

        // Checkbox con texto
        CheckboxWithText()

        MyCheckboxWithTextCompleted(checkInfo)

        myOptions.forEach {
            MyCheckboxWithTextCompleted(it)
        }
    }
}


@Composable
private fun CheckboxWithText() {
    var state by rememberSaveable { mutableStateOf(true) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = state, onCheckedChange = { state = it }, colors = CheckboxDefaults.colors(
                checkedColor = Color.Cyan, uncheckedColor = Color.Green, checkmarkColor = Color.Gray
            )
        )
        Spacer(Modifier.width(8.dp))
        Text("Ejemplo 1")

    }
}

data class CheckInfo(
    val title: String,
    var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit,
)


@Composable
private fun MyCheckboxWithTextCompleted(checkInfo: CheckInfo) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(it) },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Cyan, uncheckedColor = Color.Green, checkmarkColor = Color.Gray
            )
        )
        Spacer(Modifier.width(8.dp))
        Text(checkInfo.title)

    }
}


@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(true) }
        CheckInfo(
            title = it,
            selected = status
        ) {
            status = it
        }
    }
}


