package com.example.chucknorris.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chucknorris.ChuckNorrisRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainViewModel : ViewModel(), KoinComponent {

	private val chuckNorrisRepository: ChuckNorrisRepository by inject()

	private val _categories = MutableLiveData<List<String>>()
	val categories: LiveData<List<String>> = _categories

	init {
		_categories.value = listOf(
			"animal",
			"career",
			"celebrity",
			"dev",
			"explicit",
			"fashion",
			"food",
			"history",
			"money",
			"movie",
			"music",
			"political",
			"religion",
			"science",
			"sport",
			"travel"
		)
	}
}
