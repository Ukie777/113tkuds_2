/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0); // 虛擬頭節點
        dummy.next = head;
        ListNode prev = dummy;
        
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;
            
            // 交換節點
            first.next = second.next;
            second.next = first;
            prev.next = second;
            
            // prev 移到下一對節點前
            prev = first;
        }
        
        return dummy.next;
    }

    // 測試
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode swapped = sol.swapPairs(head);
        while (swapped != null) {
            System.out.print(swapped.val + " ");
            swapped = swapped.next;
        }
        // 輸出: 2 1 4 3
    }
}