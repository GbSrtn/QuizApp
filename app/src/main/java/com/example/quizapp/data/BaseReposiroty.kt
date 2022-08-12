package com.example.quizapp.data

import android.util.Log
import com.example.quizapp.core.data.Repository
import com.example.quizapp.core.data.net.CloudDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BaseReposiroty(
    private val cloudDataSource: CloudDataSource
) : Repository {
    //todo make Empty QuestionDataModel
    private var cached : QuestionDataModel = QuestionDataModel("", "", Pair( listOf(""), -1), -2)

    override suspend fun getQuestion(): QuestionDataModel = withContext(Dispatchers.IO) {
        try {
            val data = cloudDataSource.getQuestion().to()
            cached = data
            return@withContext data
        } catch (e: Exception) {
            cached = QuestionDataModel("", "", Pair( listOf(""), -1), -2)
            throw e
        }
    }

    override suspend fun getCached(result: Int) = cached.changeCached(result)
}