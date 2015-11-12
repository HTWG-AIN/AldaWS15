/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dectionary;

/**
 *
 * @author AIN
 * @param <K>
 * @param <V>
 */
public class HashDictionary<K, V> implements Dictionary<K, V> {

    public HashDictionary(int i) {
        size = 0;
        data = new Entry[DEF_CAPACITY];
    }

    private static class Entry<K, V> {

        K key;
        V value;

        Entry(K k, V v) {
            key = k;
            value = v;
        }
    };
    private static final int DEF_CAPACITY = 16;
    private int size;
    private Entry<K, V>[] data;

    private void ensureCapacity(int newCapacity) {
        if (newCapacity < size) {
            return;
        }
        Entry[] old = data;
        data = new Entry[newCapacity];
        System.arraycopy(old, 0, data, 0, size);
    }

    @Override
    public V insert(K key, V value) {
        //   int adr = key.hashCode() % data.length; // nach Key suchen
        getHashcode(key);
        int i = searchKey(key);

        if (i >= 0) { // key gefunden
            V oldValue = data[i].value; // merke den alten Wert
            data[i].value = value; // ersetze den alten Wert durch den neuen 
            return oldValue;

        }
        //   data[getHashcode(key)]  ;
        if (data.length == size) {
            ensureCapacity(2 * size);
        }
        data[size] = new Entry(key, value);
        size++;
        return null;

    }

    public int getHashcode(K key) {
        int addr = key.hashCode();
        if (addr < 0) {
            addr = -addr;
        }
        addr = addr % data.length;
        return addr;
    }

    private int searchKey(K key) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public V search(K key) {
        getHashcode(key);
        int i = searchKey(key);

        if (i >= 0) {
            return data[i].value;
        } else {
            return null;
        }

    }

    @Override
    public V remove(K key) {

        int i = searchKey(key);
        if (i == -1) {
            return null;
        }
        V r = data[i].value;
        data[i].key = null;

        return r;
    }

    @Override
    public int size() {
        return data.length;
    }

}
