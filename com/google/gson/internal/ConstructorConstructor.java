package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public final class ConstructorConstructor {
    private final Map instanceCreators;

    /* renamed from: com.google.gson.internal.ConstructorConstructor.1 */
    class C23941 implements ObjectConstructor {
        final /* synthetic */ InstanceCreator val$creator;
        final /* synthetic */ Type val$type;

        C23941(InstanceCreator instanceCreator, Type type) {
            this.val$creator = instanceCreator;
            this.val$type = type;
        }

        public Object construct() {
            return this.val$creator.createInstance(this.val$type);
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor.2 */
    class C23952 implements ObjectConstructor {
        final /* synthetic */ Constructor val$constructor;

        C23952(Constructor constructor) {
            this.val$constructor = constructor;
        }

        public Object construct() {
            try {
                return this.val$constructor.newInstance(null);
            } catch (InstantiationException e) {
                throw new RuntimeException("Failed to invoke " + this.val$constructor + " with no args", e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to invoke " + this.val$constructor + " with no args", e2.getTargetException());
            } catch (IllegalAccessException e3) {
                throw new AssertionError(e3);
            }
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor.3 */
    class C23963 implements ObjectConstructor {
        C23963() {
        }

        public Object construct() {
            return new TreeSet();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor.4 */
    class C23974 implements ObjectConstructor {
        C23974() {
        }

        public Object construct() {
            return new LinkedHashSet();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor.5 */
    class C23985 implements ObjectConstructor {
        C23985() {
        }

        public Object construct() {
            return new LinkedList();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor.6 */
    class C23996 implements ObjectConstructor {
        C23996() {
        }

        public Object construct() {
            return new ArrayList();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor.7 */
    class C24007 implements ObjectConstructor {
        C24007() {
        }

        public Object construct() {
            return new LinkedHashMap();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor.8 */
    class C24018 implements ObjectConstructor {
        private final UnsafeAllocator unsafeAllocator;
        final /* synthetic */ Class val$rawType;
        final /* synthetic */ Type val$type;

        C24018(Class cls, Type type) {
            this.val$rawType = cls;
            this.val$type = type;
            this.unsafeAllocator = UnsafeAllocator.create();
        }

        public Object construct() {
            try {
                return this.unsafeAllocator.newInstance(this.val$rawType);
            } catch (Exception e) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.val$type + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", e);
            }
        }
    }

    public ConstructorConstructor(Map instanceCreators) {
        this.instanceCreators = instanceCreators;
    }

    public ConstructorConstructor() {
        this(Collections.emptyMap());
    }

    public ObjectConstructor get(TypeToken typeToken) {
        Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        InstanceCreator creator = (InstanceCreator) this.instanceCreators.get(type);
        if (creator != null) {
            return new C23941(creator, type);
        }
        ObjectConstructor defaultConstructor = newDefaultConstructor(rawType);
        if (defaultConstructor != null) {
            return defaultConstructor;
        }
        ObjectConstructor defaultImplementation = newDefaultImplementationConstructor(rawType);
        if (defaultImplementation != null) {
            return defaultImplementation;
        }
        return newUnsafeAllocator(type, rawType);
    }

    private ObjectConstructor newDefaultConstructor(Class rawType) {
        try {
            Constructor constructor = rawType.getDeclaredConstructor(new Class[0]);
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return new C23952(constructor);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private ObjectConstructor newDefaultImplementationConstructor(Class rawType) {
        if (Collection.class.isAssignableFrom(rawType)) {
            if (SortedSet.class.isAssignableFrom(rawType)) {
                return new C23963();
            }
            if (Set.class.isAssignableFrom(rawType)) {
                return new C23974();
            }
            if (Queue.class.isAssignableFrom(rawType)) {
                return new C23985();
            }
            return new C23996();
        } else if (Map.class.isAssignableFrom(rawType)) {
            return new C24007();
        } else {
            return null;
        }
    }

    private ObjectConstructor newUnsafeAllocator(Type type, Class rawType) {
        return new C24018(rawType, type);
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
