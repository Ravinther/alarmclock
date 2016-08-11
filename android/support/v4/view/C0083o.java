package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.view.o */
public abstract class C0083o {
    private DataSetObservable f239a;

    public abstract boolean m355a(View view, Object obj);

    public abstract int m356b();

    public C0083o() {
        this.f239a = new DataSetObservable();
    }

    public void m353a(ViewGroup container) {
        m351a((View) container);
    }

    public Object m348a(ViewGroup container, int position) {
        return m347a((View) container, position);
    }

    public void m354a(ViewGroup container, int position, Object object) {
        m352a((View) container, position, object);
    }

    public void m361b(ViewGroup container, int position, Object object) {
        m359b((View) container, position, object);
    }

    public void m360b(ViewGroup container) {
        m358b((View) container);
    }

    public void m351a(View container) {
    }

    public Object m347a(View container, int position) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void m352a(View container, int position, Object object) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void m359b(View container, int position, Object object) {
    }

    public void m358b(View container) {
    }

    public Parcelable m346a() {
        return null;
    }

    public void m350a(Parcelable state, ClassLoader loader) {
    }

    public int m345a(Object object) {
        return -1;
    }

    public void m363c() {
        this.f239a.notifyChanged();
    }

    public void m349a(DataSetObserver observer) {
        this.f239a.registerObserver(observer);
    }

    public void m357b(DataSetObserver observer) {
        this.f239a.unregisterObserver(observer);
    }

    public CharSequence m362c(int position) {
        return null;
    }

    public float m364d(int position) {
        return 1.0f;
    }
}
