/*
 * [867] New 21 Game
 *
 * https://leetcode.com/problems/new-21-game/description/
 *
 * algorithms
 * Medium (26.07%)
 * Total Accepted:    3.2K
 * Total Submissions: 12.3K
 * Testcase Example:  '10\n1\n10'
 *
 * Alice plays the following game, loosely based on the card game "21".
 * 
 * Alice starts with 0 points, and draws numbers while she has less than K
 * points.  During each draw, she gains an integer number of points randomly
 * from the range [1, W], where W is an integer.  Each draw is independent and
 * the outcomes have equal probabilities.
 * 
 * Alice stops drawing numbers when she gets K or more points.  What is the
 * probability that she has N or less points?
 * 
 * Example 1:
 * 
 * 
 * Input: N = 10, K = 1, W = 10
 * Output: 1.00000
 * Explanation:  Alice gets a single card, then stops.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: N = 6, K = 1, W = 10
 * Output: 0.60000
 * Explanation:  Alice gets a single card, then stops.
 * In 6 out of W = 10 possibilities, she is at or below N = 6 points.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: N = 21, K = 17, W = 10
 * Output: 0.73278
 * 
 * Note:
 * 
 * 
 * 0 <= K <= N <= 10000
 * 1 <= W <= 10000
 * Answers will be accepted as correct if they are within 10^-5 of the correct
 * answer.
 * The judging time limit has been reduced for this question.
 * 
 */
class Solution {
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[N + 1];
        dp[0] = 1;
        double res = 0.0;
        double sum = 0.0;
        for(int i = 1; i <= N; i++) {
            if(i - 1 < K) {
                sum += dp[i - 1];
            }
            if(i > W) {
                sum -= dp[i - W - 1];
            }
            dp[i] = sum / W;
            if(i >= K) {
                res += dp[i];
            }
        }
        if(K == 0) {
            res += 1;
        }
        // System.out.println(Arrays.toString(dp))
        return res;
    }
}
