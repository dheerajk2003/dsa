class Solution {
    int l = 0;
    public TreeNode bt(int[] preorder, int[] inorder, int left, int right){
        if(left > right)
            return null;
        TreeNode root = new TreeNode(preorder[l]);
        int i = left;
        while(i<=right && inorder[i] != preorder[l])
            i++;
        l++;
        root.left = bt(preorder, inorder,left ,i-1);
        root.right = bt(preorder, inorder,i+1,right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return bt(preorder,inorder, 0,preorder.length-1);
    }
}

// In this we will send left and right values as limiters, get the value of i by getting the index froom inorder