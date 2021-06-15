package com.krayapp.gitproject.presenter

import com.github.terrakok.cicerone.Router
import com.krayapp.gitproject.data.GitRepo
import com.krayapp.gitproject.data.GitUser
import com.krayapp.gitproject.ui.AndroidScreens
import com.krayapp.gitproject.ui.UsersView
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class UsersPresnter(val repo: GitRepo, val router: Router) : MvpPresenter<UsersView>() {

    private var disposables = CompositeDisposable()
    val screens = AndroidScreens()

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }

    class UsersListPresenter() : IUserListPresenter {
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
            router.navigateTo(screens.openedUser(usersListPresenter.users[it.pos]))
        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    fun loadData() {
        disposables.add(repo.repositories
            .doOnNext { gituser -> addUser(gituser) }
            .subscribe())
        viewState.updateList()
    }

    fun addUser(gitUser: GitUser) {
        usersListPresenter.users.add(gitUser)
    }
}