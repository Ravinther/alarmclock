package com.google.android.gms.games.internal.player;

import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.fo;

public final class ExtendedPlayerEntity implements ExtendedPlayer {
    private final PlayerEntity LH;
    private final String LI;
    private final long LJ;
    private final Uri LK;

    public ExtendedPlayerEntity(ExtendedPlayer extendedPlayer) {
        Player player = extendedPlayer.getPlayer();
        this.LH = player == null ? null : new PlayerEntity(player);
        this.LI = extendedPlayer.hu();
        this.LJ = extendedPlayer.hv();
        this.LK = extendedPlayer.hw();
    }

    static int m7714a(ExtendedPlayer extendedPlayer) {
        return fo.hashCode(extendedPlayer.getPlayer(), extendedPlayer.hu(), Long.valueOf(extendedPlayer.hv()), extendedPlayer.hw());
    }

    static boolean m7715a(ExtendedPlayer extendedPlayer, Object obj) {
        if (!(obj instanceof ExtendedPlayer)) {
            return false;
        }
        if (extendedPlayer == obj) {
            return true;
        }
        ExtendedPlayer extendedPlayer2 = (ExtendedPlayer) obj;
        return fo.equal(extendedPlayer2.getPlayer(), extendedPlayer.getPlayer()) && fo.equal(extendedPlayer2.hu(), extendedPlayer.hu()) && fo.equal(Long.valueOf(extendedPlayer2.hv()), Long.valueOf(extendedPlayer.hv())) && fo.equal(extendedPlayer2.hw(), extendedPlayer.hw());
    }

    static String m7716b(ExtendedPlayer extendedPlayer) {
        return fo.m8511e(extendedPlayer).m8510a("Player", extendedPlayer.getPlayer()).m8510a("MostRecentGameId", extendedPlayer.hu()).m8510a("MostRecentActivityTimestamp", Long.valueOf(extendedPlayer.hv())).m8510a("MostRecentGameIconImageUri", extendedPlayer.hw()).toString();
    }

    public boolean equals(Object obj) {
        return m7715a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return hy();
    }

    public /* synthetic */ Player getPlayer() {
        return hx();
    }

    public int hashCode() {
        return m7714a(this);
    }

    public String hu() {
        return this.LI;
    }

    public long hv() {
        return this.LJ;
    }

    public Uri hw() {
        return this.LK;
    }

    public PlayerEntity hx() {
        return this.LH;
    }

    public ExtendedPlayer hy() {
        return this;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m7716b(this);
    }
}
