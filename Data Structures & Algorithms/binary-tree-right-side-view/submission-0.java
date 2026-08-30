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
    public class PairNode{
        Integer level;
        TreeNode node;
        public PairNode(Integer level, TreeNode node){
            this.level = level;
            this.node = node;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        if(root == null)
            return rightSide;        
        Queue<PairNode> q = new LinkedList<>();
        q.add(new PairNode(0, root));
        rightSide.add(root.val);
        while(!q.isEmpty()){
            PairNode p = q.poll();
            TreeNode n = p.node;
            if(n.left != null){
                q.add(new PairNode(p.level + 1, n.left));
            }
            if(n.right != null){
                q.add(new PairNode(p.level + 1, n.right));
            }  
            if(rightSide.size() > p.level){
                rightSide.set(p.level, n.val);
            }else{
                rightSide.add(n.val);
            }
        }
        return rightSide;
    }
}
