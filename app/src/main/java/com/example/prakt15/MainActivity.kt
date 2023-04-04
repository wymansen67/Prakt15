package com.example.prakt15

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.prakt15.R

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextBaton: Button
    private lateinit var backBaton: Button
    private lateinit var questionTextVid: TextView
    private var questionBottle = listOf(
        Question(R.string.q1, true),
        Question(R.string.q2, true),
        Question(R.string.q3, true),
        Question(R.string.q4, true)
    )
    private var currentNumber = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextBaton = findViewById(R.id.next_baton)
        backBaton = findViewById(R.id.back_baton)
        questionTextVid = findViewById(R.id.voprosi)
        trueButton.setOnClickListener { view: View ->
            //Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
            Toast.LENGTH_SHORT
            checkAnswer(true)
        }
        falseButton.setOnClickListener { view: View ->
            //Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
            Toast.LENGTH_SHORT
            checkAnswer(false)
        }
        val questionTextResId = questionBottle[currentNumber].textResId
        questionTextVid.setText(questionTextResId)
        nextBaton.setOnClickListener {currentNumber = (currentNumber + 1) % questionBottle.size
            updateQuestion()
        }
        updateQuestion()
        backBaton.setOnClickListener {currentNumber = (currentNumber - 1) % questionBottle.size
            updateQuestion()
        }
        updateQuestion()
    }
    private fun updateQuestion(){
        val questionTextResId = questionBottle[currentNumber].textResId
        questionTextVid.setText(questionTextResId)
    }
    private fun checkAnswer (userAnswer: Boolean) {
        val correctAnswer = questionBottle[currentNumber].answer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast}
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }


    }
