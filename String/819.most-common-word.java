/*
 * @lc app=leetcode id=819 lang=java
 *
 * [819] Most Common Word
 */

// @lc code=start
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String paraLowerCase = paragraph.replaceAll("[,\\?\\!\\'\\;\\.]", " ").toLowerCase();
        String[] words = paraLowerCase.split("\\s+");

        Set<String> set = new HashSet<>();
        for (String word : banned) {
            set.add(word);
        }

        Map<String, Integer> map = new HashMap();
        for (String word : words) {
            if (!set.contains(word)) {
                System.out.println(word);
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        int max = 0;
        String maxKey = "";
        for (String key : map.keySet()) {
            max = Math.max(max, map.get(key));
            maxKey = max == map.get(key) ? key : maxKey;
        }

        return maxKey;
    }
}
// @lc code=end

