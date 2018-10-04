/*
 * [31] Next Permutation
 *
 * https://leetcode.com/problems/next-permutation/description/
 *
 * algorithms
 * Medium (29.28%)
 * Total Accepted:    177.8K
 * Total Submissions: 607.4K
 * Testcase Example:  '[1,2,3]'
 *
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 */
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len == 0) {
            return;
        }
        int i = len - 2;
        for(; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                break;
            }
        }
        if(i >= 0) {
            int larger = binarySearch(nums, i);
            swap(nums, i, larger);
        }
        reverse(nums, i + 1, nums.length - 1);
    }
    public int binarySearch(int[] nums, int i) {
        int target = nums[i];
        int l = i + 1, r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] <= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
