package com.krayapp.gitproject.ui.openedUser

import com.krayapp.gitproject.data.GitUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface OpenedUserView:MvpView {
    fun getRepositoryList()
    fun init(gitUser: GitUser)
}