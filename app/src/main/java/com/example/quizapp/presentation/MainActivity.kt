package com.example.quizapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.example.quizapp.QuizApp
import com.example.quizapp.R

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: QuestionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val questionTextView = findViewById<TextView>(R.id.questiontextView)
        val questionButton = findViewById<Button>(R.id.questionButton)

        val answerButton1 = findViewById<Button>(R.id.answerButton1)
        val answerButton2 = findViewById<Button>(R.id.answerButton2)
        val answerButton3 = findViewById<Button>(R.id.answerButton3)
        val answerButton4 = findViewById<Button>(R.id.answerButton4)

        answerButton1.setOnClickListener(this)
        answerButton2.setOnClickListener(this)
        answerButton3.setOnClickListener(this)
        answerButton4.setOnClickListener(this)

        imageView.setImageResource(R.drawable.ic_baseline_not_started_100)
        progressBar.visibility = View.GONE

        viewModel = (application as QuizApp).questionViewModel

        questionButton.setOnClickListener {
            questionButton.isEnabled = false
            progressBar.visibility = View.VISIBLE
            imageView.visibility = View.GONE
            viewModel.getQuestion()
        }

        viewModel.observer(this,  { (question, id, list) ->
            questionTextView.text = question
            questionButton.isEnabled = true
            progressBar.visibility = View.GONE
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(id)
            Log.d("TAGG", "onCreate: size list ${list.size}")
            answerButton1.text = list[0]
            answerButton2.text = list[1]
            answerButton3.text = list[2]
            answerButton4.text = list[3]

        })
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.answerButton1 -> viewModel.checkAnswer(0)
            R.id.answerButton2 -> viewModel.checkAnswer(1)
            R.id.answerButton3 -> viewModel.checkAnswer(2)
            R.id.answerButton4 -> viewModel.checkAnswer(3)
        }
    }
}