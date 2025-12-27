
public class OddEven {
    public static class ListNode {
        @SuppressWarnings("unused")
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static ListNode head;
    public static ListNode tail;
    public static int size;

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode temp = head.next;
        ListNode even = head.next;
        while(odd.next != null && even.next != null){
            odd.next = odd.next.next;
            odd =odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        
        odd.next = temp;
        return head;
    }
}
