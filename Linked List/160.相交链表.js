/*
 * @lc app=leetcode.cn id=160 lang=javascript
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
var getIntersectionNode = function(headA, headB) {
  if (headA === null || headB === null) {
    return null
  }
  let indexA = headA;
  let indexB = headB;

  while (indexA !== indexB) {
    indexA = indexA !== null ? indexA.next : headB;
    indexB = indexB !== null ? indexB.next : headA;
  }
  return indexA;
};
// @lc code=end

