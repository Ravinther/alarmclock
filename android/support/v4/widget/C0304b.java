package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* renamed from: android.support.v4.widget.b */
class C0304b extends Filter {
    C0302a f579a;

    /* renamed from: android.support.v4.widget.b.a */
    interface C0302a {
        Cursor m1298a();

        Cursor m1299a(CharSequence charSequence);

        void m1300a(Cursor cursor);

        CharSequence m1301c(Cursor cursor);
    }

    C0304b(C0302a client) {
        this.f579a = client;
    }

    public CharSequence convertResultToString(Object resultValue) {
        return this.f579a.m1301c((Cursor) resultValue);
    }

    protected FilterResults performFiltering(CharSequence constraint) {
        Cursor cursor = this.f579a.m1299a(constraint);
        FilterResults results = new FilterResults();
        if (cursor != null) {
            results.count = cursor.getCount();
            results.values = cursor;
        } else {
            results.count = 0;
            results.values = null;
        }
        return results;
    }

    protected void publishResults(CharSequence constraint, FilterResults results) {
        Cursor oldCursor = this.f579a.m1298a();
        if (results.values != null && results.values != oldCursor) {
            this.f579a.m1300a((Cursor) results.values);
        }
    }
}
