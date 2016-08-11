package com.millennialmedia.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import com.google.android.gms.cast.Cast;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import org.apache.http.conn.util.InetAddressUtils;

public final class MMSDK {
    private static final String BASE_URL_TRACK_EVENT = "http://ads.mp.mydas.mobi/pixel?id=";
    static final int CACHE_REQUEST_TIMEOUT = 30000;
    static final int CLOSE_ACTIVITY_DURATION = 400;
    static String COMMA = null;
    public static final String DEFAULT_APID = "28911";
    public static final String DEFAULT_BANNER_APID = "28913";
    public static final String DEFAULT_RECT_APID = "28914";
    static final String EMPTY = "";
    static final int HANDSHAKE_REQUEST_TIMEOUT = 3000;
    static final String JSON_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss ZZZZ";
    public static final int LOG_LEVEL_DEBUG = 1;
    public static final int LOG_LEVEL_ERROR = 0;
    public static final int LOG_LEVEL_INFO = 2;
    @Deprecated
    public static final int LOG_LEVEL_INTERNAL = 4;
    @Deprecated
    public static final int LOG_LEVEL_PRIVATE_VERBOSE = 5;
    public static final int LOG_LEVEL_VERBOSE = 3;
    static final int OPEN_ACTIVITY_DURATION = 600;
    static final String PREFS_NAME = "MillennialMediaSettings";
    static final int REQUEST_TIMEOUT = 10000;
    public static final String SDKLOG = "MillennialMediaSDK";
    public static final String VERSION = "5.1.0-13.08.12.a";
    @Deprecated
    public static boolean debugMode;
    @Deprecated
    static boolean disableAdMinRefresh;
    private static String getMMdidValue;
    private static boolean hasSpeechKit;
    private static boolean isBroadcastingEvents;
    static int logLevel;
    static String macId;
    static Handler mainHandler;
    private static int nextDefaultId;

    /* renamed from: com.millennialmedia.android.MMSDK.1 */
    static class C24841 implements OnClickListener {
        C24841() {
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
        }
    }

    /* renamed from: com.millennialmedia.android.MMSDK.2 */
    static class C24852 extends Iterator {
        final /* synthetic */ Context val$context;

        C24852(Context context) {
            this.val$context = context;
        }

        boolean callback(CachedAd ad) {
            String str = "%s %s is %son disk. Is %sexpired.";
            Object[] objArr = new Object[MMSDK.LOG_LEVEL_INTERNAL];
            objArr[MMSDK.LOG_LEVEL_ERROR] = ad.getTypeString();
            objArr[MMSDK.LOG_LEVEL_DEBUG] = ad.getId();
            objArr[MMSDK.LOG_LEVEL_INFO] = ad.isOnDisk(this.val$context) ? MMSDK.EMPTY : "not ";
            objArr[MMSDK.LOG_LEVEL_VERBOSE] = ad.isExpired() ? MMSDK.EMPTY : "not ";
            Log.m9718i(str, objArr);
            return true;
        }
    }

    static class Event {
        public static final String INTENT_EMAIL = "email";
        public static final String INTENT_EXTERNAL_BROWSER = "browser";
        public static final String INTENT_MAPS = "geo";
        public static final String INTENT_MARKET = "market";
        public static final String INTENT_PHONE_CALL = "tel";
        public static final String INTENT_STREAMING_VIDEO = "streamingVideo";
        public static final String INTENT_TXT_MESSAGE = "sms";
        private static final String KEY_ERROR = "error";
        static final String KEY_INTENT_TYPE = "intentType";
        static final String KEY_INTERNAL_ID = "internalId";
        static final String KEY_PACKAGE_NAME = "packageName";

        /* renamed from: com.millennialmedia.android.MMSDK.Event.1 */
        static class C24861 implements Runnable {
            final /* synthetic */ String val$logString;

            C24861(String str) {
                this.val$logString = str;
            }

            public void run() {
                try {
                    new HttpGetRequest().get(this.val$logString);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* renamed from: com.millennialmedia.android.MMSDK.Event.2 */
        static class C24872 implements Runnable {
            final /* synthetic */ MMAdImpl val$adImpl;

            C24872(MMAdImpl mMAdImpl) {
                this.val$adImpl = mMAdImpl;
            }

            public void run() {
                if (this.val$adImpl != null && this.val$adImpl.requestListener != null) {
                    try {
                        this.val$adImpl.requestListener.onSingleTap(this.val$adImpl.getCallingAd());
                    } catch (Exception exception) {
                        Object[] objArr = new Object[MMSDK.LOG_LEVEL_DEBUG];
                        objArr[MMSDK.LOG_LEVEL_ERROR] = exception;
                        Log.m9727w("Exception raised in your RequestListener: ", objArr);
                    }
                }
            }
        }

        /* renamed from: com.millennialmedia.android.MMSDK.Event.3 */
        static class C24883 implements Runnable {
            final /* synthetic */ MMAdImpl val$adImpl;

            C24883(MMAdImpl mMAdImpl) {
                this.val$adImpl = mMAdImpl;
            }

            public void run() {
                if (this.val$adImpl != null && this.val$adImpl.requestListener != null) {
                    try {
                        this.val$adImpl.requestListener.MMAdRequestIsCaching(this.val$adImpl.getCallingAd());
                    } catch (Exception e) {
                        Object[] objArr = new Object[MMSDK.LOG_LEVEL_DEBUG];
                        objArr[MMSDK.LOG_LEVEL_ERROR] = e;
                        Log.m9727w("Exception raised in your RequestListener: ", objArr);
                    }
                }
            }
        }

        /* renamed from: com.millennialmedia.android.MMSDK.Event.4 */
        static class C24894 implements Runnable {
            final /* synthetic */ MMAdImpl val$adImpl;

            C24894(MMAdImpl mMAdImpl) {
                this.val$adImpl = mMAdImpl;
            }

            public void run() {
                if (this.val$adImpl != null && this.val$adImpl.requestListener != null) {
                    try {
                        this.val$adImpl.requestListener.MMAdOverlayLaunched(this.val$adImpl.getCallingAd());
                    } catch (Exception exception) {
                        Object[] objArr = new Object[MMSDK.LOG_LEVEL_DEBUG];
                        objArr[MMSDK.LOG_LEVEL_ERROR] = exception;
                        Log.m9727w("Exception raised in your RequestListener: ", objArr);
                    }
                }
            }
        }

        /* renamed from: com.millennialmedia.android.MMSDK.Event.5 */
        static class C24905 implements Runnable {
            final /* synthetic */ MMAdImpl val$adImpl;

            C24905(MMAdImpl mMAdImpl) {
                this.val$adImpl = mMAdImpl;
            }

            public void run() {
                if (this.val$adImpl != null && this.val$adImpl.requestListener != null) {
                    try {
                        this.val$adImpl.requestListener.MMAdOverlayClosed(this.val$adImpl.getCallingAd());
                    } catch (Exception exception) {
                        Object[] objArr = new Object[MMSDK.LOG_LEVEL_DEBUG];
                        objArr[MMSDK.LOG_LEVEL_ERROR] = exception;
                        Log.m9727w("Exception raised in your RequestListener: ", objArr);
                    }
                }
            }
        }

        /* renamed from: com.millennialmedia.android.MMSDK.Event.6 */
        static class C24916 implements Runnable {
            final /* synthetic */ MMAdImpl val$adImpl;

            C24916(MMAdImpl mMAdImpl) {
                this.val$adImpl = mMAdImpl;
            }

            public void run() {
                if (this.val$adImpl != null && this.val$adImpl.requestListener != null) {
                    try {
                        this.val$adImpl.requestListener.requestCompleted(this.val$adImpl.getCallingAd());
                    } catch (Exception exception) {
                        Object[] objArr = new Object[MMSDK.LOG_LEVEL_DEBUG];
                        objArr[MMSDK.LOG_LEVEL_ERROR] = exception;
                        Log.m9727w("Exception raised in your RequestListener: ", objArr);
                    }
                }
            }
        }

        /* renamed from: com.millennialmedia.android.MMSDK.Event.7 */
        static class C24927 implements Runnable {
            final /* synthetic */ MMAdImpl val$adImpl;
            final /* synthetic */ MMException val$error;

            C24927(MMAdImpl mMAdImpl, MMException mMException) {
                this.val$adImpl = mMAdImpl;
                this.val$error = mMException;
            }

            public void run() {
                if (this.val$adImpl != null && this.val$adImpl.requestListener != null) {
                    try {
                        this.val$adImpl.requestListener.requestFailed(this.val$adImpl.getCallingAd(), this.val$error);
                    } catch (Exception exception) {
                        Object[] objArr = new Object[MMSDK.LOG_LEVEL_DEBUG];
                        objArr[MMSDK.LOG_LEVEL_ERROR] = exception;
                        Log.m9727w("Exception raised in your RequestListener: ", objArr);
                    }
                }
            }
        }

        Event() {
        }

        protected static void logEvent(String logString) {
            Object[] objArr = new Object[MMSDK.LOG_LEVEL_DEBUG];
            objArr[MMSDK.LOG_LEVEL_ERROR] = logString;
            Log.m9712d("Logging event to: %s", objArr);
            ThreadUtils.execute(new C24861(logString));
        }

        static void adSingleTap(MMAdImpl adImpl) {
            if (adImpl != null) {
                MMSDK.runOnUiThread(new C24872(adImpl));
                if (MMSDK.isBroadcastingEvents) {
                    sendIntent(adImpl.getContext(), new Intent(MMBroadcastReceiver.ACTION_OVERLAY_TAP), adImpl.internalId);
                    sendIntent(adImpl.getContext(), new Intent(MMBroadcastReceiver.ACTION_AD_SINGLE_TAP), adImpl.internalId);
                }
            }
        }

        static void intentStarted(Context context, String intentType, long adImplId) {
            if (MMSDK.isBroadcastingEvents && intentType != null) {
                sendIntent(context, new Intent(MMBroadcastReceiver.ACTION_INTENT_STARTED).putExtra(KEY_INTENT_TYPE, intentType), adImplId);
            }
        }

        static void fetchStartedCaching(MMAdImpl adImpl) {
            if (adImpl == null) {
                Log.m9726w("No Context in the listener: ");
                return;
            }
            MMSDK.runOnUiThread(new C24883(adImpl));
            if (MMSDK.isBroadcastingEvents) {
                sendIntent(adImpl.getContext(), new Intent(MMBroadcastReceiver.ACTION_FETCH_STARTED_CACHING), adImpl.internalId);
            }
        }

        static void displayStarted(MMAdImpl adImpl) {
            if (adImpl == null) {
                Log.m9726w("No Context in the listener: ");
                return;
            }
            if (MMSDK.isBroadcastingEvents) {
                sendIntent(adImpl.getContext(), new Intent(MMBroadcastReceiver.ACTION_DISPLAY_STARTED), adImpl.internalId);
            }
            overlayOpened(adImpl);
        }

        static void overlayOpened(MMAdImpl adImpl) {
            if (adImpl == null) {
                Log.m9726w("No Context in the listener: ");
                return;
            }
            MMSDK.runOnUiThread(new C24894(adImpl));
            overlayOpenedBroadCast(adImpl.getContext(), adImpl.internalId);
        }

        static void overlayOpenedBroadCast(Context context, long adImplId) {
            if (MMSDK.isBroadcastingEvents) {
                sendIntent(context, new Intent(MMBroadcastReceiver.ACTION_OVERLAY_OPENED), adImplId);
            }
        }

        static void overlayClosed(MMAdImpl adImpl) {
            if (adImpl == null) {
                Log.m9726w("No Context in the listener: ");
                return;
            }
            MMSDK.runOnUiThread(new C24905(adImpl));
            if (MMSDK.isBroadcastingEvents && adImpl.getContext() != null) {
                sendIntent(adImpl.getContext(), new Intent(MMBroadcastReceiver.ACTION_OVERLAY_CLOSED), adImpl.internalId);
            }
        }

        static void requestCompleted(MMAdImpl adImpl) {
            if (adImpl == null) {
                Log.m9726w("No Context in the listener: ");
                return;
            }
            MMSDK.runOnUiThread(new C24916(adImpl));
            if (MMSDK.isBroadcastingEvents) {
                sendIntent(adImpl.getContext(), new Intent(adImpl.getRequestCompletedAction()), adImpl.internalId);
            }
        }

        static void requestFailed(MMAdImpl adImpl, MMException error) {
            if (adImpl == null) {
                Log.m9726w("No Context in the listener: ");
                return;
            }
            MMSDK.runOnUiThread(new C24927(adImpl, error));
            if (MMSDK.isBroadcastingEvents) {
                sendIntent(adImpl.getContext(), new Intent(adImpl.getRequestFailedAction()).putExtra(KEY_ERROR, error), adImpl.internalId);
            }
        }

        private static final void sendIntent(Context context, Intent intent, long adImplId) {
            if (context != null) {
                intent.addCategory(MMBroadcastReceiver.CATEGORY_SDK);
                if (adImplId != -4) {
                    intent.putExtra(KEY_INTERNAL_ID, adImplId);
                }
                intent.putExtra(KEY_PACKAGE_NAME, context.getPackageName());
                String type = intent.getStringExtra(KEY_INTENT_TYPE);
                if (TextUtils.isEmpty(type)) {
                    type = MMSDK.EMPTY;
                } else {
                    Object[] objArr = new Object[MMSDK.LOG_LEVEL_DEBUG];
                    objArr[MMSDK.LOG_LEVEL_ERROR] = type;
                    type = String.format(" Type[%s]", objArr);
                }
                Log.m9723v(" @@ Intent: " + intent.getAction() + " " + type + " for " + adImplId);
                context.sendBroadcast(intent);
            }
        }
    }

    static class Log {
        Log() {
        }

        static void m9717i(String message) {
            android.util.Log.i(MMSDK.SDKLOG, message);
        }

        static void m9718i(String format, Object... args) {
            android.util.Log.i(MMSDK.SDKLOG, String.format(format, args));
        }

        static void m9719i(Throwable tr) {
            m9717i(android.util.Log.getStackTraceString(tr));
        }

        static void m9726w(String message) {
            android.util.Log.w(MMSDK.SDKLOG, message);
        }

        static void m9727w(String format, Object... args) {
            android.util.Log.w(MMSDK.SDKLOG, String.format(format, args));
        }

        static void m9728w(Throwable tr) {
            m9726w(android.util.Log.getStackTraceString(tr));
        }

        static void m9714e(String message) {
            android.util.Log.e(MMSDK.SDKLOG, message);
        }

        static void m9715e(String format, Object... args) {
            android.util.Log.e(MMSDK.SDKLOG, String.format(format, args));
        }

        static void m9716e(Throwable tr) {
            m9714e(android.util.Log.getStackTraceString(tr));
        }

        static void m9711d(String message) {
            if (MMSDK.logLevel >= MMSDK.LOG_LEVEL_DEBUG) {
                android.util.Log.i(MMSDK.SDKLOG, "Diagnostic - " + message);
            }
        }

        static void m9712d(String format, Object... args) {
            if (MMSDK.logLevel >= MMSDK.LOG_LEVEL_DEBUG) {
                android.util.Log.i(MMSDK.SDKLOG, "Diagnostic - " + String.format(format, args));
            }
        }

        static void m9713d(Throwable tr) {
            if (MMSDK.logLevel >= MMSDK.LOG_LEVEL_DEBUG) {
                m9711d(android.util.Log.getStackTraceString(tr));
            }
        }

        static void m9723v(String message) {
            if (MMSDK.logLevel >= MMSDK.LOG_LEVEL_VERBOSE) {
                android.util.Log.i(MMSDK.SDKLOG, "Verbose - " + message);
            }
        }

        static void m9724v(String format, Object... args) {
            if (MMSDK.logLevel >= MMSDK.LOG_LEVEL_VERBOSE) {
                android.util.Log.i(MMSDK.SDKLOG, "Verbose - " + String.format(format, args));
            }
        }

        static void m9725v(Throwable tr) {
            if (MMSDK.logLevel >= MMSDK.LOG_LEVEL_VERBOSE) {
                m9723v(android.util.Log.getStackTraceString(tr));
            }
        }

        static void m9720p(String message) {
            if (MMSDK.logLevel > MMSDK.LOG_LEVEL_VERBOSE) {
                android.util.Log.i(MMSDK.SDKLOG, "Private - " + message);
            }
        }

        static void m9721p(String format, Object... args) {
            if (MMSDK.logLevel > MMSDK.LOG_LEVEL_VERBOSE) {
                android.util.Log.i(MMSDK.SDKLOG, "Private - " + String.format(format, args));
            }
        }

        static void m9722p(Throwable tr) {
            if (MMSDK.logLevel > MMSDK.LOG_LEVEL_VERBOSE) {
                m9720p(android.util.Log.getStackTraceString(tr));
            }
        }
    }

    private MMSDK() {
    }

    static {
        disableAdMinRefresh = false;
        nextDefaultId = 1897808289;
        COMMA = ",";
        mainHandler = new Handler(Looper.getMainLooper());
        getMMdidValue = null;
        hasSpeechKit = false;
        try {
            System.loadLibrary("nmsp_speex");
            hasSpeechKit = true;
        } catch (UnsatisfiedLinkError e) {
        }
    }

    public static int getDefaultAdId() {
        int i;
        synchronized (MMSDK.class) {
            i = nextDefaultId + LOG_LEVEL_DEBUG;
            nextDefaultId = i;
        }
        return i;
    }

    public static void resetCache(Context context) {
        AdCache.resetCache(context);
    }

    public static void setBroadcastEvents(boolean enable) {
        isBroadcastingEvents = enable;
    }

    public static boolean getBroadcastEvents() {
        return isBroadcastingEvents;
    }

    public static void setLogLevel(int level) {
        logLevel = level;
    }

    public static int getLogLevel() {
        return logLevel;
    }

    static void runOnUiThread(Runnable action) {
        if (isUiThread()) {
            action.run();
        } else {
            mainHandler.post(action);
        }
    }

    static void runOnUiThreadDelayed(Runnable action, long delayMillis) {
        mainHandler.postDelayed(action, delayMillis);
    }

    static boolean isUiThread() {
        return mainHandler.getLooper() == Looper.myLooper();
    }

    static boolean isConnected(Context context) {
        boolean z = true;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        if (connectivityManager.getActiveNetworkInfo() == null || !connectivityManager.getActiveNetworkInfo().isConnected()) {
            z = false;
        }
        return z;
    }

    static String getIpAddress(Context context) {
        try {
            StringBuilder ips = new StringBuilder();
            Enumeration en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                Enumeration enumIpAddr = ((NetworkInterface) en.nextElement()).getInetAddresses();
                while (enumIpAddr.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        if (ips.length() > 0) {
                            ips.append(',');
                        }
                        String inetAddressHost = inetAddress.getHostAddress().toUpperCase();
                        if (InetAddressUtils.isIPv4Address(inetAddressHost)) {
                            ips.append(inetAddressHost);
                        } else {
                            int delim = inetAddressHost.indexOf(37);
                            ips.append(delim < 0 ? inetAddressHost : inetAddressHost.substring(LOG_LEVEL_ERROR, delim));
                        }
                    }
                }
            }
            return ips.toString();
        } catch (Throwable ex) {
            Log.m9716e(ex);
            return EMPTY;
        }
    }

    static String getConnectionType(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return "unknown";
        }
        if (connectivityManager.getActiveNetworkInfo() == null || !connectivityManager.getActiveNetworkInfo().isConnected()) {
            return "offline";
        }
        int type = connectivityManager.getActiveNetworkInfo().getType();
        int subType = connectivityManager.getActiveNetworkInfo().getSubtype();
        if (type == LOG_LEVEL_DEBUG) {
            return "wifi";
        }
        if (type != 0) {
            return "unknown";
        }
        switch (subType) {
            case LOG_LEVEL_DEBUG /*1*/:
                return "gprs";
            case LOG_LEVEL_INFO /*2*/:
                return "edge";
            case LOG_LEVEL_VERBOSE /*3*/:
                return "umts";
            case LOG_LEVEL_INTERNAL /*4*/:
                return "cdma";
            case LOG_LEVEL_PRIVATE_VERBOSE /*5*/:
                return "evdo_0";
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return "evdo_a";
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                return "1xrtt";
            case Base64.URL_SAFE /*8*/:
                return "hsdpa";
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                return "hsupa";
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                return "hspa";
            case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                return "iden";
            case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                return "evdo_b";
            case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                return "lte";
            case C2513R.styleable.MMAdView_height /*14*/:
                return "ehrpd";
            case C2513R.styleable.MMAdView_width /*15*/:
                return "hspap";
            default:
                return "unknown";
        }
    }

    static synchronized String getMMdid(Context context) {
        String str = null;
        synchronized (MMSDK.class) {
            if (getMMdidValue != null) {
                str = getMMdidValue;
            } else {
                String mmdid = Secure.getString(context.getContentResolver(), "android_id");
                if (mmdid != null) {
                    StringBuilder mmdidBuilder = new StringBuilder("mmh_");
                    try {
                        mmdidBuilder.append(byteArrayToString(MessageDigest.getInstance("MD5").digest(mmdid.getBytes())));
                        mmdidBuilder.append("_");
                        mmdidBuilder.append(byteArrayToString(MessageDigest.getInstance("SHA1").digest(mmdid.getBytes())));
                        str = mmdidBuilder.toString();
                        getMMdidValue = str;
                    } catch (Exception e) {
                        Log.m9723v(e.getMessage());
                    }
                }
            }
        }
        return str;
    }

    static synchronized void setMMdid(String value) {
        synchronized (MMSDK.class) {
            getMMdidValue = value;
        }
    }

    static String byteArrayToString(byte[] ba) {
        StringBuilder hex = new StringBuilder(ba.length * LOG_LEVEL_INFO);
        for (int i = LOG_LEVEL_ERROR; i < ba.length; i += LOG_LEVEL_DEBUG) {
            Object[] objArr = new Object[LOG_LEVEL_DEBUG];
            objArr[LOG_LEVEL_ERROR] = Byte.valueOf(ba[i]);
            hex.append(String.format("%02X", objArr));
        }
        return hex.toString();
    }

    private static String getDensityString(Context context) {
        return Float.toString(getDensity(context));
    }

    static float getDensity(Context context) {
        DisplayMetrics metrics = getMetrics(context);
        if (metrics == null) {
            return 1.0f;
        }
        return metrics.density;
    }

    static void checkPermissions(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
            createMissingPermissionDialog(context, "INTERNET permission").show();
        }
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
            createMissingPermissionDialog(context, "ACCESS_NETWORK_STATE permission").show();
        }
    }

    private static AlertDialog createMissingPermissionDialog(Context context, String permission) {
        AlertDialog dialog = new Builder(context).create();
        dialog.setTitle("Whoops!");
        Object[] objArr = new Object[LOG_LEVEL_DEBUG];
        objArr[LOG_LEVEL_ERROR] = permission;
        dialog.setMessage(String.format("The developer has forgot to declare the %s in the manifest file. Please reach out to the developer to remove this error.", objArr));
        dialog.setButton(-3, "OK", new C24841());
        dialog.show();
        return dialog;
    }

    static void checkActivity(Context context) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context, "com.millennialmedia.android.MMActivity"), Cast.MAX_NAMESPACE_LENGTH);
        } catch (NameNotFoundException e) {
            Log.m9714e("Activity MMActivity not declared in AndroidManifest.xml");
            e.printStackTrace();
            createMissingPermissionDialog(context, "MMActivity class").show();
        }
    }

    static boolean isCachedVideoSupportedOnDevice(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != -1 && (!VERSION.SDK.equalsIgnoreCase("8") || (Environment.getExternalStorageState().equals("mounted") && AdCache.isExternalEnabled));
    }

    static String getMcc(Context context) {
        Configuration config = getConfiguration(context);
        if (config.mcc == 0) {
            String networkOperator = getNetworkOperator(context);
            if (networkOperator != null && networkOperator.length() >= 6) {
                return networkOperator.substring(LOG_LEVEL_ERROR, LOG_LEVEL_VERBOSE);
            }
        }
        return String.valueOf(config.mcc);
    }

    static String getMnc(Context context) {
        Configuration config = getConfiguration(context);
        if (config.mnc == 0) {
            String networkOperator = getNetworkOperator(context);
            if (networkOperator != null && networkOperator.length() >= 6) {
                return networkOperator.substring(LOG_LEVEL_VERBOSE);
            }
        }
        return String.valueOf(config.mnc);
    }

    static Configuration getConfiguration(Context context) {
        return context.getResources().getConfiguration();
    }

    static String getNetworkOperator(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
    }

    static void insertUrlCommonValues(Context context, Map paramsMap) {
        paramsMap.put("density", getDensityString(context));
        paramsMap.put("hpx", getDpiHeight(context));
        paramsMap.put("wpx", getDpiWidth(context));
        paramsMap.put("sk", hasSpeechKit(context));
        paramsMap.put("mic", hasVoiceAbility(context));
        if (isCachedVideoSupportedOnDevice(context)) {
            paramsMap.put("cachedvideo", "true");
        } else {
            paramsMap.put("cachedvideo", "false");
        }
        if (Build.MODEL != null) {
            paramsMap.put("dm", Build.MODEL);
        }
        if (VERSION.RELEASE != null) {
            paramsMap.put("dv", "Android" + VERSION.RELEASE);
        }
        String mmdid = getMMdid(context);
        if (mmdid != null) {
            paramsMap.put("mmdid", mmdid);
        }
        paramsMap.put("sdkversion", VERSION);
        paramsMap.put("mmisdk", VERSION);
        paramsMap.put("mcc", getMcc(context));
        paramsMap.put("mnc", getMnc(context));
        Locale locale = Locale.getDefault();
        if (locale != null) {
            paramsMap.put("language", locale.getLanguage());
            paramsMap.put("country", locale.getCountry());
        }
        try {
            String pkid = context.getPackageName();
            paramsMap.put("pkid", pkid);
            PackageManager pm = context.getPackageManager();
            paramsMap.put("pknm", pm.getApplicationLabel(pm.getApplicationInfo(pkid, LOG_LEVEL_ERROR)).toString());
        } catch (Exception e) {
        }
        if (debugMode) {
            paramsMap.put("debug", "true");
        }
        String schemes = HandShake.sharedHandShake(context).getSchemesList(context);
        if (schemes != null) {
            paramsMap.put("appsids", schemes);
        }
        String vid = AdCache.getCachedVideoList(context);
        if (vid != null) {
            paramsMap.put("vid", vid);
        }
        try {
            String connectionType = getConnectionType(context);
            StatFs statFs;
            if (AdCache.isExternalStorageAvailable(context)) {
                statFs = new StatFs(AdCache.getCacheDirectory(context).getAbsolutePath());
            } else {
                statFs = new StatFs(context.getFilesDir().getPath());
            }
            String freeSpace = Long.toString(((long) stat.getAvailableBlocks()) * ((long) stat.getBlockSize()));
            String devicePluggedIn = null;
            String deviceBatteryLevel = null;
            Intent intent = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intent != null) {
                devicePluggedIn = intent.getIntExtra("plugged", LOG_LEVEL_ERROR) == 0 ? "false" : "true";
                deviceBatteryLevel = Integer.toString((int) (((float) intent.getIntExtra("level", LOG_LEVEL_ERROR)) * (100.0f / ((float) intent.getIntExtra("scale", 100)))));
            }
            if (deviceBatteryLevel != null && deviceBatteryLevel.length() > 0) {
                paramsMap.put("bl", deviceBatteryLevel);
            }
            if (devicePluggedIn != null && devicePluggedIn.length() > 0) {
                paramsMap.put("plugged", devicePluggedIn);
            }
            if (freeSpace.length() > 0) {
                paramsMap.put("space", freeSpace);
            }
            if (connectionType != null) {
                paramsMap.put("conn", connectionType);
            }
            String ip = URLEncoder.encode(getIpAddress(context), "UTF-8");
            if (!TextUtils.isEmpty(ip)) {
                paramsMap.put("pip", ip);
            }
        } catch (Throwable e2) {
            Log.m9725v(e2);
        }
        MMRequest.insertLocation(paramsMap);
    }

    static String getDpiWidth(Context context) {
        if (needsRawDisplayMethod()) {
            String width = getRawSize(context, "getRawWidth");
            if (!TextUtils.isEmpty(width)) {
                return width;
            }
        }
        return getDpiWidthFrom(getMetrics(context));
    }

    static DisplayMetrics getMetrics(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        if (needsRealDisplayMethod()) {
            try {
                Display.class.getMethod("getRealMetrics", new Class[LOG_LEVEL_ERROR]).invoke(metrics, new Object[LOG_LEVEL_ERROR]);
            } catch (Exception e) {
            }
        }
        return metrics;
    }

    static String getDpiHeight(Context context) {
        if (needsRawDisplayMethod()) {
            String height = getRawSize(context, "getRawHeight");
            if (!TextUtils.isEmpty(height)) {
                return height;
            }
        }
        return getDpiHeightFrom(getMetrics(context));
    }

    private static String getRawSize(Context context, String functionName) {
        String size = null;
        if (context instanceof Activity) {
            try {
                size = String.valueOf(((Integer) Display.class.getMethod(functionName, new Class[LOG_LEVEL_ERROR]).invoke(((Activity) context).getWindowManager().getDefaultDisplay(), new Object[LOG_LEVEL_ERROR])).intValue());
            } catch (Exception e) {
            }
        }
        return size;
    }

    private static boolean needsRawDisplayMethod() {
        return Integer.parseInt(VERSION.SDK) >= 13 && Integer.parseInt(VERSION.SDK) <= 16;
    }

    private static boolean needsRealDisplayMethod() {
        return Integer.parseInt(VERSION.SDK) >= 17;
    }

    private static String getDpiHeightFrom(DisplayMetrics metrics) {
        return Integer.toString(metrics.heightPixels);
    }

    private static String getDpiWidthFrom(DisplayMetrics metrics) {
        return Integer.toString(metrics.widthPixels);
    }

    public static void trackEvent(Context context, String eventId) {
        if (!TextUtils.isEmpty(eventId)) {
            String mmdid = getMMdid(context);
            if (!TextUtils.isEmpty(mmdid)) {
                HttpUtils.executeUrl(BASE_URL_TRACK_EVENT + eventId + "&mmdid=" + mmdid);
            }
        }
    }

    public static void trackConversion(Context context, String goalId) {
        MMConversionTracker.trackConversion(context, goalId, null);
    }

    public static void trackConversion(Context context, String goalId, MMRequest request) {
        MMConversionTracker.trackConversion(context, goalId, request);
    }

    private static String hasSpeechKit(Context context) {
        if (hasSpeechKit) {
            return "true";
        }
        return "false";
    }

    public static void initialize(Context context) {
        HandShake handShake = HandShake.sharedHandShake(context);
        handShake.sendInitRequest();
        handShake.startSession();
    }

    static String hasVoiceAbility(Context context) {
        if (!context.getPackageManager().hasSystemFeature("android.hardware.microphone")) {
            return "false";
        }
        if (getMediaVolume(context) == 0) {
            return "false";
        }
        int ringermode = ((AudioManager) context.getApplicationContext().getSystemService("audio")).getRingerMode();
        if (ringermode == 0 || ringermode == LOG_LEVEL_DEBUG) {
            return "false";
        }
        return "true";
    }

    static int getMediaVolume(Context context) {
        return ((AudioManager) context.getApplicationContext().getSystemService("audio")).getStreamVolume(LOG_LEVEL_VERBOSE);
    }

    static void printDiagnostics(MMAdImpl adImpl) {
        if (adImpl != null) {
            Context context = adImpl.getContext();
            Object[] objArr = new Object[LOG_LEVEL_DEBUG];
            objArr[LOG_LEVEL_ERROR] = Integer.valueOf(adImpl.getId());
            Log.m9718i("MMAd External ID: %d", objArr);
            objArr = new Object[LOG_LEVEL_DEBUG];
            objArr[LOG_LEVEL_ERROR] = Long.valueOf(adImpl.internalId);
            Log.m9718i("MMAd Internal ID: %d", objArr);
            objArr = new Object[LOG_LEVEL_DEBUG];
            objArr[LOG_LEVEL_ERROR] = adImpl.apid;
            Log.m9718i("APID: %s", objArr);
            String str = "SD card is %savailable.";
            Object[] objArr2 = new Object[LOG_LEVEL_DEBUG];
            objArr2[LOG_LEVEL_ERROR] = AdCache.isExternalStorageAvailable(context) ? EMPTY : "not ";
            Log.m9718i(str, objArr2);
            if (context != null) {
                objArr = new Object[LOG_LEVEL_DEBUG];
                objArr[LOG_LEVEL_ERROR] = context.getPackageName();
                Log.m9718i("Package: %s", objArr);
                objArr = new Object[LOG_LEVEL_DEBUG];
                objArr[LOG_LEVEL_ERROR] = getMMdid(context);
                Log.m9718i("MMDID: %s", objArr);
                Log.m9717i("Permissions:");
                str = "android.permission.ACCESS_NETWORK_STATE is %spresent";
                objArr2 = new Object[LOG_LEVEL_DEBUG];
                objArr2[LOG_LEVEL_ERROR] = context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1 ? "not " : EMPTY;
                Log.m9718i(str, objArr2);
                str = "android.permission.INTERNET is %spresent";
                objArr2 = new Object[LOG_LEVEL_DEBUG];
                objArr2[LOG_LEVEL_ERROR] = context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1 ? "not " : EMPTY;
                Log.m9718i(str, objArr2);
                str = "android.permission.WRITE_EXTERNAL_STORAGE is %spresent";
                objArr2 = new Object[LOG_LEVEL_DEBUG];
                objArr2[LOG_LEVEL_ERROR] = context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == -1 ? "not " : EMPTY;
                Log.m9718i(str, objArr2);
                str = "android.permission.VIBRATE is %spresent";
                objArr2 = new Object[LOG_LEVEL_DEBUG];
                objArr2[LOG_LEVEL_ERROR] = context.checkCallingOrSelfPermission("android.permission.VIBRATE") == -1 ? "not " : EMPTY;
                Log.m9718i(str, objArr2);
                str = "android.permission.ACCESS_COARSE_LOCATION is %spresent";
                objArr2 = new Object[LOG_LEVEL_DEBUG];
                objArr2[LOG_LEVEL_ERROR] = context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == -1 ? "not " : EMPTY;
                Log.m9718i(str, objArr2);
                str = "android.permission.ACCESS_FINE_LOCATION is %spresent";
                objArr2 = new Object[LOG_LEVEL_DEBUG];
                objArr2[LOG_LEVEL_ERROR] = context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == -1 ? "not " : EMPTY;
                Log.m9718i(str, objArr2);
                Log.m9717i("Cached Ads:");
                AdCache.iterateCachedAds(context, LOG_LEVEL_INFO, new C24852(context));
            }
        }
    }

    static String getSupportsSms(Context context) {
        return String.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.telephony"));
    }

    static String getSupportsTel(Context context) {
        return String.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.telephony"));
    }

    static String getOrientation(Context context) {
        switch (context.getResources().getConfiguration().orientation) {
            case LOG_LEVEL_DEBUG /*1*/:
                return "portrait";
            case LOG_LEVEL_INFO /*2*/:
                return "landscape";
            case LOG_LEVEL_VERBOSE /*3*/:
                return "square";
            default:
                return "default";
        }
    }

    static final String getOrientationLocked(Context context) {
        return System.getString(context.getContentResolver(), "accelerometer_rotation").equals("1") ? "false" : "true";
    }

    static boolean removeAccelForJira1164() {
        return Integer.parseInt(VERSION.SDK) >= 14;
    }

    static boolean hasSetTranslationMethod() {
        return Integer.parseInt(VERSION.SDK) >= 11;
    }

    static boolean supportsFullScreenInline() {
        return Integer.parseInt(VERSION.SDK) >= 11;
    }
}
