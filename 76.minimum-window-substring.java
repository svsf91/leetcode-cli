/*
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (28.35%)
 * Total Accepted:    177.6K
 * Total Submissions: 626.5K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * 
 * Note:
 * 
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "".
 * If there is such window, you are guaranteed that there will always be only
 * one unique minimum window in S.
 * 
 * 
 */
class Solution {
    public String minWindow(String s, String t) {
        int[] bucket = new int[256];
        for (char c : t.toCharArray()) {
            bucket[c]++;
        }
        int l = 0, r = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        String res = "";
        while (r < s.length()) {
            if (bucket[s.charAt(r)]-- > 0) {
                count--;
            }
            r++;
            if (count == 0) {
                while (count == 0) {
                    if (++bucket[s.charAt(l)] > 0) {
                        count++;
                    }
                    l++;
                }
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    res = s.substring(l - 1, r);
                }
            }
        }
        return res;
    }
}
