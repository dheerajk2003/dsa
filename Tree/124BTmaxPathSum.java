class Solution {
    int max = Integer.MIN_VALUE;
    public int mp(TreeNode root) {
        if(root == null)
            return 0;
        int temp[] = new int[6];
        temp[0] = mp(root.left);
        temp[1] = mp(root.right);
        temp[2] = (temp[0] > temp[1]) ? temp[0] : temp[1];
        temp[3] = root.val + temp[2];
        temp[4] = root.val+temp[0]+temp[1];
        temp[5] = root.val;
        for (int i=3; i<6; i++)
            if(temp[i] > max)
                max = temp[i];
        return (temp[3]>root.val)? temp[3] : root.val;
    }
    public int maxPathSum(TreeNode root){
        mp(root);
        return max;
    }
}

// In this problem we will first get the left and right nodes max path then compare max with current node, current node + larger path from left & right , current node + left + right and return the bigger out of current node and current node + large node.
 