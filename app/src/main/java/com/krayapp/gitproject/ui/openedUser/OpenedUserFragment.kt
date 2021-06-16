package com.krayapp.gitproject.ui.openedUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.krayapp.gitproject.App
import com.krayapp.gitproject.data.GitUser
import com.krayapp.gitproject.databinding.OpenedUserLayoutBinding
import com.krayapp.gitproject.presenter.OpenedUserPresenter
import com.krayapp.gitproject.ui.AndroidScreens
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class OpenedUserFragment : MvpAppCompatFragment(), OpenedUserView {
    companion object {
        private const val ARG_KEY = "ARG_KEY"
        fun newInstance(gitUser: GitUser): OpenedUserFragment {
            val newFrag = OpenedUserFragment()
            val bundle = Bundle()
            bundle.putParcelable(ARG_KEY, gitUser)
            newFrag.arguments = bundle
            return newFrag
        }
    }

    private val presenter by moxyPresenter { OpenedUserPresenter(App.instance.router, AndroidScreens(), user = arguments?.getParcelable(ARG_KEY)!!) }
    private var binding: OpenedUserLayoutBinding? = null
    private var adapter:OpenedAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = OpenedUserLayoutBinding.inflate(inflater, container, false).also { binding = it }.root


    override fun getRepositoryList() {

    }

    override fun init(gitUser: GitUser) {
        binding?.loginIs?.text = gitUser.login
        Glide.with(requireContext())
            .load(gitUser.avatarUrl)
            .into(binding?.avatarIn!!)
    }
}