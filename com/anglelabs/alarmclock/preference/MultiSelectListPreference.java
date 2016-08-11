package com.anglelabs.alarmclock.preference;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.preference.Preference.BaseSavedState;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.anglelabs.alarmclock.preference.base.BaseListPreference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiSelectListPreference extends BaseListPreference {
    private final boolean[] f1338a;
    private String f1339b;
    private String f1340c;

    /* renamed from: com.anglelabs.alarmclock.preference.MultiSelectListPreference.1 */
    class C05041 implements OnMultiChoiceClickListener {
        final /* synthetic */ MultiSelectListPreference f1336a;

        C05041(MultiSelectListPreference multiSelectListPreference) {
            this.f1336a = multiSelectListPreference;
        }

        public void onClick(DialogInterface dialog, int which, boolean val) {
            this.f1336a.f1338a[which] = val;
        }
    }

    private static class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        boolean[] f1337a;

        /* renamed from: com.anglelabs.alarmclock.preference.MultiSelectListPreference.SavedState.1 */
        static class C05051 implements Creator {
            C05051() {
            }

            public /* synthetic */ Object createFromParcel(Parcel x0) {
                return m2399a(x0);
            }

            public /* synthetic */ Object[] newArray(int x0) {
                return m2400a(x0);
            }

            public SavedState m2399a(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] m2400a(int size) {
                return new SavedState[size];
            }
        }

        public SavedState(Parcel source) {
            super(source);
            if (this.f1337a != null) {
                source.readBooleanArray(this.f1337a);
            }
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            if (this.f1337a != null) {
                dest.writeBooleanArray(this.f1337a);
            }
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }

        static {
            CREATOR = new C05051();
        }
    }

    public MultiSelectListPreference(Context context) {
        this(context, null);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1338a = new boolean[getEntries().length];
    }

    protected void onPrepareDialogBuilder(Builder builder) {
        CharSequence[] entries = getEntries();
        CharSequence[] entryValues = getEntryValues();
        if (entries == null || entryValues == null || entries.length != entryValues.length) {
            throw new IllegalStateException("MultiSelectListPreference entries-array and entry-Values array have to be both in the same length");
        }
        m2404a(entryValues);
        builder.setMultiChoiceItems(entries, this.f1338a, new C05041(this));
    }

    private void m2404a(CharSequence[] entryValues) {
        CharSequence[] values = m2405a(getValue());
        if (values != null) {
            List valuesList = Arrays.asList(values);
            for (int i = 0; i < entryValues.length; i++) {
                this.f1338a[i] = valuesList.contains(entryValues[i]);
            }
        }
    }

    protected void onDialogClosed(boolean positiveResult) {
        CharSequence[] entryValues = getEntryValues();
        if (positiveResult && entryValues != null) {
            List values = new ArrayList();
            for (int i = 0; i < entryValues.length; i++) {
                if (this.f1338a[i]) {
                    values.add(entryValues[i]);
                }
            }
            m2403a(values, m2408c(values));
        }
    }

    private void m2403a(List values, String value) {
        if (callChangeListener(values)) {
            setSummary(m2402a(values));
            setValue(value);
        }
    }

    private CharSequence m2402a(List joined) {
        List titles = new ArrayList();
        CharSequence[] entryTitle = getEntries();
        CharSequence[] entryValues = getEntryValues();
        int ix = 0;
        if (joined.size() == entryValues.length && this.f1339b != null) {
            return this.f1339b;
        }
        if (joined.size() == 0 && this.f1339b != null) {
            return this.f1340c;
        }
        for (CharSequence value : entryValues) {
            if (joined.contains(value)) {
                titles.add(entryTitle[ix].toString());
            }
            ix++;
        }
        return m2407b(titles);
    }

    public void m2409a(String allCheckedSummary, String noneCheckedSummary) {
        this.f1339b = allCheckedSummary;
        this.f1340c = noneCheckedSummary;
        onSetInitialValue(true, m2410a());
    }

    protected Object onGetDefaultValue(TypedArray typedArray, int index) {
        return typedArray.getTextArray(index);
    }

    protected void onSetInitialValue(boolean restoreValue, Object rawDefaultValue) {
        List joined;
        String value;
        if (rawDefaultValue == null || !(rawDefaultValue instanceof CharSequence[])) {
            joined = new ArrayList();
        } else {
            joined = Arrays.asList((CharSequence[]) rawDefaultValue);
        }
        String joinedDefaultValue = m2408c(joined);
        if (restoreValue) {
            value = getPersistedString(joinedDefaultValue);
        } else {
            value = joinedDefaultValue;
        }
        m2403a(joined, value);
    }

    public CharSequence[] m2410a() {
        return m2405a(getValue());
    }

    private static String m2407b(List list) {
        if (list == null) {
            return "";
        }
        return TextUtils.join(", ", list);
    }

    private static String m2408c(List list) {
        return TextUtils.join("\u201a\u2017\u201a", list);
    }

    private static String[] m2405a(String strToList) {
        return TextUtils.split(strToList, "\u201a\u2017\u201a");
    }

    protected Parcelable onSaveInstanceState() {
        SavedState myState = new SavedState(super.onSaveInstanceState());
        myState.f1337a = this.f1338a;
        return myState;
    }

    protected void onRestoreInstanceState(Parcelable state) {
        if (state == null || !state.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState myState = (SavedState) state;
        super.onRestoreInstanceState(myState.getSuperState());
        for (int i = 0; i < myState.f1337a.length; i++) {
            this.f1338a[i] = myState.f1337a[i];
        }
    }
}
