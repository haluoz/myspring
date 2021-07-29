package com.lxj.leetcode.bst;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SerializedBSTOffer37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> queue = new LinkedList<>();
//        sb.append("[");
        queue.addLast(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node !=null) {
                sb.append(node.val + ",");
                queue.addLast(node.left);
                queue.addLast(node.right);
            } else {
              sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length()-1);
//        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data == ""){
            return null;
        }
        String[] strings = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (strings[i].equals("null")){
                i++;
            }else{
                queue.add(node.left = new TreeNode(Integer.parseInt(strings[i])));
                i++;
            }
            if (strings[i].equals("null")){
                i++;
            }else {
                queue.add(node.right = new TreeNode(Integer.parseInt(strings[i])));
                i++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        SerializedBSTOffer37 solution = new SerializedBSTOffer37();
        TreeNode treeNode = new TreeNode(1 , new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        String serializedObject = solution.serialize(treeNode);
        System.out.println(serializedObject);
        TreeNode deserializedTree = solution.deserialize(serializedObject);
        System.out.println(deserializedTree);
    }
}
