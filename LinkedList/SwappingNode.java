public class SwappingNode {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int data) {
            this.val = data;
            this.next = null;
        }
    }

    public static ListNode head;
    public static ListNode tail;
    public static int size;

    public ListNode swapNodes(ListNode head, int k) {

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        ListNode first = fast;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode second = slow;
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
}
