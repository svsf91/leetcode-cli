/*
 * [1630] Interesting String
 *
 * https://www.lintcode.com/problem/interesting-string/description
 *
 * lintcode
 * Medium (29.00%)
 * Total Accepted:    145
 * Total Submissions: 492
 * Testcase Example:  '"r72d3w07zk"'
 *
 * There is now a string `s` consisting of only numbers and lowercase letters.
 * If the string `s` is interesting, then `s` must be split into several
 * substrings, each substring satisfies the beginning of the number, and the
 * number represents the number of characters after it. For example, s =
 * "4g12y6hunter", we can divide it into "4g12y" and "6hunter", so the string
 * is interesting.
 * If `s` is an interesting string, output "yes", otherwise output "no"
 */
public class Solution {
    /**
     * @param s: the string s
     * @return: check if the string is interesting
     */
    public String check(String s) {
        // Write your code here
        return helper(s, 0) ? "yes" : "no";
    }

    public boolean helper(String s, int pos) {
        if (pos == s.length()) {
            return true;
        }
        if (!Character.isDigit(s.charAt(pos))) {
            return false;
        }
        int num = 0;
        for (int i = pos; i < s.length() && Character.isDigit(s.charAt(i)); i++) {
            num *= 10;
            num += s.charAt(i) - '0';
            if (i + num + 1 > s.length()) {
                break;
            }
            if (helper(s, i + num + 1)) {
                return true;
            }
        }
        return false;
    }
}
