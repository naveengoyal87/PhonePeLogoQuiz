package com.example.logoquiz.di

import android.content.Context
import com.example.airtelassignment.di.ApiScope
import com.example.logoquiz.view.LogoQuizFragment
import com.example.logoquiz.view.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApiScope
@Component(modules = [LogoQuizModule::class, ViewModelModule::class])
interface LogoQuizComponent {

    fun inject(fragment: LogoQuizFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context) : Builder
        fun build() : LogoQuizComponent
    }
}