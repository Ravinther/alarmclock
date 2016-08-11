package android.support.v7.internal.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.C0220d;
import android.support.v7.p014b.C0364a.C0357d;
import android.support.v7.p014b.C0364a.C0358e;
import android.support.v7.p014b.C0364a.C0360g;
import android.support.v7.p014b.C0364a.C0361h;
import android.support.v7.p014b.C0364a.C0363j;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.mopub.mobileads.util.Base64;

/* renamed from: android.support.v7.internal.widget.c */
public class C0446c extends ViewGroup {
    C0220d f1139a;
    private final C0444a f1140b;
    private final C0445b f1141c;
    private final LinearLayout f1142d;
    private final Drawable f1143e;
    private final FrameLayout f1144f;
    private final ImageView f1145g;
    private final FrameLayout f1146h;
    private final ImageView f1147i;
    private final int f1148j;
    private final DataSetObserver f1149k;
    private final OnGlobalLayoutListener f1150l;
    private C0460f f1151m;
    private OnDismissListener f1152n;
    private boolean f1153o;
    private int f1154p;
    private boolean f1155q;
    private int f1156r;

    /* renamed from: android.support.v7.internal.widget.c.1 */
    class C04411 extends DataSetObserver {
        final /* synthetic */ C0446c f1129a;

        C04411(C0446c c0446c) {
            this.f1129a = c0446c;
        }

        public void onChanged() {
            super.onChanged();
            this.f1129a.f1140b.notifyDataSetChanged();
        }

        public void onInvalidated() {
            super.onInvalidated();
            this.f1129a.f1140b.notifyDataSetInvalidated();
        }
    }

    /* renamed from: android.support.v7.internal.widget.c.2 */
    class C04422 implements OnGlobalLayoutListener {
        final /* synthetic */ C0446c f1130a;

        C04422(C0446c c0446c) {
            this.f1130a = c0446c;
        }

        public void onGlobalLayout() {
            if (!this.f1130a.m2175c()) {
                return;
            }
            if (this.f1130a.isShown()) {
                this.f1130a.getListPopupWindow().m2195c();
                if (this.f1130a.f1139a != null) {
                    this.f1130a.f1139a.m991a(true);
                    return;
                }
                return;
            }
            this.f1130a.getListPopupWindow().m2197d();
        }
    }

    /* renamed from: android.support.v7.internal.widget.c.3 */
    class C04433 extends DataSetObserver {
        final /* synthetic */ C0446c f1131a;

        C04433(C0446c c0446c) {
            this.f1131a = c0446c;
        }

        public void onChanged() {
            super.onChanged();
            this.f1131a.m2166d();
        }
    }

    /* renamed from: android.support.v7.internal.widget.c.a */
    private class C0444a extends BaseAdapter {
        final /* synthetic */ C0446c f1132a;
        private C0440b f1133b;
        private int f1134c;
        private boolean f1135d;
        private boolean f1136e;
        private boolean f1137f;

        private C0444a(C0446c c0446c) {
            this.f1132a = c0446c;
            this.f1134c = 4;
        }

        public void m2151a(C0440b dataModel) {
            C0440b oldDataModel = this.f1132a.f1140b.m2157e();
            if (oldDataModel != null && this.f1132a.isShown()) {
                oldDataModel.unregisterObserver(this.f1132a.f1149k);
            }
            this.f1133b = dataModel;
            if (dataModel != null && this.f1132a.isShown()) {
                dataModel.registerObserver(this.f1132a.f1149k);
            }
            notifyDataSetChanged();
        }

        public int getItemViewType(int position) {
            if (this.f1137f && position == getCount() - 1) {
                return 1;
            }
            return 0;
        }

        public int getViewTypeCount() {
            return 3;
        }

        public int getCount() {
            int activityCount = this.f1133b.m2140a();
            if (!(this.f1135d || this.f1133b.m2146b() == null)) {
                activityCount--;
            }
            int count = Math.min(activityCount, this.f1134c);
            if (this.f1137f) {
                return count + 1;
            }
            return count;
        }

        public Object getItem(int position) {
            switch (getItemViewType(position)) {
                case Base64.DEFAULT /*0*/:
                    if (!(this.f1135d || this.f1133b.m2146b() == null)) {
                        position++;
                    }
                    return this.f1133b.m2142a(position);
                case Base64.NO_PADDING /*1*/:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            switch (getItemViewType(position)) {
                case Base64.DEFAULT /*0*/:
                    if (convertView == null || convertView.getId() != C0358e.list_item) {
                        convertView = LayoutInflater.from(this.f1132a.getContext()).inflate(C0360g.abc_activity_chooser_view_list_item, parent, false);
                    }
                    PackageManager packageManager = this.f1132a.getContext().getPackageManager();
                    ResolveInfo activity = (ResolveInfo) getItem(position);
                    ((ImageView) convertView.findViewById(C0358e.icon)).setImageDrawable(activity.loadIcon(packageManager));
                    ((TextView) convertView.findViewById(C0358e.title)).setText(activity.loadLabel(packageManager));
                    if (this.f1135d && position == 0 && !this.f1136e) {
                    }
                    return convertView;
                case Base64.NO_PADDING /*1*/:
                    if (convertView == null || convertView.getId() != 1) {
                        convertView = LayoutInflater.from(this.f1132a.getContext()).inflate(C0360g.abc_activity_chooser_view_list_item, parent, false);
                        convertView.setId(1);
                        ((TextView) convertView.findViewById(C0358e.title)).setText(this.f1132a.getContext().getString(C0361h.abc_activity_chooser_view_see_all));
                    }
                    return convertView;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int m2149a() {
            int oldMaxActivityCount = this.f1134c;
            this.f1134c = Integer.MAX_VALUE;
            int contentWidth = 0;
            View itemView = null;
            int widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            for (int i = 0; i < count; i++) {
                itemView = getView(i, itemView, null);
                itemView.measure(widthMeasureSpec, heightMeasureSpec);
                contentWidth = Math.max(contentWidth, itemView.getMeasuredWidth());
            }
            this.f1134c = oldMaxActivityCount;
            return contentWidth;
        }

        public void m2150a(int maxActivityCount) {
            if (this.f1134c != maxActivityCount) {
                this.f1134c = maxActivityCount;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo m2154b() {
            return this.f1133b.m2146b();
        }

        public void m2152a(boolean showFooterView) {
            if (this.f1137f != showFooterView) {
                this.f1137f = showFooterView;
                notifyDataSetChanged();
            }
        }

        public int m2155c() {
            return this.f1133b.m2140a();
        }

        public int m2156d() {
            return this.f1133b.m2147c();
        }

        public C0440b m2157e() {
            return this.f1133b;
        }

        public void m2153a(boolean showDefaultActivity, boolean highlightDefaultActivity) {
            if (this.f1135d != showDefaultActivity || this.f1136e != highlightDefaultActivity) {
                this.f1135d = showDefaultActivity;
                this.f1136e = highlightDefaultActivity;
                notifyDataSetChanged();
            }
        }

        public boolean m2158f() {
            return this.f1135d;
        }
    }

    /* renamed from: android.support.v7.internal.widget.c.b */
    private class C0445b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        final /* synthetic */ C0446c f1138a;

        private C0445b(C0446c c0446c) {
            this.f1138a = c0446c;
        }

        public void onItemClick(AdapterView parent, View view, int position, long id) {
            switch (((C0444a) parent.getAdapter()).getItemViewType(position)) {
                case Base64.DEFAULT /*0*/:
                    this.f1138a.m2174b();
                    if (!this.f1138a.f1153o) {
                        if (!this.f1138a.f1140b.m2158f()) {
                            position++;
                        }
                        Intent launchIntent = this.f1138a.f1140b.m2157e().m2145b(position);
                        if (launchIntent != null) {
                            launchIntent.addFlags(524288);
                            this.f1138a.getContext().startActivity(launchIntent);
                        }
                    } else if (position > 0) {
                        this.f1138a.f1140b.m2157e().m2148c(position);
                    }
                case Base64.NO_PADDING /*1*/:
                    this.f1138a.m2161a(Integer.MAX_VALUE);
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void onClick(View view) {
            if (view == this.f1138a.f1146h) {
                this.f1138a.m2174b();
                Intent launchIntent = this.f1138a.f1140b.m2157e().m2145b(this.f1138a.f1140b.m2157e().m2141a(this.f1138a.f1140b.m2154b()));
                if (launchIntent != null) {
                    launchIntent.addFlags(524288);
                    this.f1138a.getContext().startActivity(launchIntent);
                }
            } else if (view == this.f1138a.f1144f) {
                this.f1138a.f1153o = false;
                this.f1138a.m2161a(this.f1138a.f1154p);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.f1138a.f1146h) {
                if (this.f1138a.f1140b.getCount() > 0) {
                    this.f1138a.f1153o = true;
                    this.f1138a.m2161a(this.f1138a.f1154p);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public void onDismiss() {
            m2159a();
            if (this.f1138a.f1139a != null) {
                this.f1138a.f1139a.m991a(false);
            }
        }

        private void m2159a() {
            if (this.f1138a.f1152n != null) {
                this.f1138a.f1152n.onDismiss();
            }
        }
    }

    public C0446c(Context context) {
        this(context, null);
    }

    public C0446c(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public C0446c(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f1149k = new C04411(this);
        this.f1150l = new C04422(this);
        this.f1154p = 4;
        TypedArray attributesArray = context.obtainStyledAttributes(attrs, C0363j.ActivityChooserView, defStyle, 0);
        this.f1154p = attributesArray.getInt(0, 4);
        Drawable expandActivityOverflowButtonDrawable = attributesArray.getDrawable(1);
        attributesArray.recycle();
        LayoutInflater.from(getContext()).inflate(C0360g.abc_activity_chooser_view, this, true);
        this.f1141c = new C0445b();
        this.f1142d = (LinearLayout) findViewById(C0358e.activity_chooser_view_content);
        this.f1143e = this.f1142d.getBackground();
        this.f1146h = (FrameLayout) findViewById(C0358e.default_activity_button);
        this.f1146h.setOnClickListener(this.f1141c);
        this.f1146h.setOnLongClickListener(this.f1141c);
        this.f1147i = (ImageView) this.f1146h.findViewById(C0358e.image);
        this.f1144f = (FrameLayout) findViewById(C0358e.expand_activities_button);
        this.f1144f.setOnClickListener(this.f1141c);
        this.f1145g = (ImageView) this.f1144f.findViewById(C0358e.image);
        this.f1145g.setImageDrawable(expandActivityOverflowButtonDrawable);
        this.f1140b = new C0444a();
        this.f1140b.registerDataSetObserver(new C04433(this));
        Resources resources = context.getResources();
        this.f1148j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0357d.abc_config_prefDialogWidth));
    }

    public void setActivityChooserModel(C0440b dataModel) {
        this.f1140b.m2151a(dataModel);
        if (m2175c()) {
            m2174b();
            m2173a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1145g.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int resourceId) {
        this.f1145g.setContentDescription(getContext().getString(resourceId));
    }

    public void setProvider(C0220d provider) {
        this.f1139a = provider;
    }

    public boolean m2173a() {
        if (m2175c() || !this.f1155q) {
            return false;
        }
        this.f1153o = false;
        m2161a(this.f1154p);
        return true;
    }

    private void m2161a(int maxActivityCount) {
        if (this.f1140b.m2157e() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        boolean defaultActivityButtonShown;
        getViewTreeObserver().addOnGlobalLayoutListener(this.f1150l);
        if (this.f1146h.getVisibility() == 0) {
            defaultActivityButtonShown = true;
        } else {
            defaultActivityButtonShown = false;
        }
        int activityCount = this.f1140b.m2155c();
        int maxActivityCountOffset;
        if (defaultActivityButtonShown) {
            maxActivityCountOffset = 1;
        } else {
            maxActivityCountOffset = 0;
        }
        if (maxActivityCount == Integer.MAX_VALUE || activityCount <= maxActivityCount + maxActivityCountOffset) {
            this.f1140b.m2152a(false);
            this.f1140b.m2150a(maxActivityCount);
        } else {
            this.f1140b.m2152a(true);
            this.f1140b.m2150a(maxActivityCount - 1);
        }
        C0460f popupWindow = getListPopupWindow();
        if (!popupWindow.m2202f()) {
            if (this.f1153o || !defaultActivityButtonShown) {
                this.f1140b.m2153a(true, defaultActivityButtonShown);
            } else {
                this.f1140b.m2153a(false, false);
            }
            popupWindow.m2200e(Math.min(this.f1140b.m2149a(), this.f1148j));
            popupWindow.m2195c();
            if (this.f1139a != null) {
                this.f1139a.m991a(true);
            }
            popupWindow.m2205h().setContentDescription(getContext().getString(C0361h.abc_activitychooserview_choose_application));
        }
    }

    public boolean m2174b() {
        if (m2175c()) {
            getListPopupWindow().m2197d();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f1150l);
            }
        }
        return true;
    }

    public boolean m2175c() {
        return getListPopupWindow().m2202f();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0440b dataModel = this.f1140b.m2157e();
        if (dataModel != null) {
            dataModel.registerObserver(this.f1149k);
        }
        this.f1155q = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0440b dataModel = this.f1140b.m2157e();
        if (dataModel != null) {
            dataModel.unregisterObserver(this.f1149k);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1150l);
        }
        if (m2175c()) {
            m2174b();
        }
        this.f1155q = false;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View child = this.f1142d;
        if (this.f1146h.getVisibility() != 0) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(heightMeasureSpec), 1073741824);
        }
        measureChild(child, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(child.getMeasuredWidth(), child.getMeasuredHeight());
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.f1142d.layout(0, 0, right - left, bottom - top);
        if (!m2175c()) {
            m2174b();
        }
    }

    public C0440b getDataModel() {
        return this.f1140b.m2157e();
    }

    public void setOnDismissListener(OnDismissListener listener) {
        this.f1152n = listener;
    }

    public void setInitialActivityCount(int itemCount) {
        this.f1154p = itemCount;
    }

    public void setDefaultActionButtonContentDescription(int resourceId) {
        this.f1156r = resourceId;
    }

    private C0460f getListPopupWindow() {
        if (this.f1151m == null) {
            this.f1151m = new C0460f(getContext());
            this.f1151m.m2190a(this.f1140b);
            this.f1151m.m2188a((View) this);
            this.f1151m.m2192a(true);
            this.f1151m.m2189a(this.f1141c);
            this.f1151m.m2191a(this.f1141c);
        }
        return this.f1151m;
    }

    private void m2166d() {
        if (this.f1140b.getCount() > 0) {
            this.f1144f.setEnabled(true);
        } else {
            this.f1144f.setEnabled(false);
        }
        int activityCount = this.f1140b.m2155c();
        int historySize = this.f1140b.m2156d();
        if (activityCount == 1 || (activityCount > 1 && historySize > 0)) {
            this.f1146h.setVisibility(0);
            ResolveInfo activity = this.f1140b.m2154b();
            PackageManager packageManager = getContext().getPackageManager();
            this.f1147i.setImageDrawable(activity.loadIcon(packageManager));
            if (this.f1156r != 0) {
                CharSequence label = activity.loadLabel(packageManager);
                this.f1146h.setContentDescription(getContext().getString(this.f1156r, new Object[]{label}));
            }
        } else {
            this.f1146h.setVisibility(8);
        }
        if (this.f1146h.getVisibility() == 0) {
            this.f1142d.setBackgroundDrawable(this.f1143e);
        } else {
            this.f1142d.setBackgroundDrawable(null);
        }
    }
}
