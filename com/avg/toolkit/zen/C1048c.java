package com.avg.toolkit.zen;

import com.millennialmedia.google.gson.GsonBuilder;
import com.millennialmedia.google.gson.JsonElement;
import com.millennialmedia.google.gson.JsonSerializationContext;
import com.millennialmedia.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Locale;

/* renamed from: com.avg.toolkit.zen.c */
public class C1048c {

    /* renamed from: com.avg.toolkit.zen.c.a */
    private static class C1047a implements JsonSerializer {
        private C1047a() {
        }

        public JsonElement serialize(Object arg0, Type arg1, JsonSerializationContext arg2) {
            String output;
            if ((arg0 instanceof Float) || (arg0 instanceof Double)) {
                output = String.format(Locale.US, "%.2f", new Object[]{arg0});
            } else {
                output = "" + arg0;
            }
            return arg2.serialize(output, String.class);
        }
    }

    public static GsonBuilder m4538a() {
        GsonBuilder builder = new GsonBuilder();
        C1047a customSerializer = new C1047a();
        builder.registerTypeAdapter(Integer.class, customSerializer);
        builder.registerTypeAdapter(Float.class, customSerializer);
        builder.registerTypeAdapter(Double.class, customSerializer);
        builder.registerTypeAdapter(Long.class, customSerializer);
        builder.registerTypeAdapter(Boolean.class, customSerializer);
        builder.registerTypeAdapter(Byte.class, customSerializer);
        builder.registerTypeAdapter(Short.class, customSerializer);
        builder.registerTypeAdapter(Character.class, customSerializer);
        return builder;
    }
}
