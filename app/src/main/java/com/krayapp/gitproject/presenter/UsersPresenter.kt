package com.krayapp.gitproject.presenter

import com.github.terrakok.cicerone.Router
import com.krayapp.gitproject.data.GitUser
import com.krayapp.gitproject.data.retrofit2.IGithubUsersRepo
import com.krayapp.gitproject.ui.IScreens
import com.krayapp.gitproject.ui.list.UsersView
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter

class UsersPresenter(
    val uiScheduler: Scheduler,
    val repo: IGithubUsersRepo,
    val router: Router,
    val screens: IScreens
) : MvpPresenter<UsersView>() {

    private var disposables = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GitUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            user.login?.let { view.setLogin(it) }
            user.avatarUrl?.let { view.loadAvatar(it) }
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
        repo.getUsers()
            .observeOn(uiScheduler)
            .subscribe({ repos ->
                usersListPresenter.users.clear()
                usersListPresenter.users.addAll(repos)
                viewState.updateList()
            }, {
                println("Error ${it.message}")
            })
    }
}