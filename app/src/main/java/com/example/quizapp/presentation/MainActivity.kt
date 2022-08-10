package com.example.quizapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.example.quizapp.QuizApp
import com.example.quizapp.R
import com.example.quizapp.data.BaseReposiroty
import com.example.quizapp.data.net.QuestionCloudDataSource
import com.example.quizapp.data.net.QuestionService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: QuestionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val questionTextView = findViewById<TextView>(R.id.questiontextView)
        val questionButton = findViewById<Button>(R.id.questionButton)

        imageView.setImageResource(R.drawable.baseline_not_started_50)
        progressBar.visibility = View.GONE

        viewModel = (application as QuizApp).questionViewModel

        questionButton.setOnClickListener {
            questionButton.isEnabled = false
            progressBar.visibility = View.VISIBLE
            viewModel.getQuestion()
            imageView.visibility = View.GONE
        }

        viewModel.observer(this,  { question ->
            questionTextView.text = question
            questionButton.isEnabled = true
            progressBar.visibility = View.GONE
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.baseline_question_mark_50)
        })

    }
}