package com.example.quizapp.data.net

import com.google.gson.annotations.SerializedName

data class QuestionDataModel(
    @SerializedName("id")
    val id: String,
    @SerializedName("correctAnswer")
    val correctAnswer : String,
    @SerializedName("incorrectAnswers")
    val incorrectAnswerList: List<String>,
    @SerializedName("question")
    val question: String
) {
}