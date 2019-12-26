package com.example.chucknorris.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.chucknorris.R
import kotlinx.android.synthetic.main.detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private val mViewModel: DetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val category = DetailFragmentArgs.fromBundle(it).category
            txv_category.text = category
            mViewModel.getJoke(category)
        }
        configObserverLoading()
        configObserverJoke()
    }

    private fun configObserverLoading() {
        mViewModel.isLoading.observe(this, Observer { isLoading ->
            progressBar.visibility = if (isLoading) {
                View.VISIBLE
            } else {
                View.GONE
            }
        })
    }

    private fun configObserverJoke() {
        mViewModel.joke.observe(this, Observer { joke ->
            txv_joke_value.text = joke.value
            Glide.with(this).load(joke.icon_url).into(img_icon_url)
        })
    }
}