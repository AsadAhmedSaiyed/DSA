

public class CopyLL {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node dummy = new Node(-1);
        dummy.next = head;
        Node curr =head;
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        curr = head;
        while(curr != null){
            Node copy = curr.next;
            if(curr.random != null){
                copy.random = curr.random.next;
            }
            curr = copy.next;
        }

        curr = head;
        Node copyHead = head.next;
        while(curr != null){
            Node copy = curr.next;
            curr.next = copy.next;
            if(copy.next != null){
                copy.next = copy.next.next;
            }
            curr = curr.next;
        }
        return copyHead;
    }
}
