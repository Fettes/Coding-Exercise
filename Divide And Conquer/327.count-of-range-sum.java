/*
 * @lc app=leetcode id=327 lang=java
 *
 * [327] Count of Range Sum
 */

// @lc code=start
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        long[] prefixSum = new long[nums.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        return mergeSort(prefixSum, lower, upper, 0, prefixSum.length - 1);
    }

    public int mergeSort(long[] prefixSum, int lower, int upper, int start, int end) {
        if (start >= end) return 0;

        int mid = (start + end) / 2;
        int count = mergeSort(prefixSum, lower, upper, start, mid) + mergeSort(prefixSum, lower, upper, mid + 1, end);

        int i = mid + 1, j = mid + 1;
        for (int k = start; k <= mid; k++) {
            //set the left bound
            while (i <= end && prefixSum[i] - prefixSum[k] < lower) {
                i++;
            }
            //set the right bound
            while (j <= end && prefixSum[j] - prefixSum[k] <= upper) {
                j++;
            }
            count += j - i;
        }

        merge(prefixSum, start, end);
        return count;
    }

    public void merge(long[] prefixSum, int start, int end) {
        // create a temp array
        long temp[] = new long[end - start + 1];

        // crawlers for both intervals and for temp
        int mid = start + (end - start) / 2;
        int i = start, j = mid + 1, k = 0;

        // traverse both arrays and in each iteration add smaller of both elements in temp 
        while(i <= mid && j <= end) {
            temp[k++] = prefixSum[i] <= prefixSum[j] ? prefixSum[i++] : prefixSum[j++];
        }

        // add elements left in the first interval 
        while(i <= mid) {
            temp[k++] = prefixSum[i++];
        }

        // add elements left in the second interval 
        while(j <= end) {
            temp[k++] = prefixSum[j++];
        }

        // copy temp to original interval
        for(i = start; i <= end; i += 1) {
            prefixSum[i] = temp[i - start];
        }
    }
}
// @lc code=end

