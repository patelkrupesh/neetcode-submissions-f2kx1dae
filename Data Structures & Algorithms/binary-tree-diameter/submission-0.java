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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int left = 0;
        int right = 0;
        if(root.left != null){
            left = diameterOfBinaryTree(root.left);
        }
        if(root.right != null){
            right = diameterOfBinaryTree(root.right);
        }
        int dec = Math.max(left, right);
        return Math.max(dec, (maxDepth(root.left) + maxDepth(root.right)));
    }
    public int maxDepth(TreeNode root) {
        int height = 0;
        if(root == null) return height;               
        height++;
        if(root.left == null && root.right == null){
            return height;
        }
        int leftHeight = 1 + maxDepth(root.left);
        int rightHeight = 1 + maxDepth(root.right);        
        return Math.max(leftHeight, rightHeight);
    }
}
