package com.brainlesslabs.momo.common.utils;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Pair<K, V> implements Serializable {
    private K key;
    private V value;
}
