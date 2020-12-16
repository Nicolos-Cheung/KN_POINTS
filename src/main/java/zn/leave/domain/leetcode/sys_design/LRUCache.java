package zn.leave.domain.leetcode.sys_design;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This is Description
 *
 * @author ning
 * @date 2020/11/23
 */
public class LRUCache extends LinkedHashMap {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
    }

    private int capacity;

    public LRUCache(int capacity) {
        //accessOrder true->按照访问顺序存储
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return (int) super.getOrDefault(key, -1);
    }

    // 这个可不写
    public void put(int key, int value) {
        super.put(key, value);
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }
}
