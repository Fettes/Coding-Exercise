/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
       if (grid.length == 0) {
           return 0;
       }
       int count = 0;
       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < grid[0].length; j++) {
               if (grid[i][j] == '1') {
                   count++;
                   dfsTraverse(grid, i, j);
               }
           }
       }
       return count;
    }
    public void dfsTraverse(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfsTraverse(grid, row + 1, col);
        dfsTraverse(grid, row - 1, col);
        dfsTraverse(grid, row, col + 1);
        dfsTraverse(grid, row, col - 1);
    }
}
// @lc code=end

