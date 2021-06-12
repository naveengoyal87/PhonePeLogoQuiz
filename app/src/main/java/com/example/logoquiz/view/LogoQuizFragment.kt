package com.example.logoquiz.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.logoquiz.R
import com.example.logoquiz.di.DaggerLogoQuizComponent
import com.example.logoquiz.di.ViewModelProviderFactory
import com.example.logoquiz.util.constants.alphabets
import com.example.logoquiz.view.adapter.LogoQuizAdapter
import com.example.logoquiz.view.viewmodel.GetQuizDataViewModel
import kotlinx.android.synthetic.main.fragment_logo_quiz.*
import javax.inject.Inject

class LogoQuizFragment : Fragment() {

    var suggestSource: ArrayList<String> = ArrayList()

    private lateinit var  viewModel: GetQuizDataViewModel

    lateinit var adapter: LogoQuizAdapter

    @Inject
    lateinit var viewModelProvider: ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val apiComponent = DaggerLogoQuizComponent.builder().context(requireContext()).build()
        apiComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelProvider).get(GetQuizDataViewModel::class.java)
        observeData()
    }

    private fun observeData() {
        viewModel.getQuizData().observe(this, {

            val responseItem =
                it.logoList?.get(viewModel.getQuizState().value?.currentQuestion ?: 0)
            Glide.with(requireContext()).load(responseItem?.imgUrl).apply(
                RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC)
            ).into(logo_image)
            initSuggestSource(responseItem?.name ?: "")
        })
    }


    private fun initSuggestSource(name: String) {
        suggestSource.clear()
        for (i in name.toCharArray()) {
            suggestSource.add(i.toString())
        }
        val random = java.util.Random()

        for (i in name.length until name.length * 2) {
            suggestSource.add(alphabets[random.nextInt(alphabets.size)])
        }

        adapter = LogoQuizAdapter(context, suggestSource)
        answer_view.layoutManager = GridLayoutManager(context, 10)
        adapter.notifyDataSetChanged()
        answer_view.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_logo_quiz, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() = LogoQuizFragment()
    }
}