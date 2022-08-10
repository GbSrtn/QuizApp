package com.example.quizapp.data

import com.example.quizapp.core.data.Repository
import com.example.quizapp.core.data.net.CloudDataSource
import com.example.quizapp.data.net.QuestionDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BaseReposiroty(
    private val cloudDataSource: CloudDataSource
) : Repository {

    override suspend fun getQuestion(): QuestionDataModel = withContext(Dispatchers.IO) {
        try {
            return@withContext cloudDataSource.getQuestion()
        } catch (e: Exception) {
            throw e
        }
    }
}