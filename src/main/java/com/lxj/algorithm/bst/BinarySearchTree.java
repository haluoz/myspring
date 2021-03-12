package com.lxj.algorithm.bst;

import com.lxj.algorithm.queue.ArrayQueue;
import com.lxj.algorithm.stack.ArrayStack;

import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public void addRecursion(E e){
        root = addRecursion(root, e);
//        if(root == null){
//            root = new Node(e);
//            size++;
//        }else{
//            addRecursion(root, e);
//        }
    }

    private Node addRecursion(Node node, E e){
//        if (e.equals(node.e)){
//            return;
//        }else if (e.compareTo(node.e) < 0 && node.left == null){
//            node.left = new Node(e);
//            size++;
//            return;
//        }else if (e.compareTo(e) > 0 && node.right == null){
//            node.right = new Node(e);
//            size++;
//            return;
//        }
        if (node == null){
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0){
            node.left = addRecursion(node.left, e);
        }else if (e.compareTo(node.e) > 0){
            node.right = addRecursion(node.right, e);
        }
        return node;
    }

    public Node getRoot(){
        return this.root;
    }

    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node node, E e){
        if (node == null){
            return false;
        }
        if (e.compareTo(node.e) == 0){
            return true;
        }else if (e.compareTo(node.e) < 0){
            return contains(node.left, e);
        }else if(e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        }
        return false;
    }

    public void preOrder(){
        ArrayStack<Node> stack = new ArrayStack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void preOrderRecursion(){
        preOrder(root);
    }

    //前序遍历
    private void preOrder(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    //中序遍历
    private void inOrder(Node node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    //中序遍历
    private void postOrder(Node node){
        if (node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void levelOrder(){
        ArrayQueue<Node> queue = new ArrayQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()){
            Node cur = queue.dequeue();
            System.out.println(cur.e);
            if (cur.left != null){
                queue.enqueue(cur.left);
            }
            if (cur.right != null){
                queue.enqueue(cur.right);
            }
        }
    }

    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
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

    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public E minimum(){
        if (size ==0){
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }

    /**
     * 返回二分搜索树中最小节点的值
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    public E maximum(){
        if (size ==0){
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    /**
     * 返回二分搜索树中最小节点的值
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null){
            return node;
        }
        return minimum(node.right);
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int maxDepth(Node root) {
        return calDepth(root, 0);
    }

    public int calDepth(Node node, int depth){
        if(node == null){
            return depth;
        }
        int leftDepth = calDepth(node.left, depth+1);
        int rightDepth = calDepth(node.right, depth+1);
        if(leftDepth > rightDepth){
            return leftDepth;
        }else{
            return rightDepth;
        }
    }

    public Node mirrorTree(Node root) {
        Stack<Node> stack  = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
            Node temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }

    public static void main(String[] args) {
        int [] nums = {9,3,20,15,7};
        Queue<Integer> queue = new LinkedList<Integer>();
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
//        int [] nums = {5,3,6,8,4,2};
//        for (int num:nums) {
//            tree.addRecursion(num);
//        }
//        tree.preOrder();
//        System.out.println();
//        tree.preOrderRecursion();
//        System.out.println();
//        tree.inOrder();
//        System.out.println();
//        tree.postOrder();
//        Random random = new Random();
//        for (int i = 0; i < 1000; i++) {
//            tree.addRecursion(random.nextInt(10000));
//        }
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        while (!tree.isEmpty()){
//            arrayList.add(tree.removeMin());
//        }
//        System.out.println(arrayList);
//        for (int i = 1; i < arrayList.size(); i++) {
//            if (arrayList.get(i-1) > arrayList.get(i)){
//                throw new IllegalArgumentException("ERROR");
//            }
//        }
//        System.out.println("remove min success");
    }

    public void remove(E e){
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null){
            return null;
        }
        if (e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }else if (e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }else { // e == node.e
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
        sb.append(generateDepth(depth)+ node.e + "\n");
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
}
