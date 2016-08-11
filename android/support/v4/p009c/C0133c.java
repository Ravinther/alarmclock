package android.support.v4.p009c;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* renamed from: android.support.v4.c.c */
class C0133c implements ClassLoaderCreator {
    private final C0132b f335a;

    public C0133c(C0132b callbacks) {
        this.f335a = callbacks;
    }

    public Object createFromParcel(Parcel in) {
        return this.f335a.m499a(in, null);
    }

    public Object createFromParcel(Parcel in, ClassLoader loader) {
        return this.f335a.m499a(in, loader);
    }

    public Object[] newArray(int size) {
        return this.f335a.m500a(size);
    }
}
