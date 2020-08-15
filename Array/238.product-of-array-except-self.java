/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        //initialize the array
        int[] leftPro = new int[nums.length];
        int[] rightPro = new int[nums.length];
        int[] result = new int[nums.length];
        //initailize the status
        leftPro[0] = 1;
        rightPro[nums.length - 1] = 1;
        //calculate the left product
        for (int i = 1; i < nums.length; i++) {
            leftPro[i] = leftPro[i - 1] * nums[i - 1];
        }
        //calculate the right product
        for (int i = nums.length - 2; i >= 0; i--) {
            rightPro[i] = rightPro[i + 1] * nums[i + 1];
        }
        //calculate the final result
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftPro[i] * rightPro[i];
        }
        return result;
    }
}
// @lc code=end

