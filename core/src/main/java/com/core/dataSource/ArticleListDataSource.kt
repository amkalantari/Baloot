package com.core.dataSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.core.dto.ArticleDto
import com.core.dto.GetArticleListRequest
import com.core.dto.Status
import com.core.repository.PagingRepository
import com.core.repository.PagingRepositoryImpl.Companion.API_KEY
import com.core.repository.PagingRepositoryImpl.Companion.NETWORK_PAGE_SIZE


class ArticleListDataSource(
    private val pagingRepository: PagingRepository
) : PagingSource<Int, ArticleDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleDto> {
        val pageNumber = params.key ?: 1
        val result =
            pagingRepository.getArticle(
                GetArticleListRequest(
                    pageNumber, NETWORK_PAGE_SIZE
                )
            )

        return when (result.networkState.status) {
            Status.FAILED -> {
                LoadResult.Error(Exception(result.networkState.msg))
            }
            else -> {
                val data = result.onSuccess
                val nextPageNumber: Int? = data?.let { res ->
                    if (res.size >= NETWORK_PAGE_SIZE) {
                        pageNumber + 1
                    } else {
                        null
                    }
                } ?: kotlin.run {
                    null
                }
                LoadResult.Page(
                    data = data.orEmpty(),
                    prevKey = if (pageNumber == 1) null else pageNumber - 1,
                    nextKey = nextPageNumber
                )
            }
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ArticleDto>): Int = 1

}