/*
 * [346] Moving Average from Data Stream
 *
 * https://leetcode.com/problems/moving-average-from-data-stream/description/
 *
 * algorithms
 * Easy (62.31%)
 * Total Accepted:    52.2K
 * Total Submissions: 83.8K
 * Testcase Example:  '["MovingAverage","next","next","next","next"]\n[[3],[1],[10],[3],[5]]'
 *
 * Given a stream of integers and a window size, calculate the moving average
 * of all integers in the sliding window.
 * 
 * Example:
 * 
 * 
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * 
 * 
 * 
 * 
 */
class MovingAverage {

    /** Initialize your data structure here. */
    int size;
    int sum;
    Queue<Integer> queue;
    public MovingAverage(int size) {
        this.size = size;
        this.sum = 0;
        this.queue = new LinkedList<>();
    }
    
    public double next(int val) {
        queue.offer(val);
        sum += val;
        if(queue.size() > size) {
            sum -= queue.poll();
        }
        return (double)sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
