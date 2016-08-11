package com.avg.ui.general;

import android.content.Context;
import android.content.SharedPreferences;
import com.avg.utils.C1192b;

/* renamed from: com.avg.ui.general.d */
public class C1162d {
    private SharedPreferences f3522a;
    private boolean f3523b;

    public C1162d(Context context) {
        this.f3523b = true;
        this.f3522a = context.getApplicationContext().getSharedPreferences("UI_shared_prefs", 0);
        if (!C1192b.m4997a(context) && context.getResources().getDisplayMetrics().density < 1.5f) {
            this.f3523b = false;
        }
    }

    public void m4867a(String mainFragmentName) {
        this.f3522a.edit().putString("main_fragment", mainFragmentName).apply();
    }

    public String m4866a() {
        return this.f3522a.getString("main_fragment", "");
    }
}
