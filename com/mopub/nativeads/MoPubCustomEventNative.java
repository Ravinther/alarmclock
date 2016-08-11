package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.util.MoPubLog;
import com.mopub.common.util.Numbers;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import com.mopub.nativeads.CustomEventNative.ImageListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class MoPubCustomEventNative extends CustomEventNative {

    /* renamed from: com.mopub.nativeads.MoPubCustomEventNative.1 */
    class C26411 implements ImageListener {
        final /* synthetic */ CustomEventNativeListener val$customEventNativeListener;
        final /* synthetic */ MoPubForwardingNativeAd val$moPubForwardingNativeAd;

        C26411(CustomEventNativeListener customEventNativeListener, MoPubForwardingNativeAd moPubForwardingNativeAd) {
            this.val$customEventNativeListener = customEventNativeListener;
            this.val$moPubForwardingNativeAd = moPubForwardingNativeAd;
        }

        public void onImagesCached() {
            this.val$customEventNativeListener.onNativeAdLoaded(this.val$moPubForwardingNativeAd);
        }

        public void onImagesFailedToCache(NativeErrorCode errorCode) {
            this.val$customEventNativeListener.onNativeAdFailed(errorCode);
        }
    }

    /* renamed from: com.mopub.nativeads.MoPubCustomEventNative.2 */
    static /* synthetic */ class C26422 {
        static final /* synthetic */ int[] $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter;

        static {
            $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter = new int[Parameter.values().length];
            try {
                $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[Parameter.MAIN_IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[Parameter.ICON_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[Parameter.IMPRESSION_TRACKER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[Parameter.CLICK_TRACKER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[Parameter.CLICK_DESTINATION.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[Parameter.CALL_TO_ACTION.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[Parameter.TITLE.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[Parameter.TEXT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[Parameter.STAR_RATING.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    static class MoPubForwardingNativeAd extends BaseForwardingNativeAd {
        MoPubForwardingNativeAd(String jsonString) {
            if (jsonString == null) {
                throw new IllegalArgumentException("Json String cannot be null");
            }
            JSONObject jsonObject = new JSONObject(new JSONTokener(jsonString));
            if (containsRequiredKeys(jsonObject)) {
                Iterator keys = jsonObject.keys();
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    Parameter parameter = Parameter.from(key);
                    if (parameter != null) {
                        try {
                            addInstanceVariable(parameter, jsonObject.opt(key));
                        } catch (ClassCastException e) {
                            throw new IllegalArgumentException("JSONObject key (" + key + ") contained unexpected value.");
                        }
                    }
                    addExtra(key, jsonObject.opt(key));
                }
                return;
            }
            throw new IllegalArgumentException("JSONObject did not contain required keys.");
        }

        private boolean containsRequiredKeys(JSONObject jsonObject) {
            Set keys = new HashSet();
            Iterator jsonKeys = jsonObject.keys();
            while (jsonKeys.hasNext()) {
                keys.add(jsonKeys.next());
            }
            return keys.containsAll(Parameter.requiredKeys);
        }

        private void addInstanceVariable(Parameter key, Object value) {
            try {
                switch (C26422.$SwitchMap$com$mopub$nativeads$NativeResponse$Parameter[key.ordinal()]) {
                    case Base64.NO_PADDING /*1*/:
                        setMainImageUrl((String) value);
                        return;
                    case Base64.NO_WRAP /*2*/:
                        setIconImageUrl((String) value);
                        return;
                    case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        addImpressionTrackers(value);
                        return;
                    case Base64.CRLF /*4*/:
                        return;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        setClickDestinationUrl((String) value);
                        return;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        setCallToAction((String) value);
                        return;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                        setTitle((String) value);
                        return;
                    case Base64.URL_SAFE /*8*/:
                        setText((String) value);
                        return;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                        setStarRating(Numbers.parseDouble(value));
                        return;
                    default:
                        MoPubLog.m9729d("Unable to add JSON key to internal mapping: " + key.name);
                        return;
                }
            } catch (ClassCastException e) {
                if (key.required) {
                    throw e;
                }
                MoPubLog.m9729d("Ignoring class cast exception for optional key: " + key.name);
                return;
            }
            if (key.required) {
                MoPubLog.m9729d("Ignoring class cast exception for optional key: " + key.name);
                return;
            }
            throw e;
        }

        private void addImpressionTrackers(Object impressionTrackers) {
            if (impressionTrackers instanceof JSONArray) {
                JSONArray trackers = (JSONArray) impressionTrackers;
                for (int i = 0; i < trackers.length(); i++) {
                    try {
                        addImpressionTracker(trackers.getString(i));
                    } catch (JSONException e) {
                        MoPubLog.m9729d("Unable to parse impression trackers.");
                    }
                }
                return;
            }
            throw new ClassCastException("Expected impression trackers of type JSONArray.");
        }

        private boolean isImageKey(String name) {
            return name != null && name.toLowerCase().endsWith("image");
        }

        List getExtrasImageUrls() {
            List extrasBitmapUrls = new ArrayList(getExtras().size());
            for (Entry entry : getExtras().entrySet()) {
                if (isImageKey((String) entry.getKey()) && (entry.getValue() instanceof String)) {
                    extrasBitmapUrls.add((String) entry.getValue());
                }
            }
            return extrasBitmapUrls;
        }

        List getAllImageUrls() {
            List imageUrls = new ArrayList();
            if (getMainImageUrl() != null) {
                imageUrls.add(getMainImageUrl());
            }
            if (getIconImageUrl() != null) {
                imageUrls.add(getIconImageUrl());
            }
            imageUrls.addAll(getExtrasImageUrls());
            return imageUrls;
        }
    }

    protected void loadNativeAd(Context context, CustomEventNativeListener customEventNativeListener, Map localExtras, Map serverExtras) {
        try {
            MoPubForwardingNativeAd moPubForwardingNativeAd = new MoPubForwardingNativeAd((String) serverExtras.get("response_body_key"));
            preCacheImages(context, moPubForwardingNativeAd.getAllImageUrls(), new C26411(customEventNativeListener, moPubForwardingNativeAd));
        } catch (IllegalArgumentException e) {
            customEventNativeListener.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
        } catch (JSONException e2) {
            customEventNativeListener.onNativeAdFailed(NativeErrorCode.INVALID_JSON);
        }
    }
}
