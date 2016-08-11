package com.mopub.common.util;

import java.security.MessageDigest;
import java.util.concurrent.atomic.AtomicLong;

public class Utils {
    private static final AtomicLong sNextGeneratedId;

    static {
        sNextGeneratedId = new AtomicLong(1);
    }

    public static String sha1(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] bytes = string.getBytes("UTF-8");
            digest.update(bytes, 0, bytes.length);
            int len$ = digest.digest().length;
            for (int i$ = 0; i$ < len$; i$++) {
                stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(arr$[i$])}));
            }
            return stringBuilder.toString().toLowerCase();
        } catch (Exception e) {
            return "";
        }
    }

    public static long generateUniqueId() {
        long result;
        long newValue;
        do {
            result = sNextGeneratedId.get();
            newValue = result + 1;
            if (newValue > 9223372036854775806L) {
                newValue = 1;
            }
        } while (!sNextGeneratedId.compareAndSet(result, newValue));
        return result;
    }

    public static boolean bitMaskContainsFlag(int bitMask, int flag) {
        return (bitMask & flag) != 0;
    }
}
