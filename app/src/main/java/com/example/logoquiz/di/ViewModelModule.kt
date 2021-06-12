package com.example.logoquiz.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.airtelassignment.di.ApiScope
import com.example.airtelassignment.presentation.base.ViewModelKey
import com.example.logoquiz.di.ViewModelProviderFactory
import com.example.logoquiz.data.LogoQuizRepository
import com.example.logoquiz.view.viewmodel.GetQuizDataViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@ApiScope
@Module
abstract class ViewModelModule {

    @Binds
    @ApiScope
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ApiScope
    @ViewModelKey(GetQuizDataViewModel::class)
    internal abstract fun getQuizDataViewModel(viewModel: GetQuizDataViewModel) : ViewModel
}