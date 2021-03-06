/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode lLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rLCA = lowestCommonAncestor(root.right, p, q);

        if (lLCA == null) {
            return rLCA;
        }
        if (rLCA == null) {
            return lLCA;
        }
        return root;
    }
}
// @lc code=end

