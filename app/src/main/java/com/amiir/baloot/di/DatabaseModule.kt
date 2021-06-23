package com.amiir.baloot.di

import android.app.Application
import com.core.db.AppDatabase
import com.core.utils.Preference
import com.core.utils.PreferenceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDb(app: Application): AppDatabase {
        return AppDatabase.getInstance(app)
    }


    @Provides
    fun providePreference(app: Application): Preference {
        return PreferenceImpl(app)
    }

}
