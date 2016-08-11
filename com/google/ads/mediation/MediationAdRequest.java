package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Date;
import java.util.Set;

@Deprecated
public final class MediationAdRequest {
    private final Date f4006d;
    private final Gender f4007e;
    private final Set f4008f;
    private final boolean f4009g;
    private final Location f4010h;

    public MediationAdRequest(Date birthday, Gender gender, Set keywords, boolean isTesting, Location location) {
        this.f4006d = birthday;
        this.f4007e = gender;
        this.f4008f = keywords;
        this.f4009g = isTesting;
        this.f4010h = location;
    }

    public Integer getAgeInYears() {
        return null;
    }

    public Date getBirthday() {
        return this.f4006d;
    }

    public Gender getGender() {
        return this.f4007e;
    }

    public Set getKeywords() {
        return this.f4008f;
    }

    public Location getLocation() {
        return this.f4010h;
    }

    public boolean isTesting() {
        return this.f4009g;
    }
}
