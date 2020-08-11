/*
 * @lc app=leetcode id=490 lang=java
 *
 * [490] The Maze
 */

// @lc code=start
class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        return helper(maze, start, destination, visited);
    }
    public boolean helper(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if (visited[start[0]][start[1]]) {
            return false;
        }
        
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        
        visited[start[0]][start[1]] = true;
        
        for (int[] dir : directions) {
            int startX = start[0];
            int startY = start[1];
            
            while (startX + dir[0] >= 0 && startX + dir[0] < maze.length && startY + dir[1] >= 0 && startY + dir[1] < maze[0].length && maze[startX + dir[0]][startY + dir[1]] != 1) {
                startX += dir[0];
                startY += dir[1];
            }
            
            int[] newStart = new int[]{startX, startY};
            if (helper(maze, newStart, destination, visited)) {
                return true;
            }
        }
        return false;
    }
}