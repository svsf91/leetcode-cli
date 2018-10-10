/*
 * [207] Course Schedule
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (35.02%)
 * Total Accepted:    153.2K
 * Total Submissions: 437.5K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * Example 1:
 * 
 * 
 * Input: 2, [[1,0]] 
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2:
 * 
 * 
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0, and to take course 0 you
 * should
 * also have finished course 1. So it is impossible.
 * 
 * 
 * Note:
 * 
 * 
 * The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input
 * prerequisites.
 * 
 * 
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacency = new HashMap<>();
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            adjacency.putIfAbsent(from, new ArrayList<>());
            adjacency.get(from).add(to);
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i)) {
                if (!dfs(i, adjacency, visited, new HashSet<>())) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int start, Map<Integer, List<Integer>> adjacency, Set<Integer> visited, Set<Integer> visiting) {
        visiting.add(start);
        boolean res = true;
        if (adjacency.containsKey(start)) {
            for (int next : adjacency.get(start)) {
                if (visited.contains(next)) {
                    continue;
                } else if (visiting.contains(next)) {
                    res = false;
                    break;
                }
                if (!dfs(next, adjacency, visited, visiting)) {
                    res = false;
                    break;
                }
            }
        }
        visited.add(start);
        return res;
    }
}
