/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode curr = head;
        ListNode indexNode = head;

        ListNode tail = null; 
        ListNode result = new ListNode(-1);
        ListNode reverseList = null;
        int count = 1;

        while (indexNode != null && indexNode.next != null) {
            count++;
            indexNode = indexNode.next;

            if (count == k) {
                //save the tail
                tail = indexNode.next;
                //cut the tail
                indexNode.next = null;
                //reverse the previous group
                reverseList = reverse(curr);
                //reset 
                curr = tail;
                indexNode = tail;
                count = 1;
            }

            if (reverseList != null) {
                result = LinkNode(result, reverseList);
                reverseList = null;
            }
        }
        result = LinkNode(result, tail);
        return result.next;
    }

    public ListNode LinkNode(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }

        ListNode head = l1;
        while (l1.next != null) {
            l1 = l1.next;
        }
        l1.next = l2;
        return head;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        return pre;
    }
}
// @lc code=end

