package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.avg.toolkit.ads.AdsManager;
import com.google.android.gms.location.LocationStatusCodes;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONArray;
import org.json.JSONObject;

class VideoLogEvent implements Parcelable, Externalizable {
    public static final Creator CREATOR;
    static final long serialVersionUID = 795553873017368584L;
    String[] activities;
    long position;

    /* renamed from: com.millennialmedia.android.VideoLogEvent.1 */
    static class C25171 implements Creator {
        C25171() {
        }

        public VideoLogEvent createFromParcel(Parcel in) {
            return new VideoLogEvent(in);
        }

        public VideoLogEvent[] newArray(int size) {
            return new VideoLogEvent[size];
        }
    }

    VideoLogEvent(JSONObject logObject) {
        deserializeFromObj(logObject);
    }

    VideoLogEvent(Parcel in) {
        try {
            this.position = in.readLong();
            this.activities = new String[in.readInt()];
            in.readStringArray(this.activities);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deserializeFromObj(JSONObject logObject) {
        if (logObject != null) {
            this.position = (long) (logObject.optInt(AdsManager.PREFS_KEY_TIME) * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE);
            JSONArray jsonArray = logObject.optJSONArray("urls");
            if (jsonArray != null) {
                this.activities = new String[jsonArray.length()];
                for (int i = 0; i < jsonArray.length(); i++) {
                    this.activities[i] = jsonArray.optString(i);
                }
                return;
            }
            this.activities = new String[0];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.position);
        dest.writeInt(this.activities.length);
        dest.writeStringArray(this.activities);
    }

    static {
        CREATOR = new C25171();
    }

    public void readExternal(ObjectInput input) {
        this.position = input.readLong();
        int count = input.readInt();
        this.activities = new String[count];
        for (int i = 0; i < count; i++) {
            this.activities[i] = (String) input.readObject();
        }
    }

    public void writeExternal(ObjectOutput output) {
        output.writeLong(this.position);
        output.writeInt(this.activities.length);
        for (String temp : this.activities) {
            output.writeObject(temp);
        }
    }
}
