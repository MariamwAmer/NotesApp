package com.example.notesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false
)
abstract class RoomDBHelper: RoomDatabase () {

    abstract val dao: NoteDao

    companion object{

        @Volatile //UP TO DATE
        private var INSTANCE: RoomDBHelper? = null

        fun getInstance(context: Context): RoomDBHelper{
            return INSTANCE ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, RoomDBHelper::class.java, "MyDB")
                    .build()

                INSTANCE = instance

                instance

            }
        }
    }
}