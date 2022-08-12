package com.example.quizapp.domain

import com.example.quizapp.core.data.QuestionDataModelMapper
import com.example.quizapp.core.data.Repository
import com.example.quizapp.core.domain.Interactor
import java.lang.Exception

class QuestionInteractor(
    private val repository: Repository,
    private val mapper : QuestionDataModelMapper<QuizItem.Success>

) : Interactor {
    override suspend fun getQuestionItem(): QuizItem {
        try {
            val item = repository.getQuestion()
            return item.map(mapper)
        } catch (e: Exception) {
            throw e
        }
    }

    //todo make proper changeButtonStatus
    override suspend fun changeButtonStatus(id: Int): QuizItem {
        return try {
                repository.getCached(id).map(mapper)
            } catch (e: Exception) {
                throw e
            }
    }
}