package utils;

public class Pair<K, V> {

    private K k;
    private V v;
    public Pair(K key, V value) {
        this.k = key;
        this.v = value;
    }

    public K first() {
        return k;
    }

    public V second() {
        return v;
    }
}
