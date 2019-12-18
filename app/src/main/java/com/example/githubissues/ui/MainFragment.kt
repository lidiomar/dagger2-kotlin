package com.example.githubissues.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.githubissues.R
import com.example.githubissues.databinding.FragmentMainBinding
import com.example.githubissues.model.Issue
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel
    lateinit var bind : FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return bind.root
    }

    override fun onResume() {
        super.onResume()
        setupSwipeRefresh()
        loadIssues()
    }

    private fun setupSwipeRefresh(){
        bind.swiperefresh.setOnRefreshListener {
            loadIssues()
            bind.swiperefresh.isRefreshing = false
        }
    }

    private fun loadIssues(){
        showProgressbar()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.loadIssues()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ issueList ->
                setupRecyclerView(issueList)
            }, {e ->
                showErrorMessage(resources.getString(R.string.an_error_was_ocured))
            })
    }

    private fun setupRecyclerView(issueList: List<Issue>){
        bind.issuesRecyclerview.adapter = MainAdapter(issueList)
        showRecyclerView()
    }

    private fun showProgressbar(){
        bind.issuesRecyclerview.visibility = View.GONE
        bind.progressbar.visibility = View.VISIBLE
        bind.message.visibility = View.GONE
    }

    private fun showErrorMessage(message: String?){
        bind.issuesRecyclerview.visibility = View.GONE
        bind.progressbar.visibility = View.GONE
        bind.message.visibility = View.VISIBLE
        bind.message.text = message
    }

    private fun showRecyclerView(){
        bind.issuesRecyclerview.visibility = View.VISIBLE
        bind.progressbar.visibility = View.GONE
        bind.message.visibility = View.GONE
    }
}