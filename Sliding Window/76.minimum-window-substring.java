/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || s.length() < t.length()) {
            return "";
        }
        //count the letters in t
        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        int startIndex = 0;
        int minLen = Integer.MAX_VALUE;

        Map<Character, Integer> mapS = new HashMap<>();
        while (right < s.length()) {  
            //new character ready to in the window
            char rightChar = s.charAt(right);
            right++;
            //if it contains the current character, it should be put in the window map
            if (mapT.containsKey(rightChar)) {
                mapS.put(rightChar, mapS.getOrDefault(rightChar, 0) + 1);
                //check whether their number are matched
                //note: we need to add intValue() because the test case is extreeeeemely large...
                if (mapS.get(rightChar).intValue() == mapT.get(rightChar).intValue()) {
                    valid++;
                }
            }

            //now we can consider the left bound
            while (valid == mapT.size()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }
                //minimize the left bound 
                char leftChar = s.charAt(left);
                left++;

                if (mapT.containsKey(leftChar)) { 
                    //we need to consider the number of valid character 
                    //note: we need to add intValue() because the test case is extreeeeemely large...
                    if (mapT.get(leftChar).intValue() == mapS.get(leftChar).intValue()) {
                        valid--;
                    } 
                    mapS.put(leftChar, mapS.get(leftChar) - 1);
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
// @lc code=end

