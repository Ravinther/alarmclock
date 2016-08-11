package com.mopub.nativeads;

import java.util.HashMap;
import java.util.Map;

public final class ViewBinder {
    final int callToActionId;
    final Map extras;
    final int iconImageId;
    final int layoutId;
    final int mainImageId;
    final int textId;
    final int titleId;

    public static final class Builder {
        private int callToActionId;
        private Map extras;
        private int iconImageId;
        private final int layoutId;
        private int mainImageId;
        private int textId;
        private int titleId;

        public Builder(int layoutId) {
            this.layoutId = layoutId;
            this.extras = new HashMap();
        }

        public final Builder titleId(int titleId) {
            this.titleId = titleId;
            return this;
        }

        public final Builder textId(int textId) {
            this.textId = textId;
            return this;
        }

        public final Builder callToActionId(int callToActionId) {
            this.callToActionId = callToActionId;
            return this;
        }

        public final Builder mainImageId(int mainImageId) {
            this.mainImageId = mainImageId;
            return this;
        }

        public final Builder iconImageId(int iconImageId) {
            this.iconImageId = iconImageId;
            return this;
        }

        public final Builder addExtras(Map resourceIds) {
            this.extras = new HashMap(resourceIds);
            return this;
        }

        public final Builder addExtra(String key, int resourceId) {
            this.extras.put(key, Integer.valueOf(resourceId));
            return this;
        }

        public final ViewBinder build() {
            return new ViewBinder();
        }
    }

    private ViewBinder(Builder builder) {
        this.layoutId = builder.layoutId;
        this.titleId = builder.titleId;
        this.textId = builder.textId;
        this.callToActionId = builder.callToActionId;
        this.mainImageId = builder.mainImageId;
        this.iconImageId = builder.iconImageId;
        this.extras = builder.extras;
    }
}
