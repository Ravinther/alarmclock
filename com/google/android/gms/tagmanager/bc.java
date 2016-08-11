package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.Locale;
import java.util.Map;

class bc extends aj {
    private static final String ID;

    static {
        ID = C1732a.LANGUAGE.toString();
    }

    public bc() {
        super(ID, new String[0]);
    }

    public boolean jX() {
        return false;
    }

    public C1816a m9365x(Map map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return dh.lT();
        }
        String language = locale.getLanguage();
        return language == null ? dh.lT() : dh.m9531r(language.toLowerCase());
    }
}
