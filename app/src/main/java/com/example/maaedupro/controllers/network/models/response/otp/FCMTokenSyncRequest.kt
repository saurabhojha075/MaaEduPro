package com.humainhealth.android.customer.controllers.network.models.response.otp

import com.example.maaedupro.utils.Constants


class FCMTokenSyncRequest {
    var deviceId: String? = null
    var deviceToken: String? = null
    var deviceType: Int = Constants.Global.DEVICE_TYPE_NUM
}