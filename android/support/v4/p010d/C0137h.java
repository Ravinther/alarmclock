package android.support.v4.p010d;

import java.util.Map;

/* renamed from: android.support.v4.d.h */
public class C0137h {
    static Object[] f340b;
    static int f341c;
    static Object[] f342d;
    static int f343e;
    int[] f344f;
    Object[] f345g;
    int f346h;

    int m533a(Object key, int hash) {
        int N = this.f346h;
        if (N == 0) {
            return -1;
        }
        int index = C0139b.m543a(this.f344f, N, hash);
        if (index < 0 || key.equals(this.f345g[index << 1])) {
            return index;
        }
        int end = index + 1;
        while (end < N && this.f344f[end] == hash) {
            if (key.equals(this.f345g[end << 1])) {
                return end;
            }
            end++;
        }
        int i = index - 1;
        while (i >= 0 && this.f344f[i] == hash) {
            if (key.equals(this.f345g[i << 1])) {
                return i;
            }
            i--;
        }
        return end ^ -1;
    }

    int m531a() {
        int N = this.f346h;
        if (N == 0) {
            return -1;
        }
        int index = C0139b.m543a(this.f344f, N, 0);
        if (index < 0 || this.f345g[index << 1] == null) {
            return index;
        }
        int end = index + 1;
        while (end < N && this.f344f[end] == 0) {
            if (this.f345g[end << 1] == null) {
                return end;
            }
            end++;
        }
        int i = index - 1;
        while (i >= 0 && this.f344f[i] == 0) {
            if (this.f345g[i << 1] == null) {
                return i;
            }
            i--;
        }
        return end ^ -1;
    }

    private void m530e(int size) {
        Object[] array;
        if (size == 8) {
            synchronized (C0138a.class) {
                if (f342d != null) {
                    array = f342d;
                    this.f345g = array;
                    f342d = (Object[]) array[0];
                    this.f344f = (int[]) array[1];
                    array[1] = null;
                    array[0] = null;
                    f343e--;
                    return;
                }
            }
        } else if (size == 4) {
            synchronized (C0138a.class) {
                if (f340b != null) {
                    array = f340b;
                    this.f345g = array;
                    f340b = (Object[]) array[0];
                    this.f344f = (int[]) array[1];
                    array[1] = null;
                    array[0] = null;
                    f341c--;
                    return;
                }
            }
        }
        this.f344f = new int[size];
        this.f345g = new Object[(size << 1)];
    }

    private static void m529a(int[] hashes, Object[] array, int size) {
        int i;
        if (hashes.length == 8) {
            synchronized (C0138a.class) {
                if (f343e < 10) {
                    array[0] = f342d;
                    array[1] = hashes;
                    for (i = (size << 1) - 1; i >= 2; i--) {
                        array[i] = null;
                    }
                    f342d = array;
                    f343e++;
                }
            }
        } else if (hashes.length == 4) {
            synchronized (C0138a.class) {
                if (f341c < 10) {
                    array[0] = f340b;
                    array[1] = hashes;
                    for (i = (size << 1) - 1; i >= 2; i--) {
                        array[i] = null;
                    }
                    f340b = array;
                    f341c++;
                }
            }
        }
    }

    public C0137h() {
        this.f344f = C0139b.f348a;
        this.f345g = C0139b.f350c;
        this.f346h = 0;
    }

    public void clear() {
        if (this.f346h != 0) {
            C0137h.m529a(this.f344f, this.f345g, this.f346h);
            this.f344f = C0139b.f348a;
            this.f345g = C0139b.f350c;
            this.f346h = 0;
        }
    }

    public void m535a(int minimumCapacity) {
        if (this.f344f.length < minimumCapacity) {
            int[] ohashes = this.f344f;
            Object[] oarray = this.f345g;
            m530e(minimumCapacity);
            if (this.f346h > 0) {
                System.arraycopy(ohashes, 0, this.f344f, 0, this.f346h);
                System.arraycopy(oarray, 0, this.f345g, 0, this.f346h << 1);
            }
            C0137h.m529a(ohashes, oarray, this.f346h);
        }
    }

    public boolean containsKey(Object key) {
        return m532a(key) >= 0;
    }

    public int m532a(Object key) {
        return key == null ? m531a() : m533a(key, key.hashCode());
    }

    int m536b(Object value) {
        int N = this.f346h * 2;
        Object[] array = this.f345g;
        int i;
        if (value == null) {
            for (i = 1; i < N; i += 2) {
                if (array[i] == null) {
                    return i >> 1;
                }
            }
        } else {
            for (i = 1; i < N; i += 2) {
                if (value.equals(array[i])) {
                    return i >> 1;
                }
            }
        }
        return -1;
    }

    public boolean containsValue(Object value) {
        return m536b(value) >= 0;
    }

    public Object get(Object key) {
        int index = m532a(key);
        return index >= 0 ? this.f345g[(index << 1) + 1] : null;
    }

    public Object m537b(int index) {
        return this.f345g[index << 1];
    }

    public Object m538c(int index) {
        return this.f345g[(index << 1) + 1];
    }

    public Object m534a(int index, Object value) {
        index = (index << 1) + 1;
        Object old = this.f345g[index];
        this.f345g[index] = value;
        return old;
    }

    public boolean isEmpty() {
        return this.f346h <= 0;
    }

    public Object put(Object key, Object value) {
        int hash;
        int index;
        int n = 8;
        if (key == null) {
            hash = 0;
            index = m531a();
        } else {
            hash = key.hashCode();
            index = m533a(key, hash);
        }
        if (index >= 0) {
            index = (index << 1) + 1;
            Object old = this.f345g[index];
            this.f345g[index] = value;
            return old;
        }
        index ^= -1;
        if (this.f346h >= this.f344f.length) {
            if (this.f346h >= 8) {
                n = this.f346h + (this.f346h >> 1);
            } else if (this.f346h < 4) {
                n = 4;
            }
            int[] ohashes = this.f344f;
            Object[] oarray = this.f345g;
            m530e(n);
            if (this.f344f.length > 0) {
                System.arraycopy(ohashes, 0, this.f344f, 0, ohashes.length);
                System.arraycopy(oarray, 0, this.f345g, 0, oarray.length);
            }
            C0137h.m529a(ohashes, oarray, this.f346h);
        }
        if (index < this.f346h) {
            System.arraycopy(this.f344f, index, this.f344f, index + 1, this.f346h - index);
            System.arraycopy(this.f345g, index << 1, this.f345g, (index + 1) << 1, (this.f346h - index) << 1);
        }
        this.f344f[index] = hash;
        this.f345g[index << 1] = key;
        this.f345g[(index << 1) + 1] = value;
        this.f346h++;
        return null;
    }

    public Object remove(Object key) {
        int index = m532a(key);
        if (index >= 0) {
            return m539d(index);
        }
        return null;
    }

    public Object m539d(int index) {
        int n = 8;
        Object old = this.f345g[(index << 1) + 1];
        if (this.f346h <= 1) {
            C0137h.m529a(this.f344f, this.f345g, this.f346h);
            this.f344f = C0139b.f348a;
            this.f345g = C0139b.f350c;
            this.f346h = 0;
        } else if (this.f344f.length <= 8 || this.f346h >= this.f344f.length / 3) {
            this.f346h--;
            if (index < this.f346h) {
                System.arraycopy(this.f344f, index + 1, this.f344f, index, this.f346h - index);
                System.arraycopy(this.f345g, (index + 1) << 1, this.f345g, index << 1, (this.f346h - index) << 1);
            }
            this.f345g[this.f346h << 1] = null;
            this.f345g[(this.f346h << 1) + 1] = null;
        } else {
            if (this.f346h > 8) {
                n = this.f346h + (this.f346h >> 1);
            }
            int[] ohashes = this.f344f;
            Object[] oarray = this.f345g;
            m530e(n);
            this.f346h--;
            if (index > 0) {
                System.arraycopy(ohashes, 0, this.f344f, 0, index);
                System.arraycopy(oarray, 0, this.f345g, 0, index << 1);
            }
            if (index < this.f346h) {
                System.arraycopy(ohashes, index + 1, this.f344f, index, this.f346h - index);
                System.arraycopy(oarray, (index + 1) << 1, this.f345g, index << 1, (this.f346h - index) << 1);
            }
        }
        return old;
    }

    public int size() {
        return this.f346h;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Map)) {
            return false;
        }
        Map map = (Map) object;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.f346h) {
            try {
                Object key = m537b(i);
                Object mine = m538c(i);
                Object theirs = map.get(key);
                if (mine == null) {
                    if (theirs != null || !map.containsKey(key)) {
                        return false;
                    }
                } else if (!mine.equals(theirs)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] hashes = this.f344f;
        Object[] array = this.f345g;
        int result = 0;
        int i = 0;
        int v = 1;
        int s = this.f346h;
        while (i < s) {
            Object value = array[v];
            result += (value == null ? 0 : value.hashCode()) ^ hashes[i];
            i++;
            v += 2;
        }
        return result;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder buffer = new StringBuilder(this.f346h * 28);
        buffer.append('{');
        for (int i = 0; i < this.f346h; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            C0137h key = m537b(i);
            if (key != this) {
                buffer.append(key);
            } else {
                buffer.append("(this Map)");
            }
            buffer.append('=');
            C0137h value = m538c(i);
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
