package com.avionmission.biggernumberwwcode

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLeft.setOnClickListener {
            checkAnswer(true)
            assignNumbersToButtons()
        }

        btnRight.setOnClickListener {
            checkAnswer(false)
            assignNumbersToButtons()
        }

    }

    private fun checkAnswer(isLeftButtonSelected: Boolean){
        val leftNum : Int = btnLeft.text.toString().toInt()
        val rightNum : Int = btnRight.text.toString().toInt()
        val isAnswerCorrect:Boolean = if (isLeftButtonSelected) leftNum > rightNum else rightNum > leftNum
        if (isAnswerCorrect) {
            // Correct
            // Change Background Color
            backgroundView.setBackgroundColor(Color.CYAN)
            // Show a toast
            Toast.makeText(this,"Correct", Toast.LENGTH_SHORT).show()
        } else {
            // Change Background Color
            backgroundView.setBackgroundColor(Color.RED)
            // Show a toast
            Toast.makeText(this,"Wrong!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignNumbersToButtons() {
        val r = Random()
        val leftNum: Int = r.nextInt(10)
        var rightNum: Int = leftNum

        while (rightNum == leftNum) {
            rightNum = r.nextInt(10)
        }

        btnLeft.text = leftNum.toString()
        btnRight.text = rightNum.toString()
    }
}