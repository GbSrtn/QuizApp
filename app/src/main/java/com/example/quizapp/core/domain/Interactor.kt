package com.example.quizapp.core.domain

import com.example.quizapp.domain.QuestionItem

interface Interactor {
    suspend fun getQuestionItem() : QuestionItem
}