import java.util.*;

public class LC24_SwapPairs_Shifts {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode dummy = new ListNode(0), cur = dummy;
        while (sc.hasNextInt()) {
            cur.next = new ListNode(sc.nextInt());
            cur = cur.next;
        }
        ListNode head = swapPairs(dummy.next);
        printList(head);
    }

    private static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null && head.next != null) {
            ListNode a = head, b = head.next;
            prev.next = b;
            a.next = b.next;
            b.next = a;
            prev = a;
            head = a.next;
        }
        return dummy.next;
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
