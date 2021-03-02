package com.lxj.algorithm.map;

public interface Map<K, V> {
    void add(K key, V val);
    V remove(K key);
    V get(K key);
    V set(K key, V val);
    boolean contains(K key);
    int getSize();
    boolean isEmpty();
}
