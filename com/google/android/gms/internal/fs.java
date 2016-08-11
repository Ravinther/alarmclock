package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.C1336R;
import com.mopub.mobileads.util.Base64;

public final class fs extends Button {
    public fs(Context context) {
        this(context, null);
    }

    public fs(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private int m8527b(int i, int i2, int i3) {
        switch (i) {
            case Base64.DEFAULT /*0*/:
                return i2;
            case Base64.NO_PADDING /*1*/:
                return i3;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }

    private void m8528b(Resources resources, int i, int i2) {
        int b;
        switch (i) {
            case Base64.DEFAULT /*0*/:
            case Base64.NO_PADDING /*1*/:
                b = m8527b(i2, C1336R.drawable.common_signin_btn_text_dark, C1336R.drawable.common_signin_btn_text_light);
                break;
            case Base64.NO_WRAP /*2*/:
                b = m8527b(i2, C1336R.drawable.common_signin_btn_icon_dark, C1336R.drawable.common_signin_btn_icon_light);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        if (b == -1) {
            throw new IllegalStateException("Could not find background resource!");
        }
        setBackgroundDrawable(resources.getDrawable(b));
    }

    private void m8529c(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    private void m8530c(Resources resources, int i, int i2) {
        setTextColor(resources.getColorStateList(m8527b(i2, C1336R.color.common_signin_btn_text_dark, C1336R.color.common_signin_btn_text_light)));
        switch (i) {
            case Base64.DEFAULT /*0*/:
                setText(resources.getString(C1336R.string.common_signin_button_text));
            case Base64.NO_PADDING /*1*/:
                setText(resources.getString(C1336R.string.common_signin_button_text_long));
            case Base64.NO_WRAP /*2*/:
                setText(null);
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
    }

    public void m8531a(Resources resources, int i, int i2) {
        boolean z = true;
        boolean z2 = i >= 0 && i < 3;
        fq.m8515a(z2, "Unknown button size " + i);
        if (i2 < 0 || i2 >= 2) {
            z = false;
        }
        fq.m8515a(z, "Unknown color scheme " + i2);
        m8529c(resources);
        m8528b(resources, i, i2);
        m8530c(resources, i, i2);
    }
}
