package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.UUID;

public final class TypeAdapters {
    public static final TypeAdapter BIG_DECIMAL;
    public static final TypeAdapter BIG_INTEGER;
    public static final TypeAdapter BIT_SET;
    public static final TypeAdapterFactory BIT_SET_FACTORY;
    public static final TypeAdapter BOOLEAN;
    public static final TypeAdapter BOOLEAN_AS_STRING;
    public static final TypeAdapterFactory BOOLEAN_FACTORY;
    public static final TypeAdapter BYTE;
    public static final TypeAdapterFactory BYTE_FACTORY;
    public static final TypeAdapter CALENDAR;
    public static final TypeAdapterFactory CALENDAR_FACTORY;
    public static final TypeAdapter CHARACTER;
    public static final TypeAdapterFactory CHARACTER_FACTORY;
    public static final TypeAdapter CLASS;
    public static final TypeAdapterFactory CLASS_FACTORY;
    public static final TypeAdapter DOUBLE;
    public static final TypeAdapterFactory ENUM_FACTORY;
    public static final TypeAdapter FLOAT;
    public static final TypeAdapter INET_ADDRESS;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
    public static final TypeAdapter INTEGER;
    public static final TypeAdapterFactory INTEGER_FACTORY;
    public static final TypeAdapter JSON_ELEMENT;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
    public static final TypeAdapter LOCALE;
    public static final TypeAdapterFactory LOCALE_FACTORY;
    public static final TypeAdapter LONG;
    public static final TypeAdapter NUMBER;
    public static final TypeAdapterFactory NUMBER_FACTORY;
    public static final TypeAdapter SHORT;
    public static final TypeAdapterFactory SHORT_FACTORY;
    public static final TypeAdapter STRING;
    public static final TypeAdapter STRING_BUFFER;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
    public static final TypeAdapter STRING_BUILDER;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
    public static final TypeAdapterFactory STRING_FACTORY;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY;
    public static final TypeAdapter URI;
    public static final TypeAdapterFactory URI_FACTORY;
    public static final TypeAdapter URL;
    public static final TypeAdapterFactory URL_FACTORY;
    public static final TypeAdapter UUID;
    public static final TypeAdapterFactory UUID_FACTORY;

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.1 */
    static class C24211 extends TypeAdapter {
        C24211() {
        }

        public void write(JsonWriter out, Class value) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + value.getName() + ". Forgot to register a type adapter?");
        }

        public Class read(JsonReader in) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.27 */
    static class AnonymousClass27 implements TypeAdapterFactory {
        final /* synthetic */ TypeToken val$type;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        AnonymousClass27(TypeToken typeToken, TypeAdapter typeAdapter) {
            this.val$type = typeToken;
            this.val$typeAdapter = typeAdapter;
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            return typeToken.equals(this.val$type) ? this.val$typeAdapter : null;
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.28 */
    static class AnonymousClass28 implements TypeAdapterFactory {
        final /* synthetic */ Class val$type;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        AnonymousClass28(Class cls, TypeAdapter typeAdapter) {
            this.val$type = cls;
            this.val$typeAdapter = typeAdapter;
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            return typeToken.getRawType() == this.val$type ? this.val$typeAdapter : null;
        }

        public String toString() {
            return "Factory[type=" + this.val$type.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.29 */
    static class AnonymousClass29 implements TypeAdapterFactory {
        final /* synthetic */ Class val$boxed;
        final /* synthetic */ TypeAdapter val$typeAdapter;
        final /* synthetic */ Class val$unboxed;

        AnonymousClass29(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.val$unboxed = cls;
            this.val$boxed = cls2;
            this.val$typeAdapter = typeAdapter;
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            Class rawType = typeToken.getRawType();
            return (rawType == this.val$unboxed || rawType == this.val$boxed) ? this.val$typeAdapter : null;
        }

        public String toString() {
            return "Factory[type=" + this.val$boxed.getName() + "+" + this.val$unboxed.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.2 */
    static class C24232 extends TypeAdapter {
        C24232() {
        }

        public BitSet read(JsonReader in) {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            BitSet bitset = new BitSet();
            in.beginArray();
            int i = 0;
            JsonToken tokenType = in.peek();
            while (tokenType != JsonToken.END_ARRAY) {
                boolean set;
                switch (AnonymousClass32.$SwitchMap$com$google$gson$stream$JsonToken[tokenType.ordinal()]) {
                    case Base64.NO_PADDING /*1*/:
                        if (in.nextInt() == 0) {
                            set = false;
                            break;
                        }
                        set = true;
                        break;
                    case Base64.NO_WRAP /*2*/:
                        set = in.nextBoolean();
                        break;
                    case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        String stringValue = in.nextString();
                        try {
                            set = Integer.parseInt(stringValue) != 0;
                            break;
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + stringValue);
                        }
                    default:
                        throw new JsonSyntaxException("Invalid bitset value type: " + tokenType);
                }
                if (set) {
                    bitset.set(i);
                }
                i++;
                tokenType = in.peek();
            }
            in.endArray();
            return bitset;
        }

        public void write(JsonWriter out, BitSet src) {
            if (src == null) {
                out.nullValue();
                return;
            }
            out.beginArray();
            for (int i = 0; i < src.length(); i++) {
                out.value((long) (src.get(i) ? 1 : 0));
            }
            out.endArray();
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.30 */
    static class AnonymousClass30 implements TypeAdapterFactory {
        final /* synthetic */ Class val$base;
        final /* synthetic */ Class val$sub;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        AnonymousClass30(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.val$base = cls;
            this.val$sub = cls2;
            this.val$typeAdapter = typeAdapter;
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            Class rawType = typeToken.getRawType();
            return (rawType == this.val$base || rawType == this.val$sub) ? this.val$typeAdapter : null;
        }

        public String toString() {
            return "Factory[type=" + this.val$base.getName() + "+" + this.val$sub.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.31 */
    static class AnonymousClass31 implements TypeAdapterFactory {
        final /* synthetic */ Class val$clazz;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        AnonymousClass31(Class cls, TypeAdapter typeAdapter) {
            this.val$clazz = cls;
            this.val$typeAdapter = typeAdapter;
        }

        public TypeAdapter create(Gson gson, TypeToken typeToken) {
            return this.val$clazz.isAssignableFrom(typeToken.getRawType()) ? this.val$typeAdapter : null;
        }

        public String toString() {
            return "Factory[typeHierarchy=" + this.val$clazz.getName() + ",adapter=" + this.val$typeAdapter + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.32 */
    static /* synthetic */ class AnonymousClass32 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            $SwitchMap$com$google$gson$stream$JsonToken = new int[JsonToken.values().length];
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.3 */
    static class C24243 extends TypeAdapter {
        C24243() {
        }

        public Boolean read(JsonReader in) {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            } else if (in.peek() == JsonToken.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(in.nextString()));
            } else {
                return Boolean.valueOf(in.nextBoolean());
            }
        }

        public void write(JsonWriter out, Boolean value) {
            if (value == null) {
                out.nullValue();
            } else {
                out.value(value.booleanValue());
            }
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.4 */
    static class C24254 extends TypeAdapter {
        C24254() {
        }

        public Boolean read(JsonReader in) {
            if (in.peek() != JsonToken.NULL) {
                return Boolean.valueOf(in.nextString());
            }
            in.nextNull();
            return null;
        }

        public void write(JsonWriter out, Boolean value) {
            out.value(value == null ? "null" : value.toString());
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.5 */
    static class C24265 extends TypeAdapter {
        C24265() {
        }

        public Number read(JsonReader in) {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            try {
                return Byte.valueOf((byte) in.nextInt());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }

        public void write(JsonWriter out, Number value) {
            out.value(value);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.6 */
    static class C24276 extends TypeAdapter {
        C24276() {
        }

        public Number read(JsonReader in) {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) in.nextInt());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }

        public void write(JsonWriter out, Number value) {
            out.value(value);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.7 */
    static class C24287 extends TypeAdapter {
        C24287() {
        }

        public Number read(JsonReader in) {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(in.nextInt());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }

        public void write(JsonWriter out, Number value) {
            out.value(value);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.8 */
    static class C24298 extends TypeAdapter {
        C24298() {
        }

        public Number read(JsonReader in) {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            try {
                return Long.valueOf(in.nextLong());
            } catch (Throwable e) {
                throw new JsonSyntaxException(e);
            }
        }

        public void write(JsonWriter out, Number value) {
            out.value(value);
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters.9 */
    static class C24309 extends TypeAdapter {
        C24309() {
        }

        public Number read(JsonReader in) {
            if (in.peek() != JsonToken.NULL) {
                return Float.valueOf((float) in.nextDouble());
            }
            in.nextNull();
            return null;
        }

        public void write(JsonWriter out, Number value) {
            out.value(value);
        }
    }

    private static final class EnumTypeAdapter extends TypeAdapter {
        private final Map constantToName;
        private final Map nameToConstant;

        public EnumTypeAdapter(Class classOfT) {
            this.nameToConstant = new HashMap();
            this.constantToName = new HashMap();
            try {
                for (Enum constant : (Enum[]) classOfT.getEnumConstants()) {
                    String name = constant.name();
                    SerializedName annotation = (SerializedName) classOfT.getField(name).getAnnotation(SerializedName.class);
                    if (annotation != null) {
                        name = annotation.value();
                    }
                    this.nameToConstant.put(name, constant);
                    this.constantToName.put(constant, name);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError();
            }
        }

        public Enum read(JsonReader in) {
            if (in.peek() != JsonToken.NULL) {
                return (Enum) this.nameToConstant.get(in.nextString());
            }
            in.nextNull();
            return null;
        }

        public void write(JsonWriter out, Enum value) {
            out.value(value == null ? null : (String) this.constantToName.get(value));
        }
    }

    private TypeAdapters() {
    }

    static {
        CLASS = new C24211();
        CLASS_FACTORY = newFactory(Class.class, CLASS);
        BIT_SET = new C24232();
        BIT_SET_FACTORY = newFactory(BitSet.class, BIT_SET);
        BOOLEAN = new C24243();
        BOOLEAN_AS_STRING = new C24254();
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, BOOLEAN);
        BYTE = new C24265();
        BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, BYTE);
        SHORT = new C24276();
        SHORT_FACTORY = newFactory(Short.TYPE, Short.class, SHORT);
        INTEGER = new C24287();
        INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, INTEGER);
        LONG = new C24298();
        FLOAT = new C24309();
        DOUBLE = new TypeAdapter() {
            public Number read(JsonReader in) {
                if (in.peek() != JsonToken.NULL) {
                    return Double.valueOf(in.nextDouble());
                }
                in.nextNull();
                return null;
            }

            public void write(JsonWriter out, Number value) {
                out.value(value);
            }
        };
        NUMBER = new TypeAdapter() {
            public Number read(JsonReader in) {
                JsonToken jsonToken = in.peek();
                switch (AnonymousClass32.$SwitchMap$com$google$gson$stream$JsonToken[jsonToken.ordinal()]) {
                    case Base64.NO_PADDING /*1*/:
                        return new LazilyParsedNumber(in.nextString());
                    case Base64.CRLF /*4*/:
                        in.nextNull();
                        return null;
                    default:
                        throw new JsonSyntaxException("Expecting number, got: " + jsonToken);
                }
            }

            public void write(JsonWriter out, Number value) {
                out.value(value);
            }
        };
        NUMBER_FACTORY = newFactory(Number.class, NUMBER);
        CHARACTER = new TypeAdapter() {
            public Character read(JsonReader in) {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                String str = in.nextString();
                if (str.length() == 1) {
                    return Character.valueOf(str.charAt(0));
                }
                throw new JsonSyntaxException("Expecting character, got: " + str);
            }

            public void write(JsonWriter out, Character value) {
                out.value(value == null ? null : String.valueOf(value));
            }
        };
        CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, CHARACTER);
        STRING = new TypeAdapter() {
            public String read(JsonReader in) {
                JsonToken peek = in.peek();
                if (peek == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                } else if (peek == JsonToken.BOOLEAN) {
                    return Boolean.toString(in.nextBoolean());
                } else {
                    return in.nextString();
                }
            }

            public void write(JsonWriter out, String value) {
                out.value(value);
            }
        };
        BIG_DECIMAL = new TypeAdapter() {
            public BigDecimal read(JsonReader in) {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                try {
                    return new BigDecimal(in.nextString());
                } catch (Throwable e) {
                    throw new JsonSyntaxException(e);
                }
            }

            public void write(JsonWriter out, BigDecimal value) {
                out.value((Number) value);
            }
        };
        BIG_INTEGER = new TypeAdapter() {
            public BigInteger read(JsonReader in) {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                try {
                    return new BigInteger(in.nextString());
                } catch (Throwable e) {
                    throw new JsonSyntaxException(e);
                }
            }

            public void write(JsonWriter out, BigInteger value) {
                out.value((Number) value);
            }
        };
        STRING_FACTORY = newFactory(String.class, STRING);
        STRING_BUILDER = new TypeAdapter() {
            public StringBuilder read(JsonReader in) {
                if (in.peek() != JsonToken.NULL) {
                    return new StringBuilder(in.nextString());
                }
                in.nextNull();
                return null;
            }

            public void write(JsonWriter out, StringBuilder value) {
                out.value(value == null ? null : value.toString());
            }
        };
        STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, STRING_BUILDER);
        STRING_BUFFER = new TypeAdapter() {
            public StringBuffer read(JsonReader in) {
                if (in.peek() != JsonToken.NULL) {
                    return new StringBuffer(in.nextString());
                }
                in.nextNull();
                return null;
            }

            public void write(JsonWriter out, StringBuffer value) {
                out.value(value == null ? null : value.toString());
            }
        };
        STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, STRING_BUFFER);
        URL = new TypeAdapter() {
            public URL read(JsonReader in) {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                String nextString = in.nextString();
                if ("null".equals(nextString)) {
                    return null;
                }
                return new URL(nextString);
            }

            public void write(JsonWriter out, URL value) {
                out.value(value == null ? null : value.toExternalForm());
            }
        };
        URL_FACTORY = newFactory(URL.class, URL);
        URI = new TypeAdapter() {
            public URI read(JsonReader in) {
                URI uri = null;
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                } else {
                    try {
                        String nextString = in.nextString();
                        if (!"null".equals(nextString)) {
                            uri = new URI(nextString);
                        }
                    } catch (Throwable e) {
                        throw new JsonIOException(e);
                    }
                }
                return uri;
            }

            public void write(JsonWriter out, URI value) {
                out.value(value == null ? null : value.toASCIIString());
            }
        };
        URI_FACTORY = newFactory(URI.class, URI);
        INET_ADDRESS = new TypeAdapter() {
            public InetAddress read(JsonReader in) {
                if (in.peek() != JsonToken.NULL) {
                    return InetAddress.getByName(in.nextString());
                }
                in.nextNull();
                return null;
            }

            public void write(JsonWriter out, InetAddress value) {
                out.value(value == null ? null : value.getHostAddress());
            }
        };
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, INET_ADDRESS);
        UUID = new TypeAdapter() {
            public UUID read(JsonReader in) {
                if (in.peek() != JsonToken.NULL) {
                    return UUID.fromString(in.nextString());
                }
                in.nextNull();
                return null;
            }

            public void write(JsonWriter out, UUID value) {
                out.value(value == null ? null : value.toString());
            }
        };
        UUID_FACTORY = newFactory(UUID.class, UUID);
        TIMESTAMP_FACTORY = new TypeAdapterFactory() {

            /* renamed from: com.google.gson.internal.bind.TypeAdapters.22.1 */
            class C24221 extends TypeAdapter {
                final /* synthetic */ TypeAdapter val$dateTypeAdapter;

                C24221(TypeAdapter typeAdapter) {
                    this.val$dateTypeAdapter = typeAdapter;
                }

                public Timestamp read(JsonReader in) {
                    Date date = (Date) this.val$dateTypeAdapter.read(in);
                    return date != null ? new Timestamp(date.getTime()) : null;
                }

                public void write(JsonWriter out, Timestamp value) {
                    this.val$dateTypeAdapter.write(out, value);
                }
            }

            public TypeAdapter create(Gson gson, TypeToken typeToken) {
                if (typeToken.getRawType() != Timestamp.class) {
                    return null;
                }
                return new C24221(gson.getAdapter(Date.class));
            }
        };
        CALENDAR = new TypeAdapter() {
            private static final String DAY_OF_MONTH = "dayOfMonth";
            private static final String HOUR_OF_DAY = "hourOfDay";
            private static final String MINUTE = "minute";
            private static final String MONTH = "month";
            private static final String SECOND = "second";
            private static final String YEAR = "year";

            public Calendar read(JsonReader in) {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                in.beginObject();
                int year = 0;
                int month = 0;
                int dayOfMonth = 0;
                int hourOfDay = 0;
                int minute = 0;
                int second = 0;
                while (in.peek() != JsonToken.END_OBJECT) {
                    String name = in.nextName();
                    int value = in.nextInt();
                    if (YEAR.equals(name)) {
                        year = value;
                    } else if (MONTH.equals(name)) {
                        month = value;
                    } else if (DAY_OF_MONTH.equals(name)) {
                        dayOfMonth = value;
                    } else if (HOUR_OF_DAY.equals(name)) {
                        hourOfDay = value;
                    } else if (MINUTE.equals(name)) {
                        minute = value;
                    } else if (SECOND.equals(name)) {
                        second = value;
                    }
                }
                in.endObject();
                return new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute, second);
            }

            public void write(JsonWriter out, Calendar value) {
                if (value == null) {
                    out.nullValue();
                    return;
                }
                out.beginObject();
                out.name(YEAR);
                out.value((long) value.get(1));
                out.name(MONTH);
                out.value((long) value.get(2));
                out.name(DAY_OF_MONTH);
                out.value((long) value.get(5));
                out.name(HOUR_OF_DAY);
                out.value((long) value.get(11));
                out.name(MINUTE);
                out.value((long) value.get(12));
                out.name(SECOND);
                out.value((long) value.get(13));
                out.endObject();
            }
        };
        CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, CALENDAR);
        LOCALE = new TypeAdapter() {
            public Locale read(JsonReader in) {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return null;
                }
                StringTokenizer tokenizer = new StringTokenizer(in.nextString(), "_");
                String language = null;
                String country = null;
                String variant = null;
                if (tokenizer.hasMoreElements()) {
                    language = tokenizer.nextToken();
                }
                if (tokenizer.hasMoreElements()) {
                    country = tokenizer.nextToken();
                }
                if (tokenizer.hasMoreElements()) {
                    variant = tokenizer.nextToken();
                }
                if (country == null && variant == null) {
                    return new Locale(language);
                }
                if (variant == null) {
                    return new Locale(language, country);
                }
                return new Locale(language, country, variant);
            }

            public void write(JsonWriter out, Locale value) {
                out.value(value == null ? null : value.toString());
            }
        };
        LOCALE_FACTORY = newFactory(Locale.class, LOCALE);
        JSON_ELEMENT = new TypeAdapter() {
            public JsonElement read(JsonReader in) {
                switch (AnonymousClass32.$SwitchMap$com$google$gson$stream$JsonToken[in.peek().ordinal()]) {
                    case Base64.NO_PADDING /*1*/:
                        return new JsonPrimitive(new LazilyParsedNumber(in.nextString()));
                    case Base64.NO_WRAP /*2*/:
                        return new JsonPrimitive(Boolean.valueOf(in.nextBoolean()));
                    case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        return new JsonPrimitive(in.nextString());
                    case Base64.CRLF /*4*/:
                        in.nextNull();
                        return JsonNull.INSTANCE;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        JsonElement array = new JsonArray();
                        in.beginArray();
                        while (in.hasNext()) {
                            array.add(read(in));
                        }
                        in.endArray();
                        return array;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        JsonElement object = new JsonObject();
                        in.beginObject();
                        while (in.hasNext()) {
                            object.add(in.nextName(), read(in));
                        }
                        in.endObject();
                        return object;
                    default:
                        throw new IllegalArgumentException();
                }
            }

            public void write(JsonWriter out, JsonElement value) {
                if (value == null || value.isJsonNull()) {
                    out.nullValue();
                } else if (value.isJsonPrimitive()) {
                    JsonPrimitive primitive = value.getAsJsonPrimitive();
                    if (primitive.isNumber()) {
                        out.value(primitive.getAsNumber());
                    } else if (primitive.isBoolean()) {
                        out.value(primitive.getAsBoolean());
                    } else {
                        out.value(primitive.getAsString());
                    }
                } else if (value.isJsonArray()) {
                    out.beginArray();
                    i$ = value.getAsJsonArray().iterator();
                    while (i$.hasNext()) {
                        write(out, (JsonElement) i$.next());
                    }
                    out.endArray();
                } else if (value.isJsonObject()) {
                    out.beginObject();
                    for (Entry e : value.getAsJsonObject().entrySet()) {
                        out.name((String) e.getKey());
                        write(out, (JsonElement) e.getValue());
                    }
                    out.endObject();
                } else {
                    throw new IllegalArgumentException("Couldn't write " + value.getClass());
                }
            }
        };
        JSON_ELEMENT_FACTORY = newFactory(JsonElement.class, JSON_ELEMENT);
        ENUM_FACTORY = newEnumTypeHierarchyFactory();
    }

    public static TypeAdapterFactory newEnumTypeHierarchyFactory() {
        return new TypeAdapterFactory() {
            public TypeAdapter create(Gson gson, TypeToken typeToken) {
                Class rawType = typeToken.getRawType();
                if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                    return null;
                }
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }
                return new EnumTypeAdapter(rawType);
            }
        };
    }

    public static TypeAdapterFactory newFactory(TypeToken type, TypeAdapter typeAdapter) {
        return new AnonymousClass27(type, typeAdapter);
    }

    public static TypeAdapterFactory newFactory(Class type, TypeAdapter typeAdapter) {
        return new AnonymousClass28(type, typeAdapter);
    }

    public static TypeAdapterFactory newFactory(Class unboxed, Class boxed, TypeAdapter typeAdapter) {
        return new AnonymousClass29(unboxed, boxed, typeAdapter);
    }

    public static TypeAdapterFactory newFactoryForMultipleTypes(Class base, Class sub, TypeAdapter typeAdapter) {
        return new AnonymousClass30(base, sub, typeAdapter);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class clazz, TypeAdapter typeAdapter) {
        return new AnonymousClass31(clazz, typeAdapter);
    }
}
