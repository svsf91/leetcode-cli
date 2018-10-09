/*
 * [744] Network Delay Time
 *
 * https://leetcode.com/problems/network-delay-time/description/
 *
 * algorithms
 * Medium (37.52%)
 * Total Accepted:    13.3K
 * Total Submissions: 35.5K
 * Testcase Example:  '[[2,1,1],[2,3,1],[3,4,1]]\n4\n2'
 *
 * 
 * There are N network nodes, labelled 1 to N.
 * 
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node, and w is the time it takes
 * for a signal to travel from source to target.
 * 
 * Now, we send a signal from a certain node K.  How long will it take for all
 * nodes to receive the signal?  If it is impossible, return -1.
 * 
 * 
 * Note:
 * 
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1  and 1 .
 * 
 * 
 */
class Solution {
    class Edge {
        int u;
        int v;
        int w;

        public Edge(int _u, int _v, int _w) {
            u = _u;
            v = _v;
            w = _w;
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<Edge>> edges = new HashMap<>();
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            edges.putIfAbsent(u, new ArrayList<>());
            edges.get(u).add(new Edge(u, v, w));
        }
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> distance[a] - distance[b]);
        pq.offer(K);
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            int d = distance[cur];
            if (!edges.containsKey(cur)) {
                continue;
            }
            for (Edge edge : edges.get(cur)) {
                int v = edge.v;
                int w = edge.w;
                if (d + w < distance[v]) {
                    distance[v] = d + w;
                    pq.offer(v);
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, distance[i]);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
