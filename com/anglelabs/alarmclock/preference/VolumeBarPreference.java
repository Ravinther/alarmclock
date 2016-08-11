package com.anglelabs.alarmclock.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.anglelabs.alarmclock.preference.base.C0507a;

public class VolumeBarPreference extends C0507a implements OnSeekBarChangeListener {
    private SeekBar f1356a;
    private TextView f1357b;
    private Context f1358c;
    private String f1359d;
    private int f1360e;
    private int f1361f;
    private int f1362g;
    private int f1363h;
    private int f1364i;

    public VolumeBarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f1361f = 0;
        this.f1364i = 100;
        this.f1358c = context;
        this.f1359d = attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "text");
        this.f1362g = attrs.getAttributeIntValue("http://schemas.android.com/apk/res/android", "defaultValue", 100);
        this.f1364i = attrs.getAttributeIntValue("http://schemas.android.com/apk/res/android", "max", 100);
        this.f1361f = Integer.parseInt(getPersistedString(Integer.toString(this.f1362g)));
    }

    protected View onCreateDialogView() {
        LinearLayout layout = new LinearLayout(this.f1358c);
        layout.setOrientation(1);
        layout.setPadding(6, 6, 6, 6);
        this.f1357b = m2423c();
        this.f1357b.setGravity(1);
        this.f1357b.setTextSize(32.0f);
        layout.addView(this.f1357b, new LayoutParams(-1, -2));
        this.f1356a = new SeekBar(this.f1358c);
        this.f1356a.setOnSeekBarChangeListener(this);
        layout.addView(this.f1356a, new LayoutParams(-1, -2));
        if (shouldPersist()) {
            this.f1361f = Integer.parseInt(getPersistedString(Integer.toString(this.f1362g)));
        }
        if (this.f1361f < 0) {
            this.f1361f = 0;
        }
        this.f1356a.setMax(this.f1364i);
        this.f1356a.setProgress(this.f1361f);
        String t = String.valueOf(this.f1361f);
        TextView textView = this.f1357b;
        if (this.f1359d != null) {
            t = t.concat(this.f1359d);
        }
        textView.setText(t);
        return layout;
    }

    protected void onBindDialogView(View v) {
        super.onBindDialogView(v);
        this.f1356a.setMax(this.f1364i);
        this.f1356a.setProgress(this.f1361f);
        this.f1363h = this.f1361f;
    }

    protected void onSetInitialValue(boolean restore, Object defaultValue) {
        super.onSetInitialValue(restore, defaultValue);
        if (restore) {
            this.f1361f = Integer.parseInt(getPersistedString(Integer.toString(this.f1362g)));
        } else {
            this.f1361f = ((Integer) defaultValue).intValue();
        }
    }

    public void onProgressChanged(SeekBar seek, int value, boolean fromTouch) {
        int displayValue = value;
        if (value >= this.f1360e) {
            displayValue -= displayValue % 5;
            String t = String.valueOf(displayValue);
            TextView textView = this.f1357b;
            if (this.f1359d != null) {
                t = t.concat(this.f1359d);
            }
            textView.setText(t);
            this.f1361f = displayValue;
        } else if (fromTouch) {
            m2431a(this.f1360e);
        }
    }

    protected void onDialogClosed(boolean positiveResult) {
        if (positiveResult) {
            callChangeListener(Integer.valueOf(this.f1361f));
            if (shouldPersist()) {
                persistString(String.valueOf(this.f1361f));
            }
        } else {
            this.f1361f = this.f1363h;
        }
        super.onDialogClosed(positiveResult);
    }

    public void onStartTrackingTouch(SeekBar seek) {
    }

    public void onStopTrackingTouch(SeekBar seek) {
    }

    public void m2431a(int progress) {
        if (progress < this.f1360e) {
            this.f1361f = this.f1360e;
        } else {
            this.f1361f = progress - (progress % 5);
        }
        if (this.f1356a != null) {
            this.f1356a.setProgress(this.f1361f);
        }
    }
}
