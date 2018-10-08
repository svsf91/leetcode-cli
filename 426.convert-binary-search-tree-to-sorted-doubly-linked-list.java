/*
 * [758] Convert Binary Search Tree to Sorted Doubly Linked List
 *
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/
 *
 * algorithms
 * Medium (39.09%)
 * Total Accepted:    7.1K
 * Total Submissions: 18.2K
 * Testcase Example:  '{"$id":"1","val":4,"left":{"$id":"2","val":2,"left":{"$id":"4","val":1,"left":null,"right":null},"right":{"$id":"5","val":3,"left":null,"right":null}},"right":{"$id":"3","val":5,"left":null,"right":null}}'
 *
 * Convert a BST to a sorted circular doubly-linked list in-place. Think of the
 * left and right pointers as synonymous to the previous and next pointers in a
 * doubly-linked list.
 * 
 * Let's take the following BST as an example, it may help you understand the
 * problem better:
 * 
 * 
 * 
 * 
 * 
 * We want to transform this BST into a circular doubly linked list. Each node
 * in a doubly linked list has a predecessor and successor. For a circular
 * doubly linked list, the predecessor of the first element is the last
 * element, and the successor of the last element is the first element.
 * 
 * The figure below shows the circular doubly linked list for the BST above.
 * The "head" symbol means the node it points to is the smallest element of the
 * linked list.
 * 
 * 
 * 
 * 
 * 
 * Specifically, we want to do the transformation in place. After the
 * transformation, the left pointer of the tree node should point to its
 * predecessor, and the right pointer should point to its successor. We should
 * return the pointer to the first element of the linked list.
 * 
 * The figure below shows the transformed BST. The solid line indicates the
 * successor relationship, while the dashed line means the predecessor
 * relationship.
 * 
 * 
 * 
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return root;
        }
        Deque<Node> dq = new LinkedList<>();
        Node new_root = null;
        Node pre = null;
        while(!dq.isEmpty() || root != null) {
            if(root != null) {
                dq.push(root);
                root = root.left;
            } else {
                root = dq.pop();
                if(pre != null) {
                    pre.right = root;
                    root.left = pre;
                } else {
                    new_root = root;
                }
                pre = root;
                root = root.right;
            }
        }
        new_root.left = pre;
        pre.right = new_root;
        return new_root;
    }
}
