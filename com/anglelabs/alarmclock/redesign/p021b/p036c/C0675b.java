package com.anglelabs.alarmclock.redesign.p021b.p036c;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.p012a.C0329b;
import android.support.v7.p013c.C0342a;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.p021b.p022b.C0518a;
import com.anglelabs.alarmclock.redesign.utils.C0807e;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0845o;
import com.anglelabs.alarmclock.redesign.utils.C0845o.C0668b;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.utils.C0853r;
import com.anglelabs.alarmclock.redesign.utils.C0853r.C0663b;
import com.anglelabs.alarmclock.redesign.utils.C0853r.C0852a;
import com.anglelabs.alarmclock.redesign.utils.C0868y;
import com.anglelabs.alarmclock.redesign.utils.C0868y.C0670a;
import com.anglelabs.alarmclock.redesign.views.C0897c;
import com.avg.toolkit.p049e.C0970a;
import com.p037b.p038a.C0673b;
import com.p037b.p038a.C1193a;
import com.p037b.p038a.C1200c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.anglelabs.alarmclock.redesign.b.c.b */
public abstract class C0675b extends C0662a {
    protected C0845o f1748a;
    protected C0852a f1749b;
    private C0868y f1750c;
    private final SparseArray f1751d;
    private boolean f1752e;
    private boolean f1753f;
    private C0897c f1754g;
    private final Handler f1755h;
    private boolean f1756i;
    private final C0663b f1757j;
    private final Runnable f1758k;
    private final Runnable f1759l;

    /* renamed from: com.anglelabs.alarmclock.redesign.b.c.b.1 */
    class C06641 implements C0663b {
        final /* synthetic */ C0675b f1739a;

        C06641(C0675b c0675b) {
            this.f1739a = c0675b;
        }

        public boolean m3022b(C0342a arg0, Menu menu) {
            boolean z = true;
            MenuItem editItem = menu.findItem(R.id.multi_selection_edit);
            if (this.f1739a.m3086r().isEmpty()) {
                if (this.f1739a.f1749b != null) {
                    this.f1739a.f1749b.m3993a();
                }
            } else if (this.f1739a.m3078j()) {
                if (this.f1739a.m3086r().size() != 1) {
                    z = false;
                }
                editItem.setVisible(z);
            } else {
                editItem.setVisible(false);
            }
            return false;
        }

        public void m3018a(C0342a arg0) {
            this.f1739a.m3080l().setOnTouchListener(this.f1739a.f1750c);
            this.f1739a.m3080l().setOnScrollListener(this.f1739a.f1750c.m4055a());
            this.f1739a.f1756i = false;
            this.f1739a.m3083o();
        }

        public boolean m3020a(C0342a actionMode, Menu menu) {
            actionMode.m1581a().inflate(R.menu.redesign_view_alarms_multi_selection_menu, menu);
            this.f1739a.m3080l().setOnTouchListener(null);
            this.f1739a.m3080l().setOnScrollListener(null);
            this.f1739a.m3074f();
            this.f1739a.f1756i = true;
            this.f1739a.m3083o();
            return true;
        }

        public boolean m3021a(C0342a mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.multi_selection_delete:
                    this.f1739a.m3090v();
                    this.f1739a.f1753f = true;
                    break;
                default:
                    this.f1739a.m3065a(mode, item);
                    break;
            }
            mode.m1584c();
            return true;
        }

        public void m3019a(C0342a mode, int position, long id, boolean checked) {
            mode.m1582a(String.format("%s items selected", new Object[]{Integer.valueOf(this.f1739a.m3086r().size())}));
            mode.m1585d();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.b.c.b.2 */
    class C06652 implements Runnable {
        final /* synthetic */ C0675b f1740a;

        C06652(C0675b c0675b) {
            this.f1740a = c0675b;
        }

        public void run() {
            if (this.f1740a.f1754g == null) {
                C0850q.m3987b("popup is null, avoid NPE");
            } else {
                this.f1740a.f1754g.m4142a();
            }
            if (this.f1740a.f1753f) {
                this.f1740a.m3079k();
                this.f1740a.f1753f = false;
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.b.c.b.3 */
    class C06663 implements Runnable {
        final /* synthetic */ C0675b f1741a;

        C06663(C0675b c0675b) {
            this.f1741a = c0675b;
        }

        public void run() {
            int position = this.f1741a.f1751d.keyAt(0);
            Object obj = this.f1741a.f1751d.get(position);
            if (obj == null) {
                C0970a.m4325b("unable to find item in undo list, aborting undo");
                return;
            }
            int listSize = this.f1741a.m3082n().getCount();
            int positionToRemove = position;
            if (positionToRemove > listSize) {
                positionToRemove = listSize;
            }
            this.f1741a.f1748a.m3971a(obj, positionToRemove);
            this.f1741a.m3070c(positionToRemove);
            this.f1741a.f1751d.remove(position);
            if (this.f1741a.f1751d.size() > 0) {
                this.f1741a.f1755h.postDelayed(this.f1741a.f1759l, 300);
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.b.c.b.4 */
    class C06674 implements OnClickListener {
        final /* synthetic */ C0675b f1742a;

        C06674(C0675b c0675b) {
            this.f1742a = c0675b;
        }

        public void onClick(View v) {
            this.f1742a.f1755h.postDelayed(this.f1742a.f1759l, 300);
            if (this.f1742a.f1754g != null) {
                this.f1742a.f1754g.m4142a();
            }
            this.f1742a.f1753f = false;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.b.c.b.5 */
    class C06695 implements C0668b {
        final /* synthetic */ C0675b f1743a;

        C06695(C0675b c0675b) {
            this.f1743a = c0675b;
        }

        public void m3028a() {
            this.f1743a.m3087s();
        }

        public void m3029a(int position) {
            this.f1743a.m3068b(position);
            this.f1743a.f1753f = true;
            this.f1743a.m3082n().notifyDataSetChanged();
        }

        public void m3031a(boolean isEnabled) {
        }

        public long m3032b(int position) {
            return this.f1743a.m3082n().m2466a(position);
        }

        public void m3030a(int pos, Object itemToAdd) {
            this.f1743a.m3054a(pos, itemToAdd);
            this.f1743a.m3082n().m2469f();
            this.f1743a.m3082n().notifyDataSetChanged();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.b.c.b.6 */
    class C06716 implements C0670a {
        final /* synthetic */ ListView f1744a;
        final /* synthetic */ C0675b f1745b;

        C06716(C0675b c0675b, ListView listView) {
            this.f1745b = c0675b;
            this.f1744a = listView;
        }

        public void m3039a(View viewToRemove, int position) {
            this.f1745b.f1748a.m3970a(viewToRemove, position);
        }

        public void m3038a(int position) {
            if (this.f1744a != null) {
                this.f1745b.m3069b(this.f1744a.getAdapter().getItem(position));
            }
        }

        public boolean m3041b(int position) {
            if (this.f1744a == null) {
                return false;
            }
            if (this.f1745b.m3067a(this.f1744a.getAdapter().getItem(position))) {
                return false;
            }
            return true;
        }

        public boolean m3042c(int position) {
            return (this.f1745b.f1748a == null || this.f1745b.f1748a.m3972a()) ? false : true;
        }

        public void m3040a(boolean isAnimating) {
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.b.c.b.7 */
    class C06747 extends C0673b {
        final /* synthetic */ ArrayList f1746a;
        final /* synthetic */ C0675b f1747b;

        C06747(C0675b c0675b, ArrayList arrayList) {
            this.f1747b = c0675b;
            this.f1746a = arrayList;
        }

        public void m3051a(C1193a animation) {
            super.m3049c(animation);
            this.f1747b.m3082n().m2462c(this.f1746a);
            this.f1747b.m3082n().notifyDataSetChanged();
            this.f1747b.m3087s();
            this.f1747b.m3089u();
        }
    }

    public abstract View m3064a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public abstract void m3070c(int i);

    public abstract void m3071c(Object obj);

    public abstract boolean m3078j();

    public abstract void m3079k();

    public abstract ListView m3080l();

    public abstract C0329b m3081m();

    public abstract C0518a m3082n();

    public abstract void m3083o();

    public abstract void m3089u();

    public C0675b() {
        this.f1751d = new SparseArray();
        this.f1755h = new Handler();
        this.f1757j = new C06641(this);
        this.f1758k = new C06652(this);
        this.f1759l = new C06663(this);
    }

    protected boolean m3073e() {
        return this.f1756i;
    }

    protected void m3074f() {
    }

    void m3075g() {
        if (this.f1749b != null) {
            this.f1749b.m3993a();
        }
    }

    public String m3076h() {
        return "";
    }

    public void m3068b(int position) {
        this.f1751d.clear();
        C0518a adapter = m3082n();
        Object item = adapter.getItem(position);
        adapter.m2460b(item);
        this.f1751d.put(position, item);
        adapter.notifyDataSetChanged();
    }

    private void m3054a(int pos, Object itemToAdd) {
        m3082n().m2458a(itemToAdd, pos);
    }

    protected final SparseArray m3077i() {
        return this.f1751d;
    }

    protected void m3065a(C0342a mode, MenuItem item) {
    }

    public void m3084p() {
    }

    protected boolean m3085q() {
        return true;
    }

    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = m3064a(inflater, container, savedInstanceState);
        m3053a();
        m3066a(m3080l());
        if (m3085q()) {
            this.f1749b = C0853r.m4003a(m3080l(), m3081m(), this.f1757j);
            this.f1749b.m3995a(savedInstanceState);
            m3082n().m2467a(this.f1749b);
            m3082n().m2459b(savedInstanceState);
        }
        return v;
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.f1749b != null) {
            this.f1749b.m4000b(outState);
        }
        if (m3082n() != null) {
            m3082n().m2456a(outState);
        }
        super.onSaveInstanceState(outState);
    }

    private void m3053a() {
        this.f1754g = new C0897c(getActivity(), (int) getActivity().getResources().getDimension(R.dimen.undoOffset), 0);
    }

    public void onResume() {
        super.onResume();
        this.f1752e = true;
        this.f1754g.m4144a(new C06674(this));
        m3063w();
    }

    public void onPause() {
        this.f1752e = false;
        try {
            this.f1755h.removeCallbacks(this.f1759l);
            if (this.f1754g != null) {
                this.f1754g.m4142a();
            }
            if (this.f1753f) {
                m3079k();
                this.f1753f = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onPause();
    }

    public void onDestroy() {
        if (this.f1754g != null && this.f1754g.m4146b()) {
            this.f1754g.m4142a();
            m3079k();
        }
        this.f1754g = null;
        super.onDestroy();
    }

    protected final List m3086r() {
        List checkedSessionPositions = new ArrayList();
        if (m3080l() != null) {
            SparseBooleanArray checkedPositionsBool = m3080l().getCheckedItemPositions();
            if (checkedPositionsBool != null) {
                for (int i = 0; i < checkedPositionsBool.size(); i++) {
                    if (checkedPositionsBool.valueAt(i)) {
                        checkedSessionPositions.add(Integer.valueOf(checkedPositionsBool.keyAt(i)));
                    }
                }
            }
        }
        return checkedSessionPositions;
    }

    private void m3063w() {
        this.f1748a = new C0845o(m3080l(), new C06695(this));
    }

    protected void m3087s() {
        if (this.f1752e) {
            try {
                this.f1754g.m4145a(m3080l(), m3076h());
                this.f1755h.removeCallbacks(this.f1758k);
                this.f1755h.postDelayed(this.f1758k, 5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void m3066a(ListView listView) {
        this.f1750c = new C0868y(listView, new C06716(this, listView));
        m3080l().setOnTouchListener(this.f1750c);
        m3080l().setOnScrollListener(this.f1750c.m4055a());
    }

    protected void m3072d() {
        super.m3016d();
        m3075g();
    }

    public boolean m3067a(Object item) {
        return false;
    }

    public void m3088t() {
    }

    public void m3069b(Object item) {
    }

    public void m3090v() {
        List<Integer> checkedItems = m3086r();
        ArrayList itemToDelete = new ArrayList(checkedItems.size());
        boolean triedToDeleteInvalidItem = false;
        C1200c deleteAnimationSet = new C1200c();
        Collection deleteAnimationList = new ArrayList();
        int firstVisiblePosition = m3080l().getFirstVisiblePosition();
        for (Integer intValue : checkedItems) {
            int positionToDelete = intValue.intValue();
            Object item = m3082n().getItem(positionToDelete);
            if (item == null) {
                C0970a.m4325b("unable to find item at index " + positionToDelete);
            } else if (m3067a(item)) {
                triedToDeleteInvalidItem = true;
            } else {
                itemToDelete.add(item);
                View view = m3080l().getChildAt(positionToDelete - firstVisiblePosition);
                if (view != null) {
                    deleteAnimationList.add(C0807e.m3815b(view));
                }
                m3077i().put(positionToDelete, item);
                m3071c(item);
            }
        }
        if (triedToDeleteInvalidItem) {
            m3088t();
        }
        if (!deleteAnimationList.isEmpty()) {
            if (C0810h.f2129c) {
                long animationTime = (long) m3080l().getContext().getResources().getInteger(17694721);
                deleteAnimationSet.m5033a(deleteAnimationList);
                deleteAnimationSet.m5035b(animationTime).m5001a(new C06747(this, itemToDelete));
                deleteAnimationSet.m5031a();
                return;
            }
            m3082n().m2462c(itemToDelete);
            m3082n().notifyDataSetChanged();
            m3087s();
            m3089u();
        }
    }
}
