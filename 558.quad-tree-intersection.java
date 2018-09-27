/*
 * [773] Quad Tree Intersection
 *
 * https://leetcode.com/problems/quad-tree-intersection/description/
 *
 * algorithms
 * Easy (34.56%)
 * Total Accepted:    1.3K
 * Total Submissions: 3.7K
 * Testcase Example:  '{"$id":"1","bottomLeft":{"$id":"4","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":false},"bottomRight":{"$id":"5","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":false},"isLeaf":false,"topLeft":{"$id":"2","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},"topRight":{"$id":"3","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},"val":true}\n{"$id":"1","bottomLeft":{"$id":"8","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},"bottomRight":{"$id":"9","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":false},"isLeaf":false,"topLeft":{"$id":"2","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},"topRight":{"$id":"3","bottomLeft":{"$id":"6","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},"bottomRight":{"$id":"7","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":true},"isLeaf":false,"topLeft":{"$id":"4","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":false},"topRight":{"$id":"5","bottomLeft":null,"bottomRight":null,"isLeaf":true,"topLeft":null,"topRight":null,"val":false},"val":true},"val":true}'
 *
 * A quadtree is a tree data in which each internal node has exactly four
 * children: topLeft, topRight, bottomLeft and bottomRight. Quad trees are
 * often used to partition a two-dimensional space by recursively subdividing
 * it into four quadrants or regions.
 * 
 * We want to store True/False information in our quad tree. The quad tree is
 * used to represent a N * N boolean grid. For each node, it will be subdivided
 * into four children nodes until the values in the region it represents are
 * all the same. Each node has another two boolean attributes : isLeaf and val.
 * isLeaf is true if and only if the node is a leaf node. The val attribute for
 * a leaf node contains the value of the region it represents.
 * 
 * For example, below are two quad trees A and B:
 * 
 * 
 * A:
 * +-------+-------+   T: true
 * |       |       |   F: false
 * |   T   |   T   |
 * |       |       |
 * +-------+-------+
 * |       |       |
 * |   F   |   F   |
 * |       |       |
 * +-------+-------+
 * topLeft: T
 * topRight: T
 * bottomLeft: F
 * bottomRight: F
 * 
 * B:               
 * +-------+---+---+
 * |       | F | F |
 * |   T   +---+---+
 * |       | T | T |
 * +-------+---+---+
 * |       |       |
 * |   T   |   F   |
 * |       |       |
 * +-------+-------+
 * topLeft: T
 * topRight:
 * ⁠    topLeft: F
 * ⁠    topRight: F
 * ⁠    bottomLeft: T
 * ⁠    bottomRight: T
 * bottomLeft: T
 * bottomRight: F
 * 
 * 
 * 
 * 
 * Your task is to implement a function that will take two quadtrees and return
 * a quadtree that represents the logical OR (or union) of the two trees.
 * 
 * 
 * A:                 B:                 C (A or B):
 * +-------+-------+  +-------+---+---+  +-------+-------+
 * |       |       |  |       | F | F |  |       |       |
 * |   T   |   T   |  |   T   +---+---+  |   T   |   T   |
 * |       |       |  |       | T | T |  |       |       |
 * +-------+-------+  +-------+---+---+  +-------+-------+
 * |       |       |  |       |       |  |       |       |
 * |   F   |   F   |  |   T   |   F   |  |   T   |   F   |
 * |       |       |  |       |       |  |       |       |
 * +-------+-------+  +-------+-------+  +-------+-------+
 * 
 * 
 * Note:
 * 
 * 
 * Both A and B represent grids of size N * N.
 * N is guaranteed to be a power of 2.
 * If you want to know more about the quad tree, you can refer to its wiki.
 * The logic OR operation is defined as this: "A or B" is true if A is true, or
 * if B is true, or if both A and B are true.
 * 
 * 
 */
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if(quadTree1.isLeaf && quadTree2.isLeaf) {
            if(quadTree1.val || quadTree2.val) {
                return new Node(true, true, null, null, null, null);
            } else {
                return new Node(false, true, null, null, null, null);
            }
        }
        Node tl = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.topLeft, quadTree2.isLeaf ? quadTree2 : quadTree2.topLeft);
        Node tr = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.topRight, quadTree2.isLeaf ? quadTree2 : quadTree2.topRight);
        Node bl = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.bottomLeft, quadTree2.isLeaf ? quadTree2 : quadTree2.bottomLeft);
        Node br = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.bottomRight, quadTree2.isLeaf ? quadTree2 : quadTree2.bottomRight);
        if(tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf) {
            if(tl.val && tr.val && bl.val && br.val) {
                return new Node(true, true, null, null, null, null);
            }
            else if(!tl.val && !tr.val && !bl.val && !br.val) {
                return new Node(false, true, null, null, null, null);
            }
        }
        return new Node(false, false, tl, tr, bl, br);
    }
}
