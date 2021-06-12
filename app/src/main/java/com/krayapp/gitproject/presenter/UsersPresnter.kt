package com.krayapp.gitproject.presenter

import com.github.terrakok.cicerone.Router
import com.krayapp.gitproject.data.GitRepo
import com.krayapp.gitproject.data.GitUser
import com.krayapp.gitproject.ui.AndroidScreens
import com.krayapp.gitproject.ui.UsersView
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter

class UsersPresnter(val repo: GitRepo, val router: Router) : MvpPresenter<UsersView>() {

    val screens = AndroidScreens()
    val userObserver = object : Observer<GitUser> {
        var disposable: Disposable? = null
        override fun onSubscribe(d: Disposable?) {
            println("Subscribed")
        }

        override fun onNext(t: GitUser) {
            addUser(t)
        }

        override fun onError(e: Throwable?) {
            println("Error $e")
        }

        override fun onComplete() {
            println("Completed")
        }

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
        repo.repositories().subscribe(userObserver)
        viewState.updateList()
    }

    fun addUser(gitUser: GitUser) {
        usersListPresenter.users.add(gitUser)
    }
}