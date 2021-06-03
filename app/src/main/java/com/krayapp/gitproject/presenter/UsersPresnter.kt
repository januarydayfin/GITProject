package com.krayapp.gitproject.presenter

import com.github.terrakok.cicerone.Router
import com.krayapp.gitproject.data.GitRepo
import com.krayapp.gitproject.data.GitUser
import com.krayapp.gitproject.ui.UsersView
import moxy.MvpPresenter

class UsersPresnter (val repo: GitRepo, val router: Router):MvpPresenter<UsersView>(){
    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GitUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }

        override fun getCount(): Int {
            return users.size
        }

    }

    val usersListPresenter = UsersListPresenter()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = {
            TODO()
        }
    }

    fun backPressed():Boolean{
        router.exit()
        return true
    }
    fun loadData() {
        val users = repo.gerUsers()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }
}