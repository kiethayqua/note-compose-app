package com.example.notecompose.presentation.navigation

import androidx.compose.foundation.layout.navigationBarsPadding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.notecompose.presentation.add_edit_note.AddEditNoteScreen
import com.example.notecompose.presentation.notes.NotesScreen
import com.example.notecompose.presentation.settings.SettingsScreen
import com.example.notecompose.presentation.util.AddEditNote
import com.example.notecompose.presentation.util.Notes
import com.example.notecompose.presentation.util.Settings

private data class BottomNavItem(
    val name: String,
    val route: Any,
    val icon: ImageVector
)

@Composable
fun MainBottomNavigation(
    navController: NavHostController = rememberNavController()
) {
    val items = remember {
        listOf(
            BottomNavItem(
                name = "Notes",
                route = Notes,
                icon = Icons.Filled.Book
            ),
            BottomNavItem(
                name = "Settings",
                route = Settings,
                icon = Icons.Filled.Settings
            )
        )
    }

    val bottomNavRoutes = listOf(Notes.javaClass.name, Settings.javaClass.name)

    Scaffold(
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            currentDestination?.route?.let { route ->
                if (route in bottomNavRoutes) {
                    BottomNavigation(
                        modifier = Modifier.navigationBarsPadding(),
                        backgroundColor = Color.Blue,
                    ) {
                        items.forEach { screen ->
                            BottomNavigationItem(
                                icon = { Icon(screen.icon, contentDescription = null) },
                                label = { Text(text = screen.name) },
                                selected = currentDestination.hierarchy.any { it.route == screen.route.javaClass.name },
                                onClick = {
                                    navController.navigate(screen.route) {
                                        // Pop up to the start destination of the graph to
                                        // avoid building up a large stack of destinations
                                        // on the back stack as users select items
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }

                                        // Avoid multiple copies of the same destination when
                                        // reselecting the same item
                                        launchSingleTop = true

                                        // Restore state when reselecting a previously selected item
                                        restoreState = true
                                    }
                                },
                                selectedContentColor = Color.Red,
                                unselectedContentColor = Color.Green
                            )
                        }
                    }
                }
            }
        }
    ) { _ ->
        NavHost(
            navController = navController,
            startDestination = Notes
        ) {
            composable<Notes> {
                NotesScreen(
                    navigateToAddEditNote = {
                        navController.navigate(it)
                    },
                )
            }
            composable<Settings> {
                SettingsScreen()
            }
            composable<AddEditNote>(
                enterTransition = {
                    scaleIntoContainer()
                },
                exitTransition = {
                    scaleOutOfContainer()
                },
                popEnterTransition = {
                    scaleIntoContainer()
                },
                popExitTransition = {
                    scaleOutOfContainer()
                }
            ) { backstackEntry ->
                val addEditNote: AddEditNote = backstackEntry.toRoute()
                val color = addEditNote.noteColor
                AddEditNoteScreen(
                    onBack = {
                        navController.navigateUp()
                    },
                    noteColor = color,
                )
            }
        }
    }
}