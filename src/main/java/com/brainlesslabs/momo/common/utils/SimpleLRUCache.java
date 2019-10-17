package com.brainlesslabs.momo.common.utils;

import lombok.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@NoArgsConstructor
public class SimpleLRUCache<K, V> implements Iterable<Map.Entry<K, V>>{
    @Getter
    @Setter
    private int capacity = 127;
    private Map<K, LRUCacheElement<V>> elements = new HashMap<>();

    public void add(@NonNull final K key, @NonNull final V value) {
        if(elements.size() == capacity) {
            remoteLeastReventlyUsed();
        }
        final long updateTime = Instant.now().getEpochSecond();
        final LRUCacheElement<V> element = elements.getOrDefault(key, new LRUCacheElement<>(value, updateTime));
        element.lastTimeUsed = updateTime;
        elements.put(key, element);
    }

    public V get(@NonNull K key) {
        final LRUCacheElement<V> element = elements.getOrDefault(key, null);
        return element != null ? element.element : null;
    }

    public void clear() {
        elements.clear();
    }

    private void remoteLeastReventlyUsed() {
        long maxValue = 0;
        K key = null;
        for(final Map.Entry<K, LRUCacheElement<V>> entry : elements.entrySet()) {
            if(maxValue < entry.getValue().lastTimeUsed) {
                maxValue = entry.getValue().lastTimeUsed;
                key = entry.getKey();
            }
        }
        if(key != null) {
            elements.remove(key);
        }
    }

    @Override
    public Iterator iterator() {
        return new SimpleLRUCacheIterator<K, V>(elements);
    }
}

class SimpleLRUCacheIterator<K, V> implements Iterator<Pair<K, V>> {
    private Iterator<Map.Entry<K, LRUCacheElement<V>>> elementIterator;

    SimpleLRUCacheIterator(@NonNull final Map<K, LRUCacheElement<V>> elements) {
        this.elementIterator = elements.entrySet().iterator();
    }

    @Override
    public boolean hasNext() {
        return elementIterator.hasNext();
    }

    @Override
    public Pair<K, V> next() {
        final Map.Entry<K, LRUCacheElement<V>> klruCacheElementEntry = elementIterator.next();
        return new Pair<>(klruCacheElementEntry.getKey(), klruCacheElementEntry.getValue().element);
    }
}

@Data
@EqualsAndHashCode(exclude = "lastTimeUsed")
@ToString
@NoArgsConstructor
@AllArgsConstructor
class LRUCacheElement<E> {
    public E element;
    public long lastTimeUsed;
}
