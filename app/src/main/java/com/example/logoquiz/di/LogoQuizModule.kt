package com.example.logoquiz.di

import android.content.Context
import com.example.airtelassignment.di.ApiScope
import com.example.logoquiz.data.LogoQuizRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LogoQuizModule {

    @Provides
    @ApiScope
    fun getRepository(context: Context): LogoQuizRepository {
        return LogoQuizRepository(context)
    }
}