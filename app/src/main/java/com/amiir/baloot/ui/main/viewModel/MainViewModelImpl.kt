package com.amiir.baloot.ui.main.viewModel

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.core.dataSource.ArticleListDataSource
import com.core.dto.ArticleDto
import com.core.repository.PagingRepository
import com.core.repository.PagingRepositoryImpl.Companion.NETWORK_PAGE_SIZE
import kotlinx.coroutines.flow.Flow

/**
 * Created by aMiir on 1/31/21
 * Drunk, Fix Later
 */
class MainViewModelImpl(var pagingRepository: PagingRepository) : MainViewModel() {

    override fun requestArticle(): Flow<PagingData<ArticleDto>> =
        Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                ArticleListDataSource(
                    pagingRepository
                )
            }
        ).flow

}