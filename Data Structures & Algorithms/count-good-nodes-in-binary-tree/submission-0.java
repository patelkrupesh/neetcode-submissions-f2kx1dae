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
    List<TreeNode> goodNodes;
    public void dfs(TreeNode root, int currMax){
        if(root == null)
            return;        
        if(root.left!= null){
            if(root.left.val >= currMax){
                goodNodes.add(root.left);
                dfs(root.left, root.left.val);
            }else{
                dfs(root.left, currMax);
            }
        }
        if(root.right!= null){
            if(root.right.val >= currMax){
                goodNodes.add(root.right);
                dfs(root.right, root.right.val);
            }else{
                dfs(root.right, currMax);
            }
        }
    }
    public int goodNodes(TreeNode root) {
        goodNodes = new ArrayList<>();
        if(root == null) return 0;
        goodNodes.add(root);
        dfs(root, root.val);
        return goodNodes.size();
    }
}
