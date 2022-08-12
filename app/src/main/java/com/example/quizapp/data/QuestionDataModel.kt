package com.example.quizapp.data

import com.example.quizapp.core.data.QuestionDataModelMapper

class QuestionDataModel(
    private val id: String,
    private val question: String,
    private val answers: Pair<List<String>,Int>,
    private val result: Int = -1
) {
    fun changeCached(res: Int) = QuestionDataModel(id,question,answers, res)

    fun <T> map(mapper: QuestionDataModelMapper<T>) : T {
        return mapper.map(id,question,answers,result)
    }
}