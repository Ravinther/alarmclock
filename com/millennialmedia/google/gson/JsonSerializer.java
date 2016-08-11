package com.millennialmedia.google.gson;

import java.lang.reflect.Type;

public interface JsonSerializer {
    JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonSerializationContext);
}
