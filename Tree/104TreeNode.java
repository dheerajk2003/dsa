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

// In this we will send a integer depth and add 1 for each function call in recursion and store the returned values into extra variables l and r whichever is bigger we return that

class Solution {
    public int depth(TreeNode root, int depth){
        int l,r;
        if(root != null){
            l = depth(root.left, depth+1);
            r = depth(root.right, depth+1);
            return (l > r) ? l : r;
        }
        return depth;
    }
    public int maxDepth(TreeNode root) {
        int d = depth(root, 0);
        return d;
    }
}
