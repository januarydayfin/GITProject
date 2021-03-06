package com.krayapp.gitproject.ui.openedUser

interface OpAdapterInterface {
    var pos:Int
}

interface GitRepoView:OpAdapterInterface{
    fun setRepo(repo: String)
}

interface GitRepoPresenter<V : OpAdapterInterface>{
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}

interface UserGitRepoPresenter : GitRepoPresenter<GitRepoView>

