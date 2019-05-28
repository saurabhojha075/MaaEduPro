package com.example.maaedupro.controllers.database.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import com.example.maaedupro.controllers.database.models.Photo
import com.google.gson.annotations.SerializedName

class UserDetails {
    @ColumnInfo(name="userDetailName")
    var name:String?=null
    @Embedded
    @SerializedName("photo")
    var image: Photo?=null
    @ColumnInfo(name="userDetailIsBlocked")
    var isBlocked:Boolean?=null
    @ColumnInfo(name="userDetailIsActive")
    var isActive:Boolean?=null
    @ColumnInfo(name="userDetailLastLogin")
    var lastLogin:Long?=null
    @ColumnInfo(name="userDetailIsVerified")
    var isVerified:Boolean?=null
    @ColumnInfo(name="userDetailUserType")
    var type: String? = null
    @ColumnInfo(name="userDetailPhone")
    var phone:Long?=null
    @ColumnInfo(name="userDetailEmail")
    var email:String?=null
    @ColumnInfo(name="userDetailCreatedAt")
    var createdAt:Long?=null
    @ColumnInfo(name="userDetailUpdatedAt")
    var updatedAt:Long?=null
    @ColumnInfo(name="userDetailId")
    var id:String?=null
}