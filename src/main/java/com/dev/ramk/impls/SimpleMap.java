package com.dev.ramk.impls;

import com.dev.ramk.maps.AltMap;
import com.dev.ramk.nodes.Node;
import java.util.List;
import java.util.Objects;

public class SimpleMap<K, V> implements AltMap<K, V> {
	Node<K, V> startNode, endNode;

	public SimpleMap() {}

	@Override
	public void insert(K key, V value) {
		Node<K, V> newNode = new Node<>(key, value);

		if (Objects.isNull(startNode)) {
			startNode = endNode = newNode;
			startNode.previous = null;
		} else {
			if (containsKey(key)) {
				getEntry(key).value = value;
			} else {
				endNode.next = newNode;
				newNode.previous = endNode;
				endNode = newNode;
			}
		}
		endNode.next = null;
	}

	@Override
	public void remove(K key) {
		if (Objects.isNull(startNode)) {
			return;
		}
		if (startNode.key.equals(key)) {
			startNode = startNode.next;
			startNode.previous = null;
			return;
		}

		Node<K, V> currentNode = startNode.next;
		while (!currentNode.key.equals(key)) {
			currentNode = currentNode.next;
		}

		currentNode.previous.next = currentNode.next;
		if (!Objects.isNull(currentNode.next)) {
			currentNode.next.previous = currentNode.previous;
		} else {
			endNode = currentNode.previous;
		}
	}

	@Override
	public void removeAll(List<K> keys) {
		keys.forEach(this::remove);
	}

	@Override
	public boolean containsKey(K key) {
		if (Objects.isNull(startNode)) {
			return false;
		}
		if (startNode.key.equals(key)) {
			return true;
		}

		Node<K, V> currentNode = startNode.next;
		while (!Objects.isNull(currentNode) && !currentNode.key.equals(key)) {
			currentNode = currentNode.next;
		}

		return !Objects.isNull(currentNode) && currentNode.key.equals(key);
	}

	@Override
	public int size() {
		int size = 0;
		Node<K, V> node = startNode;
		while (!Objects.isNull(node)) {
			size++;
			node = node.next;
		}
		return size;
	}

	@Override
	public boolean isEmpty() {

		return Objects.isNull(startNode);
	}

	@Override
	public String print() {
		StringBuilder content = new StringBuilder();
		Node<K, V> currentNode = startNode;
		content.append("{");
		while(!Objects.isNull(currentNode)) {
			content.append(currentNode.key).append("=")
				.append(currentNode.value)
				.append(!Objects.isNull(currentNode.next) ? " ," : "");
			currentNode = currentNode.next;
		}
		content.append("}");

		return content.toString();
	}

	@Override
	public V get(K key) {

		return getEntry(key).value;
	}

	@Override
	public Node<K, V> getEntry(K key) {
		if (Objects.isNull(startNode)) {
			return null;
		}
		if (startNode.key.equals(key)) {
			return startNode;
		}

		Node<K, V> currentNode = startNode.next;
		while (!Objects.isNull(currentNode) && !currentNode.key.equals(key)) {
			currentNode = currentNode.next;
		}

		return !Objects.isNull(currentNode) ? currentNode : null;
	}
}
