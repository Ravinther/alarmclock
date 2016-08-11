package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.view.C0366a;
import android.support.v7.internal.widget.C0416d.C0431b;
import android.support.v7.p012a.C0328a.C0326e;
import android.support.v7.p014b.C0364a.C0355b;
import android.support.v7.p014b.C0364a.C0360g;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class ScrollingTabContainerView extends HorizontalScrollView implements C0431b {
    Runnable f1093a;
    int f1094b;
    int f1095c;
    private C0430b f1096d;
    private LinearLayout f1097e;
    private C0467g f1098f;
    private boolean f1099g;
    private final LayoutInflater f1100h;
    private int f1101i;
    private int f1102j;

    /* renamed from: android.support.v7.internal.widget.ScrollingTabContainerView.1 */
    class C04281 implements Runnable {
        final /* synthetic */ View f1084a;
        final /* synthetic */ ScrollingTabContainerView f1085b;

        C04281(ScrollingTabContainerView scrollingTabContainerView, View view) {
            this.f1085b = scrollingTabContainerView;
            this.f1084a = view;
        }

        public void run() {
            this.f1085b.smoothScrollTo(this.f1084a.getLeft() - ((this.f1085b.getWidth() - this.f1084a.getWidth()) / 2), 0);
            this.f1085b.f1093a = null;
        }
    }

    public static class TabView extends LinearLayout {
        private C0326e f1086a;
        private TextView f1087b;
        private ImageView f1088c;
        private View f1089d;
        private ScrollingTabContainerView f1090e;

        public TabView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        void m2108a(ScrollingTabContainerView parent, C0326e tab, boolean forList) {
            this.f1090e = parent;
            this.f1086a = tab;
            if (forList) {
                setGravity(19);
            }
            m2106a();
        }

        public void m2107a(C0326e tab) {
            this.f1086a = tab;
            m2106a();
        }

        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            int maxTabWidth = this.f1090e != null ? this.f1090e.f1094b : 0;
            if (maxTabWidth > 0 && getMeasuredWidth() > maxTabWidth) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(maxTabWidth, 1073741824), heightMeasureSpec);
            }
        }

        public void m2106a() {
            C0326e tab = this.f1086a;
            View custom = tab.m1442d();
            if (custom != null) {
                TabView customParent = custom.getParent();
                if (customParent != this) {
                    if (customParent != null) {
                        customParent.removeView(custom);
                    }
                    addView(custom);
                }
                this.f1089d = custom;
                if (this.f1087b != null) {
                    this.f1087b.setVisibility(8);
                }
                if (this.f1088c != null) {
                    this.f1088c.setVisibility(8);
                    this.f1088c.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f1089d != null) {
                removeView(this.f1089d);
                this.f1089d = null;
            }
            Drawable icon = tab.m1440b();
            CharSequence text = tab.m1441c();
            if (icon != null) {
                if (this.f1088c == null) {
                    ImageView iconView = new ImageView(getContext());
                    LayoutParams lp = new LayoutParams(-2, -2);
                    lp.gravity = 16;
                    iconView.setLayoutParams(lp);
                    addView(iconView, 0);
                    this.f1088c = iconView;
                }
                this.f1088c.setImageDrawable(icon);
                this.f1088c.setVisibility(0);
            } else if (this.f1088c != null) {
                this.f1088c.setVisibility(8);
                this.f1088c.setImageDrawable(null);
            }
            if (text != null) {
                if (this.f1087b == null) {
                    TextView textView = new C0375e(getContext(), null, C0355b.actionBarTabTextStyle);
                    textView.setEllipsize(TruncateAt.END);
                    lp = new LayoutParams(-2, -2);
                    lp.gravity = 16;
                    textView.setLayoutParams(lp);
                    addView(textView);
                    this.f1087b = textView;
                }
                this.f1087b.setText(text);
                this.f1087b.setVisibility(0);
            } else if (this.f1087b != null) {
                this.f1087b.setVisibility(8);
                this.f1087b.setText(null);
            }
            if (this.f1088c != null) {
                this.f1088c.setContentDescription(tab.m1445g());
            }
        }

        public C0326e getTab() {
            return this.f1086a;
        }
    }

    /* renamed from: android.support.v7.internal.widget.ScrollingTabContainerView.a */
    private class C0429a extends BaseAdapter {
        final /* synthetic */ ScrollingTabContainerView f1091a;

        private C0429a(ScrollingTabContainerView scrollingTabContainerView) {
            this.f1091a = scrollingTabContainerView;
        }

        public int getCount() {
            return this.f1091a.f1097e.getChildCount();
        }

        public Object getItem(int position) {
            return ((TabView) this.f1091a.f1097e.getChildAt(position)).getTab();
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                return this.f1091a.m2110a((C0326e) getItem(position), true);
            }
            ((TabView) convertView).m2107a((C0326e) getItem(position));
            return convertView;
        }
    }

    /* renamed from: android.support.v7.internal.widget.ScrollingTabContainerView.b */
    private class C0430b implements OnClickListener {
        final /* synthetic */ ScrollingTabContainerView f1092a;

        private C0430b(ScrollingTabContainerView scrollingTabContainerView) {
            this.f1092a = scrollingTabContainerView;
        }

        public void onClick(View view) {
            ((TabView) view).getTab().m1444f();
            int tabCount = this.f1092a.f1097e.getChildCount();
            for (int i = 0; i < tabCount; i++) {
                View child = this.f1092a.f1097e.getChildAt(i);
                child.setSelected(child == view);
            }
        }
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean lockedExpanded;
        boolean canCollapse;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        if (widthMode == 1073741824) {
            lockedExpanded = true;
        } else {
            lockedExpanded = false;
        }
        setFillViewport(lockedExpanded);
        int childCount = this.f1097e.getChildCount();
        if (childCount <= 1 || !(widthMode == 1073741824 || widthMode == Integer.MIN_VALUE)) {
            this.f1094b = -1;
        } else {
            if (childCount > 2) {
                this.f1094b = (int) (((float) MeasureSpec.getSize(widthMeasureSpec)) * 0.4f);
            } else {
                this.f1094b = MeasureSpec.getSize(widthMeasureSpec) / 2;
            }
            this.f1094b = Math.min(this.f1094b, this.f1095c);
        }
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(this.f1101i, 1073741824);
        if (lockedExpanded || !this.f1099g) {
            canCollapse = false;
        } else {
            canCollapse = true;
        }
        if (canCollapse) {
            this.f1097e.measure(0, heightMeasureSpec);
            if (this.f1097e.getMeasuredWidth() > MeasureSpec.getSize(widthMeasureSpec)) {
                m2114b();
            } else {
                m2115c();
            }
        } else {
            m2115c();
        }
        int oldWidth = getMeasuredWidth();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int newWidth = getMeasuredWidth();
        if (lockedExpanded && oldWidth != newWidth) {
            setTabSelected(this.f1102j);
        }
    }

    private boolean m2113a() {
        return this.f1098f != null && this.f1098f.getParent() == this;
    }

    public void setAllowCollapse(boolean allowCollapse) {
        this.f1099g = allowCollapse;
    }

    private void m2114b() {
        if (!m2113a()) {
            if (this.f1098f == null) {
                this.f1098f = m2116d();
            }
            removeView(this.f1097e);
            addView(this.f1098f, new ViewGroup.LayoutParams(-2, -1));
            if (this.f1098f.m2017d() == null) {
                this.f1098f.m2226a(new C0429a());
            }
            if (this.f1093a != null) {
                removeCallbacks(this.f1093a);
                this.f1093a = null;
            }
            this.f1098f.m2012a(this.f1102j);
        }
    }

    private boolean m2115c() {
        if (m2113a()) {
            removeView(this.f1098f);
            addView(this.f1097e, new ViewGroup.LayoutParams(-2, -1));
            setTabSelected(this.f1098f.m1999f());
        }
        return false;
    }

    public void setTabSelected(int position) {
        this.f1102j = position;
        int tabCount = this.f1097e.getChildCount();
        int i = 0;
        while (i < tabCount) {
            View child = this.f1097e.getChildAt(i);
            boolean isSelected = i == position;
            child.setSelected(isSelected);
            if (isSelected) {
                m2117a(position);
            }
            i++;
        }
        if (this.f1098f != null && position >= 0) {
            this.f1098f.m2012a(position);
        }
    }

    public void setContentHeight(int contentHeight) {
        this.f1101i = contentHeight;
        requestLayout();
    }

    private C0467g m2116d() {
        C0467g spinner = new C0467g(getContext(), null, C0355b.actionDropDownStyle);
        spinner.setLayoutParams(new LayoutParams(-2, -1));
        spinner.m2228b(this);
        return spinner;
    }

    protected void onConfigurationChanged(Configuration newConfig) {
        C0366a abp = C0366a.m1706a(getContext());
        setContentHeight(abp.m1711e());
        this.f1095c = abp.m1713g();
    }

    public void m2117a(int position) {
        View tabView = this.f1097e.getChildAt(position);
        if (this.f1093a != null) {
            removeCallbacks(this.f1093a);
        }
        this.f1093a = new C04281(this, tabView);
        post(this.f1093a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1093a != null) {
            post(this.f1093a);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1093a != null) {
            removeCallbacks(this.f1093a);
        }
    }

    private TabView m2110a(C0326e tab, boolean forAdapter) {
        TabView tabView = (TabView) this.f1100h.inflate(C0360g.abc_action_bar_tab, this.f1097e, false);
        tabView.m2108a(this, tab, forAdapter);
        if (forAdapter) {
            tabView.setBackgroundDrawable(null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1101i));
        } else {
            tabView.setFocusable(true);
            if (this.f1096d == null) {
                this.f1096d = new C0430b();
            }
            tabView.setOnClickListener(this.f1096d);
        }
        return tabView;
    }

    public void m2119b(int position) {
        ((TabView) this.f1097e.getChildAt(position)).m2106a();
        if (this.f1098f != null) {
            ((C0429a) this.f1098f.m2017d()).notifyDataSetChanged();
        }
        if (this.f1099g) {
            requestLayout();
        }
    }

    public void m2118a(C0416d parent, View view, int position, long id) {
        ((TabView) view).getTab().m1444f();
    }
}
