package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment.databinding.FragmentMainBinding



class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val router = (activity as MainActivity).router.from(this)
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val root = binding.root

        binding.previewBtn.setOnClickListener {
            val previewFragment = PreviewFragment.newInstance()
            router.goTo(PreviewFragment.TAG, previewFragment)
        }

        binding.cartBtn.setOnClickListener {
            BottomSheetFragment
                .newInstance()
                .show(requireActivity().supportFragmentManager, BottomSheetFragment.TAG)
        }

        binding.checkoutBtn.setOnClickListener {
            router.goTo(CartFragment.TAG, CartFragment.newInstance())
        }

        return root
    }


    companion object {
        const val TAG = "MainFragment"

        @JvmStatic
        fun newInstance() =
            MainFragment()
    }
}
