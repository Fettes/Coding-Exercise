/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        int length = 0;

        if (s == null || s.length() == 0) {
            return length;
        }

        while (left < s.length() && right < s.length()) {
            char curr = s.charAt(right);

            if (set.contains(curr)) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(curr);
                right++;
            }
            length = Math.max(right - left, length);
        }

        return length;
    }
}
// @lc code=end

