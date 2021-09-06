package com.neverova.project.di.modules

import com.neverova.project.data.MainRepository
import com.neverova.project.data.TmdbApi
import com.neverova.project.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository, tmdbApi: TmdbApi) = Interactor(repo = repository, retrofitService = tmdbApi)
}