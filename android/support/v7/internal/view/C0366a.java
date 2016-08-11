package android.support.v7.internal.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.p014b.C0364a.C0355b;
import android.support.v7.p014b.C0364a.C0356c;
import android.support.v7.p014b.C0364a.C0357d;
import android.support.v7.p014b.C0364a.C0359f;
import android.support.v7.p014b.C0364a.C0363j;

/* renamed from: android.support.v7.internal.view.a */
public class C0366a {
    private Context f692a;

    public static C0366a m1706a(Context context) {
        return new C0366a(context);
    }

    private C0366a(Context context) {
        this.f692a = context;
    }

    public int m1707a() {
        return this.f692a.getResources().getInteger(C0359f.abc_max_action_buttons);
    }

    public boolean m1708b() {
        return VERSION.SDK_INT >= 11;
    }

    public int m1709c() {
        return this.f692a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean m1710d() {
        return this.f692a.getResources().getBoolean(C0356c.abc_action_bar_embed_tabs_pre_jb);
    }

    public int m1711e() {
        TypedArray a = this.f692a.obtainStyledAttributes(null, C0363j.ActionBar, C0355b.actionBarStyle, 0);
        int height = a.getLayoutDimension(1, 0);
        Resources r = this.f692a.getResources();
        if (!m1710d()) {
            height = Math.min(height, r.getDimensionPixelSize(C0357d.abc_action_bar_stacked_max_height));
        }
        a.recycle();
        return height;
    }

    public boolean m1712f() {
        return this.f692a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int m1713g() {
        return this.f692a.getResources().getDimensionPixelSize(C0357d.abc_action_bar_stacked_tab_max_width);
    }
}
