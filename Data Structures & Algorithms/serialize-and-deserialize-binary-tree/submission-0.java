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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder b = new StringBuilder();
        preOrder(root, b);
        return b.toString();
    }

    private void preOrder(TreeNode root ,StringBuilder b ){
        if(root == null)  {
            b.append("null,");
        }else{
            b.append(root.val + ",");
            preOrder(root.left , b);
            preOrder(root.right , b);
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> list  = new ArrayList(Arrays.asList(split));
        return preOrder(list);
    }
    private TreeNode preOrder(List<String> list){
        String s= list.get(0);
        if(s.equals("null")){
            list.remove(0);
            return null;
        }
        else{
            int num = Integer.parseInt(s);
            TreeNode root = new TreeNode(num);
            list.remove(0);
            root.left = preOrder(list);
            root.right = preOrder(list);
            return root;
        }
    }
}
