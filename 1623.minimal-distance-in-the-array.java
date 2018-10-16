/*
 * [1623] Minimal Distance In The Array
 *
 * https://www.lintcode.com/problem/minimal-distance-in-the-array/description
 *
 * lintcode
 * Easy (38.00%)
 * Total Accepted:    186
 * Total Submissions: 477
 * Testcase Example:  '[5,1,2,3]\n[2,4,2]'
 *
 * Given two integer arrays `a` and `b`,please find the number in `a` with the
 * minimal distance between corresponding value in `b` (the distance between
 * two numbers means the absolute value of two numbers), if there are several
 * numbers in `a` have same distance between `b[i]`,just output the smallest
 * number. 
 * Finally, you should output an array of length `b.length` to represent the
 * answer.
 */
public class Solution {
    /**
     * @param a: array a
     * @param b: the query array
     * @return: Output an array of length `b.length` to represent the answer
     */
    public int[] minimalDistance(int[] a, int[] b) {
        // Write your code here
        Arrays.sort(a);
        int[] res = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            int idx = Arrays.binarySearch(a, b[i]);
            if (idx < 0) {
                idx = -(idx + 1);
                if (idx >= a.length || idx > 0 && b[i] - a[idx - 1] <= a[idx] - b[i]) {
                    idx--;
                }
            }
            res[i] = a[idx];
        }
        return res;
    }
}
