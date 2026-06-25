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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){ return null; }

        ListNode head = new ListNode(-1);
        ListNode current = head;
        ArrayList<ListNode> nodes = new ArrayList<>();
        for(ListNode listNode : lists){
            nodes.add(listNode);
        }
        // put to result
        while(nodes.size() > 0)
        { 
            //find largest
            int large = 0;
            for(int itr = 1 ; itr < nodes.size() ; itr ++){
                if(nodes.get(itr) == null) continue;
                if(nodes.get(itr).val < nodes.get(large).val){
                    large = itr;
                }
            }
            //put largest to result
            current.next = new ListNode(nodes.get(large).val);
            nodes.set(large, nodes.get(large).next);
            if(nodes.get(large) == null){
                nodes.remove(large);
            }
            current = current.next;
        }   
        // 
        if(head.next == null){ return null; }        
        return head.next;
    }
}
