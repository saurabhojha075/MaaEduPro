package com.example.maaedupro.viewmodel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import com.example.maaedupro.repository.LoginSignUpRepository
import com.example.maaedupro.controllers.network.models.request.RequestOTP
import com.humainhealth.android.customer.controllers.network.models.response.otp.ResponseOTPRequestWrapper
import com.example.maaedupro.controllers.network.models.response.otp.ResponseOTPVerifyWrapper

class LoginViewModel(context: Application): BaseViewModel(context) {

    private var repository: LoginSignUpRepository? = null


    init {
        repository = LoginSignUpRepository(getContext())
        linkBaseRepository(repository)
    }

    override fun clearDisposable() {

    }


    fun requestOTP(request: RequestOTP): MutableLiveData<ResponseOTPRequestWrapper>? {
        return repository?.requestOTP(request)
    }

    fun verifyOTP(request: RequestOTP): MutableLiveData<ResponseOTPVerifyWrapper>? {
        return repository?.verifyOTP(request)
    }
}