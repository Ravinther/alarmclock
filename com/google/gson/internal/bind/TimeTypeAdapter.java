package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class TimeTypeAdapter extends TypeAdapter {
    public static final TypeAdapterFactory FACTORY;
    private final DateFormat format;

    /* renamed from: com.google.gson.internal.bind.TimeTypeAdapter.1 */
    static class C24201 implements TypeAdapterFactory {
        C24201() {
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            return typeToken.getRawType() == Time.class ? new TimeTypeAdapter() : null;
        }
    }

    public TimeTypeAdapter() {
        this.format = new SimpleDateFormat("hh:mm:ss a");
    }

    static {
        FACTORY = new C24201();
    }

    public synchronized Time read(JsonReader in) {
        Time time;
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            time = null;
        } else {
            try {
                time = new Time(this.format.parse(in.nextString()).getTime());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }
        return time;
    }

    public synchronized void write(JsonWriter out, Time value) {
        out.value(value == null ? null : this.format.format(value));
    }
}
