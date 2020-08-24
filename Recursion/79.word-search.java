/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j] && helper(board, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean helper(char[][] board, boolean[][] visited, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)
                || visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        if (helper(board, visited, word, row + 1, col, index + 1)
                || helper(board, visited, word, row - 1, col, index + 1)
                || helper(board, visited, word, row, col + 1, index + 1)
                || helper(board, visited, word, row, col - 1, index + 1)) {
                    return true;
        }
        visited[row][col] = false;
        return false;
    }
}
// @lc code=end
