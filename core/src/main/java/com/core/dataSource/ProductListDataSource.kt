package com.core.dataSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.core.dto.GetProductListRequest
import com.core.dto.Status
import com.core.dto.response.ProductItem
import com.core.repository.PagingRepository


class ProductListDataSource(
    val request: GetProductListRequest,
    private val pageSize: Int,
    private val pagingRepository: PagingRepository
) : PagingSource<Int, ProductItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProductItem> {
        val pageNumber = params.key ?: 1
        val temp = request
        temp.pageNumber = pageNumber
        val result = pagingRepository.getAllProduct(request)

        return when (result.networkState.status) {
            Status.FAILED -> {
                LoadResult.Error(Exception(result.networkState.msg))
            }
            else -> {
                val data = result.onSuccess
                val nextPageNumber: Int? = data?.let { res ->
                    if (res.size >= pageSize) {
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

    override fun getRefreshKey(state: PagingState<Int, ProductItem>): Int = 1

}