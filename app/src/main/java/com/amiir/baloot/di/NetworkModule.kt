package com.amiir.baloot.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.google.gson.GsonBuilder
import com.amiir.baloot.util.ConnectivityInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {


    @Singleton
    @Provides
    fun provideConnectivityManager(app: Application): ConnectivityManager {
        return app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Singleton
    @Provides
    fun provideConnectivityInterceptor(app: Application): ConnectivityInterceptor {
        return ConnectivityInterceptor(app)
    }

    @Singleton
    @Provides
    fun provideOkHttp(connectivityInterceptor: ConnectivityInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(connectivityInterceptor)
            .addInterceptor(HttpLoggingInterceptor().apply {
                this.setLevel(HttpLoggingInterceptor.Level.BODY)
            }).build()
    }

    @Provides
    @Singleton
    fun provideRetrofitBase(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

}

