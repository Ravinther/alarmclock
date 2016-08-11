package com.p037b.p038a;

import android.view.animation.Interpolator;
import com.p037b.p038a.C1193a.C0672a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.b.a.c */
public final class C1200c extends C1193a {
    boolean f3635b;
    private ArrayList f3636c;
    private HashMap f3637d;
    private ArrayList f3638e;
    private ArrayList f3639f;
    private boolean f3640g;
    private C1195a f3641h;
    private boolean f3642i;
    private long f3643j;
    private C1210n f3644k;
    private long f3645l;

    /* renamed from: com.b.a.c.1 */
    class C11941 extends C0673b {
        boolean f3617a;
        final /* synthetic */ ArrayList f3618b;
        final /* synthetic */ C1200c f3619c;

        C11941(C1200c c1200c, ArrayList arrayList) {
            this.f3619c = c1200c;
            this.f3618b = arrayList;
            this.f3617a = false;
        }

        public void m5009c(C1193a anim) {
            this.f3617a = true;
        }

        public void m5008a(C1193a anim) {
            if (!this.f3617a) {
                int numNodes = this.f3618b.size();
                for (int i = 0; i < numNodes; i++) {
                    C1199e node = (C1199e) this.f3618b.get(i);
                    node.f3629a.m4999a();
                    this.f3619c.f3636c.add(node.f3629a);
                }
            }
        }
    }

    /* renamed from: com.b.a.c.a */
    private class C1195a implements C0672a {
        final /* synthetic */ C1200c f3620a;
        private C1200c f3621b;

        C1195a(C1200c c1200c, C1200c animatorSet) {
            this.f3620a = c1200c;
            this.f3621b = animatorSet;
        }

        public void m5012c(C1193a animation) {
            if (!this.f3620a.f3635b && this.f3620a.f3636c.size() == 0 && this.f3620a.a != null) {
                int numListeners = this.f3620a.a.size();
                for (int i = 0; i < numListeners; i++) {
                    ((C0672a) this.f3620a.a.get(i)).m3045c(this.f3621b);
                }
            }
        }

        public void m5010a(C1193a animation) {
            animation.m5003b(this);
            this.f3620a.f3636c.remove(animation);
            ((C1199e) this.f3621b.f3637d.get(animation)).f3634f = true;
            if (!this.f3620a.f3635b) {
                int i;
                ArrayList sortedNodes = this.f3621b.f3639f;
                boolean allDone = true;
                int numSortedNodes = sortedNodes.size();
                for (i = 0; i < numSortedNodes; i++) {
                    if (!((C1199e) sortedNodes.get(i)).f3634f) {
                        allDone = false;
                        break;
                    }
                }
                if (allDone) {
                    if (this.f3620a.a != null) {
                        ArrayList tmpListeners = (ArrayList) this.f3620a.a.clone();
                        int numListeners = tmpListeners.size();
                        for (i = 0; i < numListeners; i++) {
                            ((C0672a) tmpListeners.get(i)).m3043a(this.f3621b);
                        }
                    }
                    this.f3621b.f3642i = false;
                }
            }
        }

        public void m5013d(C1193a animation) {
        }

        public void m5011b(C1193a animation) {
        }
    }

    /* renamed from: com.b.a.c.b */
    public class C1196b {
        final /* synthetic */ C1200c f3622a;
        private C1199e f3623b;

        C1196b(C1200c c1200c, C1193a anim) {
            this.f3622a = c1200c;
            this.f3623b = (C1199e) c1200c.f3637d.get(anim);
            if (this.f3623b == null) {
                this.f3623b = new C1199e(anim);
                c1200c.f3637d.put(anim, this.f3623b);
                c1200c.f3638e.add(this.f3623b);
            }
        }

        public C1196b m5014a(C1193a anim) {
            C1199e node = (C1199e) this.f3622a.f3637d.get(anim);
            if (node == null) {
                node = new C1199e(anim);
                this.f3622a.f3637d.put(anim, node);
                this.f3622a.f3638e.add(node);
            }
            node.m5022a(new C1197c(this.f3623b, 0));
            return this;
        }

        public C1196b m5015b(C1193a anim) {
            C1199e node = (C1199e) this.f3622a.f3637d.get(anim);
            if (node == null) {
                node = new C1199e(anim);
                this.f3622a.f3637d.put(anim, node);
                this.f3622a.f3638e.add(node);
            }
            node.m5022a(new C1197c(this.f3623b, 1));
            return this;
        }
    }

    /* renamed from: com.b.a.c.c */
    private static class C1197c {
        public C1199e f3624a;
        public int f3625b;

        public C1197c(C1199e node, int rule) {
            this.f3624a = node;
            this.f3625b = rule;
        }
    }

    /* renamed from: com.b.a.c.d */
    private static class C1198d implements C0672a {
        private C1200c f3626a;
        private C1199e f3627b;
        private int f3628c;

        public C1198d(C1200c animatorSet, C1199e node, int rule) {
            this.f3626a = animatorSet;
            this.f3627b = node;
            this.f3628c = rule;
        }

        public void m5019c(C1193a animation) {
        }

        public void m5017a(C1193a animation) {
            if (this.f3628c == 1) {
                m5016e(animation);
            }
        }

        public void m5020d(C1193a animation) {
        }

        public void m5018b(C1193a animation) {
            if (this.f3628c == 0) {
                m5016e(animation);
            }
        }

        private void m5016e(C1193a dependencyAnimation) {
            if (!this.f3626a.f3635b) {
                C1197c dependencyToRemove = null;
                int numDependencies = this.f3627b.f3631c.size();
                for (int i = 0; i < numDependencies; i++) {
                    C1197c dependency = (C1197c) this.f3627b.f3631c.get(i);
                    if (dependency.f3625b == this.f3628c && dependency.f3624a.f3629a == dependencyAnimation) {
                        dependencyToRemove = dependency;
                        dependencyAnimation.m5003b(this);
                        break;
                    }
                }
                this.f3627b.f3631c.remove(dependencyToRemove);
                if (this.f3627b.f3631c.size() == 0) {
                    this.f3627b.f3629a.m4999a();
                    this.f3626a.f3636c.add(this.f3627b.f3629a);
                }
            }
        }
    }

    /* renamed from: com.b.a.c.e */
    private static class C1199e implements Cloneable {
        public C1193a f3629a;
        public ArrayList f3630b;
        public ArrayList f3631c;
        public ArrayList f3632d;
        public ArrayList f3633e;
        public boolean f3634f;

        public /* synthetic */ Object clone() {
            return m5021a();
        }

        public C1199e(C1193a animation) {
            this.f3630b = null;
            this.f3631c = null;
            this.f3632d = null;
            this.f3633e = null;
            this.f3634f = false;
            this.f3629a = animation;
        }

        public void m5022a(C1197c dependency) {
            if (this.f3630b == null) {
                this.f3630b = new ArrayList();
                this.f3632d = new ArrayList();
            }
            this.f3630b.add(dependency);
            if (!this.f3632d.contains(dependency.f3624a)) {
                this.f3632d.add(dependency.f3624a);
            }
            C1199e dependencyNode = dependency.f3624a;
            if (dependencyNode.f3633e == null) {
                dependencyNode.f3633e = new ArrayList();
            }
            dependencyNode.f3633e.add(this);
        }

        public C1199e m5021a() {
            try {
                C1199e node = (C1199e) super.clone();
                node.f3629a = this.f3629a.m5007f();
                return node;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

    public C1200c() {
        this.f3636c = new ArrayList();
        this.f3637d = new HashMap();
        this.f3638e = new ArrayList();
        this.f3639f = new ArrayList();
        this.f3640g = true;
        this.f3641h = null;
        this.f3635b = false;
        this.f3642i = false;
        this.f3643j = 0;
        this.f3644k = null;
        this.f3645l = -1;
    }

    public /* synthetic */ C1193a m5029a(long x0) {
        return m5035b(x0);
    }

    public /* synthetic */ Object clone() {
        return m5041g();
    }

    public /* synthetic */ C1193a m5040f() {
        return m5041g();
    }

    public void m5034a(C1193a... items) {
        if (items != null) {
            this.f3640g = true;
            C1196b builder = m5030a(items[0]);
            for (int i = 1; i < items.length; i++) {
                builder.m5014a(items[i]);
            }
        }
    }

    public void m5033a(Collection items) {
        if (items != null && items.size() > 0) {
            this.f3640g = true;
            C1196b builder = null;
            for (C1193a anim : items) {
                if (builder == null) {
                    builder = m5030a(anim);
                } else {
                    builder.m5014a(anim);
                }
            }
        }
    }

    public void m5037b(C1193a... items) {
        if (items != null) {
            this.f3640g = true;
            if (items.length == 1) {
                m5030a(items[0]);
                return;
            }
            for (int i = 0; i < items.length - 1; i++) {
                m5030a(items[i]).m5015b(items[i + 1]);
            }
        }
    }

    public void m5032a(Interpolator interpolator) {
        Iterator i$ = this.f3638e.iterator();
        while (i$.hasNext()) {
            ((C1199e) i$.next()).f3629a.m5000a(interpolator);
        }
    }

    public C1196b m5030a(C1193a anim) {
        if (anim == null) {
            return null;
        }
        this.f3640g = true;
        return new C1196b(this, anim);
    }

    public void m5036b() {
        this.f3635b = true;
        if (m5039d()) {
            Iterator i$;
            ArrayList tmpListeners = null;
            if (this.a != null) {
                tmpListeners = (ArrayList) this.a.clone();
                i$ = tmpListeners.iterator();
                while (i$.hasNext()) {
                    ((C0672a) i$.next()).m3045c(this);
                }
            }
            if (this.f3644k != null && this.f3644k.m5108c()) {
                this.f3644k.m5106b();
            } else if (this.f3639f.size() > 0) {
                i$ = this.f3639f.iterator();
                while (i$.hasNext()) {
                    ((C1199e) i$.next()).f3629a.m5002b();
                }
            }
            if (tmpListeners != null) {
                i$ = tmpListeners.iterator();
                while (i$.hasNext()) {
                    ((C0672a) i$.next()).m3043a(this);
                }
            }
            this.f3642i = false;
        }
    }

    public boolean m5038c() {
        Iterator i$ = this.f3638e.iterator();
        while (i$.hasNext()) {
            if (((C1199e) i$.next()).f3629a.m5004c()) {
                return true;
            }
        }
        return false;
    }

    public boolean m5039d() {
        return this.f3642i;
    }

    public C1200c m5035b(long duration) {
        if (duration < 0) {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        }
        Iterator i$ = this.f3638e.iterator();
        while (i$.hasNext()) {
            ((C1199e) i$.next()).f3629a.m4998a(duration);
        }
        this.f3645l = duration;
        return this;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m5031a() {
        /*
        r22 = this;
        r17 = 0;
        r0 = r17;
        r1 = r22;
        r1.f3635b = r0;
        r17 = 1;
        r0 = r17;
        r1 = r22;
        r1.f3642i = r0;
        r22.m5028h();
        r0 = r22;
        r0 = r0.f3639f;
        r17 = r0;
        r14 = r17.size();
        r6 = 0;
    L_0x001e:
        if (r6 >= r14) goto L_0x006c;
    L_0x0020:
        r0 = r22;
        r0 = r0.f3639f;
        r17 = r0;
        r0 = r17;
        r10 = r0.get(r6);
        r10 = (com.p037b.p038a.C1200c.C1199e) r10;
        r0 = r10.f3629a;
        r17 = r0;
        r15 = r17.m5006e();
        if (r15 == 0) goto L_0x0069;
    L_0x0038:
        r17 = r15.size();
        if (r17 <= 0) goto L_0x0069;
    L_0x003e:
        r4 = new java.util.ArrayList;
        r4.<init>(r15);
        r7 = r4.iterator();
    L_0x0047:
        r17 = r7.hasNext();
        if (r17 == 0) goto L_0x0069;
    L_0x004d:
        r9 = r7.next();
        r9 = (com.p037b.p038a.C1193a.C0672a) r9;
        r0 = r9 instanceof com.p037b.p038a.C1200c.C1198d;
        r17 = r0;
        if (r17 != 0) goto L_0x005f;
    L_0x0059:
        r0 = r9 instanceof com.p037b.p038a.C1200c.C1195a;
        r17 = r0;
        if (r17 == 0) goto L_0x0047;
    L_0x005f:
        r0 = r10.f3629a;
        r17 = r0;
        r0 = r17;
        r0.m5003b(r9);
        goto L_0x0047;
    L_0x0069:
        r6 = r6 + 1;
        goto L_0x001e;
    L_0x006c:
        r11 = new java.util.ArrayList;
        r11.<init>();
        r6 = 0;
    L_0x0072:
        if (r6 >= r14) goto L_0x0103;
    L_0x0074:
        r0 = r22;
        r0 = r0.f3639f;
        r17 = r0;
        r0 = r17;
        r10 = r0.get(r6);
        r10 = (com.p037b.p038a.C1200c.C1199e) r10;
        r0 = r22;
        r0 = r0.f3641h;
        r17 = r0;
        if (r17 != 0) goto L_0x009b;
    L_0x008a:
        r17 = new com.b.a.c$a;
        r0 = r17;
        r1 = r22;
        r2 = r22;
        r0.<init>(r1, r2);
        r0 = r17;
        r1 = r22;
        r1.f3641h = r0;
    L_0x009b:
        r0 = r10.f3630b;
        r17 = r0;
        if (r17 == 0) goto L_0x00ab;
    L_0x00a1:
        r0 = r10.f3630b;
        r17 = r0;
        r17 = r17.size();
        if (r17 != 0) goto L_0x00be;
    L_0x00ab:
        r11.add(r10);
    L_0x00ae:
        r0 = r10.f3629a;
        r17 = r0;
        r0 = r22;
        r0 = r0.f3641h;
        r18 = r0;
        r17.m5001a(r18);
        r6 = r6 + 1;
        goto L_0x0072;
    L_0x00be:
        r0 = r10.f3630b;
        r17 = r0;
        r12 = r17.size();
        r8 = 0;
    L_0x00c7:
        if (r8 >= r12) goto L_0x00f4;
    L_0x00c9:
        r0 = r10.f3630b;
        r17 = r0;
        r0 = r17;
        r5 = r0.get(r8);
        r5 = (com.p037b.p038a.C1200c.C1197c) r5;
        r0 = r5.f3624a;
        r17 = r0;
        r0 = r17;
        r0 = r0.f3629a;
        r17 = r0;
        r18 = new com.b.a.c$d;
        r0 = r5.f3625b;
        r19 = r0;
        r0 = r18;
        r1 = r22;
        r2 = r19;
        r0.<init>(r1, r10, r2);
        r17.m5001a(r18);
        r8 = r8 + 1;
        goto L_0x00c7;
    L_0x00f4:
        r0 = r10.f3630b;
        r17 = r0;
        r17 = r17.clone();
        r17 = (java.util.ArrayList) r17;
        r0 = r17;
        r10.f3631c = r0;
        goto L_0x00ae;
    L_0x0103:
        r0 = r22;
        r0 = r0.f3643j;
        r18 = r0;
        r20 = 0;
        r17 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1));
        if (r17 > 0) goto L_0x0134;
    L_0x010f:
        r7 = r11.iterator();
    L_0x0113:
        r17 = r7.hasNext();
        if (r17 == 0) goto L_0x0173;
    L_0x0119:
        r10 = r7.next();
        r10 = (com.p037b.p038a.C1200c.C1199e) r10;
        r0 = r10.f3629a;
        r17 = r0;
        r17.m4999a();
        r0 = r22;
        r0 = r0.f3636c;
        r17 = r0;
        r0 = r10.f3629a;
        r18 = r0;
        r17.add(r18);
        goto L_0x0113;
    L_0x0134:
        r17 = 2;
        r0 = r17;
        r0 = new float[r0];
        r17 = r0;
        r17 = {0, 1065353216};
        r17 = com.p037b.p038a.C1210n.m5085b(r17);
        r0 = r17;
        r1 = r22;
        r1.f3644k = r0;
        r0 = r22;
        r0 = r0.f3644k;
        r17 = r0;
        r0 = r22;
        r0 = r0.f3643j;
        r18 = r0;
        r17.m5107c(r18);
        r0 = r22;
        r0 = r0.f3644k;
        r17 = r0;
        r18 = new com.b.a.c$1;
        r0 = r18;
        r1 = r22;
        r0.<init>(r1, r11);
        r17.m5001a(r18);
        r0 = r22;
        r0 = r0.f3644k;
        r17 = r0;
        r17.m5099a();
    L_0x0173:
        r0 = r22;
        r0 = r0.a;
        r17 = r0;
        if (r17 == 0) goto L_0x01a0;
    L_0x017b:
        r0 = r22;
        r0 = r0.a;
        r17 = r0;
        r16 = r17.clone();
        r16 = (java.util.ArrayList) r16;
        r13 = r16.size();
        r6 = 0;
    L_0x018c:
        if (r6 >= r13) goto L_0x01a0;
    L_0x018e:
        r0 = r16;
        r17 = r0.get(r6);
        r17 = (com.p037b.p038a.C1193a.C0672a) r17;
        r0 = r17;
        r1 = r22;
        r0.m3044b(r1);
        r6 = r6 + 1;
        goto L_0x018c;
    L_0x01a0:
        r0 = r22;
        r0 = r0.f3638e;
        r17 = r0;
        r17 = r17.size();
        if (r17 != 0) goto L_0x01ed;
    L_0x01ac:
        r0 = r22;
        r0 = r0.f3643j;
        r18 = r0;
        r20 = 0;
        r17 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1));
        if (r17 != 0) goto L_0x01ed;
    L_0x01b8:
        r17 = 0;
        r0 = r17;
        r1 = r22;
        r1.f3642i = r0;
        r0 = r22;
        r0 = r0.a;
        r17 = r0;
        if (r17 == 0) goto L_0x01ed;
    L_0x01c8:
        r0 = r22;
        r0 = r0.a;
        r17 = r0;
        r16 = r17.clone();
        r16 = (java.util.ArrayList) r16;
        r13 = r16.size();
        r6 = 0;
    L_0x01d9:
        if (r6 >= r13) goto L_0x01ed;
    L_0x01db:
        r0 = r16;
        r17 = r0.get(r6);
        r17 = (com.p037b.p038a.C1193a.C0672a) r17;
        r0 = r17;
        r1 = r22;
        r0.m3043a(r1);
        r6 = r6 + 1;
        goto L_0x01d9;
    L_0x01ed:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.c.a():void");
    }

    public C1200c m5041g() {
        Iterator i$;
        C1200c anim = (C1200c) super.m5007f();
        anim.f3640g = true;
        anim.f3635b = false;
        anim.f3642i = false;
        anim.f3636c = new ArrayList();
        anim.f3637d = new HashMap();
        anim.f3638e = new ArrayList();
        anim.f3639f = new ArrayList();
        HashMap nodeCloneMap = new HashMap();
        Iterator it = this.f3638e.iterator();
        while (it.hasNext()) {
            C1199e node = (C1199e) it.next();
            C1199e nodeClone = node.m5021a();
            nodeCloneMap.put(node, nodeClone);
            anim.f3638e.add(nodeClone);
            anim.f3637d.put(nodeClone.f3629a, nodeClone);
            nodeClone.f3630b = null;
            nodeClone.f3631c = null;
            nodeClone.f3633e = null;
            nodeClone.f3632d = null;
            ArrayList cloneListeners = nodeClone.f3629a.m5006e();
            if (cloneListeners != null) {
                ArrayList listenersToRemove = null;
                i$ = cloneListeners.iterator();
                while (i$.hasNext()) {
                    C0672a listener = (C0672a) i$.next();
                    if (listener instanceof C1195a) {
                        if (listenersToRemove == null) {
                            listenersToRemove = new ArrayList();
                        }
                        listenersToRemove.add(listener);
                    }
                }
                if (listenersToRemove != null) {
                    i$ = listenersToRemove.iterator();
                    while (i$.hasNext()) {
                        cloneListeners.remove((C0672a) i$.next());
                    }
                }
            }
        }
        it = this.f3638e.iterator();
        while (it.hasNext()) {
            node = (C1199e) it.next();
            nodeClone = (C1199e) nodeCloneMap.get(node);
            if (node.f3630b != null) {
                i$ = node.f3630b.iterator();
                while (i$.hasNext()) {
                    C1197c dependency = (C1197c) i$.next();
                    nodeClone.m5022a(new C1197c((C1199e) nodeCloneMap.get(dependency.f3624a), dependency.f3625b));
                }
            }
        }
        return anim;
    }

    private void m5028h() {
        int numNodes;
        int i;
        C1199e node;
        int j;
        if (this.f3640g) {
            this.f3639f.clear();
            ArrayList roots = new ArrayList();
            numNodes = this.f3638e.size();
            for (i = 0; i < numNodes; i++) {
                node = (C1199e) this.f3638e.get(i);
                if (node.f3630b == null || node.f3630b.size() == 0) {
                    roots.add(node);
                }
            }
            ArrayList tmpRoots = new ArrayList();
            while (roots.size() > 0) {
                int numRoots = roots.size();
                for (i = 0; i < numRoots; i++) {
                    C1199e root = (C1199e) roots.get(i);
                    this.f3639f.add(root);
                    if (root.f3633e != null) {
                        int numDependents = root.f3633e.size();
                        for (j = 0; j < numDependents; j++) {
                            node = (C1199e) root.f3633e.get(j);
                            node.f3632d.remove(root);
                            if (node.f3632d.size() == 0) {
                                tmpRoots.add(node);
                            }
                        }
                    }
                }
                roots.clear();
                roots.addAll(tmpRoots);
                tmpRoots.clear();
            }
            this.f3640g = false;
            if (this.f3639f.size() != this.f3638e.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        numNodes = this.f3638e.size();
        for (i = 0; i < numNodes; i++) {
            node = (C1199e) this.f3638e.get(i);
            if (node.f3630b != null && node.f3630b.size() > 0) {
                int numDependencies = node.f3630b.size();
                for (j = 0; j < numDependencies; j++) {
                    C1197c dependency = (C1197c) node.f3630b.get(j);
                    if (node.f3632d == null) {
                        node.f3632d = new ArrayList();
                    }
                    if (!node.f3632d.contains(dependency.f3624a)) {
                        node.f3632d.add(dependency.f3624a);
                    }
                }
            }
            node.f3634f = false;
        }
    }
}
