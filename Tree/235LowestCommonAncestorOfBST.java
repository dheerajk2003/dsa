// in this we will find both nodes on left and right if we find them we return root otherwise se on which side the nodes are and call recursion on that side

class Solution {
    public boolean findOne(TreeNode root, TreeNode temp){
        if(root == null)
            return false;
        else if(root == temp)
            return true;
        return (findOne(root.left, temp) || findOne(root.right, temp));
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        boolean lp = findOne(root.left, p);
        boolean rp = findOne(root.right, p);
        boolean lq = findOne(root.left, q);
        boolean rq = findOne(root.right, q);
        if((root == p && (lq || rq)) || (root == q && (lp || rp)) || (lp && rq) || (rp && lq))
            return root;
        else if(lp && lq)
            return lowestCommonAncestor(root.left, p, q);            
        else if(rp && rq)
            return lowestCommonAncestor(root.right, p, q);
        return null;
    }
}