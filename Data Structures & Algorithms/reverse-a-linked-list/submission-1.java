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
        if(head == null){               
            return null;
        }
        ListNode prev = head;
        ListNode save = head.next;
        head.next = null;
        head = save;
        while(head != null){
            save = head.next;
            head.next = prev;            
            prev = head;
            head = save;
        }
        return prev;
    }
}
