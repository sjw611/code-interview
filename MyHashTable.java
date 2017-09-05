package ood;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MyHashTable<K, V> {

    private static final int DEFAULT_CAPACITY = 10;

    private Bucket<K, V>[] array;

    public MyHashTable() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public MyHashTable(int capacity) {
        array = new Bucket[capacity <= DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity];
    }

    public int size() {
        int total = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] != null) {
                total += array[i].mappings.size();
            }
        }
        return total;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean put(K key, V value) {
        Objects.requireNonNull(key);
        Objects.requireNonNull(value);

        int hash = hash(key);
        if (array[hash] == null) {
            array[hash] = new Bucket<K, V>(hash);
        }
        return array[hash].add(key, value);
    }

    public V get(Object key) {
        Objects.requireNonNull(key);

        int hash = hash(key);

        if (array[hash] == null) {
            return null;
        }

        Bucket<K, V> bucket = array[hash];
        for (Pair<K, V> p : bucket.mappings) {
            if (key.equals(p.key)) {
                return p.value;
            }
        }

        return null;
    }

    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    public V remove(Object key) {
        Objects.requireNonNull(key);

        int hash = hash(key);

        if (array[hash] == null) {
            return null;
        }

        Bucket<K, V> bucket = array[hash];

        V ret = null;

        for (Iterator<Pair<K, V>> iter = bucket.mappings.iterator(); iter.hasNext();) {
            Pair<K, V> p = iter.next();
            if (key.equals(p.key)) {
                iter.remove();
                ret = p.value;
                break;
            }
        }

        if (bucket.mappings.isEmpty()) {
            array[hash] = null;
        }

        return ret;
    }

    private int hash(Object key) {
        return Math.abs(key.hashCode() % array.length);
    }

    private static class Bucket<K, V> {

        private List<Pair<K, V>> mappings = new LinkedList<>();
        private int hash;

        public Bucket(int hash) {
            this.hash = hash;
        }

        public boolean add(K key, V value) {
            for (Pair<K, V> p : mappings) {
                if (key.equals(p.key)) {
                    p.value = value;
                    return true;
                }
            }

            return mappings.add(new Pair<>(key, value));
        }

        @Override
        public String toString() {
            return "Bucket(" + hash + ")" + mappings;
        }

    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair[" + key + ":" + value + "]";
        }
    }

}
