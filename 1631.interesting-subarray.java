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
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int len = 0;
        while (r < a.length) {
            map.put(a[r], map.getOrDefault(a[r], 0) + 1);
            r++;
            while (map.keySet().size() > 2) {
                map.put(a[l], map.get(a[l]) - 1);
                if (map.get(a[l]) == 0) {
                    map.remove(a[l]);
                }
                l++;
            }
            len = Math.max(len, r - l);
        }
        return len;
    }
}
