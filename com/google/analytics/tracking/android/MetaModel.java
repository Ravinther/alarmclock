package com.google.analytics.tracking.android;

import java.util.HashMap;
import java.util.Map;

class MetaModel {
    private Map f4210a;

    public interface Formatter {
        String m5761a(String str);
    }

    public static class MetaInfo {
        private final String f4207a;
        private final String f4208b;
        private final Formatter f4209c;

        public MetaInfo(String urlParam, String defaultValue, Formatter formatter) {
            this.f4207a = urlParam;
            this.f4208b = defaultValue;
            this.f4209c = formatter;
        }

        public String m5763a(String actualKey) {
            if (!actualKey.contains("*")) {
                return this.f4207a;
            }
            String param = this.f4207a;
            String[] splits = actualKey.split("\\*");
            if (splits.length <= 1) {
                return null;
            }
            try {
                return param + Integer.parseInt(splits[1]);
            } catch (NumberFormatException e) {
                Log.m5758h("Unable to parse slot for url parameter " + param);
                return null;
            }
        }

        public String m5762a() {
            return this.f4208b;
        }

        public Formatter m5764b() {
            return this.f4209c;
        }
    }

    MetaModel() {
        this.f4210a = new HashMap();
    }

    MetaInfo m5765a(String key) {
        if (key.startsWith("&")) {
            return new MetaInfo(key.substring(1), null, null);
        }
        String tmpKey = key;
        if (key.contains("*")) {
            tmpKey = key.substring(0, key.indexOf("*"));
        }
        return (MetaInfo) this.f4210a.get(tmpKey);
    }

    public void m5766a(String key, String urlParam, String defaultValue, Formatter formatter) {
        this.f4210a.put(key, new MetaInfo(urlParam, defaultValue, formatter));
    }
}
