package com.neverova.project.data

import com.neverova.project.data.dao.FilmDao
import com.neverova.project.data.entity.Film
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class MainRepository(private val filmDao: FilmDao) {

    fun putToDb(films: List<Film>) {
            filmDao.insertAll(films)
    }

    fun getAllFromDB(): Observable<List<Film>> = filmDao.getCachedFilms()

}