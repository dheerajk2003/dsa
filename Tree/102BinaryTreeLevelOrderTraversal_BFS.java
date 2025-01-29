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

// in this we will see if the list size is less than the level then we will add a new list to the list and add the value to that list

class Solution {
    public List<List<Integer>> dfs(TreeNode root, int level, List<List<Integer>> ls){
        if(root == null)
            return ls;
        if(ls.size() <= level)
            ls.add(new ArrayList<>());
        ls.get(level).add(root.val);
        dfs(root.left, level +1, ls);
        dfs(root.right, level+1, ls);
        return ls;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        return dfs(root, 0, ls);
    }
}