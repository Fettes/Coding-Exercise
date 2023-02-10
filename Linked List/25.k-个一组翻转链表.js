/*
 * @lc app=leetcode.cn id=25 lang=javascript
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function(head, k) {
  if (k === 0) return head;
  
  let index = head;
  
  let currHead = head; //保存走过k以后的头部
  let tail = null; //用于保存被切断的尾巴
  let reverseTemp = null; //保存反转后的部分
  let result = new ListNode(0); //保存结果

  let count = 1;

  while (index !== null && index.next !== null) {
    count ++;
    index = index.next;

    if (count === k) {
      tail = index.next; //保存尾巴
      index.next = null; //切断尾巴
      reverseTemp = reverse(currHead); //反转
      //复位
      count = 1;
      currHead = tail;
      index = tail;
    }
    if (reverseTemp !== null) {
      result = link(result, reverseTemp);
      reverseTemp = null;
    }
  }
  result = link(result, currHead)
  return result.next
};

var link = function (list1, list2) {
  if (list2 === null) {
    return list1;
  }
  let head = list1;
  while (list1.next !== null) {
    list1 = list1.next
  }
  list1.next = list2;
  return head;
}

var reverse = function(head) {
  if (head === null) {
    return null
  }

  let pre = null;
  let index = head;

  while (index !== null) {
    let temp = index.next;
    index.next = pre;
    pre = index;
    index = temp;
  }
  return pre;
}
// @lc code=end

