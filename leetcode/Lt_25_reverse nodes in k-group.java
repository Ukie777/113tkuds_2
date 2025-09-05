class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // 檢查是否有足夠 k 個節點
            ListNode kth = prevGroupEnd;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) break; // 不足 k 個節點，結束

            // 反轉 k 個節點
            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;

            // 反轉鏈表區段
            ListNode prev = nextGroupStart;
            ListNode curr = groupStart;
            while (curr != nextGroupStart) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            // 連接前一區段
            prevGroupEnd.next = kth;
            prevGroupEnd = groupStart; // 移動到下一區段前
        }

        return dummy.next;
    }

    // 測試
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 2;
        ListNode result = sol.reverseKGroup(head, k);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // 輸出: 2 1 4 3 5
    }
}