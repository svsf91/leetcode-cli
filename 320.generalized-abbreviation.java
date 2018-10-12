/*
 * [320] Generalized Abbreviation
 *
 * https://leetcode.com/problems/generalized-abbreviation/description/
 *
 * algorithms
 * Medium (47.12%)
 * Total Accepted:    32.9K
 * Total Submissions: 69.9K
 * Testcase Example:  '"word"'
 *
 * Write a function to generate the generalized abbreviations of a word. 
 * 
 * Note: The order of the output does not matter.
 * 
 * Example:
 * 
 * 
 * Input: "word"
 * Output:
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d",
 * "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * 
 * 
 * 
 * 
 */
class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> list = new ArrayList<>();
        helper(word, 0, false, new StringBuilder(), list);
        return list;
    }

    public void helper(String word, int pos, boolean isAbbr, StringBuilder sb, List<String> list) {
        if (pos == word.length()) {
            list.add(sb.toString());
            return;
        }
        int len = sb.length();
        sb.append(word.charAt(pos));
        helper(word, pos + 1, false, sb, list);
        sb.setLength(len);
        if (!isAbbr) {
            for (int i = pos; i < word.length(); i++) {
                sb.append(Integer.toString(i - pos + 1));
                helper(word, i + 1, true, sb, list);
                sb.setLength(len);
            }
        }
    }
}
