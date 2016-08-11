package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;

public final class AclsImpl implements Acls {

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl.1 */
    static class C16381 implements LoadAclResult {
        final /* synthetic */ Status wz;

        C16381(Status status) {
            this.wz = status;
        }

        public Status getStatus() {
            return this.wz;
        }

        public void release() {
        }
    }

    private static abstract class LoadNotifyAclImpl extends BaseGamesApiMethodImpl {
        private LoadNotifyAclImpl() {
        }

        public /* synthetic */ Result m7484d(Status status) {
            return m7485x(status);
        }

        public LoadAclResult m7485x(Status status) {
            return AclsImpl.m7492v(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl.2 */
    class C16392 extends LoadNotifyAclImpl {
        protected void m7487a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7087i(this);
        }
    }

    private static abstract class UpdateNotifyAclImpl extends BaseGamesApiMethodImpl {
        private UpdateNotifyAclImpl() {
        }

        public /* synthetic */ Result m7488d(Status status) {
            return m7489f(status);
        }

        public Status m7489f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl.3 */
    class C16403 extends UpdateNotifyAclImpl {
        final /* synthetic */ String JY;

        protected void m7491a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7094m((C1401d) this, this.JY);
        }
    }

    private static LoadAclResult m7492v(Status status) {
        return new C16381(status);
    }
}
