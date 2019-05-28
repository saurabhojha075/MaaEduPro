package com.example.maaedupro.views.activities

import android.os.Bundle
import android.view.View
import com.example.maaedupro.R
import com.example.maaedupro.utils.Constants
import com.example.maaedupro.utils.Constants.RequestArgs.ARG_REQ_FRAGMENT


class LoginActivity : BaseFragmentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        extractData()
        initComponents()
    }

    override fun onClick(p0: View?) {
        super.onClick(p0)

        when (p0) {

        }
    }


    override fun extractData() {
        //Extract data from intent
        fragReqData = intent.extras
        fragReqCode = intent.getIntExtra(ARG_REQ_FRAGMENT, Constants.RequestFragment.FRAG_LOGIN)
    }

    override fun initComponents() {
        //opening fragment
        onFragmentSelected(fragReqCode, fragReqData)
    }
}
