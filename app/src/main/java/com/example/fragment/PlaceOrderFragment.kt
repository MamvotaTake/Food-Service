package com.example.fragment

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment.databinding.FragmentPlaceOrderBinding


class PlaceOrderFragment : Fragment() {
    private var _binding : FragmentPlaceOrderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlaceOrderBinding.inflate(inflater, container, false)
        val root = binding.root
        val router = (requireActivity() as MainActivity).router.from(this@PlaceOrderFragment)
        val fragmentManager = requireActivity().supportFragmentManager
        binding.backToMenuBtn.setOnClickListener {
            router.backTo(MainFragment.TAG)

        }
        return root
    }

    companion object {
        const val TAG = "PlaceOrderFragment"
        @JvmStatic
        fun newInstance() =
            PlaceOrderFragment()
    }
}