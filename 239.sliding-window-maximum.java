/*
 * [239] Sliding Window Maximum
 *
 * https://leetcode.com/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (35.41%)
 * Total Accepted:    109.6K
 * Total Submissions: 309.7K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * Given an array nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one
 * position. Return the max sliding window.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7] 
 * Explanation: 
 * 
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty
 * array.
 * 
 * Follow up:
 * Could you solve it in linear time?
 * 
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length < k || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<int[]> dq = new LinkedList<>();

        for(int i = 0; i < k - 1; i++) {
            while(!dq.isEmpty() && nums[i] >= dq.peekLast()[0]) {
                dq.pollLast();
            }
            dq.offerLast(new int[]{nums[i], i});
        }

        for(int i = k - 1; i < nums.length; i++) {
            if(!dq.isEmpty() && dq.peekFirst()[1] < i - k + 1) {
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[i] >= dq.peekLast()[0]) {
                dq.pollLast();
            }
            dq.offerLast(new int[]{nums[i], i});
            res[i - k + 1] = dq.peekFirst()[0];
        }

        return res;
    }
}
