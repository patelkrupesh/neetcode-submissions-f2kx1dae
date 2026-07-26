/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = null;
        ListNode itr = head;
        ListNode last = head;
        ListNode temp = null;
        while(itr != null){
            for(int i = 0 ; i < k ; i ++){
                if(itr != null){
                    stack.push(itr);
                    itr = itr.next;
                }else{
                    break;
                }
            }
            if(stack.size() < k){
                ListNode x = null;
                do{
                    x = stack.pop();
                }while (x!= null && !stack.isEmpty());
                last.next = x;
                break;
            }else{
                temp = stack.pop();
                last.next = temp;
                if(newHead == null){
                    newHead = temp;
                }
                while(!stack.isEmpty()){
                    ListNode following = stack.pop();
                    temp.next = following;
                    temp = following;
                }
                last = temp;
                if(itr == null){
                    last.next = null;
                }else{
                    last.next = itr;
                }
            }
        }
        return newHead;
    }
}
