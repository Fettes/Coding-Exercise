/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node start = head;

        while (start != null) {
            map.put(start, new Node(start.val));
            start = start.next;
        } 

        start = head;
        while (start != null) {
            Node temp = map.get(start);
            temp.next = map.get(start.next);
            temp.random = map.get(start.random);
            start = start.next;
        }

        return map.get(head);
    }
}
// @lc code=end

