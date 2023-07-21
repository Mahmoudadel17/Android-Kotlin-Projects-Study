package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Paint
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.LoginFragmentBinding
import android.widget.*

class LoginFragment : Fragment() {
    lateinit var binding:LoginFragmentBinding
    private val instanceCommon = Common()

    private lateinit var sharedPreferences: SharedPreferences
    private var isPasswordVisible = false

    lateinit var email:String
    lateinit var password:String


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater,container,false)
        initStart()
        callBack()
        return  binding.root
    }

    private fun initStart(){

        // make under line for text that can be clickable
        //----------------------------------------------------
        binding.textViewRegister.paintFlags =  Paint.UNDERLINE_TEXT_FLAG
        binding.textViewForgotPassword.paintFlags =  Paint.UNDERLINE_TEXT_FLAG


    }

    private fun callBack(){
        // when user click on icon visibility to show or hide password
        binding.visibilityToggleImageViewPassword.setOnClickListener{
            isPasswordVisible = !isPasswordVisible

            if (isPasswordVisible){
                // Show password
                binding.editTextPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                binding.visibilityToggleImageViewPassword.setImageResource(R.drawable.ic_baseline_visibility_24)
                // Move the cursor indicator to the end of the text
                binding.editTextPassword.setSelection(binding.editTextPassword.getText().length);

            }
            else{
                // Hide password
                binding.editTextPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.visibilityToggleImageViewPassword.setImageResource(R.drawable.ic_baseline_visibility_off_24)
                // Move the cursor indicator to the end of the text
                binding.editTextPassword.setSelection( binding.editTextPassword.getText().length);


            }
        }





    }
}