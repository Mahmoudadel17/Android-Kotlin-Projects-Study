package com.example.myapplication


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
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

    private fun startHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }


}