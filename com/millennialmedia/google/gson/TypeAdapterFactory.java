package com.millennialmedia.google.gson;

import com.millennialmedia.google.gson.reflect.TypeToken;

public interface TypeAdapterFactory {
    TypeAdapter create(Gson gson, TypeToken typeToken);
}
