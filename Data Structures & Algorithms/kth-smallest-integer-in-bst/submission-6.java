// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */

class Solution {
    int value, cnt;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return value;
    }
    void inorder(TreeNode root, int k) {
        if (root == null || cnt == k) {
            return;
        }
        inorder(root.left, k);
        if (cnt < k) {
            cnt++;
            if (cnt == k) {
                value = root.val;
                return;
            }
        }
        inorder(root.right, k);
    }
}