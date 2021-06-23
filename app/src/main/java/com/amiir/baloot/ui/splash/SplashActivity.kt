package com.amiir.baloot.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.lifecycle.ViewModelProvider
import com.amiir.baloot.R
import com.amiir.baloot.databinding.ActivitySplashBinding
import com.amiir.baloot.di.DaggerAppComponent
import com.amiir.baloot.ui.main.MainActivity
import com.amiir.baloot.ui.splash.viewModel.SplashViewModel
import com.amiir.baloot.ui.splash.viewModel.SplashViewModelFactory
import com.core.parent.ParentActivity
import javax.inject.Inject


/**
 * Created by aMiir on 10/2/20
 * Drunk, Fix Later
 */

class SplashActivity : ParentActivity<SplashViewModel, ActivitySplashBinding>() {

    @Inject
    lateinit var factory: SplashViewModelFactory

    private var isDelayPassed = false

    @Suppress("DEPRECATION")
    private fun hideStatusBar() {
        window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideStatusBar()
        setStatusBarColorResource(R.color.colorPrimaryDark)
        animateContent(binding.root)
        Handler(Looper.getMainLooper()).postDelayed({
            isDelayPassed = true
            checkReadyToGo()
        }, 2000)
    }

    private fun animateContent(view: View) {
        view.alpha = 0f
        view.animate()
            .alpha(1f)
            .setDuration(resources.getInteger(R.integer.default_animation_duration).toLong())
            .setInterpolator(AccelerateDecelerateInterpolator())
            .start()
    }

    private fun checkReadyToGo() {
        if (isDelayPassed) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun getResourceLayoutId(): Int = R.layout.activity_splash

    override fun getViewModelClass(): Class<SplashViewModel> = SplashViewModel::class.java

    override fun getFactory(): ViewModelProvider.Factory = factory

    override fun inject() {
        DaggerAppComponent.builder()
            .app(application)
            .build()
            .inject(this)
    }

}