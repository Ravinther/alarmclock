package com.anglelabs.alarmclock.redesign.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.p021b.p025a.C0564a;
import com.anglelabs.alarmclock.redesign.p024c.C0676a;
import com.anglelabs.alarmclock.redesign.utils.C0807e;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0825m;
import com.anglelabs.alarmclock.redesign.utils.C0831l;
import com.anglelabs.alarmclock.redesign.utils.C0861x;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.anglelabs.alarmclock.redesign.views.HorizontalPicturesViewer;
import com.anglelabs.alarmclock.redesign.views.HorizontalPicturesViewer.C0578a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class RedesignChooseBackgroundActivity extends C0564a {
    private static final C0861x f1620r;
    private int f1621o;
    private HorizontalPicturesViewer f1622p;
    private View f1623s;

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignChooseBackgroundActivity.1 */
    class C05771 implements OnTouchListener {
        final /* synthetic */ GestureDetector f1601a;
        final /* synthetic */ RedesignChooseBackgroundActivity f1602b;

        C05771(RedesignChooseBackgroundActivity redesignChooseBackgroundActivity, GestureDetector gestureDetector) {
            this.f1602b = redesignChooseBackgroundActivity;
            this.f1601a = gestureDetector;
        }

        public boolean onTouch(View v, MotionEvent event) {
            return this.f1601a.onTouchEvent(event);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignChooseBackgroundActivity.2 */
    class C05792 implements C0578a {
        final /* synthetic */ int[] f1603a;
        final /* synthetic */ RedesignChooseBackgroundActivity f1604b;

        C05792(RedesignChooseBackgroundActivity redesignChooseBackgroundActivity, int[] iArr) {
            this.f1604b = redesignChooseBackgroundActivity;
            this.f1603a = iArr;
        }

        public void m2707a(int position) {
            this.f1604b.f1621o = C0582a.values()[position].ordinal();
            this.f1604b.m2712a(this.f1603a[position], true);
            C0830k.m3896a(this.f1604b, C0825m.BgScreenSelected);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignChooseBackgroundActivity.3 */
    class C05803 implements OnClickListener {
        final /* synthetic */ SharedPreferences f1605a;
        final /* synthetic */ RedesignChooseBackgroundActivity f1606b;

        C05803(RedesignChooseBackgroundActivity redesignChooseBackgroundActivity, SharedPreferences sharedPreferences) {
            this.f1606b = redesignChooseBackgroundActivity;
            this.f1605a = sharedPreferences;
        }

        public void onClick(View v) {
            if (this.f1605a.getInt("default_background", 0) != this.f1606b.f1621o) {
                C0831l.m3904a();
                this.f1605a.edit().putInt("default_background", this.f1606b.f1621o).commit();
                C0676a.m3092a(this.f1606b);
            }
            C0830k.m3896a(v.getContext(), C0825m.BgScreenSaved);
            this.f1606b.finish();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignChooseBackgroundActivity.4 */
    class C05814 implements OnClickListener {
        final /* synthetic */ RedesignChooseBackgroundActivity f1607a;

        C05814(RedesignChooseBackgroundActivity redesignChooseBackgroundActivity) {
            this.f1607a = redesignChooseBackgroundActivity;
        }

        public void onClick(View v) {
            this.f1607a.finish();
            C0830k.m3896a(v.getContext(), C0825m.BgScreenCanceled);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignChooseBackgroundActivity.a */
    public enum C0582a {
        FLARY_LIGHTS(R.drawable.ic_bkg_flary_lights_theme),
        ORANGE(R.drawable.ic_bkg_orange_theme),
        PURPLE(R.drawable.ic_bkg_purple_theme),
        DARK_NIGHT(R.drawable.ic_bkg_dark_night_theme),
        DESERT_SUNRISE(R.drawable.ic_bkg_desert_sunrise_theme),
        OCEAN(R.drawable.ic_bkg_ocean_theme),
        PINK_LADY(R.drawable.ic_bkg_pink_lady_theme),
        SUNRISE(R.drawable.ic_bkg_sunrise_theme),
        SUNSET(R.drawable.ic_bkg_sunset_theme);
        
        private final int f1618j;

        private C0582a(int resId) {
            this.f1618j = resId;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.activities.RedesignChooseBackgroundActivity.b */
    private class C0583b extends SimpleOnGestureListener {
        final /* synthetic */ RedesignChooseBackgroundActivity f1619a;

        private C0583b(RedesignChooseBackgroundActivity redesignChooseBackgroundActivity) {
            this.f1619a = redesignChooseBackgroundActivity;
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (this.f1619a.f1622p == null) {
                return true;
            }
            if (Math.abs(e1.getY() - e2.getY()) > 250.0f) {
                return false;
            }
            if (e1.getX() - e2.getX() <= BitmapDescriptorFactory.HUE_GREEN || Math.abs(velocityX) <= 200.0f) {
                if (e2.getX() - e1.getX() > BitmapDescriptorFactory.HUE_GREEN && Math.abs(velocityX) > 200.0f && this.f1619a.f1621o - 1 >= 0) {
                    RedesignChooseBackgroundActivity.m2717c(this.f1619a, 1);
                    this.f1619a.f1622p.m4107a(this.f1619a.f1621o);
                }
            } else if (this.f1619a.f1621o + 1 < this.f1619a.m2719k().length) {
                RedesignChooseBackgroundActivity.m2715b(this.f1619a, 1);
                this.f1619a.f1622p.m4107a(this.f1619a.f1621o);
            }
            return false;
        }

        public boolean onDown(MotionEvent e) {
            return true;
        }
    }

    static /* synthetic */ int m2715b(RedesignChooseBackgroundActivity x0, int x1) {
        int i = x0.f1621o + x1;
        x0.f1621o = i;
        return i;
    }

    static /* synthetic */ int m2717c(RedesignChooseBackgroundActivity x0, int x1) {
        int i = x0.f1621o - x1;
        x0.f1621o = i;
        return i;
    }

    static {
        f1620r = new C0861x();
    }

    private int[] m2719k() {
        int backgroundsCount = C0582a.values().length;
        int[] resList = new int[backgroundsCount];
        for (int i = 0; i < backgroundsCount; i++) {
            resList[i] = C0582a.values()[i].f1618j;
        }
        return resList;
    }

    protected void onCreate(Bundle savedInstanceState) {
        int chosenResId;
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = ac.m3774b(this);
        setContentView((int) R.layout.redesign_activity_select_background);
        this.f1622p = (HorizontalPicturesViewer) findViewById(R.id.background_viewer);
        this.f1623s = findViewById(R.id.background_container);
        findViewById(R.id.choose_background_root_view).setOnTouchListener(new C05771(this, new GestureDetector(this, new C0583b())));
        if (savedInstanceState == null || !savedInstanceState.containsKey("last_background_index")) {
            chosenResId = m2709a(getApplicationContext());
            this.f1621o = m2720b(chosenResId);
        } else {
            this.f1621o = savedInstanceState.getInt("last_background_index");
            chosenResId = C0582a.values()[this.f1621o].f1618j;
        }
        m2712a(chosenResId, false);
        int[] resList = m2719k();
        if (this.f1622p != null) {
            this.f1622p.m4108a(resList, new C05792(this, resList), chosenResId);
        }
        findViewById(R.id.save).setOnClickListener(new C05803(this, prefs));
        findViewById(R.id.cancel).setOnClickListener(new C05814(this));
        C0830k.m3896a((Context) this, C0825m.BgScreen);
    }

    public void finish() {
        f1620r.m4046a();
        super.finish();
    }

    private void m2712a(int chosenResId, boolean clearOldImageRef) {
        if (clearOldImageRef) {
            f1620r.m4046a();
        }
        try {
            C0831l.m3906a(this.f1623s, f1620r.m4045a(this, chosenResId));
            C0807e.m3820d(this.f1623s).m4999a();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                C0831l.m3906a(this.f1623s, f1620r.m4045a(this, chosenResId));
            } catch (Exception e1) {
                e1.printStackTrace();
                this.f1623s.setBackgroundColor(-16777216);
            }
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("last_background_index", this.f1621o);
        super.onSaveInstanceState(outState);
    }

    public static int m2709a(Context context) {
        return C0582a.values()[ac.m3774b(context).getInt("default_background", 0)].f1618j;
    }

    public static int m2714b(Context context) {
        ac.m3774b(context).edit().putInt("default_background", 0).commit();
        return C0582a.values()[0].f1618j;
    }

    int m2720b(int backgroundResId) {
        int[] resList = m2719k();
        for (int i = 0; i < resList.length; i++) {
            if (resList[i] == backgroundResId) {
                return i;
            }
        }
        return -1;
    }
}
