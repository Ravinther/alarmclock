package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.p014b.C0364a.C0355b;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.google.android.gms.wallet.fragment.Dimension;
import com.mopub.mobileads.util.Base64;
import java.util.Locale;

/* renamed from: android.support.v7.internal.widget.f */
public class C0460f {
    private boolean f1172A;
    int f1173a;
    private Context f1174b;
    private PopupWindow f1175c;
    private ListAdapter f1176d;
    private C0454a f1177e;
    private int f1178f;
    private int f1179g;
    private int f1180h;
    private int f1181i;
    private boolean f1182j;
    private boolean f1183k;
    private boolean f1184l;
    private View f1185m;
    private int f1186n;
    private DataSetObserver f1187o;
    private View f1188p;
    private Drawable f1189q;
    private OnItemClickListener f1190r;
    private OnItemSelectedListener f1191s;
    private final C0459f f1192t;
    private final C0458e f1193u;
    private final C0457d f1194v;
    private final C0455b f1195w;
    private Runnable f1196x;
    private Handler f1197y;
    private Rect f1198z;

    /* renamed from: android.support.v7.internal.widget.f.1 */
    class C04521 implements Runnable {
        final /* synthetic */ C0460f f1163a;

        C04521(C0460f c0460f) {
            this.f1163a = c0460f;
        }

        public void run() {
            View view = this.f1163a.m2193b();
            if (view != null && view.getWindowToken() != null) {
                this.f1163a.m2195c();
            }
        }
    }

    /* renamed from: android.support.v7.internal.widget.f.2 */
    class C04532 implements OnItemSelectedListener {
        final /* synthetic */ C0460f f1164a;

        C04532(C0460f c0460f) {
            this.f1164a = c0460f;
        }

        public void onItemSelected(AdapterView parent, View view, int position, long id) {
            if (position != -1) {
                C0454a dropDownList = this.f1164a.f1177e;
                if (dropDownList != null) {
                    dropDownList.f1165a = false;
                }
            }
        }

        public void onNothingSelected(AdapterView parent) {
        }
    }

    /* renamed from: android.support.v7.internal.widget.f.a */
    private static class C0454a extends ListView {
        private boolean f1165a;
        private boolean f1166b;

        public C0454a(Context context, boolean hijackFocus) {
            super(context, null, C0355b.dropDownListViewStyle);
            this.f1166b = hijackFocus;
            setCacheColorHint(0);
        }

        public boolean isInTouchMode() {
            return (this.f1166b && this.f1165a) || super.isInTouchMode();
        }

        public boolean hasWindowFocus() {
            return this.f1166b || super.hasWindowFocus();
        }

        public boolean isFocused() {
            return this.f1166b || super.isFocused();
        }

        public boolean hasFocus() {
            return this.f1166b || super.hasFocus();
        }

        final int m2177a(int widthMeasureSpec, int startPosition, int endPosition, int maxHeight, int disallowPartialChildPosition) {
            int paddingTop = getListPaddingTop();
            int paddingBottom = getListPaddingBottom();
            int paddingLeft = getListPaddingLeft();
            int paddingRight = getListPaddingRight();
            int reportedDividerHeight = getDividerHeight();
            Drawable divider = getDivider();
            ListAdapter adapter = getAdapter();
            if (adapter == null) {
                return paddingTop + paddingBottom;
            }
            int returnedHeight = paddingTop + paddingBottom;
            int dividerHeight = (reportedDividerHeight <= 0 || divider == null) ? 0 : reportedDividerHeight;
            int prevHeightWithoutPartialChild = 0;
            View child = null;
            int viewType = 0;
            int count = adapter.getCount();
            int i = 0;
            while (i < count) {
                int heightMeasureSpec;
                int newType = adapter.getItemViewType(i);
                if (newType != viewType) {
                    child = null;
                    viewType = newType;
                }
                child = adapter.getView(i, child, this);
                LayoutParams childLp = child.getLayoutParams();
                if (childLp == null || childLp.height <= 0) {
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                } else {
                    heightMeasureSpec = MeasureSpec.makeMeasureSpec(childLp.height, 1073741824);
                }
                child.measure(widthMeasureSpec, heightMeasureSpec);
                if (i > 0) {
                    returnedHeight += dividerHeight;
                }
                returnedHeight += child.getMeasuredHeight();
                if (returnedHeight < maxHeight) {
                    if (disallowPartialChildPosition >= 0 && i >= disallowPartialChildPosition) {
                        prevHeightWithoutPartialChild = returnedHeight;
                    }
                    i++;
                } else if (disallowPartialChildPosition < 0 || i <= disallowPartialChildPosition || prevHeightWithoutPartialChild <= 0 || returnedHeight == maxHeight) {
                    return maxHeight;
                } else {
                    return prevHeightWithoutPartialChild;
                }
            }
            return returnedHeight;
        }
    }

    /* renamed from: android.support.v7.internal.widget.f.b */
    private class C0455b implements Runnable {
        final /* synthetic */ C0460f f1167a;

        private C0455b(C0460f c0460f) {
            this.f1167a = c0460f;
        }

        public void run() {
            this.f1167a.m2199e();
        }
    }

    /* renamed from: android.support.v7.internal.widget.f.c */
    private class C0456c extends DataSetObserver {
        final /* synthetic */ C0460f f1168a;

        private C0456c(C0460f c0460f) {
            this.f1168a = c0460f;
        }

        public void onChanged() {
            if (this.f1168a.m2202f()) {
                this.f1168a.m2195c();
            }
        }

        public void onInvalidated() {
            this.f1168a.m2197d();
        }
    }

    /* renamed from: android.support.v7.internal.widget.f.d */
    private class C0457d implements OnScrollListener {
        final /* synthetic */ C0460f f1169a;

        private C0457d(C0460f c0460f) {
            this.f1169a = c0460f;
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (scrollState == 1 && !this.f1169a.m2204g() && this.f1169a.f1175c.getContentView() != null) {
                this.f1169a.f1197y.removeCallbacks(this.f1169a.f1192t);
                this.f1169a.f1192t.run();
            }
        }
    }

    /* renamed from: android.support.v7.internal.widget.f.e */
    private class C0458e implements OnTouchListener {
        final /* synthetic */ C0460f f1170a;

        private C0458e(C0460f c0460f) {
            this.f1170a = c0460f;
        }

        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            int x = (int) event.getX();
            int y = (int) event.getY();
            if (action == 0 && this.f1170a.f1175c != null && this.f1170a.f1175c.isShowing() && x >= 0 && x < this.f1170a.f1175c.getWidth() && y >= 0 && y < this.f1170a.f1175c.getHeight()) {
                this.f1170a.f1197y.postDelayed(this.f1170a.f1192t, 250);
            } else if (action == 1) {
                this.f1170a.f1197y.removeCallbacks(this.f1170a.f1192t);
            }
            return false;
        }
    }

    /* renamed from: android.support.v7.internal.widget.f.f */
    private class C0459f implements Runnable {
        final /* synthetic */ C0460f f1171a;

        private C0459f(C0460f c0460f) {
            this.f1171a = c0460f;
        }

        public void run() {
            if (this.f1171a.f1177e != null && this.f1171a.f1177e.getCount() > this.f1171a.f1177e.getChildCount() && this.f1171a.f1177e.getChildCount() <= this.f1171a.f1173a) {
                this.f1171a.f1175c.setInputMethodMode(2);
                this.f1171a.m2195c();
            }
        }
    }

    public C0460f(Context context) {
        this(context, null, C0355b.listPopupWindowStyle);
    }

    public C0460f(Context context, AttributeSet attrs, int defStyleAttr) {
        this.f1178f = -2;
        this.f1179g = -2;
        this.f1183k = false;
        this.f1184l = false;
        this.f1173a = Integer.MAX_VALUE;
        this.f1186n = 0;
        this.f1192t = new C0459f();
        this.f1193u = new C0458e();
        this.f1194v = new C0457d();
        this.f1195w = new C0455b();
        this.f1197y = new Handler();
        this.f1198z = new Rect();
        this.f1174b = context;
        this.f1175c = new PopupWindow(context, attrs, defStyleAttr);
        this.f1175c.setInputMethodMode(1);
        Locale locale = this.f1174b.getResources().getConfiguration().locale;
    }

    public void m2190a(ListAdapter adapter) {
        if (this.f1187o == null) {
            this.f1187o = new C0456c();
        } else if (this.f1176d != null) {
            this.f1176d.unregisterDataSetObserver(this.f1187o);
        }
        this.f1176d = adapter;
        if (this.f1176d != null) {
            adapter.registerDataSetObserver(this.f1187o);
        }
        if (this.f1177e != null) {
            this.f1177e.setAdapter(this.f1176d);
        }
    }

    public void m2186a(int position) {
        this.f1186n = position;
    }

    public void m2192a(boolean modal) {
        this.f1172A = true;
        this.f1175c.setFocusable(modal);
    }

    public Drawable m2185a() {
        return this.f1175c.getBackground();
    }

    public void m2187a(Drawable d) {
        this.f1175c.setBackgroundDrawable(d);
    }

    public View m2193b() {
        return this.f1188p;
    }

    public void m2188a(View anchor) {
        this.f1188p = anchor;
    }

    public void m2194b(int offset) {
        this.f1180h = offset;
    }

    public void m2196c(int offset) {
        this.f1181i = offset;
        this.f1182j = true;
    }

    public void m2198d(int width) {
        this.f1179g = width;
    }

    public void m2200e(int width) {
        Drawable popupBackground = this.f1175c.getBackground();
        if (popupBackground != null) {
            popupBackground.getPadding(this.f1198z);
            this.f1179g = (this.f1198z.left + this.f1198z.right) + width;
            return;
        }
        m2198d(width);
    }

    public void m2189a(OnItemClickListener clickListener) {
        this.f1190r = clickListener;
    }

    public void m2195c() {
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int height = m2183j();
        int widthSpec = 0;
        int heightSpec = 0;
        boolean noInputMethod = m2204g();
        if (this.f1175c.isShowing()) {
            if (this.f1179g == -1) {
                widthSpec = -1;
            } else if (this.f1179g == -2) {
                widthSpec = m2193b().getWidth();
            } else {
                widthSpec = this.f1179g;
            }
            if (this.f1178f == -1) {
                if (noInputMethod) {
                    heightSpec = height;
                } else {
                    heightSpec = -1;
                }
                if (noInputMethod) {
                    PopupWindow popupWindow = this.f1175c;
                    if (this.f1179g != -1) {
                        i = 0;
                    }
                    popupWindow.setWindowLayoutMode(i, 0);
                } else {
                    this.f1175c.setWindowLayoutMode(this.f1179g == -1 ? -1 : 0, -1);
                }
            } else if (this.f1178f == -2) {
                heightSpec = height;
            } else {
                heightSpec = this.f1178f;
            }
            PopupWindow popupWindow2 = this.f1175c;
            if (!(this.f1184l || this.f1183k)) {
                z2 = true;
            }
            popupWindow2.setOutsideTouchable(z2);
            this.f1175c.update(m2193b(), this.f1180h, this.f1181i, widthSpec, heightSpec);
            return;
        }
        if (this.f1179g == -1) {
            widthSpec = -1;
        } else if (this.f1179g == -2) {
            this.f1175c.setWidth(m2193b().getWidth());
        } else {
            this.f1175c.setWidth(this.f1179g);
        }
        if (this.f1178f == -1) {
            heightSpec = -1;
        } else if (this.f1178f == -2) {
            this.f1175c.setHeight(height);
        } else {
            this.f1175c.setHeight(this.f1178f);
        }
        this.f1175c.setWindowLayoutMode(widthSpec, heightSpec);
        popupWindow = this.f1175c;
        if (this.f1184l || this.f1183k) {
            z = false;
        }
        popupWindow.setOutsideTouchable(z);
        this.f1175c.setTouchInterceptor(this.f1193u);
        this.f1175c.showAsDropDown(m2193b(), this.f1180h, this.f1181i);
        this.f1177e.setSelection(-1);
        if (!this.f1172A || this.f1177e.isInTouchMode()) {
            m2199e();
        }
        if (!this.f1172A) {
            this.f1197y.post(this.f1195w);
        }
    }

    public void m2197d() {
        this.f1175c.dismiss();
        m2182i();
        this.f1175c.setContentView(null);
        this.f1177e = null;
        this.f1197y.removeCallbacks(this.f1192t);
    }

    public void m2191a(OnDismissListener listener) {
        this.f1175c.setOnDismissListener(listener);
    }

    private void m2182i() {
        if (this.f1185m != null) {
            ViewParent parent = this.f1185m.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1185m);
            }
        }
    }

    public void m2201f(int mode) {
        this.f1175c.setInputMethodMode(mode);
    }

    public void m2203g(int position) {
        C0454a list = this.f1177e;
        if (m2202f() && list != null) {
            list.f1165a = false;
            list.setSelection(position);
            if (list.getChoiceMode() != 0) {
                list.setItemChecked(position, true);
            }
        }
    }

    public void m2199e() {
        C0454a list = this.f1177e;
        if (list != null) {
            list.f1165a = true;
            list.requestLayout();
        }
    }

    public boolean m2202f() {
        return this.f1175c.isShowing();
    }

    public boolean m2204g() {
        return this.f1175c.getInputMethodMode() == 2;
    }

    public ListView m2205h() {
        return this.f1177e;
    }

    private int m2183j() {
        int otherHeights = 0;
        ViewGroup dropDownView;
        LinearLayout.LayoutParams hintParams;
        if (this.f1177e == null) {
            Context context = this.f1174b;
            this.f1196x = new C04521(this);
            this.f1177e = new C0454a(context, !this.f1172A);
            if (this.f1189q != null) {
                this.f1177e.setSelector(this.f1189q);
            }
            this.f1177e.setAdapter(this.f1176d);
            this.f1177e.setOnItemClickListener(this.f1190r);
            this.f1177e.setFocusable(true);
            this.f1177e.setFocusableInTouchMode(true);
            this.f1177e.setOnItemSelectedListener(new C04532(this));
            this.f1177e.setOnScrollListener(this.f1194v);
            if (this.f1191s != null) {
                this.f1177e.setOnItemSelectedListener(this.f1191s);
            }
            dropDownView = this.f1177e;
            View hintView = this.f1185m;
            if (hintView != null) {
                ViewGroup hintContainer = new LinearLayout(context);
                hintContainer.setOrientation(1);
                hintParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.f1186n) {
                    case Base64.DEFAULT /*0*/:
                        hintContainer.addView(hintView);
                        hintContainer.addView(dropDownView, hintParams);
                        break;
                    case Base64.NO_PADDING /*1*/:
                        hintContainer.addView(dropDownView, hintParams);
                        hintContainer.addView(hintView);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f1186n);
                        break;
                }
                hintView.measure(MeasureSpec.makeMeasureSpec(this.f1179g, Integer.MIN_VALUE), 0);
                hintParams = (LinearLayout.LayoutParams) hintView.getLayoutParams();
                otherHeights = (hintView.getMeasuredHeight() + hintParams.topMargin) + hintParams.bottomMargin;
                dropDownView = hintContainer;
            }
            this.f1175c.setContentView(dropDownView);
        } else {
            dropDownView = (ViewGroup) this.f1175c.getContentView();
            View view = this.f1185m;
            if (view != null) {
                hintParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                otherHeights = (view.getMeasuredHeight() + hintParams.topMargin) + hintParams.bottomMargin;
            }
        }
        int padding = 0;
        Drawable background = this.f1175c.getBackground();
        if (background != null) {
            background.getPadding(this.f1198z);
            padding = this.f1198z.top + this.f1198z.bottom;
            if (!this.f1182j) {
                this.f1181i = -this.f1198z.top;
            }
        } else {
            this.f1198z.setEmpty();
        }
        int maxHeight = m2184a(m2193b(), this.f1181i, this.f1175c.getInputMethodMode() == 2);
        if (this.f1183k || this.f1178f == -1) {
            return maxHeight + padding;
        }
        int childWidthSpec;
        switch (this.f1179g) {
            case Dimension.WRAP_CONTENT /*-2*/:
                childWidthSpec = MeasureSpec.makeMeasureSpec(this.f1174b.getResources().getDisplayMetrics().widthPixels - (this.f1198z.left + this.f1198z.right), Integer.MIN_VALUE);
                break;
            case Dimension.MATCH_PARENT /*-1*/:
                childWidthSpec = MeasureSpec.makeMeasureSpec(this.f1174b.getResources().getDisplayMetrics().widthPixels - (this.f1198z.left + this.f1198z.right), 1073741824);
                break;
            default:
                childWidthSpec = MeasureSpec.makeMeasureSpec(this.f1179g, 1073741824);
                break;
        }
        int listContent = this.f1177e.m2177a(childWidthSpec, 0, -1, maxHeight - otherHeights, -1);
        if (listContent > 0) {
            otherHeights += padding;
        }
        return listContent + otherHeights;
    }

    public int m2184a(View anchor, int yOffset, boolean ignoreBottomDecorations) {
        Rect displayFrame = new Rect();
        anchor.getWindowVisibleDisplayFrame(displayFrame);
        int[] anchorPos = new int[2];
        anchor.getLocationOnScreen(anchorPos);
        int bottomEdge = displayFrame.bottom;
        if (ignoreBottomDecorations) {
            bottomEdge = anchor.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        int returnedHeight = Math.max((bottomEdge - (anchorPos[1] + anchor.getHeight())) - yOffset, (anchorPos[1] - displayFrame.top) + yOffset);
        if (this.f1175c.getBackground() == null) {
            return returnedHeight;
        }
        this.f1175c.getBackground().getPadding(this.f1198z);
        return returnedHeight - (this.f1198z.top + this.f1198z.bottom);
    }
}
