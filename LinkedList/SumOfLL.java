public class SumOfLL {
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        
        while(l1 != null || l2 != null || carry != 0){
            
            int d1 = (l1 != null)? l1.val : 0;
            int d2 = (l2 != null)? l2.val : 0;
            int sum = d1 + d2 + carry;
            int d =  sum % 10;
            ListNode temp = new ListNode(d);
            carry = sum / 10;
            curr.next = temp;
            curr = curr.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        return dummy.next;
    }
}
