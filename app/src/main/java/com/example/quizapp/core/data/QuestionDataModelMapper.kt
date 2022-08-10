package com.example.quizapp.core.data

interface QuestionDataModelMapper<T> {
    fun map(question: String) : T
}