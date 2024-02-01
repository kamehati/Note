package com.example.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NoteViewModel(
    private val noteRepository: NoteRepository
) : ViewModel(){

    private val notes = MutableLiveData<List<NoteEntity>>()

    init {
        forceReload()
    }

    fun forceReload() =
        viewModelScope.launch(IO) {
            fetchNote()
        }

    private suspend fun fetchNote() {
        notes.postValue(
            noteRepository.fetchNote()
        )
    }

    fun getNote(): LiveData<List<NoteEntity>> = notes

    suspend fun getSavedContent()
    = withContext(IO){
        noteRepository.getSavedContent()
    }

    fun insertNote(
        note: NoteEntity
    ) = viewModelScope.launch {
        noteRepository.insertNote(note)
    }

    fun insertNotes(
        notes: List<NoteEntity>
    ) = viewModelScope.launch {
        noteRepository.insertNotes(notes)
    }

    fun deleteNote(
        notes: List<NoteEntity>
    ) = viewModelScope.launch {
        noteRepository.deleteNote(notes)
    }

    suspend fun checkInsertNote(
        note: NoteEntity
    ) = noteRepository.checkInsertNote(note)
}