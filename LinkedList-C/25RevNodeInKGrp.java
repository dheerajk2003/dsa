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

// in this we will create a temp list and store the node till k in reverse order, then append it to another temp list tl

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;
        ListNode tempList = new ListNode(0, null);
        ListNode tl = tempList;
        int count = 0;
        ListNode temp = null;
        ListNode t = null;
        ListNode p = null;
        ListNode thead = null;
        while(head != null){
            temp = null;
            thead = null;
            int i;
            for(i = 0;head != null &&  i<k; i++){
                t = new ListNode(head.val, temp);
                if(temp == null){
                    p = head;
                    temp = t;
                    thead = t;
                }
                else{
                    t.next = temp;
                    temp = t;
                }
                head = head.next;
            }
            if(head != null || i == k){
                if(tl == null){
                    tl = temp;
                }
                else{
                    while(tl.next != null)
                        tl = tl.next;
                    tl.next = temp;
                }
            }
            else{
                while(tl.next != null)
                    tl = tl.next;
                tl.next = p;
            }
        }
        return tempList.next;
    }
}