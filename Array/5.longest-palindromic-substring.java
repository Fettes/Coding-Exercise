/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int size = s.length();

        if (size == 0) {
            return s;
        }

        //base case
        boolean[][] dp = new boolean[size][size];
        int max = 1;
        for (int i = 0; i < size; i++) {
            dp[i][i] = true;
        }

        //base case2 && dp function
        int start = 0;
        for (int length = 2; length <= size; length++) {
            for (int i = 0; i <= size - length; i++) {
                int j = i + length - 1;

                if (length == 2 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    start = i;
                    max = 2;
                } else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    
                    if (length > max) {
                        max = length;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + max);
    }
}
// @lc code=end

