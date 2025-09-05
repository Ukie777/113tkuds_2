import java.util.*;

public class LC23_MergeKLists_Hospitals {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        List<ListNode> lists = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < k; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            ListNode dummy = new ListNode(0), cur = dummy;
            for (String t : tokens) {
                int x = Integer.parseInt(t);
                if (x == -1) break;
                cur.next = new ListNode(x);
                cur = cur.next;
            }
            lists.add(dummy.next);
        }
        ListNode head = mergeKLists(lists.toArray(new ListNode[0]));
        printList(head);
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) if (node != null) pq.offer(node);
        ListNode dummy = new ListNode(0), tail = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) pq.offer(node.next);
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
