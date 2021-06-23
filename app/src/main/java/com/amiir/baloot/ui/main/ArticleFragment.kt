package com.amiir.baloot.ui.main

import android.view.View
import com.amiir.baloot.R
import com.amiir.baloot.databinding.FragmentArticleBinding
import com.amiir.baloot.ui.main.viewModel.MainViewModel
import com.core.parent.ParentSharedFragment

class ArticleFragment : ParentSharedFragment<MainViewModel, FragmentArticleBinding>() {
    override fun getResourceLayoutId(): Int = R.layout.fragment_article

    override fun getSkeletonLayoutId(): View? = null

    override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java
}