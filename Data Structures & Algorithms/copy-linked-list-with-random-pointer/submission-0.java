/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
                
        Map<Node, Node> map = new HashMap<>();        
        Node copiedHead = new Node(head.val);
        Node tempOrg = head;
        Node tempCpy = copiedHead;
        map.put(head, copiedHead);

        while (tempOrg.next != null){            
            tempCpy.next = new Node(tempOrg.next.val);                        
            map.put(tempOrg.next, tempCpy.next);
            tempCpy = tempCpy.next;
            tempOrg = tempOrg.next;
        }

        tempOrg = head;
        tempCpy = copiedHead;
        while (tempOrg != null){                        
            tempCpy.random = map.get(tempOrg.random);    
            tempCpy = tempCpy.next;
            tempOrg = tempOrg.next;        
        }

        return copiedHead;
    }
}
