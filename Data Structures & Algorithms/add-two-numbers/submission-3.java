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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = null;
        if(l1== null && l2== null){
            return null;
        }
        ListNode resultPtr = null;
        ListNode l1ptr = l1;
        ListNode l2ptr = l2;
        Boolean carry = false;
        ListNode prev = null;
        while(l1ptr!= null && l2ptr!= null){
            int sum = l1ptr.val + l2ptr.val + (carry ? 1 : 0);
            carry = sum >= 10 ? true : false;
            resultPtr = new ListNode(carry ? sum-10 : sum);
            System.out.println(resultPtr.val);
            l1ptr = l1ptr.next;
            l2ptr = l2ptr.next;
            if(prev != null){
                prev.next = resultPtr;            
            }else{
                resultHead = resultPtr;
            }
            prev = resultPtr;
        }
        while(l1ptr!= null){
            if(carry){
                int sum =l1ptr.val+1;
                carry = sum >= 10 ? true : false;
                resultPtr = new ListNode(carry ? sum-10 : sum);
                System.out.println(resultPtr.val);
                l1ptr = l1ptr.next;
                if(prev != null){
                prev.next = resultPtr;            
                }else{
                    resultHead = resultPtr;
                }
                prev = resultPtr;   
            }
            else{
                resultPtr = new ListNode(l1ptr.val);
                l1ptr = l1ptr.next;
                prev.next = resultPtr; 
                prev = resultPtr; 
            }
        }
        while(l2ptr!= null){
            if(carry){
                int sum =l2ptr.val+1;
                carry = sum >= 10 ? true : false;
                resultPtr = new ListNode(carry ? sum-10 : sum);
                System.out.println(resultPtr.val);
                l2ptr = l2ptr.next;
                if(prev != null){
                prev.next = resultPtr;            
                }else{
                    resultHead = resultPtr;
                }
                prev = resultPtr;   
            }else{
                resultPtr = new ListNode(l2ptr.val);
                l2ptr = l2ptr.next;
                prev.next = resultPtr; 
                prev = resultPtr; 
            }
        }
        if(carry){
            resultPtr = new ListNode(1);
            prev.next = resultPtr; 
        }
        return resultHead;
    }
}
