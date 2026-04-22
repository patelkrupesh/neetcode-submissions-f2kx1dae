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
    public ListNode reverseList(ListNode head) {
        Stack<Integer> s = new Stack<>();
        while(head!= null){
            s.push(head.val);
            head = head.next;
        }         
        ListNode newHead; 
        if(s.isEmpty()){               
            return null;
        }
        newHead = new ListNode(s.pop()); 
        ListNode curr = newHead;
        ListNode prev = newHead;
        while(!s.isEmpty()){
            int val = s.pop();
            curr = new ListNode(val);   
            prev.next = curr;   
            prev = curr;                  
        }
        return newHead;
    }
}
