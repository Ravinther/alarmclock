package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MediaSessionCompat {

    public static final class Token implements Parcelable {
        public static final Creator CREATOR;
        private final Parcelable f381a;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat.Token.1 */
        static class C01531 implements Creator {
            C01531() {
            }

            public /* synthetic */ Object createFromParcel(Parcel x0) {
                return m582a(x0);
            }

            public /* synthetic */ Object[] newArray(int x0) {
                return m583a(x0);
            }

            public Token m582a(Parcel in) {
                return new Token(in.readParcelable(null));
            }

            public Token[] m583a(int size) {
                return new Token[size];
            }
        }

        Token(Parcelable inner) {
            this.f381a = inner;
        }

        public int describeContents() {
            return this.f381a.describeContents();
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeParcelable(this.f381a, flags);
        }

        static {
            CREATOR = new C01531();
        }
    }
}
