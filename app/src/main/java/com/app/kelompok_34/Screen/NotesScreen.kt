@file:OptIn(ExperimentalMaterial3Api::class)

package com.app.kelompok_34.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.kelompok_34.components.NoteCard
import com.app.kelompok_34.model.response.NoteItem

/**
 * NotesScreen adalah layar utama yang menampilkan daftar catatan (notes) dalam sebuah Scaffold.
 * TopAppBar ditampilkan di bagian atas, dan isi konten diambil dari komponen NoteList.
 *
 * @param notes Daftar NoteItem yang akan ditampilkan.
 */
@Composable
fun NotesScreen(notes: List<NoteItem>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("📒 Daftar Notes") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        NoteList(
            notes = notes,
            modifier = Modifier
                .padding(paddingValues)
                .padding(12.dp)
        )
    }
}

/**
 * NoteList adalah komponen yang menampilkan daftar NoteItem dalam bentuk LazyColumn.
 *
 * @param notes Daftar catatan yang akan ditampilkan.
 * @param modifier Modifier opsional untuk styling tambahan.
 */
@Composable
fun NoteList(notes: List<NoteItem>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(notes) { note ->
            NoteCard(note)
        }
    }
}


/**
 * PreviewNotesScreen menampilkan pratinjau NotesScreen dengan dummy data.
 */
@Preview(showBackground = true)
@Composable
fun PreviewNotesScreen() {
    val dummyNotes = listOf(
        NoteItem(
            nm_lengkap = "Zidan",
            id_notes = "1",
            id_user = "user1",
            title = "📘 Belajar Compose",
            content = "Kita akan belajar membuat UI dengan Jetpack Compose.",
            created_at = "",
            updated_at = ""
        ),
        NoteItem(
            nm_lengkap = "Admin",
            id_notes = "2",
            id_user = "user2",
            title = "🚀 Authentication",
            content = "Kita akan bahas tentang JWT dan login session.",
            created_at = "",
            updated_at = ""
        )
    )

    NotesScreen(notes = dummyNotes)
}
