package android.support.v4.p010d;

/* renamed from: android.support.v4.d.e */
public class C0142e implements Cloneable {
    private static final Object f353a;
    private boolean f354b;
    private long[] f355c;
    private Object[] f356d;
    private int f357e;

    public /* synthetic */ Object clone() {
        return m552a();
    }

    static {
        f353a = new Object();
    }

    public C0142e() {
        this(10);
    }

    public C0142e(int initialCapacity) {
        this.f354b = false;
        if (initialCapacity == 0) {
            this.f355c = C0139b.f349b;
            this.f356d = C0139b.f350c;
        } else {
            initialCapacity = C0139b.m546b(initialCapacity);
            this.f355c = new long[initialCapacity];
            this.f356d = new Object[initialCapacity];
        }
        this.f357e = 0;
    }

    public C0142e m552a() {
        C0142e clone = null;
        try {
            clone = (C0142e) super.clone();
            clone.f355c = (long[]) this.f355c.clone();
            clone.f356d = (Object[]) this.f356d.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            return clone;
        }
    }

    public Object m553a(long key) {
        return m554a(key, null);
    }

    public Object m554a(long key, Object valueIfKeyNotFound) {
        int i = C0139b.m544a(this.f355c, this.f357e, key);
        return (i < 0 || this.f356d[i] == f353a) ? valueIfKeyNotFound : this.f356d[i];
    }

    private void m550d() {
        int n = this.f357e;
        int o = 0;
        long[] keys = this.f355c;
        Object[] values = this.f356d;
        for (int i = 0; i < n; i++) {
            Object val = values[i];
            if (val != f353a) {
                if (i != o) {
                    keys[o] = keys[i];
                    values[o] = val;
                    values[i] = null;
                }
                o++;
            }
        }
        this.f354b = false;
        this.f357e = o;
    }

    public void m557b(long key, Object value) {
        int i = C0139b.m544a(this.f355c, this.f357e, key);
        if (i >= 0) {
            this.f356d[i] = value;
            return;
        }
        i ^= -1;
        if (i >= this.f357e || this.f356d[i] != f353a) {
            if (this.f354b && this.f357e >= this.f355c.length) {
                m550d();
                i = C0139b.m544a(this.f355c, this.f357e, key) ^ -1;
            }
            if (this.f357e >= this.f355c.length) {
                int n = C0139b.m546b(this.f357e + 1);
                long[] nkeys = new long[n];
                Object[] nvalues = new Object[n];
                System.arraycopy(this.f355c, 0, nkeys, 0, this.f355c.length);
                System.arraycopy(this.f356d, 0, nvalues, 0, this.f356d.length);
                this.f355c = nkeys;
                this.f356d = nvalues;
            }
            if (this.f357e - i != 0) {
                System.arraycopy(this.f355c, i, this.f355c, i + 1, this.f357e - i);
                System.arraycopy(this.f356d, i, this.f356d, i + 1, this.f357e - i);
            }
            this.f355c[i] = key;
            this.f356d[i] = value;
            this.f357e++;
            return;
        }
        this.f355c[i] = key;
        this.f356d[i] = value;
    }

    public int m555b() {
        if (this.f354b) {
            m550d();
        }
        return this.f357e;
    }

    public long m551a(int index) {
        if (this.f354b) {
            m550d();
        }
        return this.f355c[index];
    }

    public Object m556b(int index) {
        if (this.f354b) {
            m550d();
        }
        return this.f356d[index];
    }

    public void m558c() {
        int n = this.f357e;
        Object[] values = this.f356d;
        for (int i = 0; i < n; i++) {
            values[i] = null;
        }
        this.f357e = 0;
        this.f354b = false;
    }

    public String toString() {
        if (m555b() <= 0) {
            return "{}";
        }
        StringBuilder buffer = new StringBuilder(this.f357e * 28);
        buffer.append('{');
        for (int i = 0; i < this.f357e; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            buffer.append(m551a(i));
            buffer.append('=');
            C0142e value = m556b(i);
            if (value != this) {
                buffer.append(value);
            } else {
                buffer.append("(this Map)");
            }
        }
        buffer.append('}');
        return buffer.toString();
    }
}
