package com.example.quizapp.data.net

import android.util.Log
import com.example.quizapp.core.Mapper
import com.example.quizapp.core.data.QuestionDataModelMapper
import com.example.quizapp.data.QuestionDataModel
import com.example.quizapp.domain.QuizItem
import com.google.gson.annotations.SerializedName

data class QuestionServerModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("correctAnswer")
    val correctAnswer : String,
    @SerializedName("incorrectAnswers")
    val incorrectAnswerList: List<String>,
    @SerializedName("question")
    val question: String
) : Mapper<QuestionDataModel>{
    private fun randomizeAnswers() : Pair<List<String>, Int> {
        val answers = (listOf(this.correctAnswer) + this.incorrectAnswerList).shuffled()
        Log.d("TAGG", "randomizeAnswers: $answers")
        Log.d("TAGG", "randomizeAnswers: ${answers.indexOf(this.correctAnswer)}")
        return Pair(answers, answers.indexOf(this.correctAnswer))

    }

    override fun to() = QuestionDataModel(id, question, randomizeAnswers(), -1)
}