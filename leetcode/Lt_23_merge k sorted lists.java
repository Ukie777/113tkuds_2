import java.util.*;

// 定義鏈結串列節點
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        // 小根堆，按節點值排序
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        
        // 將非空串列的頭節點加入堆
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            tail.next = curr;
            tail = tail.next;
            
            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }
        
        return dummy.next;
    }

    // 測試
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = new ListNode[]{l1, l2, l3};
        
        ListNode merged = sol.mergeKLists(lists);
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
        // 輸出: 1 1 2 3 4 4 5 6
    }
}

