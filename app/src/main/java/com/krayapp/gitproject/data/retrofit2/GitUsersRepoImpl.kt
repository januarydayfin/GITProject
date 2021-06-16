package com.krayapp.gitproject.data.retrofit2

import com.krayapp.gitproject.data.GitRepoList
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GitUsersRepoImpl(val api:IDataSource):IGithubUsersRepo {
    override fun getUsers() = api.getUsers().subscribeOn(Schedulers.io())!!
    override fun getRepoList(login:String) = api.loadRepos(login).subscribeOn(Schedulers.io())!!
}