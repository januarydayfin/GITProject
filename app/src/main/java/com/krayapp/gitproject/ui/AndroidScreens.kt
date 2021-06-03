package com.krayapp.gitproject.ui

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens:IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
}