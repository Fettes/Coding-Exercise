/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        int result = 0;
        int index = 0;

        while (index < s.length()) {
            String curr = s.substring(index, index + 1);
            int currValue = map.get(curr);

            int nextValue = 0;
            if (index + 1 < s.length()) {
                String next = s.substring(index + 1, index + 2);
                nextValue = map.get(next);
            }

            if (currValue < nextValue) {
                result += nextValue - currValue;
                index += 2;
            } else {
                result += currValue;
                index += 1;
            }
        }
        return result;
    }
}
// @lc code=end

