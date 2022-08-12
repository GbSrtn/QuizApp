package com.example.quizapp.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.quizapp.core.presentation.Communication

class BaseCommunication : Communication {

    private val liveData = MutableLiveData<Triple<String,Int, List<String>>>()

    override fun showState(data: Triple<String,Int, List<String>>) {
        liveData.value = data
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<Triple<String,Int, List<String>>>) {
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