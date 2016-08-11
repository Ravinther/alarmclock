package com.mopub.common;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.mopub.common.util.MoPubLog;
import java.math.BigDecimal;

public class LocationService {

    public enum LocationAwareness {
        NORMAL,
        TRUNCATED,
        DISABLED
    }

    public static Location getLastKnownLocation(Context context, int locationPrecision, LocationAwareness locationAwareness) {
        if (locationAwareness == LocationAwareness.DISABLED) {
            return null;
        }
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        Location gpsLocation = null;
        try {
            gpsLocation = locationManager.getLastKnownLocation("gps");
        } catch (SecurityException e) {
            MoPubLog.m9729d("Failed to retrieve GPS location: access appears to be disabled.");
        } catch (IllegalArgumentException e2) {
            MoPubLog.m9729d("Failed to retrieve GPS location: device has no GPS provider.");
        }
        Location networkLocation = null;
        try {
            networkLocation = locationManager.getLastKnownLocation("network");
        } catch (SecurityException e3) {
            MoPubLog.m9729d("Failed to retrieve network location: access appears to be disabled.");
        } catch (IllegalArgumentException e4) {
            MoPubLog.m9729d("Failed to retrieve network location: device has no network provider.");
        }
        if (gpsLocation == null && networkLocation == null) {
            return null;
        }
        Location result;
        if (gpsLocation == null || networkLocation == null) {
            if (gpsLocation != null) {
                result = gpsLocation;
            } else {
                result = networkLocation;
            }
        } else if (gpsLocation.getTime() > networkLocation.getTime()) {
            result = gpsLocation;
        } else {
            result = networkLocation;
        }
        if (locationAwareness != LocationAwareness.TRUNCATED) {
            return result;
        }
        result.setLatitude(BigDecimal.valueOf(result.getLatitude()).setScale(locationPrecision, 5).doubleValue());
        result.setLongitude(BigDecimal.valueOf(result.getLongitude()).setScale(locationPrecision, 5).doubleValue());
        return result;
    }
}
