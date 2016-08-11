package com.anglelabs.alarmclock.redesign.p026e.p041b;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.p012a.C0329b;
import android.support.v7.widget.SearchView.C0479c;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.p021b.p022b.C0518a.C0519a;
import com.anglelabs.alarmclock.redesign.p021b.p025a.C0564a;
import com.anglelabs.alarmclock.redesign.p021b.p036c.C0675b;
import com.anglelabs.alarmclock.redesign.p026e.p027a.C0704c.C0703a;
import com.anglelabs.alarmclock.redesign.utils.C0790a;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.utils.C0854s;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.avg.toolkit.p049e.C0970a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/* renamed from: com.anglelabs.alarmclock.redesign.e.b.a */
public abstract class C0710a extends C0675b implements C0479c, OnItemClickListener, C0703a {
    public ListView f1821c;
    SharedPreferences f1822d;
    private ProgressBar f1823e;
    private boolean f1824f;
    private boolean f1825g;
    private MediaPlayer f1826h;
    private String f1827i;
    private ArrayList f1828j;

    /* renamed from: com.anglelabs.alarmclock.redesign.e.b.a.1 */
    class C07081 implements OnPreparedListener {
        final /* synthetic */ C0710a f1819a;

        C07081(C0710a c0710a) {
            this.f1819a = c0710a;
        }

        public void onPrepared(MediaPlayer mp) {
            try {
                this.f1819a.f1826h.seekTo(0);
                this.f1819a.f1826h.start();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.b.a.2 */
    class C07092 implements OnCompletionListener {
        final /* synthetic */ C0710a f1820a;

        C07092(C0710a c0710a) {
            this.f1820a = c0710a;
        }

        public void onCompletion(MediaPlayer mp) {
            this.f1820a.f1827i = null;
        }
    }

    abstract String m3182A();

    abstract void m3189a(View view);

    abstract CharSequence m3201w();

    abstract CharSequence m3202x();

    abstract CharSequence m3203y();

    abstract String m3204z();

    public C0710a() {
        this.f1824f = true;
        this.f1825g = true;
    }

    public boolean a_(String arg0) {
        return false;
    }

    protected void m3183B() {
        if (this.f1828j != null && this.f1828j.size() > 0) {
            ((C0519a) m3082n()).m2470a(this.f1828j);
        }
    }

    public void m3193b(int position) {
        m3079k();
        super.m3068b(position);
    }

    protected final void m3184C() {
        this.f1824f = false;
        if (getView() != null) {
            getView().findViewById(R.id.footer).setVisibility(8);
        }
    }

    protected final void m3185D() {
        this.f1825g = false;
        getActivity().m256e();
    }

    protected final void m3186E() {
        this.f1824f = true;
        if (getView() != null) {
            getView().findViewById(R.id.footer).setVisibility(0);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.f1821c == null) {
            C0970a.m4325b("listview is null, aborting!");
            return;
        }
        if (m3082n() instanceof C0519a) {
            ArrayList checkedPositions = ((C0519a) m3082n()).m2471d();
            if (checkedPositions != null && checkedPositions.size() > 0) {
                outState.putIntegerArrayList("multi_selected_position", checkedPositions);
            }
        }
        super.onSaveInstanceState(outState);
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null && (m3082n() instanceof C0519a)) {
            this.f1828j = savedInstanceState.getIntegerArrayList("multi_selected_position");
        }
    }

    public View m3188a(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f1822d = ac.m3774b(getActivity());
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.redesign_fragment_choose_sound_type, container, false);
        this.f1821c = (ListView) view.findViewById(R.id.list);
        ((TextView) view.findViewById(16908292)).setText(m3182A());
        ((TextView) view.findViewById(R.id.footer_textview)).setText(m3203y());
        m3181a();
        View footer = view.findViewById(R.id.footer);
        footer.setVisibility(this.f1824f ? 0 : 8);
        if (this.f1824f) {
            m3189a(footer);
        }
        this.f1823e = (ProgressBar) view.findViewById(R.id.progress);
        return view;
    }

    protected void m3190a(boolean isVisible) {
        if (isVisible) {
            this.f1823e.setVisibility(0);
        } else {
            this.f1823e.setVisibility(8);
        }
    }

    protected void m3191a(long[] idsToIgnore) {
        if (C0854s.m4008a(getActivity(), m3204z(), idsToIgnore)) {
            getActivity().m256e();
        }
    }

    private void m3181a() {
        this.f1821c.setAdapter(m3082n());
        this.f1821c.setItemsCanFocus(true);
        m3084p();
        this.f1821c.setOnItemClickListener(this);
    }

    public ListView m3197l() {
        return this.f1821c;
    }

    public void onPause() {
        m3187F();
        super.onPause();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof C0564a) {
            ((C0564a) getActivity()).m2573n().m3751a(m3201w(), m3202x());
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        if (getActivity() != null) {
            if (this.f1825g) {
                C0790a.m3745a(getActivity(), menu, (C0479c) this);
            }
            String deletedIds = this.f1822d.getString(m3204z(), "");
            HashSet uniqueIds = new HashSet(Arrays.asList(deletedIds.split(",")));
            if (!TextUtils.isEmpty(deletedIds)) {
                C0790a.m3747a(getActivity(), menu, uniqueIds.size());
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public C0329b m3198m() {
        return (C0329b) getActivity();
    }

    private MediaPlayer m3178G() {
        if (this.f1826h == null) {
            this.f1826h = new MediaPlayer();
        } else {
            this.f1826h.reset();
        }
        return this.f1826h;
    }

    public boolean m3196c(String dataStream) {
        return m3192a(dataStream, 0);
    }

    public boolean m3192a(String dataStream, int tries) {
        boolean z = false;
        if (dataStream == null) {
            return z;
        }
        if (dataStream.equals(this.f1827i)) {
            m3187F();
            this.f1827i = null;
            return z;
        }
        this.f1826h = m3178G();
        try {
            this.f1826h.setDataSource(dataStream);
            this.f1827i = dataStream;
            this.f1826h.prepareAsync();
            this.f1826h.setOnPreparedListener(new C07081(this));
            this.f1826h.setOnCompletionListener(new C07092(this));
            return true;
        } catch (IOException io) {
            if (tries < 1) {
                try {
                    return m3192a(C0854s.m4014c(getActivity(), Uri.parse(dataStream)), 1);
                } catch (Exception e) {
                    C0970a.m4322a(e);
                    return z;
                }
            }
            C0850q.m3985a(io, "failed to play song after retry");
            return z;
        } catch (Exception e2) {
            C0970a.m4322a(e2);
            return z;
        }
    }

    public void m3187F() {
        if (this.f1826h != null && this.f1826h.isPlaying()) {
            this.f1826h.stop();
            this.f1826h.release();
        }
        this.f1826h = null;
    }

    public void b_() {
        m3084p();
    }

    public void m3199o() {
    }

    public void m3194c(int position) {
    }

    public void m3200u() {
    }

    public void m3195c(Object item) {
    }
}
