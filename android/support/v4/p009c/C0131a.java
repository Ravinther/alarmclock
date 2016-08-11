package android.support.v4.p009c;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.c.a */
public class C0131a {

    /* renamed from: android.support.v4.c.a.a */
    static class C0130a implements Creator {
        final C0132b f334a;

        public C0130a(C0132b callbacks) {
            this.f334a = callbacks;
        }

        public Object createFromParcel(Parcel source) {
            return this.f334a.m499a(source, null);
        }

        public Object[] newArray(int size) {
            return this.f334a.m500a(size);
        }
    }

    public static Creator m498a(C0132b callbacks) {
        if (VERSION.SDK_INT >= 13) {
            C0134d.m501a(callbacks);
        }
        return new C0130a(callbacks);
    }
}
