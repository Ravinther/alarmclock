package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat implements Parcelable {
    public static final Creator CREATOR;
    private final int f379a;
    private final float f380b;

    /* renamed from: android.support.v4.media.RatingCompat.1 */
    static class C01521 implements Creator {
        C01521() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m580a(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m581a(x0);
        }

        public RatingCompat m580a(Parcel p) {
            return new RatingCompat(p.readFloat(), null);
        }

        public RatingCompat[] m581a(int size) {
            return new RatingCompat[size];
        }
    }

    private RatingCompat(int ratingStyle, float rating) {
        this.f379a = ratingStyle;
        this.f380b = rating;
    }

    public String toString() {
        return "Rating:style=" + this.f379a + " rating=" + (this.f380b < 0.0f ? "unrated" : String.valueOf(this.f380b));
    }

    public int describeContents() {
        return this.f379a;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f379a);
        dest.writeFloat(this.f380b);
    }

    static {
        CREATOR = new C01521();
    }
}
