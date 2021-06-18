package com.krayapp.gitproject.ui.openedUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.krayapp.gitproject.data.gituserinfo.AboutUserRepo
import com.krayapp.gitproject.databinding.AboutRepoFragBinding
import moxy.MvpAppCompatFragment

class AboutRepoFrag:MvpAppCompatFragment() {
    companion object {
        val REPO_USER_KEY = "REPO_USER_KEY"
        fun newInstance(aboutUserRepo: AboutUserRepo): AboutRepoFrag {
            val newFrag = AboutRepoFrag()
            val bundle = Bundle()
            bundle.putParcelable(REPO_USER_KEY, aboutUserRepo)
            newFrag.arguments = bundle
            return newFrag
        }
    }

    private var binding: AboutRepoFragBinding? = null
    private var currentRepoInfo:AboutUserRepo? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = AboutRepoFragBinding.inflate(inflater, container, false).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentRepoInfo = arguments?.getParcelable(REPO_USER_KEY)
        loadInfo()
    }

    private fun loadInfo(){
        binding?.forkCounterView?.text = currentRepoInfo?.forks.toString()
    }
}