package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.Gson;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.TypeAdapterFactory;
import com.millennialmedia.google.gson.internal.C$Gson$Types;
import com.millennialmedia.google.gson.reflect.TypeToken;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.JsonWriter;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public final class ArrayTypeAdapter extends TypeAdapter {
    public static final TypeAdapterFactory FACTORY;
    private final Class componentType;
    private final TypeAdapter componentTypeAdapter;

    /* renamed from: com.millennialmedia.google.gson.internal.bind.ArrayTypeAdapter.1 */
    static class C25551 implements TypeAdapterFactory {
        C25551() {
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            Type type = typeToken.getType();
            if (!(type instanceof GenericArrayType) && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type componentType = C$Gson$Types.getArrayComponentType(type);
            return new ArrayTypeAdapter(gson, gson.getAdapter(TypeToken.get(componentType)), C$Gson$Types.getRawType(componentType));
        }
    }

    static {
        FACTORY = new C25551();
    }

    public ArrayTypeAdapter(Gson context, TypeAdapter componentTypeAdapter, Class componentType) {
        this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper(context, componentTypeAdapter, componentType);
        this.componentType = componentType;
    }

    public Object read(JsonReader in) {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        List list = new ArrayList();
        in.beginArray();
        while (in.hasNext()) {
            list.add(this.componentTypeAdapter.read(in));
        }
        in.endArray();
        Object array = Array.newInstance(this.componentType, list.size());
        for (int i = 0; i < list.size(); i++) {
            Array.set(array, i, list.get(i));
        }
        return array;
    }

    public void write(JsonWriter out, Object array) {
        if (array == null) {
            out.nullValue();
            return;
        }
        out.beginArray();
        int length = Array.getLength(array);
        for (int i = 0; i < length; i++) {
            this.componentTypeAdapter.write(out, Array.get(array, i));
        }
        out.endArray();
    }
}
