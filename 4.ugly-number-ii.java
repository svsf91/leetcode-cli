import java.util.TreeSet;

/*
 * [4] Ugly Number II
 *
 * https://www.lintcode.com/problem/ugly-number-ii/description
 *
 * lintcode
 * Medium (25.00%)
 * Total Accepted:    20545
 * Total Submissions: 81940
 * Testcase Example:  '9\n'
 *
 * Ugly number is a number that only have factors `2`, `3` and `5`. 
 * 
 * Design an algorithm to find the *n*th ugly number. The first 10 ugly numbers
 * are `1, 2, 3, 4, 5, 6, 8, 9, 10, 12...`
 */
public class Solution {
    /**
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        int[] nums = { 2, 3, 5 };
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        long cur = 1;
        for (int i = 0; i < n; i++) {
            cur = set.pollFirst();
            for (int num : nums) {
                if (cur * num > Integer.MAX_VALUE) {
                    break;
                }
                set.add(num * (int) cur);
            }
        }
        return (int) cur;
    }
}
