package com.lxj.algorithm.map;

import com.lxj.algorithm.linkedlist.LinkedList;

/**
 * @author Administrator
 */
public class LinkedListMap<K,V> implements Map<K, V> {

    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key,null,null);
        }

        public  Node(){this(null,null,null);}

        @Override
        public String toString() {
            return key.toString()+":"+value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V val) {
        Node node = getNode(key);
        if (node == null){
            dummyHead.next = new Node(key,val,dummyHead.next);
            size++;
        }else {
            node.value = val;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = this.dummyHead;
        while (prev.next != null){
            if (prev.next.key.equals(key)){
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V val) {
        Node node = getNode(key);
        if (node ==null){
            throw new IllegalArgumentException("key does not exist");
        }
        node.value = val;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    private Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur!=null){
            if (cur.key.equals(key)){
                return cur;
            }else{
                cur = cur.next;
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            sb.append(cur+"->");
            cur = cur.next;
        }
        return "LinkedListMap{"+sb.toString()+"}";
    }

    public static void main(String[] args) {
        LinkedListMap<String, Integer> map = new LinkedListMap<>();
        String [] words = {"I","am","a","student","I","was","born","in","gz","I","love","here","It","would","be","great"};
        System.out.println(words.length);
        for (String word : words) {
            if (map.contains(word)){
                map.set(word, map.get(word)+1);
            }else {
                map.add(word,1);
            }
        }
        System.out.println(map.getSize());
        System.out.println(map);
    }
}
