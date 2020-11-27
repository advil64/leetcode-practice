
class FlattenList {

    public Node flatten(Node head) {

        helper(head);
        return head;
    }

    public Node helper(Node currHead) {

        Node curr = currHead;
        Node next;
        Node subTail;
        Node prev = currHead;

        //get the tail of the list from recursive function
        while(curr != null){
            if(curr.child != null){
                next = curr.next;
                subTail = helper(curr.child);
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                subTail.next = next;
                if(next != null){
                    next.prev = subTail;
                }
            }
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
}

// // Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val, Node prev, Node next, Node child){
        this.val = val;
        this.prev = prev;
        this.next = null;
        this.child = null;
    }
};