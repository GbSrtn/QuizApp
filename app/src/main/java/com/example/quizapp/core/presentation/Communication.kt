package com.example.quizapp.core.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.quizapp.presentation.State

interface Communication {
    fun showState(text : String)

    fun observe(owner: LifecycleOwner, observer: Observer<String>)

    //fun isState(type: Int) : Boolean
}