/*
 * [1627] Word Segmentation
 *
 * https://www.lintcode.com/problem/word-segmentation/description
 *
 * lintcode
 * Medium (48.00%)
 * Total Accepted:    98
 * Total Submissions: 201
 * Testcase Example:  '"aaaa bbb cccc ddd ee ff ggggg"\n8'
 *
 * Given a  long string `S`, only include normal English words, words are
 * separated by a single space, and give you a positive integer. Please divide
 * the string into several lines. Requirement 1: You can only wrap between
 * words. The same word cannot be separated; Requirement 2: Each line cannot be
 * more than one character after the division.
 */
public class Solution {
    /**
     * @param s: the string
     * @param k: the k
     * @return: the answer
     */
    public String[] wordSegmentation(String s, int k) {
        // Write your code here
        if (s == null || s.length() == 0 || k <= 0)
            return new String[0];
        String[] arr = s.split(" ");
        int index = 0;
        int len = arr.length;
        List<String> result = new ArrayList<>();
        String str = "";
        while (index < len) {
            int curLen = 0;
            while (index < len && curLen + arr[index].length() <= k) {
                curLen += arr[index].length() + 1;
                str += arr[index] + " ";
                index++;
            }
            if (str.charAt(str.length() - 1) == ' ')
                result.add(str.substring(0, str.length() - 1));
            else
                result.add(str);
            str = "";
            // index++;
        }
        return result.toArray(new String[result.size()]);
    }
}
