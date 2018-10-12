/*
 * [29] Divide Two Integers
 *
 * https://leetcode.com/problems/divide-two-integers/description/
 *
 * algorithms
 * Medium (15.72%)
 * Total Accepted:    154.9K
 * Total Submissions: 985.5K
 * Testcase Example:  '10\n3'
 *
 * Given two integers dividend and divisor, divide two integers without using
 * multiplication, division and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * 
 * Example 1:
 * 
 * 
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * 
 * Example 2:
 * 
 * 
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * 
 * Note:
 * 
 * 
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of
 * this problem, assume that your function returns 231 − 1 when the division
 * result overflows.
 * 
 * 
 */
class Solution {
    public int divide(int dividend, int divisor) {
        boolean sign = !(dividend < 0 ^ divisor < 0);
        long dd = Math.abs((long) dividend);
        long dv = Math.abs((long) divisor);
        long res = (sign ? 1 : -1) * helper(dd, dv);
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) res;
    }

    public long helper(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        long d = divisor;
        long res = 1;
        while ((d << 1) < dividend) {
            d <<= 1;
            res <<= 1;
        }
        return res + helper(dividend - d, divisor);
    }
}
