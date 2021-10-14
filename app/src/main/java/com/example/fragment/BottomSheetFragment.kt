package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment.databinding.BottomSheetFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {
    private var _binding : BottomSheetFragmentBinding? = null
    private val binding get () = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetFragmentBinding.inflate(inflater, container, false)
        val fragmentManager = requireActivity().supportFragmentManager
        val router = (activity as MainActivity).router
        val root = binding.root
        binding.addToBtn.setOnClickListener {
            this.dismiss()
            router.goTo(CartFragment.TAG, CartFragment.newInstance())
        }
        return root
    }

    companion object {
        const val TAG = "BottomSheetDialogFragment"
        @JvmStatic
        fun newInstance() =
            BottomSheetDialogFragment()
    }
}