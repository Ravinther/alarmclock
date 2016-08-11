package com.google.android.gms.games.internal.player;

import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Player;

public interface ExtendedPlayer extends Freezable {
    Player getPlayer();

    String hu();

    long hv();

    Uri hw();
}
