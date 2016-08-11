package com.anglelabs.alarmclock.redesign.alarm.p028a.p031c;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0616b;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0617d;
import com.anglelabs.alarmclock.redesign.utils.ac;
import java.util.Random;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.c.a */
public class C0621a implements C0616b {
    private EditText f1673a;
    private TextView f1674b;
    private final C0617d f1675c;
    private final boolean f1676d;
    private String f1677e;
    private String f1678f;
    private TextView f1679g;

    /* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.c.a.1 */
    class C06191 implements OnClickListener {
        final /* synthetic */ C0621a f1671a;

        C06191(C0621a c0621a) {
            this.f1671a = c0621a;
        }

        public void onClick(View v) {
            this.f1671a.m2853f();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.c.a.2 */
    class C06202 implements OnEditorActionListener {
        final /* synthetic */ C0621a f1672a;

        C06202(C0621a c0621a) {
            this.f1672a = c0621a;
        }

        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            boolean isHardKeyEnterPressed = event != null && event.getAction() == 0 && event.getKeyCode() == 66;
            if (actionId == 6 || actionId == 5 || isHardKeyEnterPressed) {
                this.f1672a.m2853f();
            }
            return true;
        }
    }

    public C0621a(C0617d callback, boolean isStartedForDismiss) {
        this.f1675c = callback;
        this.f1676d = isStartedForDismiss;
    }

    public View m2854a(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_question_captcha_layout, container, false);
        this.f1674b = (TextView) view.findViewById(R.id.problem_text);
        this.f1673a = (EditText) view.findViewById(R.id.math_edit_text);
        this.f1679g = (TextView) view.findViewById(R.id.error_text);
        m2851d();
        m2852e();
        view.findViewById(R.id.submit).setOnClickListener(new C06191(this));
        return view;
    }

    public void m2859c() {
        ac.m3768a(this.f1675c.m2847b(), this.f1673a);
    }

    public void m2856a(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("extra_question", this.f1677e);
            bundle.putString("extra_input", this.f1673a.getText().toString());
        }
    }

    public void m2858b(Bundle bundle) {
        if (bundle != null) {
            this.f1677e = bundle.getString("extra_question");
            this.f1678f = bundle.getString("extra_input");
        }
    }

    private void m2851d() {
        if (TextUtils.isEmpty(this.f1677e)) {
            this.f1677e = m2849a(8);
            this.f1674b.setText(this.f1677e);
            return;
        }
        this.f1674b.setText(this.f1677e);
        if (TextUtils.isEmpty(this.f1678f)) {
            this.f1673a.setText(this.f1678f);
        }
    }

    private String m2849a(int length) {
        String AB = "123456789ABCDEFGHJKMNPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length - 1; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        AB = "123456789";
        sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    private void m2852e() {
        this.f1673a.setInputType(528385);
        this.f1673a.setOnEditorActionListener(new C06202(this));
        this.f1673a.addTextChangedListener(this.f1675c.m2843a(this.f1673a, this.f1679g));
    }

    private void m2853f() {
        if (this.f1677e.equalsIgnoreCase(this.f1673a.getText().toString().trim())) {
            ac.m3775b(this.f1675c.m2847b(), this.f1673a);
            this.f1675c.m2846a(this.f1676d);
            return;
        }
        this.f1675c.m2845a(this.f1679g, this.f1673a);
    }

    public void m2857b() {
    }

    public String m2855a() {
        return "Captcha";
    }

    public String toString() {
        return "captcha";
    }
}
