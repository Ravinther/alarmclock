package com.anglelabs.alarmclock.redesign.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.p020a.C0542c;
import com.anglelabs.alarmclock.redesign.p020a.C0542c.C0540a;
import com.anglelabs.alarmclock.redesign.p021b.p025a.C0564a;
import com.anglelabs.alarmclock.redesign.utils.C0790a;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0825m;
import com.anglelabs.alarmclock.redesign.utils.C0832m;

public class RedesignMainSettingsActivity extends C0564a {
    private ListView f1633o;
    private C0542c f1634p;

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignMainSettingsActivity.1 */
    class C05891 implements OnItemClickListener {
        final /* synthetic */ RedesignMainSettingsActivity f1632a;

        C05891(RedesignMainSettingsActivity redesignMainSettingsActivity) {
            this.f1632a = redesignMainSettingsActivity;
        }

        public void onItemClick(AdapterView parent, View view, int position, long id) {
            Intent intent = null;
            switch (((C0540a) this.f1632a.f1634p.getItem(position)).m2525a()) {
                case R.string.settings_general:
                    intent = C0832m.m3937l(this.f1632a);
                    C0830k.m3896a(view.getContext(), C0825m.MainSettingsGeneral);
                    break;
                case R.string.settings_alarm:
                    intent = C0832m.m3917b(this.f1632a);
                    C0830k.m3896a(view.getContext(), C0825m.MainSettingsAlarm);
                    break;
                case R.string.settings_timer:
                    intent = C0832m.m3921c(this.f1632a);
                    C0830k.m3896a(view.getContext(), C0825m.MainSettingsTimer);
                    break;
                case R.string.settings_stopwatch:
                    intent = C0832m.m3924d(this.f1632a);
                    C0830k.m3896a(view.getContext(), C0825m.MainSettingsStopwatch);
                    break;
            }
            if (intent != null) {
                this.f1632a.startActivity(intent);
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m1486h().m1461c(true);
        setContentView((int) R.layout.redesign_main_settings_layout);
        findViewById(R.id.adsContainerView).setVisibility(8);
        new C0790a(this).m3750a(getString(R.string.acx_main_menu_settings));
        this.f1633o = (ListView) findViewById(R.id.list);
        this.f1634p = new C0542c(getApplicationContext());
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    protected void onStart() {
        super.onStart();
        C0830k.m3896a((Context) this, C0825m.MainSettingsScreen);
        this.f1633o.setAdapter(this.f1634p);
        this.f1633o.setOnItemClickListener(new C05891(this));
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                onBackPressed();
                break;
        }
        return true;
    }
}
