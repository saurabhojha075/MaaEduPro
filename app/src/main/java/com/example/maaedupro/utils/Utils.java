package com.example.maaedupro.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.example.maaedupro.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

import static com.example.maaedupro.utils.Constants.Global.*;
import static com.example.maaedupro.utils.Constants.LoginMode.*;
import static com.example.maaedupro.utils.Constants.TimeFormats.TIME_SERVER;
import static com.example.maaedupro.utils.TextUtils.isNotEmpty;

public class Utils {
    private static Toast toast;
    private static Dialog dialog;

    public static void showShortToast(Context context, String msg) {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP, 0, 250);
        toast.show();
    }

    //Keyboard
    public static void showKeyboard(Activity activity, boolean show) {
        try {
            InputMethodManager imgr = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imgr != null) {
                View view = activity.getCurrentFocus();
                if (show)
                    imgr.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                else if (view != null) imgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void showKeyboard(Activity activity, boolean show, View view) {
        try {
            InputMethodManager imgr = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (show)
                imgr.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
            else if (view != null) imgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Toast
    public static void showToast(Context context, String message) {
        if (context != null) {
            if (toast == null) {
                toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP, 0, 250);
            } else toast.setText(message);
            toast.show();
        }
    }

    public static void showLoader(Context context, String message) {
        if (dialog == null || !dialog.isShowing()) {
            try {
                if (context != null) {
                    dialog = createLoader(context);
                    Log.v("loader:", "show loader pop-up");
                    dialog.show();
                }
            } catch (Exception e) {
                Log.e("loader exception: ", e.getStackTrace().toString());
                showToast(context, message);
            }
        }
    }


    private static Dialog createLoader(Context context) {
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_app_loader);
        dialog.setCancelable(false);
        final Window window = dialog.getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.setGravity(Gravity.CENTER);
        return dialog;
    }

    //Internet Check
    public static boolean isInternetConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }


    //Cred Validation
    public static boolean isValidEmail(String email) {
        //AppLog.e(TAG, "Email: " + email);
        return (isNotEmpty(email)
                && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
                && Pattern.matches(PATTERN_EMAIL, email));
    }

    public static boolean isValidPhoneNumber(String number) {
        //AppLog.e(TAG, "Email: " + email);
        return (isNotEmpty(number) && number.length() == 10 && Pattern.matches(PATTERN_PHONE_NUMBER, number));
    }

    public static boolean isValidPassword(String password) {
        return Pattern.matches(PATTERN_PASSWORD, password);
    }

    public static int getLoginMode(String username) {
        if (isValidEmail(username)) return LOGIN_MODE_EMAIL;
        else if (isValidPhoneNumber(username)) return LOGIN_MODE_PHONE;
        else return LOGIN_MODE_NONE;
    }


    //Age Formatting
    public static int getAge(String sDOB) {
        if (isNotEmpty(sDOB)) {
            SimpleDateFormat sdf = new SimpleDateFormat(TIME_SERVER);
            try {
                Calendar today = Calendar.getInstance();
                Calendar dob = Calendar.getInstance();
                dob.setTime(sdf.parse(sDOB));

                int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
                if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
                    age--;

                return age;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

}