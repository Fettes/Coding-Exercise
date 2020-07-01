/*
 * @lc app=leetcode id=286 lang=java
 *
 * [286] Walls and Gates
 */

// @lc code=start
class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] dir : directions) {
                    int newRow = point[0] + dir[0];
                    int newCol = point[1] + dir[1];

                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || rooms[newRow][newCol] != Integer.MAX_VALUE) {
                        continue;
                    }
                    rooms[newRow][newCol] = rooms[point[0]][point[1]] + 1;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
        return;
    }
}
// @lc code=end
