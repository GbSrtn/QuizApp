package com.example.quizapp.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.core.data.Repository
import com.example.quizapp.core.domain.Interactor
import com.example.quizapp.core.presentation.BaseViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuestionViewModel(
    private val interactor: Interactor,
    private val communication: BaseCommunication,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main

) : ViewModel(), BaseViewModel {
    override fun getQuestion() {
        viewModelScope.launch(dispatcher) {
            communication.showState(interactor.getQuestionItem().to().getQuestion())
        }
    }

    override fun observer(owner: LifecycleOwner, observer: Observer<String>) {
        communication.observe(owner,observer)
    }


}