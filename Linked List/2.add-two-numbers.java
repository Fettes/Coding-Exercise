/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;

        int v1 = 0;
        int v2 = 0;
        int carry = 0;

        while (l1 != null || l2 != null) {
            v1 = l1 == null ? 0 : l1.val;
            v2 = l2 == null ? 0 : l2.val;

            int sum = v1 + v2 + carry;
            if (sum / 10 > 0) {
                carry = 1;
                curr.next = new ListNode(sum % 10);
            } else {
                carry = 0;
                curr.next = new ListNode(sum);
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            curr = curr.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(1);
        }

        return result.next;
    }
}
// @lc code=end

