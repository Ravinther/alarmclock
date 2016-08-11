package com.avg.toolkit.p051g;

import android.os.Bundle;
import com.avg.toolkit.C0647c;
import com.avg.toolkit.license.C1017a;
import java.util.List;

/* renamed from: com.avg.toolkit.g.e */
public class C0977e implements C0647c {
    static String f2939a;
    static String f2940b;
    private static C0976a f2941c;
    private static boolean f2942d;

    /* renamed from: com.avg.toolkit.g.e.a */
    public enum C0976a {
        Protection(1),
        Performance(2),
        Complete(3);
        
        private int f2938d;

        private C0976a(int value) {
            this.f2938d = value;
        }

        public int m4342a() {
            return this.f2938d;
        }
    }

    static {
        f2942d = false;
    }

    public static boolean m4343a() {
        return f2942d;
    }

    public static C0976a m4344b() {
        return f2941c;
    }

    public int getID() {
        return 35000;
    }

    public void onStart(boolean firstTime) {
    }

    public void onMessage(Bundle arguments) {
    }

    public void onAlarm(Bundle arguments) {
    }

    public void onDailyTask(C1017a avgFeatures) {
    }

    public void onNewLicense(C1017a avgFeatures) {
    }

    public void onDestroy() {
    }

    public void setComm(List commClients) {
        commClients.add(C0974c.class);
        commClients.add(C0980h.class);
        commClients.add(C0973b.class);
    }
}
