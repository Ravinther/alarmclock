package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.C1615d.C1617a;
import java.lang.reflect.Field;

/* renamed from: com.google.android.gms.dynamic.e */
public final class C1618e extends C1617a {
    private final Object Hw;

    private C1618e(Object obj) {
        this.Hw = obj;
    }

    public static Object m6733d(C1615d c1615d) {
        if (c1615d instanceof C1618e) {
            return ((C1618e) c1615d).Hw;
        }
        IBinder asBinder = c1615d.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        if (declaredFields.length == 1) {
            Field field = declaredFields[0];
            if (field.isAccessible()) {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
            field.setAccessible(true);
            try {
                return field.get(asBinder);
            } catch (Throwable e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (Throwable e2) {
                throw new IllegalArgumentException("remoteBinder is the wrong class.", e2);
            } catch (Throwable e22) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e22);
            }
        }
        throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
    }

    public static C1615d m6734h(Object obj) {
        return new C1618e(obj);
    }
}
