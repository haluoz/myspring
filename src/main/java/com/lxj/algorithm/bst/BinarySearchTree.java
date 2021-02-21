package com.lxj.algorithm.bst;

import com.lxj.algorithm.stack.ArrayStack;

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

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        int [] nums = {5,3,6,8,4,2};
        for (int num:nums) {
            tree.addRecursion(num);
        }
        tree.preOrder();
        System.out.println();
        tree.preOrderRecursion();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.postOrder();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBST(root, 0, sb);
        return sb.toString();
    }

    private void generateBST(Node node, int depth, StringBuilder sb) {
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
