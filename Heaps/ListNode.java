import java.util.*;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

//add all head in PQ
//take min and add in ans ll and move iterator of that one
//repeat until pq is empty

class MergeKSortedLL {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a, b) -> a.val - b.val);

        // add first node of each list
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (!pq.isEmpty()) {
            ListNode curr = pq.remove();
            temp.next = curr;
            temp = temp.next;

            // push next node of same list
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }

        return dummy.next;
    }
}
