/*
 * [1631] Interesting Subarray
 *
 * https://www.lintcode.com/problem/interesting-subarray/description
 *
 * lintcode
 * Medium (40.00%)
 * Total Accepted:    166
 * Total Submissions: 409
 * Testcase Example:  '[1,1,1,1]'
 *
 * If there are no more than two values in a subarray, the subarray is
 * interesting. Given an array `a`, find the longest interesting subarray.
 * Output the maximum length.
 */
public class Solution {
    /**
     * @param a: the array a
     * @return: return the maximum length
     */
    public int maxLen(int[] a) {
        // Write your code here
        int[] bucket = new int[1001];
        int l = 0, r = 0;
        int len = 0;
        int count = 0;
        while (r < a.length) {
            if (bucket[a[r++]]++ == 0) {
                count++;
            }
            while (count > 2) {
                if (--bucket[a[l++]] == 0) {
                    count--;
                }
            }
            len = Math.max(len, r - l);
        }
        return len;
    }
}
