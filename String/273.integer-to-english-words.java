/*
 * @lc app=leetcode id=273 lang=java
 *
 * [273] Integer to English Words
 */

// @lc code=start
class Solution {
    private String[] lessThan20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
    "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] tenTh = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] thousand = new String[]{"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        String result = "";
        if (num == 0) {
            return "Zero";
        }

        int index = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                result = getDigit(num % 1000) + thousand[index] + " " + result;
            }
            index++;
            num = num / 1000;
        }

        return result.trim();
    }

    public String getDigit(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return lessThan20[num] + " ";
        } else if (num < 100) {
            return tenTh[num / 10] + " " + getDigit(num % 10);
        } else {
            return lessThan20[num / 100] + " Hundred " + getDigit(num % 100);
        }
    }
}
// @lc code=end

