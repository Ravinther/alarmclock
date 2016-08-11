package com.avg.toolkit.uid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.avg.toolkit.C0647c;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.p049e.C0970a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Properties;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

public class UUID implements C0647c {
    private static volatile String f3174b;
    private static volatile boolean f3175c;
    protected WeakReference f3176a;

    public UUID(Context context) {
        this.f3176a = new WeakReference(context);
    }

    public int getID() {
        return 19000;
    }

    public void onMessage(Bundle arguments) {
        Context context = (Context) this.f3176a.get();
        if (context != null) {
            String action = arguments.getString(ITKSvc.c_actionData);
            String pkg = arguments.getString(SharedIdReceiver.EXTRA_KEY_WHOAMI);
            if (arguments.getBoolean(SharedIdReceiver.EXTRA_IS_FROM_ALARM, false)) {
                m4508e(context);
            } else if (pkg != null && !context.getPackageName().equals(pkg) && action != null) {
                if (action.equals(SharedIdReceiver.ACTION_TAKE_ID)) {
                    m4501a(context, arguments.getString(SharedIdReceiver.EXTRA_KEY_MY_ID));
                } else if (action.equals(SharedIdReceiver.ACTION_SEND_YOUR_ID)) {
                    m4506c(context);
                } else {
                    m4502a(action);
                }
            }
        }
    }

    protected void m4502a(String action) {
    }

    public synchronized String getUUID() {
        String id;
        Context context = (Context) this.f3176a.get();
        id = f3174b;
        if (id == null && context != null) {
            id = m4499a(context);
            synchronized (this) {
                f3174b = id;
            }
        }
        return id;
    }

    public void m4500a() {
        Context context = (Context) this.f3176a.get();
        if (context != null) {
            f3175c = false;
            String key = m4499a(context);
            boolean isAlarmSet = m4494h(context);
            if (key == null && !isAlarmSet) {
                key = m4503b(context);
                if (key == null) {
                    m4492f(context);
                    m4488b(context, true);
                    return;
                }
                m4489c(key);
                m4487b(context, key);
            }
        }
    }

    public synchronized void m4504b() {
        boolean writeNewUUID = true;
        synchronized (this) {
            if (!(this.f3176a == null || this.f3176a.get() == null || f3175c)) {
                Context context = (Context) this.f3176a.get();
                f3175c = true;
                String uuid = m4507d(context);
                if ((f3174b == null || uuid == null || !uuid.equals(f3174b)) && uuid != null) {
                    writeNewUUID = false;
                }
                if (writeNewUUID) {
                    m4497k(null);
                } else if (uuid != null) {
                    m4485a(uuid, false);
                }
            }
        }
    }

    private void m4492f(Context context) {
        Intent intent = new Intent(SharedIdReceiver.ACTION_SEND_YOUR_ID);
        intent.putExtra(SharedIdReceiver.EXTRA_KEY_WHOAMI, context.getPackageName());
        intent.setFlags(8);
        context.sendBroadcast(intent);
    }

    private String m4493g(Context context) {
        return m4498l(context);
    }

    private void m4489c(String id) {
        m4485a(id, true);
    }

    private void m4485a(String id, boolean skipSaveToSettings) {
        Context context = (Context) this.f3176a.get();
        if (context != null) {
            Editor editor = context.getSharedPreferences("uuid.prefs", 0).edit();
            editor.putString("uuid.id", id);
            editor.commit();
            synchronized (this) {
                f3174b = id;
            }
            int perm = context.getPackageManager().checkPermission("android.permission.WRITE_SETTINGS", context.getPackageName());
            String settingsKey = m4503b(context);
            if (id.equals(settingsKey) || settingsKey != null) {
                if (!skipSaveToSettings && settingsKey == null && perm == 0) {
                    try {
                        System.putString(context.getContentResolver(), "droidsecurity.uniqueid", id);
                    } catch (Exception ex) {
                        C0970a.m4322a(ex);
                    }
                }
            } else if (!skipSaveToSettings) {
            }
        }
    }

    protected String m4499a(Context context) {
        return context.getSharedPreferences("uuid.prefs", 0).getString("uuid.id", null);
    }

    protected String m4503b(Context context) {
        String id = null;
        try {
            id = System.getString(context.getContentResolver(), "droidsecurity.uniqueid");
            if (m4505b(id)) {
                return id;
            }
            return null;
        } catch (Exception ex) {
            C0970a.m4322a(ex);
            return id;
        }
    }

    private boolean m4494h(Context context) {
        return context.getSharedPreferences("uuid.prefs", 0).getBoolean("uuid.is.alarm.set", false);
    }

    private void m4484a(Context context, boolean set) {
        Editor editor = context.getSharedPreferences("uuid.prefs", 0).edit();
        editor.putBoolean("uuid.is.alarm.set", set);
        editor.commit();
    }

    private void m4488b(Context context, boolean set) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent pi = m4495i(context);
        if (set) {
            alarmManager.set(0, System.currentTimeMillis() + 2500, pi);
        } else {
            alarmManager.cancel(pi);
        }
        m4484a(context, set);
    }

    private PendingIntent m4495i(Context context) {
        Intent sharedIdIntent = new Intent(context, SharedIdReceiver.class);
        sharedIdIntent.putExtra(SharedIdReceiver.EXTRA_KEY_WHOAMI, context.getPackageName());
        sharedIdIntent.putExtra(SharedIdReceiver.EXTRA_IS_FROM_ALARM, true);
        return PendingIntent.getBroadcast(context, 0, sharedIdIntent, 1073741824);
    }

    protected void m4506c(Context context) {
        try {
            if (f3174b != null) {
                String myID = m4499a(context);
                Intent bcIntent = new Intent(SharedIdReceiver.ACTION_TAKE_ID);
                bcIntent.putExtra(SharedIdReceiver.EXTRA_KEY_WHOAMI, context.getPackageName());
                bcIntent.putExtra(SharedIdReceiver.EXTRA_KEY_MY_ID, myID);
                context.sendBroadcast(bcIntent);
            }
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    private File m4496j(Context context) {
        boolean hasSDCard = (Environment.getExternalStorageState() == "mounted" && Environment.getExternalStorageState() == "mounted_ro") ? false : true;
        if (!hasSDCard) {
            return null;
        }
        File sdFile = new File(Environment.getExternalStorageDirectory(), "/.avg");
        if (sdFile.exists() && sdFile.isDirectory()) {
            return new File(sdFile, "/.avg");
        }
        return sdFile;
    }

    private String m4483a(Context context, File sdFile) {
        Throwable th;
        if (sdFile == null) {
            sdFile = m4496j(context);
        }
        String uuid = null;
        FileInputStream propertiesFileIn = null;
        try {
            if (sdFile.exists() && sdFile.canRead()) {
                Properties properties = new Properties();
                FileInputStream propertiesFileIn2 = new FileInputStream(sdFile);
                try {
                    properties.load(propertiesFileIn2);
                    propertiesFileIn2.close();
                    String[] crcAndUUID = m4491e(properties.getProperty("uuid.id"));
                    if (m4486a(crcAndUUID)) {
                        uuid = crcAndUUID[1];
                        propertiesFileIn = propertiesFileIn2;
                    } else {
                        uuid = null;
                        propertiesFileIn = propertiesFileIn2;
                    }
                } catch (Exception e) {
                    propertiesFileIn = propertiesFileIn2;
                    if (propertiesFileIn != null) {
                        try {
                            propertiesFileIn.close();
                        } catch (Exception e2) {
                            C0970a.m4322a(e2);
                        }
                    }
                    return uuid;
                } catch (Throwable th2) {
                    th = th2;
                    propertiesFileIn = propertiesFileIn2;
                    if (propertiesFileIn != null) {
                        try {
                            propertiesFileIn.close();
                        } catch (Exception e22) {
                            C0970a.m4322a(e22);
                        }
                    }
                    throw th;
                }
            }
            if (propertiesFileIn != null) {
                try {
                    propertiesFileIn.close();
                } catch (Exception e222) {
                    C0970a.m4322a(e222);
                }
            }
        } catch (Exception e3) {
            if (propertiesFileIn != null) {
                propertiesFileIn.close();
            }
            return uuid;
        } catch (Throwable th3) {
            th = th3;
            if (propertiesFileIn != null) {
                propertiesFileIn.close();
            }
            throw th;
        }
        return uuid;
    }

    protected String m4507d(Context context) {
        return m4483a(context, null);
    }

    private void m4487b(Context context, String id) {
        Throwable th;
        File sdFile = m4496j(context);
        boolean shouldWriteUUID = false;
        File sdDir = sdFile.getParentFile();
        if (!sdFile.exists() || ((sdDir == null || !sdDir.canWrite()) && sdDir != null)) {
            shouldWriteUUID = true;
        } else if (m4507d(context) == null) {
            shouldWriteUUID = true;
        }
        if (shouldWriteUUID) {
            FileOutputStream propertiesWriteStream = null;
            try {
                Properties properties = new Properties();
                properties.put("uuid.id", m4490d(id) + '#' + id);
                FileOutputStream propertiesWriteStream2 = new FileOutputStream(sdFile);
                try {
                    properties.store(propertiesWriteStream2, null);
                    propertiesWriteStream2.close();
                    if (propertiesWriteStream2 != null) {
                        try {
                            propertiesWriteStream2.close();
                        } catch (Exception e) {
                            C0970a.m4322a(e);
                        }
                    }
                } catch (Exception e2) {
                    propertiesWriteStream = propertiesWriteStream2;
                    if (propertiesWriteStream != null) {
                        try {
                            propertiesWriteStream.close();
                        } catch (Exception e3) {
                            C0970a.m4322a(e3);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    propertiesWriteStream = propertiesWriteStream2;
                    if (propertiesWriteStream != null) {
                        try {
                            propertiesWriteStream.close();
                        } catch (Exception e32) {
                            C0970a.m4322a(e32);
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                if (propertiesWriteStream != null) {
                    propertiesWriteStream.close();
                }
            } catch (Throwable th3) {
                th = th3;
                if (propertiesWriteStream != null) {
                    propertiesWriteStream.close();
                }
                throw th;
            }
        }
    }

    protected void m4508e(Context context) {
        m4497k(context);
    }

    private void m4497k(Context context) {
        boolean isCalledInternally = false;
        if (context == null) {
            isCalledInternally = true;
        }
        try {
            if (f3174b == null || isCalledInternally) {
                String uuid = isCalledInternally ? null : m4507d(context);
                if (uuid == null) {
                    uuid = m4493g(context);
                }
                m4485a(uuid, isCalledInternally);
                m4487b(context, uuid);
                if (!isCalledInternally) {
                    m4484a(context, false);
                }
            }
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    protected void m4501a(Context context, String myID) {
        try {
            if (f3174b == null && !TextUtils.isEmpty(myID) && m4505b(myID)) {
                m4488b(context, false);
                m4485a(myID, false);
                m4487b(context, myID);
                return;
            }
            C0970a.m4325b("either we already have a const id or intent was missing an ID or invalid ID");
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    private String m4498l(Context context) {
        return java.util.UUID.randomUUID().toString();
    }

    private String m4490d(String uuid) {
        if (uuid == null) {
            return null;
        }
        Checksum checksum = new CRC32();
        byte[] bytes = uuid.getBytes("ISO-8859-1");
        checksum.update(bytes, 0, bytes.length);
        return Long.toHexString(checksum.getValue());
    }

    private boolean m4486a(String[] crcAndUuid) {
        if (crcAndUuid == null) {
            return false;
        }
        boolean isValid;
        String crc32StrToCheck = m4490d(crcAndUuid[1]);
        if (crc32StrToCheck == null || !crc32StrToCheck.equals(crcAndUuid[0])) {
            isValid = false;
        } else {
            isValid = true;
        }
        if (!isValid) {
            return isValid;
        }
        if (crcAndUuid[1] == null || !m4505b(crcAndUuid[1])) {
            return false;
        }
        return true;
    }

    private String[] m4491e(String uuidFromSD) {
        if (TextUtils.isEmpty(uuidFromSD) || uuidFromSD.indexOf(35) <= 0) {
            return null;
        }
        return new String[]{uuidFromSD.substring(0, uuidFromSD.indexOf(35)), uuidFromSD.substring(uuidFromSD.indexOf(35) + 1)};
    }

    protected boolean m4505b(String uuid) {
        return uuid == null ? false : uuid.matches("[a-zA-Z0-9\\-]{2,270}");
    }

    public void onAlarm(Bundle arguments) {
    }

    public void onNewLicense(C1017a avgFeatures) {
    }

    public void onDestroy() {
        f3174b = null;
    }

    public void onStart(boolean firstTime) {
    }

    public void onDailyTask(C1017a avgFeatures) {
    }

    public void setComm(List commClients) {
    }
}
