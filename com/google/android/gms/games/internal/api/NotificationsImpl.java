package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class NotificationsImpl implements Notifications {

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.1 */
    class C16721 extends BaseGamesApiMethodImpl {
        final /* synthetic */ String KB;

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.1.1 */
        class C16711 implements GameMuteStatusChangeResult {
            final /* synthetic */ C16721 KC;
            final /* synthetic */ Status wz;

            C16711(C16721 c16721, Status status) {
                this.KC = c16721;
                this.wz = status;
            }

            public Status getStatus() {
                return this.wz;
            }
        }

        public GameMuteStatusChangeResult m7570H(Status status) {
            return new C16711(this, status);
        }

        protected void m7572a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7070c((C1401d) this, this.KB, true);
        }

        public /* synthetic */ Result m7573d(Status status) {
            return m7570H(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.2 */
    class C16742 extends BaseGamesApiMethodImpl {
        final /* synthetic */ String KB;

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.2.1 */
        class C16731 implements GameMuteStatusChangeResult {
            final /* synthetic */ C16742 KD;
            final /* synthetic */ Status wz;

            C16731(C16742 c16742, Status status) {
                this.KD = c16742;
                this.wz = status;
            }

            public Status getStatus() {
                return this.wz;
            }
        }

        public GameMuteStatusChangeResult m7574H(Status status) {
            return new C16731(this, status);
        }

        protected void m7576a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7070c((C1401d) this, this.KB, false);
        }

        public /* synthetic */ Result m7577d(Status status) {
            return m7574H(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.3 */
    class C16763 extends BaseGamesApiMethodImpl {
        final /* synthetic */ String KB;

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.3.1 */
        class C16751 implements GameMuteStatusLoadResult {
            final /* synthetic */ C16763 KE;
            final /* synthetic */ Status wz;

            C16751(C16763 c16763, Status status) {
                this.KE = c16763;
                this.wz = status;
            }

            public Status getStatus() {
                return this.wz;
            }
        }

        public GameMuteStatusLoadResult m7578I(Status status) {
            return new C16751(this, status);
        }

        protected void m7580a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7096n(this, this.KB);
        }

        public /* synthetic */ Result m7581d(Status status) {
            return m7578I(status);
        }
    }

    private static abstract class ContactSettingLoadImpl extends BaseGamesApiMethodImpl {

        /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.ContactSettingLoadImpl.1 */
        class C16791 implements ContactSettingLoadResult {
            final /* synthetic */ ContactSettingLoadImpl KH;
            final /* synthetic */ Status wz;

            C16791(ContactSettingLoadImpl contactSettingLoadImpl, Status status) {
                this.KH = contactSettingLoadImpl;
                this.wz = status;
            }

            public Status getStatus() {
                return this.wz;
            }
        }

        private ContactSettingLoadImpl() {
        }

        public ContactSettingLoadResult m7582J(Status status) {
            return new C16791(this, status);
        }

        public /* synthetic */ Result m7583d(Status status) {
            return m7582J(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.4 */
    class C16774 extends ContactSettingLoadImpl {
        protected void m7585a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7089j(this);
        }
    }

    private static abstract class ContactSettingUpdateImpl extends BaseGamesApiMethodImpl {
        private ContactSettingUpdateImpl() {
        }

        public /* synthetic */ Result m7586d(Status status) {
            return m7587f(status);
        }

        public Status m7587f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl.5 */
    class C16785 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean KF;
        final /* synthetic */ Bundle KG;

        protected void m7589a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m7041a((C1401d) this, this.KF, this.KG);
        }
    }

    public void clear(GoogleApiClient apiClient, int notificationTypes) {
        Games.m6753c(apiClient).aY(notificationTypes);
    }

    public void clearAll(GoogleApiClient apiClient) {
        clear(apiClient, 7);
    }
}
