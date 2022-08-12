package com.example.quizapp.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.quizapp.presentation.State

interface BaseViewModel {
    fun getQuestion()
    fun observer(owner: LifecycleOwner, observer: Observer<Triple<String,Int, List<String>>>)
    fun checkAnswer(buttonId: Int)
}