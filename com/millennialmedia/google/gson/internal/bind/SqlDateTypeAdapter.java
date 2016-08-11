package com.millennialmedia.google.gson.internal.bind;

import com.millennialmedia.google.gson.Gson;
import com.millennialmedia.google.gson.JsonSyntaxException;
import com.millennialmedia.google.gson.TypeAdapter;
import com.millennialmedia.google.gson.TypeAdapterFactory;
import com.millennialmedia.google.gson.reflect.TypeToken;
import com.millennialmedia.google.gson.stream.JsonReader;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.JsonWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class SqlDateTypeAdapter extends TypeAdapter {
    public static final TypeAdapterFactory FACTORY;
    private final DateFormat format;

    /* renamed from: com.millennialmedia.google.gson.internal.bind.SqlDateTypeAdapter.1 */
    static class C25621 implements TypeAdapterFactory {
        C25621() {
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            return typeToken.getRawType() == Date.class ? new SqlDateTypeAdapter() : null;
        }
    }

    public SqlDateTypeAdapter() {
        this.format = new SimpleDateFormat("MMM d, yyyy");
    }

    static {
        FACTORY = new C25621();
    }

    public synchronized Date read(JsonReader in) {
        Date date;
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            date = null;
        } else {
            try {
                date = new Date(this.format.parse(in.nextString()).getTime());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
        return date;
    }

    public synchronized void write(JsonWriter out, Date value) {
        out.value(value == null ? null : this.format.format(value));
    }
}
