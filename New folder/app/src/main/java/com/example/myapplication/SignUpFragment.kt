package com.example.myapplication

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.SignupFragmentBinding

class SignUpFragment : Fragment() {
    lateinit var binding: SignupFragmentBinding
    private val instanceCommon = Common()

    private var doubleBackToExitPressedOnce = false
    private lateinit var sharedPreferences: SharedPreferences

    private var isPasswordVisible = false

    lateinit var userName:String
    lateinit var email:String
    lateinit var password:String


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SignupFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun callBack(){
        binding.btnSubmit.setOnClickListener{


        }
    }
}