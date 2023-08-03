package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView

class ActivityOPT : AppCompatActivity() {
    private val instanceCommon = Common()

    private lateinit var buttonVerify: Button
    private lateinit var textInputErrorOTP: TextView
    private lateinit var editTextOTP: EditText
    private lateinit var lottieAnimator: LottieAnimationView
    private lateinit var otpNumber:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opt)
        init()
        callBack()
    }

    private fun init(){
        buttonVerify = findViewById(R.id.btn_verify)
        textInputErrorOTP = findViewById(R.id.textInputErrorOTP)
        editTextOTP = findViewById(R.id.edit_text_otp)
        lottieAnimator =findViewById(R.id.lottie_otp)
    }

    private fun callBack(){
        buttonVerify.setOnClickListener {
            otpNumber = editTextOTP.text.toString()

            if (otpNumber.isNotEmpty() && otpNumber.length==6 && validOPT(otpNumber)){
                lottieAnimator.setAnimation(R.raw.c)
                lottieAnimator.playAnimation()
                Handler().postDelayed({
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                },1500)
            }else{
                instanceCommon.editTextError(editTextOTP,textInputErrorOTP,"Please enter your OTP number")

            }
        }
    }
private fun validOPT(number:String):Boolean{
    for (i in number.indices){
        if (!number[i].isDigit()){
            return false
        }
    }
    return true
}
}

