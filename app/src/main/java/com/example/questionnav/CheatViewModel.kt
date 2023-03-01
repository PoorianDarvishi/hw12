package com.example.questionnav

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CheatViewModel : ViewModel(), DefaultLifecycleObserver {
    private val text = "Are you suer you want to do dis?"
    private var answer = ""
    var textLive = MutableLiveData(text)

    fun setAnswer(answer: String) {
        this.answer = answer
    }

    fun showAnswer() {
        textLive.value = answer
    }

    fun resetText() {
        textLive.value = text
    }

    override fun onPause(owner: LifecycleOwner) {
        resetText()
        super.onPause(owner)
    }

}