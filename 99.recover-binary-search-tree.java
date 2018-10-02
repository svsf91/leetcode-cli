/*
 * [99] Recover Binary Search Tree
 *
 * https://leetcode.com/problems/recover-binary-search-tree/description/
 *
 * algorithms
 * Hard (32.40%)
 * Total Accepted:    99.2K
 * Total Submissions: 306.3K
 * Testcase Example:  '[1,3,null,null,2]'
 *
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,3,null,null,2]
 * 
 * 1
 * /
 * 3
 * \
 * 2
 * 
 * Output: [3,1,null,null,2]
 * 
 * 3
 * /
 * 1
 * \
 * 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [3,1,4,null,null,2]
 * 
 * ⁠ 3
 * ⁠/ \
 * 1   4
 * /
 * 2
 * 
 * Output: [2,1,4,null,null,3]
 * 
 * ⁠ 2
 * ⁠/ \
 * 1   4
 * /
 * ⁠ 3
 * 
 * 
 * Follow up:
 * 
 * 
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> dq = new LinkedList<>();
        TreeNode pre = null;
        List<TreeNode> list = new ArrayList<>();
        List<Integer> val = new ArrayList<>();
        while(!dq.isEmpty() || root != null) {
            if(root != null) {
                dq.push(root);
                root = root.left;
            } else {
                root = dq.pop();
                if(pre != null) {
                    if(pre.val >= root.val) {
                        list.add(pre);
                        list.add(root);
                        val.add(pre.val);
                        val.add(root.val);
                    }
                }
                pre = root;
                root = root.right;
            }
        }
        Collections.sort(val);
        for(int i = 0; i < list.size(); i++) {
            list.get(i).val = val.get(i);
        }
    }
    public void swap(TreeNode t1, TreeNode t2) {
        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }
}
