/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board == null) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfsHelper(board, visited, i, 0);
            }
            if (board[i][n - 1] == 'O' && !visited[i][n - 1]) {
                dfsHelper(board, visited, i, n - 1);
            }
        }

        for (int j = 1; j < n - 1; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                dfsHelper(board, visited, 0, j);
            }
            if (board[m - 1][j] == 'O' && !visited[m - 1][j]) {
                dfsHelper(board, visited, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
        return;

    }

    public void dfsHelper(char[][] board, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] || board[row][col] == 'X') {
            return;
        }

        visited[row][col] = true;
        dfsHelper(board, visited, row + 1, col);
        dfsHelper(board, visited, row - 1, col);
        dfsHelper(board, visited, row, col + 1);
        dfsHelper(board, visited, row, col - 1);
    }
}
// @lc code=end

