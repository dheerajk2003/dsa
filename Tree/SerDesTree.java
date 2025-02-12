class Codec {
    String ms="";
    public void prefix(TreeNode root){
        if(root == null)
            return;
        ms = ms+ Integer.toString(root.val) + "-";
        prefix(root.left);
        prefix(root.right);
    }
    public void infix(TreeNode root){
        if(root == null)
            return;
        infix(root.left);
        ms = ms+ Integer.toString(root.val) + "-";
        infix(root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
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
        String[] str = data.split(",");
        String[] first = str[0].split("-");
        String[] second = str[1].split("-");

        return bt(first,second, 0,second.length-1);
    }
}

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SerDesTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        Codec c = new Codec();
        String str = c.serialize(root);
        TreeNode nd = c.deserialize(str);
        str = "";
        c.ms = "";
        c.prefix(nd);
        System.out.println(c.ms);
    }
}