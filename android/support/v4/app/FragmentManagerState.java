package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState implements Parcelable {
    public static final Creator CREATOR;
    FragmentState[] f83a;
    int[] f84b;
    BackStackState[] f85c;

    /* renamed from: android.support.v4.app.FragmentManagerState.1 */
    static class C00361 implements Creator {
        C00361() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m123a(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m124a(x0);
        }

        public FragmentManagerState m123a(Parcel in) {
            return new FragmentManagerState(in);
        }

        public FragmentManagerState[] m124a(int size) {
            return new FragmentManagerState[size];
        }
    }

    public FragmentManagerState(Parcel in) {
        this.f83a = (FragmentState[]) in.createTypedArray(FragmentState.CREATOR);
        this.f84b = in.createIntArray();
        this.f85c = (BackStackState[]) in.createTypedArray(BackStackState.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedArray(this.f83a, flags);
        dest.writeIntArray(this.f84b);
        dest.writeTypedArray(this.f85c, flags);
    }

    static {
        CREATOR = new C00361();
    }
}
