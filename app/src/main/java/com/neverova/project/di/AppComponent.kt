package com.neverova.project.di

import com.neverova.project.di.modules.DatabaseModule
import com.neverova.project.di.modules.DomainModule
import com.neverova.project.di.modules.RemoteModule
import com.neverova.project.viewmodel.HomeFragmentViewModel
import dagger.Component
import javax.inject.Singleton
import com.neverova.project.viewmodel.SettingsFragmentViewModel
import com.example.remote_module.RemoteProvider

@Singleton
@Component(
    //Внедряем все модули, нужные для этого компонента
    dependencies = [RemoteProvider::class],
    modules = [
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
    fun inject(homeFragmentViewModel: HomeFragmentViewModel)
    fun inject(settingsFragmentViewModel: SettingsFragmentViewModel)
}