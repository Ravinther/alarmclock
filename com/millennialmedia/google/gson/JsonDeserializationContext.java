package com.millennialmedia.google.gson;

import java.lang.reflect.Type;

public interface JsonDeserializationContext {
    Object deserialize(JsonElement jsonElement, Type type);
}
