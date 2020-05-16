package main.java.trees;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Given a binary tree, populate an array to represent its level-by-level traversal.
 * You should populate the values of all nodes of each level from left to right in separate sub-arrays.
 */
class LevelOrderTraversal {

    private List<List<Integer>> levelOrderTraversal( BinaryTreeNode root ) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        Queue<BinaryTreeNode> eachLevelNodes = new LinkedList<>();
        eachLevelNodes.offer(root);
        while(!eachLevelNodes.isEmpty()) {
            int size = eachLevelNodes.size();
            List<Integer> eachLevelValues = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = eachLevelNodes.poll();
                eachLevelValues.add(node.value);

                if(node.left!=null){
                    eachLevelNodes.offer(node.left);
                }
                if(node.right!=null){
                    eachLevelNodes.offer(node.right);
                }
            }
            levelOrderList.add(eachLevelValues);
        }
        return levelOrderList;
    }

    @Test
    void shouldReturnSubArrays() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);
        System.out.println(levelOrderTraversal(root));
    }

    class BinaryTreeNode {
        private int value;
        private BinaryTreeNode right;
        private BinaryTreeNode left;

        public BinaryTreeNode() {
        }

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public BinaryTreeNode getRight() {
            return right;
        }

        public void setRight(BinaryTreeNode right) {
            this.right = right;
        }

        public BinaryTreeNode getLeft() {
            return left;
        }

        public void setLeft(BinaryTreeNode left) {
            this.left = left;
        }
    }
}
