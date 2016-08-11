package com.avg.ui.general.customviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.avg.ui.general.C1091c.C1081e;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;

/* renamed from: com.avg.ui.general.customviews.d */
public class C1157d extends PopupWindow {
    private TextView f3509a;

    /* renamed from: com.avg.ui.general.customviews.d.1 */
    class C11561 implements Runnable {
        final /* synthetic */ C1157d f3508a;

        C11561(C1157d c1157d) {
            this.f3508a = c1157d;
        }

        public void run() {
            try {
                this.f3508a.dismiss();
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public C1157d(Context context) {
        super(context);
        setWindowLayoutMode(-2, -2);
        View content = LayoutInflater.from(context).inflate(C1084h.popup_hint_layout, null);
        this.f3509a = (TextView) content.findViewById(C1082f.textViewMessage);
        setBackgroundDrawable(context.getResources().getDrawable(C1081e.toast));
        setContentView(content);
    }

    public void m4855a(CharSequence message) {
        this.f3509a.setText(message);
    }

    public void m4853a(int id) {
        this.f3509a.setText(id);
    }

    public void m4854a(View v, long millis) {
        showAsDropDown(v);
        v.postDelayed(new C11561(this), millis);
    }
}
