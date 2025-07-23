package com.app.kelompok_34.model.response

data class NoteCreateResponse (
    val code: Int,
    val message: String,
    val data: NoteItemCreate
)

data class NoteItemCreate (
    val id_notes: String,
    val title: String,
    val content: String
)