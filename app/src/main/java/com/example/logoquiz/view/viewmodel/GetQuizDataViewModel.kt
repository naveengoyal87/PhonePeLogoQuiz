package com.example.logoquiz.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.logoquiz.data.LogoQuizRepository
import com.example.logoquiz.data.model.GameState
import com.example.logoquiz.data.model.LogoResponse
import javax.inject.Inject

class GetQuizDataViewModel @Inject constructor(private val repo: LogoQuizRepository) : ViewModel() {

    private val state: LiveData<GameState> = MutableLiveData()

    private val quizdata: MutableLiveData<LogoResponse> = MutableLiveData()

    init {
        quizdata.value = repo.readData()
        state.value?.apply {
            questionsCount = quizdata.value?.logoList?.size ?: 0
            currentQuestion = 1
        }
    }

    fun getQuizData(): LiveData<LogoResponse> {
        return quizdata
    }

    fun getQuizState(): LiveData<GameState> {
        return state
    }
}