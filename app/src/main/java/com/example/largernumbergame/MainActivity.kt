package com.example.largernumbergame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.largernumbergame.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        assignNumToButtons()
        binding.buttonL.setOnClickListener {
            checkAnswer(true)
            assignNumToButtons()
        }

        binding.buttonR.setOnClickListener {
            checkAnswer(false)
            assignNumToButtons()
        }

    }

    private fun checkAnswer(isLeftButton: Boolean) {
        val leftNumber = binding.buttonL.text.toString().toInt()
        val rightNumber = binding.buttonR.text.toString().toInt()
        val isAnswerCorrect: Boolean = if (isLeftButton) leftNumber > rightNumber else rightNumber > leftNumber
        if (isAnswerCorrect) {
            binding.backgroundView.setBackgroundColor(Color.CYAN)

            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
        } else {
            binding.backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()

        }
    }


    private fun assignNumToButtons() {
        val random = Random()
        val leftNumber = random.nextInt(10)
        var rightNumber = leftNumber
        while (rightNumber == leftNumber) {
            rightNumber = random.nextInt(10)
        }
        binding.buttonL.text = leftNumber.toString()
        binding.buttonR.text = rightNumber.toString()

    }
}