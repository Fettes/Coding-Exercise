/*
 * @lc app=leetcode id=1248 lang=java
 *
 * [1248] Count Number of Nice Subarrays
 */

// @lc code=start
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            return 0;
        }

        int oddNum = 0;
        int result = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] % 2 == 1) {
                oddNum++;
            }

            while (left < right && oddNum > k) {
                if (nums[left] % 2 == 1) {
                    oddNum--;
                }
                left++;
            }

            //count the subarrays
            //count the right
            if (oddNum == k) {
                result++;
            }
            //count the left
            for (int i = left; i < right && nums[i] % 2 == 0 && oddNum == k; i++) {
                result++;
            }
        }
        return result;
    }
}
// @lc code=end

