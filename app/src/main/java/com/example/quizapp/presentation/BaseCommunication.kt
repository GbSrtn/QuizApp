package com.example.quizapp.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.quizapp.core.presentation.Communication

class BaseCommunication : Communication {

    private val liveData = MutableLiveData<String>()

    override fun showState(text: String) {
        liveData.value = text
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<String>) {
        liveData.observe(owner, observer)
    }

//    override fun showState(state: State) {
//        liveData.value = state
//    }
//
//    override fun observe(owner: LifecycleOwner, observer: Observer<State>) {
//        liveData.observe(owner, observer)
//    }
//
//    override fun isState(type: Int): Boolean {
//        return liveData.value?.isType(type) ?: false
//    }
}