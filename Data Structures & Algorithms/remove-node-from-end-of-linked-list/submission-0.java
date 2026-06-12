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
    private int getSize(ListNode head){
        int size = 0;
        ListNode temp = head;
        while(temp!= null){
            temp = temp.next;
            size++; 
        }
        return size;
    }
    private void deleteNode(ListNode node){
        node.next = null;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getSize(head); 
        int remove = size - n + 1;
        int curr = 1;
        ListNode temp = head;
        if(remove <= 0){
        }else if(remove == 1){
            head = head.next;
        }
        else{
            while(curr != remove -1){
                temp = temp.next;
                curr++;
            }
            ListNode removeThis = temp.next;
            temp.next = temp.next.next;
            deleteNode(removeThis);
        }
        return head;
    }
}
