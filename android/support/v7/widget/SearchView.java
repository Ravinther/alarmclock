package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.view.C0230g;
import android.support.v4.widget.C0303a;
import android.support.v7.p013c.C0365b;
import android.support.v7.p014b.C0364a.C0355b;
import android.support.v7.p014b.C0364a.C0357d;
import android.support.v7.p014b.C0364a.C0358e;
import android.support.v7.p014b.C0364a.C0360g;
import android.support.v7.p014b.C0364a.C0363j;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.drive.DriveFile;
import com.mopub.mobileads.util.Base64;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends LinearLayout implements C0365b {
    static final C0477a f1233a;
    private CharSequence f1234A;
    private CharSequence f1235B;
    private boolean f1236C;
    private int f1237D;
    private SearchableInfo f1238E;
    private Bundle f1239F;
    private Runnable f1240G;
    private Runnable f1241H;
    private Runnable f1242I;
    private final Intent f1243J;
    private final Intent f1244K;
    private final WeakHashMap f1245L;
    private final OnClickListener f1246M;
    private final OnEditorActionListener f1247N;
    private final OnItemClickListener f1248O;
    private final OnItemSelectedListener f1249P;
    private TextWatcher f1250Q;
    OnKeyListener f1251b;
    private C0479c f1252c;
    private C0478b f1253d;
    private OnFocusChangeListener f1254e;
    private C0480d f1255f;
    private OnClickListener f1256g;
    private boolean f1257h;
    private boolean f1258i;
    private C0303a f1259j;
    private View f1260k;
    private View f1261l;
    private View f1262m;
    private View f1263n;
    private ImageView f1264o;
    private View f1265p;
    private View f1266q;
    private SearchAutoComplete f1267r;
    private View f1268s;
    private ImageView f1269t;
    private boolean f1270u;
    private CharSequence f1271v;
    private boolean f1272w;
    private boolean f1273x;
    private int f1274y;
    private boolean f1275z;

    /* renamed from: android.support.v7.widget.SearchView.1 */
    class C04681 implements Runnable {
        final /* synthetic */ SearchView f1218a;

        C04681(SearchView searchView) {
            this.f1218a = searchView;
        }

        public void run() {
            InputMethodManager imm = (InputMethodManager) this.f1218a.getContext().getSystemService("input_method");
            if (imm != null) {
                SearchView.f1233a.m2231a(imm, this.f1218a, 0);
            }
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.2 */
    class C04692 implements OnItemClickListener {
        final /* synthetic */ SearchView f1219a;

        C04692(SearchView searchView) {
            this.f1219a = searchView;
        }

        public void onItemClick(AdapterView parent, View view, int position, long id) {
            this.f1219a.m2250a(position, 0, null);
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.3 */
    class C04703 implements OnItemSelectedListener {
        final /* synthetic */ SearchView f1220a;

        C04703(SearchView searchView) {
            this.f1220a = searchView;
        }

        public void onItemSelected(AdapterView parent, View view, int position, long id) {
            this.f1220a.m2249a(position);
        }

        public void onNothingSelected(AdapterView parent) {
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.4 */
    class C04714 implements TextWatcher {
        final /* synthetic */ SearchView f1221a;

        C04714(SearchView searchView) {
            this.f1221a = searchView;
        }

        public void beforeTextChanged(CharSequence s, int start, int before, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int after) {
            this.f1221a.m2263c(s);
        }

        public void afterTextChanged(Editable s) {
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.5 */
    class C04725 implements Runnable {
        final /* synthetic */ SearchView f1222a;

        C04725(SearchView searchView) {
            this.f1222a = searchView;
        }

        public void run() {
            this.f1222a.m2280l();
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.6 */
    class C04736 implements Runnable {
        final /* synthetic */ SearchView f1223a;

        C04736(SearchView searchView) {
            this.f1223a = searchView;
        }

        public void run() {
            if (this.f1223a.f1259j != null && (this.f1223a.f1259j instanceof C0490c)) {
                this.f1223a.f1259j.m1306a(null);
            }
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.7 */
    class C04747 implements OnFocusChangeListener {
        final /* synthetic */ SearchView f1224a;

        C04747(SearchView searchView) {
            this.f1224a = searchView;
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (this.f1224a.f1254e != null) {
                this.f1224a.f1254e.onFocusChange(this.f1224a, hasFocus);
            }
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.8 */
    class C04758 implements OnLayoutChangeListener {
        final /* synthetic */ SearchView f1225a;

        C04758(SearchView searchView) {
            this.f1225a = searchView;
        }

        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            this.f1225a.m2292t();
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.9 */
    class C04769 implements OnGlobalLayoutListener {
        final /* synthetic */ SearchView f1226a;

        C04769(SearchView searchView) {
            this.f1226a = searchView;
        }

        public void onGlobalLayout() {
            this.f1226a.m2292t();
        }
    }

    public static class SearchAutoComplete extends AutoCompleteTextView {
        private int f1227a;
        private SearchView f1228b;

        public SearchAutoComplete(Context context) {
            super(context);
            this.f1227a = getThreshold();
        }

        public SearchAutoComplete(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.f1227a = getThreshold();
        }

        public SearchAutoComplete(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            this.f1227a = getThreshold();
        }

        void setSearchView(SearchView searchView) {
            this.f1228b = searchView;
        }

        public void setThreshold(int threshold) {
            super.setThreshold(threshold);
            this.f1227a = threshold;
        }

        private boolean m2229a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        protected void replaceText(CharSequence text) {
        }

        public void performCompletion() {
        }

        public void onWindowFocusChanged(boolean hasWindowFocus) {
            super.onWindowFocusChanged(hasWindowFocus);
            if (hasWindowFocus && this.f1228b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.m2251a(getContext())) {
                    SearchView.f1233a.m2233a(this, true);
                }
            }
        }

        protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
            this.f1228b.m2299d();
        }

        public boolean enoughToFilter() {
            return this.f1227a <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int keyCode, KeyEvent event) {
            if (keyCode == 4) {
                DispatcherState state;
                if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                    state = getKeyDispatcherState();
                    if (state == null) {
                        return true;
                    }
                    state.startTracking(event, this);
                    return true;
                } else if (event.getAction() == 1) {
                    state = getKeyDispatcherState();
                    if (state != null) {
                        state.handleUpEvent(event);
                    }
                    if (event.isTracking() && !event.isCanceled()) {
                        this.f1228b.clearFocus();
                        this.f1228b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(keyCode, event);
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.a */
    private static class C0477a {
        private Method f1229a;
        private Method f1230b;
        private Method f1231c;
        private Method f1232d;

        C0477a() {
            try {
                this.f1229a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1229a.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.f1230b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1230b.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.f1231c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f1231c.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.f1232d = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
                this.f1232d.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        void m2232a(AutoCompleteTextView view) {
            if (this.f1229a != null) {
                try {
                    this.f1229a.invoke(view, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void m2234b(AutoCompleteTextView view) {
            if (this.f1230b != null) {
                try {
                    this.f1230b.invoke(view, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void m2233a(AutoCompleteTextView view, boolean visible) {
            if (this.f1231c != null) {
                try {
                    this.f1231c.invoke(view, new Object[]{Boolean.valueOf(visible)});
                } catch (Exception e) {
                }
            }
        }

        void m2231a(InputMethodManager imm, View view, int flags) {
            if (this.f1232d != null) {
                try {
                    this.f1232d.invoke(imm, new Object[]{Integer.valueOf(flags), null});
                    return;
                } catch (Exception e) {
                }
            }
            imm.showSoftInput(view, flags);
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.b */
    public interface C0478b {
        boolean m2235a();
    }

    /* renamed from: android.support.v7.widget.SearchView.c */
    public interface C0479c {
        boolean a_(String str);

        boolean m2236b(String str);
    }

    /* renamed from: android.support.v7.widget.SearchView.d */
    public interface C0480d {
        boolean m2237a(int i);

        boolean m2238b(int i);
    }

    static {
        f1233a = new C0477a();
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f1240G = new C04681(this);
        this.f1241H = new C04725(this);
        this.f1242I = new C04736(this);
        this.f1245L = new WeakHashMap();
        this.f1246M = new OnClickListener() {
            final /* synthetic */ SearchView f1215a;

            {
                this.f1215a = r1;
            }

            public void onClick(View v) {
                if (v == this.f1215a.f1260k) {
                    this.f1215a.m2290r();
                } else if (v == this.f1215a.f1264o) {
                    this.f1215a.m2289q();
                } else if (v == this.f1215a.f1261l) {
                    this.f1215a.m2287o();
                } else if (v == this.f1215a.f1266q) {
                    this.f1215a.m2291s();
                } else if (v == this.f1215a.f1267r) {
                    this.f1215a.m2293u();
                }
            }
        };
        this.f1251b = new OnKeyListener() {
            final /* synthetic */ SearchView f1216a;

            {
                this.f1216a = r1;
            }

            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (this.f1216a.f1238E == null) {
                    return false;
                }
                if (this.f1216a.f1267r.isPopupShowing() && this.f1216a.f1267r.getListSelection() != -1) {
                    return this.f1216a.m2255a(v, keyCode, event);
                }
                if (this.f1216a.f1267r.m2229a() || !C0230g.m1015a(event) || event.getAction() != 1 || keyCode != 66) {
                    return false;
                }
                v.cancelLongPress();
                this.f1216a.m2242a(0, null, this.f1216a.f1267r.getText().toString());
                return true;
            }
        };
        this.f1247N = new OnEditorActionListener() {
            final /* synthetic */ SearchView f1217a;

            {
                this.f1217a = r1;
            }

            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                this.f1217a.m2287o();
                return true;
            }
        };
        this.f1248O = new C04692(this);
        this.f1249P = new C04703(this);
        this.f1250Q = new C04714(this);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C0360g.abc_search_view, this, true);
        this.f1260k = findViewById(C0358e.search_button);
        this.f1267r = (SearchAutoComplete) findViewById(C0358e.search_src_text);
        this.f1267r.setSearchView(this);
        this.f1265p = findViewById(C0358e.search_edit_frame);
        this.f1262m = findViewById(C0358e.search_plate);
        this.f1263n = findViewById(C0358e.submit_area);
        this.f1261l = findViewById(C0358e.search_go_btn);
        this.f1264o = (ImageView) findViewById(C0358e.search_close_btn);
        this.f1266q = findViewById(C0358e.search_voice_btn);
        this.f1269t = (ImageView) findViewById(C0358e.search_mag_icon);
        this.f1260k.setOnClickListener(this.f1246M);
        this.f1264o.setOnClickListener(this.f1246M);
        this.f1261l.setOnClickListener(this.f1246M);
        this.f1266q.setOnClickListener(this.f1246M);
        this.f1267r.setOnClickListener(this.f1246M);
        this.f1267r.addTextChangedListener(this.f1250Q);
        this.f1267r.setOnEditorActionListener(this.f1247N);
        this.f1267r.setOnItemClickListener(this.f1248O);
        this.f1267r.setOnItemSelectedListener(this.f1249P);
        this.f1267r.setOnKeyListener(this.f1251b);
        this.f1267r.setOnFocusChangeListener(new C04747(this));
        TypedArray a = context.obtainStyledAttributes(attrs, C0363j.SearchView, 0, 0);
        setIconifiedByDefault(a.getBoolean(3, true));
        int maxWidth = a.getDimensionPixelSize(0, -1);
        if (maxWidth != -1) {
            setMaxWidth(maxWidth);
        }
        CharSequence queryHint = a.getText(4);
        if (!TextUtils.isEmpty(queryHint)) {
            setQueryHint(queryHint);
        }
        int imeOptions = a.getInt(2, -1);
        if (imeOptions != -1) {
            setImeOptions(imeOptions);
        }
        int inputType = a.getInt(1, -1);
        if (inputType != -1) {
            setInputType(inputType);
        }
        a.recycle();
        a = context.obtainStyledAttributes(attrs, C0363j.View, 0, 0);
        boolean focusable = a.getBoolean(0, true);
        a.recycle();
        setFocusable(focusable);
        this.f1243J = new Intent("android.speech.action.WEB_SEARCH");
        this.f1243J.addFlags(DriveFile.MODE_READ_ONLY);
        this.f1243J.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.f1244K = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f1244K.addFlags(DriveFile.MODE_READ_ONLY);
        this.f1268s = findViewById(this.f1267r.getDropDownAnchor());
        if (this.f1268s != null) {
            if (VERSION.SDK_INT >= 11) {
                m2267e();
            } else {
                m2268f();
            }
        }
        m2248a(this.f1257h);
        m2283m();
    }

    private void m2267e() {
        this.f1268s.addOnLayoutChangeListener(new C04758(this));
    }

    private void m2268f() {
        this.f1268s.getViewTreeObserver().addOnGlobalLayoutListener(new C04769(this));
    }

    public void setSearchableInfo(SearchableInfo searchable) {
        this.f1238E = searchable;
        if (this.f1238E != null) {
            m2284n();
            m2283m();
        }
        this.f1275z = m2271g();
        if (this.f1275z) {
            this.f1267r.setPrivateImeOptions("nm");
        }
        m2248a(m2298c());
    }

    public void setAppSearchData(Bundle appSearchData) {
        this.f1239F = appSearchData;
    }

    public void setImeOptions(int imeOptions) {
        this.f1267r.setImeOptions(imeOptions);
    }

    public int getImeOptions() {
        return this.f1267r.getImeOptions();
    }

    public void setInputType(int inputType) {
        this.f1267r.setInputType(inputType);
    }

    public int getInputType() {
        return this.f1267r.getInputType();
    }

    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        if (this.f1273x) {
            return false;
        }
        if (!isFocusable()) {
            return false;
        }
        if (m2298c()) {
            return super.requestFocus(direction, previouslyFocusedRect);
        }
        boolean result = this.f1267r.requestFocus(direction, previouslyFocusedRect);
        if (!result) {
            return result;
        }
        m2248a(false);
        return result;
    }

    public void clearFocus() {
        this.f1273x = true;
        setImeVisibility(false);
        super.clearFocus();
        this.f1267r.clearFocus();
        this.f1273x = false;
    }

    public void setOnQueryTextListener(C0479c listener) {
        this.f1252c = listener;
    }

    public void setOnCloseListener(C0478b listener) {
        this.f1253d = listener;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener listener) {
        this.f1254e = listener;
    }

    public void setOnSuggestionListener(C0480d listener) {
        this.f1255f = listener;
    }

    public void setOnSearchClickListener(OnClickListener listener) {
        this.f1256g = listener;
    }

    public CharSequence getQuery() {
        return this.f1267r.getText();
    }

    public void m2296a(CharSequence query, boolean submit) {
        this.f1267r.setText(query);
        if (query != null) {
            this.f1267r.setSelection(this.f1267r.length());
            this.f1235B = query;
        }
        if (submit && !TextUtils.isEmpty(query)) {
            m2287o();
        }
    }

    public void setQueryHint(CharSequence hint) {
        this.f1271v = hint;
        m2283m();
    }

    public CharSequence getQueryHint() {
        if (this.f1271v != null) {
            return this.f1271v;
        }
        if (this.f1238E == null) {
            return null;
        }
        int hintId = this.f1238E.getHintId();
        if (hintId != 0) {
            return getContext().getString(hintId);
        }
        return null;
    }

    public void setIconifiedByDefault(boolean iconified) {
        if (this.f1257h != iconified) {
            this.f1257h = iconified;
            m2248a(iconified);
            m2283m();
        }
    }

    public void setIconified(boolean iconify) {
        if (iconify) {
            m2289q();
        } else {
            m2290r();
        }
    }

    public boolean m2298c() {
        return this.f1258i;
    }

    public void setSubmitButtonEnabled(boolean enabled) {
        this.f1270u = enabled;
        m2248a(m2298c());
    }

    public void setQueryRefinementEnabled(boolean enable) {
        this.f1272w = enable;
        if (this.f1259j instanceof C0490c) {
            ((C0490c) this.f1259j).m2341a(enable ? 2 : 1);
        }
    }

    public void setSuggestionsAdapter(C0303a adapter) {
        this.f1259j = adapter;
        this.f1267r.setAdapter(this.f1259j);
    }

    public C0303a getSuggestionsAdapter() {
        return this.f1259j;
    }

    public void setMaxWidth(int maxpixels) {
        this.f1274y = maxpixels;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.f1274y;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (m2298c()) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        switch (widthMode) {
            case Integer.MIN_VALUE:
                if (this.f1274y <= 0) {
                    width = Math.min(getPreferredWidth(), width);
                    break;
                } else {
                    width = Math.min(this.f1274y, width);
                    break;
                }
            case Base64.DEFAULT /*0*/:
                width = this.f1274y > 0 ? this.f1274y : getPreferredWidth();
                break;
            case 1073741824:
                if (this.f1274y > 0) {
                    width = Math.min(this.f1274y, width);
                    break;
                }
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(width, 1073741824), heightMeasureSpec);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0357d.abc_search_view_preferred_width);
    }

    private void m2248a(boolean collapsed) {
        int visCollapsed;
        boolean hasText;
        int i;
        boolean z = true;
        int i2 = 8;
        this.f1258i = collapsed;
        if (collapsed) {
            visCollapsed = 0;
        } else {
            visCollapsed = 8;
        }
        if (TextUtils.isEmpty(this.f1267r.getText())) {
            hasText = false;
        } else {
            hasText = true;
        }
        this.f1260k.setVisibility(visCollapsed);
        m2260b(hasText);
        View view = this.f1265p;
        if (collapsed) {
            i = 8;
        } else {
            i = 0;
        }
        view.setVisibility(i);
        ImageView imageView = this.f1269t;
        if (!this.f1257h) {
            i2 = 0;
        }
        imageView.setVisibility(i2);
        m2276j();
        if (hasText) {
            z = false;
        }
        m2264c(z);
        m2275i();
    }

    private boolean m2271g() {
        if (this.f1238E == null || !this.f1238E.getVoiceSearchEnabled()) {
            return false;
        }
        Intent testIntent = null;
        if (this.f1238E.getVoiceSearchLaunchWebSearch()) {
            testIntent = this.f1243J;
        } else if (this.f1238E.getVoiceSearchLaunchRecognizer()) {
            testIntent = this.f1244K;
        }
        if (testIntent == null || getContext().getPackageManager().resolveActivity(testIntent, Cast.MAX_MESSAGE_LENGTH) == null) {
            return false;
        }
        return true;
    }

    private boolean m2273h() {
        return (this.f1270u || this.f1275z) && !m2298c();
    }

    private void m2260b(boolean hasText) {
        int visibility = 8;
        if (this.f1270u && m2273h() && hasFocus() && (hasText || !this.f1275z)) {
            visibility = 0;
        }
        this.f1261l.setVisibility(visibility);
    }

    private void m2275i() {
        int visibility = 8;
        if (m2273h() && (this.f1261l.getVisibility() == 0 || this.f1266q.getVisibility() == 0)) {
            visibility = 0;
        }
        this.f1263n.setVisibility(visibility);
    }

    private void m2276j() {
        boolean hasText;
        boolean showClose = true;
        int i = 0;
        if (TextUtils.isEmpty(this.f1267r.getText())) {
            hasText = false;
        } else {
            hasText = true;
        }
        if (!hasText && (!this.f1257h || this.f1236C)) {
            showClose = false;
        }
        ImageView imageView = this.f1264o;
        if (!showClose) {
            i = 8;
        }
        imageView.setVisibility(i);
        this.f1264o.getDrawable().setState(hasText ? ENABLED_STATE_SET : EMPTY_STATE_SET);
    }

    private void m2279k() {
        post(this.f1241H);
    }

    private void m2280l() {
        boolean focused = this.f1267r.hasFocus();
        this.f1262m.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        this.f1263n.getBackground().setState(focused ? FOCUSED_STATE_SET : EMPTY_STATE_SET);
        invalidate();
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.f1241H);
        post(this.f1242I);
        super.onDetachedFromWindow();
    }

    private void setImeVisibility(boolean visible) {
        if (visible) {
            post(this.f1240G);
            return;
        }
        removeCallbacks(this.f1240G);
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService("input_method");
        if (imm != null) {
            imm.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    void m2295a(CharSequence queryText) {
        setQuery(queryText);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (this.f1238E == null) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private boolean m2255a(View v, int keyCode, KeyEvent event) {
        if (this.f1238E == null || this.f1259j == null || event.getAction() != 0 || !C0230g.m1015a(event)) {
            return false;
        }
        if (keyCode == 66 || keyCode == 84 || keyCode == 61) {
            return m2250a(this.f1267r.getListSelection(), 0, null);
        }
        if (keyCode != 21 && keyCode != 22) {
            return (keyCode == 19 && this.f1267r.getListSelection() == 0) ? false : false;
        } else {
            int selPoint;
            if (keyCode == 21) {
                selPoint = 0;
            } else {
                selPoint = this.f1267r.length();
            }
            this.f1267r.setSelection(selPoint);
            this.f1267r.setListSelection(0);
            this.f1267r.clearListSelection();
            f1233a.m2233a(this.f1267r, true);
            return true;
        }
    }

    private int getSearchIconId() {
        TypedValue outValue = new TypedValue();
        getContext().getTheme().resolveAttribute(C0355b.searchViewSearchIcon, outValue, true);
        return outValue.resourceId;
    }

    private CharSequence m2258b(CharSequence hintText) {
        if (!this.f1257h) {
            return hintText;
        }
        SpannableStringBuilder ssb = new SpannableStringBuilder("   ");
        ssb.append(hintText);
        Drawable searchIcon = getContext().getResources().getDrawable(getSearchIconId());
        int textSize = (int) (((double) this.f1267r.getTextSize()) * 1.25d);
        searchIcon.setBounds(0, 0, textSize, textSize);
        ssb.setSpan(new ImageSpan(searchIcon), 1, 2, 33);
        return ssb;
    }

    private void m2283m() {
        if (this.f1271v != null) {
            this.f1267r.setHint(m2258b(this.f1271v));
        } else if (this.f1238E != null) {
            CharSequence hint = null;
            int hintId = this.f1238E.getHintId();
            if (hintId != 0) {
                hint = getContext().getString(hintId);
            }
            if (hint != null) {
                this.f1267r.setHint(m2258b(hint));
            }
        } else {
            this.f1267r.setHint(m2258b((CharSequence) ""));
        }
    }

    private void m2284n() {
        int i = 1;
        this.f1267r.setThreshold(this.f1238E.getSuggestThreshold());
        this.f1267r.setImeOptions(this.f1238E.getImeOptions());
        int inputType = this.f1238E.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1238E.getSuggestAuthority() != null) {
                inputType = (inputType | Cast.MAX_MESSAGE_LENGTH) | 524288;
            }
        }
        this.f1267r.setInputType(inputType);
        if (this.f1259j != null) {
            this.f1259j.m1306a(null);
        }
        if (this.f1238E.getSuggestAuthority() != null) {
            this.f1259j = new C0490c(getContext(), this, this.f1238E, this.f1245L);
            this.f1267r.setAdapter(this.f1259j);
            C0490c c0490c = (C0490c) this.f1259j;
            if (this.f1272w) {
                i = 2;
            }
            c0490c.m2341a(i);
        }
    }

    private void m2264c(boolean empty) {
        int visibility = 8;
        if (this.f1275z && !m2298c() && empty) {
            visibility = 0;
            this.f1261l.setVisibility(8);
        }
        this.f1266q.setVisibility(visibility);
    }

    private void m2263c(CharSequence newText) {
        boolean hasText;
        boolean z = true;
        CharSequence text = this.f1267r.getText();
        this.f1235B = text;
        if (TextUtils.isEmpty(text)) {
            hasText = false;
        } else {
            hasText = true;
        }
        m2260b(hasText);
        if (hasText) {
            z = false;
        }
        m2264c(z);
        m2276j();
        m2275i();
        if (!(this.f1252c == null || TextUtils.equals(newText, this.f1234A))) {
            this.f1252c.m2236b(newText.toString());
        }
        this.f1234A = newText.toString();
    }

    private void m2287o() {
        CharSequence query = this.f1267r.getText();
        if (query != null && TextUtils.getTrimmedLength(query) > 0) {
            if (this.f1252c == null || !this.f1252c.a_(query.toString())) {
                if (this.f1238E != null) {
                    m2242a(0, null, query.toString());
                    setImeVisibility(false);
                }
                m2288p();
            }
        }
    }

    private void m2288p() {
        this.f1267r.dismissDropDown();
    }

    private void m2289q() {
        if (!TextUtils.isEmpty(this.f1267r.getText())) {
            this.f1267r.setText("");
            this.f1267r.requestFocus();
            setImeVisibility(true);
        } else if (!this.f1257h) {
        } else {
            if (this.f1253d == null || !this.f1253d.m2235a()) {
                clearFocus();
                m2248a(true);
            }
        }
    }

    private void m2290r() {
        m2248a(false);
        this.f1267r.requestFocus();
        setImeVisibility(true);
        if (this.f1256g != null) {
            this.f1256g.onClick(this);
        }
    }

    private void m2291s() {
        if (this.f1238E != null) {
            SearchableInfo searchable = this.f1238E;
            try {
                if (searchable.getVoiceSearchLaunchWebSearch()) {
                    getContext().startActivity(m2239a(this.f1243J, searchable));
                } else if (searchable.getVoiceSearchLaunchRecognizer()) {
                    getContext().startActivity(m2256b(this.f1244K, searchable));
                }
            } catch (ActivityNotFoundException e) {
                Log.w("SearchView", "Could not find voice search activity");
            }
        }
    }

    void m2299d() {
        m2248a(m2298c());
        m2279k();
        if (this.f1267r.hasFocus()) {
            m2293u();
        }
    }

    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        m2279k();
    }

    public void m2297b() {
        clearFocus();
        m2248a(true);
        this.f1267r.setImeOptions(this.f1237D);
        this.f1236C = false;
    }

    public void m2294a() {
        if (!this.f1236C) {
            this.f1236C = true;
            this.f1237D = this.f1267r.getImeOptions();
            this.f1267r.setImeOptions(this.f1237D | 33554432);
            this.f1267r.setText("");
            setIconified(false);
        }
    }

    private void m2292t() {
        if (this.f1268s.getWidth() > 1) {
            Resources res = getContext().getResources();
            int anchorPadding = this.f1262m.getPaddingLeft();
            Rect dropDownPadding = new Rect();
            int iconOffset = this.f1257h ? res.getDimensionPixelSize(C0357d.abc_dropdownitem_icon_width) + res.getDimensionPixelSize(C0357d.abc_dropdownitem_text_padding_left) : 0;
            this.f1267r.getDropDownBackground().getPadding(dropDownPadding);
            this.f1267r.setDropDownHorizontalOffset(anchorPadding - (dropDownPadding.left + iconOffset));
            this.f1267r.setDropDownWidth((((this.f1268s.getWidth() + dropDownPadding.left) + dropDownPadding.right) + iconOffset) - anchorPadding);
        }
    }

    private boolean m2250a(int position, int actionKey, String actionMsg) {
        if (this.f1255f != null && this.f1255f.m2238b(position)) {
            return false;
        }
        m2261b(position, 0, null);
        setImeVisibility(false);
        m2288p();
        return true;
    }

    private boolean m2249a(int position) {
        if (this.f1255f != null && this.f1255f.m2237a(position)) {
            return false;
        }
        m2259b(position);
        return true;
    }

    private void m2259b(int position) {
        CharSequence oldQuery = this.f1267r.getText();
        Cursor c = this.f1259j.m1302a();
        if (c != null) {
            if (c.moveToPosition(position)) {
                CharSequence newQuery = this.f1259j.m1311c(c);
                if (newQuery != null) {
                    setQuery(newQuery);
                    return;
                } else {
                    setQuery(oldQuery);
                    return;
                }
            }
            setQuery(oldQuery);
        }
    }

    private boolean m2261b(int position, int actionKey, String actionMsg) {
        Cursor c = this.f1259j.m1302a();
        if (c == null || !c.moveToPosition(position)) {
            return false;
        }
        m2243a(m2240a(c, actionKey, actionMsg));
        return true;
    }

    private void m2243a(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException ex) {
                Log.e("SearchView", "Failed launch activity: " + intent, ex);
            }
        }
    }

    private void setQuery(CharSequence query) {
        this.f1267r.setText(query);
        this.f1267r.setSelection(TextUtils.isEmpty(query) ? 0 : query.length());
    }

    private void m2242a(int actionKey, String actionMsg, String query) {
        getContext().startActivity(m2241a("android.intent.action.SEARCH", null, null, query, actionKey, actionMsg));
    }

    private Intent m2241a(String action, Uri data, String extraData, String query, int actionKey, String actionMsg) {
        Intent intent = new Intent(action);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        if (data != null) {
            intent.setData(data);
        }
        intent.putExtra("user_query", this.f1235B);
        if (query != null) {
            intent.putExtra("query", query);
        }
        if (extraData != null) {
            intent.putExtra("intent_extra_data_key", extraData);
        }
        if (this.f1239F != null) {
            intent.putExtra("app_data", this.f1239F);
        }
        if (actionKey != 0) {
            intent.putExtra("action_key", actionKey);
            intent.putExtra("action_msg", actionMsg);
        }
        intent.setComponent(this.f1238E.getSearchActivity());
        return intent;
    }

    private Intent m2239a(Intent baseIntent, SearchableInfo searchable) {
        Intent voiceIntent = new Intent(baseIntent);
        ComponentName searchActivity = searchable.getSearchActivity();
        voiceIntent.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return voiceIntent;
    }

    private Intent m2256b(Intent baseIntent, SearchableInfo searchable) {
        ComponentName searchActivity = searchable.getSearchActivity();
        Intent queryIntent = new Intent("android.intent.action.SEARCH");
        queryIntent.setComponent(searchActivity);
        PendingIntent pending = PendingIntent.getActivity(getContext(), 0, queryIntent, 1073741824);
        Bundle queryExtras = new Bundle();
        if (this.f1239F != null) {
            queryExtras.putParcelable("app_data", this.f1239F);
        }
        Intent voiceIntent = new Intent(baseIntent);
        String languageModel = "free_form";
        String prompt = null;
        String language = null;
        int maxResults = 1;
        Resources resources = getResources();
        if (searchable.getVoiceLanguageModeId() != 0) {
            languageModel = resources.getString(searchable.getVoiceLanguageModeId());
        }
        if (searchable.getVoicePromptTextId() != 0) {
            prompt = resources.getString(searchable.getVoicePromptTextId());
        }
        if (searchable.getVoiceLanguageId() != 0) {
            language = resources.getString(searchable.getVoiceLanguageId());
        }
        if (searchable.getVoiceMaxResults() != 0) {
            maxResults = searchable.getVoiceMaxResults();
        }
        voiceIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", languageModel);
        voiceIntent.putExtra("android.speech.extra.PROMPT", prompt);
        voiceIntent.putExtra("android.speech.extra.LANGUAGE", language);
        voiceIntent.putExtra("android.speech.extra.MAX_RESULTS", maxResults);
        voiceIntent.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        voiceIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", pending);
        voiceIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", queryExtras);
        return voiceIntent;
    }

    private Intent m2240a(Cursor c, int actionKey, String actionMsg) {
        try {
            String action = C0490c.m2325a(c, "suggest_intent_action");
            if (action == null) {
                action = this.f1238E.getSuggestIntentAction();
            }
            if (action == null) {
                action = "android.intent.action.SEARCH";
            }
            String data = C0490c.m2325a(c, "suggest_intent_data");
            if (data == null) {
                data = this.f1238E.getSuggestIntentData();
            }
            if (data != null) {
                String id = C0490c.m2325a(c, "suggest_intent_data_id");
                if (id != null) {
                    data = data + "/" + Uri.encode(id);
                }
            }
            return m2241a(action, data == null ? null : Uri.parse(data), C0490c.m2325a(c, "suggest_intent_extra_data"), C0490c.m2325a(c, "suggest_intent_query"), actionKey, actionMsg);
        } catch (RuntimeException e) {
            int rowNum;
            try {
                rowNum = c.getPosition();
            } catch (RuntimeException e2) {
                rowNum = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + rowNum + " returned exception.", e);
            return null;
        }
    }

    private void m2293u() {
        f1233a.m2232a(this.f1267r);
        f1233a.m2234b(this.f1267r);
    }

    static boolean m2251a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }
}
