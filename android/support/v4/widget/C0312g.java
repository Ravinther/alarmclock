package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.widget.g */
public abstract class C0312g extends C0303a {
    private int f582j;
    private int f583k;
    private LayoutInflater f584l;

    public C0312g(Context context, int layout, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        this.f583k = layout;
        this.f582j = layout;
        this.f584l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View m1350a(Context context, Cursor cursor, ViewGroup parent) {
        return this.f584l.inflate(this.f582j, parent, false);
    }

    public View m1351b(Context context, Cursor cursor, ViewGroup parent) {
        return this.f584l.inflate(this.f583k, parent, false);
    }
}
