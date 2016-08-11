package com.avg.toolkit.gcm;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import com.avg.toolkit.C0647c;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.p049e.C0970a;
import com.google.android.p052a.C1335c;
import java.util.List;

/* renamed from: com.avg.toolkit.gcm.a */
public class C0985a implements C0647c {
    private SparseArray f2963a;
    private Context f2964b;

    public C0985a(Context context) {
        this.f2963a = new SparseArray();
        this.f2964b = context.getApplicationContext();
    }

    public int getID() {
        return 24000;
    }

    public void onStart(boolean firstTime) {
        m4379a();
    }

    public void onMessage(Bundle arguments) {
        int action = -1;
        if (arguments != null) {
            try {
                action = arguments.getInt(ITKSvc.c_actionSubAction, -1);
            } catch (Exception e) {
                C0970a.m4322a(e);
            }
        }
        switch (action) {
            case 24001:
                m4382a(arguments.getString("registration_id"));
            case 24002:
                m4381a(arguments);
            default:
                C0970a.m4321a();
        }
    }

    public void onAlarm(Bundle arguments) {
    }

    public void onDailyTask(C1017a avgFeatures) {
        m4379a();
    }

    public void onNewLicense(C1017a avgFeatures) {
    }

    public void onDestroy() {
    }

    public void setComm(List commClients) {
    }

    private void m4379a() {
        try {
            C1335c.m5853a(this.f2964b);
            C1335c.m5858b(this.f2964b);
            if (!C1335c.m5863f(this.f2964b)) {
                C1335c.m5856a(this.f2964b, "804293759086");
            }
        } catch (Exception e) {
        }
    }

    protected void m4381a(Bundle arguments) {
        Bundle bundle = arguments.getBundle("extra");
        try {
            int id = Integer.parseInt(bundle.getString("feature_id"));
            bundle.putInt(ITKSvc.c_actionSubAction, 24002);
            ((C0647c) this.f2963a.get(id)).onMessage(bundle);
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    public void m4380a(int key, C0647c feature) {
        if (feature != null && key > 0 && this.f2963a != null && this.f2963a.get(key) == null) {
            this.f2963a.append(key, feature);
        }
    }

    protected void m4382a(String regId) {
        for (int i = 0; i < this.f2963a.size(); i++) {
            Bundle bundle = new Bundle();
            bundle.putString("registration_id", regId);
            bundle.putInt(ITKSvc.c_actionSubAction, 24001);
            ((C0647c) this.f2963a.valueAt(i)).onMessage(bundle);
        }
    }
}
