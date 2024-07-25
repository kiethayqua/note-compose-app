package com.example.notecompose.presentation.add_edit_note

data class NoteTextFieldState(
    val text: String =  "",
    val hint: String = "",
    val isHintVisible: Boolean = false
)