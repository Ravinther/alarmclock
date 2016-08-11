package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C1788c.C1783f;
import com.google.android.gms.internal.C1788c.C1786i;
import com.google.android.gms.internal.C1788c.C1787j;
import com.google.android.gms.internal.C1817d.C1816a;
import com.google.android.gms.tagmanager.C2326s.C2240a;
import com.google.android.gms.tagmanager.cd.C2271a;
import com.google.android.gms.tagmanager.cq.C2283c;
import com.google.android.gms.tagmanager.cq.C2287g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private final String WJ;
    private final DataLayer WK;
    private cs WL;
    private Map WM;
    private Map WN;
    private volatile long WO;
    private volatile String WP;
    private final Context mContext;

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map map);
    }

    /* renamed from: com.google.android.gms.tagmanager.Container.a */
    private class C2241a implements C2240a {
        final /* synthetic */ Container WQ;

        private C2241a(Container container) {
            this.WQ = container;
        }

        public Object m9271b(String str, Map map) {
            FunctionCallMacroCallback bn = this.WQ.bn(str);
            return bn == null ? null : bn.getValue(str, map);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.Container.b */
    private class C2242b implements C2240a {
        final /* synthetic */ Container WQ;

        private C2242b(Container container) {
            this.WQ = container;
        }

        public Object m9272b(String str, Map map) {
            FunctionCallTagCallback bo = this.WQ.bo(str);
            if (bo != null) {
                bo.execute(str, map);
            }
            return dh.lS();
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, C1787j resource) {
        this.WM = new HashMap();
        this.WN = new HashMap();
        this.WP = "";
        this.mContext = context;
        this.WK = dataLayer;
        this.WJ = containerId;
        this.WO = lastRefreshTime;
        m9273a(resource.fK);
        if (resource.fJ != null) {
            m9276a(resource.fJ);
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, C2283c resource) {
        this.WM = new HashMap();
        this.WN = new HashMap();
        this.WP = "";
        this.mContext = context;
        this.WK = dataLayer;
        this.WJ = containerId;
        this.WO = lastRefreshTime;
        m9274a(resource);
    }

    private void m9273a(C1783f c1783f) {
        if (c1783f == null) {
            throw new NullPointerException();
        }
        try {
            m9274a(cq.m9459b(c1783f));
        } catch (C2287g e) {
            bh.m9373w("Not loading resource: " + c1783f + " because it is invalid: " + e.toString());
        }
    }

    private void m9274a(C2283c c2283c) {
        this.WP = c2283c.getVersion();
        C2283c c2283c2 = c2283c;
        m9275a(new cs(this.mContext, c2283c2, this.WK, new C2241a(), new C2242b(), bq(this.WP)));
    }

    private synchronized void m9275a(cs csVar) {
        this.WL = csVar;
    }

    private void m9276a(C1786i[] c1786iArr) {
        List arrayList = new ArrayList();
        for (Object add : c1786iArr) {
            arrayList.add(add);
        }
        kd().m9490e(arrayList);
    }

    private synchronized cs kd() {
        return this.WL;
    }

    FunctionCallMacroCallback bn(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.WM) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.WM.get(str);
        }
        return functionCallMacroCallback;
    }

    FunctionCallTagCallback bo(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.WN) {
            functionCallTagCallback = (FunctionCallTagCallback) this.WN.get(str);
        }
        return functionCallTagCallback;
    }

    void bp(String str) {
        kd().bp(str);
    }

    ag bq(String str) {
        if (cd.kT().kU().equals(C2271a.CONTAINER_DEBUG)) {
        }
        return new bq();
    }

    public boolean getBoolean(String key) {
        cs kd = kd();
        if (kd == null) {
            bh.m9373w("getBoolean called for closed container.");
            return dh.lQ().booleanValue();
        }
        try {
            return dh.m9526n((C1816a) kd.bR(key).getObject()).booleanValue();
        } catch (Exception e) {
            bh.m9373w("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.lQ().booleanValue();
        }
    }

    public String getContainerId() {
        return this.WJ;
    }

    public double getDouble(String key) {
        cs kd = kd();
        if (kd == null) {
            bh.m9373w("getDouble called for closed container.");
            return dh.lP().doubleValue();
        }
        try {
            return dh.m9523m((C1816a) kd.bR(key).getObject()).doubleValue();
        } catch (Exception e) {
            bh.m9373w("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.lP().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.WO;
    }

    public long getLong(String key) {
        cs kd = kd();
        if (kd == null) {
            bh.m9373w("getLong called for closed container.");
            return dh.lO().longValue();
        }
        try {
            return dh.m9522l((C1816a) kd.bR(key).getObject()).longValue();
        } catch (Exception e) {
            bh.m9373w("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.lO().longValue();
        }
    }

    public String getString(String key) {
        cs kd = kd();
        if (kd == null) {
            bh.m9373w("getString called for closed container.");
            return dh.lS();
        }
        try {
            return dh.m9520j((C1816a) kd.bR(key).getObject());
        } catch (Exception e) {
            bh.m9373w("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.lS();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    String kc() {
        return this.WP;
    }

    public void registerFunctionCallMacroCallback(String customMacroName, FunctionCallMacroCallback customMacroCallback) {
        if (customMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.WM) {
            this.WM.put(customMacroName, customMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String customTagName, FunctionCallTagCallback customTagCallback) {
        if (customTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.WN) {
            this.WN.put(customTagName, customTagCallback);
        }
    }

    void release() {
        this.WL = null;
    }

    public void unregisterFunctionCallMacroCallback(String customMacroName) {
        synchronized (this.WM) {
            this.WM.remove(customMacroName);
        }
    }

    public void unregisterFunctionCallTagCallback(String customTagName) {
        synchronized (this.WN) {
            this.WN.remove(customTagName);
        }
    }
}
