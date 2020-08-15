/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        int neeLen = needle.length();

        for (int i = 0; i + neeLen <= haystack.length(); i++) {
            if (haystack.substring(i, i + neeLen).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
// @lc code=end

