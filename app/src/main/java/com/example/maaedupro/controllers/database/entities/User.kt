package com.example.maaedupro.controllers.database.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull
import com.example.maaedupro.controllers.database.models.UserDetails

@Entity
class User {
    @PrimaryKey
    @NonNull
    var _id: String? = null
    var createdAt: Long? = null
    var updatedAt: Long? = null
    var languagesSpoken: List<String>? = null
    @Embedded
    var user: UserDetails? = null
    var authToken: String? = null
    var DOB: String? = null
    var gender: String? = null
    var isEmailVerified: Boolean? = null
    @ColumnInfo(name = "LIMSId")
    var LIMSId: Int? = 0
}