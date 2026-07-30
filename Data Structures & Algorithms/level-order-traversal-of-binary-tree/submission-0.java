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
    private void addNodes(List<List<Integer>> ans, Queue<TreeNode> q){
        List<Integer> list = new ArrayList<>();
        for(TreeNode node : q){
            list.add(node.val);
        }
        if(!list.isEmpty()){
            ans.add(list);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        q.offer(root);
        while(!q.isEmpty()){
            addNodes(ans, q);
            int size = q.size();
            for(int itr = 0; itr < size ; itr ++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
        }
        return ans;
    }
}
