package com.millennialmedia.google.gson.internal;

import com.millennialmedia.google.gson.ExclusionStrategy;
import com.millennialmedia.google.gson.FieldAttributes;
import com.millennialmedia.google.gson.Gson;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.TypeAdapterFactory;
import com.millennialmedia.google.gson.annotations.Expose;
import com.millennialmedia.google.gson.annotations.Since;
import com.millennialmedia.google.gson.annotations.Until;
import com.millennialmedia.google.gson.reflect.TypeToken;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT;
    private static final double IGNORE_VERSIONS = -1.0d;
    private List deserializationStrategies;
    private int modifiers;
    private boolean requireExpose;
    private List serializationStrategies;
    private boolean serializeInnerClasses;
    private double version;

    /* renamed from: com.millennialmedia.google.gson.internal.Excluder.1 */
    class C25461 extends TypeAdapter {
        private TypeAdapter delegate;
        final /* synthetic */ Gson val$gson;
        final /* synthetic */ boolean val$skipDeserialize;
        final /* synthetic */ boolean val$skipSerialize;
        final /* synthetic */ TypeToken val$type;

        C25461(boolean z, boolean z2, Gson gson, TypeToken typeToken) {
            this.val$skipDeserialize = z;
            this.val$skipSerialize = z2;
            this.val$gson = gson;
            this.val$type = typeToken;
        }

        public Object read(JsonReader in) {
            if (!this.val$skipDeserialize) {
                return delegate().read(in);
            }
            in.skipValue();
            return null;
        }

        public void write(JsonWriter out, Object value) {
            if (this.val$skipSerialize) {
                out.nullValue();
            } else {
                delegate().write(out, value);
            }
        }

        private TypeAdapter delegate() {
            TypeAdapter d = this.delegate;
            if (d != null) {
                return d;
            }
            d = this.val$gson.getDelegateAdapter(Excluder.this, this.val$type);
            this.delegate = d;
            return d;
        }
    }

    public Excluder() {
        this.version = IGNORE_VERSIONS;
        this.modifiers = 136;
        this.serializeInnerClasses = true;
        this.serializationStrategies = Collections.emptyList();
        this.deserializationStrategies = Collections.emptyList();
    }

    static {
        DEFAULT = new Excluder();
    }

    protected Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public Excluder withVersion(double ignoreVersionsAfter) {
        Excluder result = clone();
        result.version = ignoreVersionsAfter;
        return result;
    }

    public com.millennialmedia.google.gson.internal.Excluder withModifiers(int... r7) {
        /* JADX: method processing error */
/*
        Error: java.lang.IndexOutOfBoundsException: bitIndex < 0: -1
	at java.util.BitSet.get(BitSet.java:623)
	at jadx.core.dex.visitors.CodeShrinker$ArgsInfo.usedArgAssign(CodeShrinker.java:139)
	at jadx.core.dex.visitors.CodeShrinker$ArgsInfo.access$300(CodeShrinker.java:44)
	at jadx.core.dex.visitors.CodeShrinker.canMoveBetweenBlocks(CodeShrinker.java:306)
	at jadx.core.dex.visitors.CodeShrinker.shrinkBlock(CodeShrinker.java:229)
	at jadx.core.dex.visitors.CodeShrinker.shrinkMethod(CodeShrinker.java:40)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkArrayForEach(LoopRegionVisitor.java:195)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkForIndexedLoop(LoopRegionVisitor.java:118)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:64)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r6 = this;
        r4 = r6.clone();
        r5 = 0;
        r4.modifiers = r5;
        r0 = r7;
        r2 = r0.length;
        r1 = 0;
    L_0x000a:
        if (r1 >= r2) goto L_0x0016;
    L_0x000c:
        r3 = r0[r1];
        r5 = r4.modifiers;
        r5 = r5 | r3;
        r4.modifiers = r5;
        r1 = r1 + 1;
        goto L_0x000a;
    L_0x0016:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.millennialmedia.google.gson.internal.Excluder.withModifiers(int[]):com.millennialmedia.google.gson.internal.Excluder");
    }

    public Excluder disableInnerClassSerialization() {
        Excluder result = clone();
        result.serializeInnerClasses = false;
        return result;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder result = clone();
        result.requireExpose = true;
        return result;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean serialization, boolean deserialization) {
        Excluder result = clone();
        if (serialization) {
            result.serializationStrategies = new ArrayList(this.serializationStrategies);
            result.serializationStrategies.add(exclusionStrategy);
        }
        if (deserialization) {
            result.deserializationStrategies = new ArrayList(this.deserializationStrategies);
            result.deserializationStrategies.add(exclusionStrategy);
        }
        return result;
    }

    public TypeAdapter create(Gson gson, TypeToken type) {
        Class rawType = type.getRawType();
        boolean skipSerialize = excludeClass(rawType, true);
        boolean skipDeserialize = excludeClass(rawType, false);
        if (skipSerialize || skipDeserialize) {
            return new C25461(skipDeserialize, skipSerialize, gson, type);
        }
        return null;
    }

    public boolean excludeField(Field field, boolean serialize) {
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if (this.version != IGNORE_VERSIONS && !isValidVersion((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (this.requireExpose) {
            Expose annotation = (Expose) field.getAnnotation(Expose.class);
            if (annotation == null || (serialize ? !annotation.serialize() : !annotation.deserialize())) {
                return true;
            }
        }
        if (!this.serializeInnerClasses && isInnerClass(field.getType())) {
            return true;
        }
        if (isAnonymousOrLocal(field.getType())) {
            return true;
        }
        List<ExclusionStrategy> list = serialize ? this.serializationStrategies : this.deserializationStrategies;
        if (!list.isEmpty()) {
            FieldAttributes fieldAttributes = new FieldAttributes(field);
            for (ExclusionStrategy exclusionStrategy : list) {
                if (exclusionStrategy.shouldSkipField(fieldAttributes)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean excludeClass(Class clazz, boolean serialize) {
        if (this.version != IGNORE_VERSIONS && !isValidVersion((Since) clazz.getAnnotation(Since.class), (Until) clazz.getAnnotation(Until.class))) {
            return true;
        }
        if (!this.serializeInnerClasses && isInnerClass(clazz)) {
            return true;
        }
        if (isAnonymousOrLocal(clazz)) {
            return true;
        }
        for (ExclusionStrategy exclusionStrategy : serialize ? this.serializationStrategies : this.deserializationStrategies) {
            if (exclusionStrategy.shouldSkipClass(clazz)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnonymousOrLocal(Class clazz) {
        return !Enum.class.isAssignableFrom(clazz) && (clazz.isAnonymousClass() || clazz.isLocalClass());
    }

    private boolean isInnerClass(Class clazz) {
        return clazz.isMemberClass() && !isStatic(clazz);
    }

    private boolean isStatic(Class clazz) {
        return (clazz.getModifiers() & 8) != 0;
    }

    private boolean isValidVersion(Since since, Until until) {
        return isValidSince(since) && isValidUntil(until);
    }

    private boolean isValidSince(Since annotation) {
        if (annotation == null || annotation.value() <= this.version) {
            return true;
        }
        return false;
    }

    private boolean isValidUntil(Until annotation) {
        if (annotation == null || annotation.value() > this.version) {
            return true;
        }
        return false;
    }
}
