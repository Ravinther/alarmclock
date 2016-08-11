package com.anglelabs.alarmclock.redesign.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;

/* renamed from: com.anglelabs.alarmclock.redesign.views.c */
public class C0897c {
    private final int f2654a;
    private final int f2655b;
    private final Context f2656c;
    private PopupWindow f2657d;
    private View f2658e;
    private TextView f2659f;
    private Button f2660g;

    public C0897c(Context context, int yOffset, int xOffset) {
        this.f2655b = xOffset;
        this.f2654a = yOffset;
        this.f2656c = context;
        m4143a(R.layout.redesign_undo_popup, R.id.text, R.id.undo);
        this.f2659f.setText("");
        this.f2659f.setGravity(19);
        m4141c();
    }

    public void m4143a(int resourceId, int textId, int buttonId) {
        this.f2658e = ((LayoutInflater) this.f2656c.getSystemService("layout_inflater")).inflate(resourceId, new LinearLayout(this.f2656c));
        this.f2659f = (TextView) this.f2658e.findViewById(textId);
        if (buttonId != -1) {
            this.f2660g = (Button) this.f2658e.findViewById(buttonId);
        }
    }

    private void m4141c() {
        this.f2657d = new PopupWindow(this.f2658e, -1, -2);
        this.f2657d.setAnimationStyle(R.style.fade_animation);
    }

    public void m4145a(View view, String text) {
        if (this.f2657d != null) {
            this.f2659f.setText(text);
            this.f2657d.showAtLocation(view, 81, this.f2655b, this.f2654a);
        }
    }

    public void m4142a() {
        if (this.f2657d != null) {
            this.f2657d.dismiss();
        }
    }

    public boolean m4146b() {
        return this.f2657d != null && this.f2657d.isShowing();
    }

    public void m4144a(OnClickListener onClickListener) {
        if (this.f2660g != null) {
            this.f2660g.setOnClickListener(onClickListener);
        }
    }
}
