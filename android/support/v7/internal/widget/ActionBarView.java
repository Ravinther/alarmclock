package android.support.v7.internal.widget;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p007b.p008a.C0127a;
import android.support.v4.p007b.p008a.C0128b;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.support.v7.internal.view.menu.C0384l;
import android.support.v7.internal.view.menu.C0384l.C0335a;
import android.support.v7.internal.view.menu.C0392a;
import android.support.v7.internal.view.menu.C0397f;
import android.support.v7.internal.view.menu.C0399h;
import android.support.v7.internal.view.menu.C0411p;
import android.support.v7.internal.widget.C0416d.C0419d;
import android.support.v7.p012a.C0328a.C0323b;
import android.support.v7.p012a.C0328a.C0325d;
import android.support.v7.p013c.C0365b;
import android.support.v7.p014b.C0364a.C0355b;
import android.support.v7.p014b.C0364a.C0356c;
import android.support.v7.p014b.C0364a.C0358e;
import android.support.v7.p014b.C0364a.C0360g;
import android.support.v7.p014b.C0364a.C0361h;
import android.support.v7.p014b.C0364a.C0363j;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window.Callback;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.CustomEventBannerAdapter;
import com.mopub.mobileads.util.Base64;

public class ActionBarView extends C0418a {
    private ProgressBarICS f1011A;
    private int f1012B;
    private int f1013C;
    private int f1014D;
    private int f1015E;
    private int f1016F;
    private int f1017G;
    private boolean f1018H;
    private boolean f1019I;
    private boolean f1020J;
    private boolean f1021K;
    private C0397f f1022L;
    private ActionBarContextView f1023M;
    private C0392a f1024N;
    private SpinnerAdapter f1025O;
    private C0325d f1026P;
    private Runnable f1027Q;
    private C0424a f1028R;
    private final C0419d f1029S;
    private final OnClickListener f1030T;
    private final OnClickListener f1031U;
    View f1032g;
    Callback f1033h;
    private int f1034i;
    private int f1035j;
    private CharSequence f1036k;
    private CharSequence f1037l;
    private Drawable f1038m;
    private Drawable f1039n;
    private Context f1040o;
    private HomeView f1041p;
    private HomeView f1042q;
    private LinearLayout f1043r;
    private TextView f1044s;
    private TextView f1045t;
    private View f1046u;
    private C0467g f1047v;
    private LinearLayout f1048w;
    private ScrollingTabContainerView f1049x;
    private View f1050y;
    private ProgressBarICS f1051z;

    /* renamed from: android.support.v7.internal.widget.ActionBarView.1 */
    class C04201 implements C0419d {
        final /* synthetic */ ActionBarView f998a;

        C04201(ActionBarView actionBarView) {
            this.f998a = actionBarView;
        }

        public void m2045a(C0416d parent, View view, int position, long id) {
            if (this.f998a.f1026P != null) {
                this.f998a.f1026P.m1436a(position, id);
            }
        }

        public void m2044a(C0416d parent) {
        }
    }

    /* renamed from: android.support.v7.internal.widget.ActionBarView.2 */
    class C04212 implements OnClickListener {
        final /* synthetic */ ActionBarView f999a;

        C04212(ActionBarView actionBarView) {
            this.f999a = actionBarView;
        }

        public void onClick(View v) {
            C0399h item = this.f999a.f1028R.f1009b;
            if (item != null) {
                item.collapseActionView();
            }
        }
    }

    /* renamed from: android.support.v7.internal.widget.ActionBarView.3 */
    class C04223 implements OnClickListener {
        final /* synthetic */ ActionBarView f1000a;

        C04223(ActionBarView actionBarView) {
            this.f1000a = actionBarView;
        }

        public void onClick(View v) {
            this.f1000a.f1033h.onMenuItemSelected(0, this.f1000a.f1024N);
        }
    }

    private static class HomeView extends FrameLayout {
        private ImageView f1001a;
        private ImageView f1002b;
        private int f1003c;
        private int f1004d;
        private Drawable f1005e;

        public HomeView(Context context) {
            this(context, null);
        }

        public HomeView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public void m2049a(boolean isUp) {
            this.f1001a.setVisibility(isUp ? 0 : 8);
        }

        public void m2048a(Drawable icon) {
            this.f1002b.setImageDrawable(icon);
        }

        public void m2050b(Drawable d) {
            ImageView imageView = this.f1001a;
            if (d == null) {
                d = this.f1005e;
            }
            imageView.setImageDrawable(d);
            this.f1004d = 0;
        }

        public void m2047a(int resId) {
            this.f1004d = resId;
            this.f1001a.setImageDrawable(resId != 0 ? getResources().getDrawable(resId) : this.f1005e);
        }

        protected void onConfigurationChanged(Configuration newConfig) {
            super.onConfigurationChanged(newConfig);
            if (this.f1004d != 0) {
                m2047a(this.f1004d);
            }
        }

        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
            CharSequence cdesc = getContentDescription();
            if (!TextUtils.isEmpty(cdesc)) {
                event.getText().add(cdesc);
            }
            return true;
        }

        protected void onFinishInflate() {
            this.f1001a = (ImageView) findViewById(C0358e.up);
            this.f1002b = (ImageView) findViewById(C0358e.home);
            this.f1005e = this.f1001a.getDrawable();
        }

        public int m2046a() {
            return this.f1001a.getVisibility() == 8 ? this.f1003c : 0;
        }

        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            measureChildWithMargins(this.f1001a, widthMeasureSpec, 0, heightMeasureSpec, 0);
            LayoutParams upLp = (LayoutParams) this.f1001a.getLayoutParams();
            this.f1003c = (upLp.leftMargin + this.f1001a.getMeasuredWidth()) + upLp.rightMargin;
            int width = this.f1001a.getVisibility() == 8 ? 0 : this.f1003c;
            int height = (upLp.topMargin + this.f1001a.getMeasuredHeight()) + upLp.bottomMargin;
            measureChildWithMargins(this.f1002b, widthMeasureSpec, width, heightMeasureSpec, 0);
            LayoutParams iconLp = (LayoutParams) this.f1002b.getLayoutParams();
            width += (iconLp.leftMargin + this.f1002b.getMeasuredWidth()) + iconLp.rightMargin;
            height = Math.max(height, (iconLp.topMargin + this.f1002b.getMeasuredHeight()) + iconLp.bottomMargin);
            int widthMode = MeasureSpec.getMode(widthMeasureSpec);
            int heightMode = MeasureSpec.getMode(heightMeasureSpec);
            int widthSize = MeasureSpec.getSize(widthMeasureSpec);
            int heightSize = MeasureSpec.getSize(heightMeasureSpec);
            switch (widthMode) {
                case Integer.MIN_VALUE:
                    width = Math.min(width, widthSize);
                    break;
                case 1073741824:
                    width = widthSize;
                    break;
            }
            switch (heightMode) {
                case Integer.MIN_VALUE:
                    height = Math.min(height, heightSize);
                    break;
                case 1073741824:
                    height = heightSize;
                    break;
            }
            setMeasuredDimension(width, height);
        }

        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            int vCenter = (b - t) / 2;
            int width = r - l;
            int upOffset = 0;
            if (this.f1001a.getVisibility() != 8) {
                LayoutParams upLp = (LayoutParams) this.f1001a.getLayoutParams();
                int upHeight = this.f1001a.getMeasuredHeight();
                int upWidth = this.f1001a.getMeasuredWidth();
                int upTop = vCenter - (upHeight / 2);
                this.f1001a.layout(0, upTop, upWidth, upTop + upHeight);
                upOffset = (upLp.leftMargin + upWidth) + upLp.rightMargin;
                width -= upOffset;
                l += upOffset;
            }
            LayoutParams iconLp = (LayoutParams) this.f1002b.getLayoutParams();
            int iconHeight = this.f1002b.getMeasuredHeight();
            int iconWidth = this.f1002b.getMeasuredWidth();
            int iconLeft = upOffset + Math.max(iconLp.leftMargin, ((r - l) / 2) - (iconWidth / 2));
            int iconTop = Math.max(iconLp.topMargin, vCenter - (iconHeight / 2));
            this.f1002b.layout(iconLeft, iconTop, iconLeft + iconWidth, iconTop + iconHeight);
        }
    }

    static class SavedState extends BaseSavedState {
        public static final Creator CREATOR;
        int f1006a;
        boolean f1007b;

        /* renamed from: android.support.v7.internal.widget.ActionBarView.SavedState.1 */
        static class C04231 implements Creator {
            C04231() {
            }

            public /* synthetic */ Object createFromParcel(Parcel x0) {
                return m2051a(x0);
            }

            public /* synthetic */ Object[] newArray(int x0) {
                return m2052a(x0);
            }

            public SavedState m2051a(Parcel in) {
                return new SavedState(null);
            }

            public SavedState[] m2052a(int size) {
                return new SavedState[size];
            }
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.f1006a = in.readInt();
            this.f1007b = in.readInt() != 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.f1006a);
            out.writeInt(this.f1007b ? 1 : 0);
        }

        static {
            CREATOR = new C04231();
        }
    }

    /* renamed from: android.support.v7.internal.widget.ActionBarView.a */
    private class C0424a implements C0384l {
        C0397f f1008a;
        C0399h f1009b;
        final /* synthetic */ ActionBarView f1010c;

        private C0424a(ActionBarView actionBarView) {
            this.f1010c = actionBarView;
        }

        public void m2053a(Context context, C0397f menu) {
            if (!(this.f1008a == null || this.f1009b == null)) {
                this.f1008a.m1907d(this.f1009b);
            }
            this.f1008a = menu;
        }

        public void m2058d(boolean cleared) {
            if (this.f1009b != null) {
                boolean found = false;
                if (this.f1008a != null) {
                    int count = this.f1008a.size();
                    for (int i = 0; i < count; i++) {
                        if (((C0128b) this.f1008a.getItem(i)) == this.f1009b) {
                            found = true;
                            break;
                        }
                    }
                }
                if (!found) {
                    m2057b(this.f1008a, this.f1009b);
                }
            }
        }

        public boolean m2056a(C0411p subMenu) {
            return false;
        }

        public void m2054a(C0397f menu, boolean allMenusAreClosing) {
        }

        public boolean m2059g() {
            return false;
        }

        public boolean m2055a(C0397f menu, C0399h item) {
            this.f1010c.f1032g = item.getActionView();
            this.f1010c.f1042q.m2048a(this.f1010c.f1038m.getConstantState().newDrawable(this.f1010c.getResources()));
            this.f1009b = item;
            if (this.f1010c.f1032g.getParent() != this.f1010c) {
                this.f1010c.addView(this.f1010c.f1032g);
            }
            if (this.f1010c.f1042q.getParent() != this.f1010c) {
                this.f1010c.addView(this.f1010c.f1042q);
            }
            this.f1010c.f1041p.setVisibility(8);
            if (this.f1010c.f1043r != null) {
                this.f1010c.f1043r.setVisibility(8);
            }
            if (this.f1010c.f1049x != null) {
                this.f1010c.f1049x.setVisibility(8);
            }
            if (this.f1010c.f1047v != null) {
                this.f1010c.f1047v.setVisibility(8);
            }
            if (this.f1010c.f1050y != null) {
                this.f1010c.f1050y.setVisibility(8);
            }
            this.f1010c.requestLayout();
            item.m1940e(true);
            if (this.f1010c.f1032g instanceof C0365b) {
                ((C0365b) this.f1010c.f1032g).m1704a();
            }
            return true;
        }

        public boolean m2057b(C0397f menu, C0399h item) {
            if (this.f1010c.f1032g instanceof C0365b) {
                ((C0365b) this.f1010c.f1032g).m1705b();
            }
            this.f1010c.removeView(this.f1010c.f1032g);
            this.f1010c.removeView(this.f1010c.f1042q);
            this.f1010c.f1032g = null;
            if ((this.f1010c.f1035j & 2) != 0) {
                this.f1010c.f1041p.setVisibility(0);
            }
            if ((this.f1010c.f1035j & 8) != 0) {
                if (this.f1010c.f1043r == null) {
                    this.f1010c.m2074n();
                } else {
                    this.f1010c.f1043r.setVisibility(0);
                }
            }
            if (this.f1010c.f1049x != null && this.f1010c.f1034i == 2) {
                this.f1010c.f1049x.setVisibility(0);
            }
            if (this.f1010c.f1047v != null && this.f1010c.f1034i == 1) {
                this.f1010c.f1047v.setVisibility(0);
            }
            if (!(this.f1010c.f1050y == null || (this.f1010c.f1035j & 16) == 0)) {
                this.f1010c.f1050y.setVisibility(0);
            }
            this.f1010c.f1042q.m2048a(null);
            this.f1009b = null;
            this.f1010c.requestLayout();
            item.m1940e(false);
            return true;
        }
    }

    public /* bridge */ /* synthetic */ boolean m2077a() {
        return super.m2022a();
    }

    public /* bridge */ /* synthetic */ void m2078b() {
        super.m2024b();
    }

    public /* bridge */ /* synthetic */ boolean m2079c() {
        return super.m2026c();
    }

    public /* bridge */ /* synthetic */ boolean m2080d() {
        return super.m2027d();
    }

    public /* bridge */ /* synthetic */ boolean m2081e() {
        return super.m2028e();
    }

    public /* bridge */ /* synthetic */ void m2082f() {
        super.m2029f();
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ void setContentHeight(int x0) {
        super.setContentHeight(x0);
    }

    public /* bridge */ /* synthetic */ void setSplitView(ActionBarContainer x0) {
        super.setSplitView(x0);
    }

    public /* bridge */ /* synthetic */ void setSplitWhenNarrow(boolean x0) {
        super.setSplitWhenNarrow(x0);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int x0) {
        super.setVisibility(x0);
    }

    public ActionBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f1035j = -1;
        this.f1029S = new C04201(this);
        this.f1030T = new C04212(this);
        this.f1031U = new C04223(this);
        this.f1040o = context;
        setBackgroundResource(0);
        TypedArray a = context.obtainStyledAttributes(attrs, C0363j.ActionBar, C0355b.actionBarStyle, 0);
        ApplicationInfo appInfo = context.getApplicationInfo();
        PackageManager pm = context.getPackageManager();
        this.f1034i = a.getInt(2, 0);
        this.f1036k = a.getText(0);
        this.f1037l = a.getText(4);
        this.f1039n = a.getDrawable(8);
        if (this.f1039n == null && VERSION.SDK_INT >= 9) {
            if (context instanceof Activity) {
                try {
                    this.f1039n = pm.getActivityLogo(((Activity) context).getComponentName());
                } catch (NameNotFoundException e) {
                    Log.e("ActionBarView", "Activity component name not found!", e);
                }
            }
            if (this.f1039n == null) {
                this.f1039n = appInfo.loadLogo(pm);
            }
        }
        this.f1038m = a.getDrawable(7);
        if (this.f1038m == null) {
            if (context instanceof Activity) {
                try {
                    this.f1038m = pm.getActivityIcon(((Activity) context).getComponentName());
                } catch (NameNotFoundException e2) {
                    Log.e("ActionBarView", "Activity component name not found!", e2);
                }
            }
            if (this.f1038m == null) {
                this.f1038m = appInfo.loadIcon(pm);
            }
        }
        LayoutInflater inflater = LayoutInflater.from(context);
        int homeResId = a.getResourceId(14, C0360g.abc_action_bar_home);
        this.f1041p = (HomeView) inflater.inflate(homeResId, this, false);
        this.f1042q = (HomeView) inflater.inflate(homeResId, this, false);
        this.f1042q.m2049a(true);
        this.f1042q.setOnClickListener(this.f1030T);
        this.f1042q.setContentDescription(getResources().getText(C0361h.abc_action_bar_up_description));
        this.f1014D = a.getResourceId(5, 0);
        this.f1015E = a.getResourceId(6, 0);
        this.f1016F = a.getResourceId(15, 0);
        this.f1017G = a.getResourceId(16, 0);
        this.f1012B = a.getDimensionPixelOffset(17, 0);
        this.f1013C = a.getDimensionPixelOffset(18, 0);
        setDisplayOptions(a.getInt(3, 0));
        int customNavId = a.getResourceId(13, 0);
        if (customNavId != 0) {
            this.f1050y = inflater.inflate(customNavId, this, false);
            this.f1034i = 0;
            setDisplayOptions(this.f1035j | 16);
        }
        this.f = a.getLayoutDimension(1, 0);
        a.recycle();
        this.f1024N = new C0392a(context, 0, 16908332, 0, 0, this.f1036k);
        this.f1041p.setOnClickListener(this.f1031U);
        this.f1041p.setClickable(true);
        this.f1041p.setFocusable(true);
    }

    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.f1044s = null;
        this.f1045t = null;
        this.f1046u = null;
        if (this.f1043r != null && this.f1043r.getParent() == this) {
            removeView(this.f1043r);
        }
        this.f1043r = null;
        if ((this.f1035j & 8) != 0) {
            m2074n();
        }
        if (this.f1049x != null && this.f1019I) {
            ViewGroup.LayoutParams lp = this.f1049x.getLayoutParams();
            if (lp != null) {
                lp.width = -2;
                lp.height = -1;
            }
            this.f1049x.setAllowCollapse(true);
        }
        if (this.f1051z != null) {
            removeView(this.f1051z);
            m2083g();
        }
        if (this.f1011A != null) {
            removeView(this.f1011A);
            m2084h();
        }
    }

    public void setWindowCallback(Callback cb) {
        this.f1033h = cb;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1027Q);
        if (this.b != null) {
            this.b.m1818b();
            this.b.m1822d();
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void m2083g() {
        this.f1051z = new ProgressBarICS(this.f1040o, null, 0, this.f1016F);
        this.f1051z.setId(C0358e.progress_horizontal);
        this.f1051z.setMax(CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY);
        this.f1051z.setVisibility(8);
        addView(this.f1051z);
    }

    public void m2084h() {
        this.f1011A = new ProgressBarICS(this.f1040o, null, 0, this.f1017G);
        this.f1011A.setId(C0358e.progress_circular);
        this.f1011A.setVisibility(8);
        addView(this.f1011A);
    }

    public void setSplitActionBar(boolean splitActionBar) {
        if (this.d != splitActionBar) {
            if (this.a != null) {
                ViewGroup oldParent = (ViewGroup) this.a.getParent();
                if (oldParent != null) {
                    oldParent.removeView(this.a);
                }
                if (splitActionBar) {
                    if (this.c != null) {
                        this.c.addView(this.a);
                    }
                    this.a.getLayoutParams().width = -1;
                } else {
                    addView(this.a);
                    this.a.getLayoutParams().width = -2;
                }
                this.a.requestLayout();
            }
            if (this.c != null) {
                this.c.setVisibility(splitActionBar ? 0 : 8);
            }
            if (this.b != null) {
                if (splitActionBar) {
                    this.b.m1819c(false);
                    this.b.m1807a(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    this.b.m1806a(Integer.MAX_VALUE);
                } else {
                    this.b.m1819c(getResources().getBoolean(C0356c.abc_action_bar_expanded_action_views_exclusive));
                }
            }
            super.setSplitActionBar(splitActionBar);
        }
    }

    public boolean m2085i() {
        return this.d;
    }

    public boolean m2086j() {
        return this.f1019I;
    }

    public void setEmbeddedTabView(ScrollingTabContainerView tabs) {
        if (this.f1049x != null) {
            removeView(this.f1049x);
        }
        this.f1049x = tabs;
        this.f1019I = tabs != null;
        if (this.f1019I && this.f1034i == 2) {
            addView(this.f1049x);
            ViewGroup.LayoutParams lp = this.f1049x.getLayoutParams();
            lp.width = -2;
            lp.height = -1;
            tabs.setAllowCollapse(true);
        }
    }

    public void setCallback(C0325d callback) {
        this.f1026P = callback;
    }

    public void m2076a(C0127a menu, C0335a cb) {
        if (menu != this.f1022L) {
            ViewGroup oldParent;
            ActionMenuView menuView;
            if (this.f1022L != null) {
                this.f1022L.m1900b(this.b);
                this.f1022L.m1900b(this.f1028R);
            }
            C0397f builder = (C0397f) menu;
            this.f1022L = builder;
            if (this.a != null) {
                oldParent = (ViewGroup) this.a.getParent();
                if (oldParent != null) {
                    oldParent.removeView(this.a);
                }
            }
            if (this.b == null) {
                this.b = new ActionMenuPresenter(this.f1040o);
                this.b.m1789a(cb);
                this.b.m1796b(C0358e.action_menu_presenter);
                this.f1028R = new C0424a();
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
            if (this.d) {
                this.b.m1819c(false);
                this.b.m1807a(getContext().getResources().getDisplayMetrics().widthPixels, true);
                this.b.m1806a(Integer.MAX_VALUE);
                layoutParams.width = -1;
                m2061a(builder);
                menuView = (ActionMenuView) this.b.m1804a((ViewGroup) this);
                if (this.c != null) {
                    oldParent = (ViewGroup) menuView.getParent();
                    if (!(oldParent == null || oldParent == this.c)) {
                        oldParent.removeView(menuView);
                    }
                    menuView.setVisibility(getAnimatedVisibility());
                    this.c.addView(menuView, layoutParams);
                } else {
                    menuView.setLayoutParams(layoutParams);
                }
            } else {
                this.b.m1819c(getResources().getBoolean(C0356c.abc_action_bar_expanded_action_views_exclusive));
                m2061a(builder);
                menuView = (ActionMenuView) this.b.m1804a((ViewGroup) this);
                menuView.m1838a(builder);
                oldParent = (ViewGroup) menuView.getParent();
                if (!(oldParent == null || oldParent == this)) {
                    oldParent.removeView(menuView);
                }
                addView(menuView, layoutParams);
            }
            this.a = menuView;
        }
    }

    private void m2061a(C0397f builder) {
        if (builder != null) {
            builder.m1891a(this.b);
            builder.m1891a(this.f1028R);
        } else {
            this.b.m1808a(this.f1040o, null);
            this.f1028R.m2053a(this.f1040o, null);
        }
        this.b.m1821d(true);
        this.f1028R.m2058d(true);
    }

    public boolean m2087k() {
        return (this.f1028R == null || this.f1028R.f1009b == null) ? false : true;
    }

    public void m2088l() {
        C0399h item = this.f1028R == null ? null : this.f1028R.f1009b;
        if (item != null) {
            item.collapseActionView();
        }
    }

    public void setCustomNavigationView(View view) {
        boolean showCustom = (this.f1035j & 16) != 0;
        if (this.f1050y != null && showCustom) {
            removeView(this.f1050y);
        }
        this.f1050y = view;
        if (this.f1050y != null && showCustom) {
            addView(this.f1050y);
        }
    }

    public CharSequence getTitle() {
        return this.f1036k;
    }

    public void setTitle(CharSequence title) {
        this.f1018H = true;
        setTitleImpl(title);
    }

    public void setWindowTitle(CharSequence title) {
        if (!this.f1018H) {
            setTitleImpl(title);
        }
    }

    private void setTitleImpl(CharSequence title) {
        int i = 0;
        this.f1036k = title;
        if (this.f1044s != null) {
            this.f1044s.setText(title);
            boolean visible = (this.f1032g != null || (this.f1035j & 8) == 0 || (TextUtils.isEmpty(this.f1036k) && TextUtils.isEmpty(this.f1037l))) ? false : true;
            LinearLayout linearLayout = this.f1043r;
            if (!visible) {
                i = 8;
            }
            linearLayout.setVisibility(i);
        }
        if (this.f1024N != null) {
            this.f1024N.setTitle(title);
        }
    }

    public CharSequence getSubtitle() {
        return this.f1037l;
    }

    public void setSubtitle(CharSequence subtitle) {
        int i = 0;
        this.f1037l = subtitle;
        if (this.f1045t != null) {
            boolean visible;
            this.f1045t.setText(subtitle);
            this.f1045t.setVisibility(subtitle != null ? 0 : 8);
            if (this.f1032g != null || (this.f1035j & 8) == 0 || (TextUtils.isEmpty(this.f1036k) && TextUtils.isEmpty(this.f1037l))) {
                visible = false;
            } else {
                visible = true;
            }
            LinearLayout linearLayout = this.f1043r;
            if (!visible) {
                i = 8;
            }
            linearLayout.setVisibility(i);
        }
    }

    public void setHomeButtonEnabled(boolean enable) {
        this.f1041p.setEnabled(enable);
        this.f1041p.setFocusable(enable);
        if (!enable) {
            this.f1041p.setContentDescription(null);
        } else if ((this.f1035j & 4) != 0) {
            this.f1041p.setContentDescription(this.f1040o.getResources().getText(C0361h.abc_action_bar_up_description));
        } else {
            this.f1041p.setContentDescription(this.f1040o.getResources().getText(C0361h.abc_action_bar_home_description));
        }
    }

    public void setDisplayOptions(int options) {
        int i = 8;
        int flagsChanged = -1;
        boolean z = true;
        if (this.f1035j != -1) {
            flagsChanged = options ^ this.f1035j;
        }
        this.f1035j = options;
        if ((flagsChanged & 31) != 0) {
            boolean showHome;
            int vis;
            if ((options & 2) != 0) {
                showHome = true;
            } else {
                showHome = false;
            }
            if (showHome && this.f1032g == null) {
                vis = 0;
            } else {
                vis = 8;
            }
            this.f1041p.setVisibility(vis);
            if ((flagsChanged & 4) != 0) {
                boolean setUp;
                if ((options & 4) != 0) {
                    setUp = true;
                } else {
                    setUp = false;
                }
                this.f1041p.m2049a(setUp);
                if (setUp) {
                    setHomeButtonEnabled(true);
                }
            }
            if ((flagsChanged & 1) != 0) {
                boolean logoVis = (this.f1039n == null || (options & 1) == 0) ? false : true;
                this.f1041p.m2048a(logoVis ? this.f1039n : this.f1038m);
            }
            if ((flagsChanged & 8) != 0) {
                if ((options & 8) != 0) {
                    m2074n();
                } else {
                    removeView(this.f1043r);
                }
            }
            if (!(this.f1043r == null || (flagsChanged & 6) == 0)) {
                boolean homeAsUp;
                if ((this.f1035j & 4) != 0) {
                    homeAsUp = true;
                } else {
                    homeAsUp = false;
                }
                View view = this.f1046u;
                if (!showHome) {
                    i = homeAsUp ? 0 : 4;
                }
                view.setVisibility(i);
                LinearLayout linearLayout = this.f1043r;
                if (showHome || !homeAsUp) {
                    z = false;
                }
                linearLayout.setEnabled(z);
            }
            if (!((flagsChanged & 16) == 0 || this.f1050y == null)) {
                if ((options & 16) != 0) {
                    addView(this.f1050y);
                } else {
                    removeView(this.f1050y);
                }
            }
            requestLayout();
        } else {
            invalidate();
        }
        if (!this.f1041p.isEnabled()) {
            this.f1041p.setContentDescription(null);
        } else if ((options & 4) != 0) {
            this.f1041p.setContentDescription(this.f1040o.getResources().getText(C0361h.abc_action_bar_up_description));
        } else {
            this.f1041p.setContentDescription(this.f1040o.getResources().getText(C0361h.abc_action_bar_home_description));
        }
    }

    public void setIcon(Drawable icon) {
        this.f1038m = icon;
        if (icon != null && ((this.f1035j & 1) == 0 || this.f1039n == null)) {
            this.f1041p.m2048a(icon);
        }
        if (this.f1032g != null) {
            this.f1042q.m2048a(this.f1038m.getConstantState().newDrawable(getResources()));
        }
    }

    public void setIcon(int resId) {
        setIcon(this.f1040o.getResources().getDrawable(resId));
    }

    public void setLogo(Drawable logo) {
        this.f1039n = logo;
        if (logo != null && (this.f1035j & 1) != 0) {
            this.f1041p.m2048a(logo);
        }
    }

    public void setLogo(int resId) {
        setLogo(this.f1040o.getResources().getDrawable(resId));
    }

    public void setNavigationMode(int mode) {
        int oldMode = this.f1034i;
        if (mode != oldMode) {
            switch (oldMode) {
                case Base64.NO_PADDING /*1*/:
                    if (this.f1048w != null) {
                        removeView(this.f1048w);
                        break;
                    }
                    break;
                case Base64.NO_WRAP /*2*/:
                    if (this.f1049x != null && this.f1019I) {
                        removeView(this.f1049x);
                        break;
                    }
            }
            switch (mode) {
                case Base64.NO_PADDING /*1*/:
                    if (this.f1047v == null) {
                        this.f1047v = new C0467g(this.f1040o, null, C0355b.actionDropDownStyle);
                        this.f1048w = (LinearLayout) LayoutInflater.from(this.f1040o).inflate(C0360g.abc_action_bar_view_list_nav_layout, null);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, -1);
                        params.gravity = 17;
                        this.f1048w.addView(this.f1047v, params);
                    }
                    if (this.f1047v.m2017d() != this.f1025O) {
                        this.f1047v.m2226a(this.f1025O);
                    }
                    this.f1047v.m1992a(this.f1029S);
                    addView(this.f1048w);
                    break;
                case Base64.NO_WRAP /*2*/:
                    if (this.f1049x != null && this.f1019I) {
                        addView(this.f1049x);
                        break;
                    }
            }
            this.f1034i = mode;
            requestLayout();
        }
    }

    public void setDropdownAdapter(SpinnerAdapter adapter) {
        this.f1025O = adapter;
        if (this.f1047v != null) {
            this.f1047v.m2226a(adapter);
        }
    }

    public SpinnerAdapter getDropdownAdapter() {
        return this.f1025O;
    }

    public void setDropdownSelectedPosition(int position) {
        this.f1047v.m2012a(position);
    }

    public int getDropdownSelectedPosition() {
        return this.f1047v.m1999f();
    }

    public View getCustomNavigationView() {
        return this.f1050y;
    }

    public int getNavigationMode() {
        return this.f1034i;
    }

    public int getDisplayOptions() {
        return this.f1035j;
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0323b(19);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        addView(this.f1041p);
        if (this.f1050y != null && (this.f1035j & 16) != 0) {
            ActionBarView parent = this.f1050y.getParent();
            if (parent != this) {
                if (parent instanceof ViewGroup) {
                    parent.removeView(this.f1050y);
                }
                addView(this.f1050y);
            }
        }
    }

    private void m2074n() {
        boolean z = true;
        if (this.f1043r == null) {
            boolean homeAsUp;
            boolean showHome;
            this.f1043r = (LinearLayout) LayoutInflater.from(getContext()).inflate(C0360g.abc_action_bar_title_item, this, false);
            this.f1044s = (TextView) this.f1043r.findViewById(C0358e.action_bar_title);
            this.f1045t = (TextView) this.f1043r.findViewById(C0358e.action_bar_subtitle);
            this.f1046u = this.f1043r.findViewById(C0358e.up);
            this.f1043r.setOnClickListener(this.f1031U);
            if (this.f1014D != 0) {
                this.f1044s.setTextAppearance(this.f1040o, this.f1014D);
            }
            if (this.f1036k != null) {
                this.f1044s.setText(this.f1036k);
            }
            if (this.f1015E != 0) {
                this.f1045t.setTextAppearance(this.f1040o, this.f1015E);
            }
            if (this.f1037l != null) {
                this.f1045t.setText(this.f1037l);
                this.f1045t.setVisibility(0);
            }
            if ((this.f1035j & 4) != 0) {
                homeAsUp = true;
            } else {
                homeAsUp = false;
            }
            if ((this.f1035j & 2) != 0) {
                showHome = true;
            } else {
                showHome = false;
            }
            View view = this.f1046u;
            int i = !showHome ? homeAsUp ? 0 : 4 : 8;
            view.setVisibility(i);
            LinearLayout linearLayout = this.f1043r;
            if (!homeAsUp || showHome) {
                z = false;
            }
            linearLayout.setEnabled(z);
        }
        addView(this.f1043r);
        if (this.f1032g != null || (TextUtils.isEmpty(this.f1036k) && TextUtils.isEmpty(this.f1037l))) {
            this.f1043r.setVisibility(8);
        }
    }

    public void setContextView(ActionBarContextView view) {
        this.f1023M = view;
    }

    public void setCollapsable(boolean collapsable) {
        this.f1020J = collapsable;
    }

    public boolean m2089m() {
        return this.f1021K;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        int childCount = getChildCount();
        if (this.f1020J) {
            int visibleChildren = 0;
            for (i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                if (child.getVisibility() != 8) {
                    View view = this.a;
                    if (child == r0) {
                        if (this.a.getChildCount() == 0) {
                        }
                    }
                    visibleChildren++;
                }
            }
            if (visibleChildren == 0) {
                setMeasuredDimension(0, 0);
                this.f1021K = true;
                return;
            }
        }
        this.f1021K = false;
        if (MeasureSpec.getMode(widthMeasureSpec) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"MATCH_PARENT\" (or fill_parent)");
        } else if (MeasureSpec.getMode(heightMeasureSpec) != Integer.MIN_VALUE) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            ViewGroup.LayoutParams lp;
            boolean showTitle;
            int itemPaddingSize;
            int listNavWidth;
            int tabWidth;
            View customView;
            C0323b ablp;
            int horizontalMargin;
            int verticalMargin;
            int customNavHeightMode;
            int i2;
            int customNavHeight;
            int customNavWidthMode;
            int customNavWidth;
            int measuredHeight;
            int paddedViewHeight;
            int contentWidth = MeasureSpec.getSize(widthMeasureSpec);
            int maxHeight = this.f > 0 ? this.f : MeasureSpec.getSize(heightMeasureSpec);
            int verticalPadding = getPaddingTop() + getPaddingBottom();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int height = maxHeight - verticalPadding;
            int childSpecHeight = MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE);
            int availableWidth = (contentWidth - paddingLeft) - paddingRight;
            int leftOfCenter = availableWidth / 2;
            int rightOfCenter = leftOfCenter;
            HomeView homeLayout = this.f1032g != null ? this.f1042q : this.f1041p;
            if (homeLayout.getVisibility() != 8) {
                int homeWidthSpec;
                lp = homeLayout.getLayoutParams();
                if (lp.width < 0) {
                    homeWidthSpec = MeasureSpec.makeMeasureSpec(availableWidth, Integer.MIN_VALUE);
                } else {
                    homeWidthSpec = MeasureSpec.makeMeasureSpec(lp.width, 1073741824);
                }
                homeLayout.measure(homeWidthSpec, MeasureSpec.makeMeasureSpec(height, 1073741824));
                int homeWidth = homeLayout.getMeasuredWidth() + homeLayout.m2046a();
                availableWidth = Math.max(0, availableWidth - homeWidth);
                leftOfCenter = Math.max(0, availableWidth - homeWidth);
            }
            if (this.a != null) {
                if (this.a.getParent() == this) {
                    availableWidth = m2020a(this.a, availableWidth, childSpecHeight, 0);
                    rightOfCenter = Math.max(0, rightOfCenter - this.a.getMeasuredWidth());
                }
            }
            if (this.f1011A != null) {
                if (this.f1011A.getVisibility() != 8) {
                    availableWidth = m2020a(this.f1011A, availableWidth, childSpecHeight, 0);
                    rightOfCenter = Math.max(0, rightOfCenter - this.f1011A.getMeasuredWidth());
                }
            }
            if (this.f1043r != null) {
                if (this.f1043r.getVisibility() != 8) {
                    if ((this.f1035j & 8) != 0) {
                        showTitle = true;
                        if (this.f1032g == null) {
                            switch (this.f1034i) {
                                case Base64.NO_PADDING /*1*/:
                                    if (this.f1048w != null) {
                                        if (showTitle) {
                                            itemPaddingSize = this.f1013C;
                                        } else {
                                            itemPaddingSize = this.f1013C * 2;
                                        }
                                        availableWidth = Math.max(0, availableWidth - itemPaddingSize);
                                        leftOfCenter = Math.max(0, leftOfCenter - itemPaddingSize);
                                        this.f1048w.measure(MeasureSpec.makeMeasureSpec(availableWidth, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(height, 1073741824));
                                        listNavWidth = this.f1048w.getMeasuredWidth();
                                        availableWidth = Math.max(0, availableWidth - listNavWidth);
                                        leftOfCenter = Math.max(0, leftOfCenter - listNavWidth);
                                        break;
                                    }
                                    break;
                                case Base64.NO_WRAP /*2*/:
                                    if (this.f1049x != null) {
                                        if (showTitle) {
                                            itemPaddingSize = this.f1013C;
                                        } else {
                                            itemPaddingSize = this.f1013C * 2;
                                        }
                                        availableWidth = Math.max(0, availableWidth - itemPaddingSize);
                                        leftOfCenter = Math.max(0, leftOfCenter - itemPaddingSize);
                                        this.f1049x.measure(MeasureSpec.makeMeasureSpec(availableWidth, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(height, 1073741824));
                                        tabWidth = this.f1049x.getMeasuredWidth();
                                        availableWidth = Math.max(0, availableWidth - tabWidth);
                                        leftOfCenter = Math.max(0, leftOfCenter - tabWidth);
                                        break;
                                    }
                                    break;
                            }
                        }
                        customView = null;
                        if (this.f1032g == null) {
                            customView = this.f1032g;
                        } else {
                            if (!((this.f1035j & 16) == 0 || this.f1050y == null)) {
                                customView = this.f1050y;
                            }
                        }
                        if (customView != null) {
                            lp = generateLayoutParams(customView.getLayoutParams());
                            ablp = lp instanceof C0323b ? (C0323b) lp : null;
                            horizontalMargin = 0;
                            verticalMargin = 0;
                            if (ablp != null) {
                                horizontalMargin = ablp.leftMargin + ablp.rightMargin;
                                verticalMargin = ablp.topMargin + ablp.bottomMargin;
                            }
                            if (this.f > 0) {
                                customNavHeightMode = Integer.MIN_VALUE;
                            } else {
                                i2 = lp.height;
                                customNavHeightMode = r0 == -2 ? 1073741824 : Integer.MIN_VALUE;
                            }
                            if (lp.height >= 0) {
                                height = Math.min(lp.height, height);
                            }
                            customNavHeight = Math.max(0, height - verticalMargin);
                            i2 = lp.width;
                            customNavWidthMode = r0 == -2 ? 1073741824 : Integer.MIN_VALUE;
                            if (lp.width < 0) {
                                i2 = Math.min(lp.width, availableWidth);
                            } else {
                                i2 = availableWidth;
                            }
                            customNavWidth = Math.max(0, i2 - horizontalMargin);
                            if (((ablp == null ? ablp.f611a : 19) & 7) == 1) {
                                i2 = lp.width;
                                if (r0 == -1) {
                                    customNavWidth = Math.min(leftOfCenter, rightOfCenter) * 2;
                                }
                            }
                            customView.measure(MeasureSpec.makeMeasureSpec(customNavWidth, customNavWidthMode), MeasureSpec.makeMeasureSpec(customNavHeight, customNavHeightMode));
                            availableWidth -= customView.getMeasuredWidth() + horizontalMargin;
                        }
                        if (this.f1032g == null && showTitle) {
                            availableWidth = m2020a(this.f1043r, availableWidth, MeasureSpec.makeMeasureSpec(this.f, 1073741824), 0);
                            leftOfCenter = Math.max(0, leftOfCenter - this.f1043r.getMeasuredWidth());
                        }
                        if (this.f > 0) {
                            measuredHeight = 0;
                            for (i = 0; i < childCount; i++) {
                                paddedViewHeight = getChildAt(i).getMeasuredHeight() + verticalPadding;
                                if (paddedViewHeight > measuredHeight) {
                                    measuredHeight = paddedViewHeight;
                                }
                            }
                            setMeasuredDimension(contentWidth, measuredHeight);
                        } else {
                            setMeasuredDimension(contentWidth, maxHeight);
                        }
                        if (this.f1023M != null) {
                            this.f1023M.setContentHeight(getMeasuredHeight());
                        }
                        if (this.f1051z != null) {
                            if (this.f1051z.getVisibility() != 8) {
                                this.f1051z.measure(MeasureSpec.makeMeasureSpec(contentWidth - (this.f1012B * 2), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Integer.MIN_VALUE));
                            }
                        }
                    }
                }
            }
            showTitle = false;
            if (this.f1032g == null) {
                switch (this.f1034i) {
                    case Base64.NO_PADDING /*1*/:
                        if (this.f1048w != null) {
                            if (showTitle) {
                                itemPaddingSize = this.f1013C;
                            } else {
                                itemPaddingSize = this.f1013C * 2;
                            }
                            availableWidth = Math.max(0, availableWidth - itemPaddingSize);
                            leftOfCenter = Math.max(0, leftOfCenter - itemPaddingSize);
                            this.f1048w.measure(MeasureSpec.makeMeasureSpec(availableWidth, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(height, 1073741824));
                            listNavWidth = this.f1048w.getMeasuredWidth();
                            availableWidth = Math.max(0, availableWidth - listNavWidth);
                            leftOfCenter = Math.max(0, leftOfCenter - listNavWidth);
                            break;
                        }
                        break;
                    case Base64.NO_WRAP /*2*/:
                        if (this.f1049x != null) {
                            if (showTitle) {
                                itemPaddingSize = this.f1013C;
                            } else {
                                itemPaddingSize = this.f1013C * 2;
                            }
                            availableWidth = Math.max(0, availableWidth - itemPaddingSize);
                            leftOfCenter = Math.max(0, leftOfCenter - itemPaddingSize);
                            this.f1049x.measure(MeasureSpec.makeMeasureSpec(availableWidth, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(height, 1073741824));
                            tabWidth = this.f1049x.getMeasuredWidth();
                            availableWidth = Math.max(0, availableWidth - tabWidth);
                            leftOfCenter = Math.max(0, leftOfCenter - tabWidth);
                            break;
                        }
                        break;
                }
            }
            customView = null;
            if (this.f1032g == null) {
                customView = this.f1050y;
            } else {
                customView = this.f1032g;
            }
            if (customView != null) {
                lp = generateLayoutParams(customView.getLayoutParams());
                if (lp instanceof C0323b) {
                }
                horizontalMargin = 0;
                verticalMargin = 0;
                if (ablp != null) {
                    horizontalMargin = ablp.leftMargin + ablp.rightMargin;
                    verticalMargin = ablp.topMargin + ablp.bottomMargin;
                }
                if (this.f > 0) {
                    i2 = lp.height;
                    if (r0 == -2) {
                    }
                } else {
                    customNavHeightMode = Integer.MIN_VALUE;
                }
                if (lp.height >= 0) {
                    height = Math.min(lp.height, height);
                }
                customNavHeight = Math.max(0, height - verticalMargin);
                i2 = lp.width;
                if (r0 == -2) {
                }
                if (lp.width < 0) {
                    i2 = availableWidth;
                } else {
                    i2 = Math.min(lp.width, availableWidth);
                }
                customNavWidth = Math.max(0, i2 - horizontalMargin);
                if (ablp == null) {
                }
                if (((ablp == null ? ablp.f611a : 19) & 7) == 1) {
                    i2 = lp.width;
                    if (r0 == -1) {
                        customNavWidth = Math.min(leftOfCenter, rightOfCenter) * 2;
                    }
                }
                customView.measure(MeasureSpec.makeMeasureSpec(customNavWidth, customNavWidthMode), MeasureSpec.makeMeasureSpec(customNavHeight, customNavHeightMode));
                availableWidth -= customView.getMeasuredWidth() + horizontalMargin;
            }
            availableWidth = m2020a(this.f1043r, availableWidth, MeasureSpec.makeMeasureSpec(this.f, 1073741824), 0);
            leftOfCenter = Math.max(0, leftOfCenter - this.f1043r.getMeasuredWidth());
            if (this.f > 0) {
                setMeasuredDimension(contentWidth, maxHeight);
            } else {
                measuredHeight = 0;
                for (i = 0; i < childCount; i++) {
                    paddedViewHeight = getChildAt(i).getMeasuredHeight() + verticalPadding;
                    if (paddedViewHeight > measuredHeight) {
                        measuredHeight = paddedViewHeight;
                    }
                }
                setMeasuredDimension(contentWidth, measuredHeight);
            }
            if (this.f1023M != null) {
                this.f1023M.setContentHeight(getMeasuredHeight());
            }
            if (this.f1051z != null) {
                if (this.f1051z.getVisibility() != 8) {
                    this.f1051z.measure(MeasureSpec.makeMeasureSpec(contentWidth - (this.f1012B * 2), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Integer.MIN_VALUE));
                }
            }
        }
    }

    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int x = getPaddingLeft();
        int y = getPaddingTop();
        int contentHeight = ((b - t) - getPaddingTop()) - getPaddingBottom();
        if (contentHeight > 0) {
            HomeView homeLayout = this.f1032g != null ? this.f1042q : this.f1041p;
            if (homeLayout.getVisibility() != 8) {
                int leftOffset = homeLayout.m2046a();
                x += m2023b(homeLayout, x + leftOffset, y, contentHeight) + leftOffset;
            }
            if (this.f1032g == null) {
                boolean showTitle;
                if (this.f1043r != null) {
                    if (this.f1043r.getVisibility() != 8) {
                        if ((this.f1035j & 8) != 0) {
                            showTitle = true;
                            if (showTitle) {
                                x += m2023b(this.f1043r, x, y, contentHeight);
                            }
                            switch (this.f1034i) {
                                case Base64.NO_PADDING /*1*/:
                                    if (this.f1048w != null) {
                                        if (showTitle) {
                                            x += this.f1013C;
                                        }
                                        x += m2023b(this.f1048w, x, y, contentHeight) + this.f1013C;
                                        break;
                                    }
                                    break;
                                case Base64.NO_WRAP /*2*/:
                                    if (this.f1049x != null) {
                                        if (showTitle) {
                                            x += this.f1013C;
                                        }
                                        x += m2023b(this.f1049x, x, y, contentHeight) + this.f1013C;
                                        break;
                                    }
                                    break;
                            }
                        }
                    }
                }
                showTitle = false;
                if (showTitle) {
                    x += m2023b(this.f1043r, x, y, contentHeight);
                }
                switch (this.f1034i) {
                    case Base64.NO_PADDING /*1*/:
                        if (this.f1048w != null) {
                            if (showTitle) {
                                x += this.f1013C;
                            }
                            x += m2023b(this.f1048w, x, y, contentHeight) + this.f1013C;
                            break;
                        }
                        break;
                    case Base64.NO_WRAP /*2*/:
                        if (this.f1049x != null) {
                            if (showTitle) {
                                x += this.f1013C;
                            }
                            x += m2023b(this.f1049x, x, y, contentHeight) + this.f1013C;
                            break;
                        }
                        break;
                }
            }
            int menuLeft = (r - l) - getPaddingRight();
            if (this.a != null) {
                if (this.a.getParent() == this) {
                    m2025c(this.a, menuLeft, y, contentHeight);
                    menuLeft -= this.a.getMeasuredWidth();
                }
            }
            if (this.f1011A != null) {
                if (this.f1011A.getVisibility() != 8) {
                    m2025c(this.f1011A, menuLeft, y, contentHeight);
                    menuLeft -= this.f1011A.getMeasuredWidth();
                }
            }
            View customView = null;
            if (this.f1032g != null) {
                customView = this.f1032g;
            } else {
                if (!((this.f1035j & 16) == 0 || this.f1050y == null)) {
                    customView = this.f1050y;
                }
            }
            if (customView != null) {
                ViewGroup.LayoutParams lp = customView.getLayoutParams();
                C0323b ablp = lp instanceof C0323b ? (C0323b) lp : null;
                int gravity = ablp != null ? ablp.f611a : 19;
                int navWidth = customView.getMeasuredWidth();
                int topMargin = 0;
                int bottomMargin = 0;
                if (ablp != null) {
                    x += ablp.leftMargin;
                    menuLeft -= ablp.rightMargin;
                    topMargin = ablp.topMargin;
                    bottomMargin = ablp.bottomMargin;
                }
                int hgravity = gravity & 7;
                if (hgravity == 1) {
                    int centeredLeft = (getWidth() - navWidth) / 2;
                    if (centeredLeft < x) {
                        hgravity = 3;
                    } else if (centeredLeft + navWidth > menuLeft) {
                        hgravity = 5;
                    }
                } else if (gravity == -1) {
                    hgravity = 3;
                }
                int xpos = 0;
                switch (hgravity) {
                    case Base64.NO_PADDING /*1*/:
                        xpos = (getWidth() - navWidth) / 2;
                        break;
                    case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        xpos = x;
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        xpos = menuLeft - navWidth;
                        break;
                }
                int vgravity = gravity & 112;
                if (gravity == -1) {
                    vgravity = 16;
                }
                int ypos = 0;
                switch (vgravity) {
                    case Base64.NO_CLOSE /*16*/:
                        ypos = (((getHeight() - getPaddingBottom()) - getPaddingTop()) - customView.getMeasuredHeight()) / 2;
                        break;
                    case 48:
                        ypos = getPaddingTop() + topMargin;
                        break;
                    case 80:
                        ypos = ((getHeight() - getPaddingBottom()) - customView.getMeasuredHeight()) - bottomMargin;
                        break;
                }
                int customWidth = customView.getMeasuredWidth();
                customView.layout(xpos, ypos, xpos + customWidth, customView.getMeasuredHeight() + ypos);
                x += customWidth;
            }
            if (this.f1051z != null) {
                this.f1051z.bringToFront();
                int halfProgressHeight = this.f1051z.getMeasuredHeight() / 2;
                this.f1051z.layout(this.f1012B, -halfProgressHeight, this.f1012B + this.f1051z.getMeasuredWidth(), halfProgressHeight);
            }
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new C0323b(getContext(), attrs);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        if (lp == null) {
            return generateDefaultLayoutParams();
        }
        return lp;
    }

    public Parcelable onSaveInstanceState() {
        SavedState state = new SavedState(super.onSaveInstanceState());
        if (!(this.f1028R == null || this.f1028R.f1009b == null)) {
            state.f1006a = this.f1028R.f1009b.getItemId();
        }
        state.f1007b = m2080d();
        return state;
    }

    public void onRestoreInstanceState(Parcelable p) {
        SavedState state = (SavedState) p;
        super.onRestoreInstanceState(state.getSuperState());
        if (!(state.f1006a == 0 || this.f1028R == null || this.f1022L == null)) {
            C0128b item = (C0128b) this.f1022L.findItem(state.f1006a);
            if (item != null) {
                item.expandActionView();
            }
        }
        if (state.f1007b) {
            m2078b();
        }
    }

    public void setHomeAsUpIndicator(Drawable indicator) {
        this.f1041p.m2050b(indicator);
    }

    public void setHomeAsUpIndicator(int resId) {
        this.f1041p.m2047a(resId);
    }
}
