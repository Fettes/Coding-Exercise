/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Topological sorting
        if (numCourses < 0) {
            return new int[]{};
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        int[] result = new int[numCourses];

        //indegree counting
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }

        //add the course with 0 indegree
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int currIndex = queue.poll();
            result[level] = currIndex;

            for (int i = 0; i < prerequisites.length; i++) {
                if (currIndex == prerequisites[i][1]) {
                    inDegree[prerequisites[i][0]]--;

                    if (inDegree[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                    }
                }
                
            }
            level++;
        }

        //check
        boolean flag = true;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] != 0)
                flag = false;
        }
        if (flag) {
            return result;
        }

        return new int[]{};
    }
}
// @lc code=end

