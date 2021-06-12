package com.example.logoquiz.data

import android.content.Context
import com.example.logoquiz.data.model.LogoResponse

class LogoQuizRepository constructor(private val context: Context) {

    fun readData(): LogoResponse {
        return LogoQuizDataRetriver.getLogoData(context)
    }
}