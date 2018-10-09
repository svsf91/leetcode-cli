import java.util.Collections;

/*
 * [885] Exam Room
 *
 * https://leetcode.com/problems/exam-room/description/
 *
 * algorithms
 * Medium (32.25%)
 * Total Accepted:    5.3K
 * Total Submissions: 16.3K
 * Testcase Example:  '["ExamRoom","seat","seat","seat","seat","leave","seat"]\n[[10],[],[],[],[],[4],[]]'
 *
 * In an exam room, there are N seats in a single row, numbered 0, 1, 2, ...,
 * N-1.
 * 
 * When a student enters the room, they must sit in the seat that maximizes the
 * distance to the closest person.  If there are multiple such seats, they sit
 * in the seat with the lowest number.  (Also, if no one is in the room, then
 * the student sits at seat number 0.)
 * 
 * Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat()
 * returning an int representing what seat the student sat in, and
 * ExamRoom.leave(int p) representing that the student in seat number p now
 * leaves the room.  It is guaranteed that any calls to ExamRoom.leave(p) have
 * a student sitting in seat p.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"],
 * [[10],[],[],[],[],[4],[]]
 * Output: [null,0,9,4,2,null,5]
 * Explanation:
 * ExamRoom(10) -> null
 * seat() -> 0, no one is in the room, then the student sits at seat number 0.
 * seat() -> 9, the student sits at the last seat number 9.
 * seat() -> 4, the student sits at the last seat number 4.
 * seat() -> 2, the student sits at the last seat number 2.
 * leave(4) -> null
 * seat() -> 5, the student​​​​​​​ sits at the last seat number 5.
 * 
 * 
 * ​​​​​​​
 * 
 * Note:
 * 
 * 
 * 1 <= N <= 10^9
 * ExamRoom.seat() and ExamRoom.leave() will be called at most 10^4 times
 * across all test cases.
 * Calls to ExamRoom.leave(p) are guaranteed to have a student currently
 * sitting in seat number p.
 * 
 */
class ExamRoom {

    List<Integer> occupied;
    int N;

    public ExamRoom(int N) {
        this.occupied = new ArrayList<>();
        this.N = N;
    }

    public int seat() {
        int last = -1;
        int cur = -1;
        int[] pos = new int[2];
        for (int i = 0; i < occupied.size(); i++) {
            cur = occupied.get(i);
            if (last == -1) {
                if (cur > pos[0]) {
                    pos[0] = cur;
                    pos[1] = 0;
                }
            } else {
                if ((cur - last) / 2 > pos[0]) {
                    pos[0] = (cur - last) / 2;
                    pos[1] = (last + cur) / 2;
                }
            }
            last = cur;
        }
        if (occupied.size() == 0) {
            pos[0] = N - 1 - last;
            pos[1] = 0;
        } else if (N - 1 - last > pos[0]) {
            pos[0] = last;
            pos[1] = N - 1;
        }
        int idx = Collections.binarySearch(occupied, pos[1]);
        if (idx < 0)
            idx = -(idx + 1);
        occupied.add(idx, pos[1]);
        return pos[1];
    }

    public void leave(int p) {
        occupied.remove((Integer) p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such: ExamRoom obj =
 * new ExamRoom(N); int param_1 = obj.seat(); obj.leave(p);
 */
