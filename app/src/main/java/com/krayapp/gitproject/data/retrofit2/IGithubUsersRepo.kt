package com.krayapp.gitproject.data.retrofit2

import com.krayapp.gitproject.data.GitUser
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<List<GitUser>>
}