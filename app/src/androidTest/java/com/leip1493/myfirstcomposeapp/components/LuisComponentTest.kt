package com.leip1493.myfirstcomposeapp.components

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.doubleClick
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.longClick
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeDown
import androidx.compose.ui.test.swipeLeft
import org.junit.Rule
import org.junit.Test

class LuisComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myFirstTest() {
        composeTestRule.setContent {
            LuisComponent()
        }

        // FINDER
        composeTestRule.onNodeWithText("Lorem").assertExists()
        composeTestRule.onNodeWithText("ipsum", ignoreCase = true).assertExists()
        // Por tag
        composeTestRule.onNodeWithTag("Luis2").assertExists()
        // Por content description (imagenes por ejemplo)
        composeTestRule.onNodeWithContentDescription("add").assertExists()

        // Realizar un assert sobre mas de un elemento con el mismo texto, tag o content description
        composeTestRule.onAllNodesWithText("Luis").assertCountEquals(2)
//        composeTestRule.onAllNodesWithTag("Luis").assertCountEquals(2)
//        composeTestRule.onAllNodesWithContentDescription("Luis").assertCountEquals(2)

        // ACTIONS
        composeTestRule.onNodeWithText("lorem", ignoreCase = true).performClick()
        composeTestRule.onNodeWithText("lorem", ignoreCase = true)
            .performTouchInput {
                longClick()
                doubleClick()
                swipeDown()
                swipeLeft()
            }
        composeTestRule.onNodeWithText("lorem", ignoreCase = true).performScrollTo()
        composeTestRule.onNodeWithText("lorem", ignoreCase = true)
            .performImeAction() // Action de teclado
        composeTestRule.onNodeWithText("lorem", ignoreCase = true).performTextClearance()
        composeTestRule.onNodeWithText("lorem", ignoreCase = true)
            .performTextInput("lorem ipsum ") // añade el texto al componente
        composeTestRule.onNodeWithText("lorem", ignoreCase = true)
            .performTextReplacement("reemplazar por este texto")

    }

    @Test
    fun whenComponentStart_ThenVerifyContentIsPepito() {
        composeTestRule.setContent {
            LuisComponent()
        }

        composeTestRule.onNodeWithText("Pepito", ignoreCase = true).assertExists()
        composeTestRule.onNodeWithTag("textFieldName")
            .assertTextContains("pepito", ignoreCase = true)
    }

    @Test
    fun whenNameIsAdded_ThenVerifyTextContainGreeting() {
        composeTestRule.setContent {
            LuisComponent()
        }

        composeTestRule.onNodeWithTag("textFieldName").performTextClearance()
        composeTestRule.onNodeWithTag("textFieldName").performTextReplacement("Foo")
        composeTestRule.onNodeWithTag("textGreeting").assertTextEquals("Te llamas Foo")
    }


}