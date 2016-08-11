package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.model.internal.C2182d;
import com.google.android.gms.maps.model.internal.C2185e.C2187a;
import java.util.ArrayList;
import java.util.List;

public final class IndoorBuilding {
    private final C2182d SY;

    public IndoorBuilding(C2182d delegate) {
        this.SY = (C2182d) fq.m8520f(delegate);
    }

    public boolean equals(Object other) {
        if (!(other instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.SY.m9146b(((IndoorBuilding) other).SY);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getActiveLevelIndex() {
        try {
            return this.SY.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getDefaultLevelIndex() {
        try {
            return this.SY.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List getLevels() {
        try {
            List<IBinder> levels = this.SY.getLevels();
            List arrayList = new ArrayList(levels.size());
            for (IBinder aF : levels) {
                arrayList.add(new IndoorLevel(C2187a.aF(aF)));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.SY.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isUnderground() {
        try {
            return this.SY.isUnderground();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
