package com.example.githubissues.network

import com.example.githubissues.model.Issue
import io.reactivex.Observable
import retrofit2.http.GET

interface MainApi {
    @GET("issues")
    fun getIssues() : Observable<List<Issue>>
}