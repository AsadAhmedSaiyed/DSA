public class DeleteNAfterM {
    static void linkdelete(Node head, int n, int m) {
        // your code here
        Node temp1 = head;

        while (temp1 != null) {
            int count1 = 0;
            int count2 = 0;
            while (count1 < m - 1 && temp1 != null) {
                temp1 = temp1.next;
                count1++;
            }
            if (temp1 == null) {
                return;
            }
            Node temp2 = temp1.next;

            while (count2 < n && temp2 != null) {
                temp2 = temp2.next;
                count2++;
            }
            temp1.next = temp2;
            temp1 = temp1.next;
        }
    }
}
