package com.millennialmedia.android;

import android.content.Context;
import android.os.Parcel;
import com.google.android.gms.location.LocationStatusCodes;
import java.io.Externalizable;
import java.io.File;
import java.io.FileFilter;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

abstract class CachedAd implements Externalizable {
    static final int INTERSTITIAL = 2;
    static final int NATIVE = 3;
    static final int VIDEO = 1;
    static final long serialVersionUID = 316862728709355974L;
    String acid;
    String contentUrl;
    long deferredViewStart;
    boolean downloadAllOrNothing;
    int downloadPriority;
    Date expiration;
    private String id;

    /* renamed from: com.millennialmedia.android.CachedAd.1 */
    class C24651 implements FileFilter {
        C24651() {
        }

        public boolean accept(File file) {
            return file.isFile() && file.getName().startsWith(CachedAd.this.id);
        }
    }

    abstract boolean canShow(Context context, MMAdImpl mMAdImpl, boolean z);

    abstract boolean download(Context context);

    abstract int getType();

    abstract String getTypeString();

    abstract boolean isOnDisk(Context context);

    abstract boolean saveAssets(Context context);

    abstract void show(Context context, long j);

    CachedAd() {
        this.downloadAllOrNothing = false;
        this.deferredViewStart = System.currentTimeMillis();
    }

    protected CachedAd(Parcel in) {
        this.downloadAllOrNothing = false;
        try {
            this.id = in.readString();
            this.acid = in.readString();
            this.expiration = (Date) in.readSerializable();
            this.deferredViewStart = in.readLong();
            boolean[] yo = new boolean[VIDEO];
            in.readBooleanArray(yo);
            this.downloadAllOrNothing = yo[0];
            this.contentUrl = in.readString();
            this.downloadPriority = in.readInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.acid);
        dest.writeSerializable(this.expiration);
        dest.writeLong(this.deferredViewStart);
        boolean[] zArr = new boolean[VIDEO];
        zArr[0] = this.downloadAllOrNothing;
        dest.writeBooleanArray(zArr);
        dest.writeString(this.contentUrl);
        dest.writeInt(this.downloadPriority);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CachedAd)) {
            return false;
        }
        return this.id.equals(((CachedAd) other).id);
    }

    protected void deserializeFromObj(JSONObject videoObject) {
        this.id = videoObject.optString("id", null);
        this.acid = videoObject.optString("vid", null);
        this.contentUrl = videoObject.optString("content-url", null);
        String exp = videoObject.optString("expiration", null);
        if (exp != null) {
            try {
                this.expiration = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ZZZZ").parse(exp);
            } catch (Throwable e) {
                Log.m9716e(e);
            }
        }
    }

    boolean isExpired() {
        if (this.expiration == null || this.expiration.getTime() > System.currentTimeMillis()) {
            return false;
        }
        return true;
    }

    boolean isValid() {
        if (this.id == null || this.id.length() <= 0 || this.contentUrl == null || this.contentUrl.length() <= 0) {
            return false;
        }
        return true;
    }

    void delete(Context context) {
        File dir = AdCache.getCacheDirectory(context);
        if (dir != null && dir.isDirectory()) {
            try {
                File[] files = dir.listFiles(new C24651());
                Object[] objArr = new Object[INTERSTITIAL];
                objArr[0] = Integer.valueOf(files.length);
                objArr[VIDEO] = this.id;
                Log.m9724v("Deleting %d files for %s.", objArr);
                for (int i = 0; i < files.length; i += VIDEO) {
                    files[i].delete();
                }
            } catch (Throwable e) {
                Log.m9725v(e);
            }
        }
    }

    static CachedAd parseJSON(String json) {
        if (MMSDK.logLevel >= 5) {
            Log.m9723v("Received cached ad.");
            int length = json.length();
            if (length > LocationStatusCodes.GEOFENCE_NOT_AVAILABLE) {
                int e = 999;
                int s = 0;
                while (e < length) {
                    Log.m9723v(json.substring(s, e));
                    s = e;
                    e += LocationStatusCodes.GEOFENCE_NOT_AVAILABLE;
                    if (e > length) {
                        e = length - 1;
                        break;
                    }
                }
                Log.m9723v(json.substring(s, e));
            } else {
                Log.m9723v(json);
            }
        }
        if (json.length() > 0) {
            return new VideoAd(json);
        }
        return null;
    }

    public void readExternal(ObjectInput input) {
        this.id = (String) input.readObject();
        this.acid = (String) input.readObject();
        this.expiration = (Date) input.readObject();
        this.deferredViewStart = input.readLong();
        this.contentUrl = (String) input.readObject();
    }

    public void writeExternal(ObjectOutput output) {
        output.writeObject(this.id);
        output.writeObject(this.acid);
        output.writeObject(this.expiration);
        output.writeLong(this.deferredViewStart);
        output.writeObject(this.contentUrl);
    }

    String getId() {
        return this.id;
    }

    void setId(String idIn) {
        this.id = idIn;
    }
}
