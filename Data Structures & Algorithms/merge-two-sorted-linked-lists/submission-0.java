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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      ListNode head = new ListNode(-1); 
      ListNode result = head; 
      ListNode leftPtr = list1;
      ListNode rightPtr = list2;

      while(leftPtr!= null && rightPtr!= null){
        if(leftPtr.val < rightPtr.val){
          ListNode newNode = new ListNode(leftPtr.val);
          leftPtr = leftPtr.next;
          head.next = newNode;
          head = newNode;
        }else{
          ListNode newNode = new ListNode(rightPtr.val);
          rightPtr = rightPtr.next;
          head.next = newNode;
          head = newNode;
        }        
      }
      while(leftPtr!= null){        
        ListNode newNode = new ListNode(leftPtr.val);
        leftPtr = leftPtr.next;
        head.next = newNode;
        head = newNode;
      }
      while(rightPtr!= null){        
        ListNode newNode = new ListNode(rightPtr.val);
        rightPtr = rightPtr.next;        
        head.next = newNode;
        head = newNode;
      }
      head.next = null;
      return result.next;
    }
}