/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String curr = "";
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        String[] pad = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int index = 0;

        helper(digits, pad, index, curr, result);
        return result;
    }

    public void helper(String digits, String[] pad, int index, String curr, List<String> result) {
        if (index == digits.length()) {
            result.add(curr);
            return;
        }

        int currInt = digits.charAt(index) - '0';

        for (int i = 0; i < pad[currInt].length(); i++) {
            curr += pad[currInt].charAt(i);
            helper(digits, pad, index + 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);
        }

    }
}
// @lc code=end

