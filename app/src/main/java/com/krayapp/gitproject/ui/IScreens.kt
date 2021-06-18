package com.krayapp.gitproject.ui

import com.github.terrakok.cicerone.Screen
import com.krayapp.gitproject.data.gituserinfo.AboutUserRepo
import com.krayapp.gitproject.data.gituserinfo.GitUser

interface IScreens {
    fun users(): Screen
    fun openedUser(gitUser: GitUser): Screen
    fun aboutUserRepo(aboutUserRepo: AboutUserRepo):Screen
}