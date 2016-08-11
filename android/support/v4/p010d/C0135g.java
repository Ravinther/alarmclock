package android.support.v4.p010d;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.d.g */
abstract class C0135g {
    C0145b f336b;
    C0146c f337c;
    C0148e f338d;

    /* renamed from: android.support.v4.d.g.a */
    final class C0144a implements Iterator {
        final int f358a;
        int f359b;
        int f360c;
        boolean f361d;
        final /* synthetic */ C0135g f362e;

        C0144a(C0135g c0135g, int offset) {
            this.f362e = c0135g;
            this.f361d = false;
            this.f358a = offset;
            this.f359b = c0135g.m506a();
        }

        public boolean hasNext() {
            return this.f360c < this.f359b;
        }

        public Object next() {
            Object res = this.f362e.m508a(this.f360c, this.f358a);
            this.f360c++;
            this.f361d = true;
            return res;
        }

        public void remove() {
            if (this.f361d) {
                this.f360c--;
                this.f359b--;
                this.f361d = false;
                this.f362e.m510a(this.f360c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: android.support.v4.d.g.b */
    final class C0145b implements Set {
        final /* synthetic */ C0135g f363a;

        C0145b(C0135g c0135g) {
            this.f363a = c0135g;
        }

        public /* synthetic */ boolean add(Object x0) {
            return m559a((Entry) x0);
        }

        public boolean m559a(Entry object) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            int oldSize = this.f363a.m506a();
            for (Entry entry : collection) {
                this.f363a.m511a(entry.getKey(), entry.getValue());
            }
            return oldSize != this.f363a.m506a();
        }

        public void clear() {
            this.f363a.m516c();
        }

        public boolean contains(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            Entry e = (Entry) o;
            int index = this.f363a.m507a(e.getKey());
            if (index >= 0) {
                return C0139b.m545a(this.f363a.m508a(index, 1), e.getValue());
            }
            return false;
        }

        public boolean containsAll(Collection collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f363a.m506a() == 0;
        }

        public Iterator iterator() {
            return new C0147d(this.f363a);
        }

        public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.f363a.m506a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public Object[] toArray(Object[] array) {
            throw new UnsupportedOperationException();
        }

        public boolean equals(Object object) {
            return C0135g.m503a((Set) this, object);
        }

        public int hashCode() {
            int result = 0;
            for (int i = this.f363a.m506a() - 1; i >= 0; i--) {
                Object key = this.f363a.m508a(i, 0);
                Object value = this.f363a.m508a(i, 1);
                result += (value == null ? 0 : value.hashCode()) ^ (key == null ? 0 : key.hashCode());
            }
            return result;
        }
    }

    /* renamed from: android.support.v4.d.g.c */
    final class C0146c implements Set {
        final /* synthetic */ C0135g f364a;

        C0146c(C0135g c0135g) {
            this.f364a = c0135g;
        }

        public boolean add(Object object) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f364a.m516c();
        }

        public boolean contains(Object object) {
            return this.f364a.m507a(object) >= 0;
        }

        public boolean containsAll(Collection collection) {
            return C0135g.m502a(this.f364a.m514b(), collection);
        }

        public boolean isEmpty() {
            return this.f364a.m506a() == 0;
        }

        public Iterator iterator() {
            return new C0144a(this.f364a, 0);
        }

        public boolean remove(Object object) {
            int index = this.f364a.m507a(object);
            if (index < 0) {
                return false;
            }
            this.f364a.m510a(index);
            return true;
        }

        public boolean removeAll(Collection collection) {
            return C0135g.m504b(this.f364a.m514b(), collection);
        }

        public boolean retainAll(Collection collection) {
            return C0135g.m505c(this.f364a.m514b(), collection);
        }

        public int size() {
            return this.f364a.m506a();
        }

        public Object[] toArray() {
            return this.f364a.m515b(0);
        }

        public Object[] toArray(Object[] array) {
            return this.f364a.m512a(array, 0);
        }

        public boolean equals(Object object) {
            return C0135g.m503a((Set) this, object);
        }

        public int hashCode() {
            int result = 0;
            for (int i = this.f364a.m506a() - 1; i >= 0; i--) {
                Object obj = this.f364a.m508a(i, 0);
                result += obj == null ? 0 : obj.hashCode();
            }
            return result;
        }
    }

    /* renamed from: android.support.v4.d.g.d */
    final class C0147d implements Iterator, Entry {
        int f365a;
        int f366b;
        boolean f367c;
        final /* synthetic */ C0135g f368d;

        public /* synthetic */ Object next() {
            return m560a();
        }

        C0147d(C0135g c0135g) {
            this.f368d = c0135g;
            this.f367c = false;
            this.f365a = c0135g.m506a() - 1;
            this.f366b = -1;
        }

        public boolean hasNext() {
            return this.f366b < this.f365a;
        }

        public Entry m560a() {
            this.f366b++;
            this.f367c = true;
            return this;
        }

        public void remove() {
            if (this.f367c) {
                this.f368d.m510a(this.f366b);
                this.f366b--;
                this.f365a--;
                this.f367c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public Object getKey() {
            if (this.f367c) {
                return this.f368d.m508a(this.f366b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public Object getValue() {
            if (this.f367c) {
                return this.f368d.m508a(this.f366b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public Object setValue(Object object) {
            if (this.f367c) {
                return this.f368d.m509a(this.f366b, object);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object o) {
            boolean z = true;
            if (!this.f367c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(o instanceof Entry)) {
                return false;
            } else {
                Entry e = (Entry) o;
                if (!(C0139b.m545a(e.getKey(), this.f368d.m508a(this.f366b, 0)) && C0139b.m545a(e.getValue(), this.f368d.m508a(this.f366b, 1)))) {
                    z = false;
                }
                return z;
            }
        }

        public final int hashCode() {
            int i = 0;
            if (this.f367c) {
                Object key = this.f368d.m508a(this.f366b, 0);
                Object value = this.f368d.m508a(this.f366b, 1);
                int hashCode = key == null ? 0 : key.hashCode();
                if (value != null) {
                    i = value.hashCode();
                }
                return i ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: android.support.v4.d.g.e */
    final class C0148e implements Collection {
        final /* synthetic */ C0135g f369a;

        C0148e(C0135g c0135g) {
            this.f369a = c0135g;
        }

        public boolean add(Object object) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.f369a.m516c();
        }

        public boolean contains(Object object) {
            return this.f369a.m513b(object) >= 0;
        }

        public boolean containsAll(Collection collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return this.f369a.m506a() == 0;
        }

        public Iterator iterator() {
            return new C0144a(this.f369a, 1);
        }

        public boolean remove(Object object) {
            int index = this.f369a.m513b(object);
            if (index < 0) {
                return false;
            }
            this.f369a.m510a(index);
            return true;
        }

        public boolean removeAll(Collection collection) {
            int N = this.f369a.m506a();
            boolean changed = false;
            int i = 0;
            while (i < N) {
                if (collection.contains(this.f369a.m508a(i, 1))) {
                    this.f369a.m510a(i);
                    i--;
                    N--;
                    changed = true;
                }
                i++;
            }
            return changed;
        }

        public boolean retainAll(Collection collection) {
            int N = this.f369a.m506a();
            boolean changed = false;
            int i = 0;
            while (i < N) {
                if (!collection.contains(this.f369a.m508a(i, 1))) {
                    this.f369a.m510a(i);
                    i--;
                    N--;
                    changed = true;
                }
                i++;
            }
            return changed;
        }

        public int size() {
            return this.f369a.m506a();
        }

        public Object[] toArray() {
            return this.f369a.m515b(1);
        }

        public Object[] toArray(Object[] array) {
            return this.f369a.m512a(array, 1);
        }
    }

    protected abstract int m506a();

    protected abstract int m507a(Object obj);

    protected abstract Object m508a(int i, int i2);

    protected abstract Object m509a(int i, Object obj);

    protected abstract void m510a(int i);

    protected abstract void m511a(Object obj, Object obj2);

    protected abstract int m513b(Object obj);

    protected abstract Map m514b();

    protected abstract void m516c();

    C0135g() {
    }

    public static boolean m502a(Map map, Collection collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static boolean m504b(Map map, Collection collection) {
        int oldSize = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return oldSize != map.size();
    }

    public static boolean m505c(Map map, Collection collection) {
        int oldSize = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return oldSize != map.size();
    }

    public Object[] m515b(int offset) {
        int N = m506a();
        Object[] result = new Object[N];
        for (int i = 0; i < N; i++) {
            result[i] = m508a(i, offset);
        }
        return result;
    }

    public Object[] m512a(Object[] array, int offset) {
        int N = m506a();
        if (array.length < N) {
            array = (Object[]) Array.newInstance(array.getClass().getComponentType(), N);
        }
        for (int i = 0; i < N; i++) {
            array[i] = m508a(i, offset);
        }
        if (array.length > N) {
            array[N] = null;
        }
        return array;
    }

    public static boolean m503a(Set set, Object object) {
        boolean z = true;
        if (set == object) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        Set s = (Set) object;
        try {
            if (!(set.size() == s.size() && set.containsAll(s))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public Set m517d() {
        if (this.f336b == null) {
            this.f336b = new C0145b(this);
        }
        return this.f336b;
    }

    public Set m518e() {
        if (this.f337c == null) {
            this.f337c = new C0146c(this);
        }
        return this.f337c;
    }

    public Collection m519f() {
        if (this.f338d == null) {
            this.f338d = new C0148e(this);
        }
        return this.f338d;
    }
}
