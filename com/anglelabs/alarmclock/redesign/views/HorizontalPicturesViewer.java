package com.anglelabs.alarmclock.redesign.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ViewSwitcher;
import com.alarmclock.xtreme.free.C0499a.C0498a;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.utils.C0807e;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.ab;
import com.avg.toolkit.p049e.C0970a;
import com.p044c.p045a.C0881e;
import com.p044c.p045a.C1295r;

public class HorizontalPicturesViewer extends HorizontalScrollView {
    private int f2553a;
    private int f2554b;
    private int f2555c;
    private LayoutInflater f2556d;
    private View f2557e;
    private LinearLayout f2558f;
    private int f2559g;
    private C0578a f2560h;

    /* renamed from: com.anglelabs.alarmclock.redesign.views.HorizontalPicturesViewer.a */
    public interface C0578a {
        void m2706a(int i);
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.views.HorizontalPicturesViewer.1 */
    class C08821 implements C0881e {
        final /* synthetic */ ViewSwitcher f2544a;
        final /* synthetic */ int f2545b;
        final /* synthetic */ int[] f2546c;
        final /* synthetic */ int f2547d;
        final /* synthetic */ HorizontalPicturesViewer f2548e;

        C08821(HorizontalPicturesViewer horizontalPicturesViewer, ViewSwitcher viewSwitcher, int i, int[] iArr, int i2) {
            this.f2548e = horizontalPicturesViewer;
            this.f2544a = viewSwitcher;
            this.f2545b = i;
            this.f2546c = iArr;
            this.f2547d = i2;
        }

        @SuppressLint({"NewApi"})
        public void m4098a() {
            this.f2544a.showNext();
            if (this.f2545b == this.f2546c[this.f2547d]) {
                return;
            }
            if (C0810h.f2131e) {
                this.f2544a.setBackground(null);
            } else {
                this.f2544a.setBackgroundDrawable(null);
            }
        }

        public void m4099b() {
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.views.HorizontalPicturesViewer.2 */
    class C08832 implements OnClickListener {
        final /* synthetic */ ViewSwitcher f2549a;
        final /* synthetic */ HorizontalPicturesViewer f2550b;

        C08832(HorizontalPicturesViewer horizontalPicturesViewer, ViewSwitcher viewSwitcher) {
            this.f2550b = horizontalPicturesViewer;
            this.f2549a = viewSwitcher;
        }

        public void onClick(View v) {
            int index = ((Integer) v.getTag()).intValue();
            this.f2550b.m4103a(this.f2549a, ((Integer) this.f2549a.getTag()).intValue());
            this.f2550b.m4105b(v, index);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.views.HorizontalPicturesViewer.3 */
    class C08843 implements OnPreDrawListener {
        final /* synthetic */ View f2551a;
        final /* synthetic */ HorizontalPicturesViewer f2552b;

        C08843(HorizontalPicturesViewer horizontalPicturesViewer, View view) {
            this.f2552b = horizontalPicturesViewer;
            this.f2551a = view;
        }

        public boolean onPreDraw() {
            if (this.f2551a != null) {
                this.f2552b.scrollTo(this.f2551a.getLeft() - ab.m3759a(50, this.f2552b.getResources()), this.f2551a.getTop());
                this.f2551a.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            return true;
        }
    }

    public HorizontalPicturesViewer(Context context) {
        super(context);
        m4100a(context);
    }

    public HorizontalPicturesViewer(Context context, AttributeSet attrs) {
        super(context, attrs);
        m4100a(context);
        m4101a(context, attrs);
    }

    public HorizontalPicturesViewer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        m4100a(context);
        m4101a(context, attrs);
    }

    private void m4101a(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, C0498a.HorizontalPictureViewer, 0, 0);
        try {
            this.f2554b = (int) a.getDimension(1, 0.0f);
            this.f2553a = (int) a.getDimension(0, 0.0f);
            this.f2555c = (int) a.getDimension(2, 0.0f);
        } finally {
            a.recycle();
        }
    }

    private void m4100a(Context context) {
        this.f2556d = LayoutInflater.from(context);
        setHorizontalScrollBarEnabled(false);
    }

    public void m4108a(int[] resourcesId, C0578a listener, int choosedBackgroundRes) {
        this.f2560h = listener;
        this.f2558f = new LinearLayout(getContext());
        this.f2558f.setLayoutParams(new LayoutParams(-2, -2));
        LayoutParams layoutParams = new LayoutParams(this.f2553a, this.f2554b);
        for (int position = 0; position < resourcesId.length; position++) {
            ViewSwitcher view = (ViewSwitcher) this.f2556d.inflate(R.layout.redesign_list_item_choose_background, this, false);
            layoutParams.setMargins(this.f2555c, 0, this.f2555c, 0);
            view.setLayoutParams(layoutParams);
            C1295r.m5496a(getContext()).m5502a(resourcesId[position]).m5529a(this.f2553a, this.f2554b).m5530a((ImageView) view.findViewById(R.id.backgroundPic), new C08821(this, view, choosedBackgroundRes, resourcesId, position));
            if (choosedBackgroundRes == resourcesId[position]) {
                this.f2559g = position;
            }
            view.setTag(Integer.valueOf(position));
            this.f2558f.addView(view);
            view.setOnClickListener(new C08832(this, view));
        }
        addView(this.f2558f);
        setSelection(this.f2559g);
    }

    public void setSelection(int position) {
        if (this.f2558f != null) {
            View view = this.f2558f.getChildAt(position);
            if (view != null) {
                if (position != 0) {
                    m4102a(view);
                }
                m4105b(view, position);
            }
        }
    }

    public void m4107a(int position) {
        if (this.f2558f != null) {
            View view = this.f2558f.getChildAt(position);
            view.getLocationOnScreen(new int[2]);
            getHitRect(new Rect());
            m4105b(view, position);
            m4103a(view, position);
        }
    }

    private void m4103a(View view, int position) {
        boolean outOfLeftBound;
        Rect scrollRect = new Rect();
        getHitRect(scrollRect);
        i = new int[2];
        view.getLocationOnScreen(i);
        i[1] = i[0] + view.getWidth();
        int rightLimit = (scrollRect.right - (this.f2555c * 2)) - (view.getWidth() / 4);
        int leftLimit = (this.f2555c * 2) + (view.getWidth() / 4);
        boolean outOfRightBounds;
        if (i[1] > rightLimit) {
            outOfRightBounds = true;
        } else {
            outOfRightBounds = false;
        }
        if (i[0] < leftLimit) {
            outOfLeftBound = true;
        } else {
            outOfLeftBound = false;
        }
        if (outOfLeftBound || outOfRightBounds) {
            int scrollBy = outOfLeftBound ? leftLimit - i[0] : rightLimit - i[1];
            if (C0810h.f2129c) {
                try {
                    C0807e.m3818c(this, scrollBy).m4999a();
                } catch (Exception e) {
                    C0970a.m4322a(e);
                }
            }
        }
        if (this.f2560h != null) {
            this.f2560h.m2706a(position);
        }
    }

    private void m4102a(View view) {
        view.getViewTreeObserver().addOnPreDrawListener(new C08843(this, view));
    }

    private void m4105b(View view, int position) {
        if (this.f2557e != null) {
            this.f2557e.setBackgroundResource(0);
        }
        this.f2557e = view;
        this.f2559g = position;
        view.setBackgroundResource(R.drawable.shape_border_white);
    }
}
