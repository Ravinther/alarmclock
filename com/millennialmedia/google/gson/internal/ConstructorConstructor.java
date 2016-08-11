package com.millennialmedia.google.gson.internal;

import com.millennialmedia.google.gson.InstanceCreator;
import com.millennialmedia.google.gson.JsonIOException;
import com.millennialmedia.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class ConstructorConstructor {
    private final Map instanceCreators;

    /* renamed from: com.millennialmedia.google.gson.internal.ConstructorConstructor.12 */
    class AnonymousClass12 implements ObjectConstructor {
        private final UnsafeAllocator unsafeAllocator;
        final /* synthetic */ Class val$rawType;
        final /* synthetic */ Type val$type;

        AnonymousClass12(Class cls, Type type) {
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

    /* renamed from: com.millennialmedia.google.gson.internal.ConstructorConstructor.1 */
    class C25371 implements ObjectConstructor {
        final /* synthetic */ Type val$type;
        final /* synthetic */ InstanceCreator val$typeCreator;

        C25371(InstanceCreator instanceCreator, Type type) {
            this.val$typeCreator = instanceCreator;
            this.val$type = type;
        }

        public Object construct() {
            return this.val$typeCreator.createInstance(this.val$type);
        }
    }

    /* renamed from: com.millennialmedia.google.gson.internal.ConstructorConstructor.2 */
    class C25382 implements ObjectConstructor {
        final /* synthetic */ InstanceCreator val$rawTypeCreator;
        final /* synthetic */ Type val$type;

        C25382(InstanceCreator instanceCreator, Type type) {
            this.val$rawTypeCreator = instanceCreator;
            this.val$type = type;
        }

        public Object construct() {
            return this.val$rawTypeCreator.createInstance(this.val$type);
        }
    }

    /* renamed from: com.millennialmedia.google.gson.internal.ConstructorConstructor.3 */
    class C25393 implements ObjectConstructor {
        final /* synthetic */ Constructor val$constructor;

        C25393(Constructor constructor) {
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

    /* renamed from: com.millennialmedia.google.gson.internal.ConstructorConstructor.4 */
    class C25404 implements ObjectConstructor {
        C25404() {
        }

        public Object construct() {
            return new TreeSet();
        }
    }

    /* renamed from: com.millennialmedia.google.gson.internal.ConstructorConstructor.5 */
    class C25415 implements ObjectConstructor {
        final /* synthetic */ Type val$type;

        C25415(Type type) {
            this.val$type = type;
        }

        public Object construct() {
            if (this.val$type instanceof ParameterizedType) {
                Type elementType = ((ParameterizedType) this.val$type).getActualTypeArguments()[0];
                if (elementType instanceof Class) {
                    return EnumSet.noneOf((Class) elementType);
                }
                throw new JsonIOException("Invalid EnumSet type: " + this.val$type.toString());
            }
            throw new JsonIOException("Invalid EnumSet type: " + this.val$type.toString());
        }
    }

    /* renamed from: com.millennialmedia.google.gson.internal.ConstructorConstructor.6 */
    class C25426 implements ObjectConstructor {
        C25426() {
        }

        public Object construct() {
            return new LinkedHashSet();
        }
    }

    /* renamed from: com.millennialmedia.google.gson.internal.ConstructorConstructor.7 */
    class C25437 implements ObjectConstructor {
        C25437() {
        }

        public Object construct() {
            return new LinkedList();
        }
    }

    /* renamed from: com.millennialmedia.google.gson.internal.ConstructorConstructor.8 */
    class C25448 implements ObjectConstructor {
        C25448() {
        }

        public Object construct() {
            return new ArrayList();
        }
    }

    /* renamed from: com.millennialmedia.google.gson.internal.ConstructorConstructor.9 */
    class C25459 implements ObjectConstructor {
        C25459() {
        }

        public Object construct() {
            return new TreeMap();
        }
    }

    public ConstructorConstructor(Map instanceCreators) {
        this.instanceCreators = instanceCreators;
    }

    public ObjectConstructor get(TypeToken typeToken) {
        Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        InstanceCreator typeCreator = (InstanceCreator) this.instanceCreators.get(type);
        if (typeCreator != null) {
            return new C25371(typeCreator, type);
        }
        InstanceCreator rawTypeCreator = (InstanceCreator) this.instanceCreators.get(rawType);
        if (rawTypeCreator != null) {
            return new C25382(rawTypeCreator, type);
        }
        ObjectConstructor defaultConstructor = newDefaultConstructor(rawType);
        if (defaultConstructor != null) {
            return defaultConstructor;
        }
        ObjectConstructor defaultImplementation = newDefaultImplementationConstructor(type, rawType);
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
            return new C25393(constructor);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    private ObjectConstructor newDefaultImplementationConstructor(Type type, Class rawType) {
        if (Collection.class.isAssignableFrom(rawType)) {
            if (SortedSet.class.isAssignableFrom(rawType)) {
                return new C25404();
            }
            if (EnumSet.class.isAssignableFrom(rawType)) {
                return new C25415(type);
            }
            if (Set.class.isAssignableFrom(rawType)) {
                return new C25426();
            }
            if (Queue.class.isAssignableFrom(rawType)) {
                return new C25437();
            }
            return new C25448();
        } else if (!Map.class.isAssignableFrom(rawType)) {
            return null;
        } else {
            if (SortedMap.class.isAssignableFrom(rawType)) {
                return new C25459();
            }
            if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
                return new ObjectConstructor() {
                    public Object construct() {
                        return new LinkedHashTreeMap();
                    }
                };
            }
            return new ObjectConstructor() {
                public Object construct() {
                    return new LinkedHashMap();
                }
            };
        }
    }

    private ObjectConstructor newUnsafeAllocator(Type type, Class rawType) {
        return new AnonymousClass12(rawType, type);
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
