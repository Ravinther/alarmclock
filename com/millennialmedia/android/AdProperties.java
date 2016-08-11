package com.millennialmedia.android;

import android.content.Context;
import android.util.DisplayMetrics;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class AdProperties {
    WeakReference contextRef;

    AdProperties(Context context) {
        this.contextRef = new WeakReference(context);
    }

    public JSONObject getAdProperties() {
        JSONObject adProps = new JSONObject();
        try {
            adProps.put("screen", getScreen());
            adProps.put("ad", getAd());
            adProps.put("do", MMSDK.getOrientation(getContext()));
            adProps.put("supports", getSupports());
            adProps.put("device", BridgeMMDevice.getDeviceInfo(getContext()));
            adProps.put("permissions", getPermissions());
            adProps.put("maxSize", getScreen());
        } catch (JSONException e) {
        }
        return adProps;
    }

    Context getContext() {
        return (Context) this.contextRef.get();
    }

    private JSONObject getPermissions() {
        JSONObject params = new JSONObject();
        params.put("android.permission.ACCESS_FINE_LOCATION", getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0);
        return params;
    }

    private JSONObject getScreen() {
        JSONObject params = new JSONObject();
        params.put(MMLayout.KEY_HEIGHT, getScreenDpiIndependentHeight());
        params.put(MMLayout.KEY_WIDTH, getScreenDpiIndependentWidth());
        return params;
    }

    String getScreenDpiIndependentHeight() {
        DisplayMetrics metrics = MMSDK.getMetrics(getContext());
        return String.valueOf((int) (((float) metrics.heightPixels) / metrics.density));
    }

    String getScreenDpiIndependentWidth() {
        DisplayMetrics metrics = MMSDK.getMetrics(getContext());
        return String.valueOf((int) (((float) metrics.widthPixels) / metrics.density));
    }

    private JSONObject getAd() {
        JSONObject params = new JSONObject();
        params.put(MMLayout.KEY_HEIGHT, getAdDpiIndependentHeight());
        params.put(MMLayout.KEY_WIDTH, getAdDpiIndependentWidth());
        return params;
    }

    String getAdDpiIndependentHeight() {
        return getScreenDpiIndependentHeight();
    }

    String getAdDpiIndependentWidth() {
        return getScreenDpiIndependentWidth();
    }

    private JSONObject getSupports() {
        JSONObject params = new JSONObject();
        Context context = getContext();
        params.put(Event.INTENT_TXT_MESSAGE, MMSDK.getSupportsSms(context));
        params.put(Event.INTENT_PHONE_CALL, MMSDK.getSupportsTel(context));
        params.put("calendar", "false");
        params.put("storePicture", "false");
        params.put("inlineVideo", "true");
        return params;
    }
}
