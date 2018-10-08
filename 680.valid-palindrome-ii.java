/*
 * [680] Valid Palindrome II
 *
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 *
 * algorithms
 * Easy (32.60%)
 * Total Accepted:    45.3K
 * Total Submissions: 139K
 * Testcase Example:  '"aba"'
 *
 * 
 * Given a non-empty string s, you may delete at most one character.  Judge
 * whether you can make it a palindrome.
 * 
 * 
 * Example 1:
 * 
 * Input: "aba"
 * Output: True
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * 
 * 
 * 
 * Note:
 * 
 * The string will only contain lowercase characters a-z.
 * The maximum length of the string is 50000.
 * 
 * 
 */
class Solution {
    public boolean validPalindrome(String s) {
        return helper(s, 0, s.length() - 1, true);
    }
    public boolean helper(String s, int l, int r, boolean canDel) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                if(canDel) {
                    return helper(s, l + 1, r, false) || helper(s, l, r - 1, false);
                } else {
                    return false;
                }
            }
            l++;
            r--;
        }
        return true;
    }
}
