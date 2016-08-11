package com.avg.toolkit;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.avg.p046a.C0899a.C0898a;
import com.avg.toolkit.ads.C0931c;
import com.avg.toolkit.crashReport.CrashReport;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;
import com.avg.toolkit.gcm.C0985a;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.license.C1019b;
import com.avg.toolkit.marketing.C1027a;
import com.avg.toolkit.p047a.C0905a;
import com.avg.toolkit.p048d.C0969a;
import com.avg.toolkit.p049e.C0970a;
import com.avg.toolkit.recurringTasks.C1031b;
import com.avg.toolkit.uid.UUID;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.location.LocationStatusCodes;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;

@SuppressLint({"Registered"})
public class TKService extends ITKSvc {
    protected static final int ACTION_BAD_ARGS = -1;
    protected C1031b mDailyTask;
    protected boolean mIsServiceInitialized;

    public TKService() {
        this.mIsServiceInitialized = false;
    }

    protected final Callable getResources(int resourceInt, String resourceDir) {
        Callable result = null;
        try {
            result = C0908a.m4169a(resourceDir);
        } catch (NotFoundException e) {
        }
        if (result == null) {
            return C0908a.m4168a(this, resourceInt);
        }
        return result;
    }

    protected final Properties loadProperties() {
        Callable propertiesOpener = getResources(C0898a.conf, "res/raw/conf.properties");
        InputStream is = null;
        Properties properties = new Properties();
        try {
            is = (InputStream) propertiesOpener.call();
            if (is != null) {
                properties.load(is);
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                    }
                }
                return properties;
            }
            throw new IllegalStateException("propertiesOpener returned null InputStream!");
        } catch (Exception e2) {
            throw new Error(e2);
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e3) {
                }
            }
        }
    }

    protected void onHandlerMessage(Message msg) {
        if (m2992a(msg)) {
            Bundle arguments = msg.obj;
            int action = arguments.getInt(ITKSvc.c_action, ACTION_BAD_ARGS);
            if (!this.mEnabled && !m2991a(action)) {
                return;
            }
            if (action == LocationStatusCodes.GEOFENCE_NOT_AVAILABLE) {
                onMessage(arguments);
            } else {
                onFeaturesMesssage(arguments, action);
            }
        }
    }

    private boolean m2991a(int action) {
        switch (action) {
            case ACTION_BAD_ARGS /*-1*/:
            case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
            case GamesStatusCodes.STATUS_REAL_TIME_CONNECTION_FAILED /*7000*/:
            case 19000:
                return true;
            default:
                return isFeatureNotCheckingTOS(action);
        }
    }

    protected boolean isFeatureNotCheckingTOS(int action) {
        return false;
    }

    private boolean m2992a(Message msg) {
        if (msg == null) {
            return true;
        }
        try {
            Bundle arguments = (Bundle) msg.obj;
            if (arguments == null) {
                return false;
            }
            int action = arguments.getInt(ITKSvc.c_action, ACTION_BAD_ARGS);
            return true;
        } catch (Exception e) {
            C0970a.m4322a(e);
            return false;
        }
    }

    protected void onCreateHandler() {
        this.mUUID = new UUID(this);
        this.mUUID.m4500a();
        addTKFeature(this.mUUID);
        Properties properties = loadProperties();
        C0985a gcmManager = new C0985a(getApplicationContext());
        addTKFeature(gcmManager);
        this.mAvgLicenseManager = new C1019b(this, properties, gcmManager);
        addTKFeature(this.mAvgLicenseManager);
        this.mAvgLicenseManager.m4439b();
        this.mEnabled = this.mAvgLicenseManager.m4440c();
        initCommunication(properties);
        addTKFeature(new CrashReport());
        this.mServiceHandler = createHandler();
    }

    protected TKSvcHandler createHandler() {
        HandlerThread handlerThread = new HandlerThread("ITKSvc");
        handlerThread.start();
        this.mServiceLooper = handlerThread.getLooper();
        return new TKSvcHandler(this, this.mServiceLooper);
    }

    protected void onCreateThreaded() {
        C1017a avgFeatures = C1019b.m4431a();
        Properties properties = loadProperties();
        addTKFeature(new C0905a(this, avgFeatures, properties, this.mUUID));
        addTKFeature(new C0931c(this));
        addTKFeature(new C1027a(this, avgFeatures));
        addTKFeature(new GoogleAnalyticsWrapper(this, avgFeatures, properties));
        addExtraTKFeatures(avgFeatures, properties);
        C0969a.m4317a((Service) this);
        addCommClients();
        if (this.mEnabled) {
            onStart(false);
        }
        this.mIsServiceInitialized = true;
    }

    protected void addExtraTKFeatures(C1017a avgFeatures, Properties properties) {
    }

    public void onDailyTasks(Bundle arguments) {
        if (this.mDailyTask.m4480a(getApplicationContext(), arguments)) {
            boolean b = this.mAvgLicenseManager.m4439b();
            C1017a avgFeatures = C1019b.m4431a();
            for (int i = 0; i < this.mTKFeatures.size(); i++) {
                ((C0647c) this.mTKFeatures.valueAt(i)).onDailyTask(avgFeatures);
            }
            this.mDailyTask.m4479a(this);
        }
    }

    public void onMessage(Bundle arguments) {
        switch (arguments.getInt(ITKSvc.c_actionSubAction, ACTION_BAD_ARGS)) {
            case LocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES /*1001*/:
                if (!this.mIsServiceInitialized) {
                    onCreateThreaded();
                }
            case LocationStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS /*1002*/:
                if (!this.mEnabled) {
                    onStart(true);
                }
            case ITKSvc.ACTION_ALARM /*1003*/:
                if (this.mEnabled) {
                    onAlarm(arguments);
                }
            case ITKSvc.ACTION_NOTIFY_ABOUT_NEW_LICENSE /*1004*/:
                m2990a(arguments);
            default:
                C0970a.m4321a();
        }
    }

    public void onStart(boolean firstTime) {
        this.mEnabled = true;
        if (firstTime) {
            this.mAvgLicenseManager.m4441d();
        }
        for (int i = 0; i < this.mTKFeatures.size(); i++) {
            ((C0647c) this.mTKFeatures.valueAt(i)).onStart(firstTime);
        }
        this.mDailyTask = new C1031b(getApplicationContext(), "SVCDT", 86400000, true, false, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, false);
    }

    private void m2990a(Bundle arguments) {
        boolean licenseChanged = ((Boolean) arguments.get("result")).booleanValue();
        if (arguments.containsKey(ITKSvc.c_actionHandler)) {
            try {
                Messenger messenger = (Messenger) arguments.get(ITKSvc.c_actionHandler);
                if (messenger != null) {
                    Message msg = Message.obtain();
                    msg.obj = Boolean.valueOf(licenseChanged);
                    messenger.send(msg);
                }
            } catch (RemoteException e) {
                C0970a.m4325b("RemoteException: " + e.getLocalizedMessage());
            } catch (Exception e2) {
                C0970a.m4322a(e2);
            }
        }
        if (licenseChanged) {
            C1017a avgFeatures = C1019b.m4431a();
            for (int i = 0; i < this.mTKFeatures.size(); i++) {
                ((C0647c) this.mTKFeatures.valueAt(i)).onNewLicense(avgFeatures);
            }
        }
    }

    public void onDailyTask(C1017a avgFeatures) {
    }

    public void onNewLicense(C1017a avgFeatures) {
    }

    public void setComm(List commClients) {
    }
}
