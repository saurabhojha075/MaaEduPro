package com.example.maaedupro.controllers.network.models.request


class RequestOTP {
    var userType: String = "patient";
    var phone: Long? = null
    var action: String = "login"
    var otp:Int? = null
}