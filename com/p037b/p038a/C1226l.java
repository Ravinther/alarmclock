package com.p037b.p038a;

import android.util.Log;
import com.p037b.p062b.C1212c;
import com.p037b.p062b.C1213a;
import com.p037b.p062b.C1216b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: com.b.a.l */
public class C1226l implements Cloneable {
    private static final C1201m f3715i;
    private static final C1201m f3716j;
    private static Class[] f3717k;
    private static Class[] f3718l;
    private static Class[] f3719m;
    private static final HashMap f3720n;
    private static final HashMap f3721o;
    String f3722a;
    protected C1212c f3723b;
    Method f3724c;
    Class f3725d;
    C1203i f3726e;
    final ReentrantReadWriteLock f3727f;
    final Object[] f3728g;
    private Method f3729h;
    private C1201m f3730p;
    private Object f3731q;

    /* renamed from: com.b.a.l.a */
    static class C1227a extends C1226l {
        C1204e f3732h;
        float f3733i;
        private C1213a f3734j;

        public /* synthetic */ C1226l m5220a() {
            return m5226e();
        }

        public /* synthetic */ Object clone() {
            return m5226e();
        }

        public C1227a(String propertyName, float... values) {
            super(null);
            m5223a(values);
        }

        public C1227a(C1212c property, float... values) {
            super(null);
            m5223a(values);
            if (property instanceof C1213a) {
                this.f3734j = (C1213a) this.b;
            }
        }

        public void m5223a(float... values) {
            super.m5214a(values);
            this.f3732h = (C1204e) this.e;
        }

        void m5221a(float fraction) {
            this.f3733i = this.f3732h.m5052b(fraction);
        }

        Object m5225d() {
            return Float.valueOf(this.f3733i);
        }

        public C1227a m5226e() {
            C1227a newPVH = (C1227a) super.m5208a();
            newPVH.f3732h = (C1204e) newPVH.e;
            return newPVH;
        }

        void m5224b(Object target) {
            if (this.f3734j != null) {
                this.f3734j.m5138a(target, this.f3733i);
            } else if (this.b != null) {
                this.b.m5137a(target, Float.valueOf(this.f3733i));
            } else if (this.c != null) {
                try {
                    this.g[0] = Float.valueOf(this.f3733i);
                    this.c.invoke(target, this.g);
                } catch (InvocationTargetException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (IllegalAccessException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        void m5222a(Class targetClass) {
            if (this.b == null) {
                super.m5211a(targetClass);
            }
        }
    }

    /* renamed from: com.b.a.l.b */
    static class C1228b extends C1226l {
        C1206g f3735h;
        int f3736i;
        private C1216b f3737j;

        public /* synthetic */ C1226l m5227a() {
            return m5233e();
        }

        public /* synthetic */ Object clone() {
            return m5233e();
        }

        public C1228b(String propertyName, int... values) {
            super(null);
            m5230a(values);
        }

        public C1228b(C1212c property, int... values) {
            super(null);
            m5230a(values);
            if (property instanceof C1216b) {
                this.f3737j = (C1216b) this.b;
            }
        }

        public void m5230a(int... values) {
            super.m5215a(values);
            this.f3735h = (C1206g) this.e;
        }

        void m5228a(float fraction) {
            this.f3736i = this.f3735h.m5058b(fraction);
        }

        Object m5232d() {
            return Integer.valueOf(this.f3736i);
        }

        public C1228b m5233e() {
            C1228b newPVH = (C1228b) super.m5208a();
            newPVH.f3735h = (C1206g) newPVH.e;
            return newPVH;
        }

        void m5231b(Object target) {
            if (this.f3737j != null) {
                this.f3737j.m5169a(target, this.f3736i);
            } else if (this.b != null) {
                this.b.m5137a(target, Integer.valueOf(this.f3736i));
            } else if (this.c != null) {
                try {
                    this.g[0] = Integer.valueOf(this.f3736i);
                    this.c.invoke(target, this.g);
                } catch (InvocationTargetException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (IllegalAccessException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        void m5229a(Class targetClass) {
            if (this.b == null) {
                super.m5211a(targetClass);
            }
        }
    }

    public /* synthetic */ Object clone() {
        return m5208a();
    }

    static {
        f3715i = new C1205f();
        f3716j = new C1202d();
        f3717k = new Class[]{Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class};
        f3718l = new Class[]{Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class};
        f3719m = new Class[]{Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class};
        f3720n = new HashMap();
        f3721o = new HashMap();
    }

    private C1226l(String propertyName) {
        this.f3724c = null;
        this.f3729h = null;
        this.f3726e = null;
        this.f3727f = new ReentrantReadWriteLock();
        this.f3728g = new Object[1];
        this.f3722a = propertyName;
    }

    private C1226l(C1212c property) {
        this.f3724c = null;
        this.f3729h = null;
        this.f3726e = null;
        this.f3727f = new ReentrantReadWriteLock();
        this.f3728g = new Object[1];
        this.f3723b = property;
        if (property != null) {
            this.f3722a = property.m5136a();
        }
    }

    public static C1226l m5203a(String propertyName, int... values) {
        return new C1228b(propertyName, values);
    }

    public static C1226l m5201a(C1212c property, int... values) {
        return new C1228b(property, values);
    }

    public static C1226l m5202a(String propertyName, float... values) {
        return new C1227a(propertyName, values);
    }

    public static C1226l m5200a(C1212c property, float... values) {
        return new C1227a(property, values);
    }

    public void m5215a(int... values) {
        this.f3725d = Integer.TYPE;
        this.f3726e = C1203i.m5046a(values);
    }

    public void m5214a(float... values) {
        this.f3725d = Float.TYPE;
        this.f3726e = C1203i.m5045a(values);
    }

    private Method m5205a(Class targetClass, String prefix, Class valueType) {
        Method returnVal = null;
        String methodName = C1226l.m5204a(prefix, this.f3722a);
        if (valueType == null) {
            try {
                returnVal = targetClass.getMethod(methodName, null);
            } catch (NoSuchMethodException e) {
                try {
                    returnVal = targetClass.getDeclaredMethod(methodName, null);
                    returnVal.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.f3722a + ": " + e);
                }
            }
        } else {
            Class[] typeVariants;
            Class[] args = new Class[1];
            if (this.f3725d.equals(Float.class)) {
                typeVariants = f3717k;
            } else if (this.f3725d.equals(Integer.class)) {
                typeVariants = f3718l;
            } else {
                typeVariants = this.f3725d.equals(Double.class) ? f3719m : new Class[]{this.f3725d};
            }
            Class[] arr$ = typeVariants;
            int len$ = arr$.length;
            int i$ = 0;
            while (i$ < len$) {
                Class typeVariant = arr$[i$];
                args[0] = typeVariant;
                try {
                    returnVal = targetClass.getMethod(methodName, args);
                    this.f3725d = typeVariant;
                    return returnVal;
                } catch (NoSuchMethodException e3) {
                    try {
                        returnVal = targetClass.getDeclaredMethod(methodName, args);
                        returnVal.setAccessible(true);
                        this.f3725d = typeVariant;
                        return returnVal;
                    } catch (NoSuchMethodException e4) {
                        i$++;
                    }
                }
            }
            Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.f3722a + " with value type " + this.f3725d);
        }
        return returnVal;
    }

    private Method m5206a(Class targetClass, HashMap propertyMapMap, String prefix, Class valueType) {
        Method setterOrGetter = null;
        try {
            this.f3727f.writeLock().lock();
            HashMap propertyMap = (HashMap) propertyMapMap.get(targetClass);
            if (propertyMap != null) {
                setterOrGetter = (Method) propertyMap.get(this.f3722a);
            }
            if (setterOrGetter == null) {
                setterOrGetter = m5205a(targetClass, prefix, valueType);
                if (propertyMap == null) {
                    propertyMap = new HashMap();
                    propertyMapMap.put(targetClass, propertyMap);
                }
                propertyMap.put(this.f3722a, setterOrGetter);
            }
            this.f3727f.writeLock().unlock();
            return setterOrGetter;
        } catch (Throwable th) {
            this.f3727f.writeLock().unlock();
        }
    }

    void m5211a(Class targetClass) {
        this.f3724c = m5206a(targetClass, f3720n, "set", this.f3725d);
    }

    private void m5207b(Class targetClass) {
        this.f3729h = m5206a(targetClass, f3721o, "get", null);
    }

    void m5212a(Object target) {
        Iterator i$;
        C1207h kf;
        if (this.f3723b != null) {
            try {
                Object testValue = this.f3723b.m5135a(target);
                i$ = this.f3726e.f3650e.iterator();
                while (i$.hasNext()) {
                    kf = (C1207h) i$.next();
                    if (!kf.m5066a()) {
                        kf.m5065a(this.f3723b.m5135a(target));
                    }
                }
                return;
            } catch (ClassCastException e) {
                Log.e("PropertyValuesHolder", "No such property (" + this.f3723b.m5136a() + ") on target object " + target + ". Trying reflection instead");
                this.f3723b = null;
            }
        }
        Class targetClass = target.getClass();
        if (this.f3724c == null) {
            m5211a(targetClass);
        }
        i$ = this.f3726e.f3650e.iterator();
        while (i$.hasNext()) {
            kf = (C1207h) i$.next();
            if (!kf.m5066a()) {
                if (this.f3729h == null) {
                    m5207b(targetClass);
                }
                try {
                    kf.m5065a(this.f3729h.invoke(target, new Object[0]));
                } catch (InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                } catch (IllegalAccessException e3) {
                    Log.e("PropertyValuesHolder", e3.toString());
                }
            }
        }
    }

    public C1226l m5208a() {
        try {
            C1226l newPVH = (C1226l) super.clone();
            newPVH.f3722a = this.f3722a;
            newPVH.f3723b = this.f3723b;
            newPVH.f3726e = this.f3726e.m5049b();
            newPVH.f3730p = this.f3730p;
            return newPVH;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    void m5217b(Object target) {
        if (this.f3723b != null) {
            this.f3723b.m5137a(target, m5219d());
        }
        if (this.f3724c != null) {
            try {
                this.f3728g[0] = m5219d();
                this.f3724c.invoke(target, this.f3728g);
            } catch (InvocationTargetException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (IllegalAccessException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    void m5216b() {
        if (this.f3730p == null) {
            C1201m c1201m = this.f3725d == Integer.class ? f3715i : this.f3725d == Float.class ? f3716j : null;
            this.f3730p = c1201m;
        }
        if (this.f3730p != null) {
            this.f3726e.m5048a(this.f3730p);
        }
    }

    void m5209a(float fraction) {
        this.f3731q = this.f3726e.m5047a(fraction);
    }

    public void m5213a(String propertyName) {
        this.f3722a = propertyName;
    }

    public void m5210a(C1212c property) {
        this.f3723b = property;
    }

    public String m5218c() {
        return this.f3722a;
    }

    Object m5219d() {
        return this.f3731q;
    }

    public String toString() {
        return this.f3722a + ": " + this.f3726e.toString();
    }

    static String m5204a(String prefix, String propertyName) {
        if (propertyName == null || propertyName.length() == 0) {
            return prefix;
        }
        char firstLetter = Character.toUpperCase(propertyName.charAt(0));
        return prefix + firstLetter + propertyName.substring(1);
    }
}
