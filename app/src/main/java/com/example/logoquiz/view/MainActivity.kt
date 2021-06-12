package com.example.logoquiz.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.logoquiz.R
import com.example.logoquiz.di.DaggerLogoQuizComponent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, LogoQuizFragment.newInstance())
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.fragments.size > 1) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
