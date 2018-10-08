/*
 * [912] Random Pick with Weight
 *
 * https://leetcode.com/problems/random-pick-with-weight/description/
 *
 * algorithms
 * Medium (41.35%)
 * Total Accepted:    4.4K
 * Total Submissions: 10.6K
 * Testcase Example:  '["Solution", "pickIndex"]\n[[[1]], []]'
 *
 * Given an array w of positive integers, where w[i] describes the weight of
 * index i, write a function pickIndex which randomly picks an index in
 * proportion to its weight.
 * 
 * Note:
 * 
 * 
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 * 
 * 
 * Explanation of Input Syntax:
 * 
 * The input is two lists: the subroutines called and their arguments.
 * Solution's constructor has one argument, the array w. pickIndex has no
 * arguments. Arguments are always wrapped with a list, even if there aren't
 * any.
 * 
 */
class Solution {
    int[] prefix;
    Random random;
    int bound;
    public Solution(int[] w) {
        prefix = new int[w.length];
        for(int i = 0; i < w.length; i++) {
            prefix[i] = (i > 0 ? prefix[i - 1] : 0) + w[i];
        }
        bound = prefix[prefix.length - 1];
        random = new Random();
    }
    
    public int pickIndex() {
        int r = random.nextInt(bound);
        int i = Arrays.binarySearch(prefix, r);
        if(i < 0) i = -(i + 1) - 1;
        return i + 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
