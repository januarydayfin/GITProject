package com.krayapp.gitproject.ui

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.krayapp.gitproject.data.GitUser
import com.krbinayapp.gitproject.ui.OpenedUserFragment

class AndroidScreens:IScreens {
    override fun users() = FragmentScreen {
        UsersFragment.newInstance() }
    override fun openedUser(gitUser: GitUser) = FragmentScreen { OpenedUserFragment.newInstance(gitUser) }
}