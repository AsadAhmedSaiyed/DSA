public class ReverseNodesInKGroup{
    
    public static class ListNode {
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

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private ListNode getEnd(ListNode start,int k){

        int count =0;
        while(count != k-1 && start != null){
            start = start.next;
            count++;
        }
        return start; 
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k==1){
            return head;
        }
       ListNode temp = head;
       ListNode end = getEnd(temp,k);
       if(end == null){
         return head; 
       }
       ListNode nextNode = end.next;
       end.next = null;
       ListNode newHead = reverse(temp);
       temp.next = reverseKGroup(nextNode,k);
        
       return newHead;
    }
    
}