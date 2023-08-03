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
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private val instanceCommon = Common()

    private var doubleBackToExitPressedOnce = false
    private lateinit var sharedPreferences: SharedPreferences


    lateinit var editTextUserName: EditText
    lateinit var editTextEmail: EditText
    lateinit var editTextPassword: EditText
    lateinit var textViewErrorUserName:TextView
    lateinit var textViewErrorEmail:TextView
    lateinit var textViewErrorPassword:TextView
    lateinit var textViewLogin:TextView
    lateinit var buttonSubmit:Button
    private lateinit var visibilityToggleImageViewPassword: ImageView

    private var isPasswordVisible = false

    lateinit var userName:String
    lateinit var email:String
    lateinit var password:String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        callBack()
    }

    private fun callBack(){
        // when user click Sign Up button
        buttonSubmit.setOnClickListener {

            userName = editTextUserName.text.toString()
            email = editTextEmail.text.toString()
            password = editTextPassword.text.toString()


            instanceCommon.upDateEditTexts(editTextUserName,editTextEmail,editTextPassword)
            instanceCommon.upDateTextViews(textViewErrorUserName,textViewErrorEmail,textViewErrorPassword)

            if (userName.isEmpty()){
                instanceCommon.editTextError(editTextUserName,textViewErrorUserName,"Please enter your Name")
            }
            val checkEmailAndPassword  = instanceCommon.checkEmailAndPassword(email,password, editTextEmail,editTextPassword,
                textViewErrorEmail,textViewErrorPassword)

            if (checkEmailAndPassword && userName.isNotEmpty()){
                // here write code for Sign Up using "cloud and database" firebase.

                //-----------------------------------------------------------------
                instanceCommon.toastWelcome(this,userName)
                instanceCommon.makeLoginCompletedTrue(sharedPreferences)
                val intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)
                finish()
            }





        }

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



    }
    private fun init(){
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        visibilityToggleImageViewPassword = findViewById(R.id.visibilityToggleImageViewPassword)
        textViewLogin = findViewById(R.id.textViewLogin)
        editTextUserName = findViewById(R.id.edit_text_username)
        editTextEmail = findViewById(R.id.edit_text_email)
        editTextPassword = findViewById(R.id.edit_text_password)
        textViewErrorUserName = findViewById(R.id.textInputErrorUserName)
        textViewErrorEmail = findViewById(R.id.textInputErrorEmail)
        textViewErrorPassword = findViewById(R.id.textInputErrorPassword)
        buttonSubmit = findViewById(R.id.btn_submit)

        // make under line for text that can be clickable
        //----------------------------------------------------
        textViewLogin.paintFlags =  Paint.UNDERLINE_TEXT_FLAG

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

    fun onLoginClicked(view: android.view.View) {
        val intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)
        finish()
    }
}

