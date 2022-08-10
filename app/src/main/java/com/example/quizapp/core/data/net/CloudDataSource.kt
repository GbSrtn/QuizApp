package com.example.quizapp.core.data.net

import com.example.quizapp.data.net.QuestionDataModel

interface CloudDataSource {
    fun getQuestion() : QuestionDataModel
}