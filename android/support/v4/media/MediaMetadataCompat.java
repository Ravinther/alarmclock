package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p010d.C0138a;

public final class MediaMetadataCompat implements Parcelable {
    public static final Creator CREATOR;
    private static final C0138a f377a;
    private final Bundle f378b;

    /* renamed from: android.support.v4.media.MediaMetadataCompat.1 */
    static class C01511 implements Creator {
        C01511() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m578a(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m579a(x0);
        }

        public MediaMetadataCompat m578a(Parcel in) {
            return new MediaMetadataCompat(null);
        }

        public MediaMetadataCompat[] m579a(int size) {
            return new MediaMetadataCompat[size];
        }
    }

    static {
        f377a = new C0138a();
        f377a.put("android.media.metadata.TITLE", Integer.valueOf(1));
        f377a.put("android.media.metadata.ARTIST", Integer.valueOf(1));
        f377a.put("android.media.metadata.DURATION", Integer.valueOf(0));
        f377a.put("android.media.metadata.ALBUM", Integer.valueOf(1));
        f377a.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
        f377a.put("android.media.metadata.WRITER", Integer.valueOf(1));
        f377a.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
        f377a.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
        f377a.put("android.media.metadata.DATE", Integer.valueOf(1));
        f377a.put("android.media.metadata.YEAR", Integer.valueOf(0));
        f377a.put("android.media.metadata.GENRE", Integer.valueOf(1));
        f377a.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
        f377a.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
        f377a.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
        f377a.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
        f377a.put("android.media.metadata.ART", Integer.valueOf(2));
        f377a.put("android.media.metadata.ART_URI", Integer.valueOf(1));
        f377a.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
        f377a.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
        f377a.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
        f377a.put("android.media.metadata.RATING", Integer.valueOf(3));
        f377a.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
        f377a.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
        f377a.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
        f377a.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
        f377a.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
        CREATOR = new C01511();
    }

    private MediaMetadataCompat(Parcel in) {
        this.f378b = in.readBundle();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeBundle(this.f378b);
    }
}
