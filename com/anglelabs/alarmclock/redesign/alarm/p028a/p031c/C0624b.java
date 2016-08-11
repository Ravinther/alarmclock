package com.anglelabs.alarmclock.redesign.alarm.p028a.p031c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0616b;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0617d;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.utils.C0807e;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0858u;
import com.anglelabs.alarmclock.redesign.utils.MathProblem;
import com.anglelabs.alarmclock.redesign.utils.ab;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.anglelabs.alarmclock.redesign.views.MathKeyboard;
import com.anglelabs.alarmclock.redesign.views.MathKeyboard.C0623a;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.c.b */
public class C0624b implements C0616b, C0623a {
    private final boolean f1681a;
    private MathKeyboard f1682b;
    private TextView f1683c;
    private EditText f1684d;
    private final C0617d f1685e;
    private final int f1686f;
    private final int f1687g;
    private final boolean f1688h;
    private MathProblem f1689i;
    private int f1690j;
    private TextView f1691k;
    private TextView f1692l;
    private TextWatcher f1693m;

    /* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.c.b.1 */
    class C06221 implements OnTouchListener {
        final /* synthetic */ C0624b f1680a;

        C06221(C0624b c0624b) {
            this.f1680a = c0624b;
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    public C0624b(RedesignAlarm alarm, C0617d callback, int numberToSolve, boolean isStartedForDismiss) {
        this.f1690j = 0;
        this.f1687g = numberToSolve;
        this.f1688h = isStartedForDismiss;
        this.f1685e = callback;
        this.f1681a = alarm.f1999L;
        this.f1686f = alarm.f2021v;
        if (callback.m2847b() instanceof Activity) {
            ((Activity) callback.m2847b()).getWindow().setSoftInputMode(2);
        }
    }

    public View m2872a(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_question_math_layout, container, false);
        this.f1683c = (TextView) view.findViewById(R.id.problem_text);
        this.f1684d = (EditText) view.findViewById(R.id.math_edit_text);
        this.f1682b = (MathKeyboard) view.findViewById(R.id.math_keyboard);
        this.f1691k = (TextView) view.findViewById(R.id.error_text);
        this.f1692l = (TextView) view.findViewById(R.id.numberSolvedCorrectly);
        this.f1693m = this.f1685e.m2843a(this.f1684d, this.f1691k);
        m2866h();
        m2869k();
        return view;
    }

    public void m2876b() {
        this.f1684d.removeTextChangedListener(this.f1693m);
        this.f1684d.setText("");
        this.f1684d.addTextChangedListener(this.f1693m);
    }

    public void m2878c() {
    }

    public void m2874a(Bundle bundle) {
        if (bundle != null) {
            bundle.putInt("extra_solved_number", this.f1690j);
            bundle.putParcelable("extra_math_problem", this.f1689i);
        }
    }

    public void m2877b(Bundle bundle) {
        if (bundle != null) {
            this.f1690j = bundle.getInt("extra_solved_number", 0);
            this.f1689i = (MathProblem) bundle.getParcelable("extra_math_problem");
        }
    }

    public String m2873a() {
        return "math";
    }

    public void m2875a(String value) {
        this.f1684d.append(value);
    }

    public void m2879d() {
        String text = this.f1684d.getText().toString();
        if (text.length() > 0) {
            this.f1684d.setText(text.substring(0, text.length() - 1));
            if (text.length() > 0) {
                this.f1684d.setSelection(text.length() - 1);
            }
        }
    }

    public void m2880e() {
        m2870l();
    }

    public void m2881f() {
        this.f1685e.m2844a();
    }

    public void m2882g() {
        m2865a(this.f1684d.getContext());
        m2871m();
    }

    private void m2866h() {
        m2868j();
        m2867i();
    }

    private void m2867i() {
        this.f1692l.setText(this.f1685e.m2847b().getString(R.string.question_fragment_solved_correcetly, new Object[]{Integer.valueOf(this.f1690j), Integer.valueOf(this.f1687g)}));
    }

    private void m2868j() {
        if (this.f1689i == null) {
            this.f1689i = new MathProblem(this.f1686f);
        }
        this.f1683c.setText(this.f1689i.toString());
    }

    private void m2869k() {
        this.f1684d.addTextChangedListener(this.f1693m);
        this.f1682b.setListener(this);
        this.f1682b.setAllowPassVisibility(this.f1681a);
        this.f1684d.requestFocus();
        this.f1684d.setOnTouchListener(new C06221(this));
    }

    private void m2870l() {
        if (this.f1689i.m3742a(this.f1684d.getText().toString().trim())) {
            this.f1690j++;
            if (this.f1690j < this.f1687g) {
                this.f1684d.setText("");
                this.f1689i = null;
                m2866h();
                return;
            }
            this.f1685e.m2846a(this.f1688h);
            return;
        }
        this.f1685e.m2845a(this.f1691k, this.f1684d);
    }

    private void m2871m() {
        this.f1689i = new MathProblem(this.f1686f);
        this.f1683c.setText(this.f1689i.toString());
        this.f1684d.setText("");
    }

    private void m2865a(Context context) {
        Toast toast = C0858u.m4024a(context, ac.m3766a(String.format(context.getString(R.string.math_fragment_pass_pressed), new Object[]{this.f1683c.getText(), this.f1689i.m3741a()}), this.f1689i.m3741a(), context.getResources().getColor(R.color.warning_orange)));
        if (C0810h.m3836a(context)) {
            toast.setGravity(48, 0, 0);
        } else {
            toast.setGravity(48, this.f1682b.getLeft(), this.f1682b.getTop() - (C0807e.m3805a(toast.getView()) + ab.m3759a(4, context.getResources())));
        }
        toast.show();
    }
}
