/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        if (strs.length == 0) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] curr = strs[i].toCharArray();
            Arrays.sort(curr);
            String afterSort = String.valueOf(curr);

            if (!map.containsKey(afterSort)) {
                map.put(afterSort, new ArrayList<>());
            }
            map.get(afterSort).add(strs[i]);
        }

        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }
}
// @lc code=end

