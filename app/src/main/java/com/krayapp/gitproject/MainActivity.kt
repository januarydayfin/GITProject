package com.krayapp.gitproject

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.krayapp.gitproject.databinding.ActivityMainBinding
import com.krayapp.gitproject.presenter.Presenter
import com.krayapp.gitproject.ui.AndroidScreens
import com.krayapp.gitproject.ui.BackButtonListener
import com.krayapp.gitproject.ui.MainView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {
    val navigator = AppNavigator(this, R.id.container)
    private val presenter by moxyPresenter { Presenter(App.instance.router, AndroidScreens()) }
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if(it is BackButtonListener && it.backPressed()){
                return
            }
        }
        presenter.backClicked()
    }
}
