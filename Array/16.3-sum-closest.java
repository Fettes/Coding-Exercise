/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int resultSum = 0;
        int closest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            while (low < high) {
                int tempSum = nums[i] + nums[low] + nums[high];
                if (tempSum == target) {
                    return target;
                } else if (tempSum < target) {
                    low++;
                } else {
                    high--;
                }
                resultSum = closest < Math.abs(target - tempSum) ? resultSum : tempSum;
                closest = Math.min(closest, Math.abs(target - tempSum));
            }
        }
        return resultSum;
    }
}
// @lc code=end

