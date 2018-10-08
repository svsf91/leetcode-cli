/*
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (22.13%)
 * Total Accepted:    393K
 * Total Submissions: 1.8M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        for(int i = 0; i < list.size(); i++) {
            List<List<Integer>> tmp = twoSum(list, i + 1, -list.get(i));
            for(List<Integer> l: tmp) {
                l.add(list.get(i));
                res.add(l);
            }
            if(map.get(list.get(i)) >= 3) {
                if(3 * list.get(i) == 0) {
                    res.add(new ArrayList<>(Arrays.asList(list.get(i), list.get(i), list.get(i))));
                }
            } 
            if(map.get(list.get(i)) >= 2) {
                if(map.containsKey(-2 * list.get(i)) && list.get(i) != 0) {
                    res.add(new ArrayList<>(Arrays.asList(list.get(i), list.get(i), -2 * list.get(i))));                         
                }
            }
        }
        return res;
    }
    public List<List<Integer>> twoSum(List<Integer> nums, int start, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = start; i < nums.size(); i++) {
            int num = nums.get(i);
            if(set.contains(target - num)) {
                list.add(new ArrayList<>(Arrays.asList(target - num, num)));
            }
            set.add(num);
        }
        return list;
    }
}
