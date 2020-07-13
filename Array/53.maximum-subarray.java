/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    //0-1 knapsack idea
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(nums[i], currMax + nums[i]);
            max = Math.max(currMax, max);
        }
        return max;

    }
    //prefixSum greedy idea
    public int maxSubArray2(int[] nums) {
        int maximum = Integer.MIN_VALUE;
        int prefixSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum = prefixSum + nums[i];
            maximum = Math.max(prefixSum, maximum);
            if (prefixSum < 0) {
                prefixSum = 0;
            }
            
        }
        return maximum;
    }


}
// @lc code=end

