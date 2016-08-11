package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C1420b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public final class LeaderboardRef extends C1420b implements Leaderboard {
    private final int LE;
    private final Game LS;

    LeaderboardRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.LE = numChildren;
        this.LS = new GameRef(holder, dataRow);
    }

    public boolean equals(Object obj) {
        return LeaderboardEntity.m7722a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return hC();
    }

    public String getDisplayName() {
        return getString("name");
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        m6095a("name", dataOut);
    }

    public Game getGame() {
        return this.LS;
    }

    public Uri getIconImageUri() {
        return ah("board_icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("board_icon_image_url");
    }

    public String getLeaderboardId() {
        return getString("external_leaderboard_id");
    }

    public int getScoreOrder() {
        return getInteger("score_order");
    }

    public ArrayList getVariants() {
        ArrayList arrayList = new ArrayList(this.LE);
        for (int i = 0; i < this.LE; i++) {
            arrayList.add(new LeaderboardVariantRef(this.BB, this.BD + i));
        }
        return arrayList;
    }

    public Leaderboard hC() {
        return new LeaderboardEntity(this);
    }

    public int hashCode() {
        return LeaderboardEntity.m7721a(this);
    }

    public String toString() {
        return LeaderboardEntity.m7723b(this);
    }
}
