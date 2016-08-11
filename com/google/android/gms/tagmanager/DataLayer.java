package com.google.android.gms.tagmanager;

import com.google.android.gms.location.LocationRequest;
import com.millennialmedia.android.MMException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT;
    static final String[] Xp;
    private static final Pattern Xq;
    private final ConcurrentHashMap Xr;
    private final Map Xs;
    private final ReentrantLock Xt;
    private final LinkedList Xu;
    private final C2243c Xv;
    private final CountDownLatch Xw;

    /* renamed from: com.google.android.gms.tagmanager.DataLayer.c */
    interface C2243c {

        /* renamed from: com.google.android.gms.tagmanager.DataLayer.c.a */
        public interface C2245a {
            void m9281a(List list);
        }

        void m9277a(C2245a c2245a);

        void m9278a(List list, long j);

        void bx(String str);
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer.1 */
    class C22441 implements C2243c {
        C22441() {
        }

        public void m9279a(C2245a c2245a) {
            c2245a.m9281a(new ArrayList());
        }

        public void m9280a(List list, long j) {
        }

        public void bx(String str) {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer.2 */
    class C22462 implements C2245a {
        final /* synthetic */ DataLayer Xx;

        C22462(DataLayer dataLayer) {
            this.Xx = dataLayer;
        }

        public void m9282a(List list) {
            for (C2247a c2247a : list) {
                this.Xx.m9284A(this.Xx.m9297c(c2247a.Xy, c2247a.Xz));
            }
            this.Xx.Xw.countDown();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer.a */
    static final class C2247a {
        public final String Xy;
        public final Object Xz;

        C2247a(String str, Object obj) {
            this.Xy = str;
            this.Xz = obj;
        }

        public boolean equals(Object o) {
            if (!(o instanceof C2247a)) {
                return false;
            }
            C2247a c2247a = (C2247a) o;
            return this.Xy.equals(c2247a.Xy) && this.Xz.equals(c2247a.Xz);
        }

        public int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.Xy.hashCode()), Integer.valueOf(this.Xz.hashCode())});
        }

        public String toString() {
            return "Key: " + this.Xy + " value: " + this.Xz.toString();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer.b */
    interface C2248b {
        void m9283y(Map map);
    }

    static {
        OBJECT_NOT_PRESENT = new Object();
        Xp = "gtm.lifetime".toString().split("\\.");
        Xq = Pattern.compile("(\\d+)\\s*([smhd]?)");
    }

    DataLayer() {
        this(new C22441());
    }

    DataLayer(C2243c persistentStore) {
        this.Xv = persistentStore;
        this.Xr = new ConcurrentHashMap();
        this.Xs = new HashMap();
        this.Xt = new ReentrantLock();
        this.Xu = new LinkedList();
        this.Xw = new CountDownLatch(1);
        ko();
    }

    private void m9284A(Map map) {
        this.Xt.lock();
        try {
            this.Xu.offer(map);
            if (this.Xt.getHoldCount() == 1) {
                kp();
            }
            m9285B(map);
        } finally {
            this.Xt.unlock();
        }
    }

    private void m9285B(Map map) {
        Long C = m9286C(map);
        if (C != null) {
            List E = m9288E(map);
            E.remove("gtm.lifetime");
            this.Xv.m9278a(E, C.longValue());
        }
    }

    private Long m9286C(Map map) {
        Object D = m9287D(map);
        return D == null ? null : bw(D.toString());
    }

    private Object m9287D(Map map) {
        String[] strArr = Xp;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            Object obj2 = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(obj2);
        }
        return obj;
    }

    private List m9288E(Map map) {
        Object arrayList = new ArrayList();
        m9293a(map, "", arrayList);
        return arrayList;
    }

    private void m9289F(Map map) {
        synchronized (this.Xs) {
            for (String str : map.keySet()) {
                m9296a(m9297c(str, map.get(str)), this.Xs);
            }
        }
        m9290G(map);
    }

    private void m9290G(Map map) {
        for (C2248b y : this.Xr.keySet()) {
            y.m9283y(map);
        }
    }

    private void m9293a(Map map, String str, Collection collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + ((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                m9293a((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new C2247a(str2, entry.getValue()));
            }
        }
    }

    static Long bw(String str) {
        Matcher matcher = Xq.matcher(str);
        if (matcher.matches()) {
            long parseLong;
            try {
                parseLong = Long.parseLong(matcher.group(1));
            } catch (NumberFormatException e) {
                bh.m9376z("illegal number in _lifetime value: " + str);
                parseLong = 0;
            }
            if (parseLong <= 0) {
                bh.m9374x("non-positive _lifetime: " + str);
                return null;
            }
            String group = matcher.group(2);
            if (group.length() == 0) {
                return Long.valueOf(parseLong);
            }
            switch (group.charAt(0)) {
                case MMException.UNKNOWN_ERROR /*100*/:
                    return Long.valueOf((((parseLong * 1000) * 60) * 60) * 24);
                case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                    return Long.valueOf(((parseLong * 1000) * 60) * 60);
                case 'm':
                    return Long.valueOf((parseLong * 1000) * 60);
                case 's':
                    return Long.valueOf(parseLong * 1000);
                default:
                    bh.m9376z("unknown units in _lifetime: " + str);
                    return null;
            }
        }
        bh.m9374x("unknown _lifetime: " + str);
        return null;
    }

    private void ko() {
        this.Xv.m9277a(new C22462(this));
    }

    private void kp() {
        int i = 0;
        while (true) {
            Map map = (Map) this.Xu.poll();
            if (map != null) {
                m9289F(map);
                int i2 = i + 1;
                if (i2 > 500) {
                    break;
                }
                i = i2;
            } else {
                return;
            }
        }
        this.Xu.clear();
        throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
    }

    public static List listOf(Object... objects) {
        List arrayList = new ArrayList();
        for (Object add : objects) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static Map mapOf(Object... objects) {
        if (objects.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        Map hashMap = new HashMap();
        int i = 0;
        while (i < objects.length) {
            if (objects[i] instanceof String) {
                hashMap.put((String) objects[i], objects[i + 1]);
                i += 2;
            } else {
                throw new IllegalArgumentException("key is not a string: " + objects[i]);
            }
        }
        return hashMap;
    }

    void m9294a(C2248b c2248b) {
        this.Xr.put(c2248b, Integer.valueOf(0));
    }

    void m9295a(List list, List list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                m9295a((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                m9296a((Map) obj, (Map) list2.get(i));
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i, obj);
            }
        }
    }

    void m9296a(Map map, Map map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                m9295a((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                m9296a((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    void bv(String str) {
        push(str, null);
        this.Xv.bx(str);
    }

    Map m9297c(String str, Object obj) {
        Map hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(split[i], hashMap2);
            i++;
            Object obj2 = hashMap2;
        }
        map.put(split[split.length - 1], obj);
        return hashMap;
    }

    public Object get(String key) {
        synchronized (this.Xs) {
            Map map = this.Xs;
            String[] split = key.split("\\.");
            int length = split.length;
            Object obj = map;
            int i = 0;
            while (i < length) {
                Object obj2 = split[i];
                if (obj instanceof Map) {
                    obj2 = ((Map) obj).get(obj2);
                    if (obj2 == null) {
                        return null;
                    }
                    i++;
                    obj = obj2;
                } else {
                    return null;
                }
            }
            return obj;
        }
    }

    public void push(String key, Object value) {
        push(m9297c(key, value));
    }

    public void push(Map update) {
        try {
            this.Xw.await();
        } catch (InterruptedException e) {
            bh.m9376z("DataLayer.push: unexpected InterruptedException");
        }
        m9284A(update);
    }

    public void pushEvent(String eventName, Map update) {
        Map hashMap = new HashMap(update);
        hashMap.put(EVENT_KEY, eventName);
        push(hashMap);
    }
}
