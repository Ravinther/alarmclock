package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

final class FragmentState implements Parcelable {
    public static final Creator CREATOR;
    final String f86a;
    final int f87b;
    final boolean f88c;
    final int f89d;
    final int f90e;
    final String f91f;
    final boolean f92g;
    final boolean f93h;
    final Bundle f94i;
    Bundle f95j;
    Fragment f96k;

    /* renamed from: android.support.v4.app.FragmentState.1 */
    static class C00371 implements Creator {
        C00371() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m125a(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m126a(x0);
        }

        public FragmentState m125a(Parcel in) {
            return new FragmentState(in);
        }

        public FragmentState[] m126a(int size) {
            return new FragmentState[size];
        }
    }

    public FragmentState(Fragment frag) {
        this.f86a = frag.getClass().getName();
        this.f87b = frag.mIndex;
        this.f88c = frag.mFromLayout;
        this.f89d = frag.mFragmentId;
        this.f90e = frag.mContainerId;
        this.f91f = frag.mTag;
        this.f92g = frag.mRetainInstance;
        this.f93h = frag.mDetached;
        this.f94i = frag.mArguments;
    }

    public FragmentState(Parcel in) {
        boolean z;
        boolean z2 = true;
        this.f86a = in.readString();
        this.f87b = in.readInt();
        this.f88c = in.readInt() != 0;
        this.f89d = in.readInt();
        this.f90e = in.readInt();
        this.f91f = in.readString();
        if (in.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.f92g = z;
        if (in.readInt() == 0) {
            z2 = false;
        }
        this.f93h = z2;
        this.f94i = in.readBundle();
        this.f95j = in.readBundle();
    }

    public Fragment m127a(C0073g activity, Fragment parent) {
        if (this.f96k != null) {
            return this.f96k;
        }
        if (this.f94i != null) {
            this.f94i.setClassLoader(activity.getClassLoader());
        }
        this.f96k = Fragment.instantiate(activity, this.f86a, this.f94i);
        if (this.f95j != null) {
            this.f95j.setClassLoader(activity.getClassLoader());
            this.f96k.mSavedFragmentState = this.f95j;
        }
        this.f96k.setIndex(this.f87b, parent);
        this.f96k.mFromLayout = this.f88c;
        this.f96k.mRestored = true;
        this.f96k.mFragmentId = this.f89d;
        this.f96k.mContainerId = this.f90e;
        this.f96k.mTag = this.f91f;
        this.f96k.mRetainInstance = this.f92g;
        this.f96k.mDetached = this.f93h;
        this.f96k.mFragmentManager = activity.f187b;
        if (C0082j.f213a) {
            Log.v("FragmentManager", "Instantiated fragment " + this.f96k);
        }
        return this.f96k;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i;
        int i2 = 1;
        dest.writeString(this.f86a);
        dest.writeInt(this.f87b);
        dest.writeInt(this.f88c ? 1 : 0);
        dest.writeInt(this.f89d);
        dest.writeInt(this.f90e);
        dest.writeString(this.f91f);
        if (this.f92g) {
            i = 1;
        } else {
            i = 0;
        }
        dest.writeInt(i);
        if (!this.f93h) {
            i2 = 0;
        }
        dest.writeInt(i2);
        dest.writeBundle(this.f94i);
        dest.writeBundle(this.f95j);
    }

    static {
        CREATOR = new C00371();
    }
}
