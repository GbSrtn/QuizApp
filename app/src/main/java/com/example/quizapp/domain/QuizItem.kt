package com.example.quizapp.domain

import com.example.quizapp.core.Mapper
import com.example.quizapp.presentation.*
//import com.example.quizapp.presentation.QuestionUiModel

sealed class QuizItem : Mapper<QuizUiModel> {

    class Success(
        val id : String,
        val question : String,
        val answers : Pair<List<String>,Int>,
        val result : Int
    ) : QuizItem() {
        override fun to() = if (result == -1) {
            BaseQuizUiModel(question, answers.first)
        } else if (result == answers.second) {
            CorrectQuizUiModel(question, answers.first)
        } else {
            IncorrectQuizUiModel(question, answers.first)
        }
    }

    class Failed(private val failedText: String) : QuizItem() {
        override fun to() = FailedQuizUiModel(failedText)
    }
}



