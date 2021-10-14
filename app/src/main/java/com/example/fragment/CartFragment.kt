package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragment.databinding.FragmentCartBinding

class CartFragment : Fragment() {
   private lateinit var binding: FragmentCartBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        val router = (requireActivity() as MainActivity).router.from(this@CartFragment)
        val root = binding.root
        binding.placeOrderBtn.setOnClickListener {
            router.goTo(PlaceOrderFragment.TAG, PlaceOrderFragment.newInstance())
        }
        return root
    }

    companion object {
        const val TAG = "CartFragmentTag"

        @JvmStatic
        fun newInstance() =
            CartFragment()
    }


}