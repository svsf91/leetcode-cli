/*
 * [775] N-ary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (61.12%)
 * Total Accepted:    10.3K
 * Total Submissions: 16.8K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * 
 * 
 * For example, given a 3-ary tree:
 * 
 * 
 * 
 * 
 * Return its preorder traversal as: [1,3,5,6,2,4].
 * 
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Deque<Node> dq = new LinkedList<>();
        Deque<Integer> index = new LinkedList<>();
        Deque<Boolean> state = new LinkedList<>();
        int idx = 0;
        boolean st = false;

        while(!dq.isEmpty() || root != null) {
            if(root != null) {
                if(!st) {
                    list.add(root.val);
                }
                if(idx < root.children.size()) {
                    dq.push(root);
                    index.push(idx);
                    state.push(true);
                    root = root.children.get(idx);
                    st = false;
                    idx = 0;
                } else {
                    root = null;
                }
            } else {
                root = dq.pop();
                idx = index.pop();
                st = state.pop();
                idx++;
            }
        }
        return list;
    }
    // public void helper(Node root, List<Integer> list) {
    //     if(root != null) {
    //         return;
    //     }
    //     list.add(root.val);
    //     for(Node child: root.children) {
    //         helper(child, list);
    //     }
    // }
}
