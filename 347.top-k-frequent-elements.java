/*
 * [347] Top K Frequent Elements
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (50.98%)
 * Total Accepted:    134.5K
 * Total Submissions: 263.8K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * 
 * Note: 
 * 
 * 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 * 
 * 
 */
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> num2Freq = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            num2Freq.put(nums[i], num2Freq.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length + 1];
        for(int n: num2Freq.keySet()) {
            int freq = num2Freq.get(n);
            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(n);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = nums.length; i >= 0; i--) {
            if(bucket[i] != null) {
                for(int n : bucket[i]) {
                    if(k-- > 0) {
                        res.add(n);
                    }
                }        
            }
        }
        return res;
    }
}
