package com.example.maaedupro.views.activities

import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.maaedupro.utils.Utils
import io.reactivex.disposables.CompositeDisposable
abstract class BaseActivity : AppCompatActivity() {

    private val TAG = BaseActivity::class.java.simpleName

    private var backPressedOnce = false

    var compositeDisposable: CompositeDisposable? = null


    companion object {
        //Define your companion objects whose value will persist across the activities
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Set Light Status Bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = Color.WHITE
        }

        //Set only if your app needs to run always in portrait mode
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        //To hold the instance of all the observables so that can be destroyed with activity lifecycle
        compositeDisposable = CompositeDisposable()
    }

    override fun onDestroy() {
        super.onDestroy()

        //Disposes all the observables being observed
        if (compositeDisposable != null && !compositeDisposable!!.isDisposed())
            compositeDisposable!!.clear()
        Utils.showKeyboard(this, false)
    }


    abstract fun extractData()
    abstract fun initComponents()
    abstract fun navigateBack()

    fun estimateDoubleBackPress() {
        if (backPressedOnce)
            finish()
        else {
            this.backPressedOnce = true
            Utils.showShortToast(this@BaseActivity, "Press again to Exit!")
            Handler().postDelayed({ backPressedOnce = false }, 2000)
        }
    }


    /************************************* Custom Methods *************************************
     * Write all your custom methods down here
     */




}