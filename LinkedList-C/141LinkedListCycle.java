/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//in this we will use two pointer approach if there is a cycle then the fast pointer will meet the slow pointer evertually after cycling, if not the fast pointer will be null

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode fast = head.next;
        while(head != null){
            if(head == fast)
                return true;
            if(fast == null || fast.next == null)
                return false;
            head = head.next;
            fast = (fast.next).next;
        }
        return false;
    }
}