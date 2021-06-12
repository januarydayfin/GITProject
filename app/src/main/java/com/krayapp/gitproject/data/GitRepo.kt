package com.krayapp.gitproject.data

import io.reactivex.rxjava3.core.Observable


class GitRepo {
    fun repositories():Observable<GitUser> {
        return Observable.fromIterable(mutableListOf(
            GitUser("login1"),
            GitUser("login2"),
            GitUser("login3"),
            GitUser("login4"),
            GitUser("login5"))
        )
    }
}