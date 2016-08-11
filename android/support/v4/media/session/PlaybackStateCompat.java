package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class PlaybackStateCompat implements Parcelable {
    public static final Creator CREATOR;
    private final int f382a;
    private final long f383b;
    private final long f384c;
    private final float f385d;
    private final long f386e;
    private final CharSequence f387f;
    private final long f388g;

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat.1 */
    static class C01541 implements Creator {
        C01541() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m584a(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m585a(x0);
        }

        public PlaybackStateCompat m584a(Parcel in) {
            return new PlaybackStateCompat(null);
        }

        public PlaybackStateCompat[] m585a(int size) {
            return new PlaybackStateCompat[size];
        }
    }

    private PlaybackStateCompat(Parcel in) {
        this.f382a = in.readInt();
        this.f383b = in.readLong();
        this.f385d = in.readFloat();
        this.f388g = in.readLong();
        this.f384c = in.readLong();
        this.f386e = in.readLong();
        this.f387f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
    }

    public String toString() {
        StringBuilder bob = new StringBuilder("PlaybackState {");
        bob.append("state=").append(this.f382a);
        bob.append(", position=").append(this.f383b);
        bob.append(", buffered position=").append(this.f384c);
        bob.append(", speed=").append(this.f385d);
        bob.append(", updated=").append(this.f388g);
        bob.append(", actions=").append(this.f386e);
        bob.append(", error=").append(this.f387f);
        bob.append("}");
        return bob.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f382a);
        dest.writeLong(this.f383b);
        dest.writeFloat(this.f385d);
        dest.writeLong(this.f388g);
        dest.writeLong(this.f384c);
        dest.writeLong(this.f386e);
        TextUtils.writeToParcel(this.f387f, dest, flags);
    }

    static {
        CREATOR = new C01541();
    }
}
