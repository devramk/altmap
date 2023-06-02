package com.dev.ramk.maps;

import com.dev.ramk.nodes.Node;
import java.util.List;

public interface AltMap<K, V> {
	void insert(K key, V value);
	V get(K key);
	Node<K, V> getEntry(K key);
	void remove(K key);
	void removeAll(List<K> keys);
	boolean containsKey(K key);
	int size();
	boolean isEmpty();
	String print();
}
