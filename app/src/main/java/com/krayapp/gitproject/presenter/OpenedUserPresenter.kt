package com.krayapp.gitproject.presenter

import com.github.terrakok.cicerone.Router
import com.krayapp.gitproject.data.GitUser
import com.krayapp.gitproject.ui.IScreens
import com.krayapp.gitproject.ui.openedUser.OpenedUserView
import moxy.MvpPresenter

class OpenedUserPresenter(val router: Router, val screens:IScreens, val user:GitUser):MvpPresenter<OpenedUserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init(user)
    }


}