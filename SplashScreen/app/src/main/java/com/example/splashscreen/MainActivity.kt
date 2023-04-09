package com.example.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.splashscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var lastNumeric = false
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onAllclearClic(view: android.view.View) {}

    fun onEqualClic(view: android.view.View) {}

    fun onOperatorClic(view: android.view.View) {}

    fun onClearClic(view: android.view.View) {}

    fun onBackClic(view: android.view.View) {}

    fun onDigitClic(view: android.view.View) {}


}