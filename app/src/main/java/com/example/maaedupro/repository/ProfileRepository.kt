package com.example.maaedupro.repository
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.example.maaedupro.controllers.database.AppDatabase
import com.example.maaedupro.repository.BaseRepository
import com.example.maaedupro.repository.LoginSignUpRepository
import com.example.maaedupro.utils.Constants
import com.example.maaedupro.utils.Prefs
import com.example.maaedupro.utils.TextUtils
import com.example.maaedupro.controllers.database.entities.User
import com.example.maaedupro.controllers.network.models.request.RequestOTP
import com.humainhealth.android.customer.controllers.network.models.response.otp.ResponseOTPRequestWrapper
import com.example.maaedupro.controllers.network.models.response.otp.ResponseOTPVerifyWrapper


import io.reactivex.disposables.CompositeDisposable

class ProfileRepository(mContext: Context) : BaseRepository(), Constants.APIEndPoints {

    private var profileData = MutableLiveData<User>()

    init {
        networkDisposable = CompositeDisposable()
        appDatabase = AppDatabase.getInstance(mContext)
        context = mContext
    }


    //Local DB Call
    fun saveUserDetails(details: User?) {
        appDatabase.userDao.saveUser(details)
        updateUserSessionDetails(details)
    }

    private fun updateUserDetails(details: User?, saveSession: Boolean) {
        appDatabase.userDao.updateUser(details)
        if (saveSession) updateUserSessionDetails(details)
    }

    private fun updateUserSessionDetails(details: User?) {
        if (details != null) {
            if (TextUtils.isNotEmpty(details._id))
                Prefs.setPrefs(Constants.Prefs.PREFS_USER_ID, details._id)
            if (TextUtils.isNotEmpty(details.authToken))
                Prefs.setPrefs(Constants.Prefs.PREFS_AUTH_TOKEN, details.authToken)
        }
    }





    //Server Call
    fun requestOTP(request: RequestOTP): MutableLiveData<ResponseOTPRequestWrapper> {
        return LoginSignUpRepository(context).requestOTP(request)
    }











    override fun onSuccess(reqCode: String?, responseObject: Any?) {
        super.onSuccess(reqCode, responseObject)

        if (reqCode == Constants.APIEndPoints.API_GET_UPDATE_PROFILE) {
            if (responseObject != null && responseObject is ResponseOTPVerifyWrapper) {
                updateUserDetails(responseObject.result, true)
                profileData.value = responseObject.result
            }
        }




}
    }