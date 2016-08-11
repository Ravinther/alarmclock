package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.widget.C0304b.C0302a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/* renamed from: android.support.v4.widget.a */
public abstract class C0303a extends BaseAdapter implements C0302a, Filterable {
    protected boolean f570a;
    protected boolean f571b;
    protected Cursor f572c;
    protected Context f573d;
    protected int f574e;
    protected C0300a f575f;
    protected DataSetObserver f576g;
    protected C0304b f577h;
    protected FilterQueryProvider f578i;

    /* renamed from: android.support.v4.widget.a.a */
    private class C0300a extends ContentObserver {
        final /* synthetic */ C0303a f568a;

        public C0300a(C0303a c0303a) {
            this.f568a = c0303a;
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean selfChange) {
            this.f568a.m1310b();
        }
    }

    /* renamed from: android.support.v4.widget.a.b */
    private class C0301b extends DataSetObserver {
        final /* synthetic */ C0303a f569a;

        private C0301b(C0303a c0303a) {
            this.f569a = c0303a;
        }

        public void onChanged() {
            this.f569a.f570a = true;
            this.f569a.notifyDataSetChanged();
        }

        public void onInvalidated() {
            this.f569a.f570a = false;
            this.f569a.notifyDataSetInvalidated();
        }
    }

    public abstract View m1304a(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void m1307a(View view, Context context, Cursor cursor);

    public C0303a(Context context, Cursor c, boolean autoRequery) {
        m1305a(context, c, autoRequery ? 1 : 2);
    }

    void m1305a(Context context, Cursor c, int flags) {
        boolean cursorPresent = true;
        if ((flags & 1) == 1) {
            flags |= 2;
            this.f571b = true;
        } else {
            this.f571b = false;
        }
        if (c == null) {
            cursorPresent = false;
        }
        this.f572c = c;
        this.f570a = cursorPresent;
        this.f573d = context;
        this.f574e = cursorPresent ? c.getColumnIndexOrThrow("_id") : -1;
        if ((flags & 2) == 2) {
            this.f575f = new C0300a(this);
            this.f576g = new C0301b();
        } else {
            this.f575f = null;
            this.f576g = null;
        }
        if (cursorPresent) {
            if (this.f575f != null) {
                c.registerContentObserver(this.f575f);
            }
            if (this.f576g != null) {
                c.registerDataSetObserver(this.f576g);
            }
        }
    }

    public Cursor m1302a() {
        return this.f572c;
    }

    public int getCount() {
        if (!this.f570a || this.f572c == null) {
            return 0;
        }
        return this.f572c.getCount();
    }

    public Object getItem(int position) {
        if (!this.f570a || this.f572c == null) {
            return null;
        }
        this.f572c.moveToPosition(position);
        return this.f572c;
    }

    public long getItemId(int position) {
        if (this.f570a && this.f572c != null && this.f572c.moveToPosition(position)) {
            return this.f572c.getLong(this.f574e);
        }
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (!this.f570a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f572c.moveToPosition(position)) {
            View v;
            if (convertView == null) {
                v = m1304a(this.f573d, this.f572c, parent);
            } else {
                v = convertView;
            }
            m1307a(v, this.f573d, this.f572c);
            return v;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + position);
        }
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (!this.f570a) {
            return null;
        }
        View v;
        this.f572c.moveToPosition(position);
        if (convertView == null) {
            v = m1309b(this.f573d, this.f572c, parent);
        } else {
            v = convertView;
        }
        m1307a(v, this.f573d, this.f572c);
        return v;
    }

    public View m1309b(Context context, Cursor cursor, ViewGroup parent) {
        return m1304a(context, cursor, parent);
    }

    public void m1306a(Cursor cursor) {
        Cursor old = m1308b(cursor);
        if (old != null) {
            old.close();
        }
    }

    public Cursor m1308b(Cursor newCursor) {
        if (newCursor == this.f572c) {
            return null;
        }
        Cursor oldCursor = this.f572c;
        if (oldCursor != null) {
            if (this.f575f != null) {
                oldCursor.unregisterContentObserver(this.f575f);
            }
            if (this.f576g != null) {
                oldCursor.unregisterDataSetObserver(this.f576g);
            }
        }
        this.f572c = newCursor;
        if (newCursor != null) {
            if (this.f575f != null) {
                newCursor.registerContentObserver(this.f575f);
            }
            if (this.f576g != null) {
                newCursor.registerDataSetObserver(this.f576g);
            }
            this.f574e = newCursor.getColumnIndexOrThrow("_id");
            this.f570a = true;
            notifyDataSetChanged();
            return oldCursor;
        }
        this.f574e = -1;
        this.f570a = false;
        notifyDataSetInvalidated();
        return oldCursor;
    }

    public CharSequence m1311c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor m1303a(CharSequence constraint) {
        if (this.f578i != null) {
            return this.f578i.runQuery(constraint);
        }
        return this.f572c;
    }

    public Filter getFilter() {
        if (this.f577h == null) {
            this.f577h = new C0304b(this);
        }
        return this.f577h;
    }

    protected void m1310b() {
        if (this.f571b && this.f572c != null && !this.f572c.isClosed()) {
            this.f570a = this.f572c.requery();
        }
    }
}
