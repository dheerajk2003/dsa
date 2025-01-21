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
        if(lists.length <= 0)
            return null;
        ListNode list = new ListNode(0, null);
        ListNode newList = list;
        ListNode temp = new ListNode(40000);  
        int nullCount = 0;
        while(nullCount < lists.length){
            ListNode min = temp;
            int pos=-1;
            nullCount = 0;
            for(int i=0; i<lists.length; i++){
                if(lists[i] != null){
                    if(lists[i].val < min.val){
                        min = lists[i];
                        pos = i;
                    }
                } 
                else 
                    nullCount++;
            }
            if(pos >= 0 && lists[pos] != null){
                ListNode tmp = new ListNode(min.val, null);
                newList.next = tmp;
                newList = newList.next;
                lists[pos] = lists[pos].next;
            }
            
        }
        return list.next;
    }
}