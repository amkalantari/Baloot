package com.amiir.baloot.di

import com.amiir.baloot.ui.splash.viewModel.SplashViewModelFactory
import com.amiir.baloot.ui.main.viewModel.MainViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class ViewModelFactory {

    @Provides
    fun provideSplashViewModelFactory(): SplashViewModelFactory {
        return SplashViewModelFactory()
    }

    @Provides
    fun provideMainViewModelFactory(): MainViewModelFactory {
        return MainViewModelFactory()
    }

}