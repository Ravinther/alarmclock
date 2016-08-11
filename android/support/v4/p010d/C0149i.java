package android.support.v4.p010d;

/* renamed from: android.support.v4.d.i */
public class C0149i implements Cloneable {
    private static final Object f370a;
    private boolean f371b;
    private int[] f372c;
    private Object[] f373d;
    private int f374e;

    public /* synthetic */ Object clone() {
        return m562a();
    }

    static {
        f370a = new Object();
    }

    public C0149i() {
        this(10);
    }

    public C0149i(int initialCapacity) {
        this.f371b = false;
        if (initialCapacity == 0) {
            this.f372c = C0139b.f348a;
            this.f373d = C0139b.f350c;
        } else {
            initialCapacity = C0139b.m542a(initialCapacity);
            this.f372c = new int[initialCapacity];
            this.f373d = new Object[initialCapacity];
        }
        this.f374e = 0;
    }

    public C0149i m562a() {
        C0149i clone = null;
        try {
            clone = (C0149i) super.clone();
            clone.f372c = (int[]) this.f372c.clone();
            clone.f373d = (Object[]) this.f373d.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            return clone;
        }
    }

    public Object m563a(int key) {
        return m564a(key, null);
    }

    public Object m564a(int key, Object valueIfKeyNotFound) {
        int i = C0139b.m543a(this.f372c, this.f374e, key);
        return (i < 0 || this.f373d[i] == f370a) ? valueIfKeyNotFound : this.f373d[i];
    }

    public void m566b(int key) {
        int i = C0139b.m543a(this.f372c, this.f374e, key);
        if (i >= 0 && this.f373d[i] != f370a) {
            this.f373d[i] = f370a;
            this.f371b = true;
        }
    }

    public void m569c(int key) {
        m566b(key);
    }

    private void m561d() {
        int n = this.f374e;
        int o = 0;
        int[] keys = this.f372c;
        Object[] values = this.f373d;
        for (int i = 0; i < n; i++) {
            Object val = values[i];
            if (val != f370a) {
                if (i != o) {
                    keys[o] = keys[i];
                    values[o] = val;
                    values[i] = null;
                }
                o++;
            }
        }
        this.f371b = false;
        this.f374e = o;
    }

    public void m567b(int key, Object value) {
        int i = C0139b.m543a(this.f372c, this.f374e, key);
        if (i >= 0) {
            this.f373d[i] = value;
            return;
        }
        i ^= -1;
        if (i >= this.f374e || this.f373d[i] != f370a) {
            if (this.f371b && this.f374e >= this.f372c.length) {
                m561d();
                i = C0139b.m543a(this.f372c, this.f374e, key) ^ -1;
            }
            if (this.f374e >= this.f372c.length) {
                int n = C0139b.m542a(this.f374e + 1);
                int[] nkeys = new int[n];
                Object[] nvalues = new Object[n];
                System.arraycopy(this.f372c, 0, nkeys, 0, this.f372c.length);
                System.arraycopy(this.f373d, 0, nvalues, 0, this.f373d.length);
                this.f372c = nkeys;
                this.f373d = nvalues;
            }
            if (this.f374e - i != 0) {
                System.arraycopy(this.f372c, i, this.f372c, i + 1, this.f374e - i);
                System.arraycopy(this.f373d, i, this.f373d, i + 1, this.f374e - i);
            }
            this.f372c[i] = key;
            this.f373d[i] = value;
            this.f374e++;
            return;
        }
        this.f372c[i] = key;
        this.f373d[i] = value;
    }

    public int m565b() {
        if (this.f371b) {
            m561d();
        }
        return this.f374e;
    }

    public int m570d(int index) {
        if (this.f371b) {
            m561d();
        }
        return this.f372c[index];
    }

    public Object m571e(int index) {
        if (this.f371b) {
            m561d();
        }
        return this.f373d[index];
    }

    public void m568c() {
        int n = this.f374e;
        Object[] values = this.f373d;
        for (int i = 0; i < n; i++) {
            values[i] = null;
        }
        this.f374e = 0;
        this.f371b = false;
    }

    public String toString() {
        if (m565b() <= 0) {
            return "{}";
        }
        StringBuilder buffer = new StringBuilder(this.f374e * 28);
        buffer.append('{');
        for (int i = 0; i < this.f374e; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            buffer.append(m570d(i));
            buffer.append('=');
            C0149i value = m571e(i);
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
