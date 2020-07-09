import sun.jvm.hotspot.ci.ciInstance;

/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        //This problem is hard to understand
        Arrays.sort(citations);
        
        for (int i = 0; i < citations.length; i++) {
            int paper = citations.length - i;
            if (paper <= citations[i]) {
                return paper;
            }
        }
        return 0;
    }
}
// @lc code=end

