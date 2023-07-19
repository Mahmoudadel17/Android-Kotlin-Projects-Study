package com.example.test

import android.content.Context
import android.content.SharedPreferences
import android.os.Handler
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat.finishAffinity


class Common {
    fun upDateEditTexts(vararg editTexts: EditText) {
        for (editText in editTexts) {
            editText.setBackgroundResource(R.drawable.corner)
        }
    }
    fun upDateTextViews(vararg textViews: TextView) {
        for (textView in textViews) {
            textView.visibility = View.GONE
        }
    }
    fun userNameError(editTextUserName: EditText,textView: TextView){
        editTextUserName.setBackgroundResource(R.drawable.edit_text_error)
        textView.visibility = View.VISIBLE
    }
    fun emailError( editTextEmail: EditText,textView: TextView){
        editTextEmail.setBackgroundResource(R.drawable.edit_text_error)
        textView.visibility = View.VISIBLE
    }
    fun passwordError( editTextPassword: EditText,textView: TextView){
        editTextPassword.setBackgroundResource(R.drawable.edit_text_error)
        textView.visibility = View.VISIBLE
    }


    fun makeLoginCompletedTrue(sharedPreferences:SharedPreferences){
        // for login
        val editor = sharedPreferences.edit()
        editor.putBoolean("LoginCompleted",true)
        editor.apply()
    }
    fun makeLoginCompletedFalse(sharedPreferences:SharedPreferences){
        // for logout
        val editor = sharedPreferences.edit()
        editor.putBoolean("LoginCompleted",false)
        editor.apply()
    }
    fun isValidEmail(email: String): Boolean {
        // Regular expression pattern to validate the email format
        val pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        // Check if the provided email matches the pattern
        return email.matches(Regex(pattern))
    }


    fun toastWelcome(context: Context,userName:String){
        Toast.makeText(context,"Welcome $userName ^_^",Toast.LENGTH_SHORT).show()
    }


}