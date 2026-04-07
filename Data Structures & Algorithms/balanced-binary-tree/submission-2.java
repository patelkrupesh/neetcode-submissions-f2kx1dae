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
    private Integer getHeight(TreeNode node){
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 1;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return (Math.max(left, right) + 1);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right); 
        if(Math.abs(left - right) >1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
}
