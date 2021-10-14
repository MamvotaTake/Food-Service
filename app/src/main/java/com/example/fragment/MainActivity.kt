package com.example.fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    val router = Router(R.id.flFragment, this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()
        supportFragmentManager.beginTransaction()
            .add(R.id.flFragment, RootFragment.newInstance())
            .addToBackStack("flFragment")
            .commit()
    }


    override fun onBackPressed() {
        if (supportFragmentManager.fragments.last().tag == MainFragment.TAG) {
            supportFragmentManager.popBackStack()
            supportFragmentManager.popBackStack()
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }

    }
}