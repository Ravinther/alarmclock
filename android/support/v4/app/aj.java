package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p006a.C0008b;
import android.util.Log;
import com.google.android.gms.drive.DriveFile;
import java.util.ArrayList;
import java.util.Iterator;

public class aj implements Iterable {
    private static final C0054b f126a;
    private final ArrayList f127b;
    private final Context f128c;

    /* renamed from: android.support.v4.app.aj.a */
    public interface C0053a {
        Intent m169a();
    }

    /* renamed from: android.support.v4.app.aj.b */
    interface C0054b {
    }

    /* renamed from: android.support.v4.app.aj.c */
    static class C0055c implements C0054b {
        C0055c() {
        }
    }

    /* renamed from: android.support.v4.app.aj.d */
    static class C0056d implements C0054b {
        C0056d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f126a = new C0056d();
        } else {
            f126a = new C0055c();
        }
    }

    private aj(Context a) {
        this.f127b = new ArrayList();
        this.f128c = a;
    }

    public static aj m170a(Context context) {
        return new aj(context);
    }

    public aj m173a(Intent nextIntent) {
        this.f127b.add(nextIntent);
        return this;
    }

    public aj m171a(Activity sourceActivity) {
        Intent parent = null;
        if (sourceActivity instanceof C0053a) {
            parent = ((C0053a) sourceActivity).m169a();
        }
        if (parent == null) {
            parent = C0098p.m435a(sourceActivity);
        }
        if (parent != null) {
            ComponentName target = parent.getComponent();
            if (target == null) {
                target = parent.resolveActivity(this.f128c.getPackageManager());
            }
            m172a(target);
            m173a(parent);
        }
        return this;
    }

    public aj m172a(ComponentName sourceActivityName) {
        int insertAt = this.f127b.size();
        try {
            Intent parent = C0098p.m436a(this.f128c, sourceActivityName);
            while (parent != null) {
                this.f127b.add(insertAt, parent);
                parent = C0098p.m436a(this.f128c, parent.getComponent());
            }
            return this;
        } catch (NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public Iterator iterator() {
        return this.f127b.iterator();
    }

    public void m174a() {
        m175a(null);
    }

    public void m175a(Bundle options) {
        if (this.f127b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intents = (Intent[]) this.f127b.toArray(new Intent[this.f127b.size()]);
        intents[0] = new Intent(intents[0]).addFlags(268484608);
        if (!C0008b.m98a(this.f128c, intents, options)) {
            Intent topIntent = new Intent(intents[intents.length - 1]);
            topIntent.addFlags(DriveFile.MODE_READ_ONLY);
            this.f128c.startActivity(topIntent);
        }
    }
}
