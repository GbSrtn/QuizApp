package com.example.quizapp.domain

import com.example.quizapp.core.data.QuestionDataModelMapper

class QuestionSuccessMapper : QuestionDataModelMapper<QuizItem.Success>{
    override fun map(
        id: String,
        question: String,
        answers: Pair<List<String>, Int>,
        result: Int
    ) = QuizItem.Success(id, question,answers, result)
}