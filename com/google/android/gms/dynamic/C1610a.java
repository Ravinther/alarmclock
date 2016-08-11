package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.google.android.gms.dynamic.a */
public abstract class C1610a {
    private LifecycleDelegate Hj;
    private Bundle Hk;
    private LinkedList Hl;
    private final C1601f Hm;

    /* renamed from: com.google.android.gms.dynamic.a.1 */
    class C16021 implements C1601f {
        final /* synthetic */ C1610a Hn;

        C16021(C1610a c1610a) {
            this.Hn = c1610a;
        }

        public void m6709a(LifecycleDelegate lifecycleDelegate) {
            this.Hn.Hj = lifecycleDelegate;
            Iterator it = this.Hn.Hl.iterator();
            while (it.hasNext()) {
                ((C1603a) it.next()).m6710b(this.Hn.Hj);
            }
            this.Hn.Hl.clear();
            this.Hn.Hk = null;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.a */
    private interface C1603a {
        void m6710b(LifecycleDelegate lifecycleDelegate);

        int getState();
    }

    /* renamed from: com.google.android.gms.dynamic.a.2 */
    class C16042 implements C1603a {
        final /* synthetic */ C1610a Hn;
        final /* synthetic */ Activity Ho;
        final /* synthetic */ Bundle Hp;
        final /* synthetic */ Bundle Hq;

        C16042(C1610a c1610a, Activity activity, Bundle bundle, Bundle bundle2) {
            this.Hn = c1610a;
            this.Ho = activity;
            this.Hp = bundle;
            this.Hq = bundle2;
        }

        public void m6711b(LifecycleDelegate lifecycleDelegate) {
            this.Hn.Hj.onInflate(this.Ho, this.Hp, this.Hq);
        }

        public int getState() {
            return 0;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.3 */
    class C16053 implements C1603a {
        final /* synthetic */ C1610a Hn;
        final /* synthetic */ Bundle Hq;

        C16053(C1610a c1610a, Bundle bundle) {
            this.Hn = c1610a;
            this.Hq = bundle;
        }

        public void m6712b(LifecycleDelegate lifecycleDelegate) {
            this.Hn.Hj.onCreate(this.Hq);
        }

        public int getState() {
            return 1;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.4 */
    class C16064 implements C1603a {
        final /* synthetic */ C1610a Hn;
        final /* synthetic */ Bundle Hq;
        final /* synthetic */ FrameLayout Hr;
        final /* synthetic */ LayoutInflater Hs;
        final /* synthetic */ ViewGroup Ht;

        C16064(C1610a c1610a, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.Hn = c1610a;
            this.Hr = frameLayout;
            this.Hs = layoutInflater;
            this.Ht = viewGroup;
            this.Hq = bundle;
        }

        public void m6713b(LifecycleDelegate lifecycleDelegate) {
            this.Hr.removeAllViews();
            this.Hr.addView(this.Hn.Hj.onCreateView(this.Hs, this.Ht, this.Hq));
        }

        public int getState() {
            return 2;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.5 */
    static class C16075 implements OnClickListener {
        final /* synthetic */ int Hu;
        final /* synthetic */ Context pB;

        C16075(Context context, int i) {
            this.pB = context;
            this.Hu = i;
        }

        public void onClick(View v) {
            this.pB.startActivity(GooglePlayServicesUtil.m6212b(this.pB, this.Hu));
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.6 */
    class C16086 implements C1603a {
        final /* synthetic */ C1610a Hn;

        C16086(C1610a c1610a) {
            this.Hn = c1610a;
        }

        public void m6714b(LifecycleDelegate lifecycleDelegate) {
            this.Hn.Hj.onStart();
        }

        public int getState() {
            return 4;
        }
    }

    /* renamed from: com.google.android.gms.dynamic.a.7 */
    class C16097 implements C1603a {
        final /* synthetic */ C1610a Hn;

        C16097(C1610a c1610a) {
            this.Hn = c1610a;
        }

        public void m6715b(LifecycleDelegate lifecycleDelegate) {
            this.Hn.Hj.onResume();
        }

        public int getState() {
            return 5;
        }
    }

    public C1610a() {
        this.Hm = new C16021(this);
    }

    private void m6719a(Bundle bundle, C1603a c1603a) {
        if (this.Hj != null) {
            c1603a.m6710b(this.Hj);
            return;
        }
        if (this.Hl == null) {
            this.Hl = new LinkedList();
        }
        this.Hl.add(c1603a);
        if (bundle != null) {
            if (this.Hk == null) {
                this.Hk = (Bundle) bundle.clone();
            } else {
                this.Hk.putAll(bundle);
            }
        }
        m6723a(this.Hm);
    }

    private void aR(int i) {
        while (!this.Hl.isEmpty() && ((C1603a) this.Hl.getLast()).getState() >= i) {
            this.Hl.removeLast();
        }
    }

    public static void m6721b(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        CharSequence c = GooglePlayServicesUtil.m6216c(context, isGooglePlayServicesAvailable);
        CharSequence d = GooglePlayServicesUtil.m6218d(context, isGooglePlayServicesAvailable);
        View linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        View textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(c);
        linearLayout.addView(textView);
        if (d != null) {
            View button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(d);
            linearLayout.addView(button);
            button.setOnClickListener(new C16075(context, isGooglePlayServicesAvailable));
        }
    }

    protected void m6722a(FrameLayout frameLayout) {
        C1610a.m6721b(frameLayout);
    }

    protected abstract void m6723a(C1601f c1601f);

    public LifecycleDelegate fW() {
        return this.Hj;
    }

    public void onCreate(Bundle savedInstanceState) {
        m6719a(savedInstanceState, new C16053(this, savedInstanceState));
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        m6719a(savedInstanceState, new C16064(this, frameLayout, inflater, container, savedInstanceState));
        if (this.Hj == null) {
            m6722a(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.Hj != null) {
            this.Hj.onDestroy();
        } else {
            aR(1);
        }
    }

    public void onDestroyView() {
        if (this.Hj != null) {
            this.Hj.onDestroyView();
        } else {
            aR(2);
        }
    }

    public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
        m6719a(savedInstanceState, new C16042(this, activity, attrs, savedInstanceState));
    }

    public void onLowMemory() {
        if (this.Hj != null) {
            this.Hj.onLowMemory();
        }
    }

    public void onPause() {
        if (this.Hj != null) {
            this.Hj.onPause();
        } else {
            aR(5);
        }
    }

    public void onResume() {
        m6719a(null, new C16097(this));
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.Hj != null) {
            this.Hj.onSaveInstanceState(outState);
        } else if (this.Hk != null) {
            outState.putAll(this.Hk);
        }
    }

    public void onStart() {
        m6719a(null, new C16086(this));
    }

    public void onStop() {
        if (this.Hj != null) {
            this.Hj.onStop();
        } else {
            aR(4);
        }
    }
}
