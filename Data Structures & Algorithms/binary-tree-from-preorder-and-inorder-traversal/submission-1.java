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

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {       
        if(preorder.length==0) return new TreeNode();
        TreeNode root = new TreeNode(preorder[0]);
        int i;
        for(i = 0; i<inorder.length;i++){
            if(inorder[i] == preorder[0]){
                break;
            }
        }
        //i is size of left subtree
        if(i > 0){
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder, 0, i));
        }
        int remaining = preorder.length - 1 - i;
        if(remaining > 0){
            root.right = buildTree(Arrays.copyOfRange(preorder, 1+i, preorder.length), Arrays.copyOfRange(inorder, 1+i, inorder.length));
        }
        return root;
    }
}
