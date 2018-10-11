/*
 * [91] Decode Ways
 *
 * https://leetcode.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (21.03%)
 * Total Accepted:    203.6K
 * Total Submissions: 968.1K
 * Testcase Example:  '"12"'
 *
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * Given a non-empty string containing only digits, determine the total number
 * of ways to decode it.
 * 
 * Example 1:
 * 
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2
 * 6).
 * 
 */
class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] DP = new int[s.length() + 1];
        DP[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                DP[i + 1] += DP[i];
            }
            if (i > 0) {
                int num = Integer.parseInt(s.substring(i - 1, i + 1));
                if (num >= 10 && num <= 26) {
                    DP[i + 1] += DP[i - 1];
                }
            }
        }
        return DP[s.length()];
    }
}
