package com.mopub.common.util;

import java.io.InputStream;

public class Strings {
    public static String fromStream(InputStream inputStream) {
        int numberBytesRead = 0;
        StringBuffer out = new StringBuffer();
        byte[] bytes = new byte[4096];
        while (numberBytesRead != -1) {
            out.append(new String(bytes, 0, numberBytesRead));
            numberBytesRead = inputStream.read(bytes);
        }
        inputStream.close();
        return out.toString();
    }

    public static boolean isEmpty(String input) {
        if (input != null && input.length() == 0) {
            return true;
        }
        return false;
    }
}
