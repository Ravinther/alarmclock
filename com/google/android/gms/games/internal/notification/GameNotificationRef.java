package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.C1420b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.fo;
import com.google.android.gms.plus.PlusShare;

public final class GameNotificationRef extends C1420b implements GameNotification {
    GameNotificationRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public long getId() {
        return getLong("_id");
    }

    public String getText() {
        return getString("text");
    }

    public String getTitle() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
    }

    public int getType() {
        return getInteger("type");
    }

    public String hp() {
        return getString("notification_id");
    }

    public String hq() {
        return getString("ticker");
    }

    public String hr() {
        return getString("coalesced_text");
    }

    public boolean hs() {
        return getInteger("acknowledged") > 0;
    }

    public boolean ht() {
        return getInteger("alert_level") == 0;
    }

    public String toString() {
        return fo.m8511e(this).m8510a("Id", Long.valueOf(getId())).m8510a("NotificationId", hp()).m8510a("Type", Integer.valueOf(getType())).m8510a("Title", getTitle()).m8510a("Ticker", hq()).m8510a("Text", getText()).m8510a("CoalescedText", hr()).m8510a("isAcknowledged", Boolean.valueOf(hs())).m8510a("isSilent", Boolean.valueOf(ht())).toString();
    }
}
