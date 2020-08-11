/*
 * @lc app=leetcode id=505 lang=java
 *
 * [505] The Maze II
 */

// @lc code=start
class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        
        int[][] distance = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int[] dis : distance) {
            Arrays.fill(dis, -1);
        }
        
        distance[start[0]][start[1]] = 0;
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            for (int[] dir : directions) {
                int currCount = distance[curr[0]][curr[1]];
                int startX = curr[0];
                int startY = curr[1];
                
                while (startX + dir[0] >= 0 && startX + dir[0] < maze.length && startY + dir[1] >= 0 && startY + dir[1] < maze[0].length && maze[startX + dir[0]][startY + dir[1]] != 1) { 
                    startX += dir[0];
                    startY += dir[1];
                    currCount++;
                }
                
                if (distance[startX][startY] == -1 || currCount < distance[startX][startY]) {
                    queue.add(new int[]{startX, startY});
                    distance[startX][startY] = currCount;
                }
            }
        }
        
        return distance[destination[0]][destination[1]];
    }
}