package com.example.maaedupro.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.example.maaedupro.repository.BaseRepository
import com.example.maaedupro.controllers.database.entities.User



abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val TAG = BaseViewModel::class.java.simpleName

    private var repository: BaseRepository? = null


    override fun onCleared() {
        super.onCleared()
        clearDisposable()
    }

    abstract fun clearDisposable()


    fun <T : BaseRepository> linkBaseRepository(repository: T?) {
        this.repository = repository
    }

    fun getContext(): Context {
        return getApplication<Application>().applicationContext
    }


    //User Details
    fun getUser(): LiveData<User>? {
        return repository?.getUser()
    }

    fun getUserDetail(): User? {
        return repository?.getUserDetail()
    }

    fun updateUserDetail(user: User){
        return repository?.updateUserDetail(user)!!
    }

    fun getUserId(): String? {
        return repository?.getUserId()
    }

    fun isLoggedIn(): Boolean? {
        return repository?.isLoggedIn()
    }

    fun logout() {
        repository?.logout(false)
    }

    fun hasUserSessionExpired(): MutableLiveData<Boolean> {
        return repository?.hasUserSessionExpired()!!
    }

    fun setUserSessionExpiration(hasExpired: Boolean) {
        repository?.setUserSessionExpiration(hasExpired)
    }




}