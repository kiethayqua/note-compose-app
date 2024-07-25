package com.example.notecompose.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notecompose.presentation.theme.BabyBlue
import com.example.notecompose.presentation.theme.LightGreen
import com.example.notecompose.presentation.theme.RedOrange
import com.example.notecompose.presentation.theme.RedPink
import com.example.notecompose.presentation.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String): Exception(message)
