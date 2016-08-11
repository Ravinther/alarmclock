package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.Gson;
import com.millennialmedia.google.gson.JsonElement;
import com.millennialmedia.google.gson.JsonPrimitive;
import com.millennialmedia.google.gson.JsonSyntaxException;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.TypeAdapterFactory;
import com.millennialmedia.google.gson.internal.C$Gson$Types;
import com.millennialmedia.google.gson.internal.ConstructorConstructor;
import com.millennialmedia.google.gson.internal.JsonReaderInternalAccess;
import com.millennialmedia.google.gson.internal.ObjectConstructor;
import com.millennialmedia.google.gson.internal.Streams;
import com.millennialmedia.google.gson.reflect.TypeToken;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class MapTypeAdapterFactory implements TypeAdapterFactory {
    private final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;

    private final class Adapter extends TypeAdapter {
        private final ObjectConstructor constructor;
        private final TypeAdapter keyTypeAdapter;
        private final TypeAdapter valueTypeAdapter;

        public Adapter(Gson context, Type keyType, TypeAdapter keyTypeAdapter, Type valueType, TypeAdapter valueTypeAdapter, ObjectConstructor constructor) {
            this.keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper(context, keyTypeAdapter, keyType);
            this.valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper(context, valueTypeAdapter, valueType);
            this.constructor = constructor;
        }

        public Map read(JsonReader in) {
            JsonToken peek = in.peek();
            if (peek == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            Map map = (Map) this.constructor.construct();
            Object key;
            if (peek == JsonToken.BEGIN_ARRAY) {
                in.beginArray();
                while (in.hasNext()) {
                    in.beginArray();
                    key = this.keyTypeAdapter.read(in);
                    if (map.put(key, this.valueTypeAdapter.read(in)) != null) {
                        throw new JsonSyntaxException("duplicate key: " + key);
                    }
                    in.endArray();
                }
                in.endArray();
                return map;
            }
            in.beginObject();
            while (in.hasNext()) {
                JsonReaderInternalAccess.INSTANCE.promoteNameToValue(in);
                key = this.keyTypeAdapter.read(in);
                if (map.put(key, this.valueTypeAdapter.read(in)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + key);
                }
            }
            in.endObject();
            return map;
        }

        public void write(JsonWriter out, Map map) {
            if (map == null) {
                out.nullValue();
            } else if (MapTypeAdapterFactory.this.complexMapKeySerialization) {
                boolean hasComplexKeys = false;
                List keys = new ArrayList(map.size());
                List values = new ArrayList(map.size());
                for (Entry entry : map.entrySet()) {
                    JsonElement keyElement = this.keyTypeAdapter.toJsonTree(entry.getKey());
                    keys.add(keyElement);
                    values.add(entry.getValue());
                    int i = (keyElement.isJsonArray() || keyElement.isJsonObject()) ? 1 : 0;
                    hasComplexKeys |= i;
                }
                int i2;
                if (hasComplexKeys) {
                    out.beginArray();
                    for (i2 = 0; i2 < keys.size(); i2++) {
                        out.beginArray();
                        Streams.write((JsonElement) keys.get(i2), out);
                        this.valueTypeAdapter.write(out, values.get(i2));
                        out.endArray();
                    }
                    out.endArray();
                    return;
                }
                out.beginObject();
                for (i2 = 0; i2 < keys.size(); i2++) {
                    out.name(keyToString((JsonElement) keys.get(i2)));
                    this.valueTypeAdapter.write(out, values.get(i2));
                }
                out.endObject();
            } else {
                out.beginObject();
                for (Entry entry2 : map.entrySet()) {
                    out.name(String.valueOf(entry2.getKey()));
                    this.valueTypeAdapter.write(out, entry2.getValue());
                }
                out.endObject();
            }
        }

        private String keyToString(JsonElement keyElement) {
            if (keyElement.isJsonPrimitive()) {
                JsonPrimitive primitive = keyElement.getAsJsonPrimitive();
                if (primitive.isNumber()) {
                    return String.valueOf(primitive.getAsNumber());
                }
                if (primitive.isBoolean()) {
                    return Boolean.toString(primitive.getAsBoolean());
                }
                if (primitive.isString()) {
                    return primitive.getAsString();
                }
                throw new AssertionError();
            } else if (keyElement.isJsonNull()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor, boolean complexMapKeySerialization) {
        this.constructorConstructor = constructorConstructor;
        this.complexMapKeySerialization = complexMapKeySerialization;
    }

    public TypeAdapter create(Gson gson, TypeToken typeToken) {
        Type type = typeToken.getType();
        if (!Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        Type[] keyAndValueTypes = C$Gson$Types.getMapKeyAndValueTypes(type, C$Gson$Types.getRawType(type));
        return new Adapter(gson, keyAndValueTypes[0], getKeyAdapter(gson, keyAndValueTypes[0]), keyAndValueTypes[1], gson.getAdapter(TypeToken.get(keyAndValueTypes[1])), this.constructorConstructor.get(typeToken));
    }

    private TypeAdapter getKeyAdapter(Gson context, Type keyType) {
        return (keyType == Boolean.TYPE || keyType == Boolean.class) ? TypeAdapters.BOOLEAN_AS_STRING : context.getAdapter(TypeToken.get(keyType));
    }
}
