package com.krayapp.gitproject.data

class GitRepo {
    private val repositories = mutableListOf(
        GitUser("login1"),
        GitUser("login2"),
        GitUser("login3"),
        GitUser("login4"),
        GitUser("login5")
    )

    fun getUsers(): List<GitUser>{
        return repositories
    }

    fun createNewUser(){
        repositories.add(GitUser("loginNew"))
    }
}