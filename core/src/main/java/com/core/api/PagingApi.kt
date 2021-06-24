package com.core.api

import com.core.dto.ArticleDto
import com.core.dto.ResultDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by aMiir on 5/24/2021 AD
 * Drunk, Fix Later
 */
interface PagingApi {

    @GET("everything")
    suspend fun getAllArticle(
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String,
        @Query("q") q: String? = "bitcoin",
    ): ResultDto<List<ArticleDto>>

}