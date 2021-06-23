package com.amiir.baloot.di

import com.core.api.PagingApi
import com.core.repository.PagingRepository
import com.core.repository.PagingRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class RepositoryProvider {

    @Provides
    fun providePagingRepository(retrofit: Retrofit): PagingRepository {
        return PagingRepositoryImpl(retrofit.create(PagingApi::class.java))
    }

}