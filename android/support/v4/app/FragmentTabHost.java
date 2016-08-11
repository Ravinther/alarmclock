package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private final ArrayList f102a;
    private Context f103b;
    private C0075i f104c;
    private int f105d;
    private OnTabChangeListener f106e;
    private C0040a f107f;
    private boolean f108g;

    static class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        String f97a;

        /* renamed from: android.support.v4.app.FragmentTabHost.SavedState.1 */
        static class C00391 implements Creator {
            C00391() {
            }

            public /* synthetic */ Object createFromParcel(Parcel x0) {
                return m128a(x0);
            }

            public /* synthetic */ Object[] newArray(int x0) {
                return m129a(x0);
            }

            public SavedState m128a(Parcel in) {
                return new SavedState(null);
            }

            public SavedState[] m129a(int size) {
                return new SavedState[size];
            }
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.f97a = in.readString();
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeString(this.f97a);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f97a + "}";
        }

        static {
            CREATOR = new C00391();
        }
    }

    /* renamed from: android.support.v4.app.FragmentTabHost.a */
    static final class C0040a {
        private final String f98a;
        private final Class f99b;
        private final Bundle f100c;
        private Fragment f101d;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setOnTabChangedListener(OnTabChangeListener l) {
        this.f106e = l;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTab = getCurrentTabTag();
        C0066l ft = null;
        for (int i = 0; i < this.f102a.size(); i++) {
            C0040a tab = (C0040a) this.f102a.get(i);
            tab.f101d = this.f104c.m261a(tab.f98a);
            if (!(tab.f101d == null || tab.f101d.isDetached())) {
                if (tab.f98a.equals(currentTab)) {
                    this.f107f = tab;
                } else {
                    if (ft == null) {
                        ft = this.f104c.m262a();
                    }
                    ft.m190b(tab.f101d);
                }
            }
        }
        this.f108g = true;
        ft = m135a(currentTab, ft);
        if (ft != null) {
            ft.m188b();
            this.f104c.m268b();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f108g = false;
    }

    protected Parcelable onSaveInstanceState() {
        SavedState ss = new SavedState(super.onSaveInstanceState());
        ss.f97a = getCurrentTabTag();
        return ss;
    }

    protected void onRestoreInstanceState(Parcelable state) {
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setCurrentTabByTag(ss.f97a);
    }

    public void onTabChanged(String tabId) {
        if (this.f108g) {
            C0066l ft = m135a(tabId, null);
            if (ft != null) {
                ft.m188b();
            }
        }
        if (this.f106e != null) {
            this.f106e.onTabChanged(tabId);
        }
    }

    private C0066l m135a(String tabId, C0066l ft) {
        C0040a newTab = null;
        for (int i = 0; i < this.f102a.size(); i++) {
            C0040a tab = (C0040a) this.f102a.get(i);
            if (tab.f98a.equals(tabId)) {
                newTab = tab;
            }
        }
        if (newTab == null) {
            throw new IllegalStateException("No tab known for tag " + tabId);
        }
        if (this.f107f != newTab) {
            if (ft == null) {
                ft = this.f104c.m262a();
            }
            if (!(this.f107f == null || this.f107f.f101d == null)) {
                ft.m190b(this.f107f.f101d);
            }
            if (newTab != null) {
                if (newTab.f101d == null) {
                    newTab.f101d = Fragment.instantiate(this.f103b, newTab.f99b.getName(), newTab.f100c);
                    ft.m184a(this.f105d, newTab.f101d, newTab.f98a);
                } else {
                    ft.m192c(newTab.f101d);
                }
            }
            this.f107f = newTab;
        }
        return ft;
    }
}
