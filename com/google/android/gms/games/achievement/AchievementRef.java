package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C1420b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.internal.fb;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fo.C1908a;
import com.google.android.gms.plus.PlusShare;

public final class AchievementRef extends C1420b implements Achievement {
    AchievementRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public String getAchievementId() {
        return getString("external_achievement_id");
    }

    public int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        fb.m8420x(z);
        return getInteger("current_steps");
    }

    public String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public void getDescription(CharArrayBuffer dataOut) {
        m6095a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, dataOut);
    }

    public String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        fb.m8420x(z);
        return getString("formatted_current_steps");
    }

    public void getFormattedCurrentSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        fb.m8420x(z);
        m6095a("formatted_current_steps", dataOut);
    }

    public String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        fb.m8420x(z);
        return getString("formatted_total_steps");
    }

    public void getFormattedTotalSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        fb.m8420x(z);
        m6095a("formatted_total_steps", dataOut);
    }

    public long getLastUpdatedTimestamp() {
        return getLong("last_updated_timestamp");
    }

    public String getName() {
        return getString("name");
    }

    public void getName(CharArrayBuffer dataOut) {
        m6095a("name", dataOut);
    }

    public Player getPlayer() {
        return new PlayerRef(this.BB, this.BD);
    }

    public Uri getRevealedImageUri() {
        return ah("revealed_icon_image_uri");
    }

    public String getRevealedImageUrl() {
        return getString("revealed_icon_image_url");
    }

    public int getState() {
        return getInteger("state");
    }

    public int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        fb.m8420x(z);
        return getInteger("total_steps");
    }

    public int getType() {
        return getInteger("type");
    }

    public Uri getUnlockedImageUri() {
        return ah("unlocked_icon_image_uri");
    }

    public String getUnlockedImageUrl() {
        return getString("unlocked_icon_image_url");
    }

    public String toString() {
        C1908a a = fo.m8511e(this).m8510a("AchievementId", getAchievementId()).m8510a("Type", Integer.valueOf(getType())).m8510a("Name", getName()).m8510a("Description", getDescription()).m8510a("UnlockedImageUri", getUnlockedImageUri()).m8510a("UnlockedImageUrl", getUnlockedImageUrl()).m8510a("RevealedImageUri", getRevealedImageUri()).m8510a("RevealedImageUrl", getRevealedImageUrl()).m8510a("Player", getPlayer()).m8510a("LastUpdatedTimeStamp", Long.valueOf(getLastUpdatedTimestamp()));
        if (getType() == 1) {
            a.m8510a("CurrentSteps", Integer.valueOf(getCurrentSteps()));
            a.m8510a("TotalSteps", Integer.valueOf(getTotalSteps()));
        }
        return a.toString();
    }
}
