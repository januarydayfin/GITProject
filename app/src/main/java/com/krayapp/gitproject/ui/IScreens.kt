package com.krayapp.gitproject.ui

import com.github.terrakok.cicerone.Screen
import com.krayapp.gitproject.data.GitUser

interface IScreens {
    fun users(): Screen
    fun openedUser(gitUser: GitUser): Screen
}