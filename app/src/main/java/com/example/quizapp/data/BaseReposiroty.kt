package com.example.quizapp.data

import com.example.quizapp.core.data.Repository
import com.example.quizapp.core.data.net.CloudDataSource
import com.example.quizapp.data.net.QuestionDataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BaseReposiroty(
    private val cloudDataSource: CloudDataSource
) : Repository {
    //todo make Empty QuestionDataModel
    private var cached : QuestionDataModel = QuestionDataModel("", "",listOf("",""),"")

    override suspend fun getQuestion(): QuestionDataModel = withContext(Dispatchers.IO) {
        try {
            val data = cloudDataSource.getQuestion()
            cached = data
            return@withContext data
        } catch (e: Exception) {
            cached = QuestionDataModel("", "",listOf("",""),"exception!!!!")
            throw e
        }
    }

    override suspend fun getCached(): QuestionDataModel {
        return cached
    }
}