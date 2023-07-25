package com.example.test

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity(){
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?,) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)


        Handler().postDelayed({
                      if (!sharedPreferences.getBoolean("LoginCompleted",false)){
                          startMainActivity()
                      }else{
                          startHomeActivity()
                      }

        },3000)

    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
   // Note that this method is only available for Android devices running API 21 (Android 5.0 Lollipop)
   // and above. For older versions, changing the status bar color is not supported.

    private fun startHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }


}