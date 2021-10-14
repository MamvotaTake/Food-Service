package com.example.fragment

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment.databinding.FragmentPreviewBinding



class PreviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPreviewBinding.inflate(inflater, container, false)
        val router = (requireActivity() as MainActivity).router
        val root = binding.root
        binding.goToCartBtn.setOnClickListener {
            router.from(this).goTo(CartFragment.TAG, CartFragment.newInstance())
        }
        return root
    }

    companion object {
        const val TAG = "PreviewFragmentTag"
        @JvmStatic
        fun newInstance() =
            PreviewFragment()
    }
}