package com.example.quizapp.domain

import com.example.quizapp.core.data.Repository
import com.example.quizapp.core.domain.Interactor
import java.lang.Exception

class QuestionInteractor(
    private val repository: Repository
) : Interactor {
    override suspend fun getQuestionItem(): QuestionItem {
        try {
            val question = repository.getQuestion().question
            return QuestionItem(question)
        } catch (e: Exception) {
            throw e
        }
    }
}