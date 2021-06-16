package com.krayapp.gitproject.data.retrofit2

import com.krayapp.gitproject.data.GitRepoList
import com.krayapp.gitproject.data.GitUser
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<List<GitUser>>
    fun getRepoList(login:String):Single<List<GitRepoList>>
}