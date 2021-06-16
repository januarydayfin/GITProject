package com.krayapp.gitproject.ui

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.krayapp.gitproject.data.GitUser
import com.krayapp.gitproject.ui.list.UsersFragment
import com.krayapp.gitproject.ui.openedUser.OpenedUserFragment

class AndroidScreens:IScreens {
    override fun users() = FragmentScreen {
        UsersFragment.newInstance() }
    override fun openedUser(gitUser: GitUser) = FragmentScreen { OpenedUserFragment.newInstance(gitUser) }
}