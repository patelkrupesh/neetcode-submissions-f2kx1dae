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
    int prev = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
          return true;
        /*if(root.val > prev)
          return false;
         else
          prev = root.val;
          */
        boolean left = isValidBST(root.left);
        if (! left)
          return false;

        if (root.val <= prev)
          return false;
        else 
          prev = root. val;

         boolean right = isValidBST(root.right);
         if(! right)
           return false;

        return true;
    }
}
