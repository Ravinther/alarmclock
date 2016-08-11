package com.mopub.common.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.os.StatFs;
import android.provider.Settings.Secure;
import com.mopub.common.util.Reflection.MethodBuilder;
import com.mopub.mobileads.util.Base64;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import org.apache.http.conn.util.InetAddressUtils;

public class DeviceUtils {
    private static final int MAX_DISK_CACHE_SIZE = 104857600;
    private static final int MAX_MEMORY_CACHE_SIZE = 31457280;
    private static final int MIN_DISK_CACHE_SIZE = 31457280;

    /* renamed from: com.mopub.common.util.DeviceUtils.1 */
    static /* synthetic */ class C25861 {
        static final /* synthetic */ int[] $SwitchMap$com$mopub$common$util$DeviceUtils$IP;

        static {
            $SwitchMap$com$mopub$common$util$DeviceUtils$IP = new int[IP.values().length];
            try {
                $SwitchMap$com$mopub$common$util$DeviceUtils$IP[IP.IPv4.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mopub$common$util$DeviceUtils$IP[IP.IPv6.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum IP {
        IPv4,
        IPv6;

        private boolean matches(String address) {
            switch (C25861.$SwitchMap$com$mopub$common$util$DeviceUtils$IP[ordinal()]) {
                case Base64.NO_PADDING /*1*/:
                    return InetAddressUtils.isIPv4Address(address);
                case Base64.NO_WRAP /*2*/:
                    return InetAddressUtils.isIPv6Address(address);
                default:
                    return false;
            }
        }

        private String toString(String address) {
            switch (C25861.$SwitchMap$com$mopub$common$util$DeviceUtils$IP[ordinal()]) {
                case Base64.NO_PADDING /*1*/:
                    return address;
                case Base64.NO_WRAP /*2*/:
                    return address.split("%")[0];
                default:
                    return null;
            }
        }
    }

    private DeviceUtils() {
    }

    public static String getIpAddress(IP ip) {
        Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
        while (it.hasNext()) {
            Iterator i$ = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
            while (i$.hasNext()) {
                InetAddress address = (InetAddress) i$.next();
                if (!address.isLoopbackAddress()) {
                    String hostAddress = address.getHostAddress().toUpperCase();
                    if (ip.matches(hostAddress)) {
                        return ip.toString(hostAddress);
                    }
                }
            }
        }
        return null;
    }

    public static String getHashedUdid(Context context) {
        if (context == null) {
            return null;
        }
        return Utils.sha1(Secure.getString(context.getContentResolver(), "android_id"));
    }

    public static String getUserAgent() {
        return System.getProperty("http.agent");
    }

    public static boolean isNetworkAvailable(Context context) {
        boolean z = false;
        if (context == null || context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
            return z;
        }
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
            return true;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
        } catch (NullPointerException e) {
            return z;
        }
    }

    public static int memoryCacheSizeBytes(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        long memoryClass = (long) activityManager.getMemoryClass();
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.HONEYCOMB)) {
            try {
                if (Utils.bitMaskContainsFlag(context.getApplicationInfo().flags, ApplicationInfo.class.getDeclaredField("FLAG_LARGE_HEAP").getInt(null))) {
                    memoryClass = (long) ((Integer) new MethodBuilder(activityManager, "getLargeMemoryClass").execute()).intValue();
                }
            } catch (Exception e) {
                MoPubLog.m9729d("Unable to reflectively determine large heap size on Honeycomb and above.");
            }
        }
        return (int) Math.min(31457280, ((memoryClass / 8) * 1024) * 1024);
    }

    public static long diskCacheSizeBytes(File dir) {
        long size = 31457280;
        try {
            StatFs statFs = new StatFs(dir.getAbsolutePath());
            size = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 50;
        } catch (IllegalArgumentException e) {
            MoPubLog.m9729d("Unable to calculate 2% of available disk space, defaulting to minimum");
        }
        return Math.max(Math.min(size, 104857600), 31457280);
    }
}
