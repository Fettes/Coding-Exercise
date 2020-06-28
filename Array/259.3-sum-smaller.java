/*
 * @lc app=leetcode id=259 lang=java
 *
 * [259] 3Sum Smaller
 */

// @lc code=start
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;  

            while (low < high) {
                int tempSum = nums[i] + nums[low] + nums[high];
                if (tempSum < target) {
                    count += high - low;
                    low++;
                } else {
                    high--;
                }
            }
        }
        return count;
    }
}
// @lc code=end