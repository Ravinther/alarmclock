package com.anglelabs.alarmclock.preference;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.preference.Preference.BaseSavedState;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.preference.base.C0507a;

public class SeekBarPreference extends C0507a implements OnSeekBarChangeListener {
    private SeekBar f1345a;
    private TextView f1346b;
    private final Context f1347c;
    private final String f1348d;
    private int f1349e;
    private int f1350f;
    private int f1351g;
    private int f1352h;
    private int f1353i;
    private boolean f1354j;

    private static class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        int f1344a;

        /* renamed from: com.anglelabs.alarmclock.preference.SeekBarPreference.SavedState.1 */
        static class C05061 implements Creator {
            C05061() {
            }

            public /* synthetic */ Object createFromParcel(Parcel x0) {
                return m2420a(x0);
            }

            public /* synthetic */ Object[] newArray(int x0) {
                return m2421a(x0);
            }

            public SavedState m2420a(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] m2421a(int size) {
                return new SavedState[size];
            }
        }

        public SavedState(Parcel source) {
            super(source);
            this.f1344a = source.readInt();
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.f1344a);
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }

        static {
            CREATOR = new C05061();
        }
    }

    public SeekBarPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f1351g = 0;
        this.f1352h = 1;
        this.f1353i = 0;
        this.f1354j = false;
        this.f1347c = context;
        if (attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "text") == null || !attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "text").equals("minutes")) {
            this.f1348d = attrs.getAttributeValue("http://schemas.android.com/apk/res/android", "text");
        } else {
            this.f1348d = " " + context.getString(R.string.minutes_no_number);
        }
        this.f1349e = attrs.getAttributeIntValue("http://schemas.android.com/apk/res/android", "defaultValue", 10);
        this.f1350f = attrs.getAttributeIntValue("http://schemas.android.com/apk/res/android", "max", 60);
        this.f1351g = Integer.parseInt(getPersistedString(Integer.toString(this.f1349e)));
    }

    protected View onCreateDialogView() {
        LinearLayout layout = new LinearLayout(this.f1347c);
        layout.setOrientation(1);
        layout.setPadding(6, 6, 6, 6);
        this.f1346b = m2423c();
        this.f1346b.setGravity(1);
        this.f1346b.setTextSize(32.0f);
        layout.addView(this.f1346b, new LayoutParams(-1, -2));
        this.f1345a = new SeekBar(this.f1347c);
        this.f1345a.setOnSeekBarChangeListener(this);
        layout.addView(this.f1345a, new LayoutParams(-1, -2));
        if (shouldPersist()) {
            this.f1351g = Integer.parseInt(getPersistedString(Integer.toString(this.f1349e)));
        }
        if (this.f1351g < 0) {
            this.f1351g = 0;
        }
        this.f1345a.setProgress(this.f1351g);
        this.f1345a.setMax(this.f1350f);
        if (this.f1351g >= 1 || !this.f1354j) {
            String t = String.valueOf(this.f1351g);
            TextView textView = this.f1346b;
            if (this.f1348d != null) {
                t = t.concat(this.f1348d);
            }
            textView.setText(t);
        } else {
            this.f1346b.setText(R.string.unlimited);
        }
        return layout;
    }

    protected void onBindDialogView(View v) {
        super.onBindDialogView(v);
        this.f1345a.setMax(this.f1350f);
        this.f1345a.setProgress(this.f1351g);
        this.f1353i = this.f1351g;
    }

    protected void onSetInitialValue(boolean restore, Object defaultValue) {
        super.onSetInitialValue(restore, defaultValue);
        if (restore) {
            this.f1351g = Integer.parseInt(getPersistedString(Integer.toString(this.f1349e)));
        } else {
            this.f1351g = ((Integer) defaultValue).intValue();
        }
    }

    public void onProgressChanged(SeekBar seek, int value, boolean fromTouch) {
        if (value >= 1 || this.f1352h == 0) {
            String t = String.valueOf(value);
            TextView textView = this.f1346b;
            if (this.f1348d != null) {
                t = t.concat(this.f1348d);
            }
            textView.setText(t);
            this.f1351g = value;
        } else if (this.f1354j) {
            this.f1346b.setText(R.string.unlimited);
            this.f1351g = value;
        } else if (fromTouch) {
            m2427b(1);
        }
    }

    protected void onDialogClosed(boolean positiveResult) {
        if (positiveResult) {
            callChangeListener(Integer.valueOf(this.f1351g));
            if (shouldPersist()) {
                persistString(Integer.toString(this.f1351g));
            }
        } else {
            this.f1351g = this.f1353i;
        }
        super.onDialogClosed(positiveResult);
    }

    public void onStartTrackingTouch(SeekBar seek) {
    }

    public void onStopTrackingTouch(SeekBar seek) {
    }

    public void m2426a(boolean unlimited) {
        this.f1354j = unlimited;
    }

    public void m2425a(int min) {
        this.f1352h = min;
    }

    public void m2427b(int progress) {
        if (progress < 0) {
            this.f1351g = 0;
        } else {
            this.f1351g = progress;
        }
        if (this.f1345a != null) {
            this.f1345a.setProgress(progress);
        }
    }

    public int m2424a() {
        return this.f1351g;
    }

    protected Parcelable onSaveInstanceState() {
        SavedState myState = new SavedState(super.onSaveInstanceState());
        myState.f1344a = this.f1351g;
        return myState;
    }

    protected void onRestoreInstanceState(Parcelable state) {
        if (state == null || !state.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState myState = (SavedState) state;
        super.onRestoreInstanceState(myState.getSuperState());
        m2427b(myState.f1344a);
    }
}
