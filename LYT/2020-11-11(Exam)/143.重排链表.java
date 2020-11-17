/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rightHalf = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode curr = rightHalf;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode leftHalf = head;
        ListNode restHalf = prev;
        ListNode dummy = new ListNode(-1);
        int flag = 1;
        while (leftHalf != null && restHalf != null) {
            if (flag % 2 != 0) {
                dummy.next = leftHalf;
                leftHalf = leftHalf.next;
            } else {
                dummy.next = restHalf;
                restHalf = restHalf.next;
            }
            flag++;
            dummy = dummy.next;
        }
        if (leftHalf != null) {
            dummy.next = leftHalf;
        }
        if (restHalf != null) {
            dummy.next = restHalf;
        }
    }
}
// @lc code=end

