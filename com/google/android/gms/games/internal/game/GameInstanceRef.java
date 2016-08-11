package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.C1420b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.PlatformType;
import com.google.android.gms.internal.fo;

public final class GameInstanceRef extends C1420b implements GameInstance {
    GameInstanceRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public String getApplicationId() {
        return getString("external_game_id");
    }

    public String getDisplayName() {
        return getString("instance_display_name");
    }

    public String getPackageName() {
        return getString("package_name");
    }

    public boolean hi() {
        return getInteger("real_time_support") > 0;
    }

    public boolean hj() {
        return getInteger("turn_based_support") > 0;
    }

    public int hk() {
        return getInteger("platform_type");
    }

    public boolean hl() {
        return getInteger("piracy_check") > 0;
    }

    public boolean hm() {
        return getInteger("installed") > 0;
    }

    public String toString() {
        return fo.m8511e(this).m8510a("ApplicationId", getApplicationId()).m8510a("DisplayName", getDisplayName()).m8510a("SupportsRealTime", Boolean.valueOf(hi())).m8510a("SupportsTurnBased", Boolean.valueOf(hj())).m8510a("PlatformType", PlatformType.bd(hk())).m8510a("PackageName", getPackageName()).m8510a("PiracyCheckEnabled", Boolean.valueOf(hl())).m8510a("Installed", Boolean.valueOf(hm())).toString();
    }
}
