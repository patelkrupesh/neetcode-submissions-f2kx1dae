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
    public void reorderList(ListNode head) {
        if(head == null) return;

        // head is 1st pointer

        ListNode slow = head;
        ListNode fast = head;

        while( fast.next!= null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow;
        ListNode temp;
        ListNode prev = null;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        //prev is 2nd pointer

        ListNode first = head;
        ListNode second = prev;
        while(first != null && second != null){
            temp = first.next;
            first.next = second;
            first = temp;
            temp = second.next;
            second.next = first;
            second = temp;
        }
    }
}
