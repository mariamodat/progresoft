package com.bloomberg.config.redis;

public abstract class CacheTemplate<K, V> {
    public abstract V get(K key);
    public abstract void put(K key, V value);
    public abstract void evict(K key);
}
