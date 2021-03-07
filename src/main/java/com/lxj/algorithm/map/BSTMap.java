package com.lxj.algorithm.map;

public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {
    private class Node{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

        public Node(K key) {
            this(key,null);
        }

        public Node(){this(null,null);}

        @Override
        public String toString() {
            return key.toString()+":"+value.toString();
        }
    }

    private int size;
    private Node root;

    @Override
    public void add(K key, V val) {
        root = add(root, key, val);
    }

    /**
     * 已root为根节点，向二分搜索树中插入元素（key,value),递归算法
     * 返回插入新节点后二分搜索树的根
     * @param node
     * @param key
     * @param val
     * @return
     */
    private Node add(Node node, K key, V val) {
        if (node == null){
            size++;
            return new Node(key, val);
        }
        if (key.compareTo(node.key) < 0){
            node.left = add(node.left, key,val);
        }else if (key.compareTo(node.key) > 0){
            node.right = add(node.right, key,val);
        }else{//key.compareTo(node.key) == 0
            node.value = val;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node!=null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    /**
     * 删除已node为根的二分搜索树中key的节点，递归算法
     * 返回删除节点后二分搜索树的根
     * @param node
     * @param key
     * @return
     */
    private Node remove(Node node, K key) {
        if (node == null){
            return null;
        }
        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            return node;
        }else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            return node;
        }else { // key.compareTo(node.key) == 0
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            // 找到比待删除的节点大的最小节点，用这个节点代替删除节点位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
        }
        return null;
    }

    private Node minimum(Node node){
        if (node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 删除已node为根的二分搜索树的最小节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V val) {
        Node node = getNode(root, key);
        if (node == null){
            throw new IllegalArgumentException("key does not exist");
        }else {
            node.value = val;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    private Node getNode(Node node, K key){
        if (node == null){
            return null;
        }
        if (key.compareTo(node.key)== 0){
            return node;
        }else if (key.compareTo(node.key) < 0){
            return getNode(node.left, key);
        }else{ // key.compareTo(node.key) > 0)
            return getNode(node.right, key);
        }
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
        generateBST(root, 0, sb);
        return sb.toString();
    }

    public void generateBST(Node node, int depth, StringBuilder sb) {
        if (node == null){
            sb.append(generateDepth(depth) + "null\n");
            return;
        }
        sb.append(generateDepth(depth)+ node.toString() + "\n");
        generateBST(node.left,depth+1, sb);
        generateBST(node.right,depth+1, sb);
    }

    private String generateDepth(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BSTMap<String, Integer> map = new BSTMap<>();
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
