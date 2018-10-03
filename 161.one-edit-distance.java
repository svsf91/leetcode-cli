/*
 * [161] One Edit Distance
 *
 * https://leetcode.com/problems/one-edit-distance/description/
 *
 * algorithms
 * Medium (31.28%)
 * Total Accepted:    59.6K
 * Total Submissions: 190.5K
 * Testcase Example:  '"ab"\n"acb"'
 *
 * Given two strings s and t, determine if they are both one edit distance
 * apart.
 * 
 * Note: 
 * 
 * There are 3 possiblities to satisify one edit distance apart:
 * 
 * 
 * Insert a character into s to get t
 * Delete a character from s to get t
 * Replace a character of s to get t
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ab", t = "acb"
 * Output: true
 * Explanation: We can insert 'c' into s to get t.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "cab", t = "ad"
 * Output: false
 * Explanation: We cannot get t from s by only one step.
 * 
 * Example 3:
 * 
 * 
 * Input: s = "1203", t = "1213"
 * Output: true
 * Explanation: We can replace '0' with '1' to get t.
 * 
 */
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int i = 0, j = 0;
        boolean err = false;
        while(i < s.length() || j < t.length()) {
            if(i >= s.length() || j >= t.length() || s.charAt(i) != t.charAt(j)) {
                if(!err) {
                    err = true;
                } else {
                    return false;
                }

                if(s.length() == t.length()) {
                    i++;
                    j++;
                } else if(s.length() < t.length()) {
                    j++;
                } else {
                    i++;
                }
            } else {
                i++;
                j++;
            }
        }
        return err;
    }
}
