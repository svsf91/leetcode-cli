/*
 * [1626] Salary Adjustment
 *
 * https://www.lintcode.com/problem/salary-adjustment/description
 *
 * lintcode
 * Medium (48.00%)
 * Total Accepted:    210
 * Total Submissions: 444
 * Testcase Example:  '[1,2,3,4,5,6,7,8]\n42'
 *
 * Given a list of salaries, find out a `cap` to make the adjusted salary
 * totals or larger then to `target`. `cap` is defined as: the current salary
 * is smaller than `cap`, then `cap` is used as the new salary, otherwise Keep
 * the original salary
 */
public class Solution {
    /**
     * @param a: the list of salary
     * @param target: the target of the sum
     * @return: the cap it should be
     */
    public int getCap(int[] a, int target) {
        // Write your code here.
        int lower = 0;
        int higher = target / a.length;
        while (lower <= higher) {
            int mid = lower + (higher - lower) / 2;
            if (isLarger(a, target, mid)) {
                higher = mid - 1;
            } else {
                lower = mid + 1;
            }
        }
        return lower;
    }

    public boolean isLarger(int[] a, int target, int cap) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < cap) {
                count += cap;
            } else {
                count += a[i];
            }
        }
        return count >= target;
    }
}
