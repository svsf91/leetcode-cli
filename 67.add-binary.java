/*
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (35.88%)
 * Total Accepted:    235.2K
 * Total Submissions: 655.6K
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Example 2:
 * 
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 */
class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            int n1 = a.length() - 1 - i >= 0 ? a.charAt(a.length() - 1 - i) - '0' : 0;
            int n2 = b.length() - 1 - i >= 0 ? b.charAt(b.length() - 1 - i) - '0' : 0;
            sb.append((n1 + n2 + carry) % 2);
            carry = (n1 + n2 + carry) / 2;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
