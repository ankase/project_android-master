package com.neverova.project.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.neverova.project.data.dao.FilmDao
import com.neverova.project.data.entity.Film

@Database(entities = [Film::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}