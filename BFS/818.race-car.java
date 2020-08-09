/*
 * @lc app=leetcode id=818 lang=java
 *
 * [818] Race Car
 */

// @lc code=start
class Solution {
    public int racecar(int target) {
        Queue<int[]> queue = new LinkedList<>();
        //initialize with postion 0 with speed 1
        queue.offer(new int[]{0, 1});

        //initialize the visited set with postion 0 with speed 1
        Set<String> visited = new HashSet<>();
        visited.add("0-1");

        int step = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] curr = queue.poll();

                if (curr[0] == target) {
                    return step;
                }

                //A
                int[] nextA = new int[]{curr[0] + curr[1], curr[1] << 1};
                String keyA = nextA[0] + "-" + nextA[1];
                if (!visited.contains(keyA) && nextA[0] > 0 && nextA[0] < (target << 1)) {
                    queue.offer(nextA);
                    visited.add(keyA);
                }

                //R
                int[] nextR = new int[]{curr[0], curr[1] > 0 ? -1 : 1};
                String keyR = nextR[0] + "-" + nextR[1];
                if (!visited.contains(keyR) && nextR[0] > 0 && nextR[0] < (target << 1)) {
                    queue.offer(nextR);
                    visited.add(keyR);
                } 
            }
            step++;
        }
        return -1;
    }
}
// @lc code=end

