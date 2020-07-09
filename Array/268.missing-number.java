/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        //Sum formula: (0 + sum) * (size + 1) / 2;
        int sum = size * (size + 1) / 2;
        int currSum = 0;
        for (int i = 0; i < size; i++) {
            currSum += nums[i];
        }

        return sum - currSum;
    }
}
// @lc code=end

