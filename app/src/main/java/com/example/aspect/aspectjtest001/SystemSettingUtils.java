package com.example.aspect.aspectjtest001;

import android.content.ContentResolver;
import android.provider.Settings;
import android.text.TextUtils;

final class SystemSettingUtils {

    private static final String NULL_STRING = null;

    private SystemSettingUtils() {

    }

    public static int getInt(ContentResolver resolver, String key) {

        if (resolver == null || TextUtils.isEmpty(key)) {
            return 0;
        }
        int value = 0;
        try {
            value = Settings.System.getInt(resolver, key);
        } catch (Exception e) {
            e.printStackTrace();
            value = 0;
        }
        return value;
    }

    public static long getLong(ContentResolver resolver, String key) {

        if (resolver == null || TextUtils.isEmpty(key)) {
            return 0;
        }
        long value = 0;
        try {
            value = Settings.System.getLong(resolver, key);
        } catch (Exception e) {
            e.printStackTrace();
            value = 0;
        }
        return value;
    }

    public static String getString(ContentResolver resolver, String key, String def) {

        if (resolver == null || TextUtils.isEmpty(key)) {
            return def;
        }
        String value = null;
        try {
            value = Settings.System.getString(resolver, key);
        } catch (Exception e) {
            e.printStackTrace();
            value = def;
        }
        return value;
    }

    public static String getString(ContentResolver resolver, String key) {

        if (resolver == null || TextUtils.isEmpty(key)) {
            return NULL_STRING;
        }
        String value = null;
        try {
            value = Settings.System.getString(resolver, key);
        } catch (Exception e) {
            e.printStackTrace();
            value = NULL_STRING;
        }
        return value;
    }

    public static void putInt(ContentResolver resolver, String key, int value) {

        if (resolver == null || TextUtils.isEmpty(key)) {
            return;
        }
        try {
            Settings.System.putInt(resolver, key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void putLong(ContentResolver resolver, String key, long value) {

        if (resolver == null || TextUtils.isEmpty(key)) {
            return;
        }
        try {
            Settings.System.putLong(resolver, key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void putString(ContentResolver resolver, String key, String value) {

        if (resolver == null || TextUtils.isEmpty(key) || TextUtils.isEmpty(value)) {
            return;
        }
        try {
            Settings.System.putString(resolver, key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
