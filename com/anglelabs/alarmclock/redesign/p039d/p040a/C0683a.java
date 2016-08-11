package com.anglelabs.alarmclock.redesign.p039d.p040a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import com.anglelabs.alarmclock.redesign.p021b.C0660a;
import com.anglelabs.alarmclock.redesign.p039d.C0692a;
import com.anglelabs.alarmclock.redesign.p039d.C0692a.C0679b;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.anglelabs.alarmclock.redesign.d.a.a */
public class C0683a extends C0660a {
    public final PackageManager f1777n;
    C0682b f1778o;

    /* renamed from: com.anglelabs.alarmclock.redesign.d.a.a.a */
    public static class C0681a implements C0679b {
        private final Context f1768a;
        private final PackageManager f1769b;
        private final ApplicationInfo f1770c;
        private final File f1771d;
        private String f1772e;
        private Drawable f1773f;
        private boolean f1774g;

        public C0681a(Context context, ApplicationInfo info) {
            this.f1768a = context.getApplicationContext();
            this.f1769b = this.f1768a.getPackageManager();
            this.f1770c = info;
            this.f1771d = new File(info.sourceDir);
        }

        public String m3107b() {
            return this.f1772e;
        }

        public String m3108c() {
            return this.f1770c.packageName;
        }

        public Drawable m3109d() {
            if (this.f1773f == null) {
                if (this.f1771d.exists()) {
                    this.f1773f = this.f1770c.loadIcon(this.f1769b);
                    return this.f1773f;
                }
                this.f1774g = false;
            } else if (this.f1774g) {
                return this.f1773f;
            } else {
                if (this.f1771d.exists()) {
                    this.f1774g = true;
                    this.f1773f = this.f1770c.loadIcon(this.f1769b);
                    return this.f1773f;
                }
            }
            return this.f1768a.getResources().getDrawable(17301651);
        }

        public String toString() {
            return this.f1772e;
        }

        public void m3106a(Context context) {
            if (this.f1772e != null && this.f1774g) {
                return;
            }
            if (this.f1771d.exists()) {
                this.f1774g = true;
                CharSequence label = this.f1770c.loadLabel(context.getPackageManager());
                this.f1772e = label != null ? label.toString() : this.f1770c.packageName;
                return;
            }
            this.f1774g = false;
            this.f1772e = this.f1770c.packageName;
        }

        public String m3105a() {
            return this.f1772e;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.d.a.a.b */
    public class C0682b extends BroadcastReceiver {
        final C0660a f1775a;
        final /* synthetic */ C0683a f1776b;

        public C0682b(C0683a c0683a, C0660a loader) {
            this.f1776b = c0683a;
            this.f1775a = loader;
            IntentFilter filter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            filter.addAction("android.intent.action.PACKAGE_REMOVED");
            filter.addAction("android.intent.action.PACKAGE_CHANGED");
            filter.addDataScheme("package");
            this.f1775a.m70f().registerReceiver(this, filter);
            IntentFilter sdFilter = new IntentFilter();
            sdFilter.addAction("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE");
            sdFilter.addAction("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
            this.f1775a.m70f().registerReceiver(this, sdFilter);
        }

        public void onReceive(Context context, Intent intent) {
            this.f1775a.m86v();
        }
    }

    public /* synthetic */ Object m3110d() {
        return m3113y();
    }

    public C0683a(Context context) {
        super(context);
        this.f1777n = m70f().getPackageManager();
    }

    public ArrayList m3113y() {
        Intent mainIntent = new Intent("android.intent.action.MAIN", null);
        mainIntent.addCategory("android.intent.category.LAUNCHER");
        List apps = this.f1777n.queryIntentActivities(mainIntent, 0);
        if (apps == null) {
            apps = new ArrayList();
        }
        Context context = m70f();
        ArrayList entries = new ArrayList(apps.size());
        for (int i = 0; i < apps.size(); i++) {
            try {
                C0681a entry = new C0681a(m70f(), ((ResolveInfo) apps.get(i)).activityInfo.applicationInfo);
                entry.m3106a(context);
                entries.add(entry);
            } catch (Exception e) {
                C0850q.m3984a(e);
            }
        }
        Collections.sort(entries, C0692a.f1800a);
        return entries;
    }

    public void m3111w() {
        if (this.f1778o == null) {
            this.f1778o = new C0682b(this, this);
        }
    }

    public void m3112x() {
        if (this.f1778o != null) {
            m70f().unregisterReceiver(this.f1778o);
            this.f1778o = null;
        }
    }
}
