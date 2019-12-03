package com.example.chucknorris.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chucknorris.ChuckNorrisRepository
import kotlinx.coroutines.launch

class MainViewModel(private val chuckNorrisRepository: ChuckNorrisRepository) : ViewModel() {

    private val _categories = MutableLiveData<List<String>>()
    val categories: LiveData<List<String>> = _categories

    init {
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch {
            try {
                _categories.value = chuckNorrisRepository.getCategory()
            } catch (e: Exception) {
                Log.e("Error", e.message)
            }
        }
    }
}
