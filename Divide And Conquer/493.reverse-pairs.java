/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 */

// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && nums[i] > (long)nums[j] * 2) {
                j++;
            }
            count += j - (mid + 1);
        }

        merge(nums, left, right);
        return count;
    }

    public void merge(int[] nums, int start, int end) {
        // create a temp array
        int temp[] = new int[end - start + 1];

        // crawlers for both intervals and for temp
        int mid = (start + end) / 2;
        int i = start, j = mid + 1, k = 0;

        // traverse both arrays and in each iteration add smaller of both elements in temp 
        while(i <= mid && j <= end) {
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }

        // add elements left in the first interval 
        while(i <= mid) {
            temp[k++] = nums[i++];
        }

        // add elements left in the second interval 
        while(j <= end) {
            temp[k++] = nums[j++];
        }

        // copy temp to original interval
        for(i = start; i <= end; i++) {
            nums[i] = temp[i - start];
        }
    }
}
// @lc code=end

