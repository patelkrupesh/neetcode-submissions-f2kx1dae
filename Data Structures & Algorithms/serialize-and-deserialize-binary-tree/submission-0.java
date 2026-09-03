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
    private final String NULL = "N";    
    private int index = 0;
    private String dfsSerialize(TreeNode root) {        
        if(root == null){
            return ","+NULL;
        }
        String str = ((Integer)root.val).toString();        
        String left = dfsSerialize(root.left);
        String right = dfsSerialize(root.right);
        // System.out.println(str+left+right);
        return ","+str+left+right;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {        
        String k =  dfsSerialize(root);
        // System.out.println(k);
        return k;
    }

    private TreeNode dfsDeserialize(String [] strs){
        if(index >= strs.length){
            return null;
        }        
        if(NULL.equals(strs[index])){
            index++;
            return null;
        }
        // System.out.println(strs[index]);
        Integer i = Integer.parseInt(strs[index]);
        TreeNode curr = new TreeNode(i);
        index++;
        curr.left = dfsDeserialize(strs);
        curr.right = dfsDeserialize(strs);
        return curr;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] strs = data.split(",");  
        if(strs.length == 0) return  new TreeNode();
        index=1;
        TreeNode root = dfsDeserialize(strs);
        return root;
    }
}
