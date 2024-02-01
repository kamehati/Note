package com.example.note

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = "Note"
)
@Parcelize
class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var id: Long = 0,
    @ColumnInfo(name = "Content")
    var content: String = ""
): Parcelable {
    companion object{
        val emptyNote = NoteEntity(
            id = -1L,
            content = ""
        )
    }
}

fun createNote(content: String = ""): NoteEntity{
    return NoteEntity(
        content = content
    )
}

fun createNote(id: Long, content: String = ""): NoteEntity{
    return NoteEntity(
        id = id,
        content = content
    )
}

fun updateNote(id: Long, content: String): NoteEntity{
    return NoteEntity(
        id = id,
        content = content
    )
}