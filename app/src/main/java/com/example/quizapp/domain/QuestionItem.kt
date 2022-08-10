package com.example.quizapp.domain

import com.example.quizapp.core.Mapper
import com.example.quizapp.presentation.QuestionUiModel

class QuestionItem(
    private val question: String
) : Mapper<QuestionUiModel> {

    override fun to() = QuestionUiModel(question)
}