package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C1420b;
import com.google.android.gms.common.data.DataHolder;

public final class GameBadgeRef extends C1420b implements GameBadge {
    GameBadgeRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return GameBadgeEntity.m7710a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return hh();
    }

    public String getDescription() {
        return getString("badge_description");
    }

    public Uri getIconImageUri() {
        return ah("badge_icon_image_uri");
    }

    public String getTitle() {
        return getString("badge_title");
    }

    public int getType() {
        return getInteger("badge_type");
    }

    public int hashCode() {
        return GameBadgeEntity.m7709a(this);
    }

    public GameBadge hh() {
        return new GameBadgeEntity(this);
    }

    public String toString() {
        return GameBadgeEntity.m7711b((GameBadge) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((GameBadgeEntity) hh()).writeToParcel(dest, flags);
    }
}
