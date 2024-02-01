package com.example.note

import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(notes: List<NoteEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: NoteEntity)

    @Query("SELECT * FROM Note")
    suspend fun fetchNote(): List<NoteEntity>

    @Delete
    suspend fun deleteNote(notes: List<NoteEntity>)

    @Query("SELECT * FROM Note")
    fun getSavedContent(): List<NoteEntity>

    @Query("SELECT * FROM Note WHERE Id = :id")
    suspend fun checkNoteExist(id: Long): List<NoteEntity>

    @Transaction
    suspend fun checkInsertNote(note: NoteEntity){
        val listFromId = checkNoteExist(note.id)

        if(listFromId.isEmpty()){
            insertNote(note)
        } else {
            updateNote(note)
        }
    }
}