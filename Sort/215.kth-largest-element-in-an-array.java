/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = nums[high];
        int start = low;

        for (int i = low; i < high; i++) {
            if (nums[i] <= pivot) {
                swap(nums, start, i);
                start++;
            }
        }
        swap(nums, start, high);

        if (start == k) {
            return nums[k];
        } else if (start < k) {
            return quickSelect(nums, start + 1, high, k);
        } else {
            return quickSelect(nums, low, start - 1, k);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

