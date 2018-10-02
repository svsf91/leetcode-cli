/*
 * [852] Friends Of Appropriate Ages
 *
 * https://leetcode.com/problems/friends-of-appropriate-ages/description/
 *
 * algorithms
 * Medium (32.21%)
 * Total Accepted:    8.5K
 * Total Submissions: 26.3K
 * Testcase Example:  '[16,16]'
 *
 * Some people will make friend requests. The list of their ages is given and
 * ages[i] is the age of the ith person. 
 * 
 * Person A will NOT friend request person B (B != A) if any of the following
 * conditions are true:
 * 
 * 
 * age[B] <= 0.5 * age[A] + 7
 * age[B] > age[A]
 * age[B] > 100 && age[A] < 100
 * 
 * 
 * Otherwise, A will friend request B.
 * 
 * Note that if A requests B, B does not necessarily request A.  Also, people
 * will not friend request themselves.
 * 
 * How many total friend requests are made?
 * 
 * Example 1:
 * 
 * 
 * Input: [16,16]
 * Output: 2
 * Explanation: 2 people friend request each other.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [16,17,18]
 * Output: 2
 * Explanation: Friend requests are made 17 -> 16, 18 -> 17.
 * 
 * Example 3:
 * 
 * 
 * Input: [20,30,100,110,120]
 * Output: 
 * Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 ->
 * 100.
 * 
 * 
 * 
 * 
 * Notes:
 * 
 * 
 * 1 <= ages.length <= 20000.
 * 1 <= ages[i] <= 120.
 * 
 */
class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int count = 0;
        for(int i = 0; i < ages.length; i++) {
            if(ages[i] <= 14) {
                continue;
            }
            int r = searchRight(ages, 0, ages.length - 1, ages[i]);
            int l = searchLeft(ages, 0, ages.length - 1, ages[i] / 2 + 7);
            if(l <= r) {
                count += r - l;
            }
        }
        return count;
    }
    public int searchLeft(int[] ages, int left, int right, int lower) {
        int l = left, r = right;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(ages[mid] <= lower) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    public int searchRight(int[] ages, int left, int right, int upper) {
        int l = left, r = right;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(ages[mid] <= upper) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}
