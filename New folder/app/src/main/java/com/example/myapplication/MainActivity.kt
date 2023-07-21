package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private val signUpFragment = SignUpFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragmentView()
    }

    private fun initFragmentView(){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment,signUpFragment)
        transaction.commit()
    }
}