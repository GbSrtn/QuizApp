package com.example.quizapp.data.net

import retrofit2.Call
import retrofit2.http.GET

interface QuestionService {
    @GET("https://the-trivia-api.com/api/questions?categories=history&limit=1&difficulty=medium")
    fun getQuestion() : Call<List<QuestionServerModel>>
}