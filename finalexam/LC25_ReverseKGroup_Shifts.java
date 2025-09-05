import java.util.*;

public class LC25_ReverseKGroup_Shifts {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        ListNode dummy = new ListNode(0), cur = dummy;
        while (sc.hasNextInt()) {
            cur.next = new ListNode(sc.nextInt());
            cur = cur.next;
        }
        ListNode head = reverseKGroup(dummy.next, k);
        printList(head);
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (true) {
            ListNode tail = prev;
            for (int i = 0; i < k && tail != null; i++) tail = tail.next;
            if (tail == null) break;

            ListNode next = tail.next;
            ListNode[] reversed = reverse(head, tail);
            head = reversed[0];
            tail = reversed[1];

            prev.next = head;
            tail.next = next;
            prev = tail;
            head = next;
        }
        return dummy.next;
    }

    private static ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next, cur = head;
        while (prev != tail) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return new ListNode[]{tail, head};
    }

    private static void printList(ListNode head) {
        boolean first = true;
        while (head != null) {
            if (!first) System.out.print(" ");
            System.out.print(head.val);
            first = false;
            head = head.next;
        }
        if (!first) System.out.println();
    }
}
