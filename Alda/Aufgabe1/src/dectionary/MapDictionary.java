/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dectionary;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author AIN
 */
class MapDictionary<K, V> implements Dictionary<K, V> {

	Map<K, V> myMap;

	public MapDictionary(TreeMap<K, V> treeMap) {
		myMap = new TreeMap<K, V>();
	}

	public MapDictionary(HashMap<K, V> hashMap) {
		myMap = new HashMap<K, V>();
	}

	@Override
	public V insert(K key, V value) {
		V oldV = null;
		if (myMap.containsKey(key)) {
			oldV = myMap.get(key);
			

		}else
		myMap.put(key, value);

		return oldV;
	}

	@Override
	public String toString() {
		return "MapDictionary [myMap=" + myMap + "]";
	}

	@Override
	public V search(K key) {

		if (myMap.containsKey(key)) {
			return myMap.get(key); // get returns the value of this key
		}
		return null;
	}

	@Override
	public V remove(K key) {
		V value = null;
		if (myMap.containsKey(key)) {
			value = myMap.get(key);
			myMap.remove(key);
			return value;
		}
		return null;
	}

	@Override
	public int size() {
		return myMap.size();
	}

}
