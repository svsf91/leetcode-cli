/*
 * [666] Path Sum IV
 *
 * https://leetcode.com/problems/path-sum-iv/description/
 *
 * algorithms
 * Medium (51.14%)
 * Total Accepted:    6.2K
 * Total Submissions: 12.1K
 * Testcase Example:  '[113,215,221]'
 *
 * 
 * If the depth of a tree is smaller than 5, then this tree can be represented
 * by a list of three-digits integers.
 * 
 * 
 * 
 * For each integer in this list:
 * 
 * The hundreds digit represents the depth D of this node, 1 
 * The tens digit represents the position P of this node in the level it
 * belongs to, 1 . The position is the same as that in a full binary tree. 
 * The units digit represents the value V of this node, 0 
 * 
 * 
 * 
 * 
 * Given a list of ascending three-digits integers representing a binary with
 * the depth smaller than 5. You need to return the sum of all paths from the
 * root towards the leaves.
 * 
 * 
 * Example 1:
 * 
 * Input: [113, 215, 221]
 * Output: 12
 * Explanation: 
 * The tree that the list represents is:
 * ⁠   3
 * ⁠  / \
 * ⁠ 5   1
 * 
 * The path sum is (3 + 5) + (3 + 1) = 12.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: [113, 221]
 * Output: 4
 * Explanation: 
 * The tree that the list represents is: 
 * ⁠   3
 * ⁠    \
 * ⁠     1
 * 
 * The path sum is (3 + 1) = 4.
 * 
 * 
 */
class Solution {
    public int pathSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int a = n / 100;
            n %= 100;
            int b = n / 10;
            int c = n % 10;
            // System.out.println(a + "," + b + "," + c);
            int pos = (1 << (a - 1)) - 1 + b;
            map.put(pos, c);
        }
        // System.out.println(map);
        return helper(map, 1, 0);
    }

    public int helper(Map<Integer, Integer> map, int cur, int sum) {
        if (!map.containsKey(cur)) {
            return 0;
        }
        sum += map.get(cur);
        if (!map.containsKey(cur * 2) && !map.containsKey(cur * 2 + 1)) {
            return sum;
        }
        return helper(map, cur * 2, sum) + helper(map, cur * 2 + 1, sum);
    }
}
