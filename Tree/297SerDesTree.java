/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Codec {
    String ms="";
    public void prefix(TreeNode root){
        if(root == null)
            return;
        ms = ms+ Integer.toString(root.val) + ":";
        prefix(root.left);
        prefix(root.right);
    }
    public void infix(TreeNode root){
        if(root == null)
            return;
        infix(root.left);
        ms = ms+ Integer.toString(root.val) + ":";
        infix(root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        String str;
        prefix(root);
        str = ms;
        str = str.substring(0, str.length()-1);
        ms= "";
        infix(root);
        str = str + "," + ms;
        str = str.substring(0, str.length()-1);
        return str;
    }

    int l = 0;
    public TreeNode bt(String[] preorder, String[] inorder, int left, int right){
        if(left > right)
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(preorder[l]));
        int i = left;
        while(i<=right && Integer.parseInt(inorder[i]) != Integer.parseInt(preorder[l]))
            i++;
        l++;
        root.left = bt(preorder, inorder,left ,i-1);
        root.right = bt(preorder, inorder,i+1,right);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;
        String[] str = data.split(",");
        String[] first = str[0].split(":");
        String[] second = str[1].split(":");
        l=0;
        return bt(first,second, 0,second.length-1);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));