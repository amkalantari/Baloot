package com.amiir.baloot.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.amiir.baloot.databinding.LayoutAboutBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * you can customize the layout with desired input later
 * */
class AboutBottomSheet : BottomSheetDialogFragment() {

    lateinit var binding: LayoutAboutBottomSheetBinding

    companion object {

        @JvmStatic
        fun showDialog(fragmentManager: FragmentManager) =
            AboutBottomSheet().show(fragmentManager, this::class.java.simpleName)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LayoutAboutBottomSheetBinding.inflate(
            LayoutInflater.from(requireContext()),
            container,
            false
        )
        binding.dismissButton.setOnClickListener {
            dismissAllowingStateLoss()
        }
        return binding.root
    }

}