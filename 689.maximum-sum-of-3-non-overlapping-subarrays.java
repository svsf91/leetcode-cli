/*
 * [689] Maximum Sum of 3 Non-Overlapping Subarrays
 *
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/description/
 *
 * algorithms
 * Hard (42.00%)
 * Total Accepted:    17K
 * Total Submissions: 40.5K
 * Testcase Example:  '[1,2,1,2,6,7,5,1]\n2'
 *
 * 
 * In a given array nums of positive integers, find three non-overlapping
 * subarrays with maximum sum.
 * 
 * 
 * Each subarray will be of size k, and we want to maximize the sum of all 3*k
 * entries.
 * 
 * 
 * Return the result as a list of indices representing the starting position of
 * each interval (0-indexed).  If there are multiple answers, return the
 * lexicographically smallest one.
 * 
 * Example:
 * 
 * Input: [1,2,1,2,6,7,5,1], 2
 * Output: [0, 3, 5]
 * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting
 * indices [0, 3, 5].
 * We could have also taken [2, 1], but an answer of [1, 3, 5] would be
 * lexicographically larger.
 * 
 * 
 * 
 * Note:
 * nums.length will be between 1 and 20000.
 * nums[i] will be between 1 and 65535.
 * k will be between 1 and floor(nums.length / 3).
 * 
 */
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[][] dp = new int[3][nums.length];
        int[][] pos = new int[3][nums.length];
        int[] prefix = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(j > 0) {
                    dp[i][j] = dp[i][j - 1];
                    pos[i][j] = pos[i][j - 1];
                }
                int cur = 0;
                if(j >= k - 1)
                    cur = (i > 0 && j > k - 1 ? dp[i - 1][j - k] : 0) + prefix[j + 1] - prefix[j + 1 - k];
                if(cur > dp[i][j]) {
                    dp[i][j] = cur;
                    pos[i][j] = j - k + 1;
                }
            }
        }

        int[] res = new int[3];
        int p = nums.length - 1;
        for(int i = 2; i >= 0; i--) {
            p = pos[i][p];
            res[i] = p;
            p--;
        }
        // System.out.println(Arrays.deepToString(pos));
        return res;
    }
}
