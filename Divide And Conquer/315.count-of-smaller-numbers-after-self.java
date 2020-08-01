/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        int[] result = new int[nums.length];
        mergeSort(nums, index, 0, nums.length - 1, result);

        //add result to list
        List<Integer> resultList = new ArrayList<>();
        for (int i : result) resultList.add(i);
        return resultList;
    }

    private void mergeSort(int[] nums, int index[], int left, int right, int[] result) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;

        mergeSort(nums, index, left, mid, result);
        mergeSort(nums, index, mid + 1, right, result);
        int rightCount = 0;
        int i = left;
        for (int j = mid + 1; i <= mid; i++) {
            while (j <= right && nums[index[i]] > nums[index[j]] ) {
                rightCount++;
                j++;
            }
            result[index[i]] += rightCount;
        }

        while (i <= mid) {
            result[index[i]] += rightCount;
            i++;
        }

        merge(nums, index, left, right);
    }

    public void merge(int[] nums, int[] index, int start, int end) {
        // create a temp array
        int temp[] = new int[end - start + 1];

        // crawlers for both intervals and for temp
        int mid = start + (end - start) / 2;
        int i = start, j = mid + 1, k = 0;

        // traverse both arrays and in each iteration add smaller of both elements in temp 
        while(i <= mid && j <= end) {
            temp[k++] = nums[index[i]] <= nums[index[j]] ? index[i++] : index[j++];
        }

        // add elements left in the first interval 
        while(i <= mid) {
            temp[k++] = index[i++];
        }

        // add elements left in the second interval 
        while(j <= end) {
            temp[k++] = index[j++];
        }

        // copy temp to original interval
        for(i = start; i <= end; i += 1) {
            index[i] = temp[i - start];
        }
    }
}
// @lc code=end

