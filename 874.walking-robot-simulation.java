/*
 * [906] Walking Robot Simulation
 *
 * https://leetcode.com/problems/walking-robot-simulation/description/
 *
 * algorithms
 * Easy (28.34%)
 * Total Accepted:    4.4K
 * Total Submissions: 15.7K
 * Testcase Example:  '[4,-1,3]\n[]'
 *
 * A robot on an infinite grid starts at point (0, 0) and faces north.  The
 * robot can receive one of three possible types of commands:
 * 
 * 
 * -2: turn left 90 degrees
 * -1: turn right 90 degrees
 * 1 <= x <= 9: move forward x units
 * 
 * 
 * Some of the grid squares are obstacles. 
 * 
 * The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
 * 
 * If the robot would try to move onto them, the robot stays on the previous
 * grid square instead (but still continues following the rest of the route.)
 * 
 * Return the square of the maximum Euclidean distance that the robot will be
 * from the origin.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: commands = [4,-1,3], obstacles = []
 * Output: 25
 * Explanation: robot will go to (3, 4)
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * Output: 65
 * Explanation: robot will be stuck at (1, 4) before turning left and going to
 * (1, 8)
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 0 <= commands.length <= 10000
 * 0 <= obstacles.length <= 10000
 * -30000 <= obstacle[i][0] <= 30000
 * -30000 <= obstacle[i][1] <= 30000
 * The answer is guaranteed to be less than 2 ^ 31.
 * 
 */
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] obstacle: obstacles) {
            map.putIfAbsent(obstacle[0], new HashSet<>());
            map.get(obstacle[0]).add(obstacle[1]);
        }
        int[] pos = {0, 0};
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int maxVal = 0;
        
        for(int command: commands) {
            if(command > 0) {
                while(command-- > 0) {
                    pos[0] += dirs[d][0];
                    pos[1] += dirs[d][1];
                    if(map.containsKey(pos[0]) && map.get(pos[0]).contains(pos[1])) {
                        pos[0] -= dirs[d][0];
                        pos[1] -= dirs[d][1];
                        break;
                    }
                    maxVal = Math.max(maxVal, pos[0] * pos[0] + pos[1] * pos[1]);
                }
            } else if(command == -1) {
                d = (d + 1 + 4) % 4;
            } else if(command == -2) {
                d = (d - 1 + 4) % 4;
            }
        }
        System.out.println(Arrays.toString(pos));
        return maxVal;
    }
}
