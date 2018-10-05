/*
 * [480] Sliding Window Median
 *
 * https://leetcode.com/problems/sliding-window-median/description/
 *
 * algorithms
 * Hard (30.68%)
 * Total Accepted:    17.2K
 * Total Submissions: 56.2K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * Median is the middle value in an ordered integer list. If the size of the
 * list is even, there is no middle value. So the median is the mean of the two
 * middle value.
 * Examples: 
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5 
 * 
 * Given an array nums, there is a sliding window of size k which is moving
 * from the very left of the array to the very right. You can only see the k
 * numbers in the window. Each time the sliding window moves right by one
 * position. Your job is to output the median array for each window in the
 * original array.
 * 
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * 
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * ⁠1 [3  -1  -3] 5  3  6  7       -1
 * ⁠1  3 [-1  -3  5] 3  6  7       -1
 * ⁠1  3  -1 [-3  5  3] 6  7       3
 * ⁠1  3  -1  -3 [5  3  6] 7       5
 * ⁠1  3  -1  -3  5 [3  6  7]      6
 * 
 * 
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 * 
 * Note: 
 * You may assume k is always valid, ie: k is always smaller than input array's
 * size for non-empty array.
 */
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int l = -1, r = 0;
        List<Integer> list = new ArrayList<>();
        double[] res = new double[nums.length - k + 1];
        while(r < k - 1) {
            list.add(nums[r++]);
        }
        Collections.sort(list);
        while(r < nums.length) {
            if(r >= k) {
                int toDel = Collections.binarySearch(list, nums[r - k]);
                list.remove(toDel);
            }
            int toInsert = Collections.binarySearch(list, nums[r]);
            if(toInsert < 0) toInsert = -(toInsert + 1);
            list.add(toInsert, nums[r]);
            // System.out.println(list);
            if(k % 2 == 0) {
                res[r - k + 1] = list.get(list.size() / 2 - 1) / 2.0 + list.get(list.size() / 2) / 2.0;
            } else {
                res[r - k + 1] = list.get(list.size() / 2);
            }
            r++;
        }
        return res;
    }
}
