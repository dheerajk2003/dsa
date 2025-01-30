class Solution {
    public boolean valid(TreeNode root, long leftL, long rightL){
        if(root == null)
            return true;
        if(root.val <= leftL || root.val >= rightL)
            return false;
        return (valid(root.left, leftL, root.val) && (valid(root.right, root.val, rightL)));
    }
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}


// in this we will send the min value and the max value as the parameters if the root value is'nt in bount then its not valid bst