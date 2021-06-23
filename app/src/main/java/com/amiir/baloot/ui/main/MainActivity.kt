package com.amiir.baloot.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.amiir.baloot.R
import com.amiir.baloot.databinding.ActivityMainBinding
import com.amiir.baloot.di.DaggerAppComponent
import com.core.parent.ParentActivity
import com.amiir.baloot.ui.main.viewModel.MainViewModel
import com.amiir.baloot.ui.main.viewModel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : ParentActivity<MainViewModel, ActivityMainBinding>() {

    @Inject
    lateinit var factory: MainViewModelFactory

    private lateinit var navController: NavController

    private var isMainPageDestination = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment? ?: return

        navController = host.navController

        binding.bottomNavigation.setupWithNavController(navController)

        val navBarElevation =
            resources.getDimensionPixelSize(R.dimen.main_navbar_elevation).toFloat()

        ViewCompat.setElevation(binding.bottomNavigation, navBarElevation)

        navController.addOnDestinationChangedListener { _: NavController, destination, _: Bundle? ->
            val id = destination.id
            isMainPageDestination = id == R.id.profile || id == R.id.article
            setIconOnNavBar(binding.bottomNavigation.menu, id)
            binding.bottomNavigation.visibility =
                if (isMainPageDestination) View.VISIBLE else View.GONE
        }

        setStatusBarColorResource(R.color.colorPrimaryDark)

    }

    private fun setIconOnNavBar(menu: Menu, selectedId: Int) {
        menu.findItem(R.id.article).icon = ContextCompat.getDrawable(this, R.drawable.ic_article)
        menu.findItem(R.id.profile).icon = ContextCompat.getDrawable(this, R.drawable.ic_profile)
        when (selectedId) {
            R.id.article -> {
                menu.findItem(selectedId).icon =
                    ContextCompat.getDrawable(this, R.drawable.ic_article_active)
            }
            R.id.profile -> {
                menu.findItem(selectedId).icon =
                    ContextCompat.getDrawable(this, R.drawable.ic_profile_active)
            }
        }

    }

    override fun getFactory(): ViewModelProvider.Factory = factory

    override fun inject() {
        DaggerAppComponent.builder().app(application).build().inject(this)
    }

    override fun getResourceLayoutId(): Int = R.layout.activity_main

    override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun showError(tag: String, error: String) {
        super.showError(tag, error)
        showMessage(error)
    }

}