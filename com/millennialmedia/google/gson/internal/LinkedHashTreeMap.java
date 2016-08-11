package com.millennialmedia.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedHashTreeMap extends AbstractMap implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final Comparator NATURAL_ORDER;
    Comparator comparator;
    private EntrySet entrySet;
    final Node header;
    private KeySet keySet;
    int modCount;
    int size;
    Node[] table;
    int threshold;

    /* renamed from: com.millennialmedia.google.gson.internal.LinkedHashTreeMap.1 */
    static class C25471 implements Comparator {
        C25471() {
        }

        public int compare(Comparable a, Comparable b) {
            return a.compareTo(b);
        }
    }

    static final class AvlBuilder {
        private int leavesSkipped;
        private int leavesToSkip;
        private int size;
        private Node stack;

        AvlBuilder() {
        }

        void reset(int targetSize) {
            this.leavesToSkip = ((Integer.highestOneBit(targetSize) * 2) - 1) - targetSize;
            this.size = 0;
            this.leavesSkipped = 0;
            this.stack = null;
        }

        void add(Node node) {
            node.right = null;
            node.parent = null;
            node.left = null;
            node.height = 1;
            if (this.leavesToSkip > 0 && (this.size & 1) == 0) {
                this.size++;
                this.leavesToSkip--;
                this.leavesSkipped++;
            }
            node.parent = this.stack;
            this.stack = node;
            this.size++;
            if (this.leavesToSkip > 0 && (this.size & 1) == 0) {
                this.size++;
                this.leavesToSkip--;
                this.leavesSkipped++;
            }
            for (int scale = 4; (this.size & (scale - 1)) == scale - 1; scale *= 2) {
                Node right;
                Node center;
                if (this.leavesSkipped == 0) {
                    right = this.stack;
                    center = right.parent;
                    Node left = center.parent;
                    center.parent = left.parent;
                    this.stack = center;
                    center.left = left;
                    center.right = right;
                    center.height = right.height + 1;
                    left.parent = center;
                    right.parent = center;
                } else if (this.leavesSkipped == 1) {
                    right = this.stack;
                    center = right.parent;
                    this.stack = center;
                    center.right = right;
                    center.height = right.height + 1;
                    right.parent = center;
                    this.leavesSkipped = 0;
                } else if (this.leavesSkipped == 2) {
                    this.leavesSkipped = 0;
                }
            }
        }

        Node root() {
            Node stackTop = this.stack;
            if (stackTop.parent == null) {
                return stackTop;
            }
            throw new IllegalStateException();
        }
    }

    static class AvlIterator {
        private Node stackTop;

        AvlIterator() {
        }

        void reset(Node root) {
            Node stackTop = null;
            for (Node n = root; n != null; n = n.left) {
                n.parent = stackTop;
                stackTop = n;
            }
            this.stackTop = stackTop;
        }

        public Node next() {
            Node stackTop = this.stackTop;
            if (stackTop == null) {
                return null;
            }
            Node result = stackTop;
            stackTop = result.parent;
            result.parent = null;
            for (Node n = result.right; n != null; n = n.left) {
                n.parent = stackTop;
                stackTop = n;
            }
            this.stackTop = stackTop;
            return result;
        }
    }

    private abstract class LinkedTreeMapIterator implements Iterator {
        int expectedModCount;
        Node lastReturned;
        Node next;

        private LinkedTreeMapIterator() {
            this.next = LinkedHashTreeMap.this.header.next;
            this.lastReturned = null;
            this.expectedModCount = LinkedHashTreeMap.this.modCount;
        }

        public final boolean hasNext() {
            return this.next != LinkedHashTreeMap.this.header;
        }

        final Node nextNode() {
            Node e = this.next;
            if (e == LinkedHashTreeMap.this.header) {
                throw new NoSuchElementException();
            } else if (LinkedHashTreeMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else {
                this.next = e.next;
                this.lastReturned = e;
                return e;
            }
        }

        public final void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            LinkedHashTreeMap.this.removeInternal(this.lastReturned, true);
            this.lastReturned = null;
            this.expectedModCount = LinkedHashTreeMap.this.modCount;
        }
    }

    class EntrySet extends AbstractSet {

        /* renamed from: com.millennialmedia.google.gson.internal.LinkedHashTreeMap.EntrySet.1 */
        class C25481 extends LinkedTreeMapIterator {
            C25481() {
                super(null);
            }

            public Entry next() {
                return nextNode();
            }
        }

        EntrySet() {
        }

        public int size() {
            return LinkedHashTreeMap.this.size;
        }

        public Iterator iterator() {
            return new C25481();
        }

        public boolean contains(Object o) {
            return (o instanceof Entry) && LinkedHashTreeMap.this.findByEntry((Entry) o) != null;
        }

        public boolean remove(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            Node node = LinkedHashTreeMap.this.findByEntry((Entry) o);
            if (node == null) {
                return false;
            }
            LinkedHashTreeMap.this.removeInternal(node, true);
            return true;
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }
    }

    class KeySet extends AbstractSet {

        /* renamed from: com.millennialmedia.google.gson.internal.LinkedHashTreeMap.KeySet.1 */
        class C25491 extends LinkedTreeMapIterator {
            C25491() {
                super(null);
            }

            public Object next() {
                return nextNode().key;
            }
        }

        KeySet() {
        }

        public int size() {
            return LinkedHashTreeMap.this.size;
        }

        public Iterator iterator() {
            return new C25491();
        }

        public boolean contains(Object o) {
            return LinkedHashTreeMap.this.containsKey(o);
        }

        public boolean remove(Object key) {
            return LinkedHashTreeMap.this.removeInternalByKey(key) != null;
        }

        public void clear() {
            LinkedHashTreeMap.this.clear();
        }
    }

    static final class Node implements Entry {
        final int hash;
        int height;
        final Object key;
        Node left;
        Node next;
        Node parent;
        Node prev;
        Node right;
        Object value;

        Node() {
            this.key = null;
            this.hash = -1;
            this.prev = this;
            this.next = this;
        }

        Node(Node parent, Object key, int hash, Node next, Node prev) {
            this.parent = parent;
            this.key = key;
            this.hash = hash;
            this.height = 1;
            this.next = next;
            this.prev = prev;
            prev.next = this;
            next.prev = this;
        }

        public Object getKey() {
            return this.key;
        }

        public Object getValue() {
            return this.value;
        }

        public Object setValue(Object value) {
            Object oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            Entry other = (Entry) o;
            if (this.key == null) {
                if (other.getKey() != null) {
                    return false;
                }
            } else if (!this.key.equals(other.getKey())) {
                return false;
            }
            if (this.value == null) {
                if (other.getValue() != null) {
                    return false;
                }
            } else if (!this.value.equals(other.getValue())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.key == null ? 0 : this.key.hashCode();
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return hashCode ^ i;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }

        public Node first() {
            Node node;
            Node child = this.left;
            while (child != null) {
                node = child;
                child = node.left;
            }
            return node;
        }

        public Node last() {
            Node node;
            Node child = this.right;
            while (child != null) {
                node = child;
                child = node.right;
            }
            return node;
        }
    }

    static {
        $assertionsDisabled = !LinkedHashTreeMap.class.desiredAssertionStatus();
        NATURAL_ORDER = new C25471();
    }

    public LinkedHashTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedHashTreeMap(Comparator comparator) {
        this.size = 0;
        this.modCount = 0;
        if (comparator == null) {
            comparator = NATURAL_ORDER;
        }
        this.comparator = comparator;
        this.header = new Node();
        this.table = new Node[16];
        this.threshold = (this.table.length / 2) + (this.table.length / 4);
    }

    public int size() {
        return this.size;
    }

    public Object get(Object key) {
        Node node = findByObject(key);
        return node != null ? node.value : null;
    }

    public boolean containsKey(Object key) {
        return findByObject(key) != null;
    }

    public Object put(Object key, Object value) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        Node created = find(key, true);
        Object result = created.value;
        created.value = value;
        return result;
    }

    public void clear() {
        Arrays.fill(this.table, null);
        this.size = 0;
        this.modCount++;
        Node header = this.header;
        Node e = header.next;
        while (e != header) {
            Node next = e.next;
            e.prev = null;
            e.next = null;
            e = next;
        }
        header.prev = header;
        header.next = header;
    }

    public Object remove(Object key) {
        Node node = removeInternalByKey(key);
        return node != null ? node.value : null;
    }

    Node find(Object key, boolean create) {
        Comparator comparator = this.comparator;
        Node[] table = this.table;
        int hash = secondaryHash(key.hashCode());
        int index = hash & (table.length - 1);
        Node nearest = table[index];
        int comparison = 0;
        if (nearest != null) {
            Comparable comparableKey = comparator == NATURAL_ORDER ? (Comparable) key : null;
            while (true) {
                comparison = comparableKey != null ? comparableKey.compareTo(nearest.key) : comparator.compare(key, nearest.key);
                if (comparison == 0) {
                    return nearest;
                }
                Node child = comparison < 0 ? nearest.left : nearest.right;
                if (child == null) {
                    break;
                }
                nearest = child;
            }
        }
        if (!create) {
            return null;
        }
        Node created;
        Node header = this.header;
        if (nearest != null) {
            created = new Node(nearest, key, hash, header, header.prev);
            if (comparison < 0) {
                nearest.left = created;
            } else {
                nearest.right = created;
            }
            rebalance(nearest, true);
        } else if (comparator != NATURAL_ORDER || (key instanceof Comparable)) {
            created = new Node(nearest, key, hash, header, header.prev);
            table[index] = created;
        } else {
            throw new ClassCastException(key.getClass().getName() + " is not Comparable");
        }
        int i = this.size;
        this.size = i + 1;
        if (i > this.threshold) {
            doubleCapacity();
        }
        this.modCount++;
        return created;
    }

    Node findByObject(Object key) {
        Node node = null;
        if (key != null) {
            try {
                node = find(key, false);
            } catch (ClassCastException e) {
            }
        }
        return node;
    }

    Node findByEntry(Entry entry) {
        Node mine = findByObject(entry.getKey());
        boolean valuesEqual = mine != null && equal(mine.value, entry.getValue());
        return valuesEqual ? mine : null;
    }

    private boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    private static int secondaryHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return ((h >>> 7) ^ h) ^ (h >>> 4);
    }

    void removeInternal(Node node, boolean unlink) {
        if (unlink) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
        Node left = node.left;
        Node right = node.right;
        Node originalParent = node.parent;
        if (left == null || right == null) {
            if (left != null) {
                replaceInParent(node, left);
                node.left = null;
            } else if (right != null) {
                replaceInParent(node, right);
                node.right = null;
            } else {
                replaceInParent(node, null);
            }
            rebalance(originalParent, false);
            this.size--;
            this.modCount++;
            return;
        }
        Node adjacent = left.height > right.height ? left.last() : right.first();
        removeInternal(adjacent, false);
        int leftHeight = 0;
        left = node.left;
        if (left != null) {
            leftHeight = left.height;
            adjacent.left = left;
            left.parent = adjacent;
            node.left = null;
        }
        int rightHeight = 0;
        right = node.right;
        if (right != null) {
            rightHeight = right.height;
            adjacent.right = right;
            right.parent = adjacent;
            node.right = null;
        }
        adjacent.height = Math.max(leftHeight, rightHeight) + 1;
        replaceInParent(node, adjacent);
    }

    Node removeInternalByKey(Object key) {
        Node node = findByObject(key);
        if (node != null) {
            removeInternal(node, true);
        }
        return node;
    }

    private void replaceInParent(Node node, Node replacement) {
        Node parent = node.parent;
        node.parent = null;
        if (replacement != null) {
            replacement.parent = parent;
        }
        if (parent == null) {
            this.table[node.hash & (this.table.length - 1)] = replacement;
        } else if (parent.left == node) {
            parent.left = replacement;
        } else if ($assertionsDisabled || parent.right == node) {
            parent.right = replacement;
        } else {
            throw new AssertionError();
        }
    }

    private void rebalance(Node unbalanced, boolean insert) {
        for (Node node = unbalanced; node != null; node = node.parent) {
            Node left = node.left;
            Node right = node.right;
            int leftHeight = left != null ? left.height : 0;
            int rightHeight = right != null ? right.height : 0;
            int delta = leftHeight - rightHeight;
            if (delta == -2) {
                Node rightLeft = right.left;
                Node rightRight = right.right;
                int rightDelta = (rightLeft != null ? rightLeft.height : 0) - (rightRight != null ? rightRight.height : 0);
                if (rightDelta == -1 || (rightDelta == 0 && !insert)) {
                    rotateLeft(node);
                } else if ($assertionsDisabled || rightDelta == 1) {
                    rotateRight(right);
                    rotateLeft(node);
                } else {
                    throw new AssertionError();
                }
                if (insert) {
                    return;
                }
            } else if (delta == 2) {
                Node leftLeft = left.left;
                Node leftRight = left.right;
                int leftDelta = (leftLeft != null ? leftLeft.height : 0) - (leftRight != null ? leftRight.height : 0);
                if (leftDelta == 1 || (leftDelta == 0 && !insert)) {
                    rotateRight(node);
                } else if ($assertionsDisabled || leftDelta == -1) {
                    rotateLeft(left);
                    rotateRight(node);
                } else {
                    throw new AssertionError();
                }
                if (insert) {
                    return;
                }
            } else if (delta == 0) {
                node.height = leftHeight + 1;
                if (insert) {
                    return;
                }
            } else if ($assertionsDisabled || delta == -1 || delta == 1) {
                node.height = Math.max(leftHeight, rightHeight) + 1;
                if (!insert) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
        }
    }

    private void rotateLeft(Node root) {
        int i;
        int i2 = 0;
        Node left = root.left;
        Node pivot = root.right;
        Node pivotLeft = pivot.left;
        Node pivotRight = pivot.right;
        root.right = pivotLeft;
        if (pivotLeft != null) {
            pivotLeft.parent = root;
        }
        replaceInParent(root, pivot);
        pivot.left = root;
        root.parent = pivot;
        if (left != null) {
            i = left.height;
        } else {
            i = 0;
        }
        root.height = Math.max(i, pivotLeft != null ? pivotLeft.height : 0) + 1;
        int i3 = root.height;
        if (pivotRight != null) {
            i2 = pivotRight.height;
        }
        pivot.height = Math.max(i3, i2) + 1;
    }

    private void rotateRight(Node root) {
        int i;
        int i2 = 0;
        Node pivot = root.left;
        Node right = root.right;
        Node pivotLeft = pivot.left;
        Node pivotRight = pivot.right;
        root.left = pivotRight;
        if (pivotRight != null) {
            pivotRight.parent = root;
        }
        replaceInParent(root, pivot);
        pivot.right = root;
        root.parent = pivot;
        if (right != null) {
            i = right.height;
        } else {
            i = 0;
        }
        root.height = Math.max(i, pivotRight != null ? pivotRight.height : 0) + 1;
        int i3 = root.height;
        if (pivotLeft != null) {
            i2 = pivotLeft.height;
        }
        pivot.height = Math.max(i3, i2) + 1;
    }

    public Set entrySet() {
        EntrySet result = this.entrySet;
        if (result != null) {
            return result;
        }
        result = new EntrySet();
        this.entrySet = result;
        return result;
    }

    public Set keySet() {
        KeySet result = this.keySet;
        if (result != null) {
            return result;
        }
        result = new KeySet();
        this.keySet = result;
        return result;
    }

    private void doubleCapacity() {
        this.table = doubleCapacity(this.table);
        this.threshold = (this.table.length / 2) + (this.table.length / 4);
    }

    static Node[] doubleCapacity(Node[] oldTable) {
        int oldCapacity = oldTable.length;
        Node[] newTable = new Node[(oldCapacity * 2)];
        AvlIterator iterator = new AvlIterator();
        AvlBuilder leftBuilder = new AvlBuilder();
        AvlBuilder rightBuilder = new AvlBuilder();
        for (int i = 0; i < oldCapacity; i++) {
            Node root = oldTable[i];
            if (root != null) {
                Node node;
                iterator.reset(root);
                int leftSize = 0;
                int rightSize = 0;
                while (true) {
                    node = iterator.next();
                    if (node == null) {
                        break;
                    } else if ((node.hash & oldCapacity) == 0) {
                        leftSize++;
                    } else {
                        rightSize++;
                    }
                }
                Node leftRoot = null;
                Node rightRoot = null;
                if (leftSize > 0 && rightSize > 0) {
                    leftBuilder.reset(leftSize);
                    rightBuilder.reset(rightSize);
                    iterator.reset(root);
                    while (true) {
                        node = iterator.next();
                        if (node == null) {
                            break;
                        } else if ((node.hash & oldCapacity) == 0) {
                            leftBuilder.add(node);
                        } else {
                            rightBuilder.add(node);
                        }
                    }
                    leftRoot = leftBuilder.root();
                    rightRoot = rightBuilder.root();
                } else if (leftSize > 0) {
                    leftRoot = root;
                } else {
                    rightRoot = root;
                }
                newTable[i] = leftRoot;
                newTable[i + oldCapacity] = rightRoot;
            }
        }
        return newTable;
    }

    private Object writeReplace() {
        return new LinkedHashMap(this);
    }
}
