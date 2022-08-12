package com.example.quizapp.presentation

import androidx.annotation.DrawableRes
import com.example.quizapp.R

abstract class QuizUiModel(
    private val question: String,
    private val answers: List<String>
) {

    @DrawableRes
    abstract fun getIconResId() : Int

    fun getQuiz() = Triple(question, getIconResId(), answers)
}

class BaseQuizUiModel(question: String, answers: List<String>) :
        QuizUiModel(question, answers) {
    override fun getIconResId() = R.drawable.ic_baseline_question_mark_100
}

class CorrectQuizUiModel(question: String, answers: List<String>) :
        QuizUiModel(question,answers) {
    override fun getIconResId() = R.drawable.ic_baseline_correct_100
}

class IncorrectQuizUiModel(question: String, answers: List<String>) :
        QuizUiModel(question,answers) {
    override fun getIconResId() = R. drawable.ic_baseline_wrong_100
}

class FailedQuizUiModel(failedText: String) :
        QuizUiModel(failedText, listOf("")) {
    override fun getIconResId() = R.drawable.ic_baseline_failed_100
}
