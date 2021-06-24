package com.amiir.baloot.ui.main

import android.os.Bundle
import android.view.View
import com.amiir.baloot.R
import com.amiir.baloot.databinding.FragmentProfileBinding
import com.amiir.baloot.ui.main.viewModel.MainViewModel
import com.amiir.baloot.util.PublicFunction
import com.core.parent.ParentSharedFragment

class ProfileFragment : ParentSharedFragment<MainViewModel, FragmentProfileBinding>() {
    override fun getResourceLayoutId(): Int = R.layout.fragment_profile

    override fun getSkeletonLayoutId(): View? = null

    override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.img.setImage(R.drawable.profile_pic)
        binding.git.setOnDelayClickListener {
            PublicFunction.openUrlInBrowser(requireContext(), "https://github.com/amkalantari")
        }
        binding.about.setOnDelayClickListener {
            AboutBottomSheet.showDialog(parentFragmentManager)
        }
    }
}