package com.krayapp.gitproject.presenter

import com.github.terrakok.cicerone.Router
import com.krayapp.gitproject.data.GitRepoList
import com.krayapp.gitproject.data.GitUser
import com.krayapp.gitproject.ui.IScreens
import com.krayapp.gitproject.ui.openedUser.GitRepoView
import com.krayapp.gitproject.ui.openedUser.OpenedUserView
import com.krayapp.gitproject.ui.openedUser.UserGitRepoPresenter
import moxy.MvpPresenter

class OpenedUserPresenter(val router: Router, val screens:IScreens, val user:GitUser):MvpPresenter<OpenedUserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init(user)
    }

    class UserGetRepoPresenter : UserGitRepoPresenter {
        var repoList = mutableListOf<GitRepoList>()
        override var itemClickListener: ((GitRepoView) -> Unit)? = null

        override fun bindView(view: GitRepoView) {
            val currentRepo = repoList[view.pos]
            currentRepo.name?.let{view.setRepo(it)}
        }

        override fun getCount(): Int =
            repoList.size


    }

    var userGitRepoPresenter = UserGetRepoPresenter()
}