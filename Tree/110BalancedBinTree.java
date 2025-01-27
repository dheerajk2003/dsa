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

// in this we will just find the depth of every node's left and right child using recursion' if the difference is greater than 1 then return -20000

class Solution {
    public int bal(TreeNode root){
        if(root == null)
            return 0;

        int ld = bal(root.left);
        int rd = bal(root.right);
        if(Math.max(ld,rd) - Math.min(ld,rd) > 1)
            return -20000;
        return Math.max(ld,rd) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        int num = bal(root);
        if(num < 0)
            return false;
        return true;
    }
}