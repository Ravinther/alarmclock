package com.millennialmedia.google.gson;

import com.millennialmedia.google.gson.internal.bind.JsonTreeReader;
import com.millennialmedia.google.gson.internal.bind.JsonTreeWriter;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.JsonWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public abstract class TypeAdapter {

    /* renamed from: com.millennialmedia.google.gson.TypeAdapter.1 */
    class C25361 extends TypeAdapter {
        C25361() {
        }

        public void write(JsonWriter out, Object value) {
            if (value == null) {
                out.nullValue();
            } else {
                TypeAdapter.this.write(out, value);
            }
        }

        public Object read(JsonReader reader) {
            if (reader.peek() != JsonToken.NULL) {
                return TypeAdapter.this.read(reader);
            }
            reader.nextNull();
            return null;
        }
    }

    public abstract Object read(JsonReader jsonReader);

    public abstract void write(JsonWriter jsonWriter, Object obj);

    public final void toJson(Writer out, Object value) {
        write(new JsonWriter(out), value);
    }

    public final TypeAdapter nullSafe() {
        return new C25361();
    }

    public final String toJson(Object value) {
        StringWriter stringWriter = new StringWriter();
        toJson(stringWriter, value);
        return stringWriter.toString();
    }

    public final JsonElement toJsonTree(Object value) {
        try {
            JsonTreeWriter jsonWriter = new JsonTreeWriter();
            write(jsonWriter, value);
            return jsonWriter.get();
        } catch (Throwable e) {
            throw new JsonIOException(e);
        }
    }

    public final Object fromJson(Reader in) {
        return read(new JsonReader(in));
    }

    public final Object fromJson(String json) {
        return fromJson(new StringReader(json));
    }

    public final Object fromJsonTree(JsonElement jsonTree) {
        try {
            return read(new JsonTreeReader(jsonTree));
        } catch (Throwable e) {
            throw new JsonIOException(e);
        }
    }
}
