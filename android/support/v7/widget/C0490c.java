package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.widget.C0312g;
import android.support.v7.p014b.C0364a.C0355b;
import android.support.v7.p014b.C0364a.C0358e;
import android.support.v7.p014b.C0364a.C0360g;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.avg.toolkit.ITKSvc;
import com.google.android.gms.cast.Cast;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* renamed from: android.support.v7.widget.c */
class C0490c extends C0312g implements OnClickListener {
    private SearchManager f1295j;
    private SearchView f1296k;
    private SearchableInfo f1297l;
    private Context f1298m;
    private WeakHashMap f1299n;
    private boolean f1300o;
    private int f1301p;
    private ColorStateList f1302q;
    private int f1303r;
    private int f1304s;
    private int f1305t;
    private int f1306u;
    private int f1307v;
    private int f1308w;

    /* renamed from: android.support.v7.widget.c.a */
    private static final class C0489a {
        public final TextView f1290a;
        public final TextView f1291b;
        public final ImageView f1292c;
        public final ImageView f1293d;
        public final ImageView f1294e;

        public C0489a(View v) {
            this.f1290a = (TextView) v.findViewById(16908308);
            this.f1291b = (TextView) v.findViewById(16908309);
            this.f1292c = (ImageView) v.findViewById(16908295);
            this.f1293d = (ImageView) v.findViewById(16908296);
            this.f1294e = (ImageView) v.findViewById(C0358e.edit_query);
        }
    }

    public C0490c(Context context, SearchView searchView, SearchableInfo searchable, WeakHashMap outsideDrawablesCache) {
        super(context, C0360g.abc_search_dropdown_item_icons_2line, null, true);
        this.f1300o = false;
        this.f1301p = 1;
        this.f1303r = -1;
        this.f1304s = -1;
        this.f1305t = -1;
        this.f1306u = -1;
        this.f1307v = -1;
        this.f1308w = -1;
        this.f1295j = (SearchManager) this.d.getSystemService("search");
        this.f1296k = searchView;
        this.f1297l = searchable;
        this.f1298m = context;
        this.f1299n = outsideDrawablesCache;
    }

    public void m2341a(int refineWhat) {
        this.f1301p = refineWhat;
    }

    public boolean hasStableIds() {
        return false;
    }

    public Cursor m2338a(CharSequence constraint) {
        String query = constraint == null ? "" : constraint.toString();
        if (this.f1296k.getVisibility() != 0 || this.f1296k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor cursor = m2337a(this.f1297l, query, 50);
            if (cursor == null) {
                return null;
            }
            cursor.getCount();
            return cursor;
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            return null;
        }
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m2333d(m1302a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m2333d(m1302a());
    }

    private void m2333d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    public void m2342a(Cursor c) {
        if (this.f1300o) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (c != null) {
                c.close();
                return;
            }
            return;
        }
        try {
            super.m1306a(c);
            if (c != null) {
                this.f1303r = c.getColumnIndex("suggest_text_1");
                this.f1304s = c.getColumnIndex("suggest_text_2");
                this.f1305t = c.getColumnIndex("suggest_text_2_url");
                this.f1306u = c.getColumnIndex("suggest_icon_1");
                this.f1307v = c.getColumnIndex("suggest_icon_2");
                this.f1308w = c.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public View m2340a(Context context, Cursor cursor, ViewGroup parent) {
        View v = super.m1350a(context, cursor, parent);
        v.setTag(new C0489a(v));
        return v;
    }

    public void m2343a(View view, Context context, Cursor cursor) {
        C0489a views = (C0489a) view.getTag();
        int flags = 0;
        if (this.f1308w != -1) {
            flags = cursor.getInt(this.f1308w);
        }
        if (views.f1290a != null) {
            m2327a(views.f1290a, C0490c.m2324a(cursor, this.f1303r));
        }
        if (views.f1291b != null) {
            CharSequence text2 = C0490c.m2324a(cursor, this.f1305t);
            if (text2 != null) {
                text2 = m2332b(text2);
            } else {
                text2 = C0490c.m2324a(cursor, this.f1304s);
            }
            if (TextUtils.isEmpty(text2)) {
                if (views.f1290a != null) {
                    views.f1290a.setSingleLine(false);
                    views.f1290a.setMaxLines(2);
                }
            } else if (views.f1290a != null) {
                views.f1290a.setSingleLine(true);
                views.f1290a.setMaxLines(1);
            }
            m2327a(views.f1291b, text2);
        }
        if (views.f1292c != null) {
            m2326a(views.f1292c, m2334e(cursor), 4);
        }
        if (views.f1293d != null) {
            m2326a(views.f1293d, m2335f(cursor), 8);
        }
        if (this.f1301p == 2 || (this.f1301p == 1 && (flags & 1) != 0)) {
            views.f1294e.setVisibility(0);
            views.f1294e.setTag(views.f1290a.getText());
            views.f1294e.setOnClickListener(this);
            return;
        }
        views.f1294e.setVisibility(8);
    }

    public void onClick(View v) {
        Object tag = v.getTag();
        if (tag instanceof CharSequence) {
            this.f1296k.m2295a((CharSequence) tag);
        }
    }

    private CharSequence m2332b(CharSequence url) {
        if (this.f1302q == null) {
            TypedValue colorValue = new TypedValue();
            this.d.getTheme().resolveAttribute(C0355b.textColorSearchUrl, colorValue, true);
            this.f1302q = this.d.getResources().getColorStateList(colorValue.resourceId);
        }
        SpannableString text = new SpannableString(url);
        text.setSpan(new TextAppearanceSpan(null, 0, 0, this.f1302q, null), 0, url.length(), 33);
        return text;
    }

    private void m2327a(TextView v, CharSequence text) {
        v.setText(text);
        if (TextUtils.isEmpty(text)) {
            v.setVisibility(8);
        } else {
            v.setVisibility(0);
        }
    }

    private Drawable m2334e(Cursor cursor) {
        if (this.f1306u == -1) {
            return null;
        }
        Drawable drawable = m2323a(cursor.getString(this.f1306u));
        return drawable == null ? m2336g(cursor) : drawable;
    }

    private Drawable m2335f(Cursor cursor) {
        if (this.f1307v == -1) {
            return null;
        }
        return m2323a(cursor.getString(this.f1307v));
    }

    private void m2326a(ImageView v, Drawable drawable, int nullVisibility) {
        v.setImageDrawable(drawable);
        if (drawable == null) {
            v.setVisibility(nullVisibility);
            return;
        }
        v.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public CharSequence m2344c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        CharSequence query = C0490c.m2325a(cursor, "suggest_intent_query");
        if (query != null) {
            return query;
        }
        if (this.f1297l.shouldRewriteQueryFromData()) {
            String data = C0490c.m2325a(cursor, "suggest_intent_data");
            if (data != null) {
                return data;
            }
        }
        if (this.f1297l.shouldRewriteQueryFromText()) {
            String text1 = C0490c.m2325a(cursor, "suggest_text_1");
            if (text1 != null) {
                return text1;
            }
        }
        return null;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        try {
            view = super.getView(position, convertView, parent);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            view = m2340a(this.d, this.c, parent);
            if (view != null) {
                ((C0489a) view.getTag()).f1290a.setText(e.toString());
            }
        }
        return view;
    }

    private Drawable m2323a(String drawableId) {
        Drawable drawable;
        if (drawableId == null || drawableId.length() == 0 || ITKSvc.CODEREVISION.equals(drawableId)) {
            return null;
        }
        try {
            int resourceId = Integer.parseInt(drawableId);
            String drawableUri = "android.resource://" + this.f1298m.getPackageName() + "/" + resourceId;
            drawable = m2331b(drawableUri);
            if (drawable != null) {
                return drawable;
            }
            drawable = this.f1298m.getResources().getDrawable(resourceId);
            m2328a(drawableUri, drawable);
            return drawable;
        } catch (NumberFormatException e) {
            drawable = m2331b(drawableId);
            if (drawable != null) {
                return drawable;
            }
            drawable = m2330b(Uri.parse(drawableId));
            m2328a(drawableId, drawable);
            return drawable;
        } catch (NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + drawableId);
            return null;
        }
    }

    private Drawable m2330b(Uri uri) {
        InputStream stream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return m2339a(uri);
            }
            stream = this.f1298m.getContentResolver().openInputStream(uri);
            if (stream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(stream, null);
            try {
                stream.close();
                return createFromStream;
            } catch (IOException ex) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, ex);
                return createFromStream;
            }
        } catch (NotFoundException e) {
            throw new FileNotFoundException("Resource does not exist: " + uri);
        } catch (FileNotFoundException fnfe) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + fnfe.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                stream.close();
            } catch (IOException ex2) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, ex2);
            }
        }
    }

    private Drawable m2331b(String resourceUri) {
        ConstantState cached = (ConstantState) this.f1299n.get(resourceUri);
        if (cached == null) {
            return null;
        }
        return cached.newDrawable();
    }

    private void m2328a(String resourceUri, Drawable drawable) {
        if (drawable != null) {
            this.f1299n.put(resourceUri, drawable.getConstantState());
        }
    }

    private Drawable m2336g(Cursor cursor) {
        Drawable drawable = m2322a(this.f1297l.getSearchActivity());
        return drawable != null ? drawable : this.d.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable m2322a(ComponentName component) {
        String componentIconKey = component.flattenToShortString();
        if (this.f1299n.containsKey(componentIconKey)) {
            ConstantState cached = (ConstantState) this.f1299n.get(componentIconKey);
            if (cached == null) {
                return null;
            }
            return cached.newDrawable(this.f1298m.getResources());
        }
        Drawable drawable = m2329b(component);
        this.f1299n.put(componentIconKey, drawable == null ? null : drawable.getConstantState());
        return drawable;
    }

    private Drawable m2329b(ComponentName component) {
        PackageManager pm = this.d.getPackageManager();
        try {
            ActivityInfo activityInfo = pm.getActivityInfo(component, Cast.MAX_NAMESPACE_LENGTH);
            int iconId = activityInfo.getIconResource();
            if (iconId == 0) {
                return null;
            }
            Drawable drawable = pm.getDrawable(component.getPackageName(), iconId, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconId + " for " + component.flattenToShortString());
            return null;
        } catch (NameNotFoundException ex) {
            Log.w("SuggestionsAdapter", ex.toString());
            return null;
        }
    }

    public static String m2325a(Cursor cursor, String columnName) {
        return C0490c.m2324a(cursor, cursor.getColumnIndex(columnName));
    }

    private static String m2324a(Cursor cursor, int col) {
        String str = null;
        if (col != -1) {
            try {
                str = cursor.getString(col);
            } catch (Exception e) {
                Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            }
        }
        return str;
    }

    Drawable m2339a(Uri uri) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources r = this.d.getPackageManager().getResourcesForApplication(authority);
            List path = uri.getPathSegments();
            if (path == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int id;
            int len = path.size();
            if (len == 1) {
                try {
                    id = Integer.parseInt((String) path.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (len == 2) {
                id = r.getIdentifier((String) path.get(1), (String) path.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (id != 0) {
                return r.getDrawable(id);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor m2337a(SearchableInfo searchable, String query, int limit) {
        if (searchable == null) {
            return null;
        }
        String authority = searchable.getSuggestAuthority();
        if (authority == null) {
            return null;
        }
        Builder uriBuilder = new Builder().scheme("content").authority(authority).query("").fragment("");
        String contentPath = searchable.getSuggestPath();
        if (contentPath != null) {
            uriBuilder.appendEncodedPath(contentPath);
        }
        uriBuilder.appendPath("search_suggest_query");
        String selection = searchable.getSuggestSelection();
        String[] selArgs = null;
        if (selection != null) {
            selArgs = new String[]{query};
        } else {
            uriBuilder.appendPath(query);
        }
        if (limit > 0) {
            uriBuilder.appendQueryParameter("limit", String.valueOf(limit));
        }
        return this.d.getContentResolver().query(uriBuilder.build(), null, selection, selArgs, null);
    }
}
