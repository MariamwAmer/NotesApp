package com.example.notesapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    /*@Insert
    fun insertNote(n: Note)

    @Update
    fun updateNote(n: Note)*/

    @Upsert
    suspend fun upsertNote(n: Note)

    @Delete
    suspend fun deleteNote(n: Note)

    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>
}