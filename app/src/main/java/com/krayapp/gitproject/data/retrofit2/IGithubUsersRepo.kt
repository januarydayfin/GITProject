package com.krayapp.gitproject.data.retrofit2

import com.krayapp.gitproject.data.gituserinfo.AboutUserRepo
import com.krayapp.gitproject.data.gituserinfo.GitRepoList
import com.krayapp.gitproject.data.gituserinfo.GitUser
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<List<GitUser>>
    fun getRepoList(login:String):Single<List<GitRepoList>>
    fun loadRepoForks(login: String, repoName:String) : Single<AboutUserRepo>
}