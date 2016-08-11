package com.anglelabs.alarmclock.redesign.utils;

import android.content.Context;
import android.support.v4.view.C0220d;
import android.support.v4.view.C0240j;
import android.support.v4.view.C0240j.C0239e;
import android.support.v7.p012a.C0328a;
import android.support.v7.p012a.C0329b;
import android.support.v7.widget.C0488b;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.C0479c;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.alarmclock.xtreme.free.R;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.a */
public class C0790a {
    private C0328a f2099a;
    private final C0329b f2100b;

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.a.1 */
    static class C07891 implements C0239e {
        final /* synthetic */ SearchView f2098a;

        C07891(SearchView searchView) {
            this.f2098a = searchView;
        }

        public boolean m3743a(MenuItem arg0) {
            return true;
        }

        public boolean m3744b(MenuItem arg0) {
            if (!TextUtils.isEmpty(this.f2098a.getQuery())) {
                this.f2098a.m2296a(null, true);
            }
            return true;
        }
    }

    public C0790a(C0329b actionBarActivity) {
        this.f2100b = actionBarActivity;
        this.f2099a = actionBarActivity.m1486h();
    }

    private C0328a m3749c() {
        if (this.f2099a == null && this.f2100b != null) {
            this.f2099a = this.f2100b.m1486h();
        }
        return this.f2099a;
    }

    public boolean m3752a() {
        return !this.f2099a.m1449a().isShown();
    }

    public void m3750a(CharSequence title) {
        m3751a(title, null);
    }

    public void m3751a(CharSequence title, CharSequence subtitle) {
        if (m3749c() != null) {
            this.f2099a.m1461c(true);
            this.f2099a.m1458b(false);
            this.f2099a.m1452a(title);
            if (TextUtils.isEmpty(subtitle)) {
                this.f2099a.m1457b(null);
            } else {
                this.f2099a.m1457b(subtitle);
            }
        }
    }

    public void m3754b(CharSequence title) {
        m3755b(title, null);
    }

    public void m3755b(CharSequence title, CharSequence subtitle) {
        if (m3749c() != null) {
            this.f2099a.m1465e(false);
            this.f2099a.m1453a(false);
            this.f2099a.m1463d(true);
            m3751a(title, subtitle);
        }
    }

    public void m3753b() {
        if (m3749c() != null) {
            this.f2099a.m1465e(true);
            this.f2099a.m1458b(false);
            this.f2099a.m1461c(false);
            this.f2099a.m1452a((CharSequence) "");
            this.f2099a.m1457b(null);
        }
    }

    public static MenuItem m3748a(Menu menu) {
        MenuItem shareItem = menu.add(0, 2, 0, R.string.ab_stopwatch_share);
        shareItem.setIcon(17301586);
        C0240j.m1056a(shareItem, 0);
        return shareItem;
    }

    public static C0488b m3746a(Context context, MenuItem shareItem) {
        C0220d provider = new C0488b(context);
        C0240j.m1052a(shareItem, provider);
        provider.m2319a("share_history.xml");
        return provider;
    }

    public static SearchView m3745a(Context context, Menu menu, C0479c textListener) {
        MenuItem searchItem = menu.add(R.string.ab_search);
        searchItem.setIcon(17301583);
        View searchView = new SearchView(context);
        searchView.setOnQueryTextListener(textListener);
        C0240j.m1053a(searchItem, new C07891(searchView));
        C0240j.m1056a(searchItem, 10);
        C0240j.m1054a(searchItem, searchView);
        return searchView;
    }

    public static MenuItem m3747a(Context context, Menu menu, int ignoredItemsCount) {
        MenuItem managedIgnoreList = menu.add(0, 1, 0, String.format(context.getString(R.string.music_type_ignored_action_button), new Object[]{Integer.valueOf(ignoredItemsCount)}));
        C0240j.m1056a(managedIgnoreList, 2);
        return managedIgnoreList;
    }
}
