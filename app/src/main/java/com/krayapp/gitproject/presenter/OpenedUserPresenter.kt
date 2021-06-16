package com.krayapp.gitproject.presenter

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import com.krayapp.gitproject.AboutRepoFactory
import com.krayapp.gitproject.data.gituserinfo.GitRepoList
import com.krayapp.gitproject.data.gituserinfo.GitUser
import com.krayapp.gitproject.data.retrofit2.IGithubUsersRepo
import com.krayapp.gitproject.ui.IScreens
import com.krayapp.gitproject.ui.openedUser.AboutRepoFrag
import com.krayapp.gitproject.ui.openedUser.GitRepoView
import com.krayapp.gitproject.ui.openedUser.OpenedUserView
import com.krayapp.gitproject.ui.openedUser.UserGitRepoPresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter

class OpenedUserPresenter(
    val router: Router,
    val user: GitUser,
    val repo: IGithubUsersRepo,
    val screens: IScreens
) :
    MvpPresenter<OpenedUserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init(user)
        loadRepos()
        userGitRepoPresenter.itemClickListener = {
            repo.loadRepoForks(user.login!!,repoName = userGitRepoPresenter.repoList[it.pos].name!!)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { forkCounter ->
                    router.navigateTo(screens.aboutUserRepo(forkCounter))
                }
        }
    }

    class UserGetRepoPresenter : UserGitRepoPresenter {
        var repoList = mutableListOf<GitRepoList>()
        override var itemClickListener: ((GitRepoView) -> Unit)? = null

        override fun bindView(view: GitRepoView) {
            val currentRepo = repoList[view.pos]
            currentRepo.name?.let { view.setRepo(it) }
        }

        override fun getCount(): Int =
            repoList.size
    }

    var userGitRepoPresenter = UserGetRepoPresenter()
    fun loadRepos() {
        repo.getRepoList(user.login!!)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ currentRepos ->
                userGitRepoPresenter.repoList.clear()
                userGitRepoPresenter.repoList.addAll(currentRepos)
                viewState.updateRepositoryList()
            }, {
                println("Error ${it.message}")
            })
    }
}