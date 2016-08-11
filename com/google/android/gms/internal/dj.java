package com.google.android.gms.internal;

import android.os.Bundle;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

public class dj {
    private static final dj qJ;
    public static final String qK;
    private final Object li;
    public final String qL;
    private final dk qM;
    private BigInteger qN;
    private final HashSet qO;
    private final HashMap qP;

    static {
        qJ = new dj();
        qK = qJ.qL;
    }

    private dj() {
        this.li = new Object();
        this.qN = BigInteger.ONE;
        this.qO = new HashSet();
        this.qP = new HashMap();
        this.qL = br();
        this.qM = new dk(this.qL);
    }

    public static Bundle m8160a(dl dlVar, String str) {
        return qJ.m8164b(dlVar, str);
    }

    public static void m8161b(HashSet hashSet) {
        qJ.m8165c(hashSet);
    }

    public static dj bq() {
        return qJ;
    }

    private static String br() {
        UUID randomUUID = UUID.randomUUID();
        byte[] toByteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] toByteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, toByteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(toByteArray);
                instance.update(toByteArray2);
                Object obj = new byte[8];
                System.arraycopy(instance.digest(), 0, obj, 0, 8);
                bigInteger = new BigInteger(1, obj).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return bigInteger;
    }

    public static String bs() {
        return qJ.bt();
    }

    public static dk bu() {
        return qJ.bv();
    }

    public void m8162a(di diVar) {
        synchronized (this.li) {
            this.qO.add(diVar);
        }
    }

    public void m8163a(String str, dm dmVar) {
        synchronized (this.li) {
            this.qP.put(str, dmVar);
        }
    }

    public Bundle m8164b(dl dlVar, String str) {
        Bundle bundle;
        synchronized (this.li) {
            bundle = new Bundle();
            bundle.putBundle("app", this.qM.m8167q(str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.qP.keySet()) {
                bundle2.putBundle(str2, ((dm) this.qP.get(str2)).toBundle());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.qO.iterator();
            while (it.hasNext()) {
                arrayList.add(((di) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            dlVar.m8168a(this.qO);
            this.qO.clear();
        }
        return bundle;
    }

    public String bt() {
        String bigInteger;
        synchronized (this.li) {
            bigInteger = this.qN.toString();
            this.qN = this.qN.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public dk bv() {
        dk dkVar;
        synchronized (this.li) {
            dkVar = this.qM;
        }
        return dkVar;
    }

    public void m8165c(HashSet hashSet) {
        synchronized (this.li) {
            this.qO.addAll(hashSet);
        }
    }
}
