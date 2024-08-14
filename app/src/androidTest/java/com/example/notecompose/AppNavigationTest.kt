package com.example.notecompose

import androidx.activity.compose.setContent
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notecompose.presentation.MainActivity
import com.example.notecompose.presentation.navigation.MainBottomNavigation
import com.example.notecompose.presentation.theme.NoteComposeAppTheme
import com.example.notecompose.presentation.util.Settings
import org.junit.Rule
import org.junit.Test

class AppNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var navController: NavHostController

    @Test
    fun assertNavigateToSetting() {
        initCompose()
        composeTestRule.onNodeWithText("Settings").performClick()

        val route = navController.currentDestination?.route
        assert(route.equals(Settings.javaClass.name))
    }

    private fun initCompose() {
        composeTestRule.activity.setContent {
            NoteComposeAppTheme {
                navController = rememberNavController()
                MainBottomNavigation(navController = navController)
            }
        }
    }
}