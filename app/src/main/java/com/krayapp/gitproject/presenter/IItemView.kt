package com.krayapp.gitproject.presenter

interface IItemView {
    var pos: Int
}

interface UserItemView: IItemView {
    fun setLogin(text: String)
    fun loadAvatar(url:String)
}

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}

interface IUserListPresenter : IListPresenter<UserItemView>