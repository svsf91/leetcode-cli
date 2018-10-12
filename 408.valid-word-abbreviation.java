/*
 * [408] Valid Word Abbreviation
 *
 * https://leetcode.com/problems/valid-word-abbreviation/description/
 *
 * algorithms
 * Easy (28.56%)
 * Total Accepted:    18.7K
 * Total Submissions: 65.4K
 * Testcase Example:  '"internationalization"\n"i12iz4n"'
 *
 * 
 * Given a non-empty string s and an abbreviation abbr, return whether the
 * string matches with the given abbreviation.
 * 
 * 
 * A string such as "word" contains only the following valid abbreviations:
 * 
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d",
 * "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * 
 * 
 * Notice that only the above abbreviations are valid abbreviations of the
 * string "word". Any other string is not a valid abbreviation of "word".
 * 
 * Note:
 * Assume s contains only lowercase letters and abbr contains only lowercase
 * letters and digits.
 * 
 * 
 * Example 1:
 * 
 * Given s = "internationalization", abbr = "i12iz4n":
 * 
 * Return true.
 * 
 * 
 * 
 * Example 2:
 * 
 * Given s = "apple", abbr = "a2e":
 * 
 * Return false.
 * 
 * 
 */
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (j < abbr.length() && i < word.length()) {
            char c = abbr.charAt(j);
            if (Character.isLetter(c)) {
                if (c != word.charAt(i)) {
                    return false;
                }
                i++;
                j++;
            } else {
                if (c == '0') {
                    return false;
                }
                int k = j;
                while (k < abbr.length() && Character.isDigit(abbr.charAt(k))) {
                    k++;
                }
                int count = k > j ? Integer.parseInt(abbr.substring(j, k)) : 0;
                i += count;
                j = k;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}
