package com.example.quizapp

import android.app.Application
import com.example.quizapp.data.BaseReposiroty
import com.example.quizapp.data.net.QuestionCloudDataSource
import com.example.quizapp.data.net.QuestionService
import com.example.quizapp.domain.QuestionInteractor
import com.example.quizapp.domain.QuestionSuccessMapper
import com.example.quizapp.presentation.BaseCommunication
import com.example.quizapp.presentation.QuestionViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class QuizApp : Application() {

    lateinit var questionViewModel : QuestionViewModel

    override fun onCreate() {
        super.onCreate()

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.google.ru/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val cloudDataSource = QuestionCloudDataSource(retrofit.create(QuestionService::class.java))
        val repository = BaseReposiroty(cloudDataSource)
        val mapper = QuestionSuccessMapper()
        val interactor = QuestionInteractor(repository, mapper)



        questionViewModel = QuestionViewModel(interactor, BaseCommunication())
    }
}