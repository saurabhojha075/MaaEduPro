package com.example.maaedupro.controllers.network;

import com.example.maaedupro.controllers.network.models.request.SignUpRequest;
import com.example.maaedupro.controllers.network.models.response.AbstractResponse;
import com.example.maaedupro.utils.Constants;

import com.example.maaedupro.controllers.network.models.request.RequestOTP;
import com.humainhealth.android.customer.controllers.network.models.response.otp.ResponseOTPRequestWrapper;
import com.example.maaedupro.controllers.network.models.response.otp.ResponseOTPVerifyWrapper;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIServices {

    /**************************************** On-Boarding ************************************/

    @GET(Constants.APIEndPoints.API_LOGIN)
    Observable<Response<AbstractResponse>> login(@Query("username") String username,
                                                 @Query("password") String password);

    @POST(Constants.APIEndPoints.API_SIGN_UP)
    Observable<Response<AbstractResponse>> signUp(@Body SignUpRequest request);

    @POST(Constants.APIEndPoints.API_OTP_REQUEST)
    Observable<Response<ResponseOTPRequestWrapper>> requestOTP(@Body RequestOTP request);

    @POST(Constants.APIEndPoints.API_OTP_VERIFY)
    Observable<Response<ResponseOTPVerifyWrapper>> verifyOTP(@Body RequestOTP request);

    @POST(Constants.APIEndPoints.API_LOGOUT)
    Observable<Response<AbstractResponse>> logout();


}