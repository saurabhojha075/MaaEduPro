package com.example.maaedupro.views.activities


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.maaedupro.R
import com.example.maaedupro.utils.Constants


import kotlinx.android.synthetic.main.activity_splash.*
import pl.droidsonroids.gif.GifDrawable


class SplashActivity : BaseFragmentActivity() {
    override fun navigateBack() {

    }

    private var SPLASH_TIMEOUT = 1000L


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        extractData()
        initComponents()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        extractData()
    }


    override fun extractData() {


    }

    override fun initComponents() {
        if (isAppAlreadyRunning) finish()
        else {
            //Render splash gif
            val gifResource = GifDrawable(resources, R.raw.gif_splash_animation)
            SPLASH_TIMEOUT += gifResource.duration.toLong()
            Handler().postDelayed({
                val gifDrawable = GifDrawable(resources, R.raw.gif_splash_animation)
                gifDrawable.loopCount = 1
                ivSplash.setImageDrawable(gifDrawable)
            }, Constants.AnimationDuration.ANIM_DURATION_LONG)

            goToNextScreen()
        }
    }


    private fun goToNextScreen() {
        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
        }, SPLASH_TIMEOUT)
    }
}