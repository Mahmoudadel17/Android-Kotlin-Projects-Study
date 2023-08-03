package com.example.test

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.utils.BaseLottieAnimator

class ForgotPasswordActivity :AppCompatActivity(){
    private lateinit var buttonResetPassword:Button
    private lateinit var textInputErrorEmail:TextView
    private lateinit var edit_text_email:EditText
    private lateinit var email:String
    private val instanceCommon = Common()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        init()
        callBack()
    }

    private fun init(){
        buttonResetPassword = findViewById(R.id.btn_reset_password)
        textInputErrorEmail = findViewById(R.id.textInputErrorEmail)
        edit_text_email = findViewById(R.id.edit_text_email)

    }

    private fun callBack(){
        buttonResetPassword.setOnClickListener {
            email = edit_text_email.text.toString()

            if (email.isEmpty()){
                instanceCommon.editTextError(edit_text_email,textInputErrorEmail,"Please enter your Email")
            }
            else if ( !instanceCommon.isValidEmail(email)){
                instanceCommon.editTextError(edit_text_email,textInputErrorEmail,"Please enter valid Email")
            }
            else{
                val intent = Intent(this, ActivityOPT::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}