class Solution {
    ArrayList<Integer> ls = new ArrayList<>();
    public void els(TreeNode node){
        if(node == null)
            return;
        els(node.left);
        ls.add(node.val);
        els(node.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        els(root);
        return ls.get(k-1);
    }
}

// this we will traverse the tree in infix order.