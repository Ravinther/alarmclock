package com.millennialmedia.google.gson;

import com.millennialmedia.google.gson.internal.C$Gson$Preconditions;
import com.millennialmedia.google.gson.internal.Streams;
import com.millennialmedia.google.gson.reflect.TypeToken;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonWriter;

final class TreeTypeAdapter extends TypeAdapter {
    private TypeAdapter delegate;
    private final JsonDeserializer deserializer;
    private final Gson gson;
    private final JsonSerializer serializer;
    private final TypeAdapterFactory skipPast;
    private final TypeToken typeToken;

    private static class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonDeserializer deserializer;
        private final TypeToken exactType;
        private final Class hierarchyType;
        private final boolean matchRawType;
        private final JsonSerializer serializer;

        private SingleTypeFactory(Object typeAdapter, TypeToken exactType, boolean matchRawType, Class hierarchyType) {
            JsonSerializer jsonSerializer;
            if (typeAdapter instanceof JsonSerializer) {
                jsonSerializer = (JsonSerializer) typeAdapter;
            } else {
                jsonSerializer = null;
            }
            this.serializer = jsonSerializer;
            if (typeAdapter instanceof JsonDeserializer) {
                typeAdapter = (JsonDeserializer) typeAdapter;
            } else {
                typeAdapter = null;
            }
            this.deserializer = typeAdapter;
            boolean z = (this.serializer == null && this.deserializer == null) ? false : true;
            C$Gson$Preconditions.checkArgument(z);
            this.exactType = exactType;
            this.matchRawType = matchRawType;
            this.hierarchyType = hierarchyType;
        }

        public TypeAdapter create(Gson gson, TypeToken type) {
            boolean matches = this.exactType != null ? this.exactType.equals(type) || (this.matchRawType && this.exactType.getType() == type.getRawType()) : this.hierarchyType.isAssignableFrom(type.getRawType());
            if (matches) {
                return new TreeTypeAdapter(this.deserializer, gson, type, this, null);
            }
            return null;
        }
    }

    private TreeTypeAdapter(JsonSerializer serializer, JsonDeserializer deserializer, Gson gson, TypeToken typeToken, TypeAdapterFactory skipPast) {
        this.serializer = serializer;
        this.deserializer = deserializer;
        this.gson = gson;
        this.typeToken = typeToken;
        this.skipPast = skipPast;
    }

    public Object read(JsonReader in) {
        if (this.deserializer == null) {
            return delegate().read(in);
        }
        JsonElement value = Streams.parse(in);
        if (value.isJsonNull()) {
            return null;
        }
        return this.deserializer.deserialize(value, this.typeToken.getType(), this.gson.deserializationContext);
    }

    public void write(JsonWriter out, Object value) {
        if (this.serializer == null) {
            delegate().write(out, value);
        } else if (value == null) {
            out.nullValue();
        } else {
            Streams.write(this.serializer.serialize(value, this.typeToken.getType(), this.gson.serializationContext), out);
        }
    }

    private TypeAdapter delegate() {
        TypeAdapter d = this.delegate;
        if (d != null) {
            return d;
        }
        d = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = d;
        return d;
    }

    public static TypeAdapterFactory newFactory(TypeToken exactType, Object typeAdapter) {
        return new SingleTypeFactory(exactType, false, null, null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken exactType, Object typeAdapter) {
        return new SingleTypeFactory(exactType, exactType.getType() == exactType.getRawType(), null, null);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class hierarchyType, Object typeAdapter) {
        return new SingleTypeFactory(null, false, hierarchyType, null);
    }
}
