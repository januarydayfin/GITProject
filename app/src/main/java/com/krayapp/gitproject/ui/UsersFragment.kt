package com.krayapp.gitproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.krayapp.gitproject.App
import com.krayapp.gitproject.data.GitRepo
import com.krayapp.gitproject.databinding.FragmentUsersBinding
import com.krayapp.gitproject.presenter.UsersPresnter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment:MvpAppCompatFragment(), UsersView, BackButtonListener {
    companion object{
        fun newInstance() = UsersFragment()
    }

    private val presenter by moxyPresenter { UsersPresnter(GitRepo(), App.instance.router) }
    private var adapter: Adapter? = null
    private var binding: FragmentUsersBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        FragmentUsersBinding.inflate(inflater, container, false).also {
            binding = it
        }.root

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
    override fun init() {
        binding?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = Adapter(presenter.usersListPresenter)
        binding?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

}