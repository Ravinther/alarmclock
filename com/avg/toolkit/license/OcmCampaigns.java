package com.avg.toolkit.license;

import android.content.Context;
import android.content.SharedPreferences;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.p049e.C0970a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Set;

public class OcmCampaigns extends HashMap {
    private static String FILENAME = null;
    public static final String LAST_SAVED_CAMPAIGN = "LAST_SAVED_CAMPAIGN";
    public static final String OCM_CAMPAIGN = "OCM_CAMPAIGN";
    public static final String OCM_KILL_SWITCH = "OCM_KILL_SWITCH";
    private static final long serialVersionUID = 3538644102726462331L;
    private static final Object syncObj;
    public HashMap analyticsArray;
    public HashMap analyticsTechErrorsMap;
    public long globalInactiveDayLastSavedTimestamp;
    public Integer globalInactiveDays;
    public Integer globalInactiveDaysOcmId;
    public String ocmId;

    public OcmCampaigns() {
        this.analyticsArray = new HashMap();
        this.analyticsTechErrorsMap = new HashMap();
        this.ocmId = ITKSvc.CODEREVISION;
        this.globalInactiveDays = Integer.valueOf(0);
        this.globalInactiveDaysOcmId = Integer.valueOf(0);
        this.globalInactiveDayLastSavedTimestamp = 0;
    }

    static {
        FILENAME = "campaigns.ser";
        syncObj = new Object();
    }

    public static boolean writeCampaignsToStorage(Context context, OcmCampaigns campaigns, boolean shouldUpdateTimeStamp) {
        Throwable th;
        boolean z = false;
        synchronized (syncObj) {
            FileOutputStream fileOut = null;
            ObjectOutputStream out = null;
            try {
                fileOut = context.openFileOutput(FILENAME, 0);
                ObjectOutputStream out2 = new ObjectOutputStream(fileOut);
                try {
                    out2.writeObject(campaigns);
                    if (out2 != null) {
                        try {
                            out2.close();
                        } catch (Exception e) {
                            C0970a.m4322a(e);
                        } catch (Throwable th2) {
                            th = th2;
                            out = out2;
                            throw th;
                        }
                    }
                    if (fileOut != null) {
                        fileOut.close();
                    }
                    if (shouldUpdateTimeStamp) {
                        saveTimeStamp(context);
                    }
                    z = true;
                    out = out2;
                } catch (IOException e2) {
                    out = out2;
                    if (out != null) {
                        try {
                            out.close();
                        } catch (Exception e3) {
                            C0970a.m4322a(e3);
                            return z;
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    }
                    if (fileOut != null) {
                        fileOut.close();
                    }
                    return z;
                } catch (Throwable th4) {
                    th = th4;
                    out = out2;
                    if (out != null) {
                        try {
                            out.close();
                        } catch (Exception e32) {
                            C0970a.m4322a(e32);
                            throw th;
                        }
                    }
                    if (fileOut != null) {
                        fileOut.close();
                    }
                    throw th;
                }
            } catch (IOException e4) {
                if (out != null) {
                    out.close();
                }
                if (fileOut != null) {
                    fileOut.close();
                }
                return z;
            } catch (Throwable th5) {
                th = th5;
                if (out != null) {
                    out.close();
                }
                if (fileOut != null) {
                    fileOut.close();
                }
                throw th;
            }
            return z;
        }
    }

    public static OcmCampaigns readCampaignsFromStorage(Context context) {
        Throwable th;
        OcmCampaigns campaigns;
        synchronized (syncObj) {
            OcmCampaigns campaigns2 = null;
            FileInputStream fileIn = null;
            ObjectInputStream in = null;
            try {
                if (new File(context.getFilesDir(), FILENAME).exists()) {
                    try {
                        fileIn = context.openFileInput(FILENAME);
                        ObjectInputStream in2 = new ObjectInputStream(fileIn);
                        try {
                            campaigns2 = (OcmCampaigns) in2.readObject();
                            if (in2 != null) {
                                try {
                                    in2.close();
                                } catch (Exception e) {
                                    C0970a.m4322a(e);
                                    in = in2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    in = in2;
                                    throw th;
                                }
                            }
                            if (fileIn != null) {
                                fileIn.close();
                            }
                            in = in2;
                        } catch (Exception e2) {
                            in = in2;
                            try {
                                campaigns = new OcmCampaigns();
                                if (in != null) {
                                    try {
                                        in.close();
                                    } catch (Exception e3) {
                                        C0970a.m4322a(e3);
                                        campaigns2 = campaigns;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        campaigns2 = campaigns;
                                        throw th;
                                    }
                                }
                                if (fileIn != null) {
                                    fileIn.close();
                                }
                                campaigns2 = campaigns;
                                return campaigns2;
                            } catch (Throwable th4) {
                                th = th4;
                                if (in != null) {
                                    in.close();
                                }
                                if (fileIn != null) {
                                    fileIn.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            in = in2;
                            if (in != null) {
                                in.close();
                            }
                            if (fileIn != null) {
                                fileIn.close();
                            }
                            throw th;
                        }
                    } catch (Exception e4) {
                        campaigns = new OcmCampaigns();
                        if (in != null) {
                            in.close();
                        }
                        if (fileIn != null) {
                            fileIn.close();
                        }
                        campaigns2 = campaigns;
                        return campaigns2;
                    }
                }
                return campaigns2;
            } catch (Exception e32) {
                C0970a.m4322a(e32);
            } catch (Throwable th6) {
                th = th6;
                throw th;
            }
        }
    }

    public static void deleteCampaignsFile(Context context) {
        synchronized (syncObj) {
            new File(context.getFilesDir(), FILENAME).delete();
        }
    }

    public static long saveTimeStamp(Context context) {
        SharedPreferences pref = context.getSharedPreferences(OCM_CAMPAIGN, 0);
        long timeStamp = OcmCampaign.getCurrentTimeInMillis();
        pref.edit().putLong(LAST_SAVED_CAMPAIGN, timeStamp).commit();
        return timeStamp;
    }

    public static long getSavedTimeStamp(Context context) {
        return context.getSharedPreferences(OCM_CAMPAIGN, 0).getLong(LAST_SAVED_CAMPAIGN, 0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean setAnalyticsFromString(java.lang.String r9) {
        /*
        r8 = this;
        r5 = 0;
        r4 = 1;
        r6 = "0";
        r6 = r6.equals(r9);
        if (r6 == 0) goto L_0x0015;
    L_0x000a:
        r5 = r8.analyticsArray;
        r5.clear();
        r5 = r8.analyticsTechErrorsMap;
        r5.clear();
    L_0x0014:
        return r4;
    L_0x0015:
        r3 = new java.util.HashMap;
        r3.<init>();
        r6 = "-";
        r2 = r9.split(r6);
        r0 = 0;
    L_0x0021:
        r6 = r2.length;
        if (r0 >= r6) goto L_0x0058;
    L_0x0024:
        r6 = r2[r0];
        r7 = "\\+";
        r1 = r6.split(r7);
        r6 = r1.length;
        r7 = 2;
        if (r6 != r7) goto L_0x0058;
    L_0x0030:
        r6 = r1[r5];
        r7 = "";
        r6 = r6.equals(r7);
        if (r6 != 0) goto L_0x0058;
    L_0x003a:
        r6 = r1[r5];
        r7 = "[a-zA-Z][a-zA-Z0-9]*";
        r6 = r6.matches(r7);
        if (r6 == 0) goto L_0x0058;
    L_0x0044:
        r6 = r1[r4];
        r7 = "";
        r6 = r6.equals(r7);
        if (r6 != 0) goto L_0x0058;
    L_0x004e:
        r6 = r1[r4];
        r7 = "[0-9a-zA-Z]*";
        r6 = r6.matches(r7);
        if (r6 != 0) goto L_0x006b;
    L_0x0058:
        r6 = r2.length;
        if (r0 != r6) goto L_0x0075;
    L_0x005b:
        r5 = r8.analyticsTechErrorsMap;
        r5.clear();
        r5 = r8.analyticsArray;
        r5.clear();
        r5 = r8.analyticsArray;
        r5.putAll(r3);
        goto L_0x0014;
    L_0x006b:
        r6 = r1[r5];
        r7 = r1[r4];
        r3.put(r6, r7);
        r0 = r0 + 1;
        goto L_0x0021;
    L_0x0075:
        r4 = r5;
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avg.toolkit.license.OcmCampaigns.setAnalyticsFromString(java.lang.String):boolean");
    }

    public String getAnalyticsString() {
        StringBuilder ret = new StringBuilder();
        Set<String> keys = this.analyticsArray.keySet();
        if (keys.size() <= 0) {
            return ITKSvc.CODEREVISION;
        }
        for (String key : keys) {
            ret.append(key).append('+').append((String) this.analyticsArray.get(key)).append('-');
        }
        ret.delete(ret.length() - 1, ret.length());
        return ret.toString();
    }

    public void updateInactiveDays(Integer newInactiveDays, Integer newInactiveDaysCampignId) {
        if (newInactiveDays != null && newInactiveDaysCampignId != null && newInactiveDaysCampignId.intValue() > this.globalInactiveDaysOcmId.intValue()) {
            this.globalInactiveDaysOcmId = newInactiveDaysCampignId;
            this.globalInactiveDays = newInactiveDays;
        }
    }
}
