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
    int max = Integer.MIN_VALUE;
    private int biggestWay(TreeNode root){
        if(root== null){
            return 0;
        }
        int left = biggestWay(root.left);
        int right = biggestWay(root.right);
        int path = root.val + Math.max(left, right);
        return Math.max(0, path);
        // return Math.max(root.val + Math.max(left, right), root.val);
    }
    private void dfs(TreeNode root) {
        if(root==null){
            return;
        }
        

        int left = biggestWay(root.left);
        int right = biggestWay(root.right);
        // int currMax = Math.max(Math.max(root.val, left+right+root.val), Math.max(left+root.val, right+root.val));
        int currMax = root.val + left + right;
        if(currMax > max){
            max = currMax;
        }
        dfs(root.left);
        dfs(root.right);
    }
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return max;
    }
}
