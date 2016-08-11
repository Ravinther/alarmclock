package com.anglelabs.alarmclock.redesign.p039d;

import com.google.android.gms.plus.PlusShare;
import java.text.Collator;
import java.util.Comparator;

/* renamed from: com.anglelabs.alarmclock.redesign.d.a */
public class C0692a {
    public static final Comparator f1800a;

    /* renamed from: com.anglelabs.alarmclock.redesign.d.a.1 */
    static class C06771 implements Comparator {
        private final Collator f1765a;

        C06771() {
            this.f1765a = Collator.getInstance();
        }

        public /* synthetic */ int compare(Object x0, Object x1) {
            return m3103a((C0679b) x0, (C0679b) x1);
        }

        public int m3103a(C0679b object1, C0679b object2) {
            return this.f1765a.compare(object1.m3104a().trim(), object2.m3104a().trim());
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.d.a.a */
    public interface C0678a {
        public static final String[] f1766a;

        static {
            f1766a = new String[]{"_id", "artist", "artist_key", "number_of_tracks"};
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.d.a.b */
    public interface C0679b {
        String m3104a();
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.d.a.c */
    public interface C0680c {
        public static final String[] f1767a;

        static {
            f1767a = new String[]{"_id", PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "duration", "title_key", "_data"};
        }
    }

    static {
        f1800a = new C06771();
    }
}
