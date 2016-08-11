package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v7.p014b.C0364a.C0363j;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

/* renamed from: android.support.v7.internal.widget.e */
public class C0375e extends TextView {

    /* renamed from: android.support.v7.internal.widget.e.a */
    private static class C0451a implements TransformationMethod {
        private final Locale f1162a;

        public C0451a(Context context) {
            this.f1162a = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence source, View view) {
            return source != null ? source.toString().toUpperCase(this.f1162a) : null;
        }

        public void onFocusChanged(View view, CharSequence charSequence, boolean b, int i, Rect rect) {
        }
    }

    public C0375e(Context context) {
        this(context, null);
    }

    public C0375e(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public C0375e(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray style = context.obtainStyledAttributes(attrs, C0363j.CompatTextView, defStyle, 0);
        boolean allCaps = style.getBoolean(0, false);
        style.recycle();
        if (allCaps) {
            setTransformationMethod(new C0451a(context));
        }
    }
}
