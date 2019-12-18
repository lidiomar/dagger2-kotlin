package com.example.githubissues.ui

import androidx.lifecycle.ViewModel
import com.example.githubissues.model.Issue
import com.example.githubissues.network.MainApi
import io.reactivex.Observable
import javax.inject.Inject

class MainViewModel @Inject constructor(val mainApi: MainApi) : ViewModel() {

    fun loadIssues() : Observable<List<Issue>>{
        return mainApi.getIssues()
    }
}