package com.krayapp.gitproject.data.retrofit2

import io.reactivex.rxjava3.schedulers.Schedulers

class GitUsersRepoImpl(val api:IDataSource):IGithubUsersRepo {
    override fun getUsers() = api.getUsers().subscribeOn(Schedulers.io())!!
}