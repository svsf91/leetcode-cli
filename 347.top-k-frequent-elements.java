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
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> num2Freq = new HashMap<>();
        for(int n : nums) {
            num2Freq.put(n, num2Freq.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int n: num2Freq.keySet()) {
            pq.offer(new int[]{n, num2Freq.get(n)});
            if(pq.size() > k) {
                pq.poll();
            }
        }
        while(!pq.isEmpty()) {
            list.add(pq.poll()[0]);
        }
        return list;
    }
}
