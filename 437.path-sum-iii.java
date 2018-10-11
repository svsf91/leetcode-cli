/*
 * [437] Path Sum III
 *
 * https://leetcode.com/problems/path-sum-iii/description/
 *
 * algorithms
 * Easy (40.54%)
 * Total Accepted:    75K
 * Total Submissions: 184.9K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * You are given a binary tree in which each node contains an integer value.
 * 
 * Find the number of paths that sum to a given value.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards
 * (traveling only from parent nodes to child nodes).
 * 
 * The tree has no more than 1,000 nodes and the values are in the range
 * -1,000,000 to 1,000,000.
 * 
 * Example:
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * ⁠     10
 * ⁠    /  \
 * ⁠   5   -3
 * ⁠  / \    \
 * ⁠ 3   2   11
 * ⁠/ \   \
 * 3  -2   1
 * 
 * Return 3. The paths that sum to 8 are:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, sum, 0, map);
    }

    public int helper(TreeNode root, int sum, int cur, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        cur += root.val;
        if (map.containsKey(cur - sum)) {
            count += map.get(cur - sum);
        }
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        count += helper(root.left, sum, cur, map);
        count += helper(root.right, sum, cur, map);
        map.put(cur, map.getOrDefault(cur, 0) - 1);
        cur -= root.val;
        return count;
    }
}
