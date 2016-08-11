package com.anglelabs.alarmclock.redesign.utils;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.p012a.C0329b;
import android.support.v7.p013c.C0342a;
import android.support.v7.p013c.C0342a.C0332a;
import android.util.Pair;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.alarmclock.xtreme.free.R;
import com.avg.toolkit.p049e.C0970a;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.r */
public class C0853r {

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.r.b */
    public interface C0663b extends C0332a {
        void m3017a(C0342a c0342a, int i, long j, boolean z);
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.r.a */
    public static class C0852a implements C0332a, OnItemClickListener, OnItemLongClickListener {
        private final Handler f2440a;
        private C0342a f2441b;
        private ListView f2442c;
        private C0329b f2443d;
        private C0663b f2444e;
        private HashSet f2445f;
        private HashSet f2446g;
        private OnItemClickListener f2447h;
        private int f2448i;
        private boolean f2449j;
        private final Runnable f2450k;

        /* renamed from: com.anglelabs.alarmclock.redesign.utils.r.a.1 */
        class C08511 implements Runnable {
            final /* synthetic */ C0852a f2439a;

            C08511(C0852a c0852a) {
                this.f2439a = c0852a;
            }

            public void run() {
                this.f2439a.f2442c.setChoiceMode(0);
            }
        }

        private C0852a() {
            this.f2440a = new Handler();
            this.f2442c = null;
            this.f2443d = null;
            this.f2444e = null;
            this.f2448i = R.drawable.alarm_item_type_background_selected;
            this.f2450k = new C08511(this);
        }

        public static C0852a m3990a(ListView listView, C0329b activity, C0663b listener) {
            C0852a controller = new C0852a();
            controller.f2442c = listView;
            controller.f2443d = activity;
            controller.f2444e = listener;
            listView.setOnItemLongClickListener(controller);
            return controller;
        }

        private void m3991c(Bundle savedInstanceState) {
            this.f2445f = null;
            if (savedInstanceState != null) {
                long[] checkedIds = savedInstanceState.getLongArray(m3992d());
                if (checkedIds != null && checkedIds.length > 0) {
                    this.f2445f = new HashSet();
                    for (long id : checkedIds) {
                        this.f2445f.add(Long.valueOf(id));
                    }
                }
            }
        }

        public void m3993a() {
            if (this.f2449j) {
                m3999b();
            }
        }

        public void m3995a(Bundle savedInstanceState) {
            m3991c(savedInstanceState);
            m4002c();
        }

        public void m3999b() {
            if (this.f2441b != null) {
                this.f2441b.m1584c();
            }
        }

        public void m3994a(int position, boolean value) {
            this.f2442c.setItemChecked(position, value);
            if (this.f2441b != null) {
                this.f2444e.m3017a(this.f2441b, position, this.f2442c.getAdapter().getItemId(position), value);
            }
        }

        public void m4002c() {
            if (this.f2445f != null && this.f2442c.getAdapter() != null) {
                boolean idsFound = false;
                Adapter adapter = this.f2442c.getAdapter();
                for (int pos = adapter.getCount() - 1; pos >= 0; pos--) {
                    if (this.f2445f.contains(Long.valueOf(adapter.getItemId(pos)))) {
                        idsFound = true;
                        if (this.f2446g == null) {
                            this.f2446g = new HashSet();
                        }
                        this.f2446g.add(new Pair(Integer.valueOf(pos), Long.valueOf(adapter.getItemId(pos))));
                    }
                }
                if (idsFound) {
                    this.f2445f = null;
                    this.f2441b = this.f2443d.m1469a((C0332a) this);
                }
            }
        }

        public boolean m4000b(Bundle outBundle) {
            if (this.f2441b == null || !this.f2442c.getAdapter().hasStableIds()) {
                return false;
            }
            outBundle.putLongArray(m3992d(), this.f2442c.getCheckedItemIds());
            return true;
        }

        private String m3992d() {
            return C0853r.class.getSimpleName() + "_" + this.f2442c.getId();
        }

        public boolean m3997a(C0342a actionMode, Menu menu) {
            this.f2449j = true;
            if (!this.f2444e.m1514a(actionMode, menu)) {
                return false;
            }
            this.f2441b = actionMode;
            this.f2447h = this.f2442c.getOnItemClickListener();
            this.f2442c.setOnItemClickListener(this);
            this.f2442c.setChoiceMode(2);
            this.f2440a.removeCallbacks(this.f2450k);
            if (this.f2446g == null) {
                return true;
            }
            Iterator i$ = this.f2446g.iterator();
            while (i$.hasNext()) {
                Pair posAndId = (Pair) i$.next();
                this.f2442c.setItemChecked(((Integer) posAndId.first).intValue(), true);
                this.f2444e.m3017a(this.f2441b, ((Integer) posAndId.first).intValue(), ((Long) posAndId.second).longValue(), true);
            }
            return true;
        }

        public boolean m4001b(C0342a actionMode, Menu menu) {
            if (!this.f2444e.m1516b(actionMode, menu)) {
                return false;
            }
            this.f2441b = actionMode;
            return true;
        }

        public boolean m3998a(C0342a actionMode, MenuItem menuItem) {
            return this.f2444e.m1515a(actionMode, menuItem);
        }

        public void m3996a(C0342a actionMode) {
            this.f2449j = false;
            this.f2444e.m1513a(actionMode);
            SparseBooleanArray checkedPositions = this.f2442c.getCheckedItemPositions();
            if (checkedPositions != null) {
                for (int i = 0; i < checkedPositions.size(); i++) {
                    View v = this.f2442c.getChildAt(checkedPositions.keyAt(i));
                    if (v != null) {
                        v.setBackgroundResource(R.drawable.alarm_item_type_background);
                    } else {
                        C0970a.m4325b("unable to find view");
                    }
                    this.f2442c.setItemChecked(checkedPositions.keyAt(i), false);
                }
            }
            ((BaseAdapter) this.f2442c.getAdapter()).notifyDataSetChanged();
            this.f2442c.setOnItemClickListener(this.f2447h);
            this.f2441b = null;
            this.f2440a.post(this.f2450k);
        }

        public void onItemClick(AdapterView adapterView, View view, int position, long id) {
            boolean checked = this.f2442c.isItemChecked(position);
            this.f2444e.m3017a(this.f2441b, position, id, checked);
            if (this.f2441b != null) {
                view.setBackgroundResource(checked ? R.drawable.alarm_item_type_background_selected : R.drawable.alarm_item_type_background);
            }
            int numChecked = 0;
            SparseBooleanArray checkedItemPositions = this.f2442c.getCheckedItemPositions();
            if (checkedItemPositions != null) {
                for (int i = 0; i < checkedItemPositions.size(); i++) {
                    numChecked += checkedItemPositions.valueAt(i) ? 1 : 0;
                }
            }
            if (this.f2441b != null && numChecked <= 0) {
                this.f2441b.m1584c();
            }
        }

        public boolean onItemLongClick(AdapterView adapterView, View view, int position, long id) {
            if (this.f2441b != null) {
                return false;
            }
            this.f2446g = new HashSet();
            this.f2446g.add(new Pair(Integer.valueOf(position), Long.valueOf(id)));
            this.f2441b = this.f2443d.m1469a((C0332a) this);
            view.setBackgroundResource(this.f2448i);
            return true;
        }
    }

    public static C0852a m4003a(ListView listView, C0329b activity, C0663b listener) {
        return C0852a.m3990a(listView, activity, listener);
    }
}
