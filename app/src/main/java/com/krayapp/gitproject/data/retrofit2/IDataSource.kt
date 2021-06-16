package com.krayapp.gitproject.data.retrofit2

import com.krayapp.gitproject.data.GitRepoList
import com.krayapp.gitproject.data.GitUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IDataSource {
    @GET("/users")
    fun getUsers(): Single<List<GitUser>>

    @GET("users/{login}")
    fun loadUser(@Path("login")login:String):Single<GitUser>

    @GET("users/{login}/repos")
    fun loadRepos(@Path("login")login:String):Single<List<GitRepoList>>
}