package com.example.quizapp.core.data

import com.example.quizapp.data.QuestionDataModel

interface Repository {
    suspend fun getQuestion() : QuestionDataModel
    suspend fun getCached(result: Int) : QuestionDataModel
}