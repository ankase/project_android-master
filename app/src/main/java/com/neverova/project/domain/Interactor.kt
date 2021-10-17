package com.neverova.project.domain

import com.neverova.project.data.API
import com.neverova.project.data.MainRepository
import com.neverova.project.data.TmdbApi
import com.neverova.project.data.entity.Film
import com.neverova.project.data.entity.TmdbResults
import com.neverova.project.data.preferences.PreferenceProvider
import com.neverova.project.utils.Converter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor(private val repo: MainRepository, private val retrofitService: TmdbApi, private val preferences: PreferenceProvider) {
    val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
    var progressBarState = Channel<Boolean>(Channel.CONFLATED)

    fun getFilmsFromApi(page: Int) {
        scope.launch {
            progressBarState.send(true)
        }

        retrofitService.getFilms(getDefaultCategoryFromPreferences(), API.KEY, "ru-RU", page).enqueue(object : Callback<TmdbResults> {
            override fun onResponse(call: Call<TmdbResults>, response: Response<TmdbResults>) {
                val list = Converter.convertApiListToDTOList(response.body()?.tmdbFilms)
                scope.launch {
                    repo.putToDb(list)
                    progressBarState.send(false)
                }
            }

            override fun onFailure(call: Call<TmdbResults>, t: Throwable) {
                scope.launch {
                    progressBarState.send(false)
                }
            }
        })
    }

    fun saveDefaultCategoryToPreferences(category: String) {
        preferences.saveDefaultCategory(category)
    }

    fun getDefaultCategoryFromPreferences() = preferences.getDefaultCategory()

    fun getFilmsFromDB(): Flow<List<Film>> = repo.getAllFromDB()
}