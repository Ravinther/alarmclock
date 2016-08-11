package com.anglelabs.alarmclock.redesign.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.p021b.p025a.C0564a;
import com.anglelabs.alarmclock.redesign.p026e.p041b.C0710a;
import com.anglelabs.alarmclock.redesign.p026e.p041b.C0711b;
import com.anglelabs.alarmclock.redesign.p026e.p041b.C0712c;
import com.anglelabs.alarmclock.redesign.p026e.p041b.C0714d;
import com.anglelabs.alarmclock.redesign.p026e.p041b.C0715e;
import com.anglelabs.alarmclock.redesign.p026e.p041b.C0716f;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class RedesignSetSoundTypeActivity extends C0564a {

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignSetSoundTypeActivity.a */
    public interface C0590a {
        Intent m2738a();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.redesign_activity_simple_container);
        C0794b.m3779a((Activity) this, (int) R.string.ads_category_choose_sound_type, true);
        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey("key_mode") && savedInstanceState == null) {
            Fragment displayedFragment = m2739b(getIntent().getExtras().getInt("key_mode"));
            if (displayedFragment == null) {
                C0850q.m3987b("mode did not match any known operation, aborting");
            } else {
                m258g().m262a().m183a((int) R.id.fragments_container, displayedFragment).m188b();
            }
        }
    }

    protected void onPause() {
        C0794b.m3787d(this);
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        C0794b.m3786c(this);
    }

    protected void onDestroy() {
        C0794b.m3788e(this);
        super.onDestroy();
    }

    private C0710a m2739b(int mode) {
        switch (mode) {
            case Base64.DEFAULT /*0*/:
                return new C0714d();
            case Base64.NO_PADDING /*1*/:
                return new C0712c();
            case Base64.NO_WRAP /*2*/:
                return new C0716f();
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return new C0715e();
            case Base64.CRLF /*4*/:
                return new C0711b();
            default:
                return null;
        }
    }

    public void onBackPressed() {
        boolean backHandledByChildren = false;
        Fragment visibleFragment = (Fragment) m258g().m273f().get(m258g().m272e());
        if (visibleFragment instanceof C0716f) {
            backHandledByChildren = ((C0716f) visibleFragment).m3291G();
        }
        if (!backHandledByChildren && (visibleFragment instanceof C0590a)) {
            Intent results = ((C0590a) visibleFragment).m2738a();
            if (results != null) {
                setResult(-1, results);
            } else {
                setResult(0);
            }
            finish();
        } else if (!backHandledByChildren) {
            super.onBackPressed();
        }
    }
}
