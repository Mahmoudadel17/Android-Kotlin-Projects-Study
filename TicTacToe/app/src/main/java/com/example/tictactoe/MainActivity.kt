package com.example.tictactoe

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.tictactoe.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    var playerXScore = 0
    var playerOScore = 0
    var checkPlayer = false
    val DIALOG_DURATION = 2000
    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onBtn_1Clic(view: android.view.View) {

        if (!full()){
            if (checkPlayer && binding.btn1.text == ""){
                binding.btn1.text = "O"
                checkPlayer=false
                binding.btn1.setTextColor(ContextCompat.getColor(this,R.color.backgroundO))
                if (checkWinner("O")){
                    win_O()
                }
            }else if (!checkPlayer && binding.btn1.text == ""){

                binding.btn1.setText("X")
                checkPlayer=true
                binding.btn1.setTextColor(ContextCompat.getColor(this,R.color.backgroundX))
                if (checkWinner("X")){
                    win_X()
                }
            }
        }
        if(full()){
            alert_No()
            reset()
        }

    }
    fun onBtn_2Clic(view: android.view.View) {
        if (!full()){
            if (checkPlayer && binding.btn2.text == ""){
                binding.btn2.text = "O"
                checkPlayer=false
                binding.btn2.setTextColor(ContextCompat.getColor(this,R.color.backgroundO))
                if (checkWinner("O")){
                    win_O()
                }
            }else if (!checkPlayer && binding.btn2.text == ""){
                binding.btn2.text = "X"
                checkPlayer=true
                binding.btn2.setTextColor(ContextCompat.getColor(this,R.color.backgroundX))
                if (checkWinner("X")){
                    win_X()
                }
            }
        }
        if(full()){
            alert_No()
            reset()
        }
    }
    fun onBtn_3Clic(view: android.view.View) {
        if (!full()){
            if (checkPlayer && binding.btn3.text == ""){
                binding.btn3.text = "O"
                checkPlayer=false
                binding.btn3.setTextColor(ContextCompat.getColor(this,R.color.backgroundO))
                if (checkWinner("O")){
                    win_O()
                }
            }else if (!checkPlayer && binding.btn3.text == ""){
                binding.btn3.text = "X"
                checkPlayer=true
                binding.btn3.setTextColor(ContextCompat.getColor(this,R.color.backgroundX))
                if (checkWinner("X")){
                    win_X()
                }
            }
        }
        if(full()){
            alert_No()
            reset()
        }
    }
    fun onBtn_4Clic(view: android.view.View) {
        if (!full()){
            if (checkPlayer && binding.btn4.text == ""){
                binding.btn4.text = "O"
                checkPlayer=false
                binding.btn4.setTextColor(ContextCompat.getColor(this,R.color.backgroundO))
                if (checkWinner("O")){
                    win_O()
                }
            }else if (!checkPlayer && binding.btn4.text == ""){
                binding.btn4.text = "X"
                checkPlayer=true
                binding.btn4.setTextColor(ContextCompat.getColor(this,R.color.backgroundX))
                if (checkWinner("X")){
                    win_X()
                }
            }
        }
        if(full()){
            alert_No()
            reset()
        }
    }
    fun onBtn_5Clic(view: android.view.View) {
        if (!full()){
            if (checkPlayer && binding.btn5.text == ""){
                binding.btn5.text = "O"
                checkPlayer=false
                binding.btn5.setTextColor(ContextCompat.getColor(this,R.color.backgroundO))
                if (checkWinner("O")){
                    win_O()
                }
            }else if (!checkPlayer && binding.btn5.text == ""){
                binding.btn5.text = "X"
                checkPlayer=true
                binding.btn5.setTextColor(ContextCompat.getColor(this,R.color.backgroundX))
                if (checkWinner("X")){
                    win_X()
                }
            }
        }
        if(full()){
            alert_No()
            reset()
        }
    }
    fun onBtn_6Clic(view: android.view.View) {
        if (!full()){
            if (checkPlayer && binding.btn6.text == ""){
                binding.btn6.text = "O"
                checkPlayer=false
                binding.btn6.setTextColor(ContextCompat.getColor(this,R.color.backgroundO))
                if (checkWinner("O")){
                    win_O()
                }
            }else if (!checkPlayer && binding.btn6.text == ""){
                binding.btn6.text = "X"
                checkPlayer=true
                binding.btn6.setTextColor(ContextCompat.getColor(this,R.color.backgroundX))
                if (checkWinner("X")){
                    win_X()
                }
            }
        }
        if(full()){
            alert_No()
            reset()
        }
    }
    fun onBtn_7Clic(view: android.view.View) {
        if (!full()){
            if (checkPlayer && binding.btn7.text == ""){
                binding.btn7.text = "O"
                checkPlayer=false
                binding.btn7.setTextColor(ContextCompat.getColor(this,R.color.backgroundO))
                if (checkWinner("O")){
                    win_O()
                }
            }else if (!checkPlayer && binding.btn7.text == ""){
                binding.btn7.text = "X"
                checkPlayer=true
                binding.btn7.setTextColor(ContextCompat.getColor(this,R.color.backgroundX))
                if (checkWinner("X")){
                    win_X()
                }
            }
        }
        if(full()){
            alert_No()
            reset()
        }
    }
    fun onBtn_8Clic(view: android.view.View) {
        if (!full()){
            if (checkPlayer && binding.btn8.text == ""){
                binding.btn8.text = "O"
                checkPlayer=false
                binding.btn8.setTextColor(ContextCompat.getColor(this,R.color.backgroundO))
                if (checkWinner("O")){
                    win_O()
                }
            }else if (!checkPlayer && binding.btn8.text == ""){
                binding.btn8.text = "X"
                checkPlayer=true
                binding.btn8.setTextColor(ContextCompat.getColor(this,R.color.backgroundX))
                if (checkWinner("X")){
                    win_X()
                }
            }
        }
        if(full()){
            alert_No()
            reset()
        }
    }
    fun onBtn_9Clic(view: android.view.View) {
        if (!full()){
            if (checkPlayer && binding.btn9.text == ""){
                binding.btn9.text = "O"
                checkPlayer=false
                binding.btn9.setTextColor(ContextCompat.getColor(this,R.color.backgroundO))
                if (checkWinner("O")){
                    win_O()
                }
            }else if (!checkPlayer && binding.btn9.text == ""){
                binding.btn9.text = "X"
                checkPlayer=true
                binding.btn9.setTextColor(ContextCompat.getColor(this,R.color.backgroundX))

                if (checkWinner("X")){
                    win_X()
                }
            }
        }
        if(full()){
            alert_No()
            reset()
        }
    }

    fun reset(){
        checkPlayer = false
        binding.btn1.text = ""
        binding.btn2.text = ""
        binding.btn3.text = ""
        binding.btn4.text = ""
        binding.btn5.text = ""
        binding.btn6.text = ""
        binding.btn7.text = ""
        binding.btn8.text = ""
        binding.btn9.text = ""
    }

    private fun checkWinner(s: String): Boolean{
        //Horizontal Victory
        if(binding.btn1.text.toString() == s && binding.btn2.text.toString() == s && binding.btn3.text.toString() == s) { return true }
        if(binding.btn4.text.toString() == s && binding.btn5.text.toString() == s && binding.btn6.text.toString() == s) { return true }
        if(binding.btn7.text.toString() == s && binding.btn8.text.toString() == s && binding.btn9.text.toString() == s) { return true }

        //Vertical Victory
        if(binding.btn1.text.toString() == s && binding.btn4.text.toString() == s && binding.btn7.text.toString() == s) { return true }
        if(binding.btn2.text.toString() == s && binding.btn5.text.toString() == s && binding.btn8.text.toString() == s) { return true }
        if(binding.btn3.text.toString() == s && binding.btn6.text.toString() == s && binding.btn9.text.toString() == s) { return true }

        //Diagonal Victory
        if(binding.btn1.text.toString() == s && binding.btn5.text.toString() == s && binding.btn9.text.toString() == s) { return true }
        if(binding.btn7.text.toString() == s && binding.btn5.text.toString() == s && binding.btn3.text.toString() == s) { return true }

        return false

    }

    private fun win_O(){

        // do some thing when o winner
        alert_O()
        playerOScore++
        val textViewO = findViewById<TextView>(R.id.player_o_score)
        val textViewX = findViewById<TextView>(R.id.player_x_score)
        if (playerOScore>playerXScore){
            textViewO.text = "Player O Score : $playerOScore  \uD83D\uDE0E \uD83E\uDD73"
            textViewX.text = "Player X Score : $playerXScore  \uD83D\uDC7F"
        }else if (playerOScore<playerXScore){
            textViewO.text = "Player O Score : $playerOScore  \uD83D\uDC7F"
            textViewX.text = "Player X Score : $playerXScore  \uD83D\uDE0E \uD83E\uDD73"
        }else{
            textViewO.text = "Player O Score : $playerOScore  \uD83D\uDC7F"
            textViewX.text = "Player X Score : $playerXScore  \uD83D\uDC7F"
        }
        Handler(Looper.getMainLooper()).postDelayed({
        }, DIALOG_DURATION.toLong())
        // reset
        reset()
    }
    private fun win_X(){

        // do some thing when o winner
        alert_X()
        playerXScore++

        val textViewO = findViewById<TextView>(R.id.player_o_score)
        val textViewX = findViewById<TextView>(R.id.player_x_score)

        if (playerXScore>playerOScore){
            textViewX.text = "Player X Score : $playerXScore  \uD83D\uDE0E \uD83E\uDD73"
            textViewO.text = "Player O Score : $playerOScore  \uD83D\uDC7F"
        }else if (playerXScore<playerOScore){
            textViewX.text = "Player X Score : $playerXScore  \uD83D\uDC7F"
            textViewO.text = "Player O Score : $playerOScore  \uD83D\uDE0E \uD83E\uDD73"
        }
        else{
            textViewX.text = "Player X Score : $playerXScore  \uD83D\uDC7F"
            textViewO.text = "Player O Score : $playerOScore  \uD83D\uDC7F"

        }
        Handler(Looper.getMainLooper()).postDelayed({
        }, DIALOG_DURATION.toLong())
        // reset
        reset()
    }

    private fun full(): Boolean {
        if (binding.btn1.text != ""&& binding.btn2.text != ""&& binding.btn3.text != ""&&
            binding.btn4.text != ""&& binding.btn5.text != ""&& binding.btn6.text != ""&&
            binding.btn7.text != ""&& binding.btn8.text != ""){return true}
        return false
    }


    private fun alert_No() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogno, null)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)

        val dialog = dialogBuilder.create()
        dialog.show()
        // Use Handler to dismiss the dialog after a certain duration
        Handler(Looper.getMainLooper()).postDelayed({
            dialog.dismiss()
        }, DIALOG_DURATION.toLong())

    }
    private fun alert_X() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogx, null)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)

        val dialog = dialogBuilder.create()
        dialog.show()
        // Use Handler to dismiss the dialog after a certain duration
        Handler(Looper.getMainLooper()).postDelayed({
            dialog.dismiss()
        }, DIALOG_DURATION.toLong())

    }
    private fun alert_O() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog, null)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)

        val dialog = dialogBuilder.create()
        dialog.show()
        // Use Handler to dismiss the dialog after a certain duration
        Handler(Looper.getMainLooper()).postDelayed({
            dialog.dismiss()
        }, DIALOG_DURATION.toLong())

    }

    fun onReset_Clic(view: android.view.View) {


        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialogreset, null)
        //dialogView.setBackgroundResource(R.color.backgroundButtonDark)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setPositiveButton("OK") { _, _ ->
                // Do something when the OK button is clicked
                checkPlayer=false
                playerXScore=0
                playerOScore=0
                val textViewO = findViewById<TextView>(R.id.player_o_score)
                val textViewX = findViewById<TextView>(R.id.player_x_score)
                textViewX.text = "Player X Score : $playerXScore  "
                textViewO.text = "Player O Score : $playerOScore  "
                reset()
            }
            .setNegativeButton("Cancel", null)

        val dialog = dialogBuilder.create()



        // Customize the negative button
        dialog.setOnShowListener {
            // Get the positive button and set its style android:background="?attr/colorPrimary"
            val positiveButton = dialog.getButton(Dialog.BUTTON_POSITIVE)
            positiveButton?.setTextColor(resources.getColor(R.color.backgroundButtonLight2))
            // Get the negative button and set its style
            val negativeButton = dialog.getButton(Dialog.BUTTON_NEGATIVE)
            negativeButton?.setTextColor(resources.getColor(R.color.backgroundButtonLight2))

        }



        dialog.show()


    }

}

