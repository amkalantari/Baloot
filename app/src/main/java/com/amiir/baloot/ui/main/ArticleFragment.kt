package com.amiir.baloot.ui.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.amiir.baloot.R
import com.amiir.baloot.databinding.FragmentArticleBinding
import com.amiir.baloot.ui.main.viewModel.MainViewModel
import com.amiir.baloot.util.bindingAdapter.navigateSafe
import com.core.base.PagingLoadStateAdapter
import com.core.parent.ParentSharedFragment
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ArticleFragment : ParentSharedFragment<MainViewModel, FragmentArticleBinding>() {

    override fun getResourceLayoutId(): Int = R.layout.fragment_article

    override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    private var searchJob: Job? = null

    private val adapter: RvAdapterArticle by lazy {
        RvAdapterArticle {
            findNavController().navigateSafe(ArticleFragmentDirections.toDetail(it))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    override fun onResume() {
        super.onResume()
        requestList()
    }

    private fun initAdapter() {
        with(adapter) {

            binding.list.apply {
                postponeEnterTransition()
                viewTreeObserver.addOnPreDrawListener {
                    startPostponedEnterTransition()
                    true
                }
            }

            binding.list.adapter = withLoadStateHeaderAndFooter(
                header = PagingLoadStateAdapter(this),
                footer = PagingLoadStateAdapter(this)
            )

            this.addLoadStateListener { loadState ->
                binding.isEmpty =
                    loadState.refresh is LoadState.NotLoading && adapter.itemCount == 0

                if (loadState.refresh is LoadState.Loading) {
                    skeletonScreen?.show()
                } else {
                    skeletonScreen?.hide()
                }

                val errorState = loadState.source.append as? LoadState.Error
                    ?: loadState.source.prepend as? LoadState.Error
                    ?: loadState.append as? LoadState.Error
                    ?: loadState.prepend as? LoadState.Error

                errorState?.let {
                    skeletonScreen?.hide()
                    it.error.message?.let { msg ->
                        showMessage(msg)
                    }
                }
            }

        }
    }

    private fun requestList() {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            viewModel.requestArticle().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    override fun showError(tag: String, error: String) {
        super.showError(tag, error)
        showMessage(error)
    }

    override fun getSkeletonLayoutId(): View? = binding.list

}