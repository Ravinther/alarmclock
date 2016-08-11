package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventBanner;
import java.lang.reflect.Constructor;

public class CustomEventBannerFactory {
    private static CustomEventBannerFactory instance;

    static {
        instance = new CustomEventBannerFactory();
    }

    public static CustomEventBanner create(String className) {
        return instance.internalCreate(className);
    }

    @Deprecated
    public static void setInstance(CustomEventBannerFactory factory) {
        instance = factory;
    }

    protected CustomEventBanner internalCreate(String className) {
        Constructor bannerConstructor = Class.forName(className).asSubclass(CustomEventBanner.class).getDeclaredConstructor((Class[]) null);
        bannerConstructor.setAccessible(true);
        return (CustomEventBanner) bannerConstructor.newInstance(new Object[0]);
    }
}
