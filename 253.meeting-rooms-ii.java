/*
 * [253] Meeting Rooms II
 *
 * https://leetcode.com/problems/meeting-rooms-ii/description/
 *
 * algorithms
 * Medium (40.25%)
 * Total Accepted:    91.9K
 * Total Submissions: 228.3K
 * Testcase Example:  '[[0,30],[5,10],[15,20]]'
 *
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * Example 1:
 * 
 * 
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * 
 * Example 2:
 * 
 * 
 * Input: [[7,10],[2,4]]
 * Output: 1
 * 
 */
/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0, j = 0;
        int count = 0;
        while (i < intervals.length) {
            if (start[i] < end[j]) {
                i++;
                count = Math.max(count, i - j);
            } else {
                j++;
            }
        }
        return count;
    }
}
