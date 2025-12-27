public class MergeKSortedLL {
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
    private ListNode merge(ListNode left,ListNode right){
        ListNode newHead = new ListNode(-1);
        ListNode temp = newHead;
        while(left != null && right != null){
          if(left.val<=right.val){
             temp.next = left;
             left = left.next;
          }else{
             temp.next = right;
             right = right.next;
          }
          temp = temp.next;
        }
        while(left != null){
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while(right != null){
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return newHead.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
       if(lists.length == 0){
         return null;
       }
       for(int i=1;i<lists.length;i++){
         lists[0] = merge(lists[0],lists[i]);
       }
       return lists[0];
    }
}
