/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */

// @lc code=start
class Solution {
    public String intToRoman(int num) {
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}; 

        if (num <= 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(symbol[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }
}
// @lc code=end

