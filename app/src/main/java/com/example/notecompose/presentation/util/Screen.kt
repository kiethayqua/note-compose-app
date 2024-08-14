package com.example.notecompose.presentation.util

import kotlinx.serialization.Serializable

@Serializable
object Notes

@Serializable
data class AddEditNote(
    val noteId: Int = -1,
    val noteColor: Int = -1
)

@Serializable
object HomeBottom

@Serializable
object Settings