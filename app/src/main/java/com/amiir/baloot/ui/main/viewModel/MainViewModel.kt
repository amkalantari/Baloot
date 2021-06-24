package com.amiir.baloot.ui.main.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagingData
import com.core.base.BaseViewModel
import com.core.dto.ArticleDto
import com.core.dto.GetArticleListRequest
import com.core.repository.PagingRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by aMiir on 1/31/21
 * Drunk, Fix Later
 */
abstract class MainViewModel : BaseViewModel() {

    abstract fun requestArticle(): Flow<PagingData<ArticleDto>>

}


class MainViewModelFactory(
    private val pagingRepository: PagingRepository,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return MainViewModelImpl(pagingRepository) as T
    }

}