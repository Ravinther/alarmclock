package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.app.C0075i.C0067a;
import android.support.v4.app.C0090m.C0060b;
import android.support.v4.app.C0090m.C0089a;
import android.support.v4.p010d.C0138a;
import android.support.v4.p010d.C0141d;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.google.android.gms.cast.Cast;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: android.support.v4.app.e */
final class C0068e extends C0066l implements C0067a, Runnable {
    final C0082j f158a;
    C0064a f159b;
    C0064a f160c;
    int f161d;
    int f162e;
    int f163f;
    int f164g;
    int f165h;
    int f166i;
    int f167j;
    boolean f168k;
    boolean f169l;
    String f170m;
    boolean f171n;
    int f172o;
    int f173p;
    CharSequence f174q;
    int f175r;
    CharSequence f176s;
    ArrayList f177t;
    ArrayList f178u;

    /* renamed from: android.support.v4.app.e.1 */
    class C00611 implements C0060b {
        final /* synthetic */ Fragment f129a;
        final /* synthetic */ C0068e f130b;

        C00611(C0068e c0068e, Fragment fragment) {
            this.f130b = c0068e;
            this.f129a = fragment;
        }

        public View m180a() {
            return this.f129a.getView();
        }
    }

    /* renamed from: android.support.v4.app.e.2 */
    class C00622 implements OnPreDrawListener {
        final /* synthetic */ View f131a;
        final /* synthetic */ Object f132b;
        final /* synthetic */ ArrayList f133c;
        final /* synthetic */ C0065b f134d;
        final /* synthetic */ boolean f135e;
        final /* synthetic */ Fragment f136f;
        final /* synthetic */ Fragment f137g;
        final /* synthetic */ C0068e f138h;

        C00622(C0068e c0068e, View view, Object obj, ArrayList arrayList, C0065b c0065b, boolean z, Fragment fragment, Fragment fragment2) {
            this.f138h = c0068e;
            this.f131a = view;
            this.f132b = obj;
            this.f133c = arrayList;
            this.f134d = c0065b;
            this.f135e = z;
            this.f136f = fragment;
            this.f137g = fragment2;
        }

        public boolean onPreDraw() {
            this.f131a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.f132b != null) {
                C0090m.m386a(this.f132b, this.f133c);
                this.f133c.clear();
                C0138a namedViews = this.f138h.m197a(this.f134d, this.f135e, this.f136f);
                if (namedViews.isEmpty()) {
                    this.f133c.add(this.f134d.f156d);
                } else {
                    this.f133c.addAll(namedViews.values());
                }
                C0090m.m390b(this.f132b, this.f133c);
                this.f138h.m212a(namedViews, this.f134d);
                this.f138h.m205a(this.f134d, this.f136f, this.f137g, this.f135e, namedViews);
            }
            return true;
        }
    }

    /* renamed from: android.support.v4.app.e.3 */
    class C00633 implements OnPreDrawListener {
        final /* synthetic */ View f139a;
        final /* synthetic */ C0065b f140b;
        final /* synthetic */ int f141c;
        final /* synthetic */ Object f142d;
        final /* synthetic */ C0068e f143e;

        C00633(C0068e c0068e, View view, C0065b c0065b, int i, Object obj) {
            this.f143e = c0068e;
            this.f139a = view;
            this.f140b = c0065b;
            this.f141c = i;
            this.f142d = obj;
        }

        public boolean onPreDraw() {
            this.f139a.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f143e.m204a(this.f140b, this.f141c, this.f142d);
            return true;
        }
    }

    /* renamed from: android.support.v4.app.e.a */
    static final class C0064a {
        C0064a f144a;
        C0064a f145b;
        int f146c;
        Fragment f147d;
        int f148e;
        int f149f;
        int f150g;
        int f151h;
        ArrayList f152i;

        C0064a() {
        }
    }

    /* renamed from: android.support.v4.app.e.b */
    public class C0065b {
        public C0138a f153a;
        public ArrayList f154b;
        public C0089a f155c;
        public View f156d;
        final /* synthetic */ C0068e f157e;

        public C0065b(C0068e c0068e) {
            this.f157e = c0068e;
            this.f153a = new C0138a();
            this.f154b = new ArrayList();
            this.f155c = new C0089a();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Cast.MAX_NAMESPACE_LENGTH);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f172o >= 0) {
            sb.append(" #");
            sb.append(this.f172o);
        }
        if (this.f170m != null) {
            sb.append(" ");
            sb.append(this.f170m);
        }
        sb.append("}");
        return sb.toString();
    }

    public void m233a(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        m234a(prefix, writer, true);
    }

    public void m234a(String prefix, PrintWriter writer, boolean full) {
        if (full) {
            writer.print(prefix);
            writer.print("mName=");
            writer.print(this.f170m);
            writer.print(" mIndex=");
            writer.print(this.f172o);
            writer.print(" mCommitted=");
            writer.println(this.f171n);
            if (this.f166i != 0) {
                writer.print(prefix);
                writer.print("mTransition=#");
                writer.print(Integer.toHexString(this.f166i));
                writer.print(" mTransitionStyle=#");
                writer.println(Integer.toHexString(this.f167j));
            }
            if (!(this.f162e == 0 && this.f163f == 0)) {
                writer.print(prefix);
                writer.print("mEnterAnim=#");
                writer.print(Integer.toHexString(this.f162e));
                writer.print(" mExitAnim=#");
                writer.println(Integer.toHexString(this.f163f));
            }
            if (!(this.f164g == 0 && this.f165h == 0)) {
                writer.print(prefix);
                writer.print("mPopEnterAnim=#");
                writer.print(Integer.toHexString(this.f164g));
                writer.print(" mPopExitAnim=#");
                writer.println(Integer.toHexString(this.f165h));
            }
            if (!(this.f173p == 0 && this.f174q == null)) {
                writer.print(prefix);
                writer.print("mBreadCrumbTitleRes=#");
                writer.print(Integer.toHexString(this.f173p));
                writer.print(" mBreadCrumbTitleText=");
                writer.println(this.f174q);
            }
            if (!(this.f175r == 0 && this.f176s == null)) {
                writer.print(prefix);
                writer.print("mBreadCrumbShortTitleRes=#");
                writer.print(Integer.toHexString(this.f175r));
                writer.print(" mBreadCrumbShortTitleText=");
                writer.println(this.f176s);
            }
        }
        if (this.f159b != null) {
            writer.print(prefix);
            writer.println("Operations:");
            String innerPrefix = prefix + "    ";
            C0064a op = this.f159b;
            int num = 0;
            while (op != null) {
                String cmdStr;
                switch (op.f146c) {
                    case Base64.DEFAULT /*0*/:
                        cmdStr = "NULL";
                        break;
                    case Base64.NO_PADDING /*1*/:
                        cmdStr = "ADD";
                        break;
                    case Base64.NO_WRAP /*2*/:
                        cmdStr = "REPLACE";
                        break;
                    case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        cmdStr = "REMOVE";
                        break;
                    case Base64.CRLF /*4*/:
                        cmdStr = "HIDE";
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        cmdStr = "SHOW";
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        cmdStr = "DETACH";
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                        cmdStr = "ATTACH";
                        break;
                    default:
                        cmdStr = "cmd=" + op.f146c;
                        break;
                }
                writer.print(prefix);
                writer.print("  Op #");
                writer.print(num);
                writer.print(": ");
                writer.print(cmdStr);
                writer.print(" ");
                writer.println(op.f147d);
                if (full) {
                    if (!(op.f148e == 0 && op.f149f == 0)) {
                        writer.print(prefix);
                        writer.print("enterAnim=#");
                        writer.print(Integer.toHexString(op.f148e));
                        writer.print(" exitAnim=#");
                        writer.println(Integer.toHexString(op.f149f));
                    }
                    if (!(op.f150g == 0 && op.f151h == 0)) {
                        writer.print(prefix);
                        writer.print("popEnterAnim=#");
                        writer.print(Integer.toHexString(op.f150g));
                        writer.print(" popExitAnim=#");
                        writer.println(Integer.toHexString(op.f151h));
                    }
                }
                if (op.f152i != null && op.f152i.size() > 0) {
                    for (int i = 0; i < op.f152i.size(); i++) {
                        writer.print(innerPrefix);
                        if (op.f152i.size() == 1) {
                            writer.print("Removed: ");
                        } else {
                            if (i == 0) {
                                writer.println("Removed:");
                            }
                            writer.print(innerPrefix);
                            writer.print("  #");
                            writer.print(i);
                            writer.print(": ");
                        }
                        writer.println(op.f152i.get(i));
                    }
                }
                op = op.f144a;
                num++;
            }
        }
    }

    public C0068e(C0082j manager) {
        this.f169l = true;
        this.f172o = -1;
        this.f158a = manager;
    }

    void m231a(C0064a op) {
        if (this.f159b == null) {
            this.f160c = op;
            this.f159b = op;
        } else {
            op.f145b = this.f160c;
            this.f160c.f144a = op;
            this.f160c = op;
        }
        op.f148e = this.f162e;
        op.f149f = this.f163f;
        op.f150g = this.f164g;
        op.f151h = this.f165h;
        this.f161d++;
    }

    public C0066l m229a(Fragment fragment, String tag) {
        m203a(0, fragment, tag, 1);
        return this;
    }

    public C0066l m227a(int containerViewId, Fragment fragment, String tag) {
        m203a(containerViewId, fragment, tag, 1);
        return this;
    }

    private void m203a(int containerViewId, Fragment fragment, String tag, int opcmd) {
        fragment.mFragmentManager = this.f158a;
        if (tag != null) {
            if (fragment.mTag == null || tag.equals(fragment.mTag)) {
                fragment.mTag = tag;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + tag);
            }
        }
        if (containerViewId != 0) {
            if (fragment.mFragmentId == 0 || fragment.mFragmentId == containerViewId) {
                fragment.mFragmentId = containerViewId;
                fragment.mContainerId = containerViewId;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + containerViewId);
            }
        }
        C0064a op = new C0064a();
        op.f146c = opcmd;
        op.f147d = fragment;
        m231a(op);
    }

    public C0066l m226a(int containerViewId, Fragment fragment) {
        return m236b(containerViewId, fragment, null);
    }

    public C0066l m236b(int containerViewId, Fragment fragment, String tag) {
        if (containerViewId == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m203a(containerViewId, fragment, tag, 2);
        return this;
    }

    public C0066l m228a(Fragment fragment) {
        C0064a op = new C0064a();
        op.f146c = 3;
        op.f147d = fragment;
        m231a(op);
        return this;
    }

    public C0066l m237b(Fragment fragment) {
        C0064a op = new C0064a();
        op.f146c = 6;
        op.f147d = fragment;
        m231a(op);
        return this;
    }

    public C0066l m240c(Fragment fragment) {
        C0064a op = new C0064a();
        op.f146c = 7;
        op.f147d = fragment;
        m231a(op);
        return this;
    }

    public C0066l m225a(int transition) {
        this.f166i = transition;
        return this;
    }

    public C0066l m230a(String name) {
        if (this.f169l) {
            this.f168k = true;
            this.f170m = name;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public C0066l m224a() {
        if (this.f168k) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f169l = false;
        return this;
    }

    void m238b(int amt) {
        if (this.f168k) {
            if (C0082j.f213a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + amt);
            }
            for (C0064a op = this.f159b; op != null; op = op.f144a) {
                if (op.f147d != null) {
                    Fragment fragment = op.f147d;
                    fragment.mBackStackNesting += amt;
                    if (C0082j.f213a) {
                        Log.v("FragmentManager", "Bump nesting of " + op.f147d + " to " + op.f147d.mBackStackNesting);
                    }
                }
                if (op.f152i != null) {
                    for (int i = op.f152i.size() - 1; i >= 0; i--) {
                        Fragment r = (Fragment) op.f152i.get(i);
                        r.mBackStackNesting += amt;
                        if (C0082j.f213a) {
                            Log.v("FragmentManager", "Bump nesting of " + r + " to " + r.mBackStackNesting);
                        }
                    }
                }
            }
        }
    }

    public int m235b() {
        return m222a(false);
    }

    public int m239c() {
        return m222a(true);
    }

    int m222a(boolean allowStateLoss) {
        if (this.f171n) {
            throw new IllegalStateException("commit already called");
        }
        if (C0082j.f213a) {
            Log.v("FragmentManager", "Commit: " + this);
            m233a("  ", null, new PrintWriter(new C0141d("FragmentManager")), null);
        }
        this.f171n = true;
        if (this.f168k) {
            this.f172o = this.f158a.m280a(this);
        } else {
            this.f172o = -1;
        }
        this.f158a.m299a((Runnable) this, allowStateLoss);
        return this.f172o;
    }

    public void run() {
        if (C0082j.f213a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f168k || this.f172o >= 0) {
            m238b(1);
            C0065b state = null;
            if (VERSION.SDK_INT >= 21) {
                SparseArray firstOutFragments = new SparseArray();
                SparseArray lastInFragments = new SparseArray();
                m221b(firstOutFragments, lastInFragments);
                state = m195a(firstOutFragments, lastInFragments, false);
            }
            int transitionStyle = state != null ? 0 : this.f167j;
            int transition = state != null ? 0 : this.f166i;
            C0064a op = this.f159b;
            while (op != null) {
                int enterAnim = state != null ? 0 : op.f148e;
                int exitAnim = state != null ? 0 : op.f149f;
                Fragment f;
                switch (op.f146c) {
                    case Base64.NO_PADDING /*1*/:
                        f = op.f147d;
                        f.mNextAnim = enterAnim;
                        this.f158a.m296a(f, false);
                        break;
                    case Base64.NO_WRAP /*2*/:
                        f = op.f147d;
                        if (this.f158a.f220g != null) {
                            for (int i = 0; i < this.f158a.f220g.size(); i++) {
                                Fragment old = (Fragment) this.f158a.f220g.get(i);
                                if (C0082j.f213a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + f + " old=" + old);
                                }
                                if (f == null || old.mContainerId == f.mContainerId) {
                                    if (old == f) {
                                        f = null;
                                        op.f147d = null;
                                    } else {
                                        if (op.f152i == null) {
                                            op.f152i = new ArrayList();
                                        }
                                        op.f152i.add(old);
                                        old.mNextAnim = exitAnim;
                                        if (this.f168k) {
                                            old.mBackStackNesting++;
                                            if (C0082j.f213a) {
                                                Log.v("FragmentManager", "Bump nesting of " + old + " to " + old.mBackStackNesting);
                                            }
                                        }
                                        this.f158a.m294a(old, transition, transitionStyle);
                                    }
                                }
                            }
                        }
                        if (f == null) {
                            break;
                        }
                        f.mNextAnim = enterAnim;
                        this.f158a.m296a(f, false);
                        break;
                    case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        f = op.f147d;
                        f.mNextAnim = exitAnim;
                        this.f158a.m294a(f, transition, transitionStyle);
                        break;
                    case Base64.CRLF /*4*/:
                        f = op.f147d;
                        f.mNextAnim = exitAnim;
                        this.f158a.m309b(f, transition, transitionStyle);
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        f = op.f147d;
                        f.mNextAnim = enterAnim;
                        this.f158a.m319c(f, transition, transitionStyle);
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        f = op.f147d;
                        f.mNextAnim = exitAnim;
                        this.f158a.m321d(f, transition, transitionStyle);
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                        f = op.f147d;
                        f.mNextAnim = enterAnim;
                        this.f158a.m325e(f, transition, transitionStyle);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + op.f146c);
                }
                op = op.f144a;
            }
            this.f158a.m287a(this.f158a.f227n, transition, transitionStyle, true);
            if (this.f168k) {
                this.f158a.m310b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    private static void m214a(SparseArray fragments, Fragment fragment) {
        if (fragment != null) {
            int containerId = fragment.mContainerId;
            if (containerId != 0 && !fragment.isHidden() && fragment.isAdded() && fragment.getView() != null && fragments.get(containerId) == null) {
                fragments.put(containerId, fragment);
            }
        }
    }

    private void m220b(SparseArray fragments, Fragment fragment) {
        if (fragment != null) {
            int containerId = fragment.mContainerId;
            if (containerId != 0) {
                fragments.put(containerId, fragment);
            }
        }
    }

    private void m221b(SparseArray firstOutFragments, SparseArray lastInFragments) {
        if (this.f158a.f229p.m118a()) {
            for (C0064a op = this.f159b; op != null; op = op.f144a) {
                switch (op.f146c) {
                    case Base64.NO_PADDING /*1*/:
                        m220b(lastInFragments, op.f147d);
                        break;
                    case Base64.NO_WRAP /*2*/:
                        Fragment f = op.f147d;
                        if (this.f158a.f220g != null) {
                            for (int i = 0; i < this.f158a.f220g.size(); i++) {
                                Fragment old = (Fragment) this.f158a.f220g.get(i);
                                if (f == null || old.mContainerId == f.mContainerId) {
                                    if (old == f) {
                                        f = null;
                                    } else {
                                        C0068e.m214a(firstOutFragments, old);
                                    }
                                }
                            }
                        }
                        m220b(lastInFragments, f);
                        break;
                    case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        C0068e.m214a(firstOutFragments, op.f147d);
                        break;
                    case Base64.CRLF /*4*/:
                        C0068e.m214a(firstOutFragments, op.f147d);
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        m220b(lastInFragments, op.f147d);
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        C0068e.m214a(firstOutFragments, op.f147d);
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                        m220b(lastInFragments, op.f147d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void m232a(SparseArray firstOutFragments, SparseArray lastInFragments) {
        if (this.f158a.f229p.m118a()) {
            for (C0064a op = this.f159b; op != null; op = op.f144a) {
                switch (op.f146c) {
                    case Base64.NO_PADDING /*1*/:
                        C0068e.m214a(firstOutFragments, op.f147d);
                        break;
                    case Base64.NO_WRAP /*2*/:
                        if (op.f152i != null) {
                            for (int i = op.f152i.size() - 1; i >= 0; i--) {
                                m220b(lastInFragments, (Fragment) op.f152i.get(i));
                            }
                        }
                        C0068e.m214a(firstOutFragments, op.f147d);
                        break;
                    case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        m220b(lastInFragments, op.f147d);
                        break;
                    case Base64.CRLF /*4*/:
                        m220b(lastInFragments, op.f147d);
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                        C0068e.m214a(firstOutFragments, op.f147d);
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                        m220b(lastInFragments, op.f147d);
                        break;
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                        C0068e.m214a(firstOutFragments, op.f147d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public C0065b m223a(boolean doStateMove, C0065b state, SparseArray firstOutFragments, SparseArray lastInFragments) {
        if (C0082j.f213a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            m233a("  ", null, new PrintWriter(new C0141d("FragmentManager")), null);
        }
        if (state == null) {
            if (!(firstOutFragments.size() == 0 && lastInFragments.size() == 0)) {
                state = m195a(firstOutFragments, lastInFragments, true);
            }
        } else if (!doStateMove) {
            C0068e.m208a(state, this.f178u, this.f177t);
        }
        m238b(-1);
        int transitionStyle = state != null ? 0 : this.f167j;
        int transition = state != null ? 0 : this.f166i;
        C0064a op = this.f160c;
        while (op != null) {
            int popEnterAnim = state != null ? 0 : op.f150g;
            int popExitAnim = state != null ? 0 : op.f151h;
            Fragment f;
            switch (op.f146c) {
                case Base64.NO_PADDING /*1*/:
                    f = op.f147d;
                    f.mNextAnim = popExitAnim;
                    this.f158a.m294a(f, C0082j.m278d(transition), transitionStyle);
                    break;
                case Base64.NO_WRAP /*2*/:
                    f = op.f147d;
                    if (f != null) {
                        f.mNextAnim = popExitAnim;
                        this.f158a.m294a(f, C0082j.m278d(transition), transitionStyle);
                    }
                    if (op.f152i == null) {
                        break;
                    }
                    for (int i = 0; i < op.f152i.size(); i++) {
                        Fragment old = (Fragment) op.f152i.get(i);
                        old.mNextAnim = popEnterAnim;
                        this.f158a.m296a(old, false);
                    }
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    f = op.f147d;
                    f.mNextAnim = popEnterAnim;
                    this.f158a.m296a(f, false);
                    break;
                case Base64.CRLF /*4*/:
                    f = op.f147d;
                    f.mNextAnim = popEnterAnim;
                    this.f158a.m319c(f, C0082j.m278d(transition), transitionStyle);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    f = op.f147d;
                    f.mNextAnim = popExitAnim;
                    this.f158a.m309b(f, C0082j.m278d(transition), transitionStyle);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    f = op.f147d;
                    f.mNextAnim = popEnterAnim;
                    this.f158a.m325e(f, C0082j.m278d(transition), transitionStyle);
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    f = op.f147d;
                    f.mNextAnim = popEnterAnim;
                    this.f158a.m321d(f, C0082j.m278d(transition), transitionStyle);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f146c);
            }
            op = op.f145b;
        }
        if (doStateMove) {
            this.f158a.m287a(this.f158a.f227n, C0082j.m278d(transition), transitionStyle, true);
            state = null;
        }
        if (this.f172o >= 0) {
            this.f158a.m317c(this.f172o);
            this.f172o = -1;
        }
        return state;
    }

    public String m241d() {
        return this.f170m;
    }

    public boolean m242e() {
        return this.f161d == 0;
    }

    private C0065b m195a(SparseArray firstOutFragments, SparseArray lastInFragments, boolean isBack) {
        int i;
        C0065b state = new C0065b(this);
        state.f156d = new View(this.f158a.f228o);
        boolean anyTransitionStarted = false;
        for (i = 0; i < firstOutFragments.size(); i++) {
            if (m216a(firstOutFragments.keyAt(i), state, isBack, firstOutFragments, lastInFragments)) {
                anyTransitionStarted = true;
            }
        }
        for (i = 0; i < lastInFragments.size(); i++) {
            int containerId = lastInFragments.keyAt(i);
            if (firstOutFragments.get(containerId) == null && m216a(containerId, state, isBack, firstOutFragments, lastInFragments)) {
                anyTransitionStarted = true;
            }
        }
        if (anyTransitionStarted) {
            return state;
        }
        return null;
    }

    private static Object m201a(Fragment inFragment, boolean isBack) {
        if (inFragment == null) {
            return null;
        }
        return C0090m.m376a(isBack ? inFragment.getReenterTransition() : inFragment.getEnterTransition());
    }

    private static Object m218b(Fragment outFragment, boolean isBack) {
        if (outFragment == null) {
            return null;
        }
        return C0090m.m376a(isBack ? outFragment.getReturnTransition() : outFragment.getExitTransition());
    }

    private static Object m200a(Fragment inFragment, Fragment outFragment, boolean isBack) {
        if (inFragment == null || outFragment == null) {
            return null;
        }
        return C0090m.m376a(isBack ? outFragment.getSharedElementReturnTransition() : inFragment.getSharedElementEnterTransition());
    }

    private static Object m202a(Object exitTransition, Fragment outFragment, ArrayList exitingViews, C0138a namedViews) {
        if (exitTransition != null) {
            return C0090m.m377a(exitTransition, outFragment.getView(), exitingViews, (Map) namedViews);
        }
        return exitTransition;
    }

    private C0138a m196a(C0065b state, Fragment outFragment, boolean isBack) {
        C0138a namedViews = new C0138a();
        if (this.f177t != null) {
            C0090m.m388a((Map) namedViews, outFragment.getView());
            if (isBack) {
                namedViews.m541a(this.f178u);
            } else {
                namedViews = C0068e.m199a(this.f177t, this.f178u, namedViews);
            }
        }
        if (isBack) {
            if (outFragment.mEnterTransitionCallback != null) {
                outFragment.mEnterTransitionCallback.m167a(this.f178u, namedViews);
            }
            m206a(state, namedViews, false);
        } else {
            if (outFragment.mExitTransitionCallback != null) {
                outFragment.mExitTransitionCallback.m167a(this.f178u, namedViews);
            }
            m219b(state, namedViews, false);
        }
        return namedViews;
    }

    private boolean m216a(int containerId, C0065b state, boolean isBack, SparseArray firstOutFragments, SparseArray lastInFragments) {
        View sceneRoot = (ViewGroup) this.f158a.f229p.m117a(containerId);
        if (sceneRoot == null) {
            return false;
        }
        Fragment inFragment = (Fragment) lastInFragments.get(containerId);
        Fragment outFragment = (Fragment) firstOutFragments.get(containerId);
        Object enterTransition = C0068e.m201a(inFragment, isBack);
        Object sharedElementTransition = C0068e.m200a(inFragment, outFragment, isBack);
        Object exitTransition = C0068e.m218b(outFragment, isBack);
        if (enterTransition == null && sharedElementTransition == null && exitTransition == null) {
            return false;
        }
        C0138a namedViews = null;
        ArrayList sharedElementTargets = new ArrayList();
        if (sharedElementTransition != null) {
            namedViews = m196a(state, outFragment, isBack);
            if (namedViews.isEmpty()) {
                sharedElementTargets.add(state.f156d);
            } else {
                sharedElementTargets.addAll(namedViews.values());
            }
            ah callback = isBack ? outFragment.mEnterTransitionCallback : inFragment.mEnterTransitionCallback;
            if (callback != null) {
                callback.m166a(new ArrayList(namedViews.keySet()), new ArrayList(namedViews.values()), null);
            }
        }
        ArrayList exitingViews = new ArrayList();
        exitTransition = C0068e.m202a(exitTransition, outFragment, exitingViews, namedViews);
        if (!(this.f178u == null || namedViews == null)) {
            View epicenterView = (View) namedViews.get(this.f178u.get(0));
            if (epicenterView != null) {
                if (exitTransition != null) {
                    C0090m.m383a(exitTransition, epicenterView);
                }
                if (sharedElementTransition != null) {
                    C0090m.m383a(sharedElementTransition, epicenterView);
                }
            }
        }
        C0060b viewRetriever = new C00611(this, inFragment);
        if (sharedElementTransition != null) {
            m207a(state, sceneRoot, sharedElementTransition, inFragment, outFragment, isBack, sharedElementTargets);
        }
        ArrayList enteringViews = new ArrayList();
        C0138a renamedViews = new C0138a();
        Object transition = C0090m.m378a(enterTransition, exitTransition, sharedElementTransition, isBack ? inFragment.getAllowReturnTransitionOverlap() : inFragment.getAllowEnterTransitionOverlap());
        if (transition != null) {
            C0090m.m385a(enterTransition, sharedElementTransition, sceneRoot, viewRetriever, state.f156d, state.f155c, state.f153a, enteringViews, renamedViews, sharedElementTargets);
            m215a(sceneRoot, state, containerId, transition);
            C0090m.m384a(transition, state.f156d, true);
            m204a(state, containerId, transition);
            C0090m.m382a((ViewGroup) sceneRoot, transition);
            C0090m.m381a(sceneRoot, state.f156d, enterTransition, enteringViews, exitTransition, exitingViews, sharedElementTransition, sharedElementTargets, transition, state.f154b, renamedViews);
        }
        if (transition != null) {
            return true;
        }
        return false;
    }

    private void m207a(C0065b state, View sceneRoot, Object sharedElementTransition, Fragment inFragment, Fragment outFragment, boolean isBack, ArrayList sharedElementTargets) {
        sceneRoot.getViewTreeObserver().addOnPreDrawListener(new C00622(this, sceneRoot, sharedElementTransition, sharedElementTargets, state, isBack, inFragment, outFragment));
    }

    private void m205a(C0065b state, Fragment inFragment, Fragment outFragment, boolean isBack, C0138a namedViews) {
        ah sharedElementCallback = isBack ? outFragment.mEnterTransitionCallback : inFragment.mEnterTransitionCallback;
        if (sharedElementCallback != null) {
            sharedElementCallback.m168b(new ArrayList(namedViews.keySet()), new ArrayList(namedViews.values()), null);
        }
    }

    private void m212a(C0138a namedViews, C0065b state) {
        if (this.f178u != null && !namedViews.isEmpty()) {
            View epicenter = (View) namedViews.get(this.f178u.get(0));
            if (epicenter != null) {
                state.f155c.f262a = epicenter;
            }
        }
    }

    private C0138a m197a(C0065b state, boolean isBack, Fragment inFragment) {
        C0138a namedViews = m217b(state, inFragment, isBack);
        if (isBack) {
            if (inFragment.mExitTransitionCallback != null) {
                inFragment.mExitTransitionCallback.m167a(this.f178u, namedViews);
            }
            m206a(state, namedViews, true);
        } else {
            if (inFragment.mEnterTransitionCallback != null) {
                inFragment.mEnterTransitionCallback.m167a(this.f178u, namedViews);
            }
            m219b(state, namedViews, true);
        }
        return namedViews;
    }

    private static C0138a m199a(ArrayList inMap, ArrayList toGoInMap, C0138a namedViews) {
        if (namedViews.isEmpty()) {
            return namedViews;
        }
        C0138a remappedViews = new C0138a();
        int numKeys = inMap.size();
        for (int i = 0; i < numKeys; i++) {
            View view = (View) namedViews.get(inMap.get(i));
            if (view != null) {
                remappedViews.put(toGoInMap.get(i), view);
            }
        }
        return remappedViews;
    }

    private C0138a m217b(C0065b state, Fragment inFragment, boolean isBack) {
        C0138a namedViews = new C0138a();
        View root = inFragment.getView();
        if (root == null || this.f177t == null) {
            return namedViews;
        }
        C0090m.m388a((Map) namedViews, root);
        if (isBack) {
            return C0068e.m199a(this.f177t, this.f178u, namedViews);
        }
        namedViews.m541a(this.f178u);
        return namedViews;
    }

    private void m215a(View sceneRoot, C0065b state, int containerId, Object transition) {
        sceneRoot.getViewTreeObserver().addOnPreDrawListener(new C00633(this, sceneRoot, state, containerId, transition));
    }

    private void m204a(C0065b state, int containerId, Object transition) {
        if (this.f158a.f220g != null) {
            for (int i = 0; i < this.f158a.f220g.size(); i++) {
                Fragment fragment = (Fragment) this.f158a.f220g.get(i);
                if (!(fragment.mView == null || fragment.mContainer == null || fragment.mContainerId != containerId)) {
                    if (!fragment.mHidden) {
                        C0090m.m384a(transition, fragment.mView, false);
                        state.f154b.remove(fragment.mView);
                    } else if (!state.f154b.contains(fragment.mView)) {
                        C0090m.m384a(transition, fragment.mView, true);
                        state.f154b.add(fragment.mView);
                    }
                }
            }
        }
    }

    private static void m213a(C0138a overrides, String source, String target) {
        if (source != null && target != null && !source.equals(target)) {
            for (int index = 0; index < overrides.size(); index++) {
                if (source.equals(overrides.m538c(index))) {
                    overrides.m534a(index, (Object) target);
                    return;
                }
            }
            overrides.put(source, target);
        }
    }

    private static void m208a(C0065b state, ArrayList sourceNames, ArrayList targetNames) {
        if (sourceNames != null) {
            for (int i = 0; i < sourceNames.size(); i++) {
                C0068e.m213a(state.f153a, (String) sourceNames.get(i), (String) targetNames.get(i));
            }
        }
    }

    private void m206a(C0065b state, C0138a namedViews, boolean isEnd) {
        int count = this.f178u == null ? 0 : this.f178u.size();
        for (int i = 0; i < count; i++) {
            String source = (String) this.f177t.get(i);
            View view = (View) namedViews.get((String) this.f178u.get(i));
            if (view != null) {
                String target = C0090m.m379a(view);
                if (isEnd) {
                    C0068e.m213a(state.f153a, source, target);
                } else {
                    C0068e.m213a(state.f153a, target, source);
                }
            }
        }
    }

    private void m219b(C0065b state, C0138a namedViews, boolean isEnd) {
        int count = namedViews.size();
        for (int i = 0; i < count; i++) {
            String source = (String) namedViews.m537b(i);
            String target = C0090m.m379a((View) namedViews.m538c(i));
            if (isEnd) {
                C0068e.m213a(state.f153a, source, target);
            } else {
                C0068e.m213a(state.f153a, target, source);
            }
        }
    }
}
