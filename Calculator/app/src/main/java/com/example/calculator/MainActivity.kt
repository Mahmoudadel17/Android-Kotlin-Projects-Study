package com.example.calculator


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.ArithmeticException
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var lastNumeric = false
    var stateError = false
    var lastDot = false

    private lateinit var expression: Expression


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onAllclearClic(view: View) {
        binding.dataTv.text = ""
        binding.resultTv.text = ""
        stateError = false
        lastNumeric = false
        lastDot = false
        binding.resultTv.visibility = View.GONE
    }

    fun onEqualClic(view: View) {
        onEqual()
        binding.dataTv.text = binding.resultTv.text.toString().drop(1)
    }

    fun onOperatorClic(view: View) {
        if (!stateError && lastNumeric) {
            binding.dataTv.append((view as Button).text)
            lastDot = false
            lastNumeric = false
            onEqual()
        }
    }

    fun onClearClic(view: View) {
        binding.dataTv.text = ""
        lastNumeric = false
    }

    fun onBackClic(view: View) {
        binding.dataTv.text = binding.dataTv.text.toString().dropLast(1)

        try {
            val lastchar = binding.dataTv.text.toString().last()

            if (lastchar.isDigit()) {
                onEqual()
            }
        } catch (e: Exception) {
            binding.resultTv.text = ""
            binding.resultTv.visibility = View.GONE
            Log.e("last char error", e.toString())
        }
    }

    fun onDigitClic(view: View) {

        if (stateError) {
            binding.dataTv.text = (view as Button).text
            stateError = false

        } else {
            binding.dataTv.append((view as Button).text)

        }
        lastNumeric = true
        onEqual()

    }

    fun onEqual() {
        if (lastNumeric && !stateError) {
            val txt = binding.dataTv.text.toString()

            expression = ExpressionBuilder(txt).build()

            try {
                val result = expression.evaluate()

                binding.resultTv.visibility = View.VISIBLE

                binding.resultTv.text = "=$result"


            } catch (ex: ArithmeticException) {
                Log.e("evaluate error", ex.toString())
                binding.resultTv.text = "Error"
                stateError = true
                lastNumeric = false
            }
        }
    }
}

