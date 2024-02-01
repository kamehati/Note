package com.example.note

import androidx.annotation.WorkerThread

interface NoteRepository{
    fun getSavedContent(): List<NoteEntity>
    suspend fun fetchNote(): List<NoteEntity>
    suspend fun insertNote(note: NoteEntity)
    suspend fun insertNotes(notes: List<NoteEntity>)
    suspend fun deleteNote(notes: List<NoteEntity>)

    suspend fun checkInsertNote(note: NoteEntity)
}

class RealNoteRepository(
    private val noteDao: NoteDao
): NoteRepository {

    override fun getSavedContent(): List<NoteEntity>
    = noteDao.getSavedContent().sortedBy { it.id }

    @WorkerThread
    override suspend fun fetchNote(): List<NoteEntity>
    = noteDao.fetchNote().sortedBy { it.id }

    @WorkerThread
    override suspend fun insertNote(note: NoteEntity)
    = noteDao.insertNote(note)

    override suspend fun insertNotes(notes: List<NoteEntity>)
    = noteDao.insertNotes(notes)

    @WorkerThread
    override suspend fun deleteNote(notes: List<NoteEntity>)
    = noteDao.deleteNote(notes)

    @WorkerThread
    override suspend fun checkInsertNote(
        note: NoteEntity
    ) = noteDao.checkInsertNote(note)
}