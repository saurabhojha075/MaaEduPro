package com.example.maaedupro.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {

    public static final String PREF_NAME = "HumainHealth";

    private static Context context;
    private static SharedPreferences prefs;


    public static void init(Context con) {
        context = con;
        prefs = context.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
    }

    public static void clear() {
        prefs.edit().clear().apply();
    }


    public static String getPrefsString(String key) {
        return prefs.getString(key, "");
    }

    public static boolean getPrefsBoolean(String key) {
        return prefs.getBoolean(key, false);
    }

    public static boolean getPrefsBooleanDefault(String key, boolean defaultVal) {
        return prefs.getBoolean(key, defaultVal);
    }

    public static int getPrefsInt(String key) {
        return prefs.getInt(key, 0);
    }

    public static long getPrefsLong(String key) {
        return prefs.getLong(key, 0);
    }

    public static Float getPrefsFloat(String key) {
        return prefs.getFloat(key, 0f);
    }

    public static Float getPrefsFloat(String key, Float defaultValue) {
        return prefs.getFloat(key, defaultValue);
    }

    public static void setPrefs(String key, String value) {
        prefs.edit().putString(key, value).apply();
    }

    public static void setPrefs(String key, boolean value) {
        prefs.edit().putBoolean(key, value).apply();
    }

    public static void setPrefs(String key, int value) {
        prefs.edit().putInt(key, value).apply();
    }

    public static void setPrefs(String key, long value) {
        prefs.edit().putLong(key, value).apply();
    }

    public static void setPrefs(String key, float value) {
        prefs.edit().putFloat(key, value).apply();
    }


    public static void removePref(String key) {
        prefs.edit().remove(key).apply();
    }
}