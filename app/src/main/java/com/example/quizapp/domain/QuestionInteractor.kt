package com.example.quizapp.domain

import com.example.quizapp.core.data.Repository
import com.example.quizapp.core.domain.Interactor
import java.lang.Exception

class QuestionInteractor(
    private val repository: Repository
) : Interactor {
    override suspend fun getQuestionItem(): QuizItem {
        try {
            val item = repository.getQuestion()
            return QuizItem.Success(item.question, item.correctAnswer,item.incorrectAnswerList)
        } catch (e: Exception) {
            throw e
        }
    }

    //todo make proper changeButtonStatus
    override suspend fun changeButtonStatus(id: Int): QuizItem {
        return try {
            val item = repository.getCached()
            when (id) {
                1 -> QuizItem.Success(item.question, "1", item.incorrectAnswerList)
                2 -> QuizItem.Success(item.question, item.correctAnswer, listOf("2" , item.incorrectAnswerList[1] , item.incorrectAnswerList[2]))
                3 -> QuizItem.Success(item.question,item.correctAnswer, listOf(item.incorrectAnswerList[0] , "3" , item.incorrectAnswerList[2]))
                else -> QuizItem.Success(item.question,item.correctAnswer, listOf(item.incorrectAnswerList[0] , item.incorrectAnswerList[1] , "4"))
            }
        } catch (e: Exception) {
            throw e
        }
    }
}