package com.example.quizapp.core.data

import com.example.quizapp.data.net.QuestionDataModel

interface Repository {
    suspend fun getQuestion() : QuestionDataModel
    suspend fun getCached() : QuestionDataModel
}