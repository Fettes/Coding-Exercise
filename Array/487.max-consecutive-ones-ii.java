/*
 * @lc app=leetcode id=487 lang=java
 *
 * [487] Max Consecutive Ones II
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int zeroLeft = 0;
        int zeroRight = 0;

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            zeroRight++;
            if (nums[i] == 0) {
                zeroLeft = zeroRight;
                zeroRight = 0;
            }
            max = Math.max(max, zeroLeft + zeroRight);
        }
        return max;
    }
}
// @lc code=end