package com.avg.toolkit;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import com.avg.toolkit.license.C1019b;
import com.avg.toolkit.p034b.C0952b;
import com.avg.toolkit.p049e.C0970a;
import com.avg.toolkit.uid.UUID;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public abstract class ITKSvc extends Service implements C0647c {
    public static final int ACTION_ALARM = 1003;
    protected static final int ACTION_BAD_ARGS = -1;
    public static final int ACTION_ENABLE = 1002;
    protected static final int ACTION_IGNORE = -2;
    public static final int ACTION_NOTIFY_ABOUT_NEW_LICENSE = 1004;
    protected static final int ACTION_ONCREATE_THD = 1001;
    public static final String CODEREVISION = "0";
    public static final int FEATURE_ID = 1000;
    public static final String TK_SERVICE_ACTION = "com.avg.toolkit.TKS_ACTION";
    public static final String c_action = "__SAC";
    public static final String c_actionData = "__SAD";
    public static final String c_actionHandler = "__SAH";
    public static final String c_actionSubAction = "__SAC2";
    protected C1019b mAvgLicenseManager;
    protected final IBinder mBinder;
    protected C0952b mCommunicationManager;
    protected boolean mEnabled;
    protected volatile Handler mServiceHandler;
    protected volatile Looper mServiceLooper;
    protected SparseArray mTKFeatures;
    protected UUID mUUID;

    protected abstract void onCreateHandler();

    protected abstract void onCreateThreaded();

    public abstract void onDailyTasks(Bundle bundle);

    protected IBinder getBinder() {
        return new C0962b(this);
    }

    public ITKSvc() {
        this.mBinder = getBinder();
        if (!(this.mBinder instanceof C0961d)) {
            throw new IllegalStateException("mBinder instance is not implementing ITKFeatureGetter interface!");
        }
    }

    public int getID() {
        return FEATURE_ID;
    }

    public final void onCreate() {
        super.onCreate();
        this.mEnabled = false;
        this.mTKFeatures = new SparseArray();
        onCreateHandler();
        Message msg = this.mServiceHandler.obtainMessage();
        Bundle arguments = new Bundle();
        arguments.putInt(c_action, FEATURE_ID);
        arguments.putInt(c_actionSubAction, ACTION_ONCREATE_THD);
        msg.obj = arguments;
        this.mServiceHandler.sendMessage(msg);
    }

    public IBinder onBind(Intent intent) {
        DoEmptyMessage(this);
        return this.mBinder;
    }

    public void onAlarm(Bundle arguments) {
        if (this.mEnabled) {
            int code = arguments.getInt("alarm_code");
            if (code == FEATURE_ID) {
                onDailyTasks(arguments);
                return;
            }
            C0647c feature = (C0647c) this.mTKFeatures.get(code);
            if (feature != null) {
                feature.onAlarm(arguments);
            } else {
                C0970a.m4325b("alarm was called with non existing feature id: " + code);
            }
        }
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            Message msg = this.mServiceHandler.obtainMessage();
            msg.arg1 = startId;
            msg.obj = intent.getExtras();
            this.mServiceHandler.sendMessage(msg);
        }
        return 1;
    }

    public void onDestroy() {
        int i = 0;
        while (i < this.mTKFeatures.size()) {
            try {
                ((C0647c) this.mTKFeatures.valueAt(i)).onDestroy();
                i++;
            } catch (Exception e) {
                C0970a.m4322a(e);
            }
        }
        this.mTKFeatures.clear();
        try {
            if (this.mServiceLooper != null) {
                this.mServiceLooper.quit();
                this.mServiceLooper = null;
            }
        } catch (Exception e2) {
            C0970a.m4322a(e2);
        }
        super.onDestroy();
    }

    protected boolean isEnabled() {
        return this.mEnabled;
    }

    protected void addTKFeature(C0647c feature) {
        int featureId = feature.getID();
        if (this.mTKFeatures.get(featureId, null) == null) {
            this.mTKFeatures.append(featureId, feature);
        } else {
            C0970a.m4321a();
        }
    }

    public static void Do(Context context, int feature, int action, Bundle bundle) {
        Intent serviceIntent = new Intent(TK_SERVICE_ACTION);
        if (bundle != null) {
            serviceIntent.putExtras(bundle);
        }
        serviceIntent.setPackage(context.getPackageName());
        serviceIntent.putExtra(c_action, feature);
        serviceIntent.putExtra(c_actionSubAction, action);
        context.startService(serviceIntent);
    }

    public static void DoEmptyMessage(Context context) {
        Intent serviceIntent = new Intent(TK_SERVICE_ACTION);
        serviceIntent.setPackage(context.getPackageName());
        context.startService(serviceIntent);
    }

    public void onFeaturesMesssage(Bundle arguments, int action) {
        if (this.mTKFeatures.get(action) != null) {
            ((C0647c) this.mTKFeatures.get(action)).onMessage(arguments);
        }
    }

    protected void initCommunication(Properties properties) {
        this.mCommunicationManager = new C0952b(this, C1019b.m4431a(), this.mUUID, properties);
        addTKFeature(this.mCommunicationManager);
    }

    protected void addCommClients() {
        List commClients = new ArrayList(this.mTKFeatures.size());
        for (int i = 0; i < this.mTKFeatures.size(); i++) {
            ((C0647c) this.mTKFeatures.valueAt(i)).setComm(commClients);
        }
        this.mCommunicationManager.m4283a(commClients);
    }

    public C0647c getFeature(int featureId) {
        return (C0647c) this.mTKFeatures.get(featureId);
    }
}
