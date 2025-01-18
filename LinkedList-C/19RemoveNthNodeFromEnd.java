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

// in this we will move the fast pointer by n+1 steps and then move the slow pointer until the fast pointer becomes null and then the slow pointer's next node will be the node to be deleted

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null)
            return null;
        ListNode fast = head, temp = head;
        for(int i = 0; i<n; i++)
            fast = fast.next;
        if(fast == null)
            return head.next;
        fast = fast.next;
        while(fast != null){
            temp = temp.next;
            fast = fast.next;
        }
        temp.next = (temp.next).next;
        return head;
    }
}