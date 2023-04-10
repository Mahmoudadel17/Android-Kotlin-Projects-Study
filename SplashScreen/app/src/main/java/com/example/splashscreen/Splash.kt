package com.example.splashscreen

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val configuration = Resources.getSystem().configuration
            val uiModeFlags = configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            val isNightMode = uiModeFlags == Configuration.UI_MODE_NIGHT_YES
            val splash = Intent(this,MainActivity::class.java)
//            if (isNightMode) {
//                // The device is in dark mode
//                splash = Intent(this,MainActivity2::class.java)
//            } else {
//                // The device is not in dark mode
//                splash = Intent(this,MainActivity::class.java)
//            }
            startActivity(splash)
        },4000)
    }
}