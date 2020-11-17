/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    public int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getPath(root);
        return maxPath;
    }
    public int getPath(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = getPath(root.left);
        int right = getPath(root.right);
        int max = Math.max(Math.max(left, right) + root.val, root.val);
        maxPath = Math.max(Math.max(maxPath, root.val + left + right),max);
        return max;
    }
}
// @lc code=end

