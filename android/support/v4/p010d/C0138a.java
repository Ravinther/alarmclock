package android.support.v4.p010d;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.d.a */
public class C0138a extends C0137h implements Map {
    C0135g f347a;

    /* renamed from: android.support.v4.d.a.1 */
    class C01361 extends C0135g {
        final /* synthetic */ C0138a f339a;

        C01361(C0138a c0138a) {
            this.f339a = c0138a;
        }

        protected int m520a() {
            return this.f339a.h;
        }

        protected Object m522a(int index, int offset) {
            return this.f339a.g[(index << 1) + offset];
        }

        protected int m521a(Object key) {
            return this.f339a.m532a(key);
        }

        protected int m526b(Object value) {
            return this.f339a.m536b(value);
        }

        protected Map m527b() {
            return this.f339a;
        }

        protected void m525a(Object key, Object value) {
            this.f339a.put(key, value);
        }

        protected Object m523a(int index, Object value) {
            return this.f339a.m534a(index, value);
        }

        protected void m524a(int index) {
            this.f339a.m539d(index);
        }

        protected void m528c() {
            this.f339a.clear();
        }
    }

    private C0135g m540b() {
        if (this.f347a == null) {
            this.f347a = new C01361(this);
        }
        return this.f347a;
    }

    public void putAll(Map map) {
        m535a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public boolean m541a(Collection collection) {
        return C0135g.m505c(this, collection);
    }

    public Set entrySet() {
        return m540b().m517d();
    }

    public Set keySet() {
        return m540b().m518e();
    }

    public Collection values() {
        return m540b().m519f();
    }
}
