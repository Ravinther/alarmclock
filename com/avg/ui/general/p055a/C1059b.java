package com.avg.ui.general.p055a;

import android.support.v4.app.C0066l;
import android.support.v4.app.C0075i;
import android.support.v4.app.Fragment;
import android.support.v7.p012a.C0328a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;
import com.avg.toolkit.p049e.C0970a;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;

/* renamed from: com.avg.ui.general.a.b */
public abstract class C1059b extends C1055d implements OnClickListener {
    public void m4616a(int titleResourceId, boolean showUpgradeButton) {
        m4617a(getString(titleResourceId), showUpgradeButton);
    }

    public void m4617a(String title, boolean showUpgradeButton) {
        int i = 0;
        C0328a actionBar = m1486h();
        actionBar.m1467f(false);
        actionBar.m1461c(false);
        actionBar.m1463d(false);
        actionBar.m1453a(false);
        actionBar.m1458b(false);
        actionBar.m1455b(17170445);
        actionBar.m1450a(C1084h.custom_action_bar_title);
        actionBar.m1465e(true);
        View actionBarRootView = actionBar.m1449a();
        TextView actionBarUpButton = (TextView) actionBarRootView.findViewById(C1082f.actionBarUpButton);
        actionBarUpButton.setOnClickListener(this);
        actionBarUpButton.setText(title);
        View findViewById = actionBarRootView.findViewById(C1082f.upgradeButton);
        if (!showUpgradeButton) {
            i = 8;
        }
        findViewById.setVisibility(i);
        actionBar.m1462d();
    }

    public Fragment m4615a(Fragment fragment, int holder, String tag) {
        C0075i supportFragmentManager = m258g();
        Fragment currentFragment = supportFragmentManager.m261a(tag);
        if (currentFragment != null) {
            return currentFragment;
        }
        try {
            C0066l ft = supportFragmentManager.m262a();
            ft.m189b(holder, fragment, tag);
            findViewById(holder).setVisibility(0);
            ft.m182a(4099);
            ft.m188b();
        } catch (Exception e) {
            C0970a.m4325b("Failed to launch " + tag + " Error: " + e.getMessage());
        }
        GoogleAnalyticsWrapper.trackPageView(this, tag);
        return fragment;
    }

    public void onClick(View v) {
        m4614k();
    }

    private void m4614k() {
        finish();
    }
}
