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

// in this we need to check the longest path in a tree so we just compare the left depth + right depth with max path 

class Solution {
    int length = 0;
    public int depth(TreeNode root){
        if(root == null)
            return 0;

        int l=depth(root.left);
        int r=depth(root.right);

        length = Math.max(length, l+r);
        return Math.max(l,r)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return length;
    }
}