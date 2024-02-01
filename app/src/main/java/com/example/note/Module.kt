package com.example.note

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module


private val roomModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            NoteDatabase::class.java,
            "note.db"
        ).build()
    }

    factory {
        get<NoteDatabase>().noteDao()
    }
}

private val dataModule = module {
    single {
        RealNoteRepository(
            get()
        )
    } bind NoteRepository::class
}

private val viewModule = module {
    viewModel {
        NoteViewModel(
            get()
        )
    }
}

val appModule = listOf(
    roomModule,
    dataModule,
    viewModule
)