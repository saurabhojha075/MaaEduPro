package com.example.maaedupro.controllers.database.entities

import com.google.gson.annotations.SerializedName

class Token {
    @SerializedName("id")
    var token_id: Int? = null

    var otp: Int? = null


    @SerializedName("token")
    var token_no: Int? = null

    @SerializedName("status")
    var token_status: String? = null
}