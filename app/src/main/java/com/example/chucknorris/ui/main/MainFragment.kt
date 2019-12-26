package com.example.chucknorris.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.chucknorris.R
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val mViewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configObserverCategories()
    }

    private fun configObserverCategories() {
        mViewModel.categories.observe(this, Observer {
            recycler_view_category.adapter = CategoryAdapter(it) { category ->
                openDetail(category)
            }
        })
    }

    private fun openDetail(category: String) {
        view?.let {
            val nextAction =
                MainFragmentDirections.actionMainFragmentToDetailFragment(category)
            Navigation.findNavController(it).navigate(nextAction)
        }
    }
}