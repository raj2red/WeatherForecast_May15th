package com.example.weatherforecase_may15th

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.weatherforecase_may15th.presentation_layer.MainActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule
import java.util.Timer
import kotlin.concurrent.schedule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class WeatherInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun initial_screen_splash_test() {
        composeTestRule.onNodeWithText("Find Weather").assertExists()
    }

    @Test
    fun check_mainScreen_test() {
        asyncTimer(4000)
        composeTestRule.onNodeWithTag("searchtext").assertExists()
        composeTestRule.onNodeWithText("Dallas ,US").assertExists()
    }

    @Test
    fun clickButton_mainScreen_search_test() {
        asyncTimer(4000)
        composeTestRule.onNodeWithContentDescription("search icon").performClick()
        asyncTimer(2000)
        composeTestRule.onNodeWithText("Search").assertExists()
    }

    @Test
    fun searchCity_searchScreen_test() {
        asyncTimer(4000)
        composeTestRule.onNodeWithContentDescription("search icon").performClick()
        asyncTimer(2000)
        composeTestRule.onNodeWithTag("textbox").performTextInput("Florida")
        composeTestRule.onNodeWithTag("textbox").performImeAction()
    }

    @Test
    fun searchCity_mainScreen_checkExpectedResult() {
        asyncTimer(4000)
        composeTestRule.onNodeWithContentDescription("search icon").performClick()
        asyncTimer(2000)
        composeTestRule.onNodeWithTag("textbox").performTextInput("Florida")
        composeTestRule.onNodeWithTag("textbox").performImeAction()
        asyncTimer(2000)

        composeTestRule.onNodeWithText("Florida ,US").assertExists()
    }

    fun asyncTimer (delay: Long = 1000) {
        AsyncTimer.start (delay)
        composeTestRule.waitUntil (
            condition = {AsyncTimer.expired},
            timeoutMillis = delay + 1000
        )
    }

    object AsyncTimer {
        var expired = false
        fun start(delay: Long = 1000){
            expired = false
            Timer().schedule(delay) {
                expired = true
            }
        }
    }

}