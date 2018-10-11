/*
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (43.12%)
 * Total Accepted:    262.3K
 * Total Submissions: 608.1K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            swap(nums, mid, r);
            int i = l, j = r;
            while (i < j) {
                if (nums[i] < nums[r]) {
                    swap(nums, i, --j);
                } else {
                    i++;
                }
            }
            swap(nums, i, r);
            // System.out.println(Arrays.toString(nums));
            if (i == k - 1) {
                return nums[i];
            } else if (i < k - 1) {
                l = i + 1;
            } else {
                r = i - 1;
            }
        }
        return -1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
