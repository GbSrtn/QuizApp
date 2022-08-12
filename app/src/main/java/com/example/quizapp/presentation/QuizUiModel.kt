package com.example.quizapp.presentation

class QuizUiModel(
    private val question: String,
    private val correctAnswer : String,
    private val incorrectAnswers : List<String>
) {
    fun getQuestion() = question
    fun getCorrectAnswer() = correctAnswer
    fun getIncorrectAnswers() = incorrectAnswers

    private var allAnswers = incorrectAnswers + correctAnswer

    fun getQuiz() = Triple(question, 0, listOf(correctAnswer) + incorrectAnswers)
}