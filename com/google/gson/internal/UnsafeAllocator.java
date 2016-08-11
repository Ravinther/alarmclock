package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class UnsafeAllocator {

    /* renamed from: com.google.gson.internal.UnsafeAllocator.1 */
    static class C24081 extends UnsafeAllocator {
        final /* synthetic */ Method val$allocateInstance;
        final /* synthetic */ Object val$unsafe;

        C24081(Method method, Object obj) {
            this.val$allocateInstance = method;
            this.val$unsafe = obj;
        }

        public Object newInstance(Class c) {
            return this.val$allocateInstance.invoke(this.val$unsafe, new Object[]{c});
        }
    }

    /* renamed from: com.google.gson.internal.UnsafeAllocator.2 */
    static class C24092 extends UnsafeAllocator {
        final /* synthetic */ Method val$newInstance;

        C24092(Method method) {
            this.val$newInstance = method;
        }

        public Object newInstance(Class c) {
            return this.val$newInstance.invoke(null, new Object[]{c, Object.class});
        }
    }

    /* renamed from: com.google.gson.internal.UnsafeAllocator.3 */
    static class C24103 extends UnsafeAllocator {
        final /* synthetic */ int val$constructorId;
        final /* synthetic */ Method val$newInstance;

        C24103(Method method, int i) {
            this.val$newInstance = method;
            this.val$constructorId = i;
        }

        public Object newInstance(Class c) {
            return this.val$newInstance.invoke(null, new Object[]{c, Integer.valueOf(this.val$constructorId)});
        }
    }

    /* renamed from: com.google.gson.internal.UnsafeAllocator.4 */
    static class C24114 extends UnsafeAllocator {
        C24114() {
        }

        public Object newInstance(Class c) {
            throw new UnsupportedOperationException("Cannot allocate " + c);
        }
    }

    public abstract Object newInstance(Class cls);

    public static UnsafeAllocator create() {
        Method newInstance;
        try {
            Class unsafeClass = Class.forName("sun.misc.Unsafe");
            Field f = unsafeClass.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return new C24081(unsafeClass.getMethod("allocateInstance", new Class[]{Class.class}), f.get(null));
        } catch (Exception e) {
            try {
                newInstance = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});
                newInstance.setAccessible(true);
                return new C24092(newInstance);
            } catch (Exception e2) {
                try {
                    Method getConstructorId = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});
                    getConstructorId.setAccessible(true);
                    int constructorId = ((Integer) getConstructorId.invoke(null, new Object[]{Object.class})).intValue();
                    newInstance = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});
                    newInstance.setAccessible(true);
                    return new C24103(newInstance, constructorId);
                } catch (Exception e3) {
                    return new C24114();
                }
            }
        }
    }
}
