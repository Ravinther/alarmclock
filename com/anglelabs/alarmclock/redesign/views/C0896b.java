package com.anglelabs.alarmclock.redesign.views;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.avg.toolkit.p049e.C0970a;

/* renamed from: com.anglelabs.alarmclock.redesign.views.b */
public class C0896b implements OnScrollListener {
    boolean f2647a;
    private boolean f2648b;
    private final Handler f2649c;
    private int f2650d;
    private final Handler f2651e;
    private final C0875a f2652f;
    private int f2653g;

    /* renamed from: com.anglelabs.alarmclock.redesign.views.b.a */
    public interface C0875a {
        ListView getListView();
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.views.b.1 */
    class C08911 extends CountDownTimer {
        final /* synthetic */ ListView f2620a;
        final /* synthetic */ int f2621b;
        final /* synthetic */ int f2622c;
        final /* synthetic */ C0896b f2623d;

        C08911(C0896b c0896b, long x0, long x1, ListView listView, int i, int i2) {
            this.f2623d = c0896b;
            this.f2620a = listView;
            this.f2621b = i;
            this.f2622c = i2;
            super(x0, x1);
        }

        public void onTick(long millisUntilFinished) {
        }

        public void onFinish() {
            this.f2623d.m4139b(this.f2620a, this.f2621b, this.f2622c);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.views.b.2 */
    class C08922 implements Runnable {
        final /* synthetic */ ListView f2624a;
        final /* synthetic */ int f2625b;
        final /* synthetic */ int f2626c;
        final /* synthetic */ CountDownTimer f2627d;
        final /* synthetic */ C0896b f2628e;

        C08922(C0896b c0896b, ListView listView, int i, int i2, CountDownTimer countDownTimer) {
            this.f2628e = c0896b;
            this.f2624a = listView;
            this.f2625b = i;
            this.f2626c = i2;
            this.f2627d = countDownTimer;
        }

        @TargetApi(11)
        public void run() {
            this.f2624a.smoothScrollToPositionFromTop(this.f2625b, this.f2626c, 250);
            this.f2627d.start();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.views.b.3 */
    class C08933 implements Runnable {
        final /* synthetic */ ListView f2629a;
        final /* synthetic */ int f2630b;
        final /* synthetic */ int f2631c;
        final /* synthetic */ C0896b f2632d;

        C08933(C0896b c0896b, ListView listView, int i, int i2) {
            this.f2632d = c0896b;
            this.f2629a = listView;
            this.f2630b = i;
            this.f2631c = i2;
        }

        public void run() {
            this.f2632d.f2648b = true;
            this.f2629a.setSelectionFromTop(this.f2630b, this.f2631c);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.views.b.4 */
    class C08944 implements Runnable {
        final /* synthetic */ int f2633a;
        final /* synthetic */ int f2634b;
        final /* synthetic */ int f2635c;
        final /* synthetic */ int f2636d;
        final /* synthetic */ ListView f2637e;
        final /* synthetic */ int f2638f;
        final /* synthetic */ C0896b f2639g;

        C08944(C0896b c0896b, int i, int i2, int i3, int i4, ListView listView, int i5) {
            this.f2639g = c0896b;
            this.f2633a = i;
            this.f2634b = i2;
            this.f2635c = i3;
            this.f2636d = i4;
            this.f2637e = listView;
            this.f2638f = i5;
        }

        public void run() {
            C0970a.m4323a("scrollAPI10Down, Runnable:\n scrollUp -> position:" + this.f2633a + " currentOffset:" + this.f2634b + " desireOffset:" + this.f2635c + " iteration:" + this.f2636d);
            this.f2637e.setSelectionFromTop(this.f2633a, this.f2634b);
            this.f2639g.m4133a(this.f2633a, this.f2634b + this.f2638f, this.f2635c, this.f2638f, this.f2637e, this.f2636d + 1);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.views.b.5 */
    class C08955 implements Runnable {
        final /* synthetic */ int f2640a;
        final /* synthetic */ int f2641b;
        final /* synthetic */ int f2642c;
        final /* synthetic */ int f2643d;
        final /* synthetic */ ListView f2644e;
        final /* synthetic */ int f2645f;
        final /* synthetic */ C0896b f2646g;

        C08955(C0896b c0896b, int i, int i2, int i3, int i4, ListView listView, int i5) {
            this.f2646g = c0896b;
            this.f2640a = i;
            this.f2641b = i2;
            this.f2642c = i3;
            this.f2643d = i4;
            this.f2644e = listView;
            this.f2645f = i5;
        }

        public void run() {
            C0970a.m4323a("scrollAPI10Down, Runnable:\n  scrollDown -> position:" + this.f2640a + " currentOffset:" + this.f2641b + " desireOffset:" + this.f2642c + " iteration:" + this.f2643d);
            this.f2644e.setSelectionFromTop(this.f2640a, this.f2641b);
            this.f2646g.m4138b(this.f2640a, this.f2641b + this.f2645f, this.f2642c, this.f2645f, this.f2644e, this.f2643d + 1);
        }
    }

    public C0896b(C0875a callback, int offset) {
        this.f2647a = false;
        this.f2649c = new Handler();
        this.f2650d = 0;
        this.f2651e = new Handler();
        this.f2653g = 0;
        this.f2653g = offset;
        this.f2652f = callback;
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == 0) {
            ListView listView = this.f2652f.getListView();
            if (this.f2647a) {
                this.f2647a = false;
                m4139b(listView, this.f2650d, this.f2653g);
                return;
            }
            View firstVisible = listView.getChildAt(0);
            int firstPosition = listView.getFirstVisiblePosition();
            int firstTop = firstVisible.getTop();
            int firstButton = firstVisible.getBottom();
            int itemHeight = firstVisible.getHeight();
            C0970a.m4323a("onScrollStateChanged details -> firstPosition:" + firstPosition + " firstTop: " + firstTop + " firstButton:" + firstButton + " itemHeight:" + itemHeight + " initialScrolloffset:" + this.f2653g);
            if (VERSION.SDK_INT >= 11) {
                if (((double) firstButton) + (((double) itemHeight) * 0.4d) > ((double) itemHeight)) {
                    this.f2650d = firstPosition;
                } else {
                    this.f2650d = firstPosition + 1;
                }
                m4134a(listView, this.f2650d, this.f2653g);
            } else if (((float) firstButton) + (((float) itemHeight) * 0.4f) > ((float) itemHeight)) {
                m4138b(firstPosition, firstTop + 5, this.f2653g, 5, listView, 0);
            } else {
                m4133a(firstPosition + 1, firstButton - 5, this.f2653g, -5, listView, 0);
            }
        }
    }

    private void m4134a(ListView listView, int position, int desireOffset) {
        this.f2647a = true;
        this.f2648b = false;
        this.f2651e.post(new C08922(this, listView, position, desireOffset, new C08911(this, 280, 70, listView, position, desireOffset)));
    }

    private void m4139b(ListView listView, int position, int desireOffset) {
        if (!this.f2648b) {
            this.f2649c.post(new C08933(this, listView, position, desireOffset));
        }
    }

    private void m4133a(int position, int currentOffset, int desireOffset, int gap, ListView listView, int iteration) {
        if (iteration <= 40) {
            if (currentOffset - desireOffset > 0) {
                this.f2651e.post(new C08944(this, position, currentOffset, desireOffset, iteration, listView, gap));
                return;
            }
            listView.setSelectionFromTop(position, desireOffset);
            listView.requestFocusFromTouch();
        }
    }

    private void m4138b(int position, int currentOffset, int desireOffset, int gap, ListView listView, int iteration) {
        if (iteration <= 40) {
            if (desireOffset - currentOffset > 0) {
                this.f2651e.post(new C08955(this, position, currentOffset, desireOffset, iteration, listView, gap));
                return;
            }
            listView.setSelectionFromTop(position, desireOffset);
            listView.requestFocusFromTouch();
        }
    }

    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
    }
}
