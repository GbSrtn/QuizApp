package com.example.quizapp.core.domain


import com.example.quizapp.domain.QuizItem

interface Interactor {
    suspend fun getQuestionItem() : QuizItem
    suspend fun changeButtonStatus(id : Int) : QuizItem
}