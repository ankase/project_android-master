package com.neverova.project.di.modules

import com.neverova.project.data.MainRepository
import com.neverova.project.data.preferences.PreferenceProvider
import com.neverova.project.data.TmdbApi
import com.neverova.project.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import android.content.Context

@Module
class DomainModule(val context: Context) {
    @Provides
    fun provideContext() = context

    @Singleton
    @Provides
    fun providePreferences(context: Context) = PreferenceProvider(context)

    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi, preferenceProvider: PreferenceProvider) = Interactor(repo = repository, retrofitService = tmdbApi, preferences = preferenceProvider)
}