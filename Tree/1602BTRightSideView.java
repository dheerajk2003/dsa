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

//if the level already exists dont insert

class Solution {
    public List<Integer> rsv(TreeNode root, int level, List<Integer> ls){
        if(root == null)
            return ls;
        if(ls.size()<=level)
            ls.add(root.val);
        rsv(root.right, level+1, ls);
        rsv(root.left, level+1, ls);
        return ls;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        return rsv(root,0, ls);
    }
}
