package com.krbinayapp.gitproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.krayapp.gitproject.data.GitUser
import com.krayapp.gitproject.databinding.OpenedUserLayoutBinding
import moxy.MvpAppCompatFragment

class OpenedUserFragment : MvpAppCompatFragment() {
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

    private var user: GitUser? = null
    private var binding: OpenedUserLayoutBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        this.user = arguments?.getParcelable(ARG_KEY)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = OpenedUserLayoutBinding.inflate(inflater, container, false).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.loginIs?.text =  user?.login
    }
}