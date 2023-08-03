package com.example.test

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Handler
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.core.content.ContextCompat.startActivity


class Common {

    fun checkEmailAndPassword(email: String,password:String, editTextEmail: EditText,editTextPassword:
    EditText, textViewErrorEmail:TextView,textViewErrorPassword:TextView,):Boolean {
        var checkEmailAndPassword = true
        if (email.isEmpty()){
            editTextError(editTextEmail,textViewErrorEmail,"Please enter your Email")
            checkEmailAndPassword = false
        }
        if (email.isNotEmpty() && !isValidEmail(email)){
            editTextError(editTextEmail,textViewErrorEmail,"Please enter valid Email")
            checkEmailAndPassword = false
        }
        if (password.isEmpty()){
            editTextError(editTextPassword,textViewErrorPassword,"Please enter your Password")
            checkEmailAndPassword = false
        }
        if (password.isNotEmpty()  && password.length < 8){
            editTextError(editTextPassword,textViewErrorPassword,"Please enter valid Password")
            checkEmailAndPassword = false
        }
        return checkEmailAndPassword

    }
    fun upDateEditTexts(vararg editTexts: EditText) {
        for (editText in editTexts) {
            editText.setBackgroundResource(R.drawable.corner)
        }
    }
    fun upDateTextViews(vararg textViews: TextView) {
        for (textView in textViews) {
            textView.text = ""
        }
    }

    fun editTextError(editText: EditText, textView: TextView, validString:String ){
        editText.setBackgroundResource(R.drawable.edit_text_error)
        textView.text = validString

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