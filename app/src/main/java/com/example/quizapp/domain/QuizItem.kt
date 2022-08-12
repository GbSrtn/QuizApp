package com.example.quizapp.domain

import com.example.quizapp.core.Mapper
//import com.example.quizapp.presentation.QuestionUiModel
import com.example.quizapp.presentation.QuizUiModel

sealed class QuizItem : Mapper<QuizUiModel> {

    class Success(
        val question : String,
        val correctAnswer : String,
        val incorrectAnswers : List<String>
    ) : QuizItem() {

        override fun to() =  QuizUiModel(question, correctAnswer, incorrectAnswers)
    }
}



