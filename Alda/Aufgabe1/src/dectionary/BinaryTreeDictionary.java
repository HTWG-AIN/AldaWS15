/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dectionary;

/**
 *
 * @author AIN
 */
class BinaryTreeDictionary<K extends Comparable<? super K>, V> implements Dictionary<K, V> {

    static private class Node<K, V> {

        private K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;

        private Node(K k, V v) {
            key = k;
            value = v;
            left = null;
            right = null;
        }
    }
    private Node<K, V> root = null;

    private Node<K, V> head;
    private int size;

    public BinaryTreeDictionary() {
        head = null;
    }

    @Override
    public V insert(K key, V value) {

        root = insertR(key, value, root);
        if (head != null) {
            return head.value;
        }
        return null;

    }

    private Node<K, V> insertR(K key, V value, Node<K, V> p) {
        if (p == null) {
            p = new Node(key, value);

        } else if (key.compareTo(p.key) < 0) {
            p.left = insertR(key, value, p.left);
        } else if (key.compareTo(p.key) > 0) {
            p.right = insertR(key, value, p.right);
        } else // Schlüssel bereits vorhanden: 
        {
            head = p;
            p.key = key;
            p.value = value;
        }

        return p;

    }

    @Override
    public V search(K key) {
        return searchR(key, root);
    }

    private V searchR(K key, Node<K, V> p) {
        if (p == null) {
            return null;
        } else if (key.compareTo(p.key) < 0) {
            return searchR(key, p.left);
        } else if (key.compareTo(p.key) > 0) {
            return searchR(key, p.right);
        } else {
            return p.value;
        }

    }

    @Override
    public V remove(K key) {
        root = removeR(key, root);
        if(root != null)
            return root.value;
        return null;
    }

    private Node<K, V> removeR(K key, Node<K, V> p) {
        if (p == null) {
            return null;
        } else if (key.compareTo(p.key) < 0) {
            p.left = removeR(key, p.left);
        } else if (key.compareTo(p.key) > 0) {
            p.right = removeR(key, p.right);
        } else {
            if (p.left == null || p.right == null) {
// p hat ein oder kein Kind: 
              
                p = (p.left != null) ? p.left : p.right;
            } else {
// p hat zwei Kinder: 
                Entry<K, V> min = new Entry();
                p.right = getRemMinR(p.right, min);
                p.key = min.key;
                p.value = min.value;
            }
        }
        return p;
    }

    private Node<K, V> getRemMinR(Node<K, V> p, Entry<K, V> min) {
        assert p != null;
        if (p.left == null) {
            min.key = p.key;
            min.value = p.value;
            p = p.right;
        } else {
            p.left = getRemMinR(p.left, min);
        }
        return p;
    }

    private static class Entry<K, V> {

        private K key;
        private V value;
    }

    @Override
    public int size() {
        if(head == null)
            return 0;
        size = 1;
        sizeR(head);

        return size;
    }

    private void sizeR(Node<K, V> head) {
        if(head.left != null) {
            size++;
            sizeR(head.left);
        }
        if(head.right != null) {
            size++;
            sizeR(head.right);
        }
    }

}
