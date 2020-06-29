/*
 * @lc app=leetcode id=1099 lang=java
 *
 * [1099] Two Sum Less Than K
 */

// @lc code=start
class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int low = 0;
        int high = A.length - 1;
        
        int max = -1;
        
        while (low < high) {
            int currSum = A[low] + A[high];
            if (currSum < K) {
                max = Math.max(max, currSum);
                low++;
            } else {
                high--;
            }
        }
        return max;
    }
}
// @lc code=end

