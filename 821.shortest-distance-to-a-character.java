/*
 * [841] Shortest Distance to a Character
 *
 * https://leetcode.com/problems/shortest-distance-to-a-character/description/
 *
 * algorithms
 * Easy (60.82%)
 * Total Accepted:    19.9K
 * Total Submissions: 32.8K
 * Testcase Example:  '"loveleetcode"\n"e"'
 *
 * Given a string S and a character C, return an array of integers representing
 * the shortest distance from the character C in the string.
 * 
 * Example 1:
 * 
 * 
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 * 
 * 
 */
class Solution {
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        int last = -1;
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == C) {
                last = i;
            }
            if(last == -1) {
                res[i] = n;
            } else {
                res[i] = i - last;
            }
        }
        last = -1;
        for(int i = n - 1; i >= 0; i--) {
            if(S.charAt(i) == C) {
                last = i;
            }
            if(last == -1) {
                res[i] = Math.min(res[i] , n);
            } else {
                res[i] = Math.min(res[i], last - i);
            }
        }
        return res;
    }
}
