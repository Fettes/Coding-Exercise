/*
 * @lc app=leetcode id=1004 lang=java
 *
 * [1004] Max Consecutive Ones III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;

        for (right = 0; right < A.length; right++) {
            if (A[right] == 0) {
                K--;
            }
            if (K < 0) {
                if (A[left] == 0) {
                    K++;
                }
                left++;
            }
        }
        return right - left;

    }
}
// @lc code=end

 