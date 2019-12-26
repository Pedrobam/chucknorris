package com.example.chucknorris

import com.example.chucknorris.ui.detail.DetailViewModel
import com.example.chucknorris.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}