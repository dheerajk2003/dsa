class Solution {
    ArrayList<Integer> ls = new ArrayList<>();
    public void els(TreeNode node){
        if(node == null)
            return;
        ls.add(node.val);
        els(node.left);
        els(node.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        els(root);
        Collections.sort(ls);
        return ls.get(k-1);
    }
}

// this we will do using an arrray and sort that array