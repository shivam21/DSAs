package hashmap;

import java.util.ArrayList;

public class MyMap<K, V> {
    private ArrayList<MapNode<K, V>> buckets;
    private int bucketSize = 4;
    private int size = 0;

    public MyMap() {
        this.buckets = new ArrayList<>(bucketSize);
        for (int i = 0; i < bucketSize; i++) {
            buckets.add(null);
        }
    }

    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = buckets.get(bucketIndex);
        MapNode<K, V> newNode = new MapNode<>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);
        size++;
        float loadFactor = (1.0f * size) / bucketSize;
        if (loadFactor > 0.75)
            rehash();
    }

    private void rehash() {
        System.out.println("rehashing buckets:" + bucketSize + " size:" + size);
        ArrayList<MapNode<K, V>> temp = buckets;
        size = 0;
        bucketSize = 2 * bucketSize;
        buckets = new ArrayList<>();
        for (int i = 0; i < bucketSize; i++) {
            buckets.add(null);
        }
        for (MapNode<K, V> head : temp) {
            while (head != null) {
                insert(head.key, head.value);
                head = head.next;
            }
        }
    }

    public float loadFactor() {
        return (1.0f * size) / bucketSize;
    }

    public V remove(K key) {
        int index = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(index);
        MapNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    buckets.set(index, head.next);
                }
                size--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(index);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    private int size() {
        return size;
    }

    private int getBucketIndex(K key) {
        return key.hashCode() % bucketSize;
    }


    static class MapNode<K, V> {
        K key;
        V value;
        MapNode<K, V> next;

        public MapNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
