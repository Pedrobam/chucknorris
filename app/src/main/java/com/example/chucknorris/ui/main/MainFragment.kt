package com.example.chucknorris.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.chucknorris.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

	private lateinit var viewModel: MainViewModel

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		return inflater.inflate(R.layout.main_fragment, container, false)
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
		configObserverCategories()
	}

	private fun configObserverCategories() {
		viewModel.categories.observe(this, Observer {
			recycler_view_category.adapter = CategoryAdapter(it)
		})
	}

}
