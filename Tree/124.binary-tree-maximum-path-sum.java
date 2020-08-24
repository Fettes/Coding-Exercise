/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //get the maxLeftsubtree and maxRightsubtree
        int maxLeft = Math.max(helper(root.left), 0);
        int maxRight = Math.max(helper(root.right), 0);

        //update current max
        int curr = root.val + maxLeft + maxRight;
        max = Math.max(max, curr);

        return root.val + Math.max(maxLeft, maxRight);
    }
}
// @lc code=end

