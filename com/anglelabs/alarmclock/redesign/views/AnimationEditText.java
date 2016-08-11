package com.anglelabs.alarmclock.redesign.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.anglelabs.alarmclock.redesign.utils.C0807e;
import com.anglelabs.alarmclock.redesign.utils.ac;

public class AnimationEditText extends EditText {
    private C0552a f2512a;
    private int f2513b;
    private boolean f2514c;

    /* renamed from: com.anglelabs.alarmclock.redesign.views.AnimationEditText.a */
    public interface C0552a {
        AnimationEditText m2526a();

        void m2527a(AnimationEditText animationEditText);

        boolean m2528a(Object obj, Object obj2);

        void m2529b(AnimationEditText animationEditText);

        boolean m2530c(AnimationEditText animationEditText);

        void m2531d(AnimationEditText animationEditText);
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.views.AnimationEditText.1 */
    class C08721 implements OnEditorActionListener {
        final /* synthetic */ AnimationEditText f2510a;

        C08721(AnimationEditText animationEditText) {
            this.f2510a = animationEditText;
        }

        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId != 6 && actionId != 5) {
                return false;
            }
            this.f2510a.m4075a(true, true);
            return true;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.views.AnimationEditText.2 */
    class C08732 implements OnTouchListener {
        final /* synthetic */ AnimationEditText f2511a;

        C08732(AnimationEditText animationEditText) {
            this.f2511a = animationEditText;
        }

        public boolean onTouch(View view, MotionEvent event) {
            if (event.getAction() == 0) {
                if (this.f2511a.f2512a.m2530c(this.f2511a)) {
                    this.f2511a.m4073a();
                } else {
                    AnimationEditText prevEditText = this.f2511a.f2512a.m2526a();
                    if (prevEditText != null) {
                        prevEditText.m4075a(true, true);
                    }
                }
            }
            return false;
        }
    }

    public AnimationEditText(Context context) {
        super(context);
        this.f2514c = false;
    }

    public AnimationEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f2514c = false;
    }

    public AnimationEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f2514c = false;
    }

    public void m4074a(C0552a editLabel, OnLongClickListener longClickListener, int targetSize) {
        this.f2512a = editLabel;
        if (this.f2514c) {
            m4075a(false, false);
        }
        setSelectAllOnFocus(true);
        setOnLongClickListener(longClickListener);
        setOnEditorActionListener(new C08721(this));
        setOnTouchListener(new C08732(this));
        this.f2513b = targetSize;
    }

    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (event.getAction() != 1 || keyCode != 4 || this.f2512a == null) {
            return super.onKeyPreIme(keyCode, event);
        }
        m4075a(true, true);
        return true;
    }

    public void m4073a() {
        AnimationEditText prevEditText = this.f2512a.m2526a();
        if (prevEditText != null) {
            Object currItem = getTag();
            Object prevItem = prevEditText.getTag();
            if (!(currItem == null || prevItem == null || this.f2512a.m2528a(prevItem, currItem))) {
                prevEditText.m4075a(true, false);
            }
        }
        ac.m3768a(getContext(), (View) this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        C0807e.m3821d(this, this.f2513b).m4999a();
        this.f2514c = true;
        this.f2512a.m2527a(this);
    }

    public void m4075a(boolean animated, boolean closeKeyboard) {
        if (closeKeyboard) {
            ac.m3775b(getContext(), this);
        }
        if (animated) {
            this.f2512a.m2531d(this);
            C0807e.m3823f(this).m4999a();
        } else {
            C0807e.m3824g(this);
        }
        setFocusable(false);
        setFocusableInTouchMode(false);
        this.f2514c = false;
        AnimationEditText prevEditText = this.f2512a.m2526a();
        if (prevEditText != null && prevEditText.isInEditMode()) {
            prevEditText.m4075a(true, false);
        }
        this.f2512a.m2529b(this);
    }
}
