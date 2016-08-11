package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.view.C0220d;
import android.support.v7.internal.widget.C0440b;
import android.support.v7.internal.widget.C0440b.C0438e;
import android.support.v7.internal.widget.C0446c;
import android.support.v7.p014b.C0364a.C0355b;
import android.support.v7.p014b.C0364a.C0361h;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.widget.b */
public class C0488b extends C0220d {
    private int f1284a;
    private final C0487c f1285b;
    private final Context f1286c;
    private String f1287d;
    private C0485a f1288e;
    private C0438e f1289f;

    /* renamed from: android.support.v7.widget.b.a */
    public interface C0485a {
        boolean m2311a(C0488b c0488b, Intent intent);
    }

    /* renamed from: android.support.v7.widget.b.b */
    private class C0486b implements C0438e {
        final /* synthetic */ C0488b f1282a;

        private C0486b(C0488b c0488b) {
            this.f1282a = c0488b;
        }

        public boolean m2312a(C0440b host, Intent intent) {
            if (this.f1282a.f1288e != null) {
                this.f1282a.f1288e.m2311a(this.f1282a, intent);
            }
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.b.c */
    private class C0487c implements OnMenuItemClickListener {
        final /* synthetic */ C0488b f1283a;

        private C0487c(C0488b c0488b) {
            this.f1283a = c0488b;
        }

        public boolean onMenuItemClick(MenuItem item) {
            Intent launchIntent = C0440b.m2126a(this.f1283a.f1286c, this.f1283a.f1287d).m2145b(item.getItemId());
            if (launchIntent != null) {
                launchIntent.addFlags(524288);
                this.f1283a.f1286c.startActivity(launchIntent);
            }
            return true;
        }
    }

    public C0488b(Context context) {
        super(context);
        this.f1284a = 4;
        this.f1285b = new C0487c();
        this.f1287d = "share_history.xml";
        this.f1286c = context;
    }

    public View m2320b() {
        C0440b dataModel = C0440b.m2126a(this.f1286c, this.f1287d);
        C0446c activityChooserView = new C0446c(this.f1286c);
        activityChooserView.setActivityChooserModel(dataModel);
        TypedValue outTypedValue = new TypedValue();
        this.f1286c.getTheme().resolveAttribute(C0355b.actionModeShareDrawable, outTypedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(this.f1286c.getResources().getDrawable(outTypedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(C0361h.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(C0361h.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    public boolean m2321g() {
        return true;
    }

    public void m2318a(SubMenu subMenu) {
        int i;
        subMenu.clear();
        C0440b dataModel = C0440b.m2126a(this.f1286c, this.f1287d);
        PackageManager packageManager = this.f1286c.getPackageManager();
        int expandedActivityCount = dataModel.m2140a();
        int collapsedActivityCount = Math.min(expandedActivityCount, this.f1284a);
        for (i = 0; i < collapsedActivityCount; i++) {
            ResolveInfo activity = dataModel.m2142a(i);
            subMenu.add(0, i, i, activity.loadLabel(packageManager)).setIcon(activity.loadIcon(packageManager)).setOnMenuItemClickListener(this.f1285b);
        }
        if (collapsedActivityCount < expandedActivityCount) {
            SubMenu expandedSubMenu = subMenu.addSubMenu(0, collapsedActivityCount, collapsedActivityCount, this.f1286c.getString(C0361h.abc_activity_chooser_view_see_all));
            for (i = 0; i < expandedActivityCount; i++) {
                activity = dataModel.m2142a(i);
                expandedSubMenu.add(0, i, i, activity.loadLabel(packageManager)).setIcon(activity.loadIcon(packageManager)).setOnMenuItemClickListener(this.f1285b);
            }
        }
    }

    public void m2319a(String shareHistoryFile) {
        this.f1287d = shareHistoryFile;
        m2316h();
    }

    public void m2317a(Intent shareIntent) {
        C0440b.m2126a(this.f1286c, this.f1287d).m2143a(shareIntent);
    }

    private void m2316h() {
        if (this.f1288e != null) {
            if (this.f1289f == null) {
                this.f1289f = new C0486b();
            }
            C0440b.m2126a(this.f1286c, this.f1287d).m2144a(this.f1289f);
        }
    }
}
