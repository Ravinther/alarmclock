package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.StringMap;
import java.util.Set;

public final class JsonObject extends JsonElement {
    private final StringMap members;

    public JsonObject() {
        this.members = new StringMap();
    }

    public void add(String property, JsonElement value) {
        Object value2;
        if (value == null) {
            value2 = JsonNull.INSTANCE;
        }
        this.members.put((String) C$Gson$Preconditions.checkNotNull(property), value2);
    }

    public JsonElement remove(String property) {
        return (JsonElement) this.members.remove(property);
    }

    public void addProperty(String property, String value) {
        add(property, createJsonElement(value));
    }

    public void addProperty(String property, Number value) {
        add(property, createJsonElement(value));
    }

    public void addProperty(String property, Boolean value) {
        add(property, createJsonElement(value));
    }

    public void addProperty(String property, Character value) {
        add(property, createJsonElement(value));
    }

    private JsonElement createJsonElement(Object value) {
        return value == null ? JsonNull.INSTANCE : new JsonPrimitive(value);
    }

    public Set entrySet() {
        return this.members.entrySet();
    }

    public boolean has(String memberName) {
        return this.members.containsKey(memberName);
    }

    public JsonElement get(String memberName) {
        if (!this.members.containsKey(memberName)) {
            return null;
        }
        JsonElement member = (JsonElement) this.members.get(memberName);
        if (member == null) {
            return JsonNull.INSTANCE;
        }
        return member;
    }

    public JsonPrimitive getAsJsonPrimitive(String memberName) {
        return (JsonPrimitive) this.members.get(memberName);
    }

    public JsonArray getAsJsonArray(String memberName) {
        return (JsonArray) this.members.get(memberName);
    }

    public JsonObject getAsJsonObject(String memberName) {
        return (JsonObject) this.members.get(memberName);
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof JsonObject) && ((JsonObject) o).members.equals(this.members));
    }

    public int hashCode() {
        return this.members.hashCode();
    }
}
