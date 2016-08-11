package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.C0075i.C0067a;
import android.support.v4.app.C0075i.C0074b;
import android.support.v4.p010d.C0140c;
import android.support.v4.p010d.C0141d;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.google.android.gms.cast.Cast;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: android.support.v4.app.j */
final class C0082j extends C0075i implements Factory {
    static final Interpolator f210A;
    static final Interpolator f211B;
    static final Interpolator f212C;
    static boolean f213a;
    static final boolean f214b;
    static final Interpolator f215z;
    ArrayList f216c;
    Runnable[] f217d;
    boolean f218e;
    ArrayList f219f;
    ArrayList f220g;
    ArrayList f221h;
    ArrayList f222i;
    ArrayList f223j;
    ArrayList f224k;
    ArrayList f225l;
    ArrayList f226m;
    int f227n;
    C0073g f228o;
    C0032h f229p;
    Fragment f230q;
    boolean f231r;
    boolean f232s;
    boolean f233t;
    String f234u;
    boolean f235v;
    Bundle f236w;
    SparseArray f237x;
    Runnable f238y;

    /* renamed from: android.support.v4.app.j.1 */
    class C00761 implements Runnable {
        final /* synthetic */ C0082j f199a;

        C00761(C0082j c0082j) {
            this.f199a = c0082j;
        }

        public void run() {
            this.f199a.m329h();
        }
    }

    /* renamed from: android.support.v4.app.j.2 */
    class C00772 implements Runnable {
        final /* synthetic */ C0082j f200a;

        C00772(C0082j c0082j) {
            this.f200a = c0082j;
        }

        public void run() {
            this.f200a.m302a(this.f200a.f228o.f186a, null, -1, 0);
        }
    }

    /* renamed from: android.support.v4.app.j.3 */
    class C00783 implements Runnable {
        final /* synthetic */ String f201a;
        final /* synthetic */ int f202b;
        final /* synthetic */ C0082j f203c;

        C00783(C0082j c0082j, String str, int i) {
            this.f203c = c0082j;
            this.f201a = str;
            this.f202b = i;
        }

        public void run() {
            this.f203c.m302a(this.f203c.f228o.f186a, this.f201a, -1, this.f202b);
        }
    }

    /* renamed from: android.support.v4.app.j.4 */
    class C00794 implements Runnable {
        final /* synthetic */ int f204a;
        final /* synthetic */ int f205b;
        final /* synthetic */ C0082j f206c;

        C00794(C0082j c0082j, int i, int i2) {
            this.f206c = c0082j;
            this.f204a = i;
            this.f205b = i2;
        }

        public void run() {
            this.f206c.m302a(this.f206c.f228o.f186a, null, this.f204a, this.f205b);
        }
    }

    /* renamed from: android.support.v4.app.j.5 */
    class C00805 implements AnimationListener {
        final /* synthetic */ Fragment f207a;
        final /* synthetic */ C0082j f208b;

        C00805(C0082j c0082j, Fragment fragment) {
            this.f208b = c0082j;
            this.f207a = fragment;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f207a.mAnimatingAway != null) {
                this.f207a.mAnimatingAway = null;
                this.f208b.m295a(this.f207a, this.f207a.mStateAfterAnimating, 0, 0, false);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: android.support.v4.app.j.a */
    static class C0081a {
        public static final int[] f209a;

        static {
            f209a = new int[]{16842755, 16842960, 16842961};
        }
    }

    C0082j() {
        this.f227n = 0;
        this.f236w = null;
        this.f237x = null;
        this.f238y = new C00761(this);
    }

    static {
        boolean z = false;
        f213a = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f214b = z;
        f215z = new DecelerateInterpolator(2.5f);
        f210A = new DecelerateInterpolator(1.5f);
        f211B = new AccelerateInterpolator(2.5f);
        f212C = new AccelerateInterpolator(1.5f);
    }

    private void m276a(RuntimeException ex) {
        Log.e("FragmentManager", ex.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter pw = new PrintWriter(new C0141d("FragmentManager"));
        if (this.f228o != null) {
            try {
                this.f228o.dump("  ", null, pw, new String[0]);
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                m301a("  ", null, pw, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw ex;
    }

    public C0066l m284a() {
        return new C0068e(this);
    }

    public boolean m313b() {
        return m329h();
    }

    public void m316c() {
        m299a(new C00772(this), false);
    }

    public boolean m322d() {
        m279x();
        m313b();
        return m302a(this.f228o.f186a, null, -1, 0);
    }

    public void m300a(String name, int flags) {
        m299a(new C00783(this, name, flags), false);
    }

    public boolean m315b(String name, int flags) {
        m279x();
        m313b();
        return m302a(this.f228o.f186a, name, -1, flags);
    }

    public void m286a(int id, int flags) {
        if (id < 0) {
            throw new IllegalArgumentException("Bad id: " + id);
        }
        m299a(new C00794(this, id, flags), false);
    }

    public int m323e() {
        return this.f222i != null ? this.f222i.size() : 0;
    }

    public C0067a m307b(int index) {
        return (C0067a) this.f222i.get(index);
    }

    public void m298a(C0074b listener) {
        if (this.f226m == null) {
            this.f226m = new ArrayList();
        }
        this.f226m.add(listener);
    }

    public void m311b(C0074b listener) {
        if (this.f226m != null) {
            this.f226m.remove(listener);
        }
    }

    public void m291a(Bundle bundle, String key, Fragment fragment) {
        if (fragment.mIndex < 0) {
            m276a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(key, fragment.mIndex);
    }

    public Fragment m282a(Bundle bundle, String key) {
        int index = bundle.getInt(key, -1);
        if (index == -1) {
            return null;
        }
        if (index >= this.f219f.size()) {
            m276a(new IllegalStateException("Fragment no longer exists for key " + key + ": index " + index));
        }
        Fragment f = (Fragment) this.f219f.get(index);
        if (f != null) {
            return f;
        }
        m276a(new IllegalStateException("Fragment no longer exists for key " + key + ": index " + index));
        return f;
    }

    public List m327f() {
        return this.f219f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Cast.MAX_NAMESPACE_LENGTH);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.f230q != null) {
            C0140c.m548a(this.f230q, sb);
        } else {
            C0140c.m548a(this.f228o, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    public void m301a(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        int N;
        int i;
        String innerPrefix = prefix + "    ";
        if (this.f219f != null) {
            N = this.f219f.size();
            if (N > 0) {
                writer.print(prefix);
                writer.print("Active Fragments in ");
                writer.print(Integer.toHexString(System.identityHashCode(this)));
                writer.println(":");
                for (i = 0; i < N; i++) {
                    Fragment f;
                    f = (Fragment) this.f219f.get(i);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i);
                    writer.print(": ");
                    writer.println(f);
                    if (f != null) {
                        f.dump(innerPrefix, fd, writer, args);
                    }
                }
            }
        }
        if (this.f220g != null) {
            N = this.f220g.size();
            if (N > 0) {
                writer.print(prefix);
                writer.println("Added Fragments:");
                for (i = 0; i < N; i++) {
                    f = (Fragment) this.f220g.get(i);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i);
                    writer.print(": ");
                    writer.println(f.toString());
                }
            }
        }
        if (this.f223j != null) {
            N = this.f223j.size();
            if (N > 0) {
                writer.print(prefix);
                writer.println("Fragments Created Menus:");
                for (i = 0; i < N; i++) {
                    f = (Fragment) this.f223j.get(i);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i);
                    writer.print(": ");
                    writer.println(f.toString());
                }
            }
        }
        if (this.f222i != null) {
            N = this.f222i.size();
            if (N > 0) {
                writer.print(prefix);
                writer.println("Back Stack:");
                for (i = 0; i < N; i++) {
                    C0068e bs = (C0068e) this.f222i.get(i);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i);
                    writer.print(": ");
                    writer.println(bs.toString());
                    bs.m233a(innerPrefix, fd, writer, args);
                }
            }
        }
        synchronized (this) {
            if (this.f224k != null) {
                N = this.f224k.size();
                if (N > 0) {
                    writer.print(prefix);
                    writer.println("Back Stack Indices:");
                    for (i = 0; i < N; i++) {
                        bs = (C0068e) this.f224k.get(i);
                        writer.print(prefix);
                        writer.print("  #");
                        writer.print(i);
                        writer.print(": ");
                        writer.println(bs);
                    }
                }
            }
            if (this.f225l != null && this.f225l.size() > 0) {
                writer.print(prefix);
                writer.print("mAvailBackStackIndices: ");
                writer.println(Arrays.toString(this.f225l.toArray()));
            }
        }
        if (this.f216c != null) {
            N = this.f216c.size();
            if (N > 0) {
                writer.print(prefix);
                writer.println("Pending Actions:");
                for (i = 0; i < N; i++) {
                    Runnable r = (Runnable) this.f216c.get(i);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i);
                    writer.print(": ");
                    writer.println(r);
                }
            }
        }
        writer.print(prefix);
        writer.println("FragmentManager misc state:");
        writer.print(prefix);
        writer.print("  mActivity=");
        writer.println(this.f228o);
        writer.print(prefix);
        writer.print("  mContainer=");
        writer.println(this.f229p);
        if (this.f230q != null) {
            writer.print(prefix);
            writer.print("  mParent=");
            writer.println(this.f230q);
        }
        writer.print(prefix);
        writer.print("  mCurState=");
        writer.print(this.f227n);
        writer.print(" mStateSaved=");
        writer.print(this.f232s);
        writer.print(" mDestroyed=");
        writer.println(this.f233t);
        if (this.f231r) {
            writer.print(prefix);
            writer.print("  mNeedMenuInvalidate=");
            writer.println(this.f231r);
        }
        if (this.f234u != null) {
            writer.print(prefix);
            writer.print("  mNoTransactionsBecause=");
            writer.println(this.f234u);
        }
        if (this.f221h != null && this.f221h.size() > 0) {
            writer.print(prefix);
            writer.print("  mAvailIndices: ");
            writer.println(Arrays.toString(this.f221h.toArray()));
        }
    }

    static Animation m275a(Context context, float startScale, float endScale, float startAlpha, float endAlpha) {
        AnimationSet set = new AnimationSet(false);
        ScaleAnimation scale = new ScaleAnimation(startScale, endScale, startScale, endScale, 1, 0.5f, 1, 0.5f);
        scale.setInterpolator(f215z);
        scale.setDuration(220);
        set.addAnimation(scale);
        AlphaAnimation alpha = new AlphaAnimation(startAlpha, endAlpha);
        alpha.setInterpolator(f210A);
        alpha.setDuration(220);
        set.addAnimation(alpha);
        return set;
    }

    static Animation m274a(Context context, float start, float end) {
        AlphaAnimation anim = new AlphaAnimation(start, end);
        anim.setInterpolator(f210A);
        anim.setDuration(220);
        return anim;
    }

    Animation m285a(Fragment fragment, int transit, boolean enter, int transitionStyle) {
        Animation animObj = fragment.onCreateAnimation(transit, enter, fragment.mNextAnim);
        if (animObj != null) {
            return animObj;
        }
        if (fragment.mNextAnim != 0) {
            Animation anim = AnimationUtils.loadAnimation(this.f228o, fragment.mNextAnim);
            if (anim != null) {
                return anim;
            }
        }
        if (transit == 0) {
            return null;
        }
        int styleIndex = C0082j.m277b(transit, enter);
        if (styleIndex < 0) {
            return null;
        }
        switch (styleIndex) {
            case Base64.NO_PADDING /*1*/:
                return C0082j.m275a(this.f228o, 1.125f, 1.0f, 0.0f, 1.0f);
            case Base64.NO_WRAP /*2*/:
                return C0082j.m275a(this.f228o, 1.0f, 0.975f, 1.0f, 0.0f);
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return C0082j.m275a(this.f228o, 0.975f, 1.0f, 0.0f, 1.0f);
            case Base64.CRLF /*4*/:
                return C0082j.m275a(this.f228o, 1.0f, 1.075f, 1.0f, 0.0f);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return C0082j.m274a(this.f228o, 0.0f, 1.0f);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return C0082j.m274a(this.f228o, 1.0f, 0.0f);
            default:
                if (transitionStyle == 0 && this.f228o.getWindow() != null) {
                    transitionStyle = this.f228o.getWindow().getAttributes().windowAnimations;
                }
                if (transitionStyle == 0) {
                    return null;
                }
                return null;
        }
    }

    public void m293a(Fragment f) {
        if (!f.mDeferStart) {
            return;
        }
        if (this.f218e) {
            this.f235v = true;
            return;
        }
        f.mDeferStart = false;
        m295a(f, this.f227n, 0, 0, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m295a(android.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r0 = r11.mAdded;
        if (r0 == 0) goto L_0x0008;
    L_0x0004:
        r0 = r11.mDetached;
        if (r0 == 0) goto L_0x000c;
    L_0x0008:
        r0 = 1;
        if (r12 <= r0) goto L_0x000c;
    L_0x000b:
        r12 = 1;
    L_0x000c:
        r0 = r11.mRemoving;
        if (r0 == 0) goto L_0x0016;
    L_0x0010:
        r0 = r11.mState;
        if (r12 <= r0) goto L_0x0016;
    L_0x0014:
        r12 = r11.mState;
    L_0x0016:
        r0 = r11.mDeferStart;
        if (r0 == 0) goto L_0x0023;
    L_0x001a:
        r0 = r11.mState;
        r1 = 4;
        if (r0 >= r1) goto L_0x0023;
    L_0x001f:
        r0 = 3;
        if (r12 <= r0) goto L_0x0023;
    L_0x0022:
        r12 = 3;
    L_0x0023:
        r0 = r11.mState;
        if (r0 >= r12) goto L_0x025e;
    L_0x0027:
        r0 = r11.mFromLayout;
        if (r0 == 0) goto L_0x0030;
    L_0x002b:
        r0 = r11.mInLayout;
        if (r0 != 0) goto L_0x0030;
    L_0x002f:
        return;
    L_0x0030:
        r0 = r11.mAnimatingAway;
        if (r0 == 0) goto L_0x0041;
    L_0x0034:
        r0 = 0;
        r11.mAnimatingAway = r0;
        r2 = r11.mStateAfterAnimating;
        r3 = 0;
        r4 = 0;
        r5 = 1;
        r0 = r10;
        r1 = r11;
        r0.m295a(r1, r2, r3, r4, r5);
    L_0x0041:
        r0 = r11.mState;
        switch(r0) {
            case 0: goto L_0x0049;
            case 1: goto L_0x0139;
            case 2: goto L_0x0206;
            case 3: goto L_0x0206;
            case 4: goto L_0x0228;
            default: goto L_0x0046;
        };
    L_0x0046:
        r11.mState = r12;
        goto L_0x002f;
    L_0x0049:
        r0 = f213a;
        if (r0 == 0) goto L_0x0065;
    L_0x004d:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0065:
        r0 = r11.mSavedFragmentState;
        if (r0 == 0) goto L_0x00ad;
    L_0x0069:
        r0 = r11.mSavedFragmentState;
        r1 = r10.f228o;
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.mSavedFragmentState;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.mSavedViewState = r0;
        r0 = r11.mSavedFragmentState;
        r1 = "android:target_state";
        r0 = r10.m282a(r0, r1);
        r11.mTarget = r0;
        r0 = r11.mTarget;
        if (r0 == 0) goto L_0x0097;
    L_0x008c:
        r0 = r11.mSavedFragmentState;
        r1 = "android:target_req_state";
        r2 = 0;
        r0 = r0.getInt(r1, r2);
        r11.mTargetRequestCode = r0;
    L_0x0097:
        r0 = r11.mSavedFragmentState;
        r1 = "android:user_visible_hint";
        r2 = 1;
        r0 = r0.getBoolean(r1, r2);
        r11.mUserVisibleHint = r0;
        r0 = r11.mUserVisibleHint;
        if (r0 != 0) goto L_0x00ad;
    L_0x00a6:
        r0 = 1;
        r11.mDeferStart = r0;
        r0 = 3;
        if (r12 <= r0) goto L_0x00ad;
    L_0x00ac:
        r12 = 3;
    L_0x00ad:
        r0 = r10.f228o;
        r11.mActivity = r0;
        r0 = r10.f230q;
        r11.mParentFragment = r0;
        r0 = r10.f230q;
        if (r0 == 0) goto L_0x00ea;
    L_0x00b9:
        r0 = r10.f230q;
        r0 = r0.mChildFragmentManager;
    L_0x00bd:
        r11.mFragmentManager = r0;
        r0 = 0;
        r11.mCalled = r0;
        r0 = r10.f228o;
        r11.onAttach(r0);
        r0 = r11.mCalled;
        if (r0 != 0) goto L_0x00ef;
    L_0x00cb:
        r0 = new android.support.v4.app.ai;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00ea:
        r0 = r10.f228o;
        r0 = r0.f187b;
        goto L_0x00bd;
    L_0x00ef:
        r0 = r11.mParentFragment;
        if (r0 != 0) goto L_0x00f8;
    L_0x00f3:
        r0 = r10.f228o;
        r0.m248a(r11);
    L_0x00f8:
        r0 = r11.mRetaining;
        if (r0 != 0) goto L_0x0101;
    L_0x00fc:
        r0 = r11.mSavedFragmentState;
        r11.performCreate(r0);
    L_0x0101:
        r0 = 0;
        r11.mRetaining = r0;
        r0 = r11.mFromLayout;
        if (r0 == 0) goto L_0x0139;
    L_0x0108:
        r0 = r11.mSavedFragmentState;
        r0 = r11.getLayoutInflater(r0);
        r1 = 0;
        r2 = r11.mSavedFragmentState;
        r0 = r11.performCreateView(r0, r1, r2);
        r11.mView = r0;
        r0 = r11.mView;
        if (r0 == 0) goto L_0x0255;
    L_0x011b:
        r0 = r11.mView;
        r11.mInnerView = r0;
        r0 = r11.mView;
        r0 = android.support.v4.app.C0100r.m445a(r0);
        r11.mView = r0;
        r0 = r11.mHidden;
        if (r0 == 0) goto L_0x0132;
    L_0x012b:
        r0 = r11.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0132:
        r0 = r11.mView;
        r1 = r11.mSavedFragmentState;
        r11.onViewCreated(r0, r1);
    L_0x0139:
        r0 = 1;
        if (r12 <= r0) goto L_0x0206;
    L_0x013c:
        r0 = f213a;
        if (r0 == 0) goto L_0x0158;
    L_0x0140:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0158:
        r0 = r11.mFromLayout;
        if (r0 != 0) goto L_0x01f5;
    L_0x015c:
        r7 = 0;
        r0 = r11.mContainerId;
        if (r0 == 0) goto L_0x01b0;
    L_0x0161:
        r0 = r10.f229p;
        r1 = r11.mContainerId;
        r7 = r0.m117a(r1);
        r7 = (android.view.ViewGroup) r7;
        if (r7 != 0) goto L_0x01b0;
    L_0x016d:
        r0 = r11.mRestored;
        if (r0 != 0) goto L_0x01b0;
    L_0x0171:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "No view found for id 0x";
        r1 = r1.append(r2);
        r2 = r11.mContainerId;
        r2 = java.lang.Integer.toHexString(r2);
        r1 = r1.append(r2);
        r2 = " (";
        r1 = r1.append(r2);
        r2 = r11.getResources();
        r3 = r11.mContainerId;
        r2 = r2.getResourceName(r3);
        r1 = r1.append(r2);
        r2 = ") for fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        r0.<init>(r1);
        r10.m276a(r0);
    L_0x01b0:
        r11.mContainer = r7;
        r0 = r11.mSavedFragmentState;
        r0 = r11.getLayoutInflater(r0);
        r1 = r11.mSavedFragmentState;
        r0 = r11.performCreateView(r0, r7, r1);
        r11.mView = r0;
        r0 = r11.mView;
        if (r0 == 0) goto L_0x025a;
    L_0x01c4:
        r0 = r11.mView;
        r11.mInnerView = r0;
        r0 = r11.mView;
        r0 = android.support.v4.app.C0100r.m445a(r0);
        r11.mView = r0;
        if (r7 == 0) goto L_0x01e3;
    L_0x01d2:
        r0 = 1;
        r6 = r10.m285a(r11, r13, r0, r14);
        if (r6 == 0) goto L_0x01de;
    L_0x01d9:
        r0 = r11.mView;
        r0.startAnimation(r6);
    L_0x01de:
        r0 = r11.mView;
        r7.addView(r0);
    L_0x01e3:
        r0 = r11.mHidden;
        if (r0 == 0) goto L_0x01ee;
    L_0x01e7:
        r0 = r11.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x01ee:
        r0 = r11.mView;
        r1 = r11.mSavedFragmentState;
        r11.onViewCreated(r0, r1);
    L_0x01f5:
        r0 = r11.mSavedFragmentState;
        r11.performActivityCreated(r0);
        r0 = r11.mView;
        if (r0 == 0) goto L_0x0203;
    L_0x01fe:
        r0 = r11.mSavedFragmentState;
        r11.restoreViewState(r0);
    L_0x0203:
        r0 = 0;
        r11.mSavedFragmentState = r0;
    L_0x0206:
        r0 = 3;
        if (r12 <= r0) goto L_0x0228;
    L_0x0209:
        r0 = f213a;
        if (r0 == 0) goto L_0x0225;
    L_0x020d:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0225:
        r11.performStart();
    L_0x0228:
        r0 = 4;
        if (r12 <= r0) goto L_0x0046;
    L_0x022b:
        r0 = f213a;
        if (r0 == 0) goto L_0x0247;
    L_0x022f:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0247:
        r0 = 1;
        r11.mResumed = r0;
        r11.performResume();
        r0 = 0;
        r11.mSavedFragmentState = r0;
        r0 = 0;
        r11.mSavedViewState = r0;
        goto L_0x0046;
    L_0x0255:
        r0 = 0;
        r11.mInnerView = r0;
        goto L_0x0139;
    L_0x025a:
        r0 = 0;
        r11.mInnerView = r0;
        goto L_0x01f5;
    L_0x025e:
        r0 = r11.mState;
        if (r0 <= r12) goto L_0x0046;
    L_0x0262:
        r0 = r11.mState;
        switch(r0) {
            case 1: goto L_0x0269;
            case 2: goto L_0x02ee;
            case 3: goto L_0x02cc;
            case 4: goto L_0x02aa;
            case 5: goto L_0x0285;
            default: goto L_0x0267;
        };
    L_0x0267:
        goto L_0x0046;
    L_0x0269:
        r0 = 1;
        if (r12 >= r0) goto L_0x0046;
    L_0x026c:
        r0 = r10.f233t;
        if (r0 == 0) goto L_0x027c;
    L_0x0270:
        r0 = r11.mAnimatingAway;
        if (r0 == 0) goto L_0x027c;
    L_0x0274:
        r9 = r11.mAnimatingAway;
        r0 = 0;
        r11.mAnimatingAway = r0;
        r9.clearAnimation();
    L_0x027c:
        r0 = r11.mAnimatingAway;
        if (r0 == 0) goto L_0x0361;
    L_0x0280:
        r11.mStateAfterAnimating = r12;
        r12 = 1;
        goto L_0x0046;
    L_0x0285:
        r0 = 5;
        if (r12 >= r0) goto L_0x02aa;
    L_0x0288:
        r0 = f213a;
        if (r0 == 0) goto L_0x02a4;
    L_0x028c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02a4:
        r11.performPause();
        r0 = 0;
        r11.mResumed = r0;
    L_0x02aa:
        r0 = 4;
        if (r12 >= r0) goto L_0x02cc;
    L_0x02ad:
        r0 = f213a;
        if (r0 == 0) goto L_0x02c9;
    L_0x02b1:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02c9:
        r11.performStop();
    L_0x02cc:
        r0 = 3;
        if (r12 >= r0) goto L_0x02ee;
    L_0x02cf:
        r0 = f213a;
        if (r0 == 0) goto L_0x02eb;
    L_0x02d3:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02eb:
        r11.performReallyStop();
    L_0x02ee:
        r0 = 2;
        if (r12 >= r0) goto L_0x0269;
    L_0x02f1:
        r0 = f213a;
        if (r0 == 0) goto L_0x030d;
    L_0x02f5:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x030d:
        r0 = r11.mView;
        if (r0 == 0) goto L_0x0320;
    L_0x0311:
        r0 = r10.f228o;
        r0 = r0.isFinishing();
        if (r0 != 0) goto L_0x0320;
    L_0x0319:
        r0 = r11.mSavedViewState;
        if (r0 != 0) goto L_0x0320;
    L_0x031d:
        r10.m324e(r11);
    L_0x0320:
        r11.performDestroyView();
        r0 = r11.mView;
        if (r0 == 0) goto L_0x0356;
    L_0x0327:
        r0 = r11.mContainer;
        if (r0 == 0) goto L_0x0356;
    L_0x032b:
        r6 = 0;
        r0 = r10.f227n;
        if (r0 <= 0) goto L_0x0339;
    L_0x0330:
        r0 = r10.f233t;
        if (r0 != 0) goto L_0x0339;
    L_0x0334:
        r0 = 0;
        r6 = r10.m285a(r11, r13, r0, r14);
    L_0x0339:
        if (r6 == 0) goto L_0x034f;
    L_0x033b:
        r8 = r11;
        r0 = r11.mView;
        r11.mAnimatingAway = r0;
        r11.mStateAfterAnimating = r12;
        r0 = new android.support.v4.app.j$5;
        r0.<init>(r10, r8);
        r6.setAnimationListener(r0);
        r0 = r11.mView;
        r0.startAnimation(r6);
    L_0x034f:
        r0 = r11.mContainer;
        r1 = r11.mView;
        r0.removeView(r1);
    L_0x0356:
        r0 = 0;
        r11.mContainer = r0;
        r0 = 0;
        r11.mView = r0;
        r0 = 0;
        r11.mInnerView = r0;
        goto L_0x0269;
    L_0x0361:
        r0 = f213a;
        if (r0 == 0) goto L_0x037d;
    L_0x0365:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x037d:
        r0 = r11.mRetaining;
        if (r0 != 0) goto L_0x0384;
    L_0x0381:
        r11.performDestroy();
    L_0x0384:
        r0 = 0;
        r11.mCalled = r0;
        r11.onDetach();
        r0 = r11.mCalled;
        if (r0 != 0) goto L_0x03ad;
    L_0x038e:
        r0 = new android.support.v4.app.ai;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onDetach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x03ad:
        if (r15 != 0) goto L_0x0046;
    L_0x03af:
        r0 = r11.mRetaining;
        if (r0 != 0) goto L_0x03b8;
    L_0x03b3:
        r10.m320d(r11);
        goto L_0x0046;
    L_0x03b8:
        r0 = 0;
        r11.mActivity = r0;
        r0 = 0;
        r11.mParentFragment = r0;
        r0 = 0;
        r11.mFragmentManager = r0;
        r0 = 0;
        r11.mChildFragmentManager = r0;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.j.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    void m308b(Fragment f) {
        m295a(f, this.f227n, 0, 0, false);
    }

    void m289a(int newState, boolean always) {
        m287a(newState, 0, 0, always);
    }

    void m287a(int newState, int transit, int transitStyle, boolean always) {
        if (this.f228o == null && newState != 0) {
            throw new IllegalStateException("No activity");
        } else if (always || this.f227n != newState) {
            this.f227n = newState;
            if (this.f219f != null) {
                boolean loadersRunning = false;
                for (int i = 0; i < this.f219f.size(); i++) {
                    Fragment f = (Fragment) this.f219f.get(i);
                    if (f != null) {
                        m295a(f, newState, transit, transitStyle, false);
                        if (f.mLoaderManager != null) {
                            loadersRunning |= f.mLoaderManager.m413a();
                        }
                    }
                }
                if (!loadersRunning) {
                    m328g();
                }
                if (this.f231r && this.f228o != null && this.f227n == 5) {
                    this.f228o.m256e();
                    this.f231r = false;
                }
            }
        }
    }

    void m328g() {
        if (this.f219f != null) {
            for (int i = 0; i < this.f219f.size(); i++) {
                Fragment f = (Fragment) this.f219f.get(i);
                if (f != null) {
                    m293a(f);
                }
            }
        }
    }

    void m318c(Fragment f) {
        if (f.mIndex < 0) {
            if (this.f221h == null || this.f221h.size() <= 0) {
                if (this.f219f == null) {
                    this.f219f = new ArrayList();
                }
                f.setIndex(this.f219f.size(), this.f230q);
                this.f219f.add(f);
            } else {
                f.setIndex(((Integer) this.f221h.remove(this.f221h.size() - 1)).intValue(), this.f230q);
                this.f219f.set(f.mIndex, f);
            }
            if (f213a) {
                Log.v("FragmentManager", "Allocated fragment index " + f);
            }
        }
    }

    void m320d(Fragment f) {
        if (f.mIndex >= 0) {
            if (f213a) {
                Log.v("FragmentManager", "Freeing fragment index " + f);
            }
            this.f219f.set(f.mIndex, null);
            if (this.f221h == null) {
                this.f221h = new ArrayList();
            }
            this.f221h.add(Integer.valueOf(f.mIndex));
            this.f228o.m250a(f.mWho);
            f.initState();
        }
    }

    public void m296a(Fragment fragment, boolean moveToStateNow) {
        if (this.f220g == null) {
            this.f220g = new ArrayList();
        }
        if (f213a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m318c(fragment);
        if (!fragment.mDetached) {
            if (this.f220g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.f220g.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.f231r = true;
            }
            if (moveToStateNow) {
                m308b(fragment);
            }
        }
    }

    public void m294a(Fragment fragment, int transition, int transitionStyle) {
        boolean inactive;
        if (f213a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        if (fragment.isInBackStack()) {
            inactive = false;
        } else {
            inactive = true;
        }
        if (!fragment.mDetached || inactive) {
            int i;
            if (this.f220g != null) {
                this.f220g.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.f231r = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
            if (inactive) {
                i = 0;
            } else {
                i = 1;
            }
            m295a(fragment, i, transition, transitionStyle, false);
        }
    }

    public void m309b(Fragment fragment, int transition, int transitionStyle) {
        if (f213a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            if (fragment.mView != null) {
                Animation anim = m285a(fragment, transition, false, transitionStyle);
                if (anim != null) {
                    fragment.mView.startAnimation(anim);
                }
                fragment.mView.setVisibility(8);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.f231r = true;
            }
            fragment.onHiddenChanged(true);
        }
    }

    public void m319c(Fragment fragment, int transition, int transitionStyle) {
        if (f213a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            if (fragment.mView != null) {
                Animation anim = m285a(fragment, transition, true, transitionStyle);
                if (anim != null) {
                    fragment.mView.startAnimation(anim);
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.f231r = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    public void m321d(Fragment fragment, int transition, int transitionStyle) {
        if (f213a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (this.f220g != null) {
                    if (f213a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.f220g.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.f231r = true;
                }
                fragment.mAdded = false;
                m295a(fragment, 1, transition, transitionStyle, false);
            }
        }
    }

    public void m325e(Fragment fragment, int transition, int transitionStyle) {
        if (f213a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                if (this.f220g == null) {
                    this.f220g = new ArrayList();
                }
                if (this.f220g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f213a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.f220g.add(fragment);
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.f231r = true;
                }
                m295a(fragment, this.f227n, transition, transitionStyle, false);
            }
        }
    }

    public Fragment m281a(int id) {
        int i;
        Fragment f;
        if (this.f220g != null) {
            for (i = this.f220g.size() - 1; i >= 0; i--) {
                f = (Fragment) this.f220g.get(i);
                if (f != null && f.mFragmentId == id) {
                    return f;
                }
            }
        }
        if (this.f219f != null) {
            for (i = this.f219f.size() - 1; i >= 0; i--) {
                f = (Fragment) this.f219f.get(i);
                if (f != null && f.mFragmentId == id) {
                    return f;
                }
            }
        }
        return null;
    }

    public Fragment m283a(String tag) {
        int i;
        Fragment f;
        if (!(this.f220g == null || tag == null)) {
            for (i = this.f220g.size() - 1; i >= 0; i--) {
                f = (Fragment) this.f220g.get(i);
                if (f != null && tag.equals(f.mTag)) {
                    return f;
                }
            }
        }
        if (!(this.f219f == null || tag == null)) {
            for (i = this.f219f.size() - 1; i >= 0; i--) {
                f = (Fragment) this.f219f.get(i);
                if (f != null && tag.equals(f.mTag)) {
                    return f;
                }
            }
        }
        return null;
    }

    public Fragment m306b(String who) {
        if (!(this.f219f == null || who == null)) {
            for (int i = this.f219f.size() - 1; i >= 0; i--) {
                Fragment f = (Fragment) this.f219f.get(i);
                if (f != null) {
                    f = f.findFragmentByWho(who);
                    if (f != null) {
                        return f;
                    }
                }
            }
        }
        return null;
    }

    private void m279x() {
        if (this.f232s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f234u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f234u);
        }
    }

    public void m299a(Runnable action, boolean allowStateLoss) {
        if (!allowStateLoss) {
            m279x();
        }
        synchronized (this) {
            if (this.f233t || this.f228o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f216c == null) {
                this.f216c = new ArrayList();
            }
            this.f216c.add(action);
            if (this.f216c.size() == 1) {
                this.f228o.f186a.removeCallbacks(this.f238y);
                this.f228o.f186a.post(this.f238y);
            }
        }
    }

    public int m280a(C0068e bse) {
        synchronized (this) {
            int index;
            if (this.f225l == null || this.f225l.size() <= 0) {
                if (this.f224k == null) {
                    this.f224k = new ArrayList();
                }
                index = this.f224k.size();
                if (f213a) {
                    Log.v("FragmentManager", "Setting back stack index " + index + " to " + bse);
                }
                this.f224k.add(bse);
                return index;
            }
            index = ((Integer) this.f225l.remove(this.f225l.size() - 1)).intValue();
            if (f213a) {
                Log.v("FragmentManager", "Adding back stack index " + index + " with " + bse);
            }
            this.f224k.set(index, bse);
            return index;
        }
    }

    public void m288a(int index, C0068e bse) {
        synchronized (this) {
            if (this.f224k == null) {
                this.f224k = new ArrayList();
            }
            int N = this.f224k.size();
            if (index < N) {
                if (f213a) {
                    Log.v("FragmentManager", "Setting back stack index " + index + " to " + bse);
                }
                this.f224k.set(index, bse);
            } else {
                while (N < index) {
                    this.f224k.add(null);
                    if (this.f225l == null) {
                        this.f225l = new ArrayList();
                    }
                    if (f213a) {
                        Log.v("FragmentManager", "Adding available back stack index " + N);
                    }
                    this.f225l.add(Integer.valueOf(N));
                    N++;
                }
                if (f213a) {
                    Log.v("FragmentManager", "Adding back stack index " + index + " with " + bse);
                }
                this.f224k.add(bse);
            }
        }
    }

    public void m317c(int index) {
        synchronized (this) {
            this.f224k.set(index, null);
            if (this.f225l == null) {
                this.f225l = new ArrayList();
            }
            if (f213a) {
                Log.v("FragmentManager", "Freeing back stack index " + index);
            }
            this.f225l.add(Integer.valueOf(index));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m329h() {
        /*
        r8 = this;
        r7 = 0;
        r5 = r8.f218e;
        if (r5 == 0) goto L_0x000d;
    L_0x0005:
        r5 = new java.lang.IllegalStateException;
        r6 = "Recursive entry to executePendingTransactions";
        r5.<init>(r6);
        throw r5;
    L_0x000d:
        r5 = android.os.Looper.myLooper();
        r6 = r8.f228o;
        r6 = r6.f186a;
        r6 = r6.getLooper();
        if (r5 == r6) goto L_0x0023;
    L_0x001b:
        r5 = new java.lang.IllegalStateException;
        r6 = "Must be called from main thread of process";
        r5.<init>(r6);
        throw r5;
    L_0x0023:
        r0 = 0;
    L_0x0024:
        monitor-enter(r8);
        r5 = r8.f216c;	 Catch:{ all -> 0x0096 }
        if (r5 == 0) goto L_0x0031;
    L_0x0029:
        r5 = r8.f216c;	 Catch:{ all -> 0x0096 }
        r5 = r5.size();	 Catch:{ all -> 0x0096 }
        if (r5 != 0) goto L_0x0058;
    L_0x0031:
        monitor-exit(r8);	 Catch:{ all -> 0x0096 }
        r5 = r8.f235v;
        if (r5 == 0) goto L_0x00a4;
    L_0x0036:
        r3 = 0;
        r2 = 0;
    L_0x0038:
        r5 = r8.f219f;
        r5 = r5.size();
        if (r2 >= r5) goto L_0x009d;
    L_0x0040:
        r5 = r8.f219f;
        r1 = r5.get(r2);
        r1 = (android.support.v4.app.Fragment) r1;
        if (r1 == 0) goto L_0x0055;
    L_0x004a:
        r5 = r1.mLoaderManager;
        if (r5 == 0) goto L_0x0055;
    L_0x004e:
        r5 = r1.mLoaderManager;
        r5 = r5.m413a();
        r3 = r3 | r5;
    L_0x0055:
        r2 = r2 + 1;
        goto L_0x0038;
    L_0x0058:
        r5 = r8.f216c;	 Catch:{ all -> 0x0096 }
        r4 = r5.size();	 Catch:{ all -> 0x0096 }
        r5 = r8.f217d;	 Catch:{ all -> 0x0096 }
        if (r5 == 0) goto L_0x0067;
    L_0x0062:
        r5 = r8.f217d;	 Catch:{ all -> 0x0096 }
        r5 = r5.length;	 Catch:{ all -> 0x0096 }
        if (r5 >= r4) goto L_0x006b;
    L_0x0067:
        r5 = new java.lang.Runnable[r4];	 Catch:{ all -> 0x0096 }
        r8.f217d = r5;	 Catch:{ all -> 0x0096 }
    L_0x006b:
        r5 = r8.f216c;	 Catch:{ all -> 0x0096 }
        r6 = r8.f217d;	 Catch:{ all -> 0x0096 }
        r5.toArray(r6);	 Catch:{ all -> 0x0096 }
        r5 = r8.f216c;	 Catch:{ all -> 0x0096 }
        r5.clear();	 Catch:{ all -> 0x0096 }
        r5 = r8.f228o;	 Catch:{ all -> 0x0096 }
        r5 = r5.f186a;	 Catch:{ all -> 0x0096 }
        r6 = r8.f238y;	 Catch:{ all -> 0x0096 }
        r5.removeCallbacks(r6);	 Catch:{ all -> 0x0096 }
        monitor-exit(r8);	 Catch:{ all -> 0x0096 }
        r5 = 1;
        r8.f218e = r5;
        r2 = 0;
    L_0x0085:
        if (r2 >= r4) goto L_0x0099;
    L_0x0087:
        r5 = r8.f217d;
        r5 = r5[r2];
        r5.run();
        r5 = r8.f217d;
        r6 = 0;
        r5[r2] = r6;
        r2 = r2 + 1;
        goto L_0x0085;
    L_0x0096:
        r5 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0096 }
        throw r5;
    L_0x0099:
        r8.f218e = r7;
        r0 = 1;
        goto L_0x0024;
    L_0x009d:
        if (r3 != 0) goto L_0x00a4;
    L_0x009f:
        r8.f235v = r7;
        r8.m328g();
    L_0x00a4:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.j.h():boolean");
    }

    void m330i() {
        if (this.f226m != null) {
            for (int i = 0; i < this.f226m.size(); i++) {
                ((C0074b) this.f226m.get(i)).m259a();
            }
        }
    }

    void m310b(C0068e state) {
        if (this.f222i == null) {
            this.f222i = new ArrayList();
        }
        this.f222i.add(state);
        m330i();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m302a(android.os.Handler r13, java.lang.String r14, int r15, int r16) {
        /*
        r12 = this;
        r9 = r12.f222i;
        if (r9 != 0) goto L_0x0006;
    L_0x0004:
        r9 = 0;
    L_0x0005:
        return r9;
    L_0x0006:
        if (r14 != 0) goto L_0x0039;
    L_0x0008:
        if (r15 >= 0) goto L_0x0039;
    L_0x000a:
        r9 = r16 & 1;
        if (r9 != 0) goto L_0x0039;
    L_0x000e:
        r9 = r12.f222i;
        r9 = r9.size();
        r5 = r9 + -1;
        if (r5 >= 0) goto L_0x001a;
    L_0x0018:
        r9 = 0;
        goto L_0x0005;
    L_0x001a:
        r9 = r12.f222i;
        r1 = r9.remove(r5);
        r1 = (android.support.v4.app.C0068e) r1;
        r2 = new android.util.SparseArray;
        r2.<init>();
        r6 = new android.util.SparseArray;
        r6.<init>();
        r1.m232a(r2, r6);
        r9 = 1;
        r10 = 0;
        r1.m223a(r9, r10, r2, r6);
        r12.m330i();
    L_0x0037:
        r9 = 1;
        goto L_0x0005;
    L_0x0039:
        r4 = -1;
        if (r14 != 0) goto L_0x003e;
    L_0x003c:
        if (r15 < 0) goto L_0x008e;
    L_0x003e:
        r9 = r12.f222i;
        r9 = r9.size();
        r4 = r9 + -1;
    L_0x0046:
        if (r4 < 0) goto L_0x005c;
    L_0x0048:
        r9 = r12.f222i;
        r1 = r9.get(r4);
        r1 = (android.support.v4.app.C0068e) r1;
        if (r14 == 0) goto L_0x0060;
    L_0x0052:
        r9 = r1.m241d();
        r9 = r14.equals(r9);
        if (r9 == 0) goto L_0x0060;
    L_0x005c:
        if (r4 >= 0) goto L_0x0069;
    L_0x005e:
        r9 = 0;
        goto L_0x0005;
    L_0x0060:
        if (r15 < 0) goto L_0x0066;
    L_0x0062:
        r9 = r1.f172o;
        if (r15 == r9) goto L_0x005c;
    L_0x0066:
        r4 = r4 + -1;
        goto L_0x0046;
    L_0x0069:
        r9 = r16 & 1;
        if (r9 == 0) goto L_0x008e;
    L_0x006d:
        r4 = r4 + -1;
    L_0x006f:
        if (r4 < 0) goto L_0x008e;
    L_0x0071:
        r9 = r12.f222i;
        r1 = r9.get(r4);
        r1 = (android.support.v4.app.C0068e) r1;
        if (r14 == 0) goto L_0x0085;
    L_0x007b:
        r9 = r1.m241d();
        r9 = r14.equals(r9);
        if (r9 != 0) goto L_0x008b;
    L_0x0085:
        if (r15 < 0) goto L_0x008e;
    L_0x0087:
        r9 = r1.f172o;
        if (r15 != r9) goto L_0x008e;
    L_0x008b:
        r4 = r4 + -1;
        goto L_0x006f;
    L_0x008e:
        r9 = r12.f222i;
        r9 = r9.size();
        r9 = r9 + -1;
        if (r4 != r9) goto L_0x009b;
    L_0x0098:
        r9 = 0;
        goto L_0x0005;
    L_0x009b:
        r8 = new java.util.ArrayList;
        r8.<init>();
        r9 = r12.f222i;
        r9 = r9.size();
        r3 = r9 + -1;
    L_0x00a8:
        if (r3 <= r4) goto L_0x00b6;
    L_0x00aa:
        r9 = r12.f222i;
        r9 = r9.remove(r3);
        r8.add(r9);
        r3 = r3 + -1;
        goto L_0x00a8;
    L_0x00b6:
        r9 = r8.size();
        r0 = r9 + -1;
        r2 = new android.util.SparseArray;
        r2.<init>();
        r6 = new android.util.SparseArray;
        r6.<init>();
        r3 = 0;
    L_0x00c7:
        if (r3 > r0) goto L_0x00d5;
    L_0x00c9:
        r9 = r8.get(r3);
        r9 = (android.support.v4.app.C0068e) r9;
        r9.m232a(r2, r6);
        r3 = r3 + 1;
        goto L_0x00c7;
    L_0x00d5:
        r7 = 0;
        r3 = 0;
    L_0x00d7:
        if (r3 > r0) goto L_0x010b;
    L_0x00d9:
        r9 = f213a;
        if (r9 == 0) goto L_0x00f9;
    L_0x00dd:
        r9 = "FragmentManager";
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = "Popping back stack state: ";
        r10 = r10.append(r11);
        r11 = r8.get(r3);
        r10 = r10.append(r11);
        r10 = r10.toString();
        android.util.Log.v(r9, r10);
    L_0x00f9:
        r9 = r8.get(r3);
        r9 = (android.support.v4.app.C0068e) r9;
        if (r3 != r0) goto L_0x0109;
    L_0x0101:
        r10 = 1;
    L_0x0102:
        r7 = r9.m223a(r10, r7, r2, r6);
        r3 = r3 + 1;
        goto L_0x00d7;
    L_0x0109:
        r10 = 0;
        goto L_0x0102;
    L_0x010b:
        r12.m330i();
        goto L_0x0037;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.j.a(android.os.Handler, java.lang.String, int, int):boolean");
    }

    ArrayList m331j() {
        ArrayList fragments = null;
        if (this.f219f != null) {
            for (int i = 0; i < this.f219f.size(); i++) {
                Fragment f = (Fragment) this.f219f.get(i);
                if (f != null && f.mRetainInstance) {
                    if (fragments == null) {
                        fragments = new ArrayList();
                    }
                    fragments.add(f);
                    f.mRetaining = true;
                    f.mTargetIndex = f.mTarget != null ? f.mTarget.mIndex : -1;
                    if (f213a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + f);
                    }
                }
            }
        }
        return fragments;
    }

    void m324e(Fragment f) {
        if (f.mInnerView != null) {
            if (this.f237x == null) {
                this.f237x = new SparseArray();
            } else {
                this.f237x.clear();
            }
            f.mInnerView.saveHierarchyState(this.f237x);
            if (this.f237x.size() > 0) {
                f.mSavedViewState = this.f237x;
                this.f237x = null;
            }
        }
    }

    Bundle m326f(Fragment f) {
        Bundle result = null;
        if (this.f236w == null) {
            this.f236w = new Bundle();
        }
        f.performSaveInstanceState(this.f236w);
        if (!this.f236w.isEmpty()) {
            result = this.f236w;
            this.f236w = null;
        }
        if (f.mView != null) {
            m324e(f);
        }
        if (f.mSavedViewState != null) {
            if (result == null) {
                result = new Bundle();
            }
            result.putSparseParcelableArray("android:view_state", f.mSavedViewState);
        }
        if (!f.mUserVisibleHint) {
            if (result == null) {
                result = new Bundle();
            }
            result.putBoolean("android:user_visible_hint", f.mUserVisibleHint);
        }
        return result;
    }

    Parcelable m332k() {
        m329h();
        if (f214b) {
            this.f232s = true;
        }
        if (this.f219f == null || this.f219f.size() <= 0) {
            return null;
        }
        int i;
        int N = this.f219f.size();
        FragmentState[] active = new FragmentState[N];
        boolean haveFragments = false;
        for (i = 0; i < N; i++) {
            Fragment f = (Fragment) this.f219f.get(i);
            if (f != null) {
                if (f.mIndex < 0) {
                    m276a(new IllegalStateException("Failure saving state: active " + f + " has cleared index: " + f.mIndex));
                }
                haveFragments = true;
                FragmentState fs = new FragmentState(f);
                active[i] = fs;
                if (f.mState <= 0 || fs.f95j != null) {
                    fs.f95j = f.mSavedFragmentState;
                } else {
                    fs.f95j = m326f(f);
                    if (f.mTarget != null) {
                        if (f.mTarget.mIndex < 0) {
                            m276a(new IllegalStateException("Failure saving state: " + f + " has target not in fragment manager: " + f.mTarget));
                        }
                        if (fs.f95j == null) {
                            fs.f95j = new Bundle();
                        }
                        m291a(fs.f95j, "android:target_state", f.mTarget);
                        if (f.mTargetRequestCode != 0) {
                            fs.f95j.putInt("android:target_req_state", f.mTargetRequestCode);
                        }
                    }
                }
                if (f213a) {
                    Log.v("FragmentManager", "Saved state of " + f + ": " + fs.f95j);
                }
            }
        }
        if (haveFragments) {
            int[] added = null;
            BackStackState[] backStack = null;
            if (this.f220g != null) {
                N = this.f220g.size();
                if (N > 0) {
                    added = new int[N];
                    for (i = 0; i < N; i++) {
                        added[i] = ((Fragment) this.f220g.get(i)).mIndex;
                        if (added[i] < 0) {
                            m276a(new IllegalStateException("Failure saving state: active " + this.f220g.get(i) + " has cleared index: " + added[i]));
                        }
                        if (f213a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i + ": " + this.f220g.get(i));
                        }
                    }
                }
            }
            if (this.f222i != null) {
                N = this.f222i.size();
                if (N > 0) {
                    backStack = new BackStackState[N];
                    for (i = 0; i < N; i++) {
                        backStack[i] = new BackStackState(this, (C0068e) this.f222i.get(i));
                        if (f213a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + this.f222i.get(i));
                        }
                    }
                }
            }
            Parcelable fms = new FragmentManagerState();
            fms.f83a = active;
            fms.f84b = added;
            fms.f85c = backStack;
            return fms;
        } else if (!f213a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    void m292a(Parcelable state, ArrayList nonConfig) {
        if (state != null) {
            FragmentManagerState fms = (FragmentManagerState) state;
            if (fms.f83a != null) {
                int i;
                Fragment f;
                FragmentState fs;
                if (nonConfig != null) {
                    for (i = 0; i < nonConfig.size(); i++) {
                        f = (Fragment) nonConfig.get(i);
                        if (f213a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + f);
                        }
                        fs = fms.f83a[f.mIndex];
                        fs.f96k = f;
                        f.mSavedViewState = null;
                        f.mBackStackNesting = 0;
                        f.mInLayout = false;
                        f.mAdded = false;
                        f.mTarget = null;
                        if (fs.f95j != null) {
                            fs.f95j.setClassLoader(this.f228o.getClassLoader());
                            f.mSavedViewState = fs.f95j.getSparseParcelableArray("android:view_state");
                            f.mSavedFragmentState = fs.f95j;
                        }
                    }
                }
                this.f219f = new ArrayList(fms.f83a.length);
                if (this.f221h != null) {
                    this.f221h.clear();
                }
                for (i = 0; i < fms.f83a.length; i++) {
                    fs = fms.f83a[i];
                    if (fs != null) {
                        f = fs.m127a(this.f228o, this.f230q);
                        if (f213a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i + ": " + f);
                        }
                        this.f219f.add(f);
                        fs.f96k = null;
                    } else {
                        this.f219f.add(null);
                        if (this.f221h == null) {
                            this.f221h = new ArrayList();
                        }
                        if (f213a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i);
                        }
                        this.f221h.add(Integer.valueOf(i));
                    }
                }
                if (nonConfig != null) {
                    for (i = 0; i < nonConfig.size(); i++) {
                        f = (Fragment) nonConfig.get(i);
                        if (f.mTargetIndex >= 0) {
                            if (f.mTargetIndex < this.f219f.size()) {
                                f.mTarget = (Fragment) this.f219f.get(f.mTargetIndex);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + f + " target no longer exists: " + f.mTargetIndex);
                                f.mTarget = null;
                            }
                        }
                    }
                }
                if (fms.f84b != null) {
                    this.f220g = new ArrayList(fms.f84b.length);
                    for (i = 0; i < fms.f84b.length; i++) {
                        f = (Fragment) this.f219f.get(fms.f84b[i]);
                        if (f == null) {
                            m276a(new IllegalStateException("No instantiated fragment for index #" + fms.f84b[i]));
                        }
                        f.mAdded = true;
                        if (f213a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i + ": " + f);
                        }
                        if (this.f220g.contains(f)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f220g.add(f);
                    }
                } else {
                    this.f220g = null;
                }
                if (fms.f85c != null) {
                    this.f222i = new ArrayList(fms.f85c.length);
                    for (i = 0; i < fms.f85c.length; i++) {
                        C0068e bse = fms.f85c[i].m116a(this);
                        if (f213a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + bse.f172o + "): " + bse);
                            bse.m234a("  ", new PrintWriter(new C0141d("FragmentManager")), false);
                        }
                        this.f222i.add(bse);
                        if (bse.f172o >= 0) {
                            m288a(bse.f172o, bse);
                        }
                    }
                    return;
                }
                this.f222i = null;
            }
        }
    }

    public void m297a(C0073g activity, C0032h container, Fragment parent) {
        if (this.f228o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f228o = activity;
        this.f229p = container;
        this.f230q = parent;
    }

    public void m333l() {
        this.f232s = false;
    }

    public void m334m() {
        this.f232s = false;
        m289a(1, false);
    }

    public void m335n() {
        this.f232s = false;
        m289a(2, false);
    }

    public void m336o() {
        this.f232s = false;
        m289a(4, false);
    }

    public void m337p() {
        this.f232s = false;
        m289a(5, false);
    }

    public void m338q() {
        m289a(4, false);
    }

    public void m339r() {
        this.f232s = true;
        m289a(3, false);
    }

    public void m340s() {
        m289a(2, false);
    }

    public void m341t() {
        m289a(1, false);
    }

    public void m342u() {
        this.f233t = true;
        m329h();
        m289a(0, false);
        this.f228o = null;
        this.f229p = null;
        this.f230q = null;
    }

    public void m290a(Configuration newConfig) {
        if (this.f220g != null) {
            for (int i = 0; i < this.f220g.size(); i++) {
                Fragment f = (Fragment) this.f220g.get(i);
                if (f != null) {
                    f.performConfigurationChanged(newConfig);
                }
            }
        }
    }

    public void m343v() {
        if (this.f220g != null) {
            for (int i = 0; i < this.f220g.size(); i++) {
                Fragment f = (Fragment) this.f220g.get(i);
                if (f != null) {
                    f.performLowMemory();
                }
            }
        }
    }

    public boolean m304a(Menu menu, MenuInflater inflater) {
        int i;
        Fragment f;
        boolean show = false;
        ArrayList newMenus = null;
        if (this.f220g != null) {
            for (i = 0; i < this.f220g.size(); i++) {
                f = (Fragment) this.f220g.get(i);
                if (f != null && f.performCreateOptionsMenu(menu, inflater)) {
                    show = true;
                    if (newMenus == null) {
                        newMenus = new ArrayList();
                    }
                    newMenus.add(f);
                }
            }
        }
        if (this.f223j != null) {
            for (i = 0; i < this.f223j.size(); i++) {
                f = (Fragment) this.f223j.get(i);
                if (newMenus == null || !newMenus.contains(f)) {
                    f.onDestroyOptionsMenu();
                }
            }
        }
        this.f223j = newMenus;
        return show;
    }

    public boolean m303a(Menu menu) {
        boolean show = false;
        if (this.f220g != null) {
            for (int i = 0; i < this.f220g.size(); i++) {
                Fragment f = (Fragment) this.f220g.get(i);
                if (f != null && f.performPrepareOptionsMenu(menu)) {
                    show = true;
                }
            }
        }
        return show;
    }

    public boolean m305a(MenuItem item) {
        if (this.f220g != null) {
            for (int i = 0; i < this.f220g.size(); i++) {
                Fragment f = (Fragment) this.f220g.get(i);
                if (f != null && f.performOptionsItemSelected(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean m314b(MenuItem item) {
        if (this.f220g != null) {
            for (int i = 0; i < this.f220g.size(); i++) {
                Fragment f = (Fragment) this.f220g.get(i);
                if (f != null && f.performContextItemSelected(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void m312b(Menu menu) {
        if (this.f220g != null) {
            for (int i = 0; i < this.f220g.size(); i++) {
                Fragment f = (Fragment) this.f220g.get(i);
                if (f != null) {
                    f.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public static int m278d(int transit) {
        switch (transit) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public static int m277b(int transit, boolean enter) {
        int animAttr = -1;
        switch (transit) {
            case 4097:
                animAttr = enter ? 1 : 2;
                break;
            case 4099:
                animAttr = enter ? 5 : 6;
                break;
            case 8194:
                animAttr = enter ? 3 : 4;
                break;
        }
        return animAttr;
    }

    public View onCreateView(String name, Context context, AttributeSet attrs) {
        if (!"fragment".equals(name)) {
            return null;
        }
        String fname = attrs.getAttributeValue(null, "class");
        TypedArray a = context.obtainStyledAttributes(attrs, C0081a.f209a);
        if (fname == null) {
            fname = a.getString(0);
        }
        int id = a.getResourceId(1, -1);
        String tag = a.getString(2);
        a.recycle();
        if (!Fragment.isSupportFragmentClass(this.f228o, fname)) {
            return null;
        }
        int containerId;
        View parent = null;
        if (parent != null) {
            containerId = parent.getId();
        } else {
            containerId = 0;
        }
        if (containerId == -1 && id == -1 && tag == null) {
            throw new IllegalArgumentException(attrs.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + fname);
        }
        Fragment fragment;
        if (id != -1) {
            fragment = m281a(id);
        } else {
            fragment = null;
        }
        if (fragment == null && tag != null) {
            fragment = m283a(tag);
        }
        if (fragment == null && containerId != -1) {
            fragment = m281a(containerId);
        }
        if (f213a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(id) + " fname=" + fname + " existing=" + fragment);
        }
        if (fragment == null) {
            int i;
            fragment = Fragment.instantiate(context, fname);
            fragment.mFromLayout = true;
            if (id != 0) {
                i = id;
            } else {
                i = containerId;
            }
            fragment.mFragmentId = i;
            fragment.mContainerId = containerId;
            fragment.mTag = tag;
            fragment.mInLayout = true;
            fragment.mFragmentManager = this;
            fragment.onInflate(this.f228o, attrs, fragment.mSavedFragmentState);
            m296a(fragment, true);
        } else if (fragment.mInLayout) {
            throw new IllegalArgumentException(attrs.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(id) + ", tag " + tag + ", or parent id 0x" + Integer.toHexString(containerId) + " with another fragment for " + fname);
        } else {
            fragment.mInLayout = true;
            if (!fragment.mRetaining) {
                fragment.onInflate(this.f228o, attrs, fragment.mSavedFragmentState);
            }
        }
        if (this.f227n >= 1 || !fragment.mFromLayout) {
            m308b(fragment);
        } else {
            m295a(fragment, 1, 0, 0, false);
        }
        if (fragment.mView == null) {
            throw new IllegalStateException("Fragment " + fname + " did not create a view.");
        }
        if (id != 0) {
            fragment.mView.setId(id);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(tag);
        }
        return fragment.mView;
    }

    Factory m344w() {
        return this;
    }
}
