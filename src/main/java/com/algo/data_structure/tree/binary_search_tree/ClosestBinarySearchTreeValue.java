package com.algo.data_structure.tree.binary_search_tree;

public class ClosestBinarySearchTreeValue {

    private class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
    }

    public int closestValue(TreeNode root, double target) {
        double min = Double.MAX_VALUE;
        int result = root.val;

        while (root != null) {
            if (target > root.val) {

                double diff = Math.abs(root.val - target);
                if (diff < min) {
                    min = Math.min(min, diff);
                    result = root.val;
                }
                root = root.right;
            } else if (target < root.val) {

                double diff = Math.abs(root.val - target);
                if (diff < min) {
                    min = Math.min(min, diff);
                    result = root.val;
                }
                root = root.left;
            } else {
                return root.val;
            }
        }

        return result;
    }
}
