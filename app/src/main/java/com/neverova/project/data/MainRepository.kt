package com.neverova.project.data

import androidx.lifecycle.LiveData
import com.neverova.project.data.dao.FilmDao
import com.neverova.project.data.entity.Film
import java.util.concurrent.Executors
import kotlinx.coroutines.flow.Flow

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
        Executors.newSingleThreadExecutor().execute {
            filmDao.insertAll(films)
        }
    }

    fun getAllFromDB(): Flow<List<Film>> = filmDao.getCachedFilms()

}