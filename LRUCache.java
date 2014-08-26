package com.example.helloworld;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    /**
     * Default value
     */
    private static final long serialVersionUID = 1L;

    private int mMaxEntries;

    public LRUCache(int maxEntries) {
        // removeEldestEntry() is called after a put(). To allow maxEntries in
        // cache, capacity should be maxEntries + 1 (+1 for the entry which will
        // be removed). Load factor is taken as 1 because size is fixed. This is
        // less space efficient when very less entries are present, but there
        // will be no effect on time complexity for get(). The third parameter
        // in the base class constructor says that this map is access-order
        // oriented.
        super(maxEntries + 1, 1, true);
        mMaxEntries = maxEntries;
    }

    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        // After size exceeds max entries, this statement returns true and the
        // oldest value will be removed. Since this map is access oriented the
        // oldest value would be least recently used.
        return size() > mMaxEntries;
    }

}