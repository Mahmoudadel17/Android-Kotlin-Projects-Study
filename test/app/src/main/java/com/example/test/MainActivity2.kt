package com.example.test

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.*

class MainActivity2 : AppCompatActivity() {
    private val instanceCommon = Common()

    private lateinit var sharedPreferences: SharedPreferences
    private var doubleBackToExitPressedOnce = false

    lateinit var textViewRegister: TextView
    lateinit var textViewForgotPassword: TextView
    lateinit var editTextPassword:EditText
    lateinit var editTextEmail:EditText
    lateinit var textViewErrorEmail:TextView
    lateinit var textViewErrorPassword:TextView
    lateinit var buttonLogin:Button

    private lateinit var visibilityToggleImageViewPassword: ImageView
    private var isPasswordVisible = false

    lateinit var email:String
    lateinit var password:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        init()
        callBack()
    }

    private fun callBack(){
        // when user click on icon visibility to show or hide password
        visibilityToggleImageViewPassword.setOnClickListener{
            isPasswordVisible = !isPasswordVisible

            if (isPasswordVisible){
                // Show password
                editTextPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                visibilityToggleImageViewPassword.setImageResource(R.drawable.ic_baseline_visibility_24)
                // Move the cursor indicator to the end of the text
                editTextPassword.setSelection(editTextPassword.getText().length);

            }
            else{
                // Hide password
                editTextPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                visibilityToggleImageViewPassword.setImageResource(R.drawable.ic_baseline_visibility_off_24)
                // Move the cursor indicator to the end of the text
                editTextPassword.setSelection(editTextPassword.getText().length);


            }
        }

        // when user click on Login button
        buttonLogin.setOnClickListener {
            email = editTextEmail.text.toString()
            password = editTextPassword.text.toString()

            instanceCommon.upDateEditTexts(editTextEmail,editTextPassword)
            instanceCommon.upDateTextViews(textViewErrorEmail,textViewErrorPassword)
            val checkEmailAndPassword  = instanceCommon.checkEmailAndPassword(email,password, editTextEmail,editTextPassword,
                textViewErrorEmail,textViewErrorPassword)

            if (checkEmailAndPassword){
                // here write code for Sign Login "cloud and database" firebase.

                //-----------------------------------------------------------------
                instanceCommon.toastWelcome(this,"userName")
                instanceCommon.makeLoginCompletedTrue(sharedPreferences)
                val intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }

    private fun init(){
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        editTextEmail = findViewById(R.id.edit_text_email)
        editTextPassword = findViewById(R.id.editTextPassword)
        textViewErrorEmail = findViewById(R.id.textInputErrorEmail)
        textViewErrorPassword = findViewById(R.id.textInputErrorPassword)
        textViewForgotPassword = findViewById(R.id.textViewForgotPassword)
        textViewRegister = findViewById(R.id.textViewRegister)
        buttonLogin = findViewById(R.id.buttonLogin)
        visibilityToggleImageViewPassword = findViewById(R.id.visibilityToggleImageViewPassword)

        // make under line for text that can be clickable
        //----------------------------------------------------
        textViewRegister.paintFlags =  Paint.UNDERLINE_TEXT_FLAG
        textViewForgotPassword.paintFlags =  Paint.UNDERLINE_TEXT_FLAG

    }


    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finishAffinity() //This will exit the app
        } else {
            doubleBackToExitPressedOnce = true
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
            // Reset the flag after 2 seconds
        }
    }


    fun onRegisterClicked(view: android.view.View) {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }


    fun onForgotClicked(view: android.view.View) {
        // here code for forgot password
    }


}