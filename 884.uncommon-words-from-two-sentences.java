/*
 * [920] Uncommon Words from Two Sentences
 *
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
 *
 * algorithms
 * Easy (59.93%)
 * Total Accepted:    11.5K
 * Total Submissions: 19.2K
 * Testcase Example:  '"this apple is sweet"\n"this apple is sour"'
 *
 * We are given two sentences A and B.  (A sentence is a string of space
 * separated words.  Each word consists only of lowercase letters.)
 * 
 * A word is uncommon if it appears exactly once in one of the sentences, and
 * does not appear in the other sentence.
 * 
 * Return a list of all uncommon words. 
 * 
 * You may return the list in any order.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 * 
 * 
 * 
 */
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        for(String word: A.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for(String word: B.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for(String word: map.keySet()) {
            if(map.get(word) == 1) {
                list.add(word);
            }
        }
        String[] res = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }
}
