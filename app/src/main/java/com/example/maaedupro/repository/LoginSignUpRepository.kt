package com.example.maaedupro.repository

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.example.maaedupro.BuildConfig
import com.example.maaedupro.controllers.database.AppDatabase
import com.example.maaedupro.controllers.network.APIController
import com.example.maaedupro.controllers.network.models.response.AbstractResponse
import com.example.maaedupro.utils.Constants
import com.example.maaedupro.utils.Constants.Prefs.PREFS_IS_LOGGED_IN
import com.example.maaedupro.utils.Prefs


import com.example.maaedupro.controllers.network.models.request.RequestOTP


import com.humainhealth.android.customer.controllers.network.models.response.otp.ResponseOTPRequestWrapper
import com.example.maaedupro.controllers.network.models.response.otp.ResponseOTPVerifyWrapper


import io.reactivex.disposables.CompositeDisposable

class LoginSignUpRepository(mContext: Context?) : BaseRepository(), Constants.APIEndPoints {

    private val signUpData = MutableLiveData<AbstractResponse>()
    private val requestOTP = MutableLiveData<ResponseOTPRequestWrapper>()
    private val verifyOTP = MutableLiveData<ResponseOTPVerifyWrapper>()

    private var profileRepository: ProfileRepository? = null



    init {
        context = mContext
        networkDisposable = CompositeDisposable()
        appDatabase = AppDatabase.getInstance(context)
        profileRepository = ProfileRepository(context!!)

    }


    fun requestOTP(request: RequestOTP): MutableLiveData<ResponseOTPRequestWrapper> {
        networkDisposable.add(APIController.getInstance(context, BuildConfig.base_url_user).requestOTP(request, this))
        return requestOTP
    }

    fun verifyOTP(request: RequestOTP): MutableLiveData<ResponseOTPVerifyWrapper> {
        networkDisposable.add(APIController.getInstance(context, BuildConfig.base_url_user).verifyOTP(request, this))
        return verifyOTP
    }

    override fun onSuccess(reqCode: String?, responseObject: Any?) {
        super.onSuccess(reqCode, responseObject)

        if (reqCode == Constants.APIEndPoints.API_OTP_REQUEST) {
            if (responseObject != null)
                requestOTP.value = responseObject as ResponseOTPRequestWrapper?

        } else if (reqCode == Constants.APIEndPoints.API_OTP_VERIFY) {
            if (responseObject != null) {
                if (responseObject is ResponseOTPVerifyWrapper) {
                    val responseOTPVerifyWrapper: ResponseOTPVerifyWrapper = responseObject
                    if (responseOTPVerifyWrapper.result != null) {

                        Prefs.setPrefs(PREFS_IS_LOGGED_IN, true)
                        profileRepository?.saveUserDetails(responseOTPVerifyWrapper.result)




                        verifyOTP.value = responseObject
                    }
                }
            }
        } else if (reqCode == Constants.APIEndPoints.API_SIGN_UP) {
            if (responseObject != null)
                signUpData.value = responseObject as AbstractResponse?
        }
    }
}