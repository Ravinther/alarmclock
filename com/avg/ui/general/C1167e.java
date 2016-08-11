package com.avg.ui.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.avg.ui.general.e */
public class C1167e {
    public static C1163a f3539a;
    private static List f3540b;
    private static List f3541c;
    private static List f3542d;

    /* renamed from: com.avg.ui.general.e.a */
    public enum C1163a {
        eTablet,
        eHandheld,
        eNook
    }

    /* renamed from: com.avg.ui.general.e.b */
    public enum C1164b {
        APP_LOCKER(0),
        BACKUP_APPS(APP_LOCKER.f3536h + 1),
        PRIVACY_FIX(BACKUP_APPS.f3536h + 1),
        CALL_MESSAGE_FILTER(PRIVACY_FIX.f3536h + 1),
        PRIVACY_WIPE_DEVICE(CALL_MESSAGE_FILTER.f3536h + 1),
        PRIVACY_WIPE_DATA(PRIVACY_WIPE_DEVICE.f3536h + 1),
        PRIVACY_WIPE_SD(PRIVACY_WIPE_DATA.f3536h + 1);
        
        private final int f3536h;

        private C1164b(int id) {
            this.f3536h = id;
        }
    }

    static {
        f3539a = C1163a.eHandheld;
        f3540b = new ArrayList(Arrays.asList(new C1164b[]{C1164b.APP_LOCKER, C1164b.BACKUP_APPS, C1164b.PRIVACY_FIX, C1164b.PRIVACY_WIPE_DEVICE, C1164b.PRIVACY_WIPE_DATA, C1164b.PRIVACY_WIPE_SD}));
        f3541c = new ArrayList(Arrays.asList(new C1164b[]{C1164b.APP_LOCKER, C1164b.BACKUP_APPS, C1164b.PRIVACY_FIX, C1164b.CALL_MESSAGE_FILTER, C1164b.PRIVACY_WIPE_DEVICE, C1164b.PRIVACY_WIPE_DATA, C1164b.PRIVACY_WIPE_SD}));
        f3542d = new ArrayList(Arrays.asList(new C1164b[]{C1164b.PRIVACY_WIPE_DEVICE, C1164b.PRIVACY_WIPE_DATA, C1164b.PRIVACY_WIPE_SD, C1164b.APP_LOCKER}));
    }

    public static boolean m4868a() {
        return f3539a == C1163a.eTablet || f3539a == C1163a.eNook;
    }
}
