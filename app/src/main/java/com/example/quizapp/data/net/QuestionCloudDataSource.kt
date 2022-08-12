package com.example.quizapp.data.net

import android.util.Log
import com.example.quizapp.core.data.net.CloudDataSource

class QuestionCloudDataSource(
    private val service: QuestionService
) : CloudDataSource {

    override fun getQuestion(): QuestionServerModel {
        try {
            val model = service.getQuestion().execute().body()!![0]
            Log.d("TAGG", "getQuestion: ${model.question}")
            return model

        } catch (e : Exception) {
            throw e
        }
    }
}