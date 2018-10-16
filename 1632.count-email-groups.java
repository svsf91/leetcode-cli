import java.util.Map;

/*
 * [1632] Count email groups
 *
 * https://www.lintcode.com/problem/count-email-groups/description
 *
 * lintcode
 * Easy (39.00%)
 * Total Accepted:    276
 * Total Submissions: 703
 * Testcase Example:  '["ab.cd+cd@jiu.zhang.com", "ab.cd+cd@jiuzhang.com", "ab+cd.cd@jiuzhang.com"]'
 *
 * Give you an array of n email addresses.
 * Find the number of email groups and each group should have more than one
 * email address(the address can be duplicated). If two strings have the same
 * value after being transformed, they are in the same group.
 * 
 * The rules of transforming are as follows:
 * 1. Ignore all the characters '.' before the character '@'.
 * 2. Ignore the substring which starts with the first '+'(included) and ends
 * with the character '@'(exclude).
 */
public class Solution {
    /**
     * @param emails: Original email
     * @return: Return the count of groups which has more than one email address in
     *          it.
     */
    public int countGroups(List<String> emails) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for (String email : emails) {
            String transformed = transform(email);
            map.put(transformed, map.getOrDefault(transformed, 0) + 1);
            if (map.get(transformed) == 2) {
                res++;
            }
        }
        // System.out.println(set);
        return res;
    }

    public String transform(String email) {
        boolean at = false;
        boolean plus = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (c == '@') {
                at = true;
                plus = false;
            } else if (c == '.' && !at) {
                continue;
            } else if (c == '+' && !at) {
                plus = true;
                continue;
            } else if (plus) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
