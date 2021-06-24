package com.core.repository

import com.core.api.PagingApi
import com.core.base.BaseObserver
import com.core.base.Response
import com.core.dto.ArticleDto
import com.core.dto.GetArticleListRequest
import retrofit2.HttpException
import java.io.IOException

/**
 * Created by aMiir on 5/23/2021 AD
 * Drunk, Fix Later
 */

abstract class PagingRepository : BaseObserver {

    abstract suspend fun getArticle(
        getArticleListRequest: GetArticleListRequest
    ): Response<List<ArticleDto>?>

}

class PagingRepositoryImpl(private val pagingApi: PagingApi) : PagingRepository() {

    companion object {
        const val NETWORK_PAGE_SIZE = 50
        const val API_KEY = "642d79f9568e465ca6b0fe2ef4cbf43f"
    }

    override suspend fun getArticle(
        getArticleListRequest: GetArticleListRequest
    ): Response<List<ArticleDto>?> {
        val tag = "getArticle"
        return try {
            val res = pagingApi.getAllArticle(
                getArticleListRequest.pageSize,
                getArticleListRequest.page,
                API_KEY
            )
            handlerResult(tag, res)
        } catch (exception: IOException) {
            Response(mutableListOf(), handleError(tag, exception))
        } catch (exception: HttpException) {
            Response(mutableListOf(), handleError(tag, exception))
        }
    }

}