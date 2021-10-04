package com.neverova.project.domain

import androidx.lifecycle.LiveData
import com.neverova.project.data.*
import com.neverova.project.data.entity.Film
import com.neverova.project.data.entity.TmdbResults
import com.neverova.project.data.preferences.PreferenceProvider
import com.neverova.project.utils.Converter
import com.neverova.project.viewmodel.HomeFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor(private val repo: MainRepository, private val retrofitService: TmdbApi, private val preferences: PreferenceProvider) {
    fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallback) {

        retrofitService.getFilms(getDefaultCategoryFromPreferences(), API.KEY, "ru-RU", page).enqueue(object : Callback<TmdbResults> {
            override fun onResponse(call: Call<TmdbResults>, response: Response<TmdbResults>) {
                val list = Converter.convertApiListToDTOList(response.body()?.tmdbFilms)
                repo.putToDb(list)
                callback.onSuccess()
            }

            override fun onFailure(call: Call<TmdbResults>, t: Throwable) {
                callback.onFailure()
            }
        })
    }

    fun saveDefaultCategoryToPreferences(category: String) {
        preferences.saveDefaultCategory(category)
    }

    fun getDefaultCategoryFromPreferences() = preferences.getDefaultCategory()

    fun getFilmsFromDB(): LiveData<List<Film>> = repo.getAllFromDB()
}