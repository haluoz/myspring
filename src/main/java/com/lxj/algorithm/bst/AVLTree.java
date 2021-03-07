package com.lxj.algorithm.bst;

import com.lxj.algorithm.map.BSTMap;

import java.util.ArrayList;

/**
 * @author Administrator
 */
public class AVLTree<K extends Comparable<K>, V> {
    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
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

    public AVLTree() {
        size = 0;
        root = null;
    }

    //获得node节点高度
    public int getHeight(Node node){
        if (node == null){
            return 0;
        }
        return node.height;
    }

    public boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i-1).compareTo(keys.get(i)) > 0){
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null){
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right,keys);
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null){
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1){
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private int getBalanceFactor(Node node){
        if (node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    /**                 向右旋转
     *          y                        x
     *         / \                     /   \
     *        x   t4                  z     y
     *       / \                     / \   / \
     *      z   t3       ----->     t1 t2 t3 t4
     *     / \
     *    t1  t2
     */
    private Node rightRotate(Node y){
        Node x = y.left;
        Node t3 = x.right;
        //右旋
        x.right = y;
        y.left = t3;
        //更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) +1;
        x.height = Math.max(getHeight(y.left), getHeight(y.right)) +1;
        return x;
    }

    /**                 向左旋转
     *          y                           x
     *        /   \                       /   \
     *       t1    x                     y     z
     *            / \                   / \   / \
     *           t2  z       ----->    t1 t2 t3 t4
     *              / \
     *             t3  t4
     */
    private Node leftRotate(Node y){
        Node x = y.right;
        Node t2 = x.left;
        //左旋
        x.left = y;
        y.right = t2;
        //更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) +1;
        x.height = Math.max(getHeight(y.left), getHeight(y.right)) +1;
        return x;
    }

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
        //更新heigh
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1){
            System.out.println("unbalanced: "+balanceFactor);
        }
        //平衡维护
        //LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0 ) {
            return rightRotate(node);
        }
        //RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0){
            return leftRotate(node);
        }
        //LR
        if (balanceFactor >1 && getBalanceFactor(node.left) < 0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

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
        //TODO cannot remove node
        Node retNode;
        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            retNode = node;
        }else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            retNode = node;
        }else { // key.compareTo(node.key) == 0
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            }
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            }
            // 找到比待删除的节点大的最小节点，用这个节点代替删除节点位置
            Node successor = minimum(node.right);
            successor.right = remove(node.right, successor.key);
            successor.left = node.left;
            node.left = node.right = null;
            retNode = successor;
        }
        if (retNode == null){
            return null;
        }
        //更新height
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
        // 计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);
        if (Math.abs(balanceFactor) > 1){
            System.out.println("unbalanced: "+balanceFactor);
        }
        //平衡维护
        //LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0 ) {
            return rightRotate(retNode);
        }
        //RR
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0){
            return leftRotate(retNode);
        }
        //LR
        if (balanceFactor >1 && getBalanceFactor(retNode.left) < 0){
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        //RL
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0){
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }
        return retNode;
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

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V val) {
        Node node = getNode(root, key);
        if (node == null){
            throw new IllegalArgumentException("key does not exist");
        }else {
            node.value = val;
        }
    }

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

    public int getSize() {
        return size;
    }

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
        AVLTree<String, Integer> map = new AVLTree<>();
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
        System.out.println("is binary search tree " + map.isBST());
        System.out.println("is balanced binary search tree "+map.isBalanced());
        for (String word : words) {
            map.remove(word);
            if (! map.isBST() && !map.isBalanced()){
                throw new RuntimeException("AVL Tree error");
            }
        }

    }
}
