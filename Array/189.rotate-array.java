/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(final int[] nums, final int k) {
        int i = k % nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, i - 1);
        reverseArray(nums, i, nums.length - 1);
    }

    private void reverseArray(final int[] nums, int left, int right) {
        while (left < right) {
            final int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
// @lc code=end

