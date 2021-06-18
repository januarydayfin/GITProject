package com.krayapp.gitproject.ui

import android.app.AlertDialog
import android.os.Bundle
import moxy.MvpAppCompatDialogFragment

class AboutRepoDialogFragment(private val forksCounter: Int) : MvpAppCompatDialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): AlertDialog {
        return requireActivity().let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Форков вот столько то")
                .setMessage("Forks: $forksCounter")
                .setPositiveButton("Ok, roger") { dialog, id ->
                    dialog.cancel()
                }
            builder.create()
        }!!
    }

    fun startDialog(){
        this.show(requireActivity().supportFragmentManager, "Fork Dialog")
    }
}