/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length;
        if (m == 0) {
            return image;
        }
        int n = image[0].length;

        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }

        int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            image[curr[0]][curr[1]] = newColor;

            for (int[] dir : directions) {
                int newX = curr[0] + dir[0];
                int newY = curr[1] + dir[1];
                
                if (newX >= 0 && newY >= 0 && newX < m && newY < n && image[newX][newY] == oldColor) {
                    queue.add(new int[]{newX, newY});
                }
            }
        }

        return image;
    }
}
// @lc code=end

