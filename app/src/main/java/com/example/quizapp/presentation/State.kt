package com.example.quizapp.presentation

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.example.quizapp.R

sealed class State {
    protected abstract val type: Int

    companion object {
        const val PROGRESS = 1
        const val INITIAL = 2
        const val FAILED = 3
    }

    fun isType(type: Int) : Boolean = type == this.type


    fun show(
        questionText : TextView,
        progress : ProgressBar
    ) {
        show(questionText)
        show(progress)
    }

    protected open fun show(questionText : TextView) {}
    protected open fun show(progress : ProgressBar) {}

    object Progress : State() {
        override val type = PROGRESS

        //как получить контекст сюда? \/
        @SuppressLint("SetTextI18n")
        override fun show(questionText: TextView) {
            questionText.text = "Searching for question"
        }

        override fun show(progress: ProgressBar) {
            progress.visibility = View.VISIBLE
        }
    }

    class Initial(private val text: String) : State() {
        override val type = INITIAL

        override fun show(questionText: TextView) {
            questionText.text = text
        }

        override fun show(progress: ProgressBar) {
            progress.visibility = View.GONE
        }
    }
}