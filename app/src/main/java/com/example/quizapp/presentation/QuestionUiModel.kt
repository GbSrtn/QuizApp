package com.example.quizapp.presentation

import com.example.quizapp.core.presentation.Communication

class QuestionUiModel(private val question : String) {

    fun getQuestion() = question

    //fun show(communication: Communication) = communication.showState(State.Initial(question))

}
