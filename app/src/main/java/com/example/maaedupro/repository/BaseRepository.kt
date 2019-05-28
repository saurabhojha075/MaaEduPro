package com.example.maaedupro.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.util.Log
import com.example.maaedupro.BuildConfig
import com.example.maaedupro.R
import com.example.maaedupro.controllers.database.AppDatabase
import com.example.maaedupro.controllers.network.APIController
import com.example.maaedupro.listeners.APIResponseListener
import com.example.maaedupro.utils.*
import com.example.maaedupro.utils.Constants.Prefs.*
import com.example.maaedupro.controllers.database.entities.User
import io.reactivex.disposables.CompositeDisposable


abstract class BaseRepository : APIResponseListener<Any> {

    private val TAG = BaseRepository::class.java.simpleName

    var context: Context? = null
    lateinit var appDatabase: AppDatabase
    lateinit var networkDisposable: CompositeDisposable




    companion object {
        var onUserSessionExpired = MutableLiveData<Boolean>()

    }

    fun clearRepository() {
        if (!networkDisposable.isDisposed) networkDisposable.clear()
    }


    //User Details
    fun getUser(): LiveData<User>? {
        AppLog.d("PREFS_USER_ID : ", Prefs.getPrefsString(PREFS_USER_ID))
        AppLog.d("USER_OBJECT : ", JsonUtils.jsonify(appDatabase.userDao?.getUserDetails()))
        return appDatabase.userDao?.userDetails
    }

    fun getUserDetail(): User? {
        return appDatabase.userDao.getNormalUserDetails(getUserId())
    }

    fun updateUserDetail(user: User){
        return appDatabase.userDao.updateUser(user)
    }

    fun getUserId(): String? {
        AppLog.d("PREFS_USER_ID : ", Prefs.getPrefsString(PREFS_USER_ID))
        return Prefs.getPrefsString(PREFS_USER_ID)
    }

    fun isLoggedIn(): Boolean {
        AppLog.d("PREFS_IS_LOGGED_IN : ", Prefs.getPrefsBoolean(PREFS_IS_LOGGED_IN).toString())
        return Prefs.getPrefsBoolean(PREFS_IS_LOGGED_IN)
    }

    fun logout(hasSessionAlreadyExpired: Boolean) {
        try {
            //Logout from server
            if (!hasSessionAlreadyExpired)
                networkDisposable.add(
                    APIController.getInstance(context, BuildConfig.base_url_user)
                        .logout(this))

            //Clear local details
            appDatabase.clearAllTables()
            Prefs.clear()

        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            setUserSessionExpiration(true)
        }
    }

    fun hasUserSessionExpired(): MutableLiveData<Boolean> {
        return onUserSessionExpired
    }

    fun setUserSessionExpiration(hasExpired: Boolean) {
        onUserSessionExpired.value = hasExpired
    }


    //Server call handling
     fun showErrorMessage(responseObject: String?) {
        if (com.example.maaedupro.utils.TextUtils.isNotEmpty(responseObject))
            Utils.showToast(context, "" + responseObject)
        else if (context != null) Utils.showToast(context, context!!.getString(R.string.error_general))
    }

    fun handelError(endPoint: String, error: Throwable?) {
        var errorMessage: String? = null
        if (error != null && com.example.maaedupro.utils.TextUtils.isNotEmpty(error.localizedMessage)) errorMessage = error.localizedMessage
        else if (context != null) errorMessage = context!!.getString(R.string.error_general)
        Log.d("responce___________", "__obsarvrable__" + errorMessage)
        Log.e(TAG, "error: $errorMessage")
        onError(endPoint, 0, errorMessage!!)
    }


    override fun onSuccess(reqCode: String?, responseObject: Any?) {


    }

    override fun onError(reqCode: String, errorCode: Int, errorMessage: String) {


        showErrorMessage(errorMessage+errorCode)
    }
}