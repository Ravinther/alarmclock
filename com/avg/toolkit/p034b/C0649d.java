package com.avg.toolkit.p034b;

import android.content.Context;
import android.os.Message;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.p034b.C0950a.C0949c;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.avg.toolkit.b.d */
public abstract class C0649d {
    public static final int JSON_CONF_KEY_EMPTY = -1;
    protected C1017a f1730a;
    public JSONObject jsonRequestFeatureParameters;
    public JSONObject jsonRequestParameters;
    public HashMap mCookies;
    public Object[] mParams;
    public File mResultTargetFile;

    public abstract boolean callFinished(Context context, Object obj);

    public abstract int getMessageId();

    public abstract C0949c getPriority();

    @Deprecated
    public abstract String getXmlRpcMethod();

    public abstract boolean handleMessage(Context context, Message message);

    public abstract boolean load(Context context);

    public abstract boolean prepare(Context context);

    public C0649d() {
        this.mParams = null;
        this.mCookies = null;
        this.f1730a = null;
        this.mResultTargetFile = null;
        this.jsonRequestParameters = null;
        this.jsonRequestFeatureParameters = null;
    }

    public boolean isAnonymous() {
        return false;
    }

    public void setAvgFeatures(C1017a avgFeatures) {
        this.f1730a = avgFeatures;
    }

    public String getProgressNotification() {
        return null;
    }

    public void resetData() {
        this.mParams = null;
        this.mCookies = null;
        this.jsonRequestParameters = new JSONObject();
        this.jsonRequestFeatureParameters = new JSONObject();
    }

    public void releaseData() {
        this.mParams = null;
        this.mCookies = null;
        this.jsonRequestParameters = null;
        this.jsonRequestFeatureParameters = null;
    }

    public void resetPreparedData() {
        releaseData();
    }

    public int getJsonConfKey() {
        return JSON_CONF_KEY_EMPTY;
    }

    public boolean prepareJson(Context context, JSONArray setParameters) {
        return true;
    }

    public void callFinishedNoChange(Context context) {
    }

    public boolean useDailyRun() {
        return false;
    }

    public boolean handleDailyRun(Context context) {
        return false;
    }
}
