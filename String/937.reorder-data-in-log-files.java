/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 */

// @lc code=start
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {
                String[] strs1 = log1.split(" ");
                String[] strs2 = log2.split(" ");

                if (Character.isDigit(strs1[1].charAt(0)) && Character.isDigit(strs2[1].charAt(0))) return 0;
                if (Character.isLetter(strs1[1].charAt(0)) && Character.isDigit(strs2[1].charAt(0))) return -1;
                if (Character.isDigit(strs1[1].charAt(0)) && Character.isLetter(strs2[1].charAt(0))) return 1;

                String s1 = log1.substring(log1.indexOf(" ") + 1);
                String s2 = log2.substring(log2.indexOf(" ") + 1);

                if (s1.equals(s2)) {
                    return strs1[0].compareTo(strs2[0]);
                }

                return s1.compareTo(s2);
            }
        });

        return logs;
    }
}
// @lc code=end

