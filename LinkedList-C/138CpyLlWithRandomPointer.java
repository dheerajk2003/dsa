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

// in this we will create a new list and store the every old node with new node in hash map , and retrieve the random node from the hash map corresponding to the old node

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        HashMap<Node, Node> hm = new HashMap<>();
        Node h = head;
        Node dummy = new Node(0);
        Node cpList = dummy;
        while(head != null){
            Node temp = new Node(head.val);
            hm.put(head, temp);
            cpList.next = temp;
            cpList = cpList.next;
            head = head.next;
        }
        cpList = dummy.next;
        head = h;
         while (head != null) {
            cpList.random = hm.get(head.random); 
            head = head.next; 
            cpList = cpList.next;
        }
        return dummy.next;
    }
}