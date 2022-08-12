package com.example.quizapp.core.data

interface QuestionDataModelMapper<T> {
    fun map(id: String ,question: String, answers: Pair<List<String>, Int>, result: Int): T
}