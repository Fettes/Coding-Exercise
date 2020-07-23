import java.util.Arrays;

/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int[] squ = new int[(int) Math.sqrt(n) + 1];
        for (int i = 1; i < squ.length; i++) {
            squ[i] = i * i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < squ.length; j++) {
                if (i < squ[j]) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - squ[j]] + 1);
            }
        }
        return dp[n];

    }
}
// @lc code=end

