/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0;i < size; i++) {
                TreeNode node = queue.remove();
                if (level % 2 == 1){
                    levelNodes.add(node.val);
                } else {
                    levelNodes.add(0, node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(levelNodes);
            level++;
        }
        return result;
    }
}
// @lc code=end

