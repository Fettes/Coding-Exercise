/*
 * @lc app=leetcode id=165 lang=java
 *
 * [165] Compare Version Numbers
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        //need to escape the dot if you want to split on a literal dot:
        //String extensionRemoved = filename.split("\\.")[0];
        //Otherwise you are splitting on the regex ., which means "any character".

        String[] ver1Arr = version1.split("\\.");
        String[] ver2Arr = version2.split("\\.");

        int index = 0;
        while (index < Math.max(ver1Arr.length, ver2Arr.length)) {
            int ver1Value = index < ver1Arr.length ? Integer.valueOf(ver1Arr[index]) : 0;
            int ver2Value = index < ver2Arr.length ? Integer.valueOf(ver2Arr[index]) : 0;

            if (ver1Value < ver2Value) {
                return -1;
            } else if (ver1Value > ver2Value) {
                return 1;
            } else {
                index++;
            }
        }
        return 0;

    }
}
// @lc code=end

