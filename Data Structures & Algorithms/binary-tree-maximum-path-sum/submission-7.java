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
    private int dfs(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        int left = Math.max(0, leftMax);
        int right = Math.max(0, rightMax);
        int maxIncludingThis = left+right+root.val;
        if(maxIncludingThis > max){
            max = maxIncludingThis;
        }
        return Math.max(left, right) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
}
