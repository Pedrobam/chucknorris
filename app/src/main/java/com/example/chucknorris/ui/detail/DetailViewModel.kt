package com.example.chucknorris.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chucknorris.ChuckNorrisRepository
import com.example.chucknorris.model.Joke
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: ChuckNorrisRepository) : ViewModel() {

    private val _joke = MutableLiveData<Joke>()
    val joke: LiveData<Joke> = _joke

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getJoke(category: String) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                _joke.value = repository.random(category)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}