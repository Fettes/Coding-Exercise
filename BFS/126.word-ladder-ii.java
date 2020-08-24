/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return result;
        }

        Set<String> visited = new HashSet<>();
        Queue<List<String>> queue = new LinkedList<>();

        //first list
        List<String> firstWord = new ArrayList<>(Arrays.asList(beginWord));
        queue.add(firstWord);
        visited.add(beginWord);
        boolean end = false;

        while (!queue.isEmpty() && !end) {
            int size = queue.size();
            Set<String> currLevelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {
                List<String> currList = queue.poll();
                String currWord = currList.get(currList.size() - 1);

                if (currWord.equals(endWord)) {
                    result.add(currList);
                    end = true;
                }

                char[] wordArr = currWord.toCharArray();
                for (int j = 0; j < wordArr.length; j++) {
                    char temp = wordArr[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArr[j] = c;
                        String newWord = new String(wordArr);

                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            List<String> newList = new ArrayList<>(currList);
                            newList.add(newWord);
                            queue.add(newList);
                            currLevelVisited.add(newWord);
                        }
                    }
                    wordArr[j] = temp;
                }                
            }
            visited.addAll(currLevelVisited);
        }

        return result;
    }
}
     
// @lc code=end

