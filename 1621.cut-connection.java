/*
 * [1621] Cut  Connection
 *
 * https://www.lintcode.com/problem/cut-connection/description
 *
 * lintcode
 * Easy (57.00%)
 * Total Accepted:    159
 * Total Submissions: 274
 * Testcase Example:  '[[1,1,1,1,1],[0,0,1,0,1],[0,0,1,0,1],[0,0,1,0,0]]\n1\n2'
 *
 * Given a matrix consists of 0 and 1, the first line is the roof.
 * Remove one of `'1'`, the same column of the '1' that is not connected to the
 * roof will drop and need to be set to `'0'`.
 */
public class Solution {
    /**
     * @param matrix:
     * @param x:
     * @param y:
     * @return: return the matrix
     */
    public int[][] removeOne(int[][] matrix, int x, int y) {
        // Write your code here
        for (int i = x; i < matrix.length; i++) {
            matrix[i][y] = 0;
        }
        return matrix;
    }
}
