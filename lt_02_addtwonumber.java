class lt_02_addtwonumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 建立一個虛擬頭節點，方便操作
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        int carry = 0; // 進位

        // 當 l1 或 l2 還有數字，或進位不為 0 時，繼續相加
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10; // 更新進位
            current.next = new ListNode(sum % 10); // 建立新節點存放個位數
            current = current.next;

            // 移動到下一個節點
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // 回傳真正的頭節點
        return dummyHead.next;
    }
}