package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.VISIBLE
import com.example.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainFragment = MainFragment()
        val cartFragment = CartFragment()
        val placeOrderFragment = PlaceOrderFragment()
        val checkoutFragment = CheckoutFragment()
        val previewFragment = PreviewFragment()



        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, mainFragment)
            commit()
        }

        binding.cartBtn.visibility = VISIBLE
        binding.placeOrderBtn.visibility = VISIBLE


        // Preview button
        binding.previewBtn.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, previewFragment)
                setReorderingAllowed(true)
                commit()
            }
        }

        // Cart button
        binding.cartBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, cartFragment)
                setReorderingAllowed(true)
                addToBackStack(null)
                commit()
            }
        }

        // Place order button
        binding.placeOrderBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, placeOrderFragment)
                setReorderingAllowed(true)
                addToBackStack(null)
                commit()
            }

        }
        // Checkout button
        binding.checkoutBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, checkoutFragment)
                addToBackStack(null)
                commit()
            }
        }


        //Back to main menu button
        binding.backToMenuBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, mainFragment)
                setReorderingAllowed(true)
                commit()
            }
        }

    }
}