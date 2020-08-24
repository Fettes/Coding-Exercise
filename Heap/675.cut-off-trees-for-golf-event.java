/*
 * @lc app=leetcode id=675 lang=java
 *
 * [675] Cut Off Trees for Golf Event
 */

// @lc code=start
class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) {
            return 0;
        }
        int m = forest.size();
        int n = forest.get(0).size();

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        //add to priority queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    queue.add(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }

        int[] start = new int[2];
        int result = 0;

        while (!queue.isEmpty()) {
            int[] targetTree = queue.poll();
            int step = getStep(forest, start, targetTree, m, n);

            if (step == -1) {
                return -1;
            }

            result += step;

            //set the target tree as start point
            start[0] = targetTree[0];
            start[1] = targetTree[1];
        }

        return result;
    }

    public int getStep(List<List<Integer>> forest, int[] start, int[] targetTree, int m, int n) {
        int step = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                //check end
                if (curr[0] == targetTree[0] && curr[1] == targetTree[1]) {
                    return step;
                }

                for (int[] dir : directions) {
                    int newX = curr[0] + dir[0];
                    int newY = curr[1] + dir[1];

                    if (newX < 0 || newY < 0 || newX >= m || newY >= n || forest.get(newX).get(newY) == 0 || visited[newX][newY]) {
                        continue;
                    }

                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
            step++;
        }
        return -1;
    }
}
// @lc code=end

