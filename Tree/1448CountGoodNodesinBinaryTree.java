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
class Solution {
    int len=0;
    public void nodes(TreeNode root, int max){
        if(root == null)
            return;
        if(root.val >= max){
            len++;
            max = root.val;
        }
        nodes(root.left, max);
        nodes(root.right, max);
    }
    public int goodNodes(TreeNode root) {
        nodes(root, root.val);
        return len;
    }
}