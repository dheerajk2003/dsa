/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// we will compare everty node with subtree using isSameTree logic from 10000SameTree.java

class Solution {
     public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null || p.val != q.val)
            return false;
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;

        if(isSameTree(root, subRoot))
            return true;

        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }
}