package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

class cy {

    /* renamed from: com.google.android.gms.tagmanager.cy.1 */
    static class C22991 implements Runnable {
        final /* synthetic */ Editor aao;

        C22991(Editor editor) {
            this.aao = editor;
        }

        public void run() {
            this.aao.commit();
        }
    }

    static void m9503a(Context context, String str, String str2, String str3) {
        Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        m9504a(edit);
    }

    static void m9504a(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            new Thread(new C22991(editor)).start();
        }
    }
}
