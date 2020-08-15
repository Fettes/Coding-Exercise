/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        //reverse the row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        return;
    }
}
// @lc code=end

