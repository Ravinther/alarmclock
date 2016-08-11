package com.anglelabs.alarmclock.redesign.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.avg.toolkit.p049e.C0970a;

public class MathKeyboard extends FrameLayout {
    private TextView f2562a;
    private TextView f2563b;
    private TextView f2564c;
    private TextView f2565d;
    private TextView f2566e;
    private TextView f2567f;
    private TextView f2568g;
    private TextView f2569h;
    private TextView f2570i;
    private TextView f2571j;
    private View f2572k;
    private View f2573l;
    private View f2574m;
    private View f2575n;
    private C0623a f2576o;
    private OnClickListener f2577p;

    /* renamed from: com.anglelabs.alarmclock.redesign.views.MathKeyboard.a */
    public interface C0623a {
        void m2860a(String str);

        void m2861d();

        void m2862e();

        void m2863f();

        void m2864g();
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.views.MathKeyboard.1 */
    class C08851 implements OnClickListener {
        final /* synthetic */ MathKeyboard f2561a;

        C08851(MathKeyboard mathKeyboard) {
            this.f2561a = mathKeyboard;
        }

        public void onClick(View v) {
            if (this.f2561a.f2576o != null) {
                switch (v.getId()) {
                    case R.id.math_one:
                    case R.id.math_two:
                    case R.id.math_three:
                    case R.id.math_four:
                    case R.id.math_five:
                    case R.id.math_six:
                    case R.id.math_seven:
                    case R.id.math_eight:
                    case R.id.math_nine:
                    case R.id.math_zero:
                        try {
                            this.f2561a.f2576o.m2860a(((TextView) v).getText().toString());
                        } catch (Exception e) {
                            C0970a.m4322a(e);
                        }
                    case R.id.math_pass:
                        this.f2561a.f2576o.m2864g();
                    case R.id.math_delete:
                        this.f2561a.f2576o.m2861d();
                    case R.id.math_cancel:
                        this.f2561a.f2576o.m2863f();
                    case R.id.math_submit:
                        this.f2561a.f2576o.m2862e();
                    default:
                }
            }
        }
    }

    public MathKeyboard(Context context) {
        super(context);
        this.f2577p = new C08851(this);
        m4112a();
    }

    public MathKeyboard(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f2577p = new C08851(this);
        m4112a();
    }

    public MathKeyboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f2577p = new C08851(this);
        m4112a();
    }

    public void setListener(C0623a listener) {
        this.f2576o = listener;
        m4110a(this.f2562a, this.f2563b, this.f2564c, this.f2565d, this.f2566e, this.f2567f, this.f2568g, this.f2569h, this.f2570i, this.f2571j, this.f2572k, this.f2573l, this.f2574m, this.f2575n);
    }

    public void setAllowPassVisibility(boolean visible) {
        View allowPass = findViewById(R.id.pass_question_text_and_icon);
        if (visible) {
            allowPass.setVisibility(0);
            m4110a(this.f2572k);
            return;
        }
        allowPass.setVisibility(4);
        this.f2572k.setOnClickListener(null);
    }

    void m4112a() {
        inflate(getContext(), R.layout.math_keyboard_layout, this);
        m4111b();
    }

    private void m4110a(View... views) {
        for (View view : views) {
            if (view != null) {
                view.setOnClickListener(this.f2577p);
            }
        }
    }

    private void m4111b() {
        this.f2562a = (TextView) findViewById(R.id.math_zero);
        this.f2563b = (TextView) findViewById(R.id.math_one);
        this.f2564c = (TextView) findViewById(R.id.math_two);
        this.f2565d = (TextView) findViewById(R.id.math_three);
        this.f2566e = (TextView) findViewById(R.id.math_four);
        this.f2567f = (TextView) findViewById(R.id.math_five);
        this.f2568g = (TextView) findViewById(R.id.math_six);
        this.f2569h = (TextView) findViewById(R.id.math_seven);
        this.f2570i = (TextView) findViewById(R.id.math_eight);
        this.f2571j = (TextView) findViewById(R.id.math_nine);
        this.f2572k = findViewById(R.id.math_pass);
        this.f2573l = findViewById(R.id.math_delete);
        this.f2574m = findViewById(R.id.math_cancel);
        this.f2575n = findViewById(R.id.math_submit);
    }
}
