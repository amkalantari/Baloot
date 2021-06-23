package com.amiir.baloot.di

import android.app.Application
import com.amiir.baloot.App
import com.amiir.baloot.ui.main.MainActivity
import com.amiir.baloot.ui.splash.SplashActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DatabaseModule::class,
        NetworkModule::class,
        RepositoryProvider::class,
        ViewModelFactory::class
    ]
)
interface AppComponent {

    fun inject(app: App)

    //Activity
    fun inject(app: MainActivity)
    fun inject(app: SplashActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(app: Application): Builder

        fun build(): AppComponent
    }

}
