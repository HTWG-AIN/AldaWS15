/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dectionary;

import java.util.Arrays;

/**
 *
 * @author AIN
 * @param <K>
 * @param <V>
 */
public class HashDictionary<K, V> implements Dictionary<K, V> {

	@Override
	public String toString() {
		return "HashDictionary [size=" + size + ", data=" + Arrays.toString(data) + "]";
	}

	@SuppressWarnings("unchecked")
	public HashDictionary(int i) {
		size = 0;
		data = new Entry[DEF_CAPACITY];
	}

	private static class Entry<K, V> {

		K key;
		V value;
		Entry<K, V> next;

		@SuppressWarnings("unused")
		Entry(K k, V v) {
			key = k;
			value = v;
		}
	};

	private static final int DEF_CAPACITY = 16;
	private int size;
	private Entry<K, V>[] data;

	@SuppressWarnings("unchecked")
	private void ensureCapacity(int newCapacity) {
		if (newCapacity < size) {
			return;
		}
		Entry<K, V>[] old = data;
		data = new Entry[newCapacity];
		System.arraycopy(old, 0, data, 0, size);
	}

	@Override
	public V insert(K key, V value) {

		if (data.length == size) {
			ensureCapacity(2 * size);
		}
		V v = search(key);

		int hash = getHashcode(key);
		if (v != null) {
			for (Entry<K, V> e = data[hash]; e != null; e = e.next) {
				if (e.key.equals(key)) {
					V oldValue = e.value;
					e.value = value;
					return oldValue;
				}
			}
		}
		data[hash]  = new  Entry<K,V>(key,value);
		data[hash].key = key;
		data[hash].value = value;
		size++;
		
	//		Entry<K, V> e = new Entry<K, V>(key, value);
	////		e.next = data[hash].next;
	//		e.key = key;
	//		e.value = value;
	//		//e.next = data[hash].next;
	//		size++;
		
		return null;

		// return null;
	}

	public int getHashcode(K key) {
		int addr = key.hashCode();
		if (addr < 0) {
			addr = -addr;
		}
		addr = addr % data.length;
		return addr;
	}

	@Override
	public V search(K key) {
		int hash = getHashcode(key);
		for (Entry<K, V> e = data[hash]; e != null; e = e.next) {
			if (e.key.equals(key)) {
				return e.value;
			}
		}
		return null;
	}

	@Override
	public V remove(K key) {
		int hash = getHashcode(key);
		V v = search(key);
		if (v != null) {
			for (Entry<K, V> e = data[hash]; e != null; e = e.next) {
				if (e.key.equals(key)) {
					data[hash] = e.next;
					size--;
					return e.value;
				}
			}
		}
		return null;

	}

	@Override
	public int size() {
		return data.length;
	}

}
