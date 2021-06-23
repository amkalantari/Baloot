package com.amiir.baloot.ui.main

import android.view.View
import com.amiir.baloot.R
import com.amiir.baloot.databinding.FragmentProfileBinding
import com.amiir.baloot.ui.main.viewModel.MainViewModel
import com.core.parent.ParentSharedFragment

class ProfileFragment : ParentSharedFragment<MainViewModel, FragmentProfileBinding>() {
    override fun getResourceLayoutId(): Int = R.layout.fragment_profile

    override fun getSkeletonLayoutId(): View? = null

    override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java
}