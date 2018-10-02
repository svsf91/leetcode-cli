/*
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (39.32%)
 * Total Accepted:    203K
 * Total Submissions: 516.3K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
class Solution {
    public int trap(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int count = 0;
        while(l < r) {
            int left = height[l];
            int right = height[r];
            if(left < right) {
                while(l < r && height[l] <= left) {
                    count += left - height[l++];
                }
            } else {
                while(l < r && height[r] <= right) {
                    count += right - height[r--];
                }
            }
        }
        return count;
    }
}
