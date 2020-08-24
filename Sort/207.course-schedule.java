/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Topological sorting
        if (numCourses < 0) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];

        //indegree counting
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][1]]++;
        }

        //add the course with 0 indegree
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        //maintain the queue with 0 indegree
        while (!queue.isEmpty()) {
             int currIndex = queue.poll();
             
             for (int i = 0; i < prerequisites.length; i++) {
                 if (currIndex == prerequisites[i][0]) {
                     inDegree[prerequisites[i][1]]--;

                     if (inDegree[prerequisites[i][1]] == 0) {
                        queue.add(prerequisites[i][1]);
                     }
                 }
             }
        }

        //check the indegree
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] != 0)
                return false;
        }

        return true;
        
    }
}
// @lc code=end

