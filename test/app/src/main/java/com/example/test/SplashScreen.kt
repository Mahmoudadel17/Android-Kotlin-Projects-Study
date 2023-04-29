package com.example.test

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?,) {
        super.onCreate(savedInstanceState)
        window.setBackgroundDrawableResource(R.color.black)
        setContentView(R.layout.splash)

        Handler().postDelayed({
            val splash = Intent(this,MainActivity::class.java)

            startActivity(splash)
            finish()
        },4000)

    }
}