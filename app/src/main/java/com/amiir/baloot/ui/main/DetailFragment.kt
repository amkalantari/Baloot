package com.amiir.baloot.ui.main

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.amiir.baloot.R
import com.amiir.baloot.databinding.FragmentDetailBinding
import com.core.base.BaseFragment

class DetailFragment : BaseFragment<FragmentDetailBinding>() {

    val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.item = args.item
    }

    override fun getResourceLayoutId(): Int = R.layout.fragment_detail

    override fun getSkeletonLayoutId(): View? = null

}