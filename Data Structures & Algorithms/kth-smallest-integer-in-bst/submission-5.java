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

// class Solution {
//     Stack<TreeNode> s = new Stack<>();
//     static int count = 0;
//     public int kthSmallest(TreeNode root, int k) {        
//         if(root == null)
//             return -1;
//         if(root.left!= null){
//             System.out.println("pushing left : " + root.left.val);
//             s.push(root.left);
//         }
//         int num = s.pop().val;
//         count++;
//         System.out.println("k : "+ count + " , val : " + num);
//         if(count == k){
//             return num;
//         }
//         if(root.right != null){
//             System.out.println("pushing right : " + root.right.val);
//             s.push(root.right);
//         }
//         return -1;
//     }
// }
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