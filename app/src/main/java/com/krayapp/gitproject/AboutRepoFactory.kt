package com.krayapp.gitproject

import com.krayapp.gitproject.ui.AboutRepoDialogFragment

class AboutRepoFactory() {
    fun create(forkCounter:Int): AboutRepoDialogFragment{
        return AboutRepoDialogFragment(forkCounter)
    }
}