package com.mopub.common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Json {
    public static Map jsonStringToMap(String jsonParams) {
        Map jsonMap = new HashMap();
        if (!(jsonParams == null || jsonParams.equals(""))) {
            JSONObject jsonObject = (JSONObject) new JSONTokener(jsonParams).nextValue();
            Iterator keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = (String) keys.next();
                jsonMap.put(key, jsonObject.getString(key));
            }
        }
        return jsonMap;
    }

    public static String mapToJsonString(Map map) {
        if (map == null) {
            return "{}";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        boolean first = true;
        for (Entry entry : map.entrySet()) {
            if (!first) {
                builder.append(",");
            }
            builder.append("\"");
            builder.append((String) entry.getKey());
            builder.append("\":\"");
            builder.append((String) entry.getValue());
            builder.append("\"");
            first = false;
        }
        builder.append("}");
        return builder.toString();
    }

    public static String[] jsonArrayToStringArray(String jsonString) {
        try {
            JSONArray jsonArray = ((JSONObject) new JSONTokener("{key:" + jsonString + "}").nextValue()).getJSONArray("key");
            String[] strArr = new String[jsonArray.length()];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = jsonArray.getString(i);
            }
            return strArr;
        } catch (JSONException e) {
            return new String[0];
        }
    }

    public static Object getJsonValue(JSONObject jsonObject, String key, Class valueClass) {
        if (jsonObject == null || key == null || valueClass == null) {
            throw new IllegalArgumentException("Cannot pass any null argument to getJsonValue");
        }
        Object object = jsonObject.opt(key);
        if (object == null) {
            MoPubLog.m9733w("Tried to get Json value with key: " + key + ", but it was null");
            return null;
        } else if (valueClass.isInstance(object)) {
            return valueClass.cast(object);
        } else {
            MoPubLog.m9733w("Tried to get Json value with key: " + key + ", of type: " + valueClass.toString() + ", its type did not match");
            return null;
        }
    }
}
