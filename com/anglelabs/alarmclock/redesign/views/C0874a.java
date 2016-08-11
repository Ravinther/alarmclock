package com.anglelabs.alarmclock.redesign.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;

/* renamed from: com.anglelabs.alarmclock.redesign.views.a */
public class C0874a extends ListView {
    protected C0890a f2515a;
    private boolean f2516b;
    private boolean f2517c;
    private OnScrollListener f2518d;

    /* renamed from: com.anglelabs.alarmclock.redesign.views.a.1 */
    class C08891 implements OnScrollListener {
        final /* synthetic */ C0874a f2615a;

        C08891(C0874a c0874a) {
            this.f2615a = c0874a;
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
            this.f2615a.f2518d.onScrollStateChanged(view, scrollState);
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            int listRealSize = this.f2615a.f2515a.m4132a();
            int floor = firstVisibleItem % this.f2615a.f2515a.m4132a();
            View firstVisiblePositionView;
            if (this.f2615a.f2517c && floor == 0 && firstVisibleItem != listRealSize) {
                firstVisiblePositionView = this.f2615a.getChildAt(0);
                if (firstVisiblePositionView != null) {
                    this.f2615a.setSelectionFromTop(listRealSize, firstVisiblePositionView.getTop());
                    return;
                }
                return;
            }
            if (this.f2615a.f2516b) {
                int lastItemVisiblePosition = (listRealSize - visibleItemCount) - 1;
                if (floor != lastItemVisiblePosition || firstVisibleItem == lastItemVisiblePosition) {
                    lastItemVisiblePosition++;
                    if (floor == lastItemVisiblePosition && firstVisibleItem != lastItemVisiblePosition) {
                        firstVisiblePositionView = this.f2615a.getChildAt(0);
                        if (firstVisiblePositionView != null) {
                            this.f2615a.setSelectionFromTop(lastItemVisiblePosition, firstVisiblePositionView.getTop());
                            return;
                        }
                        return;
                    }
                }
                firstVisiblePositionView = this.f2615a.getChildAt(0);
                if (firstVisiblePositionView != null) {
                    this.f2615a.setSelectionFromTop(lastItemVisiblePosition, firstVisiblePositionView.getTop());
                    return;
                }
                return;
            }
            this.f2615a.f2518d.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.views.a.a */
    public class C0890a extends ArrayAdapter {
        final /* synthetic */ C0874a f2616a;
        private final ArrayAdapter f2617b;
        private final int f2618c;
        private int f2619d;

        public C0890a(C0874a c0874a, Context context, int layoutResourceId, int textViewResourceId, List items) {
            this.f2616a = c0874a;
            super(context, layoutResourceId, textViewResourceId, items);
            this.f2617b = new ArrayAdapter(context, layoutResourceId, textViewResourceId, items);
            this.f2618c = this.f2617b.getCount();
            this.f2619d = this.f2618c * 2;
        }

        public Object getItem(int position) {
            return this.f2617b.getItem(position % this.f2618c);
        }

        public long getItemId(int position) {
            return this.f2617b.getItemId(position % this.f2618c);
        }

        public void notifyDataSetChanged() {
            this.f2617b.notifyDataSetChanged();
            super.notifyDataSetChanged();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            return this.f2617b.getView(position % this.f2618c, convertView, parent);
        }

        private void m4131b() {
            if (this.f2616a.getChildCount() > this.f2619d - this.f2618c) {
                this.f2619d += this.f2619d;
            }
        }

        public int getCount() {
            m4131b();
            return this.f2619d;
        }

        public int m4132a() {
            return this.f2618c;
        }
    }

    public C0874a(Context context) {
        super(context);
        this.f2516b = true;
        this.f2517c = true;
    }

    public C0874a(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f2516b = true;
        this.f2517c = true;
    }

    public C0874a(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f2516b = true;
        this.f2517c = true;
    }

    public boolean m4080a() {
        return this.f2516b;
    }

    public void setInfiniteScrollDown(boolean infiniteScrollDown) {
        this.f2516b = infiniteScrollDown;
    }

    public boolean m4081b() {
        return this.f2517c;
    }

    public void setInfiniteScrollUp(boolean infiniteScrollUp) {
        this.f2517c = infiniteScrollUp;
    }

    public void setOnScrollListener(OnScrollListener listener) {
        this.f2518d = listener;
    }

    public void m4079a(List items, int layoutResourceId, int textViewResourceId) {
        this.f2515a = new C0890a(this, getContext(), layoutResourceId, textViewResourceId, items);
        setAdapter(this.f2515a);
        super.setOnScrollListener(new C08891(this));
    }
}
