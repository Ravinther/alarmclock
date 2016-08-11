package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.plus.PlusShare;
import com.mopub.mobileads.util.Base64;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class BridgeMMDevice extends MMJSObject {
    BridgeMMDevice() {
    }

    public MMJSResponse setMMDID(HashMap arguments) {
        String mmdid = (String) arguments.get("mmdid");
        Context context = (Context) this.contextRef.get();
        if (context == null) {
            return null;
        }
        HandShake.sharedHandShake(context).setMMdid(context, mmdid);
        return MMJSResponse.responseWithSuccess("MMDID is set");
    }

    public MMJSResponse enableHardwareAcceleration(HashMap arguments) {
        Log.m9711d("hardware accel call" + arguments);
        String enabled = (String) arguments.get("enabled");
        MMWebView webView = (MMWebView) this.mmWebViewRef.get();
        if (webView == null || webView == null) {
            return null;
        }
        if (Boolean.parseBoolean(enabled)) {
            webView.enableHardwareAcceleration();
        } else {
            webView.disableAllAcceleration();
        }
        return MMJSResponse.responseWithSuccess();
    }

    public MMJSResponse getAvailableSchemes(HashMap arguments) {
        Context context = (Context) this.contextRef.get();
        if (context == null) {
            return null;
        }
        HandShake handShake = HandShake.sharedHandShake(context);
        MMJSResponse response = new MMJSResponse();
        response.result = 1;
        response.response = handShake.getSchemesJSONArray(context);
        return response;
    }

    public MMJSResponse isSchemeAvailable(HashMap arguments) {
        String scheme = (String) arguments.get("scheme");
        if (!scheme.contains(":")) {
            scheme = scheme + ":";
        }
        Context context = (Context) this.contextRef.get();
        if (!(scheme == null || context == null)) {
            if (context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(scheme)), Cast.MAX_MESSAGE_LENGTH).size() > 0) {
                return MMJSResponse.responseWithSuccess(scheme);
            }
        }
        return MMJSResponse.responseWithError(scheme);
    }

    public MMJSResponse getOrientation(HashMap arguments) {
        Context context = (Context) this.contextRef.get();
        if (context == null) {
            return null;
        }
        int orientation = context.getResources().getConfiguration().orientation;
        if (orientation == 0) {
            orientation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getOrientation();
        }
        MMJSResponse response = new MMJSResponse();
        response.result = 1;
        switch (orientation) {
            case Base64.NO_WRAP /*2*/:
                response.response = "landscape";
                return response;
            default:
                response.response = "portrait";
                return response;
        }
    }

    public MMJSResponse getInfo(HashMap arguments) {
        Context context = (Context) this.contextRef.get();
        if (context == null) {
            return null;
        }
        MMJSResponse response = new MMJSResponse();
        response.result = 1;
        response.response = getDeviceInfo(context);
        return response;
    }

    static JSONObject getDeviceInfo(Context context) {
        JSONObject jSONObject;
        try {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("sdkVersion", MMSDK.VERSION);
                jsonObject.put("mmisdk", MMSDK.VERSION);
                jsonObject.put("connection", MMSDK.getConnectionType(context));
                jsonObject.put("platform", "Android");
                if (VERSION.RELEASE != null) {
                    jsonObject.put("version", VERSION.RELEASE);
                }
                if (Build.MODEL != null) {
                    jsonObject.put("device", Build.MODEL);
                }
                jsonObject.put("mmdid", MMSDK.getMMdid(context));
                DisplayMetrics metrics = context.getResources().getDisplayMetrics();
                jsonObject.put("density", new Float(metrics.density));
                jsonObject.put(MMLayout.KEY_HEIGHT, new Integer(metrics.heightPixels));
                jsonObject.put(MMLayout.KEY_WIDTH, new Integer(metrics.widthPixels));
                Locale locale = Locale.getDefault();
                if (locale != null) {
                    jsonObject.put("language", locale.getLanguage());
                    jsonObject.put("country", locale.getCountry());
                }
                JSONObject jsonCookieObject = new JSONObject();
                try {
                    jsonCookieObject.put("name", "MAC-ID");
                    jsonCookieObject.put("path", "/");
                    jsonCookieObject.put("value", MMSDK.macId);
                    JSONArray jsonCookieArray = new JSONArray();
                    try {
                        jsonCookieArray.put(jsonCookieObject);
                        jsonObject.put("cookies", jsonCookieArray);
                        jSONObject = jsonCookieObject;
                        return jsonObject;
                    } catch (JSONException e) {
                        jSONObject = jsonCookieObject;
                        JSONArray jSONArray = jsonCookieArray;
                        return jsonObject;
                    }
                } catch (JSONException e2) {
                    jSONObject = jsonCookieObject;
                    return jsonObject;
                }
            } catch (JSONException e3) {
                return jsonObject;
            }
        } catch (JSONException e4) {
            return null;
        }
    }

    public MMJSResponse getLocation(HashMap arguments) {
        if (MMRequest.location == null) {
            return MMJSResponse.responseWithError("location object has not been set");
        }
        JSONObject jsonObject = null;
        try {
            JSONObject jsonObject2 = new JSONObject();
            try {
                jsonObject2.put("lat", Double.toString(MMRequest.location.getLatitude()));
                jsonObject2.put("long", Double.toString(MMRequest.location.getLongitude()));
                if (MMRequest.location.hasAccuracy()) {
                    jsonObject2.put("ha", Float.toString(MMRequest.location.getAccuracy()));
                    jsonObject2.put("va", Float.toString(MMRequest.location.getAccuracy()));
                }
                if (MMRequest.location.hasSpeed()) {
                    jsonObject2.put("spd", Float.toString(MMRequest.location.getSpeed()));
                }
                if (MMRequest.location.hasBearing()) {
                    jsonObject2.put("brg", Float.toString(MMRequest.location.getBearing()));
                }
                if (MMRequest.location.hasAltitude()) {
                    jsonObject2.put("alt", Double.toString(MMRequest.location.getAltitude()));
                }
                jsonObject2.put("tslr", Long.toString(MMRequest.location.getTime()));
                jsonObject = jsonObject2;
            } catch (JSONException e) {
                jsonObject = jsonObject2;
            }
        } catch (JSONException e2) {
        }
        MMJSResponse response = new MMJSResponse();
        response.result = 1;
        response.response = jsonObject;
        return response;
    }

    public MMJSResponse showMap(HashMap arguments) {
        Context context = (Context) this.contextRef.get();
        String location = (String) arguments.get("location");
        if (context == null || location == null) {
            return null;
        }
        Log.m9712d("Launching Google Maps: %s", location);
        IntentUtils.startActivity(context, new Intent("android.intent.action.VIEW", Uri.parse("geo:" + location)));
        Event.intentStarted(context, Event.INTENT_MAPS, getAdImplId((String) arguments.get("PROPERTY_EXPANDING")));
        return MMJSResponse.responseWithSuccess("Map successfully opened");
    }

    public MMJSResponse call(HashMap arguments) {
        Context context = (Context) this.contextRef.get();
        String number = (String) arguments.get("number");
        if (context == null || number == null) {
            return null;
        }
        Intent intent;
        Log.m9712d("Dialing Phone: %s", number);
        if (Boolean.parseBoolean((String) arguments.get("dial")) && context.checkCallingOrSelfPermission("android.permission.CALL_PHONE") == 0) {
            intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + number));
        } else {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("tel:" + number));
        }
        IntentUtils.startActivity(context, intent);
        Event.intentStarted(context, Event.INTENT_PHONE_CALL, getAdImplId((String) arguments.get("PROPERTY_EXPANDING")));
        return MMJSResponse.responseWithSuccess();
    }

    public MMJSResponse composeSms(HashMap arguments) {
        Context context = (Context) this.contextRef.get();
        String number = (String) arguments.get("number");
        String message = (String) arguments.get("message");
        if (context == null || number == null) {
            return null;
        }
        Log.m9712d("Creating sms: %s", number);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("sms:" + number));
        if (message != null) {
            intent.putExtra("sms_body", message);
        }
        IntentUtils.startActivity(context, intent);
        Event.intentStarted(context, Event.INTENT_TXT_MESSAGE, getAdImplId((String) arguments.get("PROPERTY_EXPANDING")));
        return MMJSResponse.responseWithSuccess("SMS Sent");
    }

    public MMJSResponse composeEmail(HashMap arguments) {
        Context context = (Context) this.contextRef.get();
        String recipients = (String) arguments.get("recipient");
        String subject = (String) arguments.get("subject");
        String message = (String) arguments.get("message");
        if (context == null) {
            return null;
        }
        Log.m9711d("Creating email");
        Intent emailIntent = new Intent("android.intent.action.SEND");
        emailIntent.setType("plain/text");
        if (recipients != null) {
            emailIntent.putExtra("android.intent.extra.EMAIL", recipients.split(","));
        }
        if (subject != null) {
            emailIntent.putExtra("android.intent.extra.SUBJECT", subject);
        }
        if (message != null) {
            emailIntent.putExtra("android.intent.extra.TEXT", message);
        }
        IntentUtils.startActivity(context, emailIntent);
        Event.intentStarted(context, Event.INTENT_EMAIL, getAdImplId((String) arguments.get("PROPERTY_EXPANDING")));
        return MMJSResponse.responseWithSuccess();
    }

    public MMJSResponse openUrl(HashMap arguments) {
        Context context = (Context) this.contextRef.get();
        String url = (String) arguments.get(PlusShare.KEY_CALL_TO_ACTION_URL);
        if (context == null || url == null) {
            return MMJSResponse.responseWithError("URL could not be opened");
        }
        Log.m9712d("Opening: %s", url);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        if (intent.getScheme().startsWith("http") || intent.getScheme().startsWith("https")) {
            Event.intentStarted(context, Event.INTENT_EXTERNAL_BROWSER, getAdImplId((String) arguments.get("PROPERTY_EXPANDING")));
        }
        IntentUtils.startActivity(context, intent);
        return MMJSResponse.responseWithSuccess("Overlay opened");
    }

    public MMJSResponse openAppStore(HashMap arguments) {
        Context context = (Context) this.contextRef.get();
        String id = (String) arguments.get("appId");
        String referrer = (String) arguments.get("referrer");
        if (context == null || id == null) {
            return null;
        }
        Log.m9712d("Opening marketplace: %s", id);
        Intent intent = new Intent("android.intent.action.VIEW");
        if (referrer != null) {
            intent.setData(Uri.parse(String.format("market://details?id=%s&referrer=%s", new Object[]{id, URLEncoder.encode(referrer)})));
        } else {
            intent.setData(Uri.parse("market://details?id=" + id));
        }
        Event.intentStarted(context, Event.INTENT_MARKET, getAdImplId((String) arguments.get("PROPERTY_EXPANDING")));
        IntentUtils.startActivity(context, intent);
        return MMJSResponse.responseWithSuccess();
    }

    public MMJSResponse tweet(HashMap arguments) {
        return null;
    }
}
