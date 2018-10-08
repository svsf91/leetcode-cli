/*
 * [463] Island Perimeter
 *
 * https://leetcode.com/problems/island-perimeter/description/
 *
 * algorithms
 * Easy (58.69%)
 * Total Accepted:    100.5K
 * Total Submissions: 171.2K
 * Testcase Example:  '[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]'
 *
 * You are given a map in form of a two-dimensional integer grid where 1
 * represents land and 0 represents water. Grid cells are connected
 * horizontally/vertically (not diagonally). The grid is completely surrounded
 * by water, and there is exactly one island (i.e., one or more connected land
 * cells). The island doesn't have "lakes" (water inside that isn't connected
 * to the water around the island). One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100. Determine the
 * perimeter of the island.
 * 
 * Example:
 * 
 * [[0,1,0,0],
 * ⁠[1,1,1,0],
 * ⁠[0,1,0,0],
 * ⁠[1,1,0,0]]
 * 
 * Answer: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 * 
 * 
 * 
 */
class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int adjacent = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    count++;
                    for(int[] dir: dirs) {
                        if(i + dir[0] >= 0 && i + dir[0] < grid.length && j + dir[1] >= 0 && j + dir[1] < grid[0].length && grid[i + dir[0]][j + dir[1]] == 1) {
                            adjacent++;
                        }
                    }
                }
            }
        }
        return 4 * count - adjacent;
    }
}
