package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.as;
import com.google.android.gms.internal.as.C1749a;
import com.google.android.gms.internal.fq;
import java.util.Date;
import java.util.Set;

public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    private final as kp;

    public static final class Builder {
        private final C1749a kq;

        public Builder() {
            this.kq = new C1749a();
        }

        public Builder addKeyword(String keyword) {
            this.kq.m7872g(keyword);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.kq.m7867a(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class adapterClass, Bundle networkExtras) {
            this.kq.m7868a(adapterClass, networkExtras);
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.kq.m7874h(deviceId);
            return this;
        }

        public PublisherAdRequest build() {
            return new PublisherAdRequest();
        }

        public Builder setBirthday(Date birthday) {
            this.kq.m7869a(birthday);
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            fq.m8517b((Object) contentUrl, (Object) "Content URL must be non-null.");
            fq.m8518b(contentUrl, (Object) "Content URL must be non-empty.");
            boolean z = contentUrl.length() <= AdRequest.MAX_CONTENT_URL_LENGTH;
            Object[] objArr = new Object[PublisherAdRequest.GENDER_FEMALE];
            objArr[PublisherAdRequest.ERROR_CODE_INTERNAL_ERROR] = Integer.valueOf(AdRequest.MAX_CONTENT_URL_LENGTH);
            objArr[PublisherAdRequest.GENDER_MALE] = Integer.valueOf(contentUrl.length());
            fq.m8516a(z, "Content URL must not exceed %d in length.  Provided length was %d.", objArr);
            this.kq.m7875i(contentUrl);
            return this;
        }

        public Builder setGender(int gender) {
            this.kq.m7870d(gender);
            return this;
        }

        public Builder setLocation(Location location) {
            this.kq.m7866a(location);
            return this;
        }

        public Builder setManualImpressionsEnabled(boolean manualImpressionsEnabled) {
            this.kq.m7871f(manualImpressionsEnabled);
            return this;
        }

        public Builder setPublisherProvidedId(String publisherProvidedId) {
            this.kq.m7876j(publisherProvidedId);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.kq.m7873g(tagForChildDirectedTreatment);
            return this;
        }
    }

    static {
        DEVICE_ID_EMULATOR = as.DEVICE_ID_EMULATOR;
    }

    private PublisherAdRequest(Builder builder) {
        this.kp = new as(builder.kq);
    }

    as m5874O() {
        return this.kp;
    }

    public Date getBirthday() {
        return this.kp.getBirthday();
    }

    public String getContentUrl() {
        return this.kp.getContentUrl();
    }

    public int getGender() {
        return this.kp.getGender();
    }

    public Set getKeywords() {
        return this.kp.getKeywords();
    }

    public Location getLocation() {
        return this.kp.getLocation();
    }

    public boolean getManualImpressionsEnabled() {
        return this.kp.getManualImpressionsEnabled();
    }

    @Deprecated
    public NetworkExtras getNetworkExtras(Class networkExtrasClass) {
        return this.kp.getNetworkExtras(networkExtrasClass);
    }

    public Bundle getNetworkExtrasBundle(Class adapterClass) {
        return this.kp.getNetworkExtrasBundle(adapterClass);
    }

    public String getPublisherProvidedId() {
        return this.kp.getPublisherProvidedId();
    }

    public boolean isTestDevice(Context context) {
        return this.kp.isTestDevice(context);
    }
}
