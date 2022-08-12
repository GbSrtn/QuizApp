package com.example.quizapp.core.data.net

import com.example.quizapp.data.net.QuestionServerModel

interface CloudDataSource {
    fun getQuestion() : QuestionServerModel
}