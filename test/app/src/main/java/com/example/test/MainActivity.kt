package com.example.test

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Html
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.*

class MainActivity : AppCompatActivity() {
    private var doubleBackToExitPressedOnce = false
    private lateinit var sharedPreferences: SharedPreferences


    lateinit var editTextUserName: EditText
    lateinit var editTextEmail: EditText
    lateinit var editTextPassword: EditText
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

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        editTextUserName = findViewById(R.id.edit_text_username)
        editTextEmail = findViewById(R.id.edit_text_email)
        editTextPassword = findViewById(R.id.edit_text_password)
        buttonSubmit = findViewById(R.id.btn_submit)


        // make under line for text that can be clickable
        //----------------------------------------------------
        textViewLogin = findViewById(R.id.textViewLogin)
        textViewLogin.paintFlags =  Paint.UNDERLINE_TEXT_FLAG




        // when user click Sign Up button
        buttonSubmit.setOnClickListener {

            userName = editTextUserName.text.toString()
            email = editTextEmail.text.toString()
            password = editTextPassword.text.toString()



            if (userName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && password.length>8){
                Toast.makeText(this,"Welcome $userName ^_^",Toast.LENGTH_SHORT).show()
                val intent = Intent(this,HomeActivity::class.java)

                val editor = sharedPreferences.edit()
                editor.putBoolean("LoginCompleted", false)
                editor.apply()

                startActivity(intent)
                finish()

            }else{
                Toast.makeText(this,
                    "Please make sure you enter correct information!",
                    Toast.LENGTH_SHORT).show()
            }




        }



        // when user click on icon visibility to show or hide password
        visibilityToggleImageViewPassword = findViewById(R.id.visibilityToggleImageViewPassword)

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




    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
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

