/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int cen = height[stack.pop()];
                if(!stack.isEmpty()) {
                    int h = Math.min(height[stack.peek()] - cen,height[i] - cen);
                    result += (i - stack.peek() - 1) * h;
                }
            }
            stack.push(i);
        }
        return result;
    }
}

// @lc code=end

