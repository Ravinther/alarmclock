package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.plus.PlusShare;
import java.io.Externalizable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class VideoAd extends CachedAd implements Parcelable, Externalizable {
    public static final Creator CREATOR;
    static final String VIDEO_FILE_ID = "video.dat";
    static final long serialVersionUID = 2679125946930815832L;
    ArrayList activities;
    ArrayList buttons;
    String[] cacheComplete;
    String[] cacheFailed;
    String cacheMissURL;
    DTOCachedVideo cachedVideoDto;
    long closeDelayMillis;
    long contentLength;
    long duration;
    String[] endActivity;
    String endOverlayURL;
    String onCompletionUrl;
    boolean reloadNonEndOverlayOnRestart;
    boolean showControls;
    boolean showCountdown;
    String[] startActivity;
    boolean stayInPlayer;
    boolean usingInternalStorage;
    String[] videoError;
    private String videoFileId;
    String webOverlayURL;

    /* renamed from: com.millennialmedia.android.VideoAd.1 */
    static class C25151 implements Creator {
        C25151() {
        }

        public VideoAd createFromParcel(Parcel in) {
            return new VideoAd(in);
        }

        public VideoAd[] newArray(int size) {
            return new VideoAd[size];
        }
    }

    private static class VideoFilenameFilter implements FilenameFilter {
        private WeakReference videoAdRef;

        public VideoFilenameFilter(VideoAd videoAd) {
            this.videoAdRef = new WeakReference(videoAd);
        }

        public boolean accept(File dir, String filename) {
            VideoAd videoAd = (VideoAd) this.videoAdRef.get();
            if (videoAd == null) {
                return false;
            }
            String id = videoAd.getId();
            if (id == null) {
                return false;
            }
            return filename.startsWith(id);
        }
    }

    private static class VideoIterator extends Iterator {
        private WeakReference contextRef;
        boolean hasSharedVideoFile;
        private WeakReference videoAdRef;

        public VideoIterator(Context context, VideoAd videoAd) {
            this.hasSharedVideoFile = false;
            this.videoAdRef = new WeakReference(videoAd);
            this.contextRef = new WeakReference(context);
        }

        boolean callback(CachedAd cachedAd) {
            if (cachedAd != null && (cachedAd instanceof VideoAd)) {
                VideoAd videoAd = (VideoAd) cachedAd;
                VideoAd requestingVideoAd = (VideoAd) this.videoAdRef.get();
                if (requestingVideoAd != null && videoAd.videoFileId.equals(requestingVideoAd.videoFileId)) {
                    this.hasSharedVideoFile = true;
                }
            }
            return super.callback(cachedAd);
        }

        void done() {
            if (!this.hasSharedVideoFile) {
                Context context = (Context) this.contextRef.get();
                if (context != null) {
                    deleteVideoFile(context);
                }
            }
            super.done();
        }

        void deleteVideoFile(Context context) {
            VideoAd requestingVideoAd = (VideoAd) this.videoAdRef.get();
            if (requestingVideoAd != null && AdCache.deleteFile(context, requestingVideoAd.videoFileId + VideoAd.VIDEO_FILE_ID)) {
                Log.m9724v("VideoAd video file %s was deleted.", requestingVideoAd.videoFileId);
            }
        }
    }

    public VideoAd() {
        this.buttons = new ArrayList();
        this.activities = new ArrayList();
    }

    VideoAd(Parcel in) {
        super(in);
        this.buttons = new ArrayList();
        this.activities = new ArrayList();
        try {
            this.startActivity = new String[in.readInt()];
            in.readStringArray(this.startActivity);
            this.endActivity = new String[in.readInt()];
            in.readStringArray(this.endActivity);
            boolean[] boolArray = new boolean[5];
            in.readBooleanArray(boolArray);
            this.showControls = boolArray[0];
            this.stayInPlayer = boolArray[1];
            this.showCountdown = boolArray[2];
            this.reloadNonEndOverlayOnRestart = boolArray[3];
            this.usingInternalStorage = boolArray[4];
            this.onCompletionUrl = in.readString();
            this.webOverlayURL = in.readString();
            this.endOverlayURL = in.readString();
            this.cacheMissURL = in.readString();
            this.videoFileId = in.readString();
            this.duration = in.readLong();
            this.contentLength = in.readLong();
            this.closeDelayMillis = in.readLong();
            this.buttons = in.readArrayList(VideoImage.class.getClassLoader());
            this.activities = in.readArrayList(VideoLogEvent.class.getClassLoader());
            this.cacheComplete = new String[in.readInt()];
            in.readStringArray(this.cacheComplete);
            this.cacheFailed = new String[in.readInt()];
            in.readStringArray(this.cacheFailed);
            this.videoError = new String[in.readInt()];
            in.readStringArray(this.videoError);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    VideoAd(String jsonString) {
        this.buttons = new ArrayList();
        this.activities = new ArrayList();
        if (jsonString != null) {
            JSONObject jsonAdObject = null;
            try {
                jsonAdObject = new JSONObject(jsonString);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jsonAdObject != null) {
                JSONObject videoObject = jsonAdObject.optJSONObject("video");
                if (videoObject != null) {
                    deserializeFromObj(videoObject);
                }
            }
        }
    }

    protected void deserializeFromObj(JSONObject videoObject) {
        int i;
        super.deserializeFromObj(videoObject);
        JSONArray jsonArray = videoObject.optJSONArray("startActivity");
        this.webOverlayURL = videoObject.optString("overlayURL", null);
        this.endOverlayURL = videoObject.optString("endURL", null);
        this.cacheMissURL = videoObject.optString("cacheMissURL", null);
        this.videoFileId = videoObject.optString("videoFileId", null);
        if (jsonArray != null) {
            this.startActivity = new String[jsonArray.length()];
            for (i = 0; i < jsonArray.length(); i++) {
                this.startActivity[i] = jsonArray.optString(i);
            }
        } else {
            this.startActivity = new String[0];
        }
        jsonArray = videoObject.optJSONArray("endActivity");
        if (jsonArray != null) {
            this.endActivity = new String[jsonArray.length()];
            for (i = 0; i < jsonArray.length(); i++) {
                this.endActivity[i] = jsonArray.optString(i);
            }
        } else {
            this.endActivity = new String[0];
        }
        jsonArray = videoObject.optJSONArray("cacheComplete");
        if (jsonArray != null) {
            this.cacheComplete = new String[jsonArray.length()];
            for (i = 0; i < jsonArray.length(); i++) {
                this.cacheComplete[i] = jsonArray.optString(i);
            }
        } else {
            this.cacheComplete = new String[0];
        }
        jsonArray = videoObject.optJSONArray("cacheFailed");
        if (jsonArray != null) {
            this.cacheFailed = new String[jsonArray.length()];
            for (i = 0; i < jsonArray.length(); i++) {
                this.cacheFailed[i] = jsonArray.optString(i);
            }
        } else {
            this.cacheFailed = new String[0];
        }
        jsonArray = videoObject.optJSONArray("videoError");
        if (jsonArray != null) {
            this.videoError = new String[jsonArray.length()];
            for (i = 0; i < jsonArray.length(); i++) {
                this.videoError[i] = jsonArray.optString(i);
            }
        } else {
            this.videoError = new String[0];
        }
        this.showControls = videoObject.optBoolean("showVideoPlayerControls");
        this.showCountdown = videoObject.optBoolean("showCountdownHUD");
        this.reloadNonEndOverlayOnRestart = videoObject.optBoolean("reloadOverlayOnRestart");
        JSONObject jsonObject = videoObject.optJSONObject("onCompletion");
        if (jsonObject != null) {
            this.onCompletionUrl = jsonObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL, null);
            this.stayInPlayer = jsonObject.optBoolean("stayInPlayer");
        }
        this.duration = (long) (videoObject.optDouble("duration", 0.0d) * 1000.0d);
        this.contentLength = videoObject.optLong("contentLength");
        this.closeDelayMillis = videoObject.optLong("closeAfterDelay");
        jsonArray = videoObject.optJSONArray("buttons");
        if (jsonArray != null) {
            for (i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.optJSONObject(i);
                if (jsonObject != null) {
                    this.buttons.add(new VideoImage(jsonObject));
                }
            }
        }
        jsonArray = videoObject.optJSONArray("log");
        if (jsonArray != null) {
            for (i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.optJSONObject(i);
                if (jsonObject != null) {
                    this.activities.add(new VideoLogEvent(jsonObject));
                }
            }
        }
    }

    int getType() {
        return 1;
    }

    String getTypeString() {
        return "Video";
    }

    boolean saveAssets(Context context) {
        return true;
    }

    static boolean downloadVideoFile(Context context, String contentUrl, String videoFileId) {
        File dir = AdCache.getCacheDirectory(context);
        if (dir == null || !dir.isDirectory()) {
            return false;
        }
        Log.m9724v("Downloading (" + videoFileId + VIDEO_FILE_ID + ") content to %s", dir);
        boolean success = AdCache.downloadComponent(contentUrl, videoFileId + VIDEO_FILE_ID, dir, context);
        Log.m9724v("Caching completed successfully (" + videoFileId + VIDEO_FILE_ID + ")? %b", Boolean.valueOf(success));
        return success;
    }

    static boolean hasVideoFile(Context context, String videoFileId) {
        return AdCache.hasDownloadFile(context, videoFileId + VIDEO_FILE_ID);
    }

    static Uri getVideoUri(Context context, String videoFileId) {
        return Uri.fromFile(AdCache.getDownloadFile(context, videoFileId + VIDEO_FILE_ID));
    }

    boolean download(Context context) {
        File dir = AdCache.getCacheDirectory(context);
        if (dir == null || !dir.isDirectory()) {
            return false;
        }
        this.usingInternalStorage = AdCache.isInternalDir(context, dir);
        Log.m9724v("Downloading content to %s", dir);
        boolean success = AdCache.downloadComponent(this.contentUrl, this.videoFileId + VIDEO_FILE_ID, dir, context);
        if (success) {
            for (int i = 0; i < this.buttons.size(); i++) {
                VideoImage button = (VideoImage) this.buttons.get(i);
                success = AdCache.downloadComponent(button.imageUrl, getId() + button.getImageName(), dir, context);
                if (!success) {
                    break;
                }
            }
        }
        if (!success) {
            if (this.downloadAllOrNothing) {
                delete(context);
            }
            HttpGetRequest.log(this.cacheFailed);
        } else if (success) {
            if (this.acid != null && this.acid.length() > 0) {
                AdCache.cachedVideoWasAdded(context, this.acid);
            }
            HttpGetRequest.log(this.cacheComplete);
        }
        Log.m9724v("Caching completed successfully? %b", Boolean.valueOf(success));
        return success;
    }

    void delete(Context context) {
        super.delete(context);
        handleSharedVideoFile(context);
        AdCache.cachedVideoWasRemoved(context, this.acid);
        Log.m9724v("Ad %s was deleted.", getId());
    }

    private void handleSharedVideoFile(Context context) {
        AdCache.iterateCachedAds(context, 2, new VideoIterator(context, this));
    }

    boolean isOnDisk(Context context) {
        boolean existsInFilesystem = false;
        File adDir = AdCache.getCacheDirectory(context);
        if (adDir == null || !adDir.exists()) {
            return false;
        }
        String[] list = adDir.list(new VideoFilenameFilter(this));
        if (list != null && list.length >= this.buttons.size() + 1) {
            existsInFilesystem = true;
        }
        if (!existsInFilesystem) {
            return existsInFilesystem;
        }
        if (!new File(adDir, this.videoFileId + VIDEO_FILE_ID).exists()) {
            return false;
        }
        Iterator i$ = this.buttons.iterator();
        while (i$.hasNext()) {
            if (!new File(adDir, getId() + ((VideoImage) i$.next()).getImageName()).exists()) {
                return false;
            }
        }
        return existsInFilesystem;
    }

    boolean canShow(Context context, MMAdImpl adImpl, boolean checkDeferredViewStart) {
        if (checkDeferredViewStart) {
            if (!isExpired() && isOnDisk(context) && HandShake.sharedHandShake(context).canDisplayCachedAd(adImpl.adType, this.deferredViewStart)) {
                return true;
            }
            return false;
        } else if (isExpired() || !isOnDisk(context)) {
            return false;
        } else {
            return true;
        }
    }

    void show(Context context, long adImplInternalId) {
        IntentUtils.startCachedVideoPlayerActivity(context, getVideoExtrasIntent(context, adImplInternalId));
    }

    Intent getVideoExtrasIntent(Context context, long adImplInternalId) {
        Intent intent = new Intent();
        intent.putExtra("videoId", getId());
        if (adImplInternalId != -4) {
            intent.putExtra("internalId", adImplInternalId);
        }
        intent.setData(Uri.parse(AdCache.getCacheDirectory(context).getAbsolutePath() + File.separator + this.videoFileId + VIDEO_FILE_ID));
        return intent;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(this.startActivity.length);
        dest.writeStringArray(this.startActivity);
        dest.writeInt(this.endActivity.length);
        dest.writeStringArray(this.endActivity);
        dest.writeBooleanArray(new boolean[]{this.showControls, this.stayInPlayer, this.showCountdown, this.reloadNonEndOverlayOnRestart, this.usingInternalStorage});
        dest.writeString(this.onCompletionUrl);
        dest.writeString(this.endOverlayURL);
        dest.writeString(this.webOverlayURL);
        dest.writeString(this.cacheMissURL);
        dest.writeString(this.videoFileId);
        dest.writeLong(this.duration);
        dest.writeLong(this.contentLength);
        dest.writeLong(this.closeDelayMillis);
        dest.writeList(this.buttons);
        dest.writeList(this.activities);
        dest.writeInt(this.cacheComplete.length);
        dest.writeStringArray(this.cacheComplete);
        dest.writeInt(this.cacheFailed.length);
        dest.writeStringArray(this.cacheFailed);
        dest.writeInt(this.videoError.length);
        dest.writeStringArray(this.videoError);
    }

    static {
        CREATOR = new C25151();
    }

    public void readExternal(ObjectInput input) {
        int i;
        super.readExternal(input);
        this.showControls = input.readBoolean();
        this.onCompletionUrl = (String) input.readObject();
        this.webOverlayURL = (String) input.readObject();
        this.endOverlayURL = (String) input.readObject();
        this.cacheMissURL = (String) input.readObject();
        this.videoFileId = (String) input.readObject();
        this.stayInPlayer = input.readBoolean();
        this.showCountdown = input.readBoolean();
        this.reloadNonEndOverlayOnRestart = input.readBoolean();
        int count = input.readInt();
        this.startActivity = new String[count];
        for (i = 0; i < count; i++) {
            this.startActivity[i] = (String) input.readObject();
        }
        count = input.readInt();
        this.endActivity = new String[count];
        for (i = 0; i < count; i++) {
            this.endActivity[i] = (String) input.readObject();
        }
        this.duration = input.readLong();
        this.usingInternalStorage = input.readBoolean();
        this.contentLength = input.readLong();
        this.closeDelayMillis = input.readLong();
        count = input.readInt();
        this.cacheComplete = new String[count];
        for (i = 0; i < count; i++) {
            this.cacheComplete[i] = (String) input.readObject();
        }
        count = input.readInt();
        this.cacheFailed = new String[count];
        for (i = 0; i < count; i++) {
            this.cacheFailed[i] = (String) input.readObject();
        }
        count = input.readInt();
        this.videoError = new String[count];
        for (i = 0; i < count; i++) {
            this.videoError[i] = (String) input.readObject();
        }
        this.buttons.clear();
        count = input.readInt();
        for (i = 0; i < count; i++) {
            this.buttons.add((VideoImage) input.readObject());
        }
        this.activities.clear();
        count = input.readInt();
        for (i = 0; i < count; i++) {
            this.activities.add((VideoLogEvent) input.readObject());
        }
    }

    public void writeExternal(ObjectOutput output) {
        super.writeExternal(output);
        output.writeBoolean(this.showControls);
        output.writeObject(this.onCompletionUrl);
        output.writeObject(this.webOverlayURL);
        output.writeObject(this.endOverlayURL);
        output.writeObject(this.cacheMissURL);
        output.writeObject(this.videoFileId);
        output.writeBoolean(this.stayInPlayer);
        output.writeBoolean(this.showCountdown);
        output.writeBoolean(this.reloadNonEndOverlayOnRestart);
        output.writeInt(this.startActivity.length);
        for (String sa : this.startActivity) {
            output.writeObject(sa);
        }
        output.writeInt(this.endActivity.length);
        for (String ea : this.endActivity) {
            output.writeObject(ea);
        }
        output.writeLong(this.duration);
        output.writeBoolean(this.usingInternalStorage);
        output.writeLong(this.contentLength);
        output.writeLong(this.closeDelayMillis);
        output.writeInt(this.cacheComplete.length);
        for (String cc : this.cacheComplete) {
            output.writeObject(cc);
        }
        output.writeInt(this.cacheFailed.length);
        for (String cf : this.cacheFailed) {
            output.writeObject(cf);
        }
        output.writeInt(this.videoError.length);
        for (String ve : this.videoError) {
            output.writeObject(ve);
        }
        output.writeInt(this.buttons.size());
        Iterator i$ = this.buttons.iterator();
        while (i$.hasNext()) {
            output.writeObject((VideoImage) i$.next());
        }
        output.writeInt(this.activities.size());
        i$ = this.activities.iterator();
        while (i$.hasNext()) {
            output.writeObject((VideoLogEvent) i$.next());
        }
    }

    void logBeginEvent() {
        if (this.startActivity != null) {
            Log.m9711d("Cached video begin event logged");
            for (String logEvent : this.startActivity) {
                Event.logEvent(logEvent);
            }
        }
    }

    void logEndEvent() {
        if (this.endActivity != null) {
            Log.m9711d("Cached video end event logged");
            for (String logEvent : this.endActivity) {
                Event.logEvent(logEvent);
            }
        }
    }

    static void playAd(Context context, String id, RedirectionListenerImpl listener) {
        if (id != null) {
            VideoAd videoAd = (VideoAd) AdCache.load(context, id);
            if (videoAd == null || !videoAd.canShow(context, null, false)) {
                Log.m9724v("mmvideo: Ad %s cannot be shown at this time.", id);
                return;
            }
            listener.updateLastVideoViewedTime();
            Log.m9724v("mmvideo: attempting to play video %s", id);
            videoAd.show(context, listener.creatorAdImplInternalId);
            listener.startingVideo();
        }
    }

    void setDtoCachedVideo(DTOCachedVideo dto) {
        this.cachedVideoDto = dto;
    }

    boolean hasEndCard() {
        Iterator i$ = this.buttons.iterator();
        while (i$.hasNext()) {
            if (((VideoImage) i$.next()).isLeaveBehind) {
                return true;
            }
        }
        return false;
    }
}
