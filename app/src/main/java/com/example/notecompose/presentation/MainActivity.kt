package com.example.notecompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.notecompose.presentation.navigation.MainBottomNavigation
import com.example.notecompose.presentation.theme.NoteComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteComposeAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    MainBottomNavigation()
                }
            }
        }
    }
}