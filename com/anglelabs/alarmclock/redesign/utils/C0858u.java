package com.anglelabs.alarmclock.redesign.utils;

import android.content.Context;
import android.support.v7.widget.C0483a;
import android.support.v7.widget.C0483a.C0481a;
import android.support.v7.widget.C0483a.C0482b;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.alarmclock.xtreme.free.R;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.u */
public class C0858u {

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.u.a */
    public static abstract class C0512a {
        protected Object f1376b;

        public abstract void m2441a(Context context, Menu menu);

        public void m2443a(Object t) {
            this.f1376b = t;
        }

        public void m2442a(View v) {
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.u.1 */
    static class C08571 implements C0481a {
        final /* synthetic */ C0512a f2457a;
        final /* synthetic */ View f2458b;

        C08571(C0512a c0512a, View view) {
            this.f2457a = c0512a;
            this.f2458b = view;
        }

        public void m4023a(C0483a menu) {
            if (this.f2457a != null) {
                this.f2457a.m2442a(this.f2458b);
            }
        }
    }

    public static void m4025a(Context context, View v, int menuRes, C0512a maker, C0482b listener) {
        C0483a popup = new C0483a(context, v);
        popup.m2308b().inflate(menuRes, popup.m2302a());
        if (maker != null) {
            maker.m2441a(context, popup.m2302a());
        }
        popup.m2306a(listener);
        popup.m2310c();
        popup.m2305a(new C08571(maker, v));
    }

    public static Toast m4024a(Context context, CharSequence string) {
        context = context.getApplicationContext();
        LinearLayout popupView = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.redesign_undo_popup, new LinearLayout(context));
        ((TextView) popupView.findViewById(R.id.text)).setText(string);
        ((Button) popupView.findViewById(R.id.undo)).setVisibility(8);
        Toast toast = Toast.makeText(context, string, 1);
        toast.setView(popupView);
        return toast;
    }

    public static void m4026a(Context context, String string) {
        Toast toast = C0858u.m4024a(context, (CharSequence) string);
        toast.setGravity(87, 0, (int) context.getResources().getDimension(R.dimen.undoOffset));
        toast.show();
    }
}
