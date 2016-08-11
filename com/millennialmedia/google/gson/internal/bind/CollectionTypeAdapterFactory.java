package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.Gson;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.TypeAdapterFactory;
import com.millennialmedia.google.gson.internal.C$Gson$Types;
import com.millennialmedia.google.gson.internal.ConstructorConstructor;
import com.millennialmedia.google.gson.internal.ObjectConstructor;
import com.millennialmedia.google.gson.reflect.TypeToken;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.Collection;

public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    private static final class Adapter extends TypeAdapter {
        private final ObjectConstructor constructor;
        private final TypeAdapter elementTypeAdapter;

        public Adapter(Gson context, Type elementType, TypeAdapter elementTypeAdapter, ObjectConstructor constructor) {
            this.elementTypeAdapter = new TypeAdapterRuntimeTypeWrapper(context, elementTypeAdapter, elementType);
            this.constructor = constructor;
        }

        public Collection read(JsonReader in) {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            Collection collection = (Collection) this.constructor.construct();
            in.beginArray();
            while (in.hasNext()) {
                collection.add(this.elementTypeAdapter.read(in));
            }
            in.endArray();
            return collection;
        }

        public void write(JsonWriter out, Collection collection) {
            if (collection == null) {
                out.nullValue();
                return;
            }
            out.beginArray();
            for (Object element : collection) {
                this.elementTypeAdapter.write(out, element);
            }
            out.endArray();
        }
    }

    public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }

    public TypeAdapter create(Gson gson, TypeToken typeToken) {
        Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type elementType = C$Gson$Types.getCollectionElementType(type, rawType);
        return new Adapter(gson, elementType, gson.getAdapter(TypeToken.get(elementType)), this.constructorConstructor.get(typeToken));
    }
}
