package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.avg.toolkit.ads.AdsManager;
import java.util.Map;

public final class be implements bb {
    private static int m7898a(DisplayMetrics displayMetrics, Map map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                i = dv.m8207a(displayMetrics, Integer.parseInt(str2));
            } catch (NumberFormatException e) {
                dw.m8221z("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        return i;
    }

    public void m7899b(dz dzVar, Map map) {
        String str = (String) map.get("action");
        if (str == null) {
            dw.m8221z("Action missing from video GMSG.");
            return;
        }
        cc bH = dzVar.bH();
        if (bH == null) {
            dw.m8221z("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean equalsIgnoreCase = "new".equalsIgnoreCase(str);
        boolean equalsIgnoreCase2 = "position".equalsIgnoreCase(str);
        int a;
        if (equalsIgnoreCase || equalsIgnoreCase2) {
            DisplayMetrics displayMetrics = dzVar.getContext().getResources().getDisplayMetrics();
            a = m7898a(displayMetrics, map, "x", 0);
            int a2 = m7898a(displayMetrics, map, "y", 0);
            int a3 = m7898a(displayMetrics, map, "w", -1);
            int a4 = m7898a(displayMetrics, map, "h", -1);
            if (equalsIgnoreCase && bH.aK() == null) {
                bH.m8028c(a, a2, a3, a4);
                return;
            } else {
                bH.m8027b(a, a2, a3, a4);
                return;
            }
        }
        cg aK = bH.aK();
        if (aK == null) {
            cg.m8040a(dzVar, "no_video_view", null);
        } else if (AdsManager.ANALYTICS_ACTION_CLICK.equalsIgnoreCase(str)) {
            displayMetrics = dzVar.getContext().getResources().getDisplayMetrics();
            int a5 = m7898a(displayMetrics, map, "x", 0);
            a = m7898a(displayMetrics, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a5, (float) a, 0);
            aK.m8043b(obtain);
            obtain.recycle();
        } else if ("controls".equalsIgnoreCase(str)) {
            str = (String) map.get("enabled");
            if (str == null) {
                dw.m8221z("Enabled parameter missing from controls video GMSG.");
            } else {
                aK.m8044k(Boolean.parseBoolean(str));
            }
        } else if ("currentTime".equalsIgnoreCase(str)) {
            str = (String) map.get(AdsManager.PREFS_KEY_TIME);
            if (str == null) {
                dw.m8221z("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                aK.seekTo((int) (Float.parseFloat(str) * 1000.0f));
            } catch (NumberFormatException e) {
                dw.m8221z("Could not parse time parameter from currentTime video GMSG: " + str);
            }
        } else if ("hide".equalsIgnoreCase(str)) {
            aK.setVisibility(4);
        } else if ("load".equalsIgnoreCase(str)) {
            aK.aU();
        } else if ("pause".equalsIgnoreCase(str)) {
            aK.pause();
        } else if ("play".equalsIgnoreCase(str)) {
            aK.play();
        } else if ("show".equalsIgnoreCase(str)) {
            aK.setVisibility(0);
        } else if ("src".equalsIgnoreCase(str)) {
            aK.m8045o((String) map.get("src"));
        } else {
            dw.m8221z("Unknown video action: " + str);
        }
    }
}
