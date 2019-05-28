package com.example.maaedupro.controllers.network;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.example.maaedupro.BuildConfig;
import com.example.maaedupro.R;
import com.example.maaedupro.controllers.network.models.request.RequestOTP;
import com.example.maaedupro.controllers.network.models.request.SignUpRequest;
import com.example.maaedupro.controllers.network.models.response.AbstractResponse;
import com.example.maaedupro.controllers.network.models.response.otp.ResponseOTPVerifyWrapper;
import com.example.maaedupro.listeners.APIResponseListener;
import com.example.maaedupro.repository.BaseRepository;
import com.example.maaedupro.repository.LoginSignUpRepository;
import com.example.maaedupro.utils.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;


import com.humainhealth.android.customer.controllers.network.models.response.otp.ResponseOTPRequestWrapper;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.example.maaedupro.utils.Constants.Prefs.PREFS_AUTH_TOKEN;


/**
 * Created by chandrapratapsingh on 6/8/18.
 */

public class APIController implements Constants.LocalBroadcastAction, Constants.Global,
        Constants.APIRequestFragments, Constants.APIResponseStatus, Constants.APIEndPoints {

    private final String TAG = APIController.class.getSimpleName();

    private static Context context;
    private static APIController apiController;
    private static String token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjpudWxsLCJjb3VudHJ5Q29kZSI6OTEsInBob3RvIjpudWxsLCJpc0Jsb2NrZWQiOmZhbHNlLCJpc0FjdGl2ZSI6dHJ1ZSwibGFzdExvZ2luIjpudWxsLCJpc1ZlcmlmaWVkIjpmYWxzZSwiX2lkIjoiNWNlY2U1NDA5YmY2NmIxODgwN2E1YTJiIiwicGhvbmUiOjg2NDQ0NDQ0NDQsInVzZXJUeXBlIjoicGF0aWVudCIsImNyZWF0ZWRBdCI6MTU1OTAyOTA1NjAzNSwidXBkYXRlZEF0IjoxNTU5MDI5MDU2MDM1LCJpZCI6IjVjZWNlNTQwOWJmNjZiMTg4MDdhNWEyYiIsInNlc3Npb25JZCI6IjZmOThkNWI1LTMwYWItNGFhYS1iMzIxLTYwMzAzN2Y2M2Q3ZCIsImlhdCI6MTU1OTAyOTA2NX0.r0P9a2eKXWCMNYBgTGnFNuy1l9nZRjGvZHzidzQ9Idk";

    private Retrofit retrofit;
    public APIServices apiServices;


    //Constructors
    private APIController() {
        prepareRequest();
    }

    private APIController(String baseUrl) {
        prepareRequest(baseUrl);
    }


    /********************************** Initialize API Controller Instance ***********************/

    public static APIController getInstance(Context mCtx) {
        context = mCtx;
        if (apiController == null) apiController = new APIController();
        return apiController;
    }

    public static APIController getInstance(Context mCtx, String baseUrl) {
        context = mCtx;
        apiController = null;
        return new APIController(baseUrl);
    }


    /********************************** Prepare Retrofit Instance ********************************/

    private void prepareRequest() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        // set connection time out
        httpClient.connectTimeout(CONNECT_TIMEOUT_SECS, TimeUnit.SECONDS)
                .writeTimeout(CONNECT_TIMEOUT_SECS, TimeUnit.SECONDS)
                .readTimeout(CONNECT_TIMEOUT_SECS, TimeUnit.SECONDS);
        // add your other interceptors … set custom headers
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request.Builder builder = original.newBuilder();

            builder.addHeader(HEADER_CONTENT_TYPE, RESPONSE_TYPE_JSON);
            builder.addHeader(HEADER_DEVICE_TYPE, DEVICE_TYPE);
            builder.addHeader(HEADER_APP_VERSION, BuildConfig.VERSION_NAME);

            builder.method(original.method(), original.body());
            Request request = builder.build();
            return chain.proceed(request);
        });
        // add logging as last interceptor
        httpClient.addInterceptor(logging);

        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.base_url_user)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();
        apiServices = retrofit.create(APIServices.class);
    }

    private void prepareRequest(String baseUrl) {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        // set connection time out
        httpClient.connectTimeout(CONNECT_TIMEOUT_SECS, TimeUnit.SECONDS)
                .writeTimeout(CONNECT_TIMEOUT_SECS, TimeUnit.SECONDS)
                .readTimeout(CONNECT_TIMEOUT_SECS, TimeUnit.SECONDS);
        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!
        // add your other interceptors … set custom headers
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder builder = original.newBuilder();

                builder.addHeader(HEADER_CONTENT_TYPE, RESPONSE_TYPE_JSON);
                builder.addHeader(HEADER_DEVICE_TYPE, DEVICE_TYPE);
                builder.addHeader(HEADER_APP_VERSION, BuildConfig.VERSION_NAME);
                if (TextUtils.isNotEmpty(token)) {
                    builder.addHeader(HEADER_AUTHORIZATION, token);
                    AppLog.d("AUTH TOKEN: ", token);
                    Log.v("Api___",token);
                }

                builder.method(original.method(), original.body());
                Request request = builder.build();
                return chain.proceed(request);
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();

        apiServices = retrofit.create(APIServices.class);
    }


    /************************** Prepare Retrofit Asynchronous Request *****************************/

    private <T> void retrofitRequest(final String endPoint, final Call<T> retroFitRequest,
                                     final APIResponseListener mListener) {

        if (!Utils.isInternetConnected(context)) {
            if (mListener != null)
                mListener.onError(endPoint, 0, context.getString(R.string.error_internet));
            return;
        }

        retroFitRequest.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                handleResponse(response, mListener, endPoint);
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                AppLog.e(TAG, "API Failure: " + t.getMessage());
                mListener.onError(endPoint, 0, t.getMessage());
            }
        });
    }

    //Observable Request using RxJava
    private <T> Disposable retrofitObservableRequest(Observable<Response<T>> observable, String endPoint, BaseRepository repository) {

        if (!Utils.isInternetConnected(context)) {
            return Observable.error(new Throwable())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(res -> {
                    }, error -> {
                        repository.onError(endPoint, ERROR_INTERNET_CONNECTION,
                                context.getString(R.string.error_internet));
                        Utils.showToast(context, context.getString(R.string.error_internet));
                    });
        }

        return observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(response -> handleObservableResponse(endPoint, repository, response),
                        error -> repository.handelError(endPoint, error));
    }


    /******************************* Handle Retrofit Response ************************************/

    private <T> void handleResponse(Response<T> response, APIResponseListener mListener, String endPoint) {
        AppLog.e(TAG, "API Response: " + response.code());

        if (response.isSuccessful())
            mListener.onSuccess(endPoint, response.body());
        else {
            AbstractResponse errorResponse = null;
            try {
                if (response.code() == STATUS_INVALID_CREDENTIALS) {
                    Utils.showToast(context, "Your session has expired!");
                    //Send broadcast
                    Intent intent = new Intent(Constants.LocalBroadcastAction.ACTION_LOGOUT);
                    LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                    return;
                }

                Converter<ResponseBody, AbstractResponse> converter = retrofit.responseBodyConverter
                        (AbstractResponse.class, AbstractResponse.class.getAnnotations());
                errorResponse = converter.convert(response.errorBody());
                if (errorResponse != null) {
                    AppLog.e(TAG, "API Error: " + errorResponse.getStatusCode() + " - " + errorResponse.getMessage());
                    mListener.onError(endPoint, errorResponse.getStatusCode(), errorResponse.getMessage());
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            mListener.onError(endPoint, response.code(), context.getString(R.string.error_general));
        }
    }

    //Handle Observable Response using RxJava
    private <T> void handleObservableResponse(String endPoint, BaseRepository repository,
                                              Response<T> response) {
        Gson gson = new Gson();
        String result = gson.toJson(response);

       Log.d("responce___________",result);
        if (response.isSuccessful()) repository.onSuccess(endPoint, response.body());
        else {
            AbstractResponse errorResponse = null;
            try {
                if (response.code() == STATUS_INVALID_CREDENTIALS) {
                    Utils.showToast(context, "Your session has expired!");
                    repository.logout(true);
                    return;
                }

                Converter<ResponseBody, AbstractResponse> converter = retrofit.responseBodyConverter
                        (AbstractResponse.class, AbstractResponse.class.getAnnotations());
                errorResponse = converter.convert(response.errorBody());
                if (errorResponse != null) {
                    AppLog.e(TAG, "API Error: " + errorResponse.getStatusCode()
                            + " - " + errorResponse.getMessage());
                    repository.onError(endPoint, errorResponse.getStatusCode(), errorResponse.getMessage());
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
            repository.onError(endPoint, response.code(), context.getString(R.string.error_general));
        }
    }


    /************************************ API Calls - On-Boarding *********************************/

    public Disposable login(String username, String password, LoginSignUpRepository repository) {
        Observable<Response<AbstractResponse>> observable = apiServices.login(username, password);
        return retrofitObservableRequest(observable, API_LOGIN, repository);
    }

    public Disposable signUp(SignUpRequest request, LoginSignUpRepository repository) {
        Observable<Response<AbstractResponse>> observable = apiServices.signUp(request);
        return retrofitObservableRequest(observable, API_SIGN_UP, repository);
    }

    public Disposable requestOTP(RequestOTP request, LoginSignUpRepository repository) {
        Observable<Response<ResponseOTPRequestWrapper>> observable = apiServices.requestOTP(request);
        return retrofitObservableRequest(observable, API_OTP_REQUEST, repository);
    }

    public Disposable verifyOTP(RequestOTP request, LoginSignUpRepository repository) {
        Observable<Response<ResponseOTPVerifyWrapper>> observable = apiServices.verifyOTP(request);
        return retrofitObservableRequest(observable, API_OTP_VERIFY, repository);
    }

    public Disposable logout(BaseRepository repository) {
        Observable<Response<AbstractResponse>> observable = apiServices.logout();
        return retrofitObservableRequest(observable, API_LOGOUT, repository);
    }




}