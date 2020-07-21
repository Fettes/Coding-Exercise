/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        // we only update the result (max) when we find a "pair".
        //If we find a pair. pop the stack and check the scale of interval.
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        //need to push -1 in stack to be easily minus
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (stack.size() > 1 && s.charAt(i) == ')' && s.charAt(stack.peek()) == '(') {
                stack.pop();
                result = Math.max(result, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return result;
    }
}
// @lc code=end

