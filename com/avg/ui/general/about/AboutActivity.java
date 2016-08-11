package com.avg.ui.general.about;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.avg.toolkit.C0961d;
import com.avg.toolkit.zen.C1044a;
import com.avg.toolkit.zen.C1051f;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;
import com.avg.ui.general.C1091c.C1085i;
import com.avg.ui.general.p055a.C1059b;
import com.avg.ui.general.p056h.C1064a;

public class AboutActivity extends C1059b {

    /* renamed from: com.avg.ui.general.about.AboutActivity.1 */
    class C10651 implements C1064a {
        final /* synthetic */ AboutActivity f3259a;

        C10651(AboutActivity aboutActivity) {
            this.f3259a = aboutActivity;
        }

        public void m4621a(IBinder binder) {
            this.f3259a.m4622a(binder);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C1084h.fragment_activity);
        m4617a(getString(C1085i.about_action_bar_title), false);
        m4586a(new C10651(this));
    }

    protected void m4622a(IBinder service) {
        C1070a proFeaturesFragment;
        C1044a dataResolver = ((C1051f) ((C0961d) service).m4305a(23000)).m4579c();
        if (dataResolver != null) {
            Context appContext = getApplicationContext();
            proFeaturesFragment = C1070a.m4623a(dataResolver.m4532a(appContext), dataResolver.m4533b(appContext), dataResolver.m4534c(appContext));
        } else {
            proFeaturesFragment = new C1070a();
        }
        m4615a(proFeaturesFragment, C1082f.middle_part, "AboutFragment");
    }
}
