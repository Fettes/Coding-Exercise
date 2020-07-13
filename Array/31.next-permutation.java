/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        //find the minimum number that is not in order Ep:1,4,3,5,4,2,1  -> 5 is the target
        int end = nums.length - 2;
        while (end >= 0 && nums[end] >= nums[end + 1]) {
            end--;
        }

        //now end = 3 which means 3 should be increased which should result in the next permutation
        //and we need to find the first number that larger than 3 from right
        if (end != -1) {
            int i = nums.length - 1;
            while (i >= 0 && nums[i] <= nums[end]) {
                i--;
            }
            //swap
            int temp = nums[end];
            nums[end] = nums[i];
            nums[i] = temp;
        }
        
        //but now it is not the next permutation
        reverse(nums, end + 1, nums.length - 1);
    }
    
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}
// @lc code=end

