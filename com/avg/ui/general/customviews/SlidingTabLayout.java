package com.avg.ui.general.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v4.view.C0083o;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0165f;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class SlidingTabLayout extends HorizontalScrollView {
    private int f3449a;
    private int f3450b;
    private int f3451c;
    private ViewPager f3452d;
    private C0165f f3453e;
    private final C1160e f3454f;

    /* renamed from: com.avg.ui.general.customviews.SlidingTabLayout.a */
    private class C1133a implements C0165f {
        final /* synthetic */ SlidingTabLayout f3443a;
        private int f3444b;

        private C1133a(SlidingTabLayout slidingTabLayout) {
            this.f3443a = slidingTabLayout;
        }

        public void m4798a(int position, float positionOffset, int positionOffsetPixels) {
            int tabStripChildCount = this.f3443a.f3454f.getChildCount();
            if (tabStripChildCount != 0 && position >= 0 && position < tabStripChildCount) {
                this.f3443a.f3454f.m4862a(position, positionOffset);
                View selectedTitle = this.f3443a.f3454f.getChildAt(position);
                this.f3443a.m4805a(position, selectedTitle != null ? (int) (((float) selectedTitle.getWidth()) * positionOffset) : 0);
                if (this.f3443a.f3453e != null) {
                    this.f3443a.f3453e.m606a(position, positionOffset, positionOffsetPixels);
                }
            }
        }

        public void b_(int state) {
            this.f3444b = state;
            if (this.f3443a.f3453e != null) {
                this.f3443a.f3453e.b_(state);
            }
        }

        public void a_(int position) {
            if (this.f3444b == 0) {
                this.f3443a.f3454f.m4862a(position, 0.0f);
                this.f3443a.m4805a(position, 0);
            }
            if (this.f3443a.f3453e != null) {
                this.f3443a.f3453e.a_(position);
            }
        }
    }

    /* renamed from: com.avg.ui.general.customviews.SlidingTabLayout.b */
    private class C1135b implements OnClickListener {
        final /* synthetic */ SlidingTabLayout f3446a;
        private final Object f3447b;
        private boolean f3448c;

        /* renamed from: com.avg.ui.general.customviews.SlidingTabLayout.b.1 */
        class C11341 implements Runnable {
            final /* synthetic */ C1135b f3445a;

            C11341(C1135b c1135b) {
                this.f3445a = c1135b;
            }

            public void run() {
                synchronized (this.f3445a.f3447b) {
                    this.f3445a.f3448c = true;
                }
            }
        }

        private C1135b(SlidingTabLayout slidingTabLayout) {
            this.f3446a = slidingTabLayout;
            this.f3447b = new Object();
            this.f3448c = true;
        }

        public void onClick(View v) {
            synchronized (this.f3447b) {
                if (this.f3448c) {
                    this.f3448c = false;
                    for (int i = 0; i < this.f3446a.f3454f.getChildCount(); i++) {
                        if (v == this.f3446a.f3454f.getChildAt(i)) {
                            this.f3446a.f3452d.setCurrentItem(i);
                            this.f3446a.f3454f.post(new C11341(this));
                            return;
                        }
                    }
                    return;
                }
            }
        }
    }

    /* renamed from: com.avg.ui.general.customviews.SlidingTabLayout.c */
    public interface C1136c {
        int m4801a(int i);

        int m4802b(int i);
    }

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f3449a = (int) (24.0f * getResources().getDisplayMetrics().density);
        this.f3454f = new C1160e(context);
        addView(this.f3454f, -1, -2);
    }

    public void setCustomTabColorizer(C1136c tabColorizer) {
        this.f3454f.m4863a(tabColorizer);
    }

    public void setSelectedIndicatorColors(int... colors) {
        this.f3454f.m4864a(colors);
    }

    public void setDividerColors(int... colors) {
        this.f3454f.m4865b(colors);
    }

    public void setOnPageChangeListener(C0165f listener) {
        this.f3453e = listener;
    }

    public void setViewPager(ViewPager viewPager) {
        this.f3454f.removeAllViews();
        this.f3452d = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new C1133a());
            m4804a();
        }
    }

    protected TextView m4809a(Context context) {
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setTextSize(2, 12.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        if (VERSION.SDK_INT >= 11) {
            TypedValue outValue = new TypedValue();
            getContext().getTheme().resolveAttribute(16843534, outValue, true);
            textView.setBackgroundResource(outValue.resourceId);
        }
        if (VERSION.SDK_INT >= 14) {
            textView.setAllCaps(true);
        }
        int padding = (int) (16.0f * getResources().getDisplayMetrics().density);
        textView.setPadding(padding, padding, padding, padding);
        return textView;
    }

    private void m4804a() {
        C0083o adapter = this.f3452d.getAdapter();
        OnClickListener tabClickListener = new C1135b();
        for (int i = 0; i < adapter.m356b(); i++) {
            View tabView = null;
            TextView tabTitleView = null;
            if (this.f3450b != 0) {
                tabView = LayoutInflater.from(getContext()).inflate(this.f3450b, this.f3454f, false);
                tabTitleView = (TextView) tabView.findViewById(this.f3451c);
            }
            if (tabView == null) {
                tabView = m4809a(getContext());
            }
            if (tabTitleView == null && TextView.class.isInstance(tabView)) {
                tabTitleView = (TextView) tabView;
            }
            tabTitleView.setText(adapter.m362c(i));
            tabView.setOnClickListener(tabClickListener);
            this.f3454f.addView(tabView, new LayoutParams(0, -1, 1.0f));
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f3452d != null) {
            m4805a(this.f3452d.getCurrentItem(), 0);
        }
    }

    private void m4805a(int tabIndex, int positionOffset) {
        int tabStripChildCount = this.f3454f.getChildCount();
        if (tabStripChildCount != 0 && tabIndex >= 0 && tabIndex < tabStripChildCount) {
            View selectedChild = this.f3454f.getChildAt(tabIndex);
            if (selectedChild != null) {
                int targetScrollX = selectedChild.getLeft() + positionOffset;
                if (tabIndex > 0 || positionOffset > 0) {
                    targetScrollX -= this.f3449a;
                }
                scrollTo(targetScrollX, 0);
            }
        }
    }
}
