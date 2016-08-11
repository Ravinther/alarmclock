package android.support.v7.p012a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.C0041a;
import android.support.v4.app.C0073g;
import android.support.v4.app.C0098p;
import android.support.v4.app.aj;
import android.support.v4.app.aj.C0053a;
import android.support.v7.p012a.C0328a.C0322a;
import android.support.v7.p013c.C0342a;
import android.support.v7.p013c.C0342a.C0332a;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* renamed from: android.support.v7.a.b */
public class C0329b extends C0073g implements C0053a, C0322a {
    C0330c f612n;

    public C0328a m1486h() {
        return this.f612n.m1502b();
    }

    public MenuInflater getMenuInflater() {
        return this.f612n.m1505c();
    }

    public void setContentView(int layoutResID) {
        this.f612n.m1492a(layoutResID);
    }

    public void setContentView(View view) {
        this.f612n.m1495a(view);
    }

    public void setContentView(View view, LayoutParams params) {
        this.f612n.m1496a(view, params);
    }

    public void addContentView(View view, LayoutParams params) {
        this.f612n.m1504b(view, params);
    }

    protected void onCreate(Bundle savedInstanceState) {
        this.f612n = C0330c.m1489a(this);
        super.onCreate(savedInstanceState);
        this.f612n.m1494a(savedInstanceState);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.f612n.m1493a(newConfig);
    }

    protected void onStop() {
        super.onStop();
        this.f612n.m1506d();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f612n.m1507e();
    }

    public View onCreatePanelView(int featureId) {
        if (featureId == 0) {
            return this.f612n.m1503b(featureId);
        }
        return super.onCreatePanelView(featureId);
    }

    public final boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (this.f612n.m1499a(featureId, item)) {
            return true;
        }
        C0328a ab = m1486h();
        if (item.getItemId() != 16908332 || ab == null || (ab.m1454b() & 4) == 0) {
            return false;
        }
        return m1487i();
    }

    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        this.f612n.m1497a(title);
    }

    public void m1485e() {
        if (VERSION.SDK_INT >= 14) {
            super.m256e();
        }
        this.f612n.m1508f();
    }

    public void m1472a(C0342a mode) {
    }

    public void m1482b(C0342a mode) {
    }

    public C0342a m1469a(C0332a callback) {
        return this.f612n.m1491a(callback);
    }

    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        return this.f612n.m1498a(featureId, menu);
    }

    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        return this.f612n.m1500a(featureId, view, menu);
    }

    protected boolean m1479a(View view, Menu menu) {
        return this.f612n.m1501a(view, menu);
    }

    void m1470a(int resId) {
        super.setContentView(resId);
    }

    void m1473a(View v) {
        super.setContentView(v);
    }

    void m1474a(View v, LayoutParams lp) {
        super.setContentView(v, lp);
    }

    void m1483b(View v, LayoutParams lp) {
        super.addContentView(v, lp);
    }

    boolean m1475a(int featureId, Menu frameworkMenu) {
        return super.onCreatePanelMenu(featureId, frameworkMenu);
    }

    boolean m1477a(int featureId, View view, Menu menu) {
        return super.onPreparePanel(featureId, view, menu);
    }

    boolean m1484b(View view, Menu menu) {
        return super.m252a(view, menu);
    }

    boolean m1476a(int featureId, MenuItem menuItem) {
        return super.onMenuItemSelected(featureId, menuItem);
    }

    public void onBackPressed() {
        if (!this.f612n.m1509g()) {
            super.onBackPressed();
        }
    }

    public void m1471a(aj builder) {
        builder.m171a((Activity) this);
    }

    public void m1481b(aj builder) {
    }

    public boolean m1487i() {
        Intent upIntent = m1468a();
        if (upIntent == null) {
            return false;
        }
        if (m1478a(upIntent)) {
            aj b = aj.m170a((Context) this);
            m1471a(b);
            m1481b(b);
            b.m174a();
            try {
                C0041a.m136a(this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            m1480b(upIntent);
        }
        return true;
    }

    public Intent m1468a() {
        return C0098p.m435a(this);
    }

    public boolean m1478a(Intent targetIntent) {
        return C0098p.m437a((Activity) this, targetIntent);
    }

    public void m1480b(Intent upIntent) {
        C0098p.m440b((Activity) this, upIntent);
    }

    public final void onContentChanged() {
        this.f612n.m1510h();
    }

    public void m1488j() {
    }
}
