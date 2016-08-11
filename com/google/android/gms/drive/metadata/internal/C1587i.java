package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C1577b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;

/* renamed from: com.google.android.gms.drive.metadata.internal.i */
public class C1587i extends C1577b {
    public C1587i(String str, int i) {
        super(str, i);
    }

    public static final Collection ay(String str) {
        if (str == null) {
            return null;
        }
        Collection arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    protected void m6683a(Bundle bundle, Collection collection) {
        bundle.putStringArrayList(getName(), new ArrayList(collection));
    }

    protected /* synthetic */ Object m6684b(DataHolder dataHolder, int i, int i2) {
        return m6685c(dataHolder, i, i2);
    }

    protected Collection m6685c(DataHolder dataHolder, int i, int i2) {
        try {
            return C1587i.ay(dataHolder.getString(getName(), i, i2));
        } catch (Throwable e) {
            throw new IllegalStateException("DataHolder supplied invalid JSON", e);
        }
    }

    protected /* synthetic */ Object m6686e(Bundle bundle) {
        return m6687j(bundle);
    }

    protected Collection m6687j(Bundle bundle) {
        return bundle.getStringArrayList(getName());
    }
}
